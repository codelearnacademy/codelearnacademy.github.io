---
layout: route
route: spring
title: Spring
search_title: Spring y Spring Boot
search_description: Ruta Spring con IoC, Dependency Injection, Spring Boot, MVC, Tomcat, PostgreSQL, testing, Docker y CI/CD.
permalink: /spring/
---

{% assign route = site.data.routes.spring %}

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
