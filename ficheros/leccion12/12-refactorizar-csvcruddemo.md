---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion12"
lesson_file: "12-refactorizar-csvcruddemo"
lesson_number: "12"
title: "Refactorizar CsvCrudDemo: separar responsabilidades"
description: "Análisis del CsvCrudDemo original y primer paso de refactorización sin adelantar la abstracción genérica."
permalink: "/ficheros/leccion12/"
---

# Refactorizar `CsvCrudDemo`: detectar responsabilidades

## Qué vas a conseguir

- Partir exactamente de `CsvCrudDemo`, sin sustituirlo por otra clase de demostración.
- Identificar qué partes pertenecen al dominio, al CRUD y al formato CSV.
- Entender que los nombres y clases que aparecen a partir de ahora son **resultado de una refactorización**.

## Antes de cambiar el código

`CsvCrudDemo` mezcla cinco responsabilidades: ejecutar el ejemplo, representar `Producto`, resolver el CRUD, leer/escribir CSV y gestionar errores de fichero.

<div class="cla-note"><strong>Importante</strong><p>No presentamos las nuevas clases como si siempre hubieran existido. El cambio de nombre, la extracción de interfaces y la creación de clases abstractas forman parte del proceso de refactorización y distribución de responsabilidades.</p></div>

## Primer objetivo de la refactorización

```text
CsvCrudDemo
 ├─ modelo Producto
 ├─ operaciones CRUD
 ├─ lectura/escritura CSV
 ├─ ruta del fichero
 └─ main de demostración
```

Queremos llegar progresivamente a responsabilidades separadas, pero cada paso debe conservar el comportamiento del ejemplo original.

## Qué no hacemos todavía

Todavía no generalizamos a `Repository<T, ID>`. Primero extraeremos una API concreta de productos y el comportamiento común. La generalización con `T` e `ID` llegará después de haber trabajado CSV, JSON y XML y poder justificarla por repetición real.

## Siguiente paso

La primera extracción será `IProductoRepository`: una API que expresa qué operaciones necesita la aplicación sin conocer todavía Commons CSV.

<div class="cla-lesson-nav"><a href="/ficheros/leccion11/">← 11 · CsvCrudDemo</a><a href="/ficheros/leccion13/">13 · IProductoRepository →</a></div>
