---
layout: lesson
route: software
lesson_id: leccion12
lesson_file: 12-modelo-en-cascada
lesson_number: "12"
title: Modelo en cascada
description: Comprender el desarrollo secuencial y sus ventajas y limitaciones.
permalink: /software/leccion12/
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

# Modelo en cascada

## Qué vas a conseguir

Comprender el desarrollo secuencial y sus ventajas y limitaciones.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/12-modelo-en-cascada.webp' | relative_url }}" aria-label="Ampliar infografía: Modelo en cascada">
    <img src="{{ '/assets/images/software/infografias/12-modelo-en-cascada.webp' | relative_url }}" alt="Resumen visual: Modelo en cascada" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>La secuencia aporta orden, pero el aprendizaje tardío puede encarecer cambios. La estabilidad debe comprobarse, no darse por supuesta.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/12-modelo-en-cascada.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Secuencia:** predominio de actividades ordenadas por fases.
- **Línea base:** versión acordada que sirve como referencia.
- **Control de cambios:** evaluación del impacto de modificar lo acordado.

Un proyecto exige acordar entregables y revisiones antes de pasar de una fase a la siguiente. Ese planteamiento puede aproximarse a un modelo en cascada.

El modelo en cascada organiza el trabajo con fases predominantemente secuenciales: requisitos, diseño, construcción y comprobación, antes de la entrega. Facilita identificar entregables y revisiones cuando existe suficiente estabilidad.

Su riesgo es descubrir tarde que los requisitos o la solución no sirven. Volver atrás puede implicar revisar varios entregables. No debe presentarse como una prohibición absoluta de cambios ni como un proceso que siempre fracasa: su adecuación depende de incertidumbre, dependencias y coste de obtener retroalimentación.

### Ejemplo guiado

En CodeTasks documentamos todas las pantallas antes de construirlas. La revisión de documentos detecta campos ausentes, pero una prueba tardía con estudiantes revela que el orden de tareas resulta confuso. El cambio afecta a interfaz y pruebas. Un prototipo temprano habría permitido comprobar esa suposición con menos trabajo.

## Práctica

1. Identifica una ventaja de revisar requisitos antes de implementar.
2. Explica el coste de descubrir una necesidad después de construir todas las pantallas.
3. Propón una comprobación temprana compatible con un proyecto que exige entregables formales.

## Para repasar

UML permite revisar diseños; Testing puede preparar comprobaciones desde requisitos.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion11/' | relative_url }}">← 11 · Qué es una metodología de desarrollo</a>
  <a href="{{ '/software/leccion13/' | relative_url }}">13 · Modelo en V →</a>
</div>
