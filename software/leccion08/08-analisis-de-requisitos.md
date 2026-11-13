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
  - id: infografía
    title: Infografía
  - id: explicación-y-ejemplo
    title: Explicación y ejemplo
  - id: práctica
    title: Práctica
  - id: para-repasar
    title: Para repasar
---

# Análisis de requisitos

## Qué vas a conseguir

Separar lo que necesita el usuario de cómo se implementará técnicamente.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/08-analisis-de-requisitos.webp' | relative_url }}" aria-label="Ampliar infografía: Análisis de requisitos">
    <img src="{{ '/assets/images/software/infografias/08-analisis-de-requisitos.webp' | relative_url }}" alt="Resumen visual: Análisis de requisitos" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Analizar requisitos exige aclarar necesidad, reglas y excepciones. Una suposición pendiente no es un requisito validado.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/08-analisis-de-requisitos.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Necesidad:** problema o resultado deseado.
- **Requisito:** condición o capacidad que debe satisfacer la solución.
- **Restricción:** límite que condiciona las alternativas.
- **Validación:** comprobar que lo definido responde a la necesidad.

«Quiero organizarme mejor» expresa una necesidad, pero no permite decidir qué comportamiento implementar en CodeTasks.

El análisis comienza escuchando a las personas implicadas y observando su trabajo. Aclaramos términos, excepciones y conflictos antes de concretar requisitos. Separar necesidad y solución evita elegir una tecnología sin entender el problema, aunque pueden existir restricciones técnicas legítimas.

Un requisito útil tiene identificador, origen y forma de comprobarse. Debe revisarse con sus interesados: un texto preciso puede describir la necesidad equivocada. También documentamos las preguntas abiertas en lugar de convertir suposiciones en hechos.

### Ejemplo guiado

Una estudiante olvida qué vence antes. Proponemos RF-02: «Mostrar las tareas pendientes del usuario ordenadas por fecha límite ascendente; las que no tienen fecha aparecen al final». Validamos el orden con tres tarjetas de ejemplo. Queda pendiente decidir cómo tratar tareas vencidas; lo preguntamos antes de programar esa regla.

## Práctica

1. Transforma «la aplicación debe ser cómoda» en preguntas de análisis.
2. Redacta un requisito de completar tareas y una excepción.
3. Añade origen y comprobación a RF-02.

## Para repasar

UML ayuda a representar interacciones; Testing transforma condiciones verificables en pruebas.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion07/' | relative_url }}">← 07 · Planificación de un proyecto</a>
  <a href="{{ '/software/leccion09/' | relative_url }}">09 · Diseño e implementación →</a>
</div>
