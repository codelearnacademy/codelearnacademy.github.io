---
layout: route
route: ficheros
title: Ficheros
search_title: Ficheros y formatos de datos en Java
search_description: Ruta Java para trabajar con properties, CSV, JSON y XML usando Files, Apache Commons CSV y Jackson.
permalink: /ficheros/
---

{% assign route = site.data.routes.ficheros %}

## Tecnologías utilizadas

<div class="cla-tech-grid">
{% for tech_key in route.technologies %}
  {% assign tech = site.data.technologies[tech_key] %}
  <div class="cla-tech-card">
    <img src="{{ tech.icon | relative_url }}" alt="{{ tech.name }}" width="42" height="42" loading="lazy">
    <strong>{{ tech.name }}</strong>
    <span>{{ tech.description }}</span>
  </div>
{% endfor %}
</div>
