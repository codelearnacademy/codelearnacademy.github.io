"""Actualiza el orden de rutas con las vistas de sus páginas de entrada en GA4."""
import json
import os
from pathlib import Path
from tempfile import NamedTemporaryFile
from urllib.parse import urlsplit

import yaml
from google.analytics.data_v1beta import BetaAnalyticsDataClient
from google.analytics.data_v1beta.types import (
    DateRange, Dimension, Filter, FilterExpression, Metric, RunReportRequest,
)

ROOT = Path(__file__).resolve().parents[1]


def read_yaml(relative):
    return yaml.safe_load((ROOT / relative).read_text(encoding="utf-8"))


def paths_by_route(routes, baseurl):
    paths = {}
    for key, route in routes.items():
        if route["status"] == "published":
            path = baseurl.rstrip("/") + route["url"].rstrip("/")
            for alias in (path, path + "/", path + "/index.html"):
                if alias in paths and paths[alias] != key:
                    raise ValueError(f"Dos rutas comparten la entrada {alias}")
                paths[alias] = key
    return paths


def collect(client, property_id, hostname, paths):
    if not paths:
        return {}
    views = dict.fromkeys(paths.values(), 0)
    # Limita la consulta a las entradas y a sus URL equivalentes.
    expression = FilterExpression(filter=Filter(
        field_name="pagePath", in_list_filter=Filter.InListFilter(
            values=list(paths), case_sensitive=True,
        ),
    ))
    if hostname:
        host_filter = FilterExpression(filter=Filter(
            field_name="hostName", string_filter=Filter.StringFilter(
                match_type=Filter.StringFilter.MatchType.EXACT, value=hostname,
            ),
        ))
        from google.analytics.data_v1beta.types import FilterExpressionList
        expression = FilterExpression(and_group=FilterExpressionList(
            expressions=[expression, host_filter],
        ))
    report = client.run_report(RunReportRequest(
        property=f"properties/{property_id}",
        date_ranges=[DateRange(start_date="30daysAgo", end_date="yesterday")],
        dimensions=[Dimension(name="pagePath")],
        metrics=[Metric(name="screenPageViews")],
        dimension_filter=expression,
        limit=len(paths),
    ))
    for row in report.rows:
        key = paths[row.dimension_values[0].value]
        views[key] += int(row.metric_values[0].value)
    return views


def main():
    property_id = os.environ.get("GA4_PROPERTY_ID", "554904210")
    if not property_id.isascii() or not property_id.isdecimal():
        raise SystemExit("Define GA4_PROPERTY_ID con el ID numérico de la propiedad.")
    routes = read_yaml("_data/routes.yml")
    editorial = read_yaml("_data/catalogo.yml")["editorial"]
    config = read_yaml("_config.yml")
    order = list(dict.fromkeys([*editorial, *routes]))
    paths = paths_by_route(routes, config.get("baseurl") or "")
    hostname = os.environ.get("GA4_HOSTNAME") or urlsplit(config.get("url", "")).hostname
    views = collect(BetaAnalyticsDataClient(), property_id, hostname, paths)
    ranked = sorted((key for key in order if key in views), key=views.__getitem__, reverse=True)
    target = ROOT / "_data/route_visits.json"
    with NamedTemporaryFile(mode="w", encoding="utf-8", dir=target.parent, delete=False) as tmp:
        json.dump({"ranked": ranked, "views": views}, tmp, indent=2)
        tmp.write("\n")
    Path(tmp.name).replace(target)


if __name__ == "__main__":
    main()
