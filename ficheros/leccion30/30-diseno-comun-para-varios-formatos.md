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

---

## Ampliación práctica: el mismo catálogo de productos

### Contrato único para tres formatos

**Archivo real: `repository/Repository.java`**

```java
package com.ejemplo.catalogo.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    void create(T entity);
    boolean update(T entity);
    boolean delete(ID id);
}
```

**Archivo real: `repository/ProductoRepository.java`**

```java
package com.ejemplo.catalogo.repository;

import com.ejemplo.catalogo.model.Producto;

public interface ProductoRepository extends Repository<Producto, Long> { }
```

**Archivo real: `repository/file/AbstractFileRepository.java`**

```java
package com.ejemplo.catalogo.repository.file;

import com.ejemplo.catalogo.repository.Repository;
import com.ejemplo.catalogo.repository.RepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** CRUD unico para CSV, JSON y XML. Solo los metodos readAll/writeAll dependen del formato. */
public abstract class AbstractFileRepository<T, ID> implements Repository<T, ID> {
    protected final Path path;

    protected AbstractFileRepository(Path path) {
        this.path = Objects.requireNonNull(path, "path");
    }

    protected abstract List<T> readAll() throws IOException;
    protected abstract void writeAll(List<T> entities) throws IOException;
    protected abstract ID getId(T entity);

    @Override
    public List<T> findAll() {
        if (Files.notExists(path)) return new ArrayList<>();
        try {
            return new ArrayList<>(readAll());
        } catch (IOException e) {
            throw new RepositoryException("Error leyendo el fichero: " + path, e);
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return findAll().stream().filter(entity -> Objects.equals(getId(entity), id)).findFirst();
    }

    @Override
    public void create(T entity) {
        Objects.requireNonNull(entity, "entity");
        List<T> entities = findAll();
        ID id = getId(entity);
        if (entities.stream().anyMatch(current -> Objects.equals(getId(current), id)))
            throw new IllegalArgumentException("Id duplicado: " + id);
        entities.add(entity);
        saveAll(entities);
    }

    @Override
    public boolean update(T entity) {
        Objects.requireNonNull(entity, "entity");
        List<T> entities = findAll();
        ID id = getId(entity);
        for (int i = 0; i < entities.size(); i++) {
            if (Objects.equals(getId(entities.get(i)), id)) {
                entities.set(i, entity);
                saveAll(entities);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(ID id) {
        List<T> entities = findAll();
        boolean removed = entities.removeIf(entity -> Objects.equals(getId(entity), id));
        if (removed) saveAll(entities);
        return removed;
    }

    /** Punto unico de guardado; llama a writeAll dinamicamente segun el formato. */
    protected final void saveAll(List<T> entities) {
        try {
            Path parent = path.toAbsolutePath().getParent();
            if (parent != null) Files.createDirectories(parent);
            writeAll(entities);
        } catch (IOException e) {
            throw new RepositoryException("Error escribiendo el fichero: " + path, e);
        }
    }
}
```

**Diseño:** el cliente programa contra `ProductoRepository`; el código CRUD se escribe **una sola vez** en `AbstractFileRepository`. CSV, JSON y XML implementan la lectura (`readAll`) y la escritura (`writeAll`); `saveAll` queda en la clase base. Este es el patrón del proyecto que acompaña la ruta, y difiere deliberadamente de los `*CrudDemo` monolíticos anteriores.
