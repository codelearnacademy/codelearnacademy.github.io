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

# Criterios de aceptación

## Qué vas a conseguir

Definir condiciones observables para considerar una historia correctamente implementada.

## Punto de partida

«Crear tarea funciona» necesita condiciones compartidas para que dos personas puedan comprobar lo mismo.

## Conceptos clave

- **Criterio de aceptación:** condición observable de una capacidad.
- **Escenario:** contexto, acción y resultado esperados.
- **Caso límite:** entrada situada en una frontera de las reglas.

## Desarrollo

Los criterios aclaran qué debe cumplirse para aceptar un comportamiento. Pueden redactarse como lista o mediante «Dado / Cuando / Entonces». La forma importa menos que poder observar y decidir el resultado.

Se incluyen situaciones normales, errores y límites relevantes. «Todo funciona» no es verificable. Tampoco conviene confundir criterios de una historia con condiciones generales de calidad del producto: las segundas se tratarán en la Definition of Done.

## Ejemplo guiado

Aplicación al caso CodeTasks:

Para RF-01: dado un estudiante autenticado, cuando introduce «Estudiar UML», entonces aparece una tarea pendiente propia con ese título. Cuando introduce solo espacios, se muestra un error y no aumenta el número de tareas. Con 120 caracteres se acepta; con 121 se rechaza. Las comprobaciones proceden de las reglas acordadas, no de decisiones del programador al azar.

## Relación con otras rutas

Testing puede automatizar escenarios; una comprobación manual sigue siendo útil cuando el contexto lo requiere.

## Ejercicios propuestos

1. Escribe tres criterios para completar una tarea.
2. Incluye un intento de completar una tarea ajena.
3. Convierte «la ordenación es correcta» en un escenario con tres tareas y orden esperado.

## Qué debes recordar

Aceptar requiere condiciones observables, incluidos límites y errores relevantes. Un criterio debe permitir decidir sin adivinar intenciones.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion34/' | relative_url }}">← 34 · Historias de usuario</a>
  <a href="{{ '/software/leccion36/' | relative_url }}">36 · Definition of Done →</a>
</div>
