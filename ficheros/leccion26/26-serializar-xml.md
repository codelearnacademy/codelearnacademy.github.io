---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion26"
lesson_file: "26-serializar-xml"
lesson_number: "26"
title: "Serializar XML"
description: "Escritura de colecciones de productos con XmlMapper y wrapper de documento."
permalink: "/ficheros/leccion26/"
---

# Serializar XML

## Qué vas a conseguir

- Crear `DocumentoProductos` desde una lista.
- Escribir XML indentado.
- Mantener la representación XML fuera del dominio.

```java
DocumentoProductos documento = new DocumentoProductos(productos);

mapper.writerWithDefaultPrettyPrinter()
      .writeValue(Path.of("data/productos.xml").toFile(), documento);
```

## Simetría

```text
XML → XmlMapper → DocumentoProductos → List<Producto>
List<Producto> → DocumentoProductos → XmlMapper → XML
```

## Ejercicios propuestos

1. Serializa una lista vacía.
2. Serializa nombres con caracteres UTF-8.
3. Vuelve a leer el XML generado y compara los productos.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion25/">← 25 · Deserializar XML</a>
  <a href="/ficheros/leccion27/">27 · CRUD con XML: XmlCrudDemo →</a>
</div>
