---
layout: route
route: software
title: Software y metodologías
search_title: Software y metodologías
search_description: Ruta sobre desarrollo de software, ciclo de vida, Agile, Scrum, Kanban, requisitos, planificación y calidad.
permalink: /software/
---

{% assign route = site.data.routes.software %}

## Tecnologías y marcos relacionados

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

## Proyecto final

<div class="cla-project-box">
  <strong>Planificación de un producto software</strong>
  <p>Visión, requisitos, historias, criterios de aceptación, Product Backlog, Sprint, Kanban, Definition of Done, riesgos y metodología.</p>
</div>
