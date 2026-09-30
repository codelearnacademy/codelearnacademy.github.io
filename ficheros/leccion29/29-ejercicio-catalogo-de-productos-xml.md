---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion29"
lesson_file: "29-ejercicio-catalogo-de-productos-xml"
lesson_number: "29"
title: "Ejercicio: catálogo de productos XML con repositorios"
description: "Ejercicio integrador de XML con Producto, wrapper, CRUD, validación y persistencia con Jackson XML."
permalink: "/ficheros/leccion29/"
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

# Ejercicio: catálogo de productos XML

## Qué vas a conseguir

- Consolidar XML manteniendo el mismo modelo `Producto` utilizado en CSV y JSON.
- Trabajar con un wrapper XML sin contaminar el modelo de dominio.
- Completar un CRUD y verificar que el XML resultante puede volver a deserializarse.

## Punto de partida

Ya conoces `XmlMapper` y la serialización de colecciones. El objetivo ahora es construir el mismo catálogo que en CSV y JSON, pero persistido como XML.

<div class="cla-note"><strong>Reto XML</strong><p>El wrapper <code>ProductosXml</code> pertenece a la representación XML. Mantén <code>Producto</code> independiente para poder reutilizarlo en los demás repositorios.</p></div>

## Conceptos clave

- `<productos>` actúa como raíz y `<producto>` como elemento repetido.
- `Producto` sigue teniendo id, nombre, precio y stock.
- Las reglas de validación son las mismas que en los otros formatos.
- El resultado escrito debe poder leerse de nuevo con `XmlMapper`.

## Ejemplo guiado

```xml
<productos>
  <producto>
    <id>1</id>
    <nombre>Teclado</nombre>
    <precio>49.99</precio>
    <stock>10</stock>
  </producto>
  <producto>
    <id>2</id>
    <nombre>Ratón</nombre>
    <precio>24.90</precio>
    <stock>25</stock>
  </producto>
</productos>
```

## Relación con el resto de la ruta

Con esta lección ya has implementado el mismo CRUD con CSV, JSON y XML. El siguiente bloque extraerá la interfaz común que esas implementaciones comparten.

## Ejercicios propuestos

1. Implementa alta, consulta, actualización y eliminación de `Producto`.
2. Impide ids duplicados, precios negativos y stock negativo.
3. Tras cada modificación, vuelve a deserializar el fichero y comprueba el resultado.
4. Añade nombres con caracteres UTF-8 y verifica que sobreviven al ciclo escribir-leer.
5. Compara las operaciones de este repositorio con las de CSV y JSON e identifica qué partes son comunes.

## Qué debes recordar

- El wrapper es una necesidad de la representación XML, no del dominio.
- Mantener `Producto` común permite comparar formatos y preparar una interfaz de repositorio.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion28/">← 28 · CRUD con XML</a>
  <a href="/ficheros/leccion30/">30 · Diseño común para varios formatos →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

### Ejercicio equivalente a CSV y JSON, ahora con XML

Mantén el contrato y el modelo común y añade `AbstractXmlRepository`, `ProductoXmlRepository` y el adaptador `DocumentoProductos`. Esta última clase **no** debe contener operaciones CRUD.

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

**Fichero de ejemplo `productos.xml`**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<productos>
  <producto><id>1</id><nombre>Teclado, mecanico</nombre><precio>29.99</precio><stock>10</stock></producto>
  <producto><id>2</id><nombre>Raton</nombre><precio>15.5</precio><stock>25</stock></producto>
  <producto><id>3</id><nombre>Monitor</nombre><precio>189.99</precio><stock>4</stock></producto>
</productos>
```

**Tareas:** listar, buscar el id 2, comprobar `Optional.empty()` para uno inexistente, crear el id 4, rechazar un id repetido, actualizar el precio, eliminar y volver a abrir el mismo XML para verificar persistencia.

**Ejecuta:** `mvn test` y `mvn exec:java -Dexec.args=xml` en `proyecto-maven/`.
