---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion15"
lesson_file: "15-repositorio-csv-responsabilidades"
lesson_number: "15"
title: "ProductoCsvRepository: implementar CSV"
description: "Extraer del CsvCrudDemo únicamente la lectura y escritura CSV."
permalink: "/ficheros/leccion15/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-queda-del-csvcruddemo
    title: "Qué queda del CsvCrudDemo"
  - id: constructor
    title: "Constructor"
  - id: readall
    title: "readAll()"
  - id: writeall
    title: "writeAll()"
  - id: responsabilidades-despues-de-la-refactorizacion
    title: "Responsabilidades después de la refactorización"
  - id: microproyecto-adaptador-de-lectura-csv
    title: "Microproyecto · Adaptador de lectura CSV"
---

# `ProductoCsvRepository`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/15.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/15.webp' | relative_url }}" alt="Adaptador del formato CSV. El repositorio base coordina el CRUD. La implementación CSV se encarga de transformar registros." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué queda del `CsvCrudDemo`
{: #que-queda-del-csvcruddemo }

El CRUD ya está en `AbstractFileRepository`. La implementación CSV solo necesita resolver:

```java
readAll()
writeAll(...)
```

y controlar los errores de Commons CSV / `Files`.

## Constructor
{: #constructor }

```java
public class ProductoCsvRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {

    public ProductoCsvRepository(Path path) {
        super(path, Producto::id);
        entities = readAll();
    }
}
```

Observa dos decisiones:

```java
Producto::id
```

define cómo obtener el identificador, y:

```java
entities = readAll();
```

lee el fichero **una sola vez al construir el repositorio**.

## `readAll()`
{: #readall }

```java
@Override
protected List<Producto> readAll() {
    if (Files.notExists(path)) {
        return new ArrayList<>();
    }

    try (BufferedReader reader = Files.newBufferedReader(
                path, StandardCharsets.UTF_8);
         CSVParser parser = READ_FORMAT.parse(reader)) {

        List<Producto> productos = new ArrayList<>();

        for (CSVRecord record : parser) {
            productos.add(new Producto(
                    Long.parseLong(record.get("id")),
                    record.get("nombre"),
                    Double.parseDouble(record.get("precio"))
            ));
        }
        return productos;

    } catch (IOException | RuntimeException e) {
        throw new RepositoryException(
                "Error leyendo productos desde CSV: " + path, e);
    }
}
```

## `writeAll()`
{: #writeall }

```java
@Override
protected void writeAll(List<Producto> productos) {
    try {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(
                    path, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(writer, WRITE_FORMAT)) {

            for (Producto producto : productos) {
                printer.printRecord(
                        producto.id(),
                        producto.nombre(),
                        producto.precio());
            }
        }
    } catch (IOException e) {
        throw new RepositoryException(
                "Error escribiendo productos en CSV: " + path, e);
    }
}
```

## Responsabilidades después de la refactorización
{: #responsabilidades-despues-de-la-refactorizacion }

| Elemento | Responsabilidad |
|---|---|
| `CsvCrudDemo` | CRUD monolítico de partida |
| `IRepository<T,ID>` | contrato CRUD general |
| `IProductoRepository` | contrato de dominio para Producto |
| `AbstractFileRepository<T,ID>` | CRUD común y estado en memoria |
| `ProductoCsvRepository` | CSV ↔ `Producto` y errores de E/S |


## Microproyecto · Adaptador de lectura CSV
{: #microproyecto-adaptador-de-lectura-csv }

Extrae los nombres mediante un adaptador CSV. Si el fichero todavía no existe, devuelve una lista vacía.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F15-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F15-tarea-01.webp' | relative_url }}" alt="Adaptador de lectura CSV. Resultado esperado: Vacío al inicio y datos al reabrir" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Vacío al inicio y datos al reabrir.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion15/F15-tarea-01.zip' | relative_url }}">Descargar F15-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion14/' | relative_url }}">← 14 · CRUD común</a><a href="{{ '/ficheros/leccion16/' | relative_url }}">16 · Probar el repositorio CSV →</a></div>
