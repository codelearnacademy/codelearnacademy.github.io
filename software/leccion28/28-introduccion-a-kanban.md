---
layout: lesson
route: software
lesson_id: leccion28
lesson_file: 28-introduccion-a-kanban
lesson_number: "28"
title: Introducción a Kanban
description: Comprender Kanban como enfoque para visualizar y gestionar flujo.
permalink: /software/leccion28/
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

# Introducción a Kanban

## Qué vas a conseguir

Comprender Kanban como enfoque para visualizar y gestionar flujo.

## Punto de partida

CodeTasks combina mejoras e incidencias. El equipo quiere ver dónde se acumula trabajo y terminarlo con menos esperas.

## Conceptos clave

- **Flujo:** recorrido de los elementos desde el inicio hasta el final acordados.
- **WIP:** trabajo iniciado y aún no terminado.
- **Pull:** incorporar trabajo cuando existe capacidad.

## Desarrollo

Kanban busca optimizar el flujo mediante su definición y visualización, gestión activa y mejora. Un tablero sin políticas ni decisiones sobre el trabajo es insuficiente.

Para el ejercicio acordamos qué representa una tarjeta, cuándo empieza, qué significa terminar y cómo tratar bloqueos. Los límites deben influir en decisiones: si una etapa está llena, ayudamos a terminar antes de iniciar más. El tablero debe reflejar el trabajo real, incluidas esperas relevantes.

## Ejemplo guiado

En CodeTasks usamos Pendiente → En curso → Revisión → Terminado. Permitimos dos tarjetas en curso y una en revisión. Cuando revisión está llena, otra persona ayuda a comprobar esa tarjeta. No movemos trabajo a terminado para liberar espacio artificialmente. Anotamos el bloqueo y buscamos su causa.

## Relación con otras rutas

Git permite relacionar tarjetas con cambios; Testing aporta criterios para revisar y finalizar.

## Ejercicios propuestos

1. Define inicio y final para una incidencia de CodeTasks.
2. Escribe una política de entrada en Revisión.
3. Decide qué harías con una tarjeta bloqueada cuando se alcanza el límite.

## Qué debes recordar

El tablero ayuda si refleja políticas y provoca decisiones. El objetivo es terminar trabajo, no mantener a todos iniciando tareas.

## Referencias

- [Guía de Kanban (mayo de 2025)](https://kanbanguides.org/the-kanban-guide/2025.5/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion27/' | relative_url }}">← 27 · Sprint Review y Retrospective</a>
  <a href="{{ '/software/leccion29/' | relative_url }}">29 · Visualización del trabajo →</a>
</div>
