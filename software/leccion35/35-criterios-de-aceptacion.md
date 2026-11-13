---
layout: lesson
route: software
lesson_id: leccion35
lesson_file: 35-criterios-de-aceptacion
lesson_number: "35"
title: Criterios de aceptación
description: Definir condiciones observables para considerar una historia correctamente implementada.
permalink: /software/leccion35/
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

# Criterios de aceptación

## Qué vas a conseguir

Definir condiciones observables para considerar una historia correctamente implementada.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/35-criterios-de-aceptacion.webp' | relative_url }}" aria-label="Ampliar infografía: Criterios de aceptación">
    <img src="{{ '/assets/images/software/infografias/35-criterios-de-aceptacion.webp' | relative_url }}" alt="Resumen visual: Criterios de aceptación" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Aceptar requiere condiciones observables, incluidos límites y errores relevantes. Un criterio debe permitir decidir sin adivinar intenciones.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/35-criterios-de-aceptacion.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Criterio de aceptación:** condición observable de una capacidad.
- **Escenario:** contexto, acción y resultado esperados.
- **Caso límite:** entrada situada en una frontera de las reglas.

«Crear tarea funciona» necesita condiciones compartidas para que dos personas puedan comprobar lo mismo.

Los criterios aclaran qué debe cumplirse para aceptar un comportamiento. Pueden redactarse como lista o mediante «Dado / Cuando / Entonces». La forma importa menos que poder observar y decidir el resultado.

Se incluyen situaciones normales, errores y límites relevantes. «Todo funciona» no es verificable. Tampoco conviene confundir criterios de una historia con condiciones generales de calidad del producto: las segundas se tratarán en la Definition of Done.

### Ejemplo guiado

Para RF-01: dado un estudiante autenticado, cuando introduce «Estudiar UML», entonces aparece una tarea pendiente propia con ese título. Cuando introduce solo espacios, se muestra un error y no aumenta el número de tareas. Con 120 caracteres se acepta; con 121 se rechaza. Las comprobaciones proceden de las reglas acordadas, no de decisiones del programador al azar.

## Práctica

1. Escribe tres criterios para completar una tarea.
2. Incluye un intento de completar una tarea ajena.
3. Convierte «la ordenación es correcta» en un escenario con tres tareas y orden esperado.

## Para repasar

Testing puede automatizar escenarios; una comprobación manual sigue siendo útil cuando el contexto lo requiere.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion34/' | relative_url }}">← 34 · Historias de usuario</a>
  <a href="{{ '/software/leccion36/' | relative_url }}">36 · Definition of Done →</a>
</div>
