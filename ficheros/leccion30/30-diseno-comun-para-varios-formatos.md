---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion30"
lesson_file: "30-diseno-comun-para-varios-formatos"
lesson_number: "30"
title: "Diseño común para varios formatos"
description: "Diseño común para varios formatos: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion30/"
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

# Diseño común para varios formatos

## Qué vas a conseguir

- Identificar qué operaciones son comunes a CSV, JSON y XML.
- Extraer una interfaz solo después de haber implementado varios casos reales.

## Punto de partida

Ahora sí has repetido conscientemente `findAll`, `findById`, `save`, `update` y `delete`; ya existe una razón para abstraer.

<div class="cla-note"><strong>Objetivo de la ruta</strong><p>Aprender el formato sin acoplar toda la aplicación a su parser o serializador.</p></div>

## Conceptos clave

- Una interfaz expresa capacidades comunes, no detalles de parser.
- Cada implementación conserva su dependencia específica.
- La aplicación puede depender de la abstracción en lugar del formato concreto.

## Ejemplo guiado

```java
public interface CrudRepository<T, ID> {
    List<T> findAll() throws IOException;
    Optional<T> findById(ID id) throws IOException;
    void create(T value) throws IOException;
    boolean update(T value) throws IOException;
    boolean deleteById(ID id) throws IOException;
}
```

## Relación con el resto de la ruta

La siguiente lección muestra cómo tres repositorios distintos cumplen este mismo contrato.

## Ejercicios propuestos

1. Compara tus métodos CRUD de CSV, JSON y XML.
2. Adapta sus firmas para que implementen `CrudRepository<Producto, Long>`.

## Qué debes recordar

- Abstrae comportamiento común comprobado, no diferencias imaginarias.
- La interfaz no debe mencionar Jackson, Commons CSV ni XML.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion29/">← 29 · Ejercicio: catálogo de productos XML</a>
  <a href="/ficheros/leccion31/">31 · Repositorios por formato →</a>
</div>
