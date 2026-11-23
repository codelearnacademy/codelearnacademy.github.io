---
layout: route
route: spring
title: Spring
search_title: Spring y Spring Boot
search_description: Spring Framework y Spring Boot con JDK 21, inyección de dependencias, API REST con Swagger UI, acceso a datos, pruebas y despliegue.
permalink: /spring/
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

{% assign route = site.data.routes.spring %}

<div class="cla-lesson-nav"><a href='{{ "/spring/infografias/" | relative_url }}'>Ver la galería de infografías</a> <a href='{{ "/spring/ejemplos/api-tareas.zip" | relative_url }}'>Descargar el ejemplo de tareas</a> <a href='{{ "/spring/leccion108/" | relative_url }}'>Practicar GET, POST, PUT, PATCH y DELETE</a></div>

## Entidades y persistencia con SQLite3

Sigue la [práctica de las lecciones 61–67]({{ '/spring/leccion61/' | relative_url }}) con el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}). Incluye el mapeo JPA, la comprobación de claves foráneas, un rollback y una migración con datos existentes.

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
