---
layout: lesson
route: software
lesson_id: leccion14
lesson_file: 14-desarrollo-incremental
lesson_number: "14"
title: Desarrollo incremental
description: Entender la construcción mediante incrementos funcionales sucesivos.
permalink: /software/leccion14/
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

# Desarrollo incremental

## Qué vas a conseguir

Entender la construcción mediante incrementos funcionales sucesivos.

## Punto de partida

El equipo quiere ofrecer una parte útil de CodeTasks antes de completar todas las funciones previstas.

## Conceptos clave

- **Incremento:** capacidad que se añade a lo disponible.
- **Integración:** combinación coherente con lo ya construido.
- **División vertical:** porción que atraviesa las partes necesarias para ofrecer un resultado.

## Desarrollo

El desarrollo incremental amplía el producto mediante capacidades sucesivas. Cada entrega elegida debe poder comprobarse en conjunto con lo anterior. Construir toda la base de datos y dejar la interfaz para el final divide trabajo técnico, pero no ofrece necesariamente una primera capacidad utilizable.

Incremental e iterativo son dimensiones diferentes: añadir filtros amplía capacidades; mejorar un filtro a partir del uso revisa una solución. Un equipo puede combinar ambas. La calidad y compatibilidad del conjunto deben revisarse con cada incorporación.

## Ejemplo guiado

Primer incremento: crear y listar tareas con persistencia. Segundo: completar tareas y distinguir pendientes. Tercero: ordenar por fecha límite. Cada paso permite un recorrido completo de usuario. Tras añadir fechas comprobamos también que siguen funcionando las tareas antiguas sin fecha.

## Relación con otras rutas

Git identifica entregas; Testing protege capacidades anteriores al incorporar otras nuevas.

## Ejercicios propuestos

1. Divide un gestor de biblioteca en tres capacidades utilizables.
2. Explica por qué «hacer todas las tablas» no equivale necesariamente a una entrega de valor.
3. Añade una prueba de compatibilidad al tercer incremento de CodeTasks.

## Qué debes recordar

Los incrementos amplían capacidades y deben integrarse. Dividir por capas técnicas no garantiza resultados utilizables.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion13/' | relative_url }}">← 13 · Modelo en V</a>
  <a href="{{ '/software/leccion15/' | relative_url }}">15 · Desarrollo iterativo, prototipado y espiral →</a>
</div>
