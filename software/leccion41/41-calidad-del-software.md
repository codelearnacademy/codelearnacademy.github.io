---
layout: lesson
route: software
lesson_id: leccion41
lesson_file: 41-calidad-del-software
lesson_number: "41"
title: Calidad del software
description: Reconocer que calidad incluye corrección, mantenibilidad, seguridad, rendimiento y usabilidad.
permalink: /software/leccion41/
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

# Calidad del software

## Qué vas a conseguir

Reconocer que calidad incluye corrección, mantenibilidad, seguridad, rendimiento y usabilidad.

## Punto de partida

CodeTasks guarda tareas, pero puede seguir fallando como producto si no es comprensible, seguro o fácil de modificar.

## Conceptos clave

- **Calidad funcional:** adecuación de los comportamientos a las necesidades.
- **Atributos de calidad:** propiedades como fiabilidad, rendimiento o mantenibilidad.
- **Evidencia de calidad:** resultados de comprobaciones relevantes.

## Desarrollo

La calidad tiene varias dimensiones. Una función correcta no compensa por sí sola pérdida de datos o una interfaz inaccesible. Debemos decidir qué atributos importan en el contexto y cómo observarlos.

Ninguna métrica aislada representa toda la calidad. La cobertura de pruebas indica qué código se ejecutó, no que todos los comportamientos importantes estén comprobados. Combinar pruebas, revisiones y uso real permite conocer riesgos distintos. Los objetivos de calidad forman parte de la planificación.

## Ejemplo guiado

CodeTasks comprueba crear y consultar, persistir tras reiniciar, impedir acceso ajeno y recorrer la interfaz con teclado. Una revisión detecta que la misma validación está duplicada, lo que dificultaría cambios. Mejoramos esa estructura y repetimos las pruebas. Los resultados aportan evidencias distintas sobre calidad, no una única puntuación total.

## Relación con otras rutas

Testing, revisión de código y análisis estático se complementan; ninguno sustituye a todos los demás.

## Ejercicios propuestos

1. Elige tres atributos importantes para el piloto y cómo comprobarlos.
2. Explica qué problema puede escapar a una cobertura elevada.
3. Describe un compromiso entre rendimiento y mantenibilidad que deba discutirse.

## Qué debes recordar

La calidad es multidimensional. Debe hacerse comprobable sin reducirla a una sola métrica.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion40/' | relative_url }}">← 40 · MVP y entregas incrementales</a>
  <a href="{{ '/software/leccion42/' | relative_url }}">42 · Deuda técnica →</a>
</div>
