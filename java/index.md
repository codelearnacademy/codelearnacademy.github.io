---
layout: route
route: java
title: Java
search_title: Java
search_description: Ruta Java con fundamentos del lenguaje, POO, buenas prácticas, SQLite y Git.
permalink: /java/
---

{% assign route = site.data.routes.java %}

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-mapa-ruta-java.png" alt="Mapa visual de la ruta de aprendizaje de Java" loading="lazy">
</figure>



## Accesibilidad y formas de trabajo

La ruta combina explicación textual, diagramas con texto alternativo, ejemplos guiados, autoevaluaciones y ejercicios. La información esencial no debe depender únicamente de una imagen, un color o una explicación oral. Las actividades principales incluyen instrucciones escritas, criterios de comprobación y tiempos orientativos.

> Si utilizas ampliación de pantalla, navegación por teclado, lector de pantalla o subtítulos, puedes recorrer la ruta siguiendo los mismos contenidos y actividades.

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

## Cómo trabajar esta ruta

Cada sección combina explicación, diagramas, ejemplos guiados, ejercicios propuestos y una autoevaluación breve. Intenta responder el test antes de desplegar las soluciones y realiza los ejercicios sin copiar el ejemplo anterior.
