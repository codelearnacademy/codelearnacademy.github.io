---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion23"
lesson_file: "23-el-formato-xml"
lesson_number: "23"
title: "El formato XML"
description: "Estructura jerárquica de XML y diferencias respecto a CSV y JSON."
permalink: "/ficheros/leccion23/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: comparacion-conceptual
    title: "Comparación conceptual"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: microproyecto-leer-la-estructura-xml
    title: "Microproyecto · Leer la estructura XML"
---

# El formato XML

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/23.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/23.webp' | relative_url }}" alt="Árbol XML. El documento tiene una raíz y puede contener elementos anidados. La estructura y el cierre de las etiquetas determinan si se puede leer." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Reconocer elementos, atributos, raíz y anidamiento.
- Representar una colección de productos en XML.
- Preparar el uso de Jackson XML.

```xml
<productos>
  <producto>
    <id>1</id>
    <nombre>Teclado</nombre>
    <precio>49.99</precio>
  </producto>
</productos>
```

XML exige un elemento raíz y permite representar la misma información de formas distintas mediante elementos o atributos.

## Comparación conceptual
{: #comparacion-conceptual }

CSV prioriza tablas, JSON objetos/arrays y XML documentos jerárquicos. Nuestro dominio `Producto` permanece igual; cambia la representación externa.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Crea un XML con tres productos.
2. Convierte `id` en atributo y compara la legibilidad.
3. Comprueba que las etiquetas estén correctamente cerradas.


## Microproyecto · Leer la estructura XML
{: #microproyecto-leer-la-estructura-xml }

Lee el nombre del elemento raíz de un documento XML. Propaga IOException cuando falte el fichero o el documento esté mal formado.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F23-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F23-tarea-01.webp' | relative_url }}" alt="Leer la estructura XML. Resultado esperado: catalogo" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** catalogo.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion23/F23-tarea-01.zip' | relative_url }}">Descargar F23-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion22/' | relative_url }}">← 22 · Refactorizar JsonCrudDemo</a>
  <a href="{{ '/ficheros/leccion24/' | relative_url }}">24 · Jackson XML y XmlMapper →</a>
</div>
