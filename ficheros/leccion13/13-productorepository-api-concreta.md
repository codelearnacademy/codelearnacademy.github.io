---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion13"
lesson_file: "13-productorepository-api-concreta"
lesson_number: "13"
title: "IRepository e IProductoRepository: extraer el contrato CRUD"
description: "Extraer del CsvCrudDemo un contrato CRUD general y especializarlo para Producto."
permalink: "/ficheros/leccion13/"
---

# Del CRUD inicial al contrato del repositorio

## 1. Extraer las operaciones que ya existen

`CsvCrudDemo` ya nos ha dado las cinco operaciones que necesita la aplicación:

```java
findAll()
findById(...)
create(...)
update(...)
delete(...)
```

El primer paso es expresarlas sin hablar de CSV.

```java
package es.educacion.ficheros.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    void create(T entity);

    boolean update(T entity);

    boolean delete(ID id);
}
```

## 2. Especializar el contrato para `Producto`

El proyecto de ejemplo conserva una interfaz de dominio específica:

```java
package es.educacion.ficheros.repository;

import es.educacion.ficheros.model.Producto;

public interface IProductoRepository
        extends IRepository<Producto, Long> {
}
```

Una **interfaz extiende** otra interfaz. Una clase será la que posteriormente la implemente.

```text
IRepository<T, ID>
       ▲
       │ T = Producto
       │ ID = Long
IProductoRepository
```

## ¿Por qué no hay `IOException`?

La aplicación no debería saber cómo se almacena la información. Por eso el contrato no contiene:

```java
throws IOException
```

Si una implementación CSV, JSON o XML tiene un problema de E/S, será esa implementación quien lo controle.

## Mantener la semántica del CRUD inicial

La interfaz conserva la semántica que ya probamos en los demos:

- `create` crea o falla si el identificador está duplicado.
- `update` devuelve `true` si encontró y sustituyó la entidad.
- `delete` devuelve `true` si encontró y eliminó la entidad.
- `findById` devuelve `Optional<T>`.

<div class="cla-note"><strong>Importante</strong><p>La interfaz no añade comportamiento nuevo. Formaliza el CRUD que ya construimos.</p></div>

<div class="cla-lesson-nav"><a href="/ficheros/leccion12/">← 12 · Responsabilidades</a><a href="/ficheros/leccion14/">14 · AbstractFileRepository →</a></div>
