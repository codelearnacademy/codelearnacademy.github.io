---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion25"
lesson_file: "25-deserializar-xml"
lesson_number: "25"
title: "Deserializar XML"
description: "Lectura de DocumentoProductos y extracción de List<Producto> con XmlMapper."
permalink: "/ficheros/leccion25/"
---

# Deserializar XML

## Qué vas a conseguir

- Leer un documento XML con Jackson.
- Obtener la colección de dominio.
- Aislar el wrapper de representación.

```java
XmlMapper mapper = new XmlMapper();
DocumentoProductos documento = mapper.readValue(
        Path.of("data/productos.xml").toFile(),
        DocumentoProductos.class
);

List<Producto> productos = documento.productos();
```

## Fichero inexistente

Al igual que en JSON, el Demo puede trabajar con una lista vacía cuando todavía no existe el fichero.

## Ejercicios propuestos

1. Lee dos productos.
2. Cambia el nombre del elemento `producto` y adapta la anotación.
3. Elimina el elemento raíz y observa el error de parsing.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion24/">← 24 · Jackson XML y XmlMapper</a>
  <a href="/ficheros/leccion26/">26 · Serializar XML →</a>
</div>
