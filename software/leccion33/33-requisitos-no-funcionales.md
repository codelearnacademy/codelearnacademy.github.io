---
layout: lesson
route: software
lesson_id: leccion33
lesson_file: 33-requisitos-no-funcionales
lesson_number: "33"
title: Requisitos no funcionales
description: Identificar restricciones y atributos de calidad medibles.
permalink: /software/leccion33/
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

# Requisitos no funcionales

## Qué vas a conseguir

Identificar restricciones y atributos de calidad medibles.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/33-requisitos-no-funcionales.webp' | relative_url }}" aria-label="Ampliar infografía: Requisitos no funcionales">
    <img src="{{ '/assets/images/software/infografias/33-requisitos-no-funcionales.webp' | relative_url }}" alt="Resumen visual: Requisitos no funcionales" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Una cualidad se evalúa bajo condiciones. El umbral debe justificarse y medirse con un procedimiento reproducible.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/33-requisitos-no-funcionales.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Atributo de calidad:** característica como rendimiento o accesibilidad.
- **Restricción:** condición impuesta a la solución o su entorno.
- **Umbral:** límite que permite decidir si se cumple un requisito.

CodeTasks puede listar tareas y aun así resultar inutilizable si tarda demasiado o muestra información de otro estudiante.

Los requisitos no funcionales describen cualidades y restricciones, no solo operaciones. «Rápido» o «seguro» no bastan: deben traducirse en condiciones comprobables y en un contexto de evaluación.

Algunas necesidades de seguridad se concretan también como reglas funcionales, por ejemplo denegar acceso a una tarea ajena. Las categorías ayudan a revisar cobertura, pero no deben impedir expresar el comportamiento. Los umbrales del ejercicio son decisiones didácticas, no valores universales para cualquier aplicación.

### Ejemplo guiado

RNF-01: con 30 sesiones concurrentes y 100 tareas por cuenta en el entorno piloto acordado, el percentil 95 del tiempo de respuesta de la consulta será menor o igual a 500 ms durante una prueba de diez minutos tras calentamiento. RNF-02: el recorrido de crear y consultar debe poder completarse usando solo teclado. Cada requisito necesita un procedimiento de comprobación.

## Práctica

1. Mejora «CodeTasks debe ser fácil de usar» indicando tarea, participantes y criterio.
2. Explica por qué medir rendimiento sin volumen de datos es insuficiente.
3. Diseña una comprobación para evitar acceso a tareas ajenas.

## Para repasar

Testing incluye pruebas de rendimiento y accesibilidad; Spring permite aplicar controles de acceso.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion32/' | relative_url }}">← 32 · Requisitos funcionales</a>
  <a href="{{ '/software/leccion34/' | relative_url }}">34 · Historias de usuario →</a>
</div>
