---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion18"
lesson_file: "18-el-formato-json"
lesson_number: "18"
title: "El formato JSON"
description: "El formato JSON: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion18/"
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

# El formato JSON

## Qué vas a conseguir

- Reconocer estructuras JSON: objeto, array, número, texto, booleano y null.
- Relacionar JSON con objetos y colecciones Java.

## Punto de partida

A diferencia de CSV, JSON representa estructuras jerárquicas y conserva tipos básicos.

<div class="cla-note"><strong>JSON</strong><p>JSON representa objetos y colecciones de forma jerárquica; Jackson realizará el mapeo entre esa estructura y Java.</p></div>

## Conceptos clave

- Un objeto JSON usa pares nombre-valor.
- Un array JSON encaja naturalmente con una colección.
- JSON no necesita cabecera porque cada propiedad tiene nombre.

## Ejemplo guiado

```json
[
  {"id": 1, "nombre": "Teclado", "precio": 49.99},
  {"id": 2, "nombre": "Ratón", "precio": 24.90}
]
```

## Relación con el resto de la ruta

El mismo `Producto` de CSV podrá reutilizarse; solo cambia la herramienta que transforma el fichero.

## Ejercicios propuestos

1. Representa tres productos en un array JSON.
2. Añade una propiedad booleana y otra opcional con `null` y analiza cómo cambiaría el modelo Java.

## Qué debes recordar

- JSON puede expresar jerarquías que CSV representa con más dificultad.
- La forma del JSON debe ser compatible con el modelo que quieres deserializar.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion17/">← 17 · Ejercicio: catálogo de productos CSV</a>
  <a href="/ficheros/leccion19/">19 · Jackson con Maven →</a>
</div>
