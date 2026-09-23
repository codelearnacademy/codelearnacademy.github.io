---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion26"
lesson_file: "26-deserializar-xml"
lesson_number: "26"
title: "Deserializar XML"
description: "Deserializar XML: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion26/"
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

# Deserializar XML

## Qué vas a conseguir

- Deserializar XML a objetos Java.
- Modelar correctamente una colección con elemento raíz.

## Punto de partida

El XML de productos tiene un nodo `<productos>` que no existe en `List<Producto>` por sí solo.

<div class="cla-note"><strong>Deserialización XML</strong><p>Comprueba cómo se mapean la raíz y los elementos repetidos antes de introducir reglas de negocio.</p></div>

## Conceptos clave

- Una clase wrapper representa el elemento raíz.
- `@JacksonXmlElementWrapper(useWrapping = false)` evita un nivel extra de contenedor.
- `@JacksonXmlProperty(localName = "producto")` fija el nombre de cada elemento.

## Ejemplo guiado

```java
@JacksonXmlRootElement(localName = "productos")
public class ProductosXml {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "producto")
    public List<Producto> productos = new ArrayList<>();
}

ProductosXml data = xmlMapper.readValue(path.toFile(), ProductosXml.class);
```

## Relación con el resto de la ruta

La clase wrapper adapta la estructura del formato; la lógica de negocio sigue recibiendo `List<Producto>`.

## Ejercicios propuestos

1. Deserializa dos productos desde XML.
2. Elimina el elemento raíz y observa el error.
3. Cambia `producto` por `item` y ajusta la anotación.

## Qué debes recordar

- Modela explícitamente la raíz y los elementos repetidos.
- Las anotaciones de formato deberían quedar cerca de la capa de adaptación, no de la lógica de negocio.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion25/">← 25 · Jackson XML con Maven</a>
  <a href="/ficheros/leccion27/">27 · Serializar XML →</a>
</div>
