---
layout: lesson
route: software
lesson_id: leccion32
lesson_file: 32-requisitos-funcionales
lesson_number: "32"
title: Requisitos funcionales
description: Identificar comportamientos y capacidades que debe proporcionar el sistema.
permalink: /software/leccion32/
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
---

# Requisitos funcionales

## Qué vas a conseguir

Identificar comportamientos y capacidades que debe proporcionar el sistema.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/32-requisitos-funcionales.webp' | relative_url }}" aria-label="Ampliar infografía: Requisitos funcionales">
    <img src="{{ '/assets/images/software/infografias/32-requisitos-funcionales.webp' | relative_url }}" alt="Resumen visual: Requisitos funcionales" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Un requisito funcional describe comportamiento observable y sus condiciones. Debe permitir diseñar una comprobación.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/32-requisitos-funcionales.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Requisito funcional:** comportamiento o capacidad del sistema.
- **Regla de negocio:** condición que determina un resultado válido.
- **Excepción:** situación alternativa que debe tratarse explícitamente.

Para comprobar CodeTasks necesitamos describir qué hace al recibir acciones y datos concretos.

Un requisito funcional explica una respuesta del sistema: crear una tarea, consultar pendientes o rechazar datos inválidos. Debe identificar actor, condiciones relevantes y resultado observable. No es una lista de clases que implementar.

Conviene separar comportamientos para poder discutirlos y comprobarlos. Un texto como «gestionar tareas correctamente» oculta operaciones y excepciones. Numerar requisitos permite enlazarlos con pruebas y decisiones. La precisión no obliga a escribir documentos extensos: obliga a eliminar ambigüedades importantes.

### Ejemplo guiado

RF-01: un estudiante autenticado puede crear una tarea con título de 1 a 120 caracteres después de eliminar espacios en los extremos. El sistema la guarda asociada a ese usuario y la muestra como pendiente. Si el título queda vacío, informa del error y no guarda la tarea. Esto permite probar tanto éxito como rechazo.

## Práctica

1. Redacta RF-03 para completar una tarea propia.
2. Añade una excepción para intentar modificar una tarea de otra persona.
3. Propón entradas y resultados para comprobar RF-01.

## Para repasar

Java y Spring implementan operaciones; Testing comprueba reglas y excepciones.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion31/' | relative_url }}">← 31 · Scrum frente a Kanban</a>
  <a href="{{ '/software/leccion33/' | relative_url }}">33 · Requisitos no funcionales →</a>
</div>
