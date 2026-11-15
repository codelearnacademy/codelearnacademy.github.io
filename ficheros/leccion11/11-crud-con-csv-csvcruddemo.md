---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion11"
lesson_file: "11-crud-con-csv-csvcruddemo"
lesson_number: "11"
title: "CRUD con CSV: CsvCrudDemo"
description: "CRUD completo con Commons CSV manteniendo CsvCrudDemo como ejemplo monolítico previo a la refactorización."
permalink: "/ficheros/leccion11/"
lessons:
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: conceptos-clave
    title: "Conceptos clave"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo-completo-csvcruddemo-java
    title: "Ejemplo completo: CsvCrudDemo.java"
  - id: que-esta-concentrando-esta-clase
    title: "Qué está concentrando esta clase"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: que-debes-recordar
    title: "Qué debes recordar"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-crud-en-csv
    title: "Microproyecto · CRUD en CSV"
---

# CRUD con CSV: `CsvCrudDemo`

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Implementar un CRUD completo sobre `productos.csv`.
- Usar Commons CSV tanto para lectura como para escritura.
- Mantener `CsvCrudDemo` como ejemplo monolítico antes de iniciar la refactorización.

## Punto de partida
{: #punto-de-partida }

El repositorio carga la colección, aplica el cambio y reescribe el fichero. Es apropiado para un ejercicio pequeño, no para millones de registros.

<div class="cla-note"><strong>Antes de refactorizar</strong><p>En esta lección no cambiamos todavía nombres ni creamos capas. <code>CsvCrudDemo</code> concentra intencionadamente lectura, escritura, CRUD y acceso al fichero. En las siguientes lecciones utilizaremos este código funcional para detectar responsabilidades y extraerlas.</p></div>


<div class="cla-note"><strong>Contrato provisional del CRUD.</strong><p>Las demos iniciales mantienen <code>throws IOException</code> porque todavía mezclan aplicación e infraestructura. Durante la refactorización eliminaremos ese detalle de las interfaces y cada repositorio concreto controlará sus errores.</p></div>

## Conceptos clave
{: #conceptos-clave }

- `findAll` convierte registros en `Producto`.
- CREATE comprueba ids duplicados.
- UPDATE y DELETE trabajan sobre una lista mutable.
- `saveAll` centraliza la serialización CSV.

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/11.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/11.webp' | relative_url }}" alt="CRUD sobre fichero. Carga el catálogo, identifica el registro y aplica el cambio. Guarda y reabre para distinguir el estado persistido del estado en memoria." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo completo: `CsvCrudDemo.java`
{: #ejemplo-completo-csvcruddemo-java }

Dependencia Maven:

```xml
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-csv</artifactId>
  <version>1.11.0</version>
</dependency>
```

```java
import es.educacion.ficheros.model.Producto;
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
        if (Files.notExists(path)) {
            return new ArrayList<>();
        }
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
        if (items.stream().anyMatch(p -> p.id() == producto.id())) {
            throw new IllegalArgumentException("Id duplicado: " + producto.id());
        }
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
        if (removed) {
            saveAll(items);
        }
        return removed;
    }

    private void saveAll(List<Producto> items) throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(writer, outputFormat)) {
            for (Producto p : items) {
                printer.printRecord(p.id(), p.nombre(), p.precio());
            }
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

## Qué está concentrando esta clase
{: #que-esta-concentrando-esta-clase }

`CsvCrudDemo` funciona, pero una sola clase conoce el CRUD, Commons CSV, el fichero, el mapeo y el modelo. No lo corregimos todavía dentro de esta lección: **ese será el punto de partida de la refactorización**.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Añade validación de precio no negativo.
2. Implementa `findByName(String text)` ignorando mayúsculas/minúsculas.
3. Crea una copia de seguridad antes de `saveAll`.

## Qué debes recordar
{: #que-debes-recordar }

- CSV se reescribe para actualizar o eliminar en este ejemplo.
- Commons CSV debe encargarse de quoting y escapes; no construyas filas a mano.
- `CsvCrudDemo` se mantiene como el ejemplo previo a la distribución de responsabilidades.


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · CRUD en CSV
{: #microproyecto-crud-en-csv }

Da de alta un ID nuevo con nombre, actualiza un ID existente con nombre y da de baja el ID si el nombre es nulo. El CSV contiene id,nombre. Devuelve el nombre anterior o null si estaba ausente.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F11-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F11-tarea-01.webp' | relative_url }}" alt="CRUD en CSV. Resultado esperado: Alta, cambio y baja conservados" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Alta, cambio y baja conservados.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion11/F11-tarea-01.zip' | relative_url }}">Descargar F11-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion10/' | relative_url }}">← 10 · Escribir objetos a CSV</a><a href="{{ '/ficheros/leccion12/' | relative_url }}">12 · Refactorizar CsvCrudDemo →</a></div>
