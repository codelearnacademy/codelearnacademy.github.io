---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion09"
lesson_file: "09-crear-y-modificar-properties"
lesson_number: "9"
title: "Crear y modificar .properties"
description: "Crear y modificar .properties: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion09/"
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

# Crear y modificar .properties

## Qué vas a conseguir

- Crear y actualizar un fichero `.properties`.
- Persistir cambios con `store`.

## Punto de partida

Modificar el objeto `Properties` solo cambia la memoria; debes volver a escribir para persistir.

<div class="cla-note"><strong>Persistencia</strong><p>Modificar un objeto <code>Properties</code> en memoria no modifica el fichero hasta llamar a <code>store</code>.</p></div>

## Conceptos clave

- `setProperty` crea o reemplaza una clave.
- `remove` elimina una entrada.
- `store(Writer, comentario)` serializa el estado actual.

## Ejemplo guiado

```java
Properties props = new Properties();
props.setProperty("app.name", "FileLab");
props.setProperty("server.port", "8080");
try (Writer writer = Files.newBufferedWriter(Path.of("config.properties"), StandardCharsets.UTF_8)) {
    props.store(writer, "Configuración de la aplicación");
}
```

## Relación con el resto de la ruta

Con lectura y escritura disponibles, la siguiente lección reúne las cuatro operaciones CRUD en un ejemplo completo.

## Ejercicios propuestos

1. Crea un fichero con tres propiedades.
2. Cambia el puerto, elimina una clave y vuelve a cargar el fichero para comprobar el resultado.

## Qué debes recordar

- Cambiar `Properties` no cambia el fichero hasta llamar a `store`.
- Las claves deberían tener nombres estables y descriptivos.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion08/">← 8 · Leer .properties</a>
  <a href="/ficheros/leccion10/">10 · CRUD con .properties →</a>
</div>
