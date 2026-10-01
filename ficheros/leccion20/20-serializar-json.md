---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion20"
lesson_file: "20-serializar-json"
lesson_number: "20"
title: "Serializar JSON"
description: "Escritura de objetos y listas con Jackson y salida legible."
permalink: "/ficheros/leccion20/"
---

# Serializar JSON

## Qué vas a conseguir

- Guardar `Producto` y `List<Producto>` en JSON.
- Generar salida indentada.
- Reutilizar `ObjectMapper`.

```java
mapper.writerWithDefaultPrettyPrinter()
        .writeValue(Path.of("data/productos.json").toFile(), productos);
```

El mapper se encarga de:

- comillas;
- escapes;
- arrays;
- nombres de propiedades;
- representación numérica.

## Ciclo de ida y vuelta

```text
productos.json → readValue → List<Producto>
List<Producto> → writeValue → productos.json
```

## Ejercicios propuestos

1. Añade un producto y serializa la colección.
2. Vuelve a deserializar el fichero.
3. Compara la representación JSON con el CSV equivalente.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion19/">← 19 · Deserializar JSON</a>
  <a href="/ficheros/leccion21/">21 · CRUD con JSON: JsonCrudDemo →</a>
</div>
