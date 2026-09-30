---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion20"
lesson_file: "20-deserializar-json"
lesson_number: "20"
title: "Deserializar JSON"
description: "Deserializar JSON: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion20/"
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

# Deserializar JSON

## Qué vas a conseguir

- Deserializar un array JSON a `List<Producto>`.
- Entender por qué se usa `TypeReference`.

## Punto de partida

`List.class` conserva el tipo de lista, pero no expresa que sus elementos deben ser `Producto`.

<div class="cla-note"><strong>Deserialización</strong><p>Para colecciones genéricas utiliza información de tipo explícita, por ejemplo <code>TypeReference&lt;List&lt;Producto&gt;&gt;</code>.</p></div>

## Conceptos clave

- `readValue` transforma JSON en objetos Java.
- `TypeReference<List<Producto>>` conserva la información genérica necesaria para Jackson.
- Un JSON sintácticamente válido aún puede ser incompatible con el modelo.

## Ejemplo guiado

```java
List<Producto> productos = mapper.readValue(
        path.toFile(),
        new TypeReference<List<Producto>>() {}
);
```

## Relación con el resto de la ruta

Después de esta lección la aplicación ya puede trabajar con la misma `List<Producto>` que obtuvo desde CSV.

## Ejercicios propuestos

1. Deserializa un fichero con tres productos.
2. Cambia `precio` por un texto no numérico y observa la excepción.
3. Compara el resultado de usar `List.class` con `TypeReference<List<Producto>>`.

## Qué debes recordar

- Los genéricos necesitan información adicional durante la deserialización.
- Valida el modelo además de confiar en la sintaxis JSON.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion19/">← 19 · Jackson con Maven</a>
  <a href="/ficheros/leccion21/">21 · Serializar JSON →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

En el primer ejemplo de `JsonCrudDemo` puedes llamar directamente a `mapper.readValue`. En la arquitectura definitiva, la clase abstracta JSON contiene `readAll()` y la clase específica fija el tipo `Producto`.

**Archivo real: `repository/file/json/AbstractJsonRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.json;

import com.ejemplo.catalogo.repository.file.AbstractFileRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Persistencia JSON generica. El TypeReference conserva el tipo de los elementos. */
public abstract class AbstractJsonRepository<T, ID> extends AbstractFileRepository<T, ID> {
    private final ObjectMapper mapper;
    private final TypeReference<List<T>> listType;

    protected AbstractJsonRepository(Path path, ObjectMapper mapper, TypeReference<List<T>> listType) {
        super(path);
        this.mapper = Objects.requireNonNull(mapper, "mapper");
        this.listType = Objects.requireNonNull(listType, "listType");
    }

    @Override
    protected List<T> readAll() throws IOException {
        if (Files.size(path) == 0) return new ArrayList<>();
        List<T> result = mapper.readValue(path.toFile(), listType);
        if (result == null) throw new IOException("El JSON debe contener un array, no null");
        return result;
    }

    @Override
    protected void writeAll(List<T> entities) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), entities);
    }
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

**Recorrido:** `findAll()` → `AbstractFileRepository.findAll()` → `AbstractJsonRepository.readAll()` → `ObjectMapper.readValue()` → `List<Producto>`. El archivo inexistente se resuelve en la clase base; el JSON mal formado produce una excepción, no una lista vacía.
