---
layout: lesson
route: software
lesson_id: leccion48
lesson_file: 48-definir-requisitos-del-proyecto
lesson_number: "48"
title: Definir requisitos del proyecto
description: Transformar necesidades en requisitos funcionales y no funcionales.
permalink: /software/leccion48/
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

# Definir requisitos del proyecto

## Qué vas a conseguir

Transformar necesidades en requisitos funcionales y no funcionales.

## Punto de partida

Usa el contexto de la lección 47. Ahora hay que convertir necesidades en requisitos comprobables sin añadir alcance de forma accidental.

## Conceptos clave

- **Identificador:** referencia estable para seguir un requisito.
- **Origen:** necesidad o interesado que lo justifica.
- **Comprobación:** evidencia que decidirá su cumplimiento.

## Desarrollo

Prepara un catálogo breve con identificador, descripción, origen y comprobación. Incluye comportamientos normales, restricciones de acceso y al menos dos atributos de calidad. Los valores numéricos deben declararse como objetivos del ejercicio y justificarse.

Una propuesta inicial contiene crear tareas, consultar las propias, completarlas y asignar fechas opcionales. La privacidad de las tareas forma parte del recorrido, no una mejora opcional para después. Marca preguntas abiertas y evita presentarlas como acuerdos ya validados.

## Ejemplo guiado

Aplicación al caso CodeTasks:

RF-01 crea una tarea con título no vacío. RF-02 consulta pendientes propias. RF-03 completa una tarea propia y conserva el registro. RF-04 permite una fecha opcional. Comprobamos RF-03 con dos cuentas: la propietaria puede completar; la otra recibe una denegación y el estado no cambia. Añadimos un objetivo de uso con teclado como requisito de calidad.

## Relación con otras rutas

Testing utilizará los casos; UML puede representar interacciones y límites del sistema.

## Ejercicios propuestos

1. Entrega cuatro requisitos funcionales y dos de calidad con su comprobación.
2. Añade un caso normal y uno de error a cada funcional.
3. Relaciona cada requisito con una necesidad del caso y enumera dudas pendientes.

## Qué debes recordar

El catálogo debe permitir decidir qué construir y cómo comprobarlo. Incluye acceso, errores y contexto de evaluación.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion47/' | relative_url }}">← 47 · Caso práctico · Analizando un proyecto</a>
  <a href="{{ '/software/leccion49/' | relative_url }}">49 · Crear el Product Backlog →</a>
</div>
