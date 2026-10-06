---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion22"
lesson_file: "22-refactorizar-jsoncruddemo"
lesson_number: "22"
title: "Refactorizar JsonCrudDemo: ProductoJsonRepository"
description: "Extraer readAll/writeAll de JsonCrudDemo y reutilizar el CRUD común."
permalink: "/ficheros/leccion22/"
---

# De `JsonCrudDemo` a `ProductoJsonRepository`

## Volvemos a partir del CRUD

`JsonCrudDemo` repitió `findAll`, `findById`, `create`, `update` y `delete`. Ahora ya sabemos que esa lógica no pertenece a JSON.

Lo específico de JSON es:

```text
ObjectMapper
readAll()
writeAll()
tratamiento de excepciones
```

## Implementación final

```java
public class ProductoJsonRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {

    private final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public ProductoJsonRepository(Path path) {
        super(path, Producto::id);
        entities = readAll();
    }

    @Override
    protected List<Producto> readAll() {
        if (Files.notExists(path)) {
            return new ArrayList<>();
        }

        try {
            if (Files.size(path) == 0) {
                return new ArrayList<>();
            }

            return mapper.readValue(
                    path.toFile(),
                    new TypeReference<List<Producto>>() {});

        } catch (IOException | RuntimeException e) {
            throw new RepositoryException(
                    "Error leyendo productos desde JSON: " + path, e);
        }
    }

    @Override
    protected void writeAll(List<Producto> productos) {
        try {
            Path parent = path.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }

            mapper.writeValue(path.toFile(), productos);

        } catch (IOException e) {
            throw new RepositoryException(
                    "Error escribiendo productos en JSON: " + path, e);
        }
    }
}
```

## Qué se reutiliza

No hemos vuelto a implementar:

```java
findAll
findById
create
update
delete
```

Todos proceden de `AbstractFileRepository`.

## El cliente no cambia

```java
IProductoRepository repository =
        new ProductoJsonRepository(
                Path.of("data", "productos.json"));
```

Las operaciones CRUD son las mismas que con CSV.

<div class="cla-lesson-nav"><a href="/ficheros/leccion21/">← 21 · JsonCrudDemo</a><a href="/ficheros/leccion23/">23 · XML →</a></div>
