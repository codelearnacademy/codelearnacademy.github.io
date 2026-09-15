---
layout: academy
title: Licencias
search_title: Licencias e iconos
search_description: Atribuciones de iconos, logotipos y marcas usadas en CodeLearn Academy.
permalink: /licencias/
---

<main class="cla-main">
<section class="cla-section">
  <div class="cla-container cla-about">
    <h1>Licencias e iconos</h1>
    <p>{{ site.data.licenses.intro }}</p>

    <div class="cla-about-grid">
      {% for source in site.data.licenses.sources %}
      <section>
        <h2>{{ source.name }}</h2>
        <p>Licencia: <strong>{{ source.license }}</strong></p>
        <p><a href="{{ source.url }}">Fuente original</a></p>
        <p>Usado para: {{ source.used_for | join: ', ' }}.</p>
      </section>
      {% endfor %}
    </div>


    <h2>Identidad visual propia</h2>
    <div class="cla-note">
      <strong>{{ site.data.licenses.branding.name }}</strong>
      <p>Los archivos {{ site.data.licenses.branding.used_for | join: ', ' }} pertenecen al proyecto. Licencia: {{ site.data.licenses.branding.license }}.</p>
    </div>

    <h2>Marcas</h2>
    <div class="cla-license-list">
      {% for trademark in site.data.licenses.trademarks %}
      <p><strong>{{ trademark.name }}</strong>: {{ trademark.owner }}</p>
      {% endfor %}
    </div>

    <div class="cla-note">
      <strong>Aviso</strong>
      <p>{{ site.data.licenses.notice }}</p>
    </div>
  </div>
</section>
</main>
