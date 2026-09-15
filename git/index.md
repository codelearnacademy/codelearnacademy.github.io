---
layout: route
route: git
title: Git
search_title: Git
search_description: Ruta Git con control de versiones, repositorios locales, ramas, GitHub, GitLab y trabajo colaborativo.
permalink: /git/
---

{% assign route = site.data.routes.git %}

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

## Qué aprenderás

A lo largo de esta ruta aprenderás a utilizar Git desde cero y a trabajar de forma segura y eficiente con repositorios locales y remotos.

Comenzaremos entendiendo qué problema resuelve un sistema de control de versiones y construiremos progresivamente un flujo de trabajo profesional:

- Crear y configurar repositorios Git.
- Comprender el área de trabajo, staging y repositorio.
- Registrar cambios mediante commits.
- Consultar y analizar el historial.
- Comparar modificaciones con `git diff`.
- Utilizar `.gitignore`.
- Recuperar y corregir cambios.
- Trabajar con ramas.
- Fusionar cambios mediante `merge`.
- Resolver conflictos.
- Utilizar repositorios remotos.
- Publicar proyectos en GitHub o GitLab.
- Clonar repositorios existentes.
- Sincronizar cambios con `fetch`, `pull` y `push`.
- Trabajar de forma colaborativa.
- Utilizar Pull Requests y Merge Requests.
- Revisar código.
- Crear etiquetas y versiones.
- Aplicar un flujo de trabajo profesional con Git.

<div class="cla-note">
  <strong>Aprendizaje práctico</strong>
  <p>La ruta está diseñada para trabajar con Git desde el terminal y comprender qué ocurre en cada operación. Los ejemplos guiados se complementan con ejercicios progresivos y un pequeño proyecto colaborativo final.</p>
</div>

## Recorrido de aprendizaje

```text
Control de versiones
        ↓
Repositorio local
        ↓
Working Directory
        ↓
Staging Area
        ↓
Commits e historial
        ↓
Ramas
        ↓
Merge y conflictos
        ↓
Repositorio remoto
        ↓
GitHub / GitLab
        ↓
Trabajo colaborativo
        ↓
Pull / Merge Request
        ↓
Flujo profesional
```