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

# Introducción a Kanban

## Qué vas a conseguir

Comprender Kanban como enfoque para visualizar y gestionar flujo.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/28-introduccion-a-kanban.webp' | relative_url }}" aria-label="Ampliar infografía: Introducción a Kanban">
    <img src="{{ '/assets/images/software/infografias/28-introduccion-a-kanban.webp' | relative_url }}" alt="Resumen visual: Introducción a Kanban" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>El tablero ayuda si refleja políticas y provoca decisiones. El objetivo es terminar trabajo, no mantener a todos iniciando tareas.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/28-introduccion-a-kanban.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Flujo:** recorrido de los elementos desde el inicio hasta el final acordados.
- **WIP:** trabajo iniciado y aún no terminado.
- **Pull:** incorporar trabajo cuando existe capacidad.

CodeTasks combina mejoras e incidencias. El equipo quiere ver dónde se acumula trabajo y terminarlo con menos esperas.

Kanban busca optimizar el flujo mediante su definición y visualización, gestión activa y mejora. Un tablero sin políticas ni decisiones sobre el trabajo es insuficiente.

Para el ejercicio acordamos qué representa una tarjeta, cuándo empieza, qué significa terminar y cómo tratar bloqueos. Los límites deben influir en decisiones: si una etapa está llena, ayudamos a terminar antes de iniciar más. El tablero debe reflejar el trabajo real, incluidas esperas relevantes.

### Ejemplo guiado

En CodeTasks usamos Pendiente → En curso → Revisión → Terminado. Permitimos dos tarjetas en curso y una en revisión. Cuando revisión está llena, otra persona ayuda a comprobar esa tarjeta. No movemos trabajo a terminado para liberar espacio artificialmente. Anotamos el bloqueo y buscamos su causa.

## Práctica

1. Define inicio y final para una incidencia de CodeTasks.
2. Escribe una política de entrada en Revisión.
3. Decide qué harías con una tarjeta bloqueada cuando se alcanza el límite.

## Para repasar

Git permite relacionar tarjetas con cambios; Testing aporta criterios para revisar y finalizar.

## Referencias

- [Guía de Kanban (mayo de 2025)](https://kanbanguides.org/the-kanban-guide/2025.5/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion27/' | relative_url }}">← 27 · Sprint Review y Retrospective</a>
  <a href="{{ '/software/leccion29/' | relative_url }}">29 · Visualización del trabajo →</a>
</div>
