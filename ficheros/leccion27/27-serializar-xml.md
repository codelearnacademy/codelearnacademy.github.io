---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion27"
lesson_file: "27-serializar-xml"
lesson_number: "27"
title: "Serializar XML"
description: "Serializar XML: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion27/"
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

# Serializar XML

## Qué vas a conseguir

- Serializar una colección Java a XML estable.
- Controlar nombres de elementos y formato legible.

## Punto de partida

Para producir el mismo XML que puedes leer necesitas reutilizar el wrapper y su configuración.

<div class="cla-note"><strong>Serialización XML</strong><p>Escribe y vuelve a leer el documento como prueba básica de que el mapeo XML es simétrico.</p></div>

## Conceptos clave

- El wrapper define la forma externa del documento.
- `writerWithDefaultPrettyPrinter` facilita inspeccionar el XML generado.
- La escritura debe mantener una estructura compatible con la deserialización.

## Ejemplo guiado

```java
ProductosXml data = new ProductosXml();
data.productos = new ArrayList<>(productos);
xmlMapper.writerWithDefaultPrettyPrinter()
         .writeValue(path.toFile(), data);
```

## Relación con el resto de la ruta

Con entrada y salida XML resueltas, la siguiente lección implementa el mismo CRUD que viste en CSV y JSON.

## Ejercicios propuestos

1. Serializa tres productos y abre el XML generado.
2. Vuelve a deserializarlo y compara la lista resultante.

## Qué debes recordar

- Diseña lectura y escritura para la misma estructura XML.
- Un XML “bonito” sigue necesitando ser válido y compatible con el modelo.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion26/">← 26 · Deserializar XML</a>
  <a href="/ficheros/leccion28/">28 · CRUD con XML →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

La escritura se realiza a través del adaptador `DocumentoProductos::new`. `XmlMapper` genera la raíz `<productos>` y los elementos `<producto>` del ejemplo; `saveAll` se encarga de la carpeta y los errores de escritura.

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

**Archivo real: `repository/file/xml/ProductoXmlRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.xml;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.nio.file.Path;

public class ProductoXmlRepository extends AbstractXmlRepository<Producto, Long, DocumentoProductos>
        implements ProductoRepository {
    public ProductoXmlRepository(Path path) { this(path, new XmlMapper()); }
    public ProductoXmlRepository(Path path, XmlMapper mapper) {
        super(path, mapper, DocumentoProductos.class,
              DocumentoProductos::getProductos, DocumentoProductos::new);
    }
    @Override protected Long getId(Producto producto) { return producto.id(); }
}
```

**Prueba:** actualiza un producto, crea otro repositorio apuntando al mismo fichero XML y comprueba los datos.
