---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion26"
lesson_file: "26-serializar-xml"
lesson_number: "26"
title: "Serializar XML"
description: "Escritura de colecciones de productos con XmlMapper y wrapper de documento."
permalink: "/ficheros/leccion26/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: simetria
    title: "Simetría"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: microproyecto-exportar-xml
    title: "Microproyecto · Exportar XML"
---

# Serializar XML

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/26.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/26.webp' | relative_url }}" alt="Java → XML. Una raíz agrupa los elementos repetidos. El escritor escapa caracteres especiales del contenido." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Crear `DocumentoProductos` desde una lista.
- Escribir XML indentado.
- Mantener la representación XML fuera del dominio.

```java
DocumentoProductos documento = new DocumentoProductos(productos);

mapper.writerWithDefaultPrettyPrinter()
      .writeValue(Path.of("data/productos.xml").toFile(), documento);
```

## Simetría
{: #simetria }

```text
XML → XmlMapper → DocumentoProductos → List<Producto>
List<Producto> → DocumentoProductos → XmlMapper → XML
```

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Serializa una lista vacía.
2. Serializa nombres con caracteres UTF-8.
3. Vuelve a leer el XML generado y compara los productos.


## Microproyecto · Exportar XML
{: #microproyecto-exportar-xml }

Exporta una raíz catalogo con un elemento nombre por cadena. Respeta acentos y escapa caracteres XML.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F26-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F26-tarea-01.webp' | relative_url }}" alt="Exportar XML. Resultado esperado: A &amp; B se recupera como texto" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** A & B se recupera como texto.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion26/F26-tarea-01.zip' | relative_url }}">Descargar F26-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion25/' | relative_url }}">← 25 · Deserializar XML</a>
  <a href="{{ '/ficheros/leccion27/' | relative_url }}">27 · CRUD con XML: XmlCrudDemo →</a>
</div>
