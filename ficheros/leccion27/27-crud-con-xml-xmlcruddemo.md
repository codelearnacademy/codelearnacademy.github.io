---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion27"
lesson_file: "27-crud-con-xml-xmlcruddemo"
lesson_number: "27"
title: "CRUD con XML: XmlCrudDemo"
description: "CRUD completo con Jackson XML manteniendo XmlCrudDemo como demo previa a la refactorización."
permalink: "/ficheros/leccion27/"
---

# CRUD con XML: `XmlCrudDemo`

## Qué vas a conseguir

- Implementar un CRUD XML completo con Jackson XML.
- Usar una clase wrapper para conservar una raíz XML estable.
- Mantener `XmlCrudDemo` como tercer ejemplo monolítico antes de refactorizar.

## Punto de partida

XML necesita representar explícitamente la colección bajo `<productos>` y cada registro como `<producto>`.

<div class="cla-note"><strong>Mismo modelo didáctico</strong><p><code>XmlCrudDemo</code> se construye primero como clase completa, igual que <code>CsvCrudDemo</code> y <code>JsonCrudDemo</code>. Las clases del repositorio XML se extraen después.</p></div>

## Ejemplo completo: `XmlCrudDemo.java`

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
    public static class DocumentoProductos {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "producto")
        public List<Producto> productos = new ArrayList<>();

        public DocumentoProductos() {}
        public DocumentoProductos(List<Producto> productos) {
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
        DocumentoProductos data = mapper.readValue(path.toFile(), DocumentoProductos.class);
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
              .writeValue(path.toFile(), new DocumentoProductos(items));
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

## Qué debes recordar

- El wrapper resuelve la raíz XML; el dominio puede seguir usando `Producto`.
- `XmlMapper` permite reutilizar gran parte del patrón aprendido con JSON.
- `XmlCrudDemo` permanece como demo; la arquitectura se extrae en el siguiente paso.

<div class="cla-lesson-nav"><a href="/ficheros/leccion26/">← 26 · Serializar XML</a><a href="/ficheros/leccion28/">28 · Refactorizar XmlCrudDemo →</a></div>
