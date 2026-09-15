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
  - id: referencias
    title: Referencias
---

# Sprint

## Qué vas a conseguir

Comprender el Sprint como periodo orientado a un objetivo y un incremento.

## Punto de partida

El equipo necesita una cadencia para comprobar avances, pero no debe alargarla cada vez que una función queda pendiente.

## Conceptos clave

- **Timebox:** duración máxima o fija según el evento.
- **Sprint Goal:** propósito compartido del Sprint.
- **Alcance:** trabajo que puede ajustarse para alcanzar ese propósito.

## Desarrollo

Un Sprint dura un mes o menos. Protege su objetivo y calidad; el alcance puede renegociarse. Puede producir varios incrementos y entregarlos antes de la Review.

El siguiente Sprint comienza al terminar el anterior. Si el objetivo queda obsoleto, el Product Owner tiene autoridad para cancelar el Sprint; no se cancela automáticamente por una tarea retrasada.

En el ejercicio elegimos dos semanas para obtener retroalimentación frecuente. Si aparece una dificultad, no ampliamos automáticamente el plazo ni declaramos completa una función sin comprobar. Revisamos alternativas que permitan alcanzar el resultado buscado y hacemos visible lo que queda pendiente.

## Ejemplo guiado

Aplicación al caso CodeTasks:

Objetivo: registrar y consultar tareas personales. Durante el Sprint descubrimos que añadir colores requiere más trabajo. Lo posponemos porque no es necesario para el objetivo. La persistencia sí es necesaria para el recorrido acordado y sigue incluida. Terminamos en la fecha prevista y explicamos el resultado real, sin contabilizar como acabado lo que falta.

## Relación con otras rutas

Testing permite comprobar el resultado; Git identifica incrementos entregables.

## Ejercicios propuestos

1. Propón un objetivo para un Sprint de fechas límite.
2. Identifica una función prescindible y una esencial para ese objetivo.
3. Explica por qué bajar las comprobaciones de calidad no resuelve un exceso de trabajo.

## Qué debes recordar

Un objetivo permite negociar detalles con criterio. Una previsión incumplida debe hacerse visible, no ocultarse cambiando qué significa terminar.

## Referencias

- [Guía oficial de Scrum (2020)](https://scrumguides.org/scrum-guide.html)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion23/' | relative_url }}">← 23 · Product Backlog</a>
  <a href="{{ '/software/leccion25/' | relative_url }}">25 · Sprint Planning y Sprint Backlog →</a>
</div>
