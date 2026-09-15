---
layout: lesson
route: software
lesson_id: leccion08
lesson_file: 08-analisis-de-requisitos
lesson_number: "08"
title: Análisis de requisitos
description: Separar lo que necesita el usuario de cómo se implementará técnicamente.
permalink: /software/leccion08/
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

# Análisis de requisitos

## Qué vas a conseguir

Separar lo que necesita el usuario de cómo se implementará técnicamente.

## Punto de partida

«Quiero organizarme mejor» expresa una necesidad, pero no permite decidir qué comportamiento implementar en CodeTasks.

## Conceptos clave

- **Necesidad:** problema o resultado deseado.
- **Requisito:** condición o capacidad que debe satisfacer la solución.
- **Restricción:** límite que condiciona las alternativas.
- **Validación:** comprobar que lo definido responde a la necesidad.

## Desarrollo

El análisis comienza escuchando a las personas implicadas y observando su trabajo. Aclaramos términos, excepciones y conflictos antes de concretar requisitos. Separar necesidad y solución evita elegir una tecnología sin entender el problema, aunque pueden existir restricciones técnicas legítimas.

Un requisito útil tiene identificador, origen y forma de comprobarse. Debe revisarse con sus interesados: un texto preciso puede describir la necesidad equivocada. También documentamos las preguntas abiertas en lugar de convertir suposiciones en hechos.

## Ejemplo guiado

Una estudiante olvida qué vence antes. Proponemos RF-02: «Mostrar las tareas pendientes del usuario ordenadas por fecha límite ascendente; las que no tienen fecha aparecen al final». Validamos el orden con tres tarjetas de ejemplo. Queda pendiente decidir cómo tratar tareas vencidas; lo preguntamos antes de programar esa regla.

## Relación con otras rutas

UML ayuda a representar interacciones; Testing transforma condiciones verificables en pruebas.

## Ejercicios propuestos

1. Transforma «la aplicación debe ser cómoda» en preguntas de análisis.
2. Redacta un requisito de completar tareas y una excepción.
3. Añade origen y comprobación a RF-02.

## Qué debes recordar

Analizar requisitos exige aclarar necesidad, reglas y excepciones. Una suposición pendiente no es un requisito validado.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion07/' | relative_url }}">← 07 · Planificación de un proyecto</a>
  <a href="{{ '/software/leccion09/' | relative_url }}">09 · Diseño e implementación →</a>
</div>
