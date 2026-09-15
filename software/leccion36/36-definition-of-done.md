---
layout: lesson
route: software
lesson_id: leccion36
lesson_file: 36-definition-of-done
lesson_number: "36"
title: Definition of Done
description: Diferenciar criterios de aceptación y Definition of Done compartida.
permalink: /software/leccion36/
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
  - id: referencias
    title: Referencias
---

# Definition of Done

## Qué vas a conseguir

Diferenciar criterios de aceptación y Definition of Done compartida.

## Punto de partida

Una historia cumple su ejemplo principal, pero sus cambios no están integrados y rompen una consulta anterior. ¿Puede declararse terminada?

## Conceptos clave

- **Criterios de aceptación:** condiciones particulares de una capacidad.
- **Definition of Done:** referencia compartida de calidad del incremento.
- **Evidencia:** comprobación que permite afirmar que se cumple una condición.

## Desarrollo

Cumplir criterios de aceptación no sustituye cumplir la Definition of Done. En Scrum, un trabajo que no la cumple no forma parte del incremento.

Para CodeTasks acordamos una lista concreta antes de evaluar entregas. Debe poder comprobarse y ser viable en el entorno del piloto. No se cambia a la baja al final para convertir trabajo pendiente en terminado. Si una condición resulta poco útil, se revisa explícitamente para futuras decisiones sin ocultar el estado real.

## Ejemplo guiado

Propuesta didáctica: criterios comprobados, cambios revisados e integrados, pruebas de regresión superadas, instalación reproducible y documentación afectada actualizada. La tarea «crear con título» pasa sus ejemplos, pero falla consultar tras reiniciar. Sigue pendiente. Reparamos el defecto y conservamos una prueba que detecte la regresión antes de declararla terminada.

## Relación con otras rutas

Git, Maven y Testing aportan evidencias de integración, construcción y regresión.

## Ejercicios propuestos

1. Redacta cinco condiciones verificables para la Definition of Done del piloto.
2. Distingue cuáles son generales y cuáles pertenecen solo a RF-01.
3. Explica cómo mostrarías trabajo que funciona parcialmente pero no cumple la definición.

## Qué debes recordar

La aceptación específica y la calidad compartida se complementan. Lo parcialmente terminado debe ser visible como tal.

## Referencias

- [Guía oficial de Scrum (2020)](https://scrumguides.org/scrum-guide.html)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion35/' | relative_url }}">← 35 · Criterios de aceptación</a>
  <a href="{{ '/software/leccion37/' | relative_url }}">37 · Descomposición del trabajo →</a>
</div>
