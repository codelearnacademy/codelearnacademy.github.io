---
layout: route
route: java
title: Java
search_title: Java
search_description: Ruta Java con fundamentos del lenguaje, POO, buenas prácticas, SQLite y Git.
permalink: /java/
---

{% assign route = site.data.routes.java %}

## Explorar Java

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion01/' | relative_url }}">Empezar la ruta</a>
  <a href="{{ '/java/infografias/' | relative_url }}">Ver infografías</a>
  <a href="{{ '/java/leccion09/' | relative_url }}">09 · Persistencia y consultas avanzadas</a>
</div>

## Lecciones

<div class="cla-content-map">
  <a href="{{ '/java/leccion01/' | relative_url }}"><span aria-hidden="true">01</span><strong>Introducción a Java</strong></a>
  <a href="{{ '/java/leccion02/' | relative_url }}"><span aria-hidden="true">02</span><strong>Fundamentos de Java</strong></a>
  <a href="{{ '/java/leccion03/' | relative_url }}"><span aria-hidden="true">03</span><strong>Estructuras de control</strong></a>
  <a href="{{ '/java/leccion04/' | relative_url }}"><span aria-hidden="true">04</span><strong>Organización de clases</strong></a>
  <a href="{{ '/java/leccion05/' | relative_url }}"><span aria-hidden="true">05</span><strong>Entrada y salida</strong></a>
  <a href="{{ '/java/leccion06/' | relative_url }}"><span aria-hidden="true">06</span><strong>Colecciones y tipos avanzados</strong></a>
  <a href="{{ '/java/leccion07/' | relative_url }}"><span aria-hidden="true">07</span><strong>Herencia e interfaces</strong></a>
  <a href="{{ '/java/leccion08/' | relative_url }}"><span aria-hidden="true">08</span><strong>Persistencia en Base de Datos</strong></a>
  <a href="{{ '/java/leccion09/' | relative_url }}"><span aria-hidden="true">09</span><strong>Persistencia y consultas avanzadas</strong></a>
</div>

{% if route and route.technologies and site.data.technologies %}
## Tecnologías utilizadas

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

## Cómo trabajar esta ruta

Cada sección combina explicación, diagramas, ejemplos guiados, ejercicios propuestos y una autoevaluación breve. Intenta responder el test antes de desplegar las soluciones y realiza los ejercicios sin copiar el ejemplo anterior.

## Proyectos de aula

<div class="cla-lesson-nav"><a href="{{ '/java/proyectos/' | relative_url }}">Abrir proyectos de aula</a></div>
