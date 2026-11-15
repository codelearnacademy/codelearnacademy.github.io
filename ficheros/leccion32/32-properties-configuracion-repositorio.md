---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion32"
lesson_file: "32-properties-configuracion-repositorio"
lesson_number: "32"
title: ".properties: configuración de los repositorios"
description: "Usar RepositoryConfig para sacar tipos y rutas de fichero fuera del código Java."
permalink: "/ficheros/leccion32/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: el-problema
    title: "El problema"
  - id: application-properties
    title: "application.properties"
  - id: repositoryconfig
    title: "RepositoryConfig"
  - id: seleccionar-una-implementacion
    title: "Seleccionar una implementación"
  - id: test-de-configuracion
    title: "Test de configuración"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-resolver-configuracion
    title: "Microproyecto · Resolver configuración"
---

# Configurar los repositorios con `.properties`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/32.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/32.webp' | relative_url }}" alt="Configuración → fichero. Lee el formato y la ruta en properties. Explicita la base respecto a la que se resuelve la ruta de datos." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## El problema
{: #el-problema }

Hasta ahora escribimos rutas directamente en Java:

```java
new ProductoCsvRepository(
        Path.of("data", "productos.csv"));
```

Un fichero `.properties` permite sacar esa configuración del código.

## `application.properties`
{: #application-properties }

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
{: #repositoryconfig }

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
{: #seleccionar-una-implementacion }

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
{: #test-de-configuracion }

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


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · Resolver configuración
{: #microproyecto-resolver-configuracion }

Lee repository.type y repository.path. Admite csv, json y xml. Resuelve la ruta respecto a la carpeta del properties. Rechaza formato desconocido.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F32-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F32-tarea-01.webp' | relative_url }}" alt="Resolver configuración. Resultado esperado: Ruta absoluta de datos" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Ruta absoluta de datos.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion32/F32-tarea-01.zip' | relative_url }}">Descargar F32-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion31/' | relative_url }}">← 31 · Vehiculo</a><a href="{{ '/ficheros/leccion33/' | relative_url }}">33 · Proyecto final →</a></div>
