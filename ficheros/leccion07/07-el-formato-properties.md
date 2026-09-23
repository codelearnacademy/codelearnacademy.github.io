---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion07"
lesson_file: "07-el-formato-properties"
lesson_number: "7"
title: "El formato .properties"
description: "El formato .properties: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion07/"
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

# El formato .properties

## Qué vas a conseguir

- Reconocer la estructura clave-valor de `.properties`.
- Decidir cuándo este formato es adecuado.

## Punto de partida

`.properties` está pensado principalmente para configuración sencilla, no para colecciones complejas.

<div class="cla-note"><strong>.properties</strong><p>Este formato está orientado a configuración clave-valor; no lo fuerces para representar colecciones complejas.</p></div>

## Conceptos clave

- Cada entrada utiliza una clave y un valor textual.
- Los comentarios comienzan con `#` o `!`.
- `java.util.Properties` forma parte del JDK y no necesita dependencia externa.

## Ejemplo guiado

```properties
app.name=FileLab
app.mode=dev
server.port=8080
export.format=json
```

## Relación con el resto de la ruta

Es el primer formato porque permite practicar persistencia sin añadir todavía una librería externa.

## Ejercicios propuestos

1. Crea un `config.properties` con nombre de aplicación, puerto y formato de salida.
2. Identifica qué valores necesitarán conversión a `int` o `boolean`.

## Qué debes recordar

- Los valores de `Properties` son texto.
- Úsalo para configuración simple, no como sustituto de una base de datos.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion06/">← 6 · Modelo común Producto</a>
  <a href="/ficheros/leccion08/">8 · Leer .properties →</a>
</div>
