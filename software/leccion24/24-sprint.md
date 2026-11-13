---
layout: lesson
route: software
lesson_id: leccion24
lesson_file: 24-sprint
lesson_number: "24"
title: Sprint
description: Comprender el Sprint como periodo orientado a un objetivo y un incremento.
permalink: /software/leccion24/
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
  - id: referencias
    title: Referencias
---

# Sprint

## Qué vas a conseguir

Comprender el Sprint como periodo orientado a un objetivo y un incremento.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/24-sprint.webp' | relative_url }}" aria-label="Ampliar infografía: Sprint">
    <img src="{{ '/assets/images/software/infografias/24-sprint.webp' | relative_url }}" alt="Resumen visual: Sprint" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Un objetivo permite negociar detalles con criterio. Una previsión incumplida debe hacerse visible, no ocultarse cambiando qué significa terminar.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/24-sprint.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Timebox:** duración máxima o fija según el evento.
- **Sprint Goal:** propósito compartido del Sprint.
- **Alcance:** trabajo que puede ajustarse para alcanzar ese propósito.

El equipo necesita una cadencia para comprobar avances, pero no debe alargarla cada vez que una función queda pendiente.

Un Sprint dura un mes o menos. Protege su objetivo y calidad; el alcance puede renegociarse. Puede producir varios incrementos y entregarlos antes de la Review.

El siguiente Sprint comienza al terminar el anterior. Si el objetivo queda obsoleto, el Product Owner tiene autoridad para cancelar el Sprint; no se cancela automáticamente por una tarea retrasada.

En el ejercicio elegimos dos semanas para obtener retroalimentación frecuente. Si aparece una dificultad, no ampliamos automáticamente el plazo ni declaramos completa una función sin comprobar. Revisamos alternativas que permitan alcanzar el resultado buscado y hacemos visible lo que queda pendiente.

### Ejemplo guiado

Objetivo: registrar y consultar tareas personales. Durante el Sprint descubrimos que añadir colores requiere más trabajo. Lo posponemos porque no es necesario para el objetivo. La persistencia sí es necesaria para el recorrido acordado y sigue incluida. Terminamos en la fecha prevista y explicamos el resultado real, sin contabilizar como acabado lo que falta.

## Práctica

1. Propón un objetivo para un Sprint de fechas límite.
2. Identifica una función prescindible y una esencial para ese objetivo.
3. Explica por qué bajar las comprobaciones de calidad no resuelve un exceso de trabajo.

## Para repasar

Testing permite comprobar el resultado; Git identifica incrementos entregables.

## Referencias

- [Guía oficial de Scrum (2020)](https://scrumguides.org/scrum-guide.html)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion23/' | relative_url }}">← 23 · Product Backlog</a>
  <a href="{{ '/software/leccion25/' | relative_url }}">25 · Sprint Planning y Sprint Backlog →</a>
</div>
