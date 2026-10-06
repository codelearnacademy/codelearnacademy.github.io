---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion32"
lesson_file: "32-properties-configuracion-repositorio"
lesson_number: "32"
title: ".properties: configuración de los repositorios"
description: "Usar RepositoryConfig para sacar tipos y rutas de fichero fuera del código Java."
permalink: "/ficheros/leccion32/"
---

# Configurar los repositorios con `.properties`

## El problema

Hasta ahora escribimos rutas directamente en Java:

```java
new ProductoCsvRepository(
        Path.of("data", "productos.csv"));
```

Un fichero `.properties` permite sacar esa configuración del código.

## `application.properties`

El proyecto utiliza estas claves:

```properties
# Repositorio de productos
repository.productos.type=csv
repository.productos.path=data/productos.csv

# Repositorio de vehículos
repository.vehiculos.type=json
repository.vehiculos.path=data/vehiculos.json
```

## `RepositoryConfig`

```java
package es.educacion.ficheros.config;

import es.educacion.ficheros.repository.RepositoryException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class RepositoryConfig {

    private final Properties properties = new Properties();

    public RepositoryConfig(Path path) {
        try (InputStream input = Files.newInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RepositoryException(
                    "Error leyendo el fichero de configuración: "
                            + path, e);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException(
                    "No existe la propiedad: " + key);
        }
        return value;
    }

    public Path getPath(String key) {
        return Path.of(get(key));
    }
}
```

Aquí sí se controla `IOException`, porque `RepositoryConfig` es precisamente la clase que conoce el fichero `.properties`.

## Seleccionar una implementación

Sin introducir todavía una factoría obligatoria, podemos construir el repositorio desde la configuración:

```java
RepositoryConfig config = new RepositoryConfig(
        Path.of("src", "main", "resources",
                "application.properties"));

String type = config.get("repository.productos.type");
Path path = config.getPath("repository.productos.path");

IProductoRepository productos = switch (type) {
    case "csv" -> new ProductoCsvRepository(path);
    case "json" -> new ProductoJsonRepository(path);
    case "xml" -> new ProductoXmlRepository(path);
    default -> throw new IllegalArgumentException(
            "Formato no soportado: " + type);
};
```

La selección puede extraerse a una factoría como ampliación posterior, pero no forma parte del núcleo del proyecto de referencia actual.

## Test de configuración

```java
@Test
void debeLeerValoresYPathsDesdeProperties() {
    RepositoryConfig config = new RepositoryConfig(
            Path.of("src", "test", "resources",
                    "test.properties"));

    assertEquals("csv",
            config.get("repository.productos.type"));

    assertEquals(
            Path.of("target", "test-data", "productos-test.csv"),
            config.getPath("repository.productos.path"));
}
```

<div class="cla-lesson-nav"><a href="/ficheros/leccion31/">← 31 · Vehiculo</a><a href="/ficheros/leccion33/">33 · Proyecto final →</a></div>
