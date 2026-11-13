---
layout: lesson
route: software
lesson_id: leccion14
lesson_file: 14-desarrollo-incremental
lesson_number: "14"
title: Desarrollo incremental
description: Entender la construcción mediante incrementos funcionales sucesivos.
permalink: /software/leccion14/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: infografía
    title: Infografía
  - id: explicación-y-ejemplo
    title: Explicación y ejemplo
  - id: práctica
    title: Práctica
  - id: para-repasar
    title: Para repasar
---

# Desarrollo incremental

## Qué vas a conseguir

Entender la construcción mediante incrementos funcionales sucesivos.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/14-desarrollo-incremental.webp' | relative_url }}" aria-label="Ampliar infografía: Desarrollo incremental">
    <img src="{{ '/assets/images/software/infografias/14-desarrollo-incremental.webp' | relative_url }}" alt="Resumen visual: Desarrollo incremental" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Los incrementos amplían capacidades y deben integrarse. Dividir por capas técnicas no garantiza resultados utilizables.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/14-desarrollo-incremental.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Incremento:** capacidad que se añade a lo disponible.
- **Integración:** combinación coherente con lo ya construido.
- **División vertical:** porción que atraviesa las partes necesarias para ofrecer un resultado.

El equipo quiere ofrecer una parte útil de CodeTasks antes de completar todas las funciones previstas.

El desarrollo incremental amplía el producto mediante capacidades sucesivas. Cada entrega elegida debe poder comprobarse en conjunto con lo anterior. Construir toda la base de datos y dejar la interfaz para el final divide trabajo técnico, pero no ofrece necesariamente una primera capacidad utilizable.

Incremental e iterativo son dimensiones diferentes: añadir filtros amplía capacidades; mejorar un filtro a partir del uso revisa una solución. Un equipo puede combinar ambas. La calidad y compatibilidad del conjunto deben revisarse con cada incorporación.

### Ejemplo guiado

Primer incremento: crear y listar tareas con persistencia. Segundo: completar tareas y distinguir pendientes. Tercero: ordenar por fecha límite. Cada paso permite un recorrido completo de usuario. Tras añadir fechas comprobamos también que siguen funcionando las tareas antiguas sin fecha.

## Práctica

1. Divide un gestor de biblioteca en tres capacidades utilizables.
2. Explica por qué «hacer todas las tablas» no equivale necesariamente a una entrega de valor.
3. Añade una prueba de compatibilidad al tercer incremento de CodeTasks.

## Para repasar

Git identifica entregas; Testing protege capacidades anteriores al incorporar otras nuevas.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion13/' | relative_url }}">← 13 · Modelo en V</a>
  <a href="{{ '/software/leccion15/' | relative_url }}">15 · Desarrollo iterativo, prototipado y espiral →</a>
</div>
