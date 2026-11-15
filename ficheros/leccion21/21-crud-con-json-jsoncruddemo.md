---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion21"
lesson_file: "21-crud-con-json-jsoncruddemo"
lesson_number: "21"
title: "CRUD con JSON: JsonCrudDemo"
description: "CRUD completo con Jackson manteniendo JsonCrudDemo como demo previa a la refactorización."
permalink: "/ficheros/leccion21/"
lessons:
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo-completo-jsoncruddemo-java
    title: "Ejemplo completo: JsonCrudDemo.java"
  - id: que-debes-recordar
    title: "Qué debes recordar"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-crud-json
    title: "Microproyecto · CRUD JSON"
---

# CRUD con JSON: `JsonCrudDemo`

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Implementar un CRUD JSON completo con Jackson.
- Reutilizar `ObjectMapper` mediante inyección por constructor.
- Mantener `JsonCrudDemo` como equivalente directo de `CsvCrudDemo` antes de integrarlo en la arquitectura común.

## Punto de partida
{: #punto-de-partida }

JSON permite serializar directamente `List<Producto>`, por lo que el repositorio resulta más corto que el CSV.

<div class="cla-note"><strong>Mismo modelo didáctico</strong><p>Primero construimos <code>JsonCrudDemo</code> como clase funcional y autocontenida. Las clases nuevas del repositorio JSON aparecerán únicamente en la siguiente lección, como refactorización y distribución de responsabilidades.</p></div>


<div class="cla-note"><strong>Contrato provisional del CRUD.</strong><p>Las demos iniciales mantienen <code>throws IOException</code> porque todavía mezclan aplicación e infraestructura. Durante la refactorización eliminaremos ese detalle de las interfaces y cada repositorio concreto controlará sus errores.</p></div>

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/21.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/21.webp' | relative_url }}" alt="CRUD JSON. Actualiza el catálogo mediante su identificador. Comprueba los valores tras guardar y volver a abrir." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo completo: `JsonCrudDemo.java`
{: #ejemplo-completo-jsoncruddemo-java }

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
        if (Files.notExists(path) || Files.size(path) == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(mapper.readValue(
                path.toFile(), new TypeReference<List<Producto>>() {}));
    }

    public Optional<Producto> findById(long id) throws IOException {
        return findAll().stream().filter(p -> p.id() == id).findFirst();
    }

    public void create(Producto producto) throws IOException {
        List<Producto> items = findAll();
        if (items.stream().anyMatch(p -> p.id() == producto.id())) {
            throw new IllegalArgumentException("Id duplicado: " + producto.id());
        }
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
        if (removed) {
            saveAll(items);
        }
        return removed;
    }

    private void saveAll(List<Producto> items) throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
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
{: #que-debes-recordar }

- Reutiliza `ObjectMapper`; no lo recrees dentro de cada operación.
- `TypeReference` es importante para colecciones genéricas.
- En este punto seguimos trabajando con `JsonCrudDemo`; `ProductoJsonRepository` aparecerá como refactorización.


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · CRUD JSON
{: #microproyecto-crud-json }

Sobre un objeto JSON de claves ID y valores nombre, inserta o cambia el valor. Si nombre es nulo, borra la clave. Devuelve el valor anterior o null.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F21-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F21-tarea-01.webp' | relative_url }}" alt="CRUD JSON. Resultado esperado: Cambios persistidos tras releer" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Cambios persistidos tras releer.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion21/F21-tarea-01.zip' | relative_url }}">Descargar F21-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion20/' | relative_url }}">← 20 · Serializar JSON</a><a href="{{ '/ficheros/leccion22/' | relative_url }}">22 · Refactorizar JsonCrudDemo →</a></div>
