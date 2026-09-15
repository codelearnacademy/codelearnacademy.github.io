---
layout: lesson
route: software
lesson_id: leccion29
lesson_file: 29-visualizacion-del-trabajo
lesson_number: "29"
title: Visualización del trabajo
description: Representar estados, políticas y bloqueos mediante un tablero.
permalink: /software/leccion29/
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

# Visualización del trabajo

## Qué vas a conseguir

Representar estados, políticas y bloqueos mediante un tablero.

## Punto de partida

Una tarjeta situada en «En curso» puede estar programándose o esperando información. Ocultar esa diferencia dificulta mejorar el flujo.

## Conceptos clave

- **Estado:** situación real del elemento.
- **Política explícita:** condición para entrar o salir de un estado.
- **Bloqueo:** impedimento visible con causa y seguimiento.

## Desarrollo

El tablero debe mostrar estados útiles para tomar decisiones. No existe una lista universal de columnas. Para CodeTasks distinguimos construcción y revisión porque sus esperas tienen causas diferentes.

Una tarjeta necesita suficiente información para comprender su propósito y comprobarla. Indicamos identificador, resultado esperado, fecha de inicio y bloqueos. Una política de salida como «pruebas acordadas superadas y revisión realizada» reduce discusiones sobre qué significa finalizar. Evitamos columnas que solo sirven para aparentar progreso.

## Ejemplo guiado

CT-12, «Ordenar pendientes por fecha», está en Revisión. Sus pruebas pasan, pero falta acordar cómo colocar las tareas sin fecha. Marcamos el bloqueo y la pregunta pendiente. Sigue siendo trabajo iniciado. Tras aclararlo, se adapta y comprueba antes de moverlo a Terminado.

## Relación con otras rutas

Las pruebas y revisiones del repositorio pueden enlazarse como evidencias de las condiciones de salida.

## Ejercicios propuestos

1. Diseña una tarjeta CT-13 para completar tareas.
2. Escribe condiciones de entrada y salida de Revisión.
3. Representa un bloqueo sin eliminar la tarjeta del trabajo en curso.

## Qué debes recordar

Visualizar significa hacer visible la situación real. Las políticas explican qué condiciones permiten mover una tarjeta.

## Referencias

- [Guía de Kanban (mayo de 2025)](https://kanbanguides.org/the-kanban-guide/2025.5/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion28/' | relative_url }}">← 28 · Introducción a Kanban</a>
  <a href="{{ '/software/leccion30/' | relative_url }}">30 · Límites WIP →</a>
</div>
