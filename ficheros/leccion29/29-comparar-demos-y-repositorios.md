---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion29"
lesson_file: "29-comparar-demos-y-repositorios"
lesson_number: "29"
title: "Comparar CRUD y repositorios de Producto"
description: "Relacionar cada demo monolítica con su implementación final de IProductoRepository."
permalink: "/ficheros/leccion29/"
---

# Tres CRUD de partida, una arquitectura

## Demos iniciales

```text
CsvCrudDemo   → Commons CSV
JsonCrudDemo  → ObjectMapper
XmlCrudDemo   → XmlMapper
```

Cada demo contiene un CRUD completo. Eso nos permitió descubrir qué se repetía antes de abstraer.

## Repositorios resultantes

```text
IProductoRepository
       ▲
       │
AbstractFileRepository<Producto, Long>
       ▲
 ┌─────┼──────────────┐
 │     │              │
CSV   JSON            XML
 │     │              │
ProductoCsvRepository
ProductoJsonRepository
ProductoXmlRepository
```

## Qué cambia

| Responsabilidad | CSV | JSON | XML |
|---|---|---|---|
| Lectura | `CSVParser` | `ObjectMapper` | `XmlMapper` |
| Escritura | `CSVPrinter` | `ObjectMapper` | `XmlMapper` + wrapper |
| Excepciones E/S | implementación CSV | implementación JSON | implementación XML |
| CRUD | `AbstractFileRepository` | `AbstractFileRepository` | `AbstractFileRepository` |
| API | `IProductoRepository` | `IProductoRepository` | `IProductoRepository` |

## Una consecuencia del modelo en memoria

Cada constructor ejecuta `readAll()` una sola vez:

```java
entities = readAll();
```

Si otro proceso modifica el fichero después, el objeto repositorio no se actualiza automáticamente. Para volver a leer el contenido habría que crear otra instancia o diseñar explícitamente una operación de recarga.

<div class="cla-note"><strong>Ahora debemos probar la generalidad</strong><p>Una abstracción creada solo para Producto todavía puede estar demasiado ligada a Producto. El siguiente paso es usar la misma infraestructura con otra entidad.</p></div>

<div class="cla-lesson-nav"><a href="/ficheros/leccion28/">← 28 · ProductoXmlRepository</a><a href="/ficheros/leccion30/">30 · Modelo Vehiculo →</a></div>
