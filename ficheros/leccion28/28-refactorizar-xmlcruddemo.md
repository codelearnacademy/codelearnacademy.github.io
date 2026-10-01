---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion28"
lesson_file: "28-refactorizar-xmlcruddemo"
lesson_number: "28"
title: "Refactorizar XmlCrudDemo: ProductoXmlRepository"
description: "Integración de XML en la arquitectura común como refactorización de XmlCrudDemo."
permalink: "/ficheros/leccion28/"
---

# Refactorizar `XmlCrudDemo` hacia `ProductoXmlRepository`

## Punto de partida

`XmlCrudDemo` contiene el CRUD, `XmlMapper`, el wrapper XML y el acceso al fichero. Como en CSV y JSON, ahora distribuimos esas responsabilidades.

## Clases nuevas durante la refactorización

- `ProductoXmlRepository`: adapta el modelo `Producto`, y sabe transformar el documento XML en una colección y viceversa
- `DocumentoProductos`: representa el documento/raíz XML cuando la implementación separada lo necesita.

```text
XmlCrudDemo
   │
   │ extraemos responsabilidades
   ▼
ProductoXmlRepository
DocumentoProductos
```

La aplicación vuelve a depender del mismo contrato concreto:

```java
IProductoRepository repository =
        new ProductoXmlRepository(Path.of("data", "productos.xml"));
```

<div class="cla-note"><strong>No es un simple cambio de nombre</strong><p><code>XmlCrudDemo</code> continúa siendo el ejemplo autocontenido. Las nuevas clases existen porque hemos repartido sus responsabilidades entre contrato, CRUD común, formato XML y mapeo de dominio.</p></div>

<div class="cla-lesson-nav"><a href="/ficheros/leccion27/">← 27 · XmlCrudDemo</a><a href="/ficheros/leccion29/">29 · Comparar los tres formatos →</a></div>
