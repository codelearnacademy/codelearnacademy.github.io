---
layout: lesson
route: software
lesson_id: leccion13
lesson_file: 13-modelo-en-v
lesson_number: "13"
title: Modelo en V
description: Relacionar fases de desarrollo con verificación y validación.
permalink: /software/leccion13/
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

# Modelo en V

## Qué vas a conseguir

Relacionar fases de desarrollo con verificación y validación.

## Punto de partida

Una regla de CodeTasks debe poder seguirse desde su definición hasta la evidencia que demuestra su cumplimiento.

## Conceptos clave

- **Verificación:** comprobar conformidad con lo especificado.
- **Validación:** comprobar adecuación a las necesidades de uso.
- **Trazabilidad:** relación entre requisito, diseño y comprobación.

## Desarrollo

El modelo en V relaciona actividades de definición y descomposición con actividades de integración y pruebas. Una representación habitual asocia necesidades con aceptación, requisitos del sistema con pruebas de sistema, arquitectura con integración y diseño de componentes con pruebas unitarias. Los nombres y detalles varían según el modelo empleado.

La enseñanza principal es preparar cómo comprobar cada nivel mientras se define, no esperar al final para pensar en pruebas. Verificación y validación pueden incluir revisiones y otras técnicas, además de ejecutar software.

## Ejemplo guiado

Necesidad: encontrar la próxima entrega. Requisito: ordenar pendientes por fecha. Diseñamos un componente de ordenación y su conexión con persistencia. Una prueba unitaria comprueba el orden; una de integración comprueba recuperar fechas; una de sistema recorre la pantalla; una sesión de aceptación confirma que estudiantes encuentran su próxima entrega.

## Relación con otras rutas

Testing desarrolla niveles de prueba; UML ayuda a conectar responsabilidades y componentes.

## Ejercicios propuestos

1. Relaciona la regla «título obligatorio» con una comprobación de componente y otra de sistema.
2. Explica cómo puede pasar una prueba técnica y fallar la validación con usuarios.
3. Construye una tabla requisito → diseño → prueba para dos requisitos.

## Qué debes recordar

La V conecta definición y comprobación. Cumplir una especificación no garantiza que la necesidad estuviera bien entendida.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion12/' | relative_url }}">← 12 · Modelo en cascada</a>
  <a href="{{ '/software/leccion14/' | relative_url }}">14 · Desarrollo incremental →</a>
</div>
