---
layout: route
route: docker
title: Docker
search_title: Docker
search_description: Ruta Docker con contenedores, imágenes, redes, volúmenes, Compose y CI/CD para Java, Spring, Angular y PostgreSQL.
permalink: /docker/
---

{% assign route = site.data.routes.docker %}


## Qué aprenderás

La ruta comienza por el problema de los entornos no reproducibles y avanza hasta construir y desplegar una aplicación completa formada por Angular, Spring/Tomcat y PostgreSQL.

<div class="cla-note">
  <strong>Objetivo</strong>
  <p>Al finalizar, deberías poder clonar un repositorio, construir sus imágenes, levantar todo el entorno con Docker Compose y entender cómo un pipeline CI/CD publica y despliega versiones reproducibles.</p>
</div>

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

r %}
</div>
