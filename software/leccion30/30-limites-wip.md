---
layout: lesson
route: software
lesson_id: leccion30
lesson_file: 30-limites-wip
lesson_number: "30"
title: Límites WIP
description: Entender cómo limitar trabajo en progreso ayuda a mejorar el flujo.
permalink: /software/leccion30/
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

# Límites WIP

## Qué vas a conseguir

Entender cómo limitar trabajo en progreso ayuda a mejorar el flujo.

## Punto de partida

Hay cinco cambios abiertos y ninguno revisado. Empezar otro puede aumentar las esperas sin aportar una nueva entrega.

## Conceptos clave

- **Límite WIP:** restricción sobre trabajo iniciado simultáneamente.
- **Cuello de botella:** parte que limita el flujo.
- **Edad:** tiempo transcurrido de un elemento aún abierto.

## Desarrollo

Limitar WIP favorece terminar antes de iniciar. Kanban observa WIP, rendimiento, edad del trabajo abierto y tiempo de ciclo de los elementos terminados; sus límites de medición deben ser explícitos.

Un límite no garantiza por sí solo que todo vaya más rápido. Si faltan conocimientos o una decisión externa, hace falta actuar sobre esa causa. En el ejercicio los bloqueos cuentan dentro del trabajo iniciado: esconderlos haría parecer disponible una capacidad que no existe.

## Ejemplo guiado

Aplicación al caso CodeTasks:

Dos tarjetas están en curso y una en revisión; esos son nuestros límites. Una nueva petición espera. El equipo ayuda a revisar y termina una tarjeta antes de iniciar otra. Si CT-12 comenzó el día 1 y termina el día 4, su ciclo es de tres días transcurridos bajo esa convención. Registramos la misma convención para todas las tarjetas.

## Relación con otras rutas

Git y CI ayudan a identificar esperas de revisión y construcción, pero sus tiempos no sustituyen automáticamente el ciclo completo de una tarjeta.

## Ejercicios propuestos

1. Decide qué hacer si Revisión está llena y llega una mejora no urgente.
2. Calcula la edad al día 6 de una tarjeta iniciada el día 2.
3. Propón una acción para un bloqueo externo que limitar WIP no resolvería.

## Qué debes recordar

Los límites deben cambiar decisiones. Medir requiere inicio, final y unidad de tiempo consistentes.

## Referencias

- [Guía de Kanban (mayo de 2025)](https://kanbanguides.org/the-kanban-guide/2025.5/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion29/' | relative_url }}">← 29 · Visualización del trabajo</a>
  <a href="{{ '/software/leccion31/' | relative_url }}">31 · Scrum frente a Kanban →</a>
</div>
