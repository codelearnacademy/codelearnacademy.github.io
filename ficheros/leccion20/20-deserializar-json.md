---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion20"
lesson_file: "20-deserializar-json"
lesson_number: "20"
title: "Deserializar JSON"
description: "Deserializar JSON: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion20/"
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

# Deserializar JSON

## Qué vas a conseguir

- Deserializar un array JSON a `List<Producto>`.
- Entender por qué se usa `TypeReference`.

## Punto de partida

`List.class` conserva el tipo de lista, pero no expresa que sus elementos deben ser `Producto`.

<div class="cla-note"><strong>Deserialización</strong><p>Para colecciones genéricas utiliza información de tipo explícita, por ejemplo <code>TypeReference&lt;List&lt;Producto&gt;&gt;</code>.</p></div>

## Conceptos clave

- `readValue` transforma JSON en objetos Java.
- `TypeReference<List<Producto>>` conserva la información genérica necesaria para Jackson.
- Un JSON sintácticamente válido aún puede ser incompatible con el modelo.

## Ejemplo guiado

```java
List<Producto> productos = mapper.readValue(
        path.toFile(),
        new TypeReference<List<Producto>>() {}
);
```

## Relación con el resto de la ruta

Después de esta lección la aplicación ya puede trabajar con la misma `List<Producto>` que obtuvo desde CSV.

## Ejercicios propuestos

1. Deserializa un fichero con tres productos.
2. Cambia `precio` por un texto no numérico y observa la excepción.
3. Compara el resultado de usar `List.class` con `TypeReference<List<Producto>>`.

## Qué debes recordar

- Los genéricos necesitan información adicional durante la deserialización.
- Valida el modelo además de confiar en la sintaxis JSON.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion19/">← 19 · Jackson con Maven</a>
  <a href="/ficheros/leccion21/">21 · Serializar JSON →</a>
</div>
