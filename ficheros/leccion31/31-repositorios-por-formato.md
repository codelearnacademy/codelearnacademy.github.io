---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion31"
lesson_file: "31-repositorios-por-formato"
lesson_number: "31"
title: "Repositorios por formato"
description: "Repositorios por formato: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion31/"
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

# Repositorios por formato

## Qué vas a conseguir

- Organizar implementaciones por formato detrás de una interfaz.
- Inyectar las dependencias de parsing por constructor.

## Punto de partida

El objetivo no es esconder que existen formatos, sino impedir que la lógica de negocio tenga que conocer sus APIs.

<div class="cla-note"><strong>Objetivo de la ruta</strong><p>Aprender el formato sin acoplar toda la aplicación a su parser o serializador.</p></div>

## Conceptos clave

- `CsvProductoRepository` recibe `Path` y configuración CSV.
- `JsonProductoRepository` puede recibir `Path` y `ObjectMapper`.
- `XmlProductoRepository` puede recibir `Path` y `XmlMapper`.

## Ejemplo guiado

```java
public final class JsonProductoRepository implements CrudRepository<Producto, Long> {
    private final Path path;
    private final ObjectMapper mapper;

    public JsonProductoRepository(Path path, ObjectMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }
    // implementación CRUD...
}
```

## Relación con el resto de la ruta

Esto introduce inyección por constructor sin Spring: la clase declara lo que necesita y otra parte crea los objetos.

## Ejercicios propuestos

1. Haz que el repositorio JSON reciba su mapper por constructor.
2. Haz lo mismo con `XmlMapper`.
3. Explica qué ventaja tiene en tests poder pasar otra instancia configurada.

## Qué debes recordar

- Inyección de dependencias no significa necesariamente usar un framework.
- La construcción de dependencias puede quedar fuera de la clase que las usa.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion30/">← 30 · Diseño común para varios formatos</a>
  <a href="/ficheros/leccion32/">32 · Configurar el programa con .properties →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

### Tres implementaciones del mismo contrato

**Archivo real: `repository/file/csv/ProductoCsvRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.csv;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import org.apache.commons.csv.CSVRecord;
import java.nio.file.Path;

public class ProductoCsvRepository extends AbstractCsvRepository<Producto, Long> implements ProductoRepository {
    public ProductoCsvRepository(Path path) {
        super(path, "id", "nombre", "precio", "stock");
    }
    @Override protected Producto fromCsv(CSVRecord record) {
        return new Producto(Long.parseLong(record.get("id")), record.get("nombre"),
                Double.parseDouble(record.get("precio")), Integer.parseInt(record.get("stock")));
    }
    @Override protected Object[] toCsv(Producto p) {
        return new Object[]{p.id(), p.nombre(), p.precio(), p.stock()};
    }
    @Override protected Long getId(Producto p) { return p.id(); }
}
```

**Archivo real: `repository/file/json/ProductoJsonRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.json;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.util.List;

public class ProductoJsonRepository extends AbstractJsonRepository<Producto, Long> implements ProductoRepository {
    public ProductoJsonRepository(Path path) { this(path, new ObjectMapper()); }
    public ProductoJsonRepository(Path path, ObjectMapper mapper) {
        super(path, mapper, new TypeReference<List<Producto>>() {});
    }
    @Override protected Long getId(Producto producto) { return producto.id(); }
}
```

**Archivo real: `repository/file/xml/ProductoXmlRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.xml;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.nio.file.Path;

public class ProductoXmlRepository extends AbstractXmlRepository<Producto, Long, DocumentoProductos>
        implements ProductoRepository {
    public ProductoXmlRepository(Path path) { this(path, new XmlMapper()); }
    public ProductoXmlRepository(Path path, XmlMapper mapper) {
        super(path, mapper, DocumentoProductos.class,
              DocumentoProductos::getProductos, DocumentoProductos::new);
    }
    @Override protected Long getId(Producto producto) { return producto.id(); }
}
```

**Práctica:** cambia únicamente la construcción del repositorio y ejecuta las mismas operaciones del catálogo sobre los tres formatos. Los tests parametrizados del proyecto comprueban que el comportamiento CRUD sea equivalente.
