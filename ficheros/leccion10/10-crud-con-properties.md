---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion10"
lesson_file: "10-crud-con-properties"
lesson_number: "10"
title: "CRUD con .properties"
description: "CRUD con .properties: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion10/"
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

# CRUD con .properties

## Qué vas a conseguir

- Reunir lectura, creación, consulta, actualización y borrado sobre `.properties`.
- Disponer de un ejemplo completo ejecutable sin dependencias externas.

## Punto de partida

Este CRUD trata cada clave como una entrada identificable. Es deliberadamente sencillo porque `.properties` se usa aquí como configuración.

<div class="cla-note"><strong>CRUD clave-valor</strong><p>En <code>.properties</code>, crear, actualizar y borrar significa modificar claves y volver a persistir el conjunto.</p></div>

## Conceptos clave

- CREATE usa `setProperty` si la clave no existe.
- READ devuelve `Optional<String>`.
- UPDATE exige que la clave exista; DELETE usa `remove`.
- Cada cambio persistente vuelve a escribir el fichero.

## Ejemplo guiado

### Ejemplo completo: `PropertiesCrudDemo.java`

```java
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Properties;

public class PropertiesCrudDemo {
    private final Path path;

    public PropertiesCrudDemo(Path path) {
        this.path = path;
    }

    private Properties load() throws IOException {
        Properties props = new Properties();
        if (Files.exists(path)) {
            try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                props.load(reader);
            }
        }
        return props;
    }

    private void store(Properties props) throws IOException {
        Path parent = path.getParent();
        if (parent != null) Files.createDirectories(parent);
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            props.store(writer, "Configuración FileLab");
        }
    }

    public void create(String key, String value) throws IOException {
        Properties props = load();
        if (props.containsKey(key)) throw new IllegalArgumentException("Ya existe: " + key);
        props.setProperty(key, value);
        store(props);
    }

    public Optional<String> read(String key) throws IOException {
        return Optional.ofNullable(load().getProperty(key));
    }

    public boolean update(String key, String value) throws IOException {
        Properties props = load();
        if (!props.containsKey(key)) return false;
        props.setProperty(key, value);
        store(props);
        return true;
    }

    public boolean delete(String key) throws IOException {
        Properties props = load();
        if (props.remove(key) == null) return false;
        store(props);
        return true;
    }

    public static void main(String[] args) throws IOException {
        PropertiesCrudDemo crud = new PropertiesCrudDemo(Path.of("data", "config.properties"));
        crud.create("app.name", "FileLab");
        crud.create("server.port", "8080");
        System.out.println(crud.read("app.name").orElse("no existe"));
        crud.update("server.port", "9090");
        crud.delete("app.name");
        System.out.println(crud.read("server.port").orElse("no existe"));
    }
}
```

Resultado final aproximado de `data/config.properties`:

```properties
server.port=9090
```

## Relación con el resto de la ruta

Este es el CRUD completo más simple de la ruta. CSV añadirá colecciones y una librería externa de parsing.

## Ejercicios propuestos

1. Añade `list()` para devolver todas las claves ordenadas.
2. Impide valores vacíos.
3. Añade `getInt(key, defaultValue)` para propiedades numéricas.

## Qué debes recordar

- `.properties` funciona bien para configuración clave-valor, no para entidades complejas.
- Cada mutación debe persistirse si quieres que sobreviva al proceso.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion09/">← 9 · Crear y modificar .properties</a>
  <a href="/ficheros/leccion11/">11 · Ejercicio: configuración de aplicación →</a>
</div>
