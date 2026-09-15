---
layout: academy
title: Acerca de
search_title: Acerca de CodeLearn Academy
search_description: Información sobre el proyecto, autor, versión, repositorio y commits.
permalink: /about/
---

<main class="cla-main">
<section class="cla-section">
  <div class="cla-container cla-about">
    <h1>Acerca de {{ site.academy.title }}</h1>
    <p>{{ site.academy.tagline }}</p>

    <div class="cla-about-grid">
      <section>
        <h2>Autor</h2>
        <p><strong>{{ site.data.build.author | default: site.author.name }}</strong></p>
        <p>{{ site.author.role }}</p>
        <p><a href="{{ site.author.github }}">GitHub</a></p>
      </section>

      <section>
        <h2>Proyecto</h2>
        <p>Versión: <strong>{{ site.data.build.version }}</strong></p>
        <p>Rama: <strong>{{ site.data.build.branch }}</strong></p>
        <p>Commit: <strong>{{ site.data.build.commit }}</strong></p>
        <p>Fecha: <strong>{{ site.data.build.date }}</strong></p>
        <p><a href="{{ site.academy.repository }}">Repositorio</a></p>
      </section>
    </div>
  </div>
</section>
</main>
