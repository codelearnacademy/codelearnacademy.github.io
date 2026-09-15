---
layout: route
route: maven
title: Maven
search_title: Maven
search_description: Ruta Maven con dependencias, ciclo de vida, testing, Git e integración continua.
permalink: /maven/
---

{% assign route = site.data.routes.maven %}

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

</div>
