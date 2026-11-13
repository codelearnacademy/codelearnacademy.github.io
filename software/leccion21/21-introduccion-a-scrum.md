---
layout: lesson
route: software
lesson_id: leccion21
lesson_file: 21-introduccion-a-scrum
lesson_number: "21"
title: Introducción a Scrum
description: Comprender Scrum como marco iterativo e incremental.
permalink: /software/leccion21/
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

# Introducción a Scrum

## Qué vas a conseguir

Comprender Scrum como marco iterativo e incremental.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/21-introduccion-a-scrum.webp' | relative_url }}" aria-label="Ampliar infografía: Introducción a Scrum">
    <img src="{{ '/assets/images/software/infografias/21-introduccion-a-scrum.webp' | relative_url }}" alt="Resumen visual: Introducción a Scrum" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Scrum utiliza inspección y adaptación. El Sprint contiene sus demás eventos; no es únicamente un tramo de programación.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/21-introduccion-a-scrum.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Empirismo:** decidir a partir de lo observado.
- **Incremento:** resultado integrado y utilizable.
- **Transparencia:** hacer visible el estado real del trabajo.

El equipo de CodeTasks necesita una forma de aprender del producto sin perder un objetivo compartido.

Scrum es un marco iterativo e incremental basado en transparencia, inspección y adaptación. El Sprint contiene Planning, Daily Scrums, Review y Retrospective, además del trabajo de desarrollo.

Sus artefactos se relacionan con compromisos que ayudan a inspeccionarlos: Product Backlog con Product Goal, Sprint Backlog con Sprint Goal e Incremento con Definition of Done. Los valores de compromiso, foco, apertura, respeto y coraje apoyan esa forma de trabajar.

En CodeTasks conviene distinguir conversar sobre el producto de comprobarlo. Una lista de tareas movidas a «terminado» aporta menos evidencia que demostrar el recorrido del estudiante y revisar sus resultados. Si aparece un problema, hacemos visible qué falta y adaptamos el plan.

```text
Sprint
├─ Planning: acordar objetivo y plan
├─ Crear y comprobar incrementos; Daily Scrums
├─ Review: examinar resultado y próximos pasos
└─ Retrospective: mejorar la forma de trabajar
```

### Ejemplo guiado

Para el primer Sprint del ejercicio buscamos que un estudiante registre y encuentre una tarea. Construimos ese recorrido y lo comprobamos con datos ficticios. En la Review observamos una dificultad al localizar pendientes; después ordenamos la mejora. En la Retrospective tratamos una espera en revisión de código, que es un problema de trabajo diferente.

## Práctica

1. Sitúa Planning y Review dentro del dibujo del Sprint.
2. Identifica qué evidencia mostrarías del objetivo del ejemplo.
3. Distingue una mejora del producto de una mejora de trabajo.

## Para repasar

Git y Testing permiten producir y comprobar el resultado que después se inspecciona.

## Referencias

- [Guía oficial de Scrum (2020)](https://scrumguides.org/scrum-guide.html)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion20/' | relative_url }}">← 20 · Predictivo frente a adaptativo</a>
  <a href="{{ '/software/leccion22/' | relative_url }}">22 · Responsabilidades en Scrum →</a>
</div>
