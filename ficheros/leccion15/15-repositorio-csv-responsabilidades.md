---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion15"
lesson_file: "15-repositorio-csv-responsabilidades"
lesson_number: "15"
title: "ProductoCsvRepository: implementar CSV"
description: "Extraer del CsvCrudDemo únicamente la lectura y escritura CSV."
permalink: "/ficheros/leccion15/"
---

# `ProductoCsvRepository`

## Qué queda del `CsvCrudDemo`

El CRUD ya está en `AbstractFileRepository`. La implementación CSV solo necesita resolver:

```java
readAll()
writeAll(...)
```

y controlar los errores de Commons CSV / `Files`.

## Constructor

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

| Elemento | Responsabilidad |
|---|---|
| `CsvCrudDemo` | CRUD monolítico de partida |
| `IRepository<T,ID>` | contrato CRUD general |
| `IProductoRepository` | contrato de dominio para Producto |
| `AbstractFileRepository<T,ID>` | CRUD común y estado en memoria |
| `ProductoCsvRepository` | CSV ↔ `Producto` y errores de E/S |

<div class="cla-lesson-nav"><a href="/ficheros/leccion14/">← 14 · CRUD común</a><a href="/ficheros/leccion16/">16 · Probar el repositorio CSV →</a></div>
