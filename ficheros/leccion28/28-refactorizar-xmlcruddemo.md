---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion28"
lesson_file: "28-refactorizar-xmlcruddemo"
lesson_number: "28"
title: "Refactorizar XmlCrudDemo: ProductoXmlRepository"
description: "Extraer readAll/writeAll de XmlCrudDemo y reutilizar el CRUD común."
permalink: "/ficheros/leccion28/"
---

# De `XmlCrudDemo` a `ProductoXmlRepository`

## Partimos otra vez de un CRUD funcional

`XmlCrudDemo` demostró que el CRUD es el mismo y que XML añade una necesidad propia: una raíz `<productos>` con elementos `<producto>`.

La refactorización conserva únicamente lo específico del formato:

- `XmlMapper`.
- el wrapper XML.
- `readAll()`.
- `writeAll()`.
- el control de excepciones.

## Implementación

```java
public class ProductoXmlRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {

    private final XmlMapper mapper = XmlMapper.builder()
            .defaultUseWrapper(false)
            .build();

    public ProductoXmlRepository(Path path) {
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

            ProductosXml data = mapper.readValue(
                    path.toFile(), ProductosXml.class);

            return data.getProductos() == null
                    ? new ArrayList<>()
                    : new ArrayList<>(data.getProductos());

        } catch (IOException | RuntimeException e) {
            throw new RepositoryException(
                    "Error leyendo productos desde XML: " + path, e);
        }
    }

    @Override
    protected void writeAll(List<Producto> productos) {
        try {
            Path parent = path.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(
                            path.toFile(),
                            new ProductosXml(productos));

        } catch (IOException e) {
            throw new RepositoryException(
                    "Error escribiendo productos en XML: " + path, e);
        }
    }
}
```

El wrapper `ProductosXml` pertenece a la implementación XML, no al `record Producto`.

## Misma API

```java
IProductoRepository repository =
        new ProductoXmlRepository(
                Path.of("data", "productos.xml"));
```

El código consumidor continúa utilizando las cinco operaciones del CRUD inicial.

<div class="cla-lesson-nav"><a href="/ficheros/leccion27/">← 27 · XmlCrudDemo</a><a href="/ficheros/leccion29/">29 · Comparar implementaciones →</a></div>
