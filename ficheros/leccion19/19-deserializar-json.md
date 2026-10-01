---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion19"
lesson_file: "19-deserializar-json"
lesson_number: "19"
title: "Deserializar JSON"
description: "Lectura de productos y colecciones desde JSON con TypeReference."
permalink: "/ficheros/leccion19/"
---

# Deserializar JSON

## Qué vas a conseguir

- Leer un objeto JSON.
- Leer `List<Producto>`.
- Distinguir el tipo genérico que Jackson necesita en ejecución.

```java
ObjectMapper mapper = new ObjectMapper();
Path path = Path.of("data/productos.json");

List<Producto> productos = mapper.readValue(
        path.toFile(),
        new TypeReference<List<Producto>>() {}
);
```

## Por qué `TypeReference`

`List<Producto>` contiene información genérica que no puede expresarse con `List.class`. `TypeReference` conserva el tipo de los elementos para Jackson.

## Manejo del fichero inexistente

En un Demo puedes decidir que un fichero inexistente equivale a catálogo vacío:

```java
List<Producto> productos = Files.exists(path)
        ? mapper.readValue(path.toFile(), new TypeReference<>() {})
        : new ArrayList<>();
```

## Ejercicios propuestos

1. Lee tres productos y muéstralos.
2. Cambia un nombre de propiedad y observa el comportamiento.
3. Prueba un número donde esperabas texto.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion18/">← 18 · Jackson Databind y ObjectMapper</a>
  <a href="/ficheros/leccion20/">20 · Serializar JSON →</a>
</div>
