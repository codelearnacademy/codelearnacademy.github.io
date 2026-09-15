---
layout: route
route: testing
title: Testing
search_title: Testing y calidad en Java
search_description: Ruta Java 21 con JUnit, Mockito, Surefire, Failsafe, JaCoCo, cobertura, complejidad, Testcontainers y CI.
permalink: /testing/
---

{% assign route = site.data.routes.testing %}

## Qué aprenderás

La ruta convierte el testing en parte del build: unit tests con Surefire, integration tests con Failsafe, cobertura y complejidad con JaCoCo, PostgreSQL con Testcontainers y quality gates ejecutados con `mvn clean verify`.

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
