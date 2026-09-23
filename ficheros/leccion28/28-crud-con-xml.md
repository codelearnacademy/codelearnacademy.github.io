---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion28"
lesson_file: "28-crud-con-xml"
lesson_number: "28"
title: "CRUD con XML"
description: "CRUD con XML: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion28/"
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

# CRUD con XML

## Qué vas a conseguir

- Implementar un CRUD XML completo con Jackson XML.
- Usar una clase wrapper para conservar una raíz XML estable.

## Punto de partida

XML necesita representar explícitamente la colección bajo `<productos>` y cada registro como `<producto>`.

<div class="cla-note"><strong>CRUD XML</strong><p>Mantén el wrapper XML dentro de la capa de persistencia para que el resto de la aplicación siga trabajando con <code>Producto</code>.</p></div>

## Conceptos clave

- `ProductosXml` adapta la estructura de la colección.
- `XmlMapper` puede inyectarse por constructor.
- El CRUD trabaja con `List<Producto>` igual que JSON; solo cambia la serialización.

## Ejemplo guiado

### Ejemplo completo: `XmlCrudDemo.java`

Dependencia Maven:

```xml
<dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

```java
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class XmlCrudDemo {
    public record Producto(long id, String nombre, double precio) {}

    @JacksonXmlRootElement(localName = "productos")
    public static class ProductosXml {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "producto")
        public List<Producto> productos = new ArrayList<>();

        public ProductosXml() {}
        public ProductosXml(List<Producto> productos) {
            this.productos = new ArrayList<>(productos);
        }
    }

    private final Path path;
    private final XmlMapper mapper;

    public XmlCrudDemo(Path path, XmlMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }

    public List<Producto> findAll() throws IOException {
        if (Files.notExists(path) || Files.size(path) == 0) return new ArrayList<>();
        ProductosXml data = mapper.readValue(path.toFile(), ProductosXml.class);
        return new ArrayList<>(data.productos);
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
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(path.toFile(), new ProductosXml(items));
    }

    public static void main(String[] args) throws IOException {
        XmlMapper mapper = new XmlMapper();
        XmlCrudDemo repo = new XmlCrudDemo(Path.of("data", "productos.xml"), mapper);
        repo.create(new Producto(1, "Teclado", 49.99));
        repo.create(new Producto(2, "Ratón", 24.90));
        System.out.println(repo.findById(2).orElseThrow());
        repo.update(new Producto(1, "Teclado mecánico", 79.90));
        repo.delete(2);
        repo.findAll().forEach(System.out::println);
    }
}
```

XML generado:

```xml
<productos>
  <producto>
    <id>1</id>
    <nombre>Teclado mecánico</nombre>
    <precio>79.9</precio>
  </producto>
</productos>
```

## Relación con el resto de la ruta

Al terminar este ejemplo ya dispones de CRUD completo en los cuatro tipos de fichero previstos por la ruta.

## Ejercicios propuestos

1. Representa `id` como atributo XML y adapta el modelo.
2. Añade un campo opcional `categoria`.
3. Extrae `XmlProductoRepository` e implementa la interfaz común de la lección 30.

## Qué debes recordar

- El wrapper resuelve la raíz XML; el dominio puede seguir usando `Producto`.
- La API de `XmlMapper` permite reutilizar gran parte del patrón aprendido con JSON.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion27/">← 27 · Serializar XML</a>
  <a href="/ficheros/leccion29/">29 · Ejercicio: catálogo de productos XML →</a>
</div>
