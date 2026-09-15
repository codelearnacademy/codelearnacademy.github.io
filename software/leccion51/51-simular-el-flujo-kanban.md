---
layout: lesson
route: software
lesson_id: leccion51
lesson_file: 51-simular-el-flujo-kanban
lesson_number: "51"
title: Simular el flujo Kanban
description: Representar flujo, WIP y bloqueos del proyecto.
permalink: /software/leccion51/
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

# Simular el flujo Kanban

## Qué vas a conseguir

Representar flujo, WIP y bloqueos del proyecto.

## Punto de partida

Simula cómo fluyen seis tarjetas de CodeTasks. El propósito es observar esperas y decidir mejoras, no solo dibujar columnas.

## Conceptos clave

- **Inicio:** entrada en En curso para esta simulación.
- **Final:** entrada en Terminado tras revisión y comprobación.
- **Rendimiento:** cantidad de elementos terminados por intervalo.

## Desarrollo

Usa Pendiente → En curso → Revisión → Terminado, con límites didácticos de dos y una tarjetas en las etapas intermedias. Registra día de inicio, final y bloqueos. Los bloqueados siguen contando como iniciados. Define los días como unidades transcurridas para evitar cálculos ambiguos.

Revisa cuándo se acumulan tarjetas y qué decisión cambia la situación. No inventes fechas para mostrar una mejora: documenta cada movimiento de la simulación. Compara periodos con el mismo criterio de medición.

## Ejemplo guiado

La tarjeta A empieza el día 1 y termina el 4: ciclo de tres días. B empieza el 2 y termina el 6: cuatro días. C empieza el 3 y sigue abierta al día 6: edad de tres días. A y B dan dos terminaciones durante el periodo observado; C no entra en la media de ciclos terminados. La media de A y B es 3,5 días. Si Revisión está llena, colaboramos allí antes de abrir más trabajo.

## Relación con otras rutas

Los tiempos de revisión de Git pueden incorporarse al análisis cuando coinciden con los límites definidos.

## Ejercicios propuestos

1. Entrega el registro de seis tarjetas durante ocho días simulados.
2. Calcula ciclos de terminadas, edad de abiertas y terminaciones por periodo.
3. Identifica una espera y propone una mejora apoyada en el registro.

## Qué debes recordar

El ciclo se calcula para trabajo terminado; la edad para trabajo abierto. Las medidas necesitan límites y tiempos consistentes.

## Referencias

- [Guía de Kanban (mayo de 2025)](https://kanbanguides.org/the-kanban-guide/2025.5/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion50/' | relative_url }}">← 50 · Organizar un Sprint</a>
  <a href="{{ '/software/leccion52/' | relative_url }}">52 · Proyecto final · Planificación de un producto software →</a>
</div>
