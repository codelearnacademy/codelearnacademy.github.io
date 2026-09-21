---
layout: route
route: maven
title: Maven
search_title: Maven
search_description: 21 lecciones principales y 4 ampliaciones con instalación, repositorios, settings, profiles, pruebas, Wrapper y CI.
permalink: /maven/
---

<div class="cla-maven-guide">
  <section class="cla-maven-intro" aria-labelledby="como-seguir-la-ruta">
    <div class="cla-maven-section-heading">
      <span class="cla-maven-eyebrow">Tu punto de partida</span>
      <h2 id="como-seguir-la-ruta">Cómo seguir la ruta</h2>
      <p>Aprende paso a paso y aplica cada concepto en el mismo proyecto.</p>
    </div>
    <dl class="cla-maven-stats">
      <div><dt>Lecciones principales</dt><dd>21</dd></div>
      <div><dt>Ampliaciones opcionales</dt><dd>4</dd></div>
      <div><dt>Proyecto progresivo</dt><dd>1</dd></div>
    </dl>
    <div class="cla-maven-start-grid">
      <section class="cla-maven-card" aria-labelledby="antes-de-empezar">
        <span class="cla-maven-eyebrow">Requisitos</span>
        <h3 id="antes-de-empezar">Antes de empezar</h3>
        <p>Necesitas <strong>conocimientos básicos de Java</strong>. La instalación del JDK y Maven se explica para <strong>Mac, Linux y Windows 10/11</strong>.</p>
        <a class="cla-maven-card-link" href="{{ '/maven/02-instalar-jdk-maven/' | relative_url }}">02 · Preparar el entorno <span aria-hidden="true">→</span></a>
      </section>
      <section class="cla-maven-card cla-maven-project" aria-labelledby="tu-proyecto-durante-la-ruta">
        <span class="cla-maven-eyebrow">Aprender haciendo</span>
        <h3 id="tu-proyecto-durante-la-ruta">Tu proyecto durante la ruta</h3>
        <p>Desde la lección 03 construirás un único proyecto: <code>gestor-tareas</code>.</p>
        <ul>
          <li>Cada lección indica qué archivos crear o modificar y cómo comprobar el resultado.</li>
          <li>Ejecuta los comandos desde la carpeta que contiene <code>pom.xml</code>.</li>
          <li>El primer proyecto fija versiones de plugins para que los ejemplos tengan una base común.</li>
        </ul>
        <a class="cla-maven-card-link" href="{{ '/maven/03-primer-proyecto/' | relative_url }}">03 · Crear el primer proyecto <span aria-hidden="true">→</span></a>
      </section>
    </div>
    <section class="cla-maven-commands" aria-labelledby="que-comando-utilizar">
      <h3 id="que-comando-utilizar">Qué comando utilizar</h3>
      <p>En la <a href="{{ '/maven/17-maven-wrapper/' | relative_url }}">lección 17</a> crearás el Wrapper antes de empezar a utilizarlo.</p>
      <div class="cla-maven-table" role="region" aria-labelledby="que-comando-utilizar" tabindex="0">
        <table>
          <thead><tr><th scope="col">Momento</th><th scope="col">macOS / Linux</th><th scope="col">Windows · PowerShell</th></tr></thead>
          <tbody>
            <tr><th scope="row">Hasta la lección 16</th><td><code>mvn</code></td><td><code>mvn</code></td></tr>
            <tr><th scope="row">Desde la lección 17, con Wrapper</th><td><code>./mvnw</code></td><td><code>.\mvnw.cmd</code></td></tr>
          </tbody>
        </table>
      </div>
    </section>
    <aside class="cla-maven-private" aria-labelledby="repositorios-privados">
      <strong id="repositorios-privados">Prácticas con repositorios privados</strong>
      <p>Necesitas acceso a un servicio real. Las URLs <code>.example</code> son marcadores que debes sustituir por las de tu entorno.</p>
    </aside>
  </section>

  <section class="cla-maven-path" aria-labelledby="recorrido-principal">
    <div class="cla-maven-section-heading">
      <span class="cla-maven-eyebrow">De la primera compilación a la entrega</span>
      <h2 id="recorrido-principal">Recorrido principal</h2>
    </div>
    <ol class="cla-maven-stage-grid">
      <li><span class="cla-maven-range">Lecciones 01–05</span><h3>Preparar y construir</h3><p>Entorno instalado y primer proyecto compilable.</p></li>
      <li><span class="cla-maven-range">Lecciones 06–12</span><h3>Resolver y configurar</h3><p>Dependencias, repositorios, settings y perfiles comprendidos.</p></li>
      <li><span class="cla-maven-range">Lecciones 13–16</span><h3>Probar y distribuir</h3><p>Pruebas ejecutadas y aplicación utilizable fuera del IDE.</p></li>
      <li><span class="cla-maven-range">Lecciones 17–21</span><h3>Automatizar y entregar</h3><p>Wrapper, Git, CI y gestor de tareas verificable.</p></li>
    </ol>
  </section>

  <section class="cla-maven-extras" aria-labelledby="ampliaciones-opcionales">
    <div class="cla-maven-section-heading">
      <span class="cla-maven-eyebrow">Para profundizar</span>
      <h2 id="ampliaciones-opcionales">Ampliaciones opcionales</h2>
      <p>Puedes completar el recorrido principal sin publicar artefactos ni configurar infraestructura corporativa.</p>
    </div>
    <div class="cla-maven-extra-grid">
      <a class="cla-maven-extra-card" href="{{ '/maven/a1-publicar-artefactos/' | relative_url }}"><span class="cla-maven-extra-number">A1</span><h3>Publicar artefactos en un repositorio privado</h3><p>Publicación de releases y snapshots. Necesita permisos de escritura en el servicio.</p><span class="cla-maven-card-link">Ver ampliación <span aria-hidden="true">→</span></span></a>
      <a class="cla-maven-extra-card" href="{{ '/maven/a2-varios-modulos/' | relative_url }}"><span class="cla-maven-extra-number">A2</span><h3>Proyectos con varios módulos</h3><p>Separación del dominio y la consola, agregación e herencia.</p><span class="cla-maven-card-link">Ver ampliación <span aria-hidden="true">→</span></span></a>
      <a class="cla-maven-extra-card" href="{{ '/maven/a3-jar-dependencias/' | relative_url }}"><span class="cla-maven-extra-number">A3</span><h3>Generar un JAR con dependencias</h3><p>Creación y comprobación del artefacto de distribución.</p><span class="cla-maven-card-link">Ver ampliación <span aria-hidden="true">→</span></span></a>
      <a class="cla-maven-extra-card" href="{{ '/maven/a4-comparar-herramientas/' | relative_url }}"><span class="cla-maven-extra-number">A4</span><h3>Maven frente a otras herramientas</h3><p>Comparación de responsabilidades y criterios de elección.</p><span class="cla-maven-card-link">Ver ampliación <span aria-hidden="true">→</span></span></a>
    </div>
  </section>
</div>

## Tecnologías utilizadas

{% assign route = site.data.routes.maven %}
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
