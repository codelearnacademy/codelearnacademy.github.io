---
layout: lesson
route: software
lesson_id: leccion06
lesson_file: 06-el-ciclo-de-vida-del-software
lesson_number: "06"
title: El ciclo de vida del software
description: Reconocer las fases habituales desde la necesidad hasta el mantenimiento de un sistema.
permalink: /software/leccion06/
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

# El ciclo de vida del software

## Qué vas a conseguir

Reconocer las fases habituales desde la necesidad hasta el mantenimiento de un sistema.

## Punto de partida

Una petición de recordatorios en CodeTasks atraviesa varias actividades antes de llegar a los estudiantes y sigue necesitando atención después.

## Conceptos clave

- **Ciclo de vida:** evolución desde la necesidad hasta la retirada.
- **Actividad:** trabajo como analizar, diseñar, probar u operar.
- **Retroalimentación:** información que obliga a revisar decisiones anteriores.

## Desarrollo

Un ciclo de vida contempla concepción, requisitos, diseño, implementación, pruebas, despliegue, operación, mantenimiento y retirada. Esta lista describe actividades habituales, no una obligación de ejecutarlas una sola vez y en ese orden.

En desarrollo incremental se repiten para nuevas capacidades. Las pruebas pueden prepararse al analizar requisitos y el diseño puede revisarse durante la implementación. La operación proporciona información sobre errores y uso real. La retirada también se planifica: avisos, exportación de datos y sustitución del sistema.

## Ejemplo guiado

Para añadir una fecha límite en CodeTasks aclaramos su significado, diseñamos cómo guardarla, implementamos, probamos y entregamos. En el piloto descubrimos una duda sobre tareas vencidas. Volvemos a requisitos y ajustamos la presentación: el ciclo incorpora lo aprendido.

```text
Necesidad → analizar → diseñar → construir y comprobar → entregar
               ↑                                         ↓
               └──────── aprender del uso y mantener ─────┘
```

## Relación con otras rutas

UML apoya el diseño; Testing acompaña varias actividades; Docker facilita la entrega.

## Ejercicios propuestos

1. Sitúa una prueba de restauración y una entrevista con usuarios en el ciclo.
2. Dibuja una vuelta de retroalimentación para un error descubierto en producción.
3. Propón dos tareas para retirar CodeTasks sin perder las tareas de sus usuarios.

## Qué debes recordar

El ciclo no termina al desplegar ni impone una secuencia rígida. Incluye aprendizaje, mantenimiento y retirada.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion05/' | relative_url }}">← 05 · Proyecto, producto y servicio</a>
  <a href="{{ '/software/leccion07/' | relative_url }}">07 · Planificación de un proyecto →</a>
</div>
