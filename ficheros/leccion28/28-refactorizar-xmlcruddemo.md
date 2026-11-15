---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion28"
lesson_file: "28-refactorizar-xmlcruddemo"
lesson_number: "28"
title: "Refactorizar XmlCrudDemo: ProductoXmlRepository"
description: "Extraer readAll/writeAll de XmlCrudDemo y reutilizar el CRUD común."
permalink: "/ficheros/leccion28/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: partimos-otra-vez-de-un-crud-funcional
    title: "Partimos otra vez de un CRUD funcional"
  - id: implementacion
    title: "Implementación"
  - id: misma-api
    title: "Misma API"
  - id: microproyecto-adaptador-xml
    title: "Microproyecto · Adaptador XML"
---

# De `XmlCrudDemo` a `ProductoXmlRepository`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/28.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/28.webp' | relative_url }}" alt="Adaptador del formato XML. El CRUD común se mantiene en el repositorio base. El adaptador interpreta la estructura del documento." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Partimos otra vez de un CRUD funcional
{: #partimos-otra-vez-de-un-crud-funcional }

`XmlCrudDemo` demostró que el CRUD es el mismo y que XML añade una necesidad propia: una raíz `<productos>` con elementos `<producto>`.

La refactorización conserva únicamente lo específico del formato:

- `XmlMapper`.
- el wrapper XML.
- `readAll()`.
- `writeAll()`.
- el control de excepciones.

## Implementación
{: #implementacion }

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
{: #misma-api }

```java
IProductoRepository repository =
        new ProductoXmlRepository(
                Path.of("data", "productos.xml"));
```

El código consumidor continúa utilizando las cinco operaciones del CRUD inicial.


## Microproyecto · Adaptador XML
{: #microproyecto-adaptador-xml }

Extrae los nombres de los elementos nombre. En el repositorio nuevo, un fichero ausente representa una lista vacía.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F28-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F28-tarea-01.webp' | relative_url }}" alt="Adaptador XML. Resultado esperado: Vacío y después A recuperable" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Vacío y después A recuperable.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion28/F28-tarea-01.zip' | relative_url }}">Descargar F28-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion27/' | relative_url }}">← 27 · XmlCrudDemo</a><a href="{{ '/ficheros/leccion29/' | relative_url }}">29 · Comparar implementaciones →</a></div>
