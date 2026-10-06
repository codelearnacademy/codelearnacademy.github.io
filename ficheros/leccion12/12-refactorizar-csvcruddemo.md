---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion12"
lesson_file: "12-refactorizar-csvcruddemo"
lesson_number: "12"
title: "Refactorizar CsvCrudDemo: detectar responsabilidades"
description: "Partir del CRUD CSV funcional para separar dominio, contrato, CRUD común y persistencia."
permalink: "/ficheros/leccion12/"
---

# Refactorizar `CsvCrudDemo`: partir de un CRUD que ya funciona

## Punto de partida

En la lección anterior construimos `CsvCrudDemo` con un CRUD completo. Esa clase es importante: **la arquitectura no aparece antes del problema**, sino después de tener un ejemplo que funciona.

`CsvCrudDemo` concentra:

```text
CsvCrudDemo
 ├─ Path del fichero
 ├─ Commons CSV
 ├─ conversión CSV ↔ Producto
 ├─ findAll / findById
 ├─ create / update / delete
 └─ tratamiento de IOException
```

El objetivo de la refactorización es conservar el mismo comportamiento y repartir responsabilidades.

## Qué se repite en el CRUD

Las operaciones del demo tienen una estructura común:

```text
leer colección
    ↓
buscar / añadir / sustituir / eliminar
    ↓
escribir colección cuando hay cambios
```

La sintaxis CSV solo afecta a dos operaciones:

```text
readAll()   fichero → List<Producto>
writeAll()  List<Producto> → fichero
```

Esta observación será la base de `AbstractFileRepository`.

## Qué queremos conseguir

La evolución será:

```text
CsvCrudDemo
    ↓ separar contrato
IRepository<T, ID>
    ↓ especializar para Producto
IProductoRepository
    ↓ extraer CRUD común
AbstractFileRepository<T, ID>
    ↓ dejar solo lo específico de CSV
ProductoCsvRepository
```

<div class="cla-note"><strong>Regla de la ruta</strong><p>Cada nueva abstracción debe poder relacionarse con código que ya existía en el CRUD inicial.</p></div>

## Las excepciones también cambian de lugar

En el demo es normal ver:

```java
public List<Producto> findAll() throws IOException
```

En la arquitectura final, las interfaces no expondrán `IOException`. Cada implementación concreta de fichero controlará sus errores de E/S y los transformará en `RepositoryException`.

Eso permite que la aplicación utilice un repositorio sin conocer si detrás hay CSV, JSON o XML.

<div class="cla-lesson-nav"><a href="/ficheros/leccion11/">← 11 · CsvCrudDemo</a><a href="/ficheros/leccion13/">13 · IRepository e IProductoRepository →</a></div>
