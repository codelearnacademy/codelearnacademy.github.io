---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion24"
lesson_file: "24-el-formato-xml"
lesson_number: "24"
title: "El formato XML"
description: "El formato XML: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion24/"
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

# El formato XML

## Qué vas a conseguir

- Reconocer elementos, atributos y jerarquía XML.
- Comparar XML con la representación JSON equivalente.

## Punto de partida

XML añade una estructura basada en etiquetas y puede representar atributos además de elementos.

<div class="cla-note"><strong>XML</strong><p>XML añade elementos raíz y wrappers que no siempre existen en el dominio. Trátalos como detalles de representación.</p></div>

## Conceptos clave

- Un documento XML tiene un único elemento raíz.
- Las colecciones suelen representarse mediante un contenedor y elementos repetidos.
- La estructura XML puede requerir anotaciones específicas al mapear a Java.

## Ejemplo guiado

```xml
<productos>
  <producto>
    <id>1</id>
    <nombre>Teclado</nombre>
    <precio>49.99</precio>
  </producto>
</productos>
```

## Relación con el resto de la ruta

Mantendrás `Producto` y cambiarás `ObjectMapper` por `XmlMapper` más una clase contenedora para la colección.

## Ejercicios propuestos

1. Escribe a mano dos productos dentro de `<productos>`.
2. Representa el id como atributo y compara esa variante con el ejemplo.

## Qué debes recordar

- XML necesita un elemento raíz.
- La forma exacta del XML influye en las anotaciones o wrapper necesarios.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion23/">← 23 · Ejercicio: inventario JSON</a>
  <a href="/ficheros/leccion25/">25 · Jackson XML con Maven →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

XML también utiliza el modelo común `Producto`, pero precisa una representación explícita de la raíz del documento. Esa responsabilidad es de `DocumentoProductos`, una clase de infraestructura que **no** sustituye a la entidad `Producto`.

**Fichero de ejemplo `productos.xml`**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<productos>
  <producto><id>1</id><nombre>Teclado, mecanico</nombre><precio>29.99</precio><stock>10</stock></producto>
  <producto><id>2</id><nombre>Raton</nombre><precio>15.5</precio><stock>25</stock></producto>
  <producto><id>3</id><nombre>Monitor</nombre><precio>189.99</precio><stock>4</stock></producto>
</productos>
```

Compara un elemento `<producto>` con un objeto del array JSON y una línea CSV: el contenido de dominio es el mismo.
