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
  - id: infografía
    title: Infografía
  - id: explicación-y-ejemplo
    title: Explicación y ejemplo
  - id: práctica
    title: Práctica
  - id: para-repasar
    title: Para repasar
---

# Definir requisitos del proyecto

## Qué vas a conseguir

Transformar necesidades en requisitos funcionales y no funcionales.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/48-definir-requisitos-del-proyecto.webp' | relative_url }}" aria-label="Ampliar infografía: Definir requisitos del proyecto">
    <img src="{{ '/assets/images/software/infografias/48-definir-requisitos-del-proyecto.webp' | relative_url }}" alt="Resumen visual: Definir requisitos del proyecto" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>El catálogo debe permitir decidir qué construir y cómo comprobarlo. Incluye acceso, errores y contexto de evaluación.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/48-definir-requisitos-del-proyecto.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Identificador:** referencia estable para seguir un requisito.
- **Origen:** necesidad o interesado que lo justifica.
- **Comprobación:** evidencia que decidirá su cumplimiento.

Usa el contexto de la lección 47. Ahora hay que convertir necesidades en requisitos comprobables sin añadir alcance de forma accidental.

Prepara un catálogo breve con identificador, descripción, origen y comprobación. Incluye comportamientos normales, restricciones de acceso y al menos dos atributos de calidad. Los valores numéricos deben declararse como objetivos del ejercicio y justificarse.

Una propuesta inicial contiene crear tareas, consultar las propias, completarlas y asignar fechas opcionales. La privacidad de las tareas forma parte del recorrido, no una mejora opcional para después. Marca preguntas abiertas y evita presentarlas como acuerdos ya validados.

### Ejemplo guiado

RF-01 crea una tarea con título no vacío. RF-02 consulta pendientes propias. RF-03 completa una tarea propia y conserva el registro. RF-04 permite una fecha opcional. Comprobamos RF-03 con dos cuentas: la propietaria puede completar; la otra recibe una denegación y el estado no cambia. Añadimos un objetivo de uso con teclado como requisito de calidad.

## Práctica

1. Entrega cuatro requisitos funcionales y dos de calidad con su comprobación.
2. Añade un caso normal y uno de error a cada funcional.
3. Relaciona cada requisito con una necesidad del caso y enumera dudas pendientes.

## Para repasar

Testing utilizará los casos; UML puede representar interacciones y límites del sistema.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion47/' | relative_url }}">← 47 · Caso práctico · Analizando un proyecto</a>
  <a href="{{ '/software/leccion49/' | relative_url }}">49 · Crear el Product Backlog →</a>
</div>
