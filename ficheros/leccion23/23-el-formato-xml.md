---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion23"
lesson_file: "23-el-formato-xml"
lesson_number: "23"
title: "El formato XML"
description: "Estructura jerárquica de XML y diferencias respecto a CSV y JSON."
permalink: "/ficheros/leccion23/"
---

# El formato XML

## Qué vas a conseguir

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

CSV prioriza tablas, JSON objetos/arrays y XML documentos jerárquicos. Nuestro dominio `Producto` permanece igual; cambia la representación externa.

## Ejercicios propuestos

1. Crea un XML con tres productos.
2. Convierte `id` en atributo y compara la legibilidad.
3. Comprueba que las etiquetas estén correctamente cerradas.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion22/">← 22 · Refactorizar JsonCrudDemo</a>
  <a href="/ficheros/leccion24/">24 · Jackson XML y XmlMapper →</a>
</div>
