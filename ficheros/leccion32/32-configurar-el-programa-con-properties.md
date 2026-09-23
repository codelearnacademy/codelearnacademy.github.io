---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion32"
lesson_file: "32-configurar-el-programa-con-properties"
lesson_number: "32"
title: "Configurar el programa con .properties"
description: "Configurar el programa con .properties: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion32/"
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

# Configurar el programa con .properties

## Qué vas a conseguir

- Usar `.properties` para elegir fichero y formato en tiempo de ejecución.
- Construir el repositorio adecuado a partir de configuración.

## Punto de partida

Hasta ahora elegías la implementación directamente en código; la configuración permite cambiarla sin recompilar.

<div class="cla-note"><strong>Selección por configuración</strong><p><code>.properties</code> puede decidir qué implementación utilizar sin que la lógica principal conozca detalles de cada formato.</p></div>

## Conceptos clave

- `storage.format` puede seleccionar `csv`, `json` o `xml`.
- `storage.path` define la ruta física.
- Una factory sencilla concentra la decisión de qué implementación construir.

## Ejemplo guiado

```properties
storage.format=json
storage.path=data/productos.json
```

```java
CrudRepository<Producto, Long> repository = switch (format) {
    case "csv" -> new CsvProductoRepository(path);
    case "json" -> new JsonProductoRepository(path, new ObjectMapper());
    case "xml" -> new XmlProductoRepository(path, new XmlMapper());
    default -> throw new IllegalArgumentException("Formato no soportado: " + format);
};
```

## Relación con el resto de la ruta

Esta configuración es el punto de entrada del proyecto DataBridge de la siguiente lección.

## Ejercicios propuestos

1. Añade `storage.format` y `storage.path` a tu configuración.
2. Valida que la extensión del fichero sea coherente con el formato elegido.

## Qué debes recordar

- La configuración selecciona componentes; no implementa el CRUD.
- Centraliza la creación de implementaciones en un único lugar.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion31/">← 31 · Repositorios por formato</a>
  <a href="/ficheros/leccion33/">33 · Proyecto final: DataBridge →</a>
</div>
