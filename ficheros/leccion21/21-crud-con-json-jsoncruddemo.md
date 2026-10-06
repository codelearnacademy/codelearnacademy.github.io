---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion21"
lesson_file: "21-crud-con-json-jsoncruddemo"
lesson_number: "21"
title: "CRUD con JSON: JsonCrudDemo"
description: "CRUD completo con Jackson manteniendo JsonCrudDemo como demo previa a la refactorización."
permalink: "/ficheros/leccion21/"
---

# CRUD con JSON: `JsonCrudDemo`

## Qué vas a conseguir

- Implementar un CRUD JSON completo con Jackson.
- Reutilizar `ObjectMapper` mediante inyección por constructor.
- Mantener `JsonCrudDemo` como equivalente directo de `CsvCrudDemo` antes de integrarlo en la arquitectura común.

## Punto de partida

JSON permite serializar directamente `List<Producto>`, por lo que el repositorio resulta más corto que el CSV.

<div class="cla-note"><strong>Mismo modelo didáctico</strong><p>Primero construimos <code>JsonCrudDemo</code> como clase funcional y autocontenida. Las clases nuevas del repositorio JSON aparecerán únicamente en la siguiente lección, como refactorización y distribución de responsabilidades.</p></div>


<div class="cla-note"><strong>Contrato provisional del CRUD.</strong><p>Las demos iniciales mantienen <code>throws IOException</code> porque todavía mezclan aplicación e infraestructura. Durante la refactorización eliminaremos ese detalle de las interfaces y cada repositorio concreto controlará sus errores.</p></div>

## Ejemplo completo: `JsonCrudDemo.java`

Dependencia Maven:

```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

```java
import es.educacion.ficheros.model.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonCrudDemo {

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

## Qué debes recordar

- Reutiliza `ObjectMapper`; no lo recrees dentro de cada operación.
- `TypeReference` es importante para colecciones genéricas.
- En este punto seguimos trabajando con `JsonCrudDemo`; `ProductoJsonRepository` aparecerá como refactorización.

<div class="cla-lesson-nav"><a href="/ficheros/leccion20/">← 20 · Serializar JSON</a><a href="/ficheros/leccion22/">22 · Refactorizar JsonCrudDemo →</a></div>
