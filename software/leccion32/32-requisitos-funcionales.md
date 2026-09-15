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
---

# Requisitos funcionales

## Qué vas a conseguir

Identificar comportamientos y capacidades que debe proporcionar el sistema.

## Punto de partida

Para comprobar CodeTasks necesitamos describir qué hace al recibir acciones y datos concretos.

## Conceptos clave

- **Requisito funcional:** comportamiento o capacidad del sistema.
- **Regla de negocio:** condición que determina un resultado válido.
- **Excepción:** situación alternativa que debe tratarse explícitamente.

## Desarrollo

Un requisito funcional explica una respuesta del sistema: crear una tarea, consultar pendientes o rechazar datos inválidos. Debe identificar actor, condiciones relevantes y resultado observable. No es una lista de clases que implementar.

Conviene separar comportamientos para poder discutirlos y comprobarlos. Un texto como «gestionar tareas correctamente» oculta operaciones y excepciones. Numerar requisitos permite enlazarlos con pruebas y decisiones. La precisión no obliga a escribir documentos extensos: obliga a eliminar ambigüedades importantes.

## Ejemplo guiado

RF-01: un estudiante autenticado puede crear una tarea con título de 1 a 120 caracteres después de eliminar espacios en los extremos. El sistema la guarda asociada a ese usuario y la muestra como pendiente. Si el título queda vacío, informa del error y no guarda la tarea. Esto permite probar tanto éxito como rechazo.

## Relación con otras rutas

Java y Spring implementan operaciones; Testing comprueba reglas y excepciones.

## Ejercicios propuestos

1. Redacta RF-03 para completar una tarea propia.
2. Añade una excepción para intentar modificar una tarea de otra persona.
3. Propón entradas y resultados para comprobar RF-01.

## Qué debes recordar

Un requisito funcional describe comportamiento observable y sus condiciones. Debe permitir diseñar una comprobación.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion31/' | relative_url }}">← 31 · Scrum frente a Kanban</a>
  <a href="{{ '/software/leccion33/' | relative_url }}">33 · Requisitos no funcionales →</a>
</div>
