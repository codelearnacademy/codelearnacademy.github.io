---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion22"
lesson_file: "22-refactorizar-jsoncruddemo"
lesson_number: "22"
title: "Refactorizar JsonCrudDemo: ProductoJsonRepository"
description: "Extraer readAll/writeAll de JsonCrudDemo y reutilizar el CRUD común."
permalink: "/ficheros/leccion22/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: volvemos-a-partir-del-crud
    title: "Volvemos a partir del CRUD"
  - id: implementacion-final
    title: "Implementación final"
  - id: que-se-reutiliza
    title: "Qué se reutiliza"
  - id: el-cliente-no-cambia
    title: "El cliente no cambia"
  - id: microproyecto-adaptador-json
    title: "Microproyecto · Adaptador JSON"
---

# De `JsonCrudDemo` a `ProductoJsonRepository`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/22.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/22.webp' | relative_url }}" alt="Adaptador del formato JSON. El cliente trabaja a través del contrato de repositorio. El código de formato se concentra en el adaptador JSON." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Volvemos a partir del CRUD
{: #volvemos-a-partir-del-crud }

`JsonCrudDemo` repitió `findAll`, `findById`, `create`, `update` y `delete`. Ahora ya sabemos que esa lógica no pertenece a JSON.

Lo específico de JSON es:

```text
ObjectMapper
readAll()
writeAll()
tratamiento de excepciones
```

## Implementación final
{: #implementacion-final }

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
{: #que-se-reutiliza }

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
{: #el-cliente-no-cambia }

```java
IProductoRepository repository =
        new ProductoJsonRepository(
                Path.of("data", "productos.json"));
```

Las operaciones CRUD son las mismas que con CSV.


## Microproyecto · Adaptador JSON
{: #microproyecto-adaptador-json }

A través de un contrato de lectura, recupera nombres de un fichero JSON con un array de cadenas. Un repositorio nuevo devuelve vacío si no hay fichero.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F22-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F22-tarea-01.webp' | relative_url }}" alt="Adaptador JSON. Resultado esperado: Vacío o nombres persistidos" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Vacío o nombres persistidos.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion22/F22-tarea-01.zip' | relative_url }}">Descargar F22-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion21/' | relative_url }}">← 21 · JsonCrudDemo</a><a href="{{ '/ficheros/leccion23/' | relative_url }}">23 · XML →</a></div>
