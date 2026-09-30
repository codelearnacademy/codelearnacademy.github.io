---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion26"
lesson_file: "26-deserializar-xml"
lesson_number: "26"
title: "Deserializar XML"
description: "Deserializar XML: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion26/"
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

# Deserializar XML

## Qué vas a conseguir

- Deserializar XML a objetos Java.
- Modelar correctamente una colección con elemento raíz.

## Punto de partida

El XML de productos tiene un nodo `<productos>` que no existe en `List<Producto>` por sí solo.

<div class="cla-note"><strong>Deserialización XML</strong><p>Comprueba cómo se mapean la raíz y los elementos repetidos antes de introducir reglas de negocio.</p></div>

## Conceptos clave

- Una clase wrapper representa el elemento raíz.
- `@JacksonXmlElementWrapper(useWrapping = false)` evita un nivel extra de contenedor.
- `@JacksonXmlProperty(localName = "producto")` fija el nombre de cada elemento.

## Ejemplo guiado

```java
@JacksonXmlRootElement(localName = "productos")
public class ProductosXml {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "producto")
    public List<Producto> productos = new ArrayList<>();
}

ProductosXml data = xmlMapper.readValue(path.toFile(), ProductosXml.class);
```

## Relación con el resto de la ruta

La clase wrapper adapta la estructura del formato; la lógica de negocio sigue recibiendo `List<Producto>`.

## Ejercicios propuestos

1. Deserializa dos productos desde XML.
2. Elimina el elemento raíz y observa el error.
3. Cambia `producto` por `item` y ajusta la anotación.

## Qué debes recordar

- Modela explícitamente la raíz y los elementos repetidos.
- Las anotaciones de formato deberían quedar cerca de la capa de adaptación, no de la lógica de negocio.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion25/">← 25 · Jackson XML con Maven</a>
  <a href="/ficheros/leccion27/">27 · Serializar XML →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

`XmlMapper.readValue` convierte el XML a `DocumentoProductos`; un adaptador extrae de este la lista de `Producto`. La clase base resuelve previamente el caso de fichero inexistente.

**Archivo real: `repository/file/xml/AbstractXmlRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.xml;

import com.ejemplo.catalogo.repository.file.AbstractFileRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/** Persistencia XML generica con un documento tipado para raiz y elementos XML. */
public abstract class AbstractXmlRepository<T, ID, D> extends AbstractFileRepository<T, ID> {
    private final XmlMapper mapper;
    private final Class<D> documentType;
    private final Function<D, List<T>> fromDocument;
    private final Function<List<T>, D> toDocument;

    protected AbstractXmlRepository(Path path, XmlMapper mapper, Class<D> documentType,
                                    Function<D, List<T>> fromDocument, Function<List<T>, D> toDocument) {
        super(path);
        this.mapper = Objects.requireNonNull(mapper, "mapper");
        this.documentType = Objects.requireNonNull(documentType, "documentType");
        this.fromDocument = Objects.requireNonNull(fromDocument, "fromDocument");
        this.toDocument = Objects.requireNonNull(toDocument, "toDocument");
    }

    @Override
    protected List<T> readAll() throws IOException {
        if (Files.size(path) == 0) return List.of();
        D document = mapper.readValue(path.toFile(), documentType);
        if (document == null) throw new IOException("Documento XML vacio");
        List<T> result = fromDocument.apply(document);
        return result == null ? List.of() : result;
    }

    @Override
    protected void writeAll(List<T> entities) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), toDocument.apply(entities));
    }
}
```

**Fichero de ejemplo `productos.xml`**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<productos>
  <producto><id>1</id><nombre>Teclado, mecanico</nombre><precio>29.99</precio><stock>10</stock></producto>
  <producto><id>2</id><nombre>Raton</nombre><precio>15.5</precio><stock>25</stock></producto>
  <producto><id>3</id><nombre>Monitor</nombre><precio>189.99</precio><stock>4</stock></producto>
</productos>
```

**Ejercicio:** encuentra dónde se llama a `DocumentoProductos::getProductos`; compara el comportamiento de un fichero inexistente con el de un XML incorrecto.
