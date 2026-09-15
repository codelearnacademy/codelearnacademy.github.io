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
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: desarrollo
    title: Desarrollo
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-otras-rutas
    title: Relación con otras rutas
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Modelo en cascada

## Qué vas a conseguir

Comprender el desarrollo secuencial y sus ventajas y limitaciones.

## Punto de partida

Un proyecto exige acordar entregables y revisiones antes de pasar de una fase a la siguiente. Ese planteamiento puede aproximarse a un modelo en cascada.

## Conceptos clave

- **Secuencia:** predominio de actividades ordenadas por fases.
- **Línea base:** versión acordada que sirve como referencia.
- **Control de cambios:** evaluación del impacto de modificar lo acordado.

## Desarrollo

El modelo en cascada organiza el trabajo con fases predominantemente secuenciales: requisitos, diseño, construcción y comprobación, antes de la entrega. Facilita identificar entregables y revisiones cuando existe suficiente estabilidad.

Su riesgo es descubrir tarde que los requisitos o la solución no sirven. Volver atrás puede implicar revisar varios entregables. No debe presentarse como una prohibición absoluta de cambios ni como un proceso que siempre fracasa: su adecuación depende de incertidumbre, dependencias y coste de obtener retroalimentación.

## Ejemplo guiado

En CodeTasks documentamos todas las pantallas antes de construirlas. La revisión de documentos detecta campos ausentes, pero una prueba tardía con estudiantes revela que el orden de tareas resulta confuso. El cambio afecta a interfaz y pruebas. Un prototipo temprano habría permitido comprobar esa suposición con menos trabajo.

## Relación con otras rutas

UML permite revisar diseños; Testing puede preparar comprobaciones desde requisitos.

## Ejercicios propuestos

1. Identifica una ventaja de revisar requisitos antes de implementar.
2. Explica el coste de descubrir una necesidad después de construir todas las pantallas.
3. Propón una comprobación temprana compatible con un proyecto que exige entregables formales.

## Qué debes recordar

La secuencia aporta orden, pero el aprendizaje tardío puede encarecer cambios. La estabilidad debe comprobarse, no darse por supuesta.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion11/' | relative_url }}">← 11 · Qué es una metodología de desarrollo</a>
  <a href="{{ '/software/leccion13/' | relative_url }}">13 · Modelo en V →</a>
</div>
