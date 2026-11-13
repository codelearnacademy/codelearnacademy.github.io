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

# Límites WIP

## Qué vas a conseguir

Entender cómo limitar trabajo en progreso ayuda a mejorar el flujo.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/30-limites-wip.webp' | relative_url }}" aria-label="Ampliar infografía: Límites WIP">
    <img src="{{ '/assets/images/software/infografias/30-limites-wip.webp' | relative_url }}" alt="Resumen visual: Límites WIP" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Los límites deben cambiar decisiones. Medir requiere inicio, final y unidad de tiempo consistentes.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/30-limites-wip.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Límite WIP:** restricción sobre trabajo iniciado simultáneamente.
- **Cuello de botella:** parte que limita el flujo.
- **Edad:** tiempo transcurrido de un elemento aún abierto.

En CodeTasks hay dos tarjetas en curso y una en revisión. Ambas columnas han alcanzado su límite. La nueva petición espera mientras el equipo ayuda a terminar la revisión. Una tarjeta bloqueada sigue contando como trabajo iniciado. Si el bloqueo depende de una decisión externa, el equipo debe resolver esa causa.

La **edad** se calcula mientras la tarjeta está abierta. El **tiempo de ciclo** se calcula al cerrarla. Si CT-12 empieza el día 1 y termina el día 4, su ciclo es de tres días transcurridos. Usa la misma convención para todas las tarjetas.

## Práctica

1. Decide qué hacer si Revisión está llena y llega una mejora no urgente.
2. Calcula la edad al día 6 de una tarjeta iniciada el día 2.
3. Propón una acción para un bloqueo externo que limitar WIP no resolvería.

## Para repasar

Git y CI ayudan a identificar esperas de revisión y construcción, pero sus tiempos no sustituyen automáticamente el ciclo completo de una tarjeta.

## Referencias

- [Guía de Kanban (mayo de 2025)](https://kanbanguides.org/the-kanban-guide/2025.5/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion29/' | relative_url }}">← 29 · Visualización del trabajo</a>
  <a href="{{ '/software/leccion31/' | relative_url }}">31 · Scrum frente a Kanban →</a>
</div>
