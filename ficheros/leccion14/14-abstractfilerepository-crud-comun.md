---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion14"
lesson_file: "14-abstractfilerepository-crud-comun"
lesson_number: "14"
title: "AbstractFileRepository: CRUD común en memoria"
description: "Extraer el CRUD común y dejar readAll/writeAll como únicos puntos dependientes del formato."
permalink: "/ficheros/leccion14/"
---

# `AbstractFileRepository<T, ID>`

## De dónde sale

En `CsvCrudDemo`, `create`, `update`, `delete` y `findById` trabajan sobre una colección. El formato solo determina cómo convertir entre esa colección y el fichero.

La clase abstracta del proyecto final es:

```java
package es.educacion.ficheros.repository;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public abstract class AbstractFileRepository<T, ID>
        implements IRepository<T, ID> {

    protected final Path path;
    protected List<T> entities;

    private final Function<T, ID> idExtractor;

    protected AbstractFileRepository(
            Path path,
            Function<T, ID> idExtractor) {

        this.path = path;
        this.idExtractor = idExtractor;
        this.entities = new ArrayList<>();
    }

    protected abstract List<T> readAll();

    protected abstract void writeAll(List<T> entities);

    @Override
    public List<T> findAll() {
        return List.copyOf(entities);
    }

    @Override
    public Optional<T> findById(ID id) {
        return entities.stream()
                .filter(entity -> Objects.equals(
                        idExtractor.apply(entity), id))
                .findFirst();
    }

    @Override
    public void create(T entity) {
        ID id = idExtractor.apply(entity);

        if (findById(id).isPresent()) {
            throw new IllegalArgumentException(
                    "Ya existe una entidad con identificador: " + id);
        }

        List<T> updated = new ArrayList<>(entities);
        updated.add(entity);
        persist(updated);
    }

    @Override
    public boolean update(T entity) {
        ID id = idExtractor.apply(entity);
        List<T> updated = new ArrayList<>(entities);

        for (int i = 0; i < updated.size(); i++) {
            if (Objects.equals(
                    idExtractor.apply(updated.get(i)), id)) {
                updated.set(i, entity);
                persist(updated);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(ID id) {
        List<T> updated = new ArrayList<>(entities);

        boolean removed = updated.removeIf(entity ->
                Objects.equals(idExtractor.apply(entity), id));

        if (removed) {
            persist(updated);
        }
        return removed;
    }

    private void persist(List<T> updated) {
        writeAll(updated);
        entities = new ArrayList<>(updated);
    }
}
```

## Solo dos métodos abstractos

```java
protected abstract List<T> readAll();
protected abstract void writeAll(List<T> entities);
```

La clase abstracta **no declara ni captura `IOException`**. CSV, JSON y XML controlarán sus propias excepciones.

## El fichero se carga una sola vez

`AbstractFileRepository` mantiene la colección `entities` en memoria. Cada repositorio concreto hará en su constructor:

```java
entities = readAll();
```

A partir de ahí:

```text
constructor → readAll() → entities
                       ↓
               CRUD sobre memoria
                       ↓
          writeAll() cuando hay cambios
```

## ¿Por qué usamos `Function<T, ID>`?

No todas las entidades tienen un método `getId()`:

```java
Producto::id
Vehiculo::matricula
```

El extractor permite definir qué campo identifica cada tipo sin imponer una interfaz al modelo.

## Una decisión importante en `persist`

Primero se escribe la copia y después se sustituye el estado en memoria:

```java
writeAll(updated);
entities = new ArrayList<>(updated);
```

Si `writeAll` falla con `RepositoryException`, `entities` conserva el estado anterior.

<div class="cla-lesson-nav"><a href="/ficheros/leccion13/">← 13 · Contratos</a><a href="/ficheros/leccion15/">15 · ProductoCsvRepository →</a></div>
