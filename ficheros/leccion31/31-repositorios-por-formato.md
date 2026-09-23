---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion31"
lesson_file: "31-repositorios-por-formato"
lesson_number: "31"
title: "Repositorios por formato"
description: "Repositorios por formato: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion31/"
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

# Repositorios por formato

## Qué vas a conseguir

- Organizar implementaciones por formato detrás de una interfaz.
- Inyectar las dependencias de parsing por constructor.

## Punto de partida

El objetivo no es esconder que existen formatos, sino impedir que la lógica de negocio tenga que conocer sus APIs.

<div class="cla-note"><strong>Objetivo de la ruta</strong><p>Aprender el formato sin acoplar toda la aplicación a su parser o serializador.</p></div>

## Conceptos clave

- `CsvProductoRepository` recibe `Path` y configuración CSV.
- `JsonProductoRepository` puede recibir `Path` y `ObjectMapper`.
- `XmlProductoRepository` puede recibir `Path` y `XmlMapper`.

## Ejemplo guiado

```java
public final class JsonProductoRepository implements CrudRepository<Producto, Long> {
    private final Path path;
    private final ObjectMapper mapper;

    public JsonProductoRepository(Path path, ObjectMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }
    // implementación CRUD...
}
```

## Relación con el resto de la ruta

Esto introduce inyección por constructor sin Spring: la clase declara lo que necesita y otra parte crea los objetos.

## Ejercicios propuestos

1. Haz que el repositorio JSON reciba su mapper por constructor.
2. Haz lo mismo con `XmlMapper`.
3. Explica qué ventaja tiene en tests poder pasar otra instancia configurada.

## Qué debes recordar

- Inyección de dependencias no significa necesariamente usar un framework.
- La construcción de dependencias puede quedar fuera de la clase que las usa.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion30/">← 30 · Diseño común para varios formatos</a>
  <a href="/ficheros/leccion32/">32 · Configurar el programa con .properties →</a>
</div>
