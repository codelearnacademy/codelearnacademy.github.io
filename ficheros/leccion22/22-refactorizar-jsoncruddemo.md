---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion22"
lesson_file: "22-refactorizar-jsoncruddemo"
lesson_number: "22"
title: "Refactorizar JsonCrudDemo: ProductoJsonRepository"
description: "Integración de JSON en la arquitectura común como refactorización de JsonCrudDemo."
permalink: "/ficheros/leccion22/"
---

# Refactorizar `JsonCrudDemo` hacia `ProductoJsonRepository`

## Punto de partida

`JsonCrudDemo` ya funciona. No lo renombramos sin más. Ahora extraemos de él únicamente la responsabilidad específica de JSON y la conectamos con las responsabilidades separadas durante el bloque CSV.

## Clases nuevas como resultado de la refactorización

- `ProductoJsonRepository`: configuración del tipo `Producto` y extracción de su identificador, y lectura y escritura JSON mediante `ObjectMapper`.

El CRUD **no se vuelve a escribir**: se reutiliza desde `AbstractFileRepository`.

```text
JsonCrudDemo
   │
   │ analizamos y extraemos
   ▼
ProductoJsonRepository
```

La aplicación puede instanciar:

```java
IProductoRepository repository =
        new ProductoJsonRepository(Path.of("data", "productos.json"));
```

El código consumidor conserva la misma API utilizada con CSV.

<div class="cla-note"><strong>Distribución de responsabilidades</strong><p><code>JsonCrudDemo</code> se conserva como demo monolítica. <code>ProductoJsonRepository</code> es una clase nueva creada durante la refactorización; no es un cambio de nombre de la demo.</p></div>

<div class="cla-lesson-nav"><a href="/ficheros/leccion21/">← 21 · JsonCrudDemo</a><a href="/ficheros/leccion23/">23 · XML →</a></div>
