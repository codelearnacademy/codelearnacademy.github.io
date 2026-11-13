---
layout: lesson
route: software
lesson_id: leccion31
lesson_file: 31-scrum-frente-a-kanban
lesson_number: "31"
title: Scrum frente a Kanban
description: Comparar Scrum y Kanban según necesidades y contexto.
permalink: /software/leccion31/
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

# Scrum frente a Kanban

## Qué vas a conseguir

Comparar Scrum y Kanban según necesidades y contexto.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/31-scrum-frente-a-kanban.webp' | relative_url }}" aria-label="Ampliar infografía: Scrum frente a Kanban">
    <img src="{{ '/assets/images/software/infografias/31-scrum-frente-a-kanban.webp' | relative_url }}" alt="Resumen visual: Scrum frente a Kanban" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>La elección debe responder al contexto. Cadencia y gestión del flujo pueden complementarse.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/31-scrum-frente-a-kanban.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Cadencia:** ritmo de inspección y planificación.
- **Flujo:** movimiento del trabajo hasta terminar.
- **Compatibilidad:** posibilidad de combinar prácticas sin contradecir sus reglas.

CodeTasks necesita desarrollar capacidades y atender incidencias. Elegir una forma de trabajo exige comprender sus restricciones.

Scrum organiza trabajo mediante Sprints y responsabilidades definidas. Kanban centra la atención en el flujo. Pueden combinarse: usar límites WIP dentro de un Sprint no elimina su objetivo ni eventos.

En el ejercicio comparamos necesidades, no etiquetas. Si el equipo trabaja con un objetivo de producto y puede inspeccionarlo periódicamente, una cadencia puede ayudar. Si recibe peticiones variables, necesita políticas claras para incorporarlas. En ambos casos debe evitar empezar más de lo que puede terminar.

### Ejemplo guiado

Para desarrollar fechas límite, CodeTasks usa un objetivo de Sprint. Dentro del Sprint limita revisión a una tarjeta. Si llega una incidencia, evalúa urgencia e impacto sobre el objetivo antes de reorganizarse. Otro equipo dedicado a soporte podría gestionar entradas por capacidad sin adoptar Sprints. Ninguna opción elimina la necesidad de calidad.

## Práctica

1. Describe el patrón de llegadas de un equipo de soporte y uno de producto.
2. Diseña un límite WIP para un Sprint de CodeTasks.
3. Explica por qué añadir un tablero no sustituye los eventos de Scrum.

## Para repasar

Git, Testing y CI sirven en distintas formas de organización: no obligan a elegir Scrum o Kanban.

## Referencias

- [Guía oficial de Scrum (2020)](https://scrumguides.org/scrum-guide.html)
- [Guía de Kanban (mayo de 2025)](https://kanbanguides.org/the-kanban-guide/2025.5/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion30/' | relative_url }}">← 30 · Límites WIP</a>
  <a href="{{ '/software/leccion32/' | relative_url }}">32 · Requisitos funcionales →</a>
</div>
