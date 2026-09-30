---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion15"
lesson_file: "15-escribir-objetos-a-csv"
lesson_number: "15"
title: "Escribir objetos a CSV"
description: "Escribir objetos a CSV: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion15/"
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

# Escribir objetos a CSV

## Qué vas a conseguir

- Serializar `Producto` a CSV.
- Escribir cabeceras y campos con `CSVPrinter`.

## Punto de partida

Construir líneas con concatenación manual reintroduce los problemas de escaping que el parser resolvía al leer.

<div class="cla-note"><strong>Escritura CSV</strong><p><code>CSVPrinter</code> debe responsabilizarse de escapar valores; tu código solo aporta los campos que quiere persistir.</p></div>

## Conceptos clave

- `CSVPrinter` escapa correctamente los valores.
- El orden de columnas debe ser estable.
- Escribir una colección suele reemplazar el fichero completo en ejemplos pequeños.

## Ejemplo guiado

```java
CSVFormat format = CSVFormat.DEFAULT.builder()
        .setHeader("id", "nombre", "precio")
        .get();
try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
     CSVPrinter printer = new CSVPrinter(writer, format)) {
    for (Producto p : productos) {
        printer.printRecord(p.id(), p.nombre(), p.precio());
    }
}
```

## Relación con el resto de la ruta

Ya puedes leer y escribir el mismo modelo; la siguiente lección reúne ambas operaciones en un CRUD completo.

## Ejercicios propuestos

1. Escribe tres productos y vuelve a leerlos.
2. Incluye un producto con una coma en el nombre y comprueba el CSV generado.

## Qué debes recordar

- Usa el writer de la librería para conservar las reglas del formato.
- Comprueba la ida y vuelta: escribir y volver a leer.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion14/">← 14 · Leer CSV a objetos Java</a>
  <a href="/ficheros/leccion16/">16 · CRUD con CSV →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

A diferencia del ejemplo directo con `CSVPrinter`, el proyecto completo separa la escritura genérica en `AbstractCsvRepository.writeAll` y el mapeo del dominio en `ProductoCsvRepository.toCsv`.

**Archivo real: `repository/file/csv/AbstractCsvRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.csv;

import com.ejemplo.catalogo.repository.file.AbstractFileRepository;
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

public abstract class AbstractCsvRepository<T, ID> extends AbstractFileRepository<T, ID> {
    private final CSVFormat inputFormat;
    private final CSVFormat outputFormat;

    protected AbstractCsvRepository(Path path, String... headers) {
        super(path);
        inputFormat = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).get();
        outputFormat = CSVFormat.DEFAULT.builder().setHeader(headers).get();
    }
    protected abstract T fromCsv(CSVRecord record);
    protected abstract Object[] toCsv(T entity);

    @Override
    protected List<T> readAll() throws IOException {
        List<T> result = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             CSVParser parser = inputFormat.parse(reader)) {
            for (CSVRecord record : parser) result.add(fromCsv(record));
        }
        return result;
    }

    @Override
    protected void writeAll(List<T> entities) throws IOException {
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(writer, outputFormat)) {
            for (T entity : entities) printer.printRecord(toCsv(entity));
        }
    }
}
```

**Prueba:** crea un producto, reconstruye el repositorio con el mismo `Path` y comprueba que sigue presente.
