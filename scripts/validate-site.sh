#!/usr/bin/env bash
set -euo pipefail

missing=0

check_file() {
  if [ ! -f "$1" ]; then
    echo "ERROR: no existe $1"
    missing=1
  fi
}

check_file _config.yml
check_file _data/routes.yml
check_file _data/technologies.yml
check_file _data/licenses.yml
check_file _includes/head.html
check_file _includes/header.html
check_file _includes/footer.html
check_file assets/js/search.js
check_file assets/css/academy.css

python3 - <<'PY'
from pathlib import Path
import sys, yaml
errors = []
base = Path('.')
routes = yaml.safe_load(Path('_data/routes.yml').read_text()) or {}
techs = yaml.safe_load(Path('_data/technologies.yml').read_text()) or {}
for key, route in routes.items():
    t = route.get('technology')
    if t not in techs:
        errors.append(f"Ruta {key}: technology '{t}' no existe en _data/technologies.yml")
    for tkey in route.get('technologies', []):
        if tkey not in techs:
            errors.append(f"Ruta {key}: tecnología '{tkey}' no existe")
    for lesson in route.get('lessons', []):
        url = lesson.get('url', '').strip('/')
        if url:
            p = base / url / 'index.md'
            if not p.exists():
                errors.append(f"Ruta {key}: lección sin página {p}")
for key, tech in techs.items():
    icon = tech.get('icon', '').lstrip('/')
    if icon and not (base / icon).exists():
        errors.append(f"Tecnología {key}: icono no existe {icon}")
if errors:
    print('\n'.join('ERROR: ' + e for e in errors))
    sys.exit(1)
print('Validación OK')
PY

exit "$missing"
