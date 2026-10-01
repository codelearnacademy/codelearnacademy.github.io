---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion34"
lesson_file: "34-retos-y-ampliaciones"
lesson_number: "34"
title: "Retos y ampliaciones"
description: "Ejercicios para extender la arquitectura manteniendo la separación de responsabilidades."
permalink: "/ficheros/leccion34/"
---

# Retos y ampliaciones

## Retos sobre el diseño

1. Extrae una `RepositoryFactory` para que `main` no contenga el `switch` de formatos.
2. Añade un nuevo modelo `Cliente` con identificador `UUID` y reutiliza `IRepository<T, ID>`.
3. Añade un cuarto formato sin modificar el código consumidor.
4. Introduce validaciones de dominio fuera de las clases de persistencia.
5. Añade pruebas que ejecuten el mismo contrato CRUD contra CSV, JSON y XML.

## Preguntas de revisión

- ¿Qué responsabilidades tenía inicialmente `CsvCrudDemo`?
- ¿Qué clases aparecieron al distribuir esas responsabilidades?
- ¿Qué se mantuvo igual al pasar a `JsonCrudDemo` y `XmlCrudDemo`?
- ¿Por qué `Repository<T, ID>` se introduce después de los ejemplos concretos?
- ¿Qué demuestra `Repository<Vehiculo, String>`?
- ¿Qué decisión sacamos del código gracias a `.properties`?

<div class="cla-lesson-nav"><a href="/ficheros/leccion33/">← 33 · DataBridge</a><a href="/ficheros/">Volver a la ruta →</a></div>
