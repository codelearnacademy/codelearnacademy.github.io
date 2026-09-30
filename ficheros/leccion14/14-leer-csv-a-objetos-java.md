---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion14"
lesson_file: "14-leer-csv-a-objetos-java"
lesson_number: "14"
title: "Leer CSV a objetos Java"
description: "Leer CSV a objetos Java: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion14/"
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

# Leer CSV a objetos Java

## Qué vas a conseguir

- Convertir filas CSV a `Producto`.
- Validar números y campos obligatorios durante el mapeo.

## Punto de partida

Un `CSVRecord` contiene texto; el dominio necesita `long`, `double` y reglas de validación.

<div class="cla-note"><strong>Mapeo</strong><p>Convierte cada <code>CSVRecord</code> en un <code>Producto</code> en un punto bien definido para aislar la representación externa.</p></div>

## Conceptos clave

- El mapeo convierte representación externa en modelo Java.
- `Long.parseLong` y `Double.parseDouble` pueden fallar.
- Un error debería indicar al menos la fila o el dato que no pudo convertirse.

## Ejemplo guiado

```java
private static Producto toProducto(CSVRecord row) {
    long id = Long.parseLong(row.get("id"));
    String nombre = row.get("nombre").trim();
    double precio = Double.parseDouble(row.get("precio"));
    return new Producto(id, nombre, precio);
}
```

## Relación con el resto de la ruta

Una vez que CSV puede convertirse a objetos, la lógica de negocio puede trabajar con `Producto` sin conocer filas ni columnas.

## Ejercicios propuestos

1. Mapea cinco filas a `List<Producto>`.
2. Añade una fila con `precio=abc` y mejora el mensaje de error incluyendo el número de registro.

## Qué debes recordar

- Parsear CSV y mapear a dominio son pasos diferentes.
- Añade contexto a los errores de conversión.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion13/">← 13 · Apache Commons CSV</a>
  <a href="/ficheros/leccion15/">15 · Escribir objetos a CSV →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

El ejercicio introductorio de lectura prepara la implementación por repositorios. En el proyecto completo, `AbstractCsvRepository` recorre las filas mediante Commons CSV y delega la creación de cada producto en `ProductoCsvRepository.fromCsv`.

**Archivo real: `repository/file/csv/ProductoCsvRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.csv;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import org.apache.commons.csv.CSVRecord;
import java.nio.file.Path;

public class ProductoCsvRepository extends AbstractCsvRepository<Producto, Long> implements ProductoRepository {
    public ProductoCsvRepository(Path path) {
        super(path, "id", "nombre", "precio", "stock");
    }
    @Override protected Producto fromCsv(CSVRecord record) {
        return new Producto(Long.parseLong(record.get("id")), record.get("nombre"),
                Double.parseDouble(record.get("precio")), Integer.parseInt(record.get("stock")));
    }
    @Override protected Object[] toCsv(Producto p) {
        return new Object[]{p.id(), p.nombre(), p.precio(), p.stock()};
    }
    @Override protected Long getId(Producto p) { return p.id(); }
}
```

**Fichero de ejemplo `productos.csv`**

```csv
id,nombre,precio,stock
1,"Teclado, mecanico",29.99,10
2,Raton,15.5,25
3,Monitor,189.99,4
```

**Comprueba:** un archivo inexistente debe producir una lista vacía al invocar `findAll()`; el identificador, precio y stock deben convertirse a sus tipos Java.
