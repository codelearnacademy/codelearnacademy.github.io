---
layout: route
route: java
title: Java
search_title: Java
search_description: Ruta Java con fundamentos del lenguaje, POO, buenas prácticas, SQLite y Git.
permalink: /java/
---

{% assign route = site.data.routes.java %}

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
