---
layout: route
route: orm
title: Persistencia relacional y ORM con Java y SQLite
search_title: Persistencia relacional y ORM con Java y SQLite
search_description: Ruta sobre SQLite, JDBC, JPA, Hibernate, DAO, JPQL y pruebas.
permalink: /orm/
---

{% assign route = site.data.routes.orm %}

{% if route.technologies and route.technologies.size > 0 %}
## Tecnologías y marcos relacionados

<div class="cla-tech-grid">
{% for tech_key in route.technologies %}
  {% assign tech = site.data.technologies[tech_key] %}
  {% if tech %}
  <div class="cla-tech-card">
    <img src="{{ tech.icon | relative_url }}" alt="{{ tech.name }}" width="42" height="42" loading="lazy">
    <strong>{{ tech.name }}</strong>
    <span>{{ tech.description }}</span>
  </div>
  {% endif %}
{% endfor %}
</div>
{% endif %}

## Infografías

<div class="cla-lesson-nav">
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver las 35 infografías</a>
</div>

## Proyecto final

<div class="cla-project-box">
  <strong>PersistenceLab</strong>
  <p>CRUD de Producto y Vehiculo sobre SQLite con JDBC y JPA, repositorios y pruebas automatizadas.</p>
  <a href="{{ '/orm/leccion28/' | relative_url }}">Ver el proyecto final</a>
</div>
