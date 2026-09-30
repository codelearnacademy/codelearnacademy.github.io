---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion25"
lesson_file: "25-jackson-xml-con-maven"
lesson_number: "25"
title: "Jackson XML con Maven"
description: "Jackson XML con Maven: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion25/"
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

# Jackson XML con Maven

## Qué vas a conseguir

- Añadir el módulo Jackson XML.
- Crear un `XmlMapper` y entender su relación con Jackson Databind.

## Punto de partida

Jackson XML reutiliza el modelo de mapeo de Jackson pero cambia el formato de entrada y salida.

<div class="cla-note"><strong>Jackson XML</strong><p><code>XmlMapper</code> permite reutilizar gran parte del enfoque aprendido con <code>ObjectMapper</code>.</p></div>

## Conceptos clave

- `jackson-dataformat-xml` añade soporte XML.
- `XmlMapper` ofrece una API muy parecida a `ObjectMapper`.
- Las anotaciones `@JacksonXml...` permiten controlar nombres y wrapping.

## Ejemplo guiado

```xml
<dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

```java
XmlMapper xmlMapper = new XmlMapper();
```

## Relación con el resto de la ruta

La similitud de APIs permite centrarse en las diferencias de estructura XML y no reaprender todo el acceso a ficheros.

## Ejercicios propuestos

1. Añade la dependencia XML junto a Jackson Databind.
2. Crea un `XmlMapper` y serializa un único `Producto`.

## Qué debes recordar

- Jackson XML es un módulo adicional, no parte del JDK.
- No asumas que una lista JSON y una lista XML tienen la misma raíz estructural.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion24/">← 24 · El formato XML</a>
  <a href="/ficheros/leccion26/">26 · Deserializar XML →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

Utiliza la dependencia `jackson-dataformat-xml` ya presente en `proyecto-maven/pom.xml` y la clase `XmlMapper`. La configuración de Maven es compartida por las tres implementaciones.

```xml
<dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

La anotación de la raíz se reserva a `DocumentoProductos`; de ese modo `Producto` no queda acoplado a XML.

**Archivo real: `repository/file/xml/DocumentoProductos.java`**

```java
package com.ejemplo.catalogo.repository.file.xml;

import com.ejemplo.catalogo.model.Producto;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

/** Adaptador exclusivo de XML; Producto sigue sin anotaciones de infraestructura. */
@JacksonXmlRootElement(localName = "productos")
public class DocumentoProductos {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "producto")
    private List<Producto> productos = new ArrayList<>();

    public DocumentoProductos() { }
    public DocumentoProductos(List<Producto> productos) { this.productos = new ArrayList<>(productos); }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
}
```
