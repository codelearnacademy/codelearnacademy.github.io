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
