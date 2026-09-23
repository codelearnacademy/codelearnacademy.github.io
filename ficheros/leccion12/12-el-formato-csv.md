---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion12"
lesson_file: "12-el-formato-csv"
lesson_number: "12"
title: "El formato CSV"
description: "El formato CSV: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion12/"
lessons:
  - id: "qué-vas-a-conseguir"
    title: "Qué vas a conseguir"
  - id: "punto-de-partida"
    title: "Punto de partida"
  - id: "conceptos-clave"
    title: "Conceptos clave"
  - id: "ejemplo-guiado"
    title: "Ejemplo guiado"
  - id: "relación-con-el-resto-de-la-ruta"
    title: "Relación con el resto de la ruta"
  - id: "ejercicios-propuestos"
    title: "Ejercicios propuestos"
  - id: "qué-debes-recordar"
    title: "Qué debes recordar"
---

# El formato CSV

## Qué vas a conseguir

- Comprender qué representa CSV y sus límites.
- Identificar por qué un parser real es preferible a `split`.

## Punto de partida

CSV parece sencillo hasta que un campo contiene comas, comillas, saltos de línea o valores vacíos.

<div class="cla-note"><strong>CSV</strong><p>CSV parece simple, pero quoting, separadores y saltos de línea hacen frágil un parser basado en <code>split</code>.</p></div>

## Conceptos clave

- CSV organiza registros en filas y campos.
- El delimitador, las comillas y las cabeceras forman parte del dialecto del fichero.
- Un parser debe respetar quoting y escaping.

## Ejemplo guiado

```csv
id,nombre,precio
1,Teclado,49.99
2,"Monitor, 27 pulgadas",219.90
```

La segunda fila demuestra por qué `split(",")` no es un parser CSV general.

## Relación con el resto de la ruta

En la próxima lección Apache Commons CSV se encargará de interpretar correctamente esos casos.

## Ejercicios propuestos

1. Crea un CSV con un nombre que contenga una coma.
2. Intenta separarlo con `split(",")` y explica por qué el resultado es incorrecto.

## Qué debes recordar

- CSV tiene reglas de quoting y escaping.
- No asumas que una coma siempre separa campos.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion11/">← 11 · Ejercicio: configuración de aplicación</a>
  <a href="/ficheros/leccion13/">13 · Apache Commons CSV →</a>
</div>
