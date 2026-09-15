---
layout: academy
title: Inicio
search_title: CodeLearn Academy
search_description: Formación real basada en ejercicios, proyectos y buenas prácticas profesionales.
permalink: /
---

<main class="cla-main">
<section class="cla-home-hero">
  <div class="cla-container cla-home-hero-grid">
    <div>
      <p class="cla-kicker">{{ site.data.branding.name | default: site.academy.title }}</p>
      <h1>{{ site.academy.hero_title }}</h1>
      <p>{{ site.academy.tagline }}</p>
    </div>

  </div>

</section>

<section id="rutas" class="cla-section">
  <div class="cla-container">
    <h2>{{ site.academy.routes_label | default: 'Rutas' }}</h2>
    <div class="cla-route-grid">
      {% for item in site.data.routes %}
        {% assign route = item[1] %}
        {% assign tech = site.data.technologies[route.technology] %}
        {% if route.status == 'published' %}
          <a class="cla-route-card" href="{{ route.url | relative_url }}">
        {% else %}
          <div class="cla-route-card is-disabled">
        {% endif %}
          <img src="{{ tech.icon | relative_url }}" alt="{{ tech.name }}" width="38" height="38" loading="lazy">
          <div>
            <h3>{{ route.title }}</h3>
            <span>{{ route.level }}</span>
          </div>
          <p>{{ route.description }}</p>
          {% if route.status == 'published' %}
            <strong>Comenzar →</strong>
          </a>
          {% else %}
            <strong>Próximamente</strong>
          </div>
          {% endif %}
      {% endfor %}
    </div>
  </div>
</section>

<section class="cla-section cla-soft">
  <div class="cla-container">
    <h2>Qué encontrarás</h2>
    <div class="cla-feature-grid">
      {% for feature in site.data.features %}
      <div>
        <strong>{{ feature.title }}</strong>
        <p>{{ feature.description }}</p>
      </div>
      {% endfor %}
    </div>
  </div>
</section>
</main>
