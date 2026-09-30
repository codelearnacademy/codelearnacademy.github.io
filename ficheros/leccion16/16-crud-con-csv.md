---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion16"
lesson_file: "16-crud-con-csv"
lesson_number: "16"
title: "CRUD con CSV"
description: "CRUD con CSV: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion16/"
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

# CRUD con CSV

## Qué vas a conseguir

- Implementar un CRUD completo sobre `productos.csv`.
- Usar Commons CSV tanto para lectura como para escritura.

## Punto de partida

El repositorio carga la colección, aplica el cambio y reescribe el fichero. Es apropiado para un ejercicio pequeño, no para millones de registros.

<div class="cla-note"><strong>CRUD CSV</strong><p>Para ficheros pequeños, una estrategia clara es cargar la colección, modificarla y reescribir el documento completo.</p></div>

## Conceptos clave

- `findAll` convierte registros en `Producto`.
- CREATE comprueba ids duplicados.
- UPDATE y DELETE trabajan sobre una lista mutable.
- `saveAll` centraliza la serialización CSV.

## Ejemplo guiado

### Ejemplo completo: `CsvCrudDemo.java`

Dependencia Maven:

```xml
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-csv</artifactId>
  <version>1.11.0</version>
</dependency>
```

```java
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvCrudDemo {
    public record Producto(long id, String nombre, double precio) {}

    private final Path path;
    private final CSVFormat inputFormat = CSVFormat.DEFAULT.builder()
            .setHeader()
            .setSkipHeaderRecord(true)
            .get();
    private final CSVFormat outputFormat = CSVFormat.DEFAULT.builder()
            .setHeader("id", "nombre", "precio")
            .get();

    public CsvCrudDemo(Path path) { this.path = path; }

    public List<Producto> findAll() throws IOException {
        if (Files.notExists(path)) return new ArrayList<>();
        List<Producto> result = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             CSVParser parser = inputFormat.parse(reader)) {
            for (CSVRecord row : parser) {
                result.add(new Producto(
                        Long.parseLong(row.get("id")),
                        row.get("nombre"),
                        Double.parseDouble(row.get("precio"))));
            }
        }
        return result;
    }

    public Optional<Producto> findById(long id) throws IOException {
        return findAll().stream().filter(p -> p.id() == id).findFirst();
    }

    public void create(Producto producto) throws IOException {
        List<Producto> items = findAll();
        if (items.stream().anyMatch(p -> p.id() == producto.id()))
            throw new IllegalArgumentException("Id duplicado: " + producto.id());
        items.add(producto);
        saveAll(items);
    }

    public boolean update(Producto producto) throws IOException {
        List<Producto> items = findAll();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id() == producto.id()) {
                items.set(i, producto);
                saveAll(items);
                return true;
            }
        }
        return false;
    }

    public boolean delete(long id) throws IOException {
        List<Producto> items = findAll();
        boolean removed = items.removeIf(p -> p.id() == id);
        if (removed) saveAll(items);
        return removed;
    }

    private void saveAll(List<Producto> items) throws IOException {
        Path parent = path.getParent();
        if (parent != null) Files.createDirectories(parent);
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(writer, outputFormat)) {
            for (Producto p : items) printer.printRecord(p.id(), p.nombre(), p.precio());
        }
    }

    public static void main(String[] args) throws IOException {
        CsvCrudDemo repo = new CsvCrudDemo(Path.of("data", "productos.csv"));
        repo.create(new Producto(1, "Teclado", 49.99));
        repo.create(new Producto(2, "Monitor, 27 pulgadas", 219.90));
        System.out.println(repo.findById(2).orElseThrow());
        repo.update(new Producto(1, "Teclado mecánico", 79.90));
        repo.delete(2);
        repo.findAll().forEach(System.out::println);
    }
}
```

El nombre con coma demuestra que `CSVPrinter` aplica quoting correctamente.

## Relación con el resto de la ruta

El mismo patrón CRUD reaparecerá en JSON, pero allí Jackson serializará la colección completa sin cabeceras ni columnas.

## Ejercicios propuestos

1. Añade validación de precio no negativo.
2. Implementa `findByName(String text)` ignorando mayúsculas/minúsculas.
3. Crea una copia de seguridad antes de `saveAll`.

## Qué debes recordar

- CSV se reescribe para actualizar o eliminar en este ejemplo.
- Commons CSV debe encargarse de quoting y escapes; no construyas filas a mano.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion15/">← 15 · Escribir objetos a CSV</a>
  <a href="/ficheros/leccion17/">17 · Ejercicio: catálogo de productos CSV →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

**Dos niveles didácticos:** `CsvCrudDemo` (incluido arriba) permite entender una clase que hace todo. En el proyecto con repositorios, el mismo CRUD deja de repetirse por formato: reside en `AbstractFileRepository`.

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

**Flujo de `create`:** `ProductoRepository.create` → `AbstractFileRepository.create` (verifica id y modifica la lista obtenida) → `saveAll` → `AbstractCsvRepository.writeAll` → `productos.csv`.

**Flujo de `findById`:** `Repository.findById` → `AbstractFileRepository.findById` → `findAll` → `readAll` de CSV → compara el id → devuelve `Optional`.

Los archivos completos y las pruebas están en [`proyecto-maven`](../../proyecto-maven/). Todos los ejemplos de repositorios de esta ampliación usan el `record Producto(long id, String nombre, double precio, int stock)`; el `*CrudDemo` previo es un ejemplo monolítico introductorio y no debe mezclarse con las clases de la arquitectura de repositorios.
