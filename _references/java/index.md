---
layout: academy
title: Referencias reutilizables de Java
search_title: Referencias reutilizables de Java
search_description: Referencias breves de Java para enlazar desde apuntes y ejercicios.
permalink: /referencias/java/
---

<main class="cla-main">
<section class="cla-section">
  <div class="cla-container">
    <div class="cla-breadcrumb">
      <a href="{{ '/' | relative_url }}">Inicio</a>
      <span>›</span>
      <span>Referencias</span>
      <span>›</span>
      <span>Java</span>
    </div>

    <h1>Referencias reutilizables de Java</h1>
    <p class="cla-lead">Piezas breves y estables para consultar desde diferentes apuntes docentes sin repetir explicaciones.</p>

    <div class="cla-lesson-list">
      {% for reference in site.references reversed %}
        {% if reference.url != page.url %}
        <a class="cla-lesson-row" href="{{ reference.url | relative_url }}">
          <strong>{{ reference.title }}</strong>
          <em>›</em>
        </a>
        {% endif %}
      {% endfor %}
    </div>
  </div>
</section>
</main>
