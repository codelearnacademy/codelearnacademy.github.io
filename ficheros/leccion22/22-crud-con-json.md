---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion22"
lesson_file: "22-crud-con-json"
lesson_number: "22"
title: "CRUD con JSON"
description: "CRUD con JSON: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion22/"
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

# CRUD con JSON

## Qué vas a conseguir

- Implementar un CRUD JSON completo con Jackson.
- Reutilizar `ObjectMapper` mediante inyección por constructor.

## Punto de partida

JSON permite serializar directamente `List<Producto>`, por lo que el repositorio resulta más corto que el CSV.

<div class="cla-note"><strong>CRUD JSON</strong><p>El repositorio debe ocuparse de persistir; las reglas como precio o stock válidos pertenecen a la lógica del dominio.</p></div>

## Conceptos clave

- `TypeReference` preserva `List<Producto>` al leer.
- El repositorio recibe un `ObjectMapper` ya creado.
- CREATE, UPDATE y DELETE modifican la lista y llaman a `saveAll`.

## Ejemplo guiado

### Ejemplo completo: `JsonCrudDemo.java`

Dependencia Maven:

```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonCrudDemo {
    public record Producto(long id, String nombre, double precio) {}

    private final Path path;
    private final ObjectMapper mapper;

    public JsonCrudDemo(Path path, ObjectMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }

    public List<Producto> findAll() throws IOException {
        if (Files.notExists(path) || Files.size(path) == 0) return new ArrayList<>();
        return new ArrayList<>(mapper.readValue(
                path.toFile(), new TypeReference<List<Producto>>() {}));
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
        mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), items);
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonCrudDemo repo = new JsonCrudDemo(Path.of("data", "productos.json"), mapper);
        repo.create(new Producto(1, "Teclado", 49.99));
        repo.create(new Producto(2, "Ratón", 24.90));
        System.out.println(repo.findById(1).orElseThrow());
        repo.update(new Producto(1, "Teclado mecánico", 79.90));
        repo.delete(2);
        repo.findAll().forEach(System.out::println);
    }
}
```

JSON generado:

```json
[ {
  "id" : 1,
  "nombre" : "Teclado mecánico",
  "precio" : 79.9
} ]
```

## Relación con el resto de la ruta

El repositorio JSON muestra claramente la ventaja del mapeo objeto-documento. XML mantendrá una API similar, pero necesitará modelar su elemento raíz.

## Ejercicios propuestos

1. Añade `stock` al producto.
2. Configura el mapper para fallar ante propiedades desconocidas y prueba un JSON incompatible.
3. Extrae una clase `JsonProductoRepository` sin método `main`.

## Qué debes recordar

- Reutiliza `ObjectMapper`; no lo recrees dentro de cada operación.
- `TypeReference` es importante para colecciones genéricas.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion21/">← 21 · Serializar JSON</a>
  <a href="/ficheros/leccion23/">23 · Ejercicio: inventario JSON →</a>
</div>
