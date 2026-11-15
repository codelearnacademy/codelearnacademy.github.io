---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion09"
lesson_file: "09-leer-csv-a-objetos-java"
lesson_number: "09"
title: "Leer CSV a objetos Java"
description: "Mapeo de CSVRecord a Producto y construcción de listas tipadas."
permalink: "/ficheros/leccion09/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: mapeo-de-una-fila
    title: "Mapeo de una fila"
  - id: lectura-completa
    title: "Lectura completa"
  - id: donde-validar
    title: "Dónde validar"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-importar-precios-csv
    title: "Microproyecto · Importar precios CSV"
---

# Leer CSV a objetos Java

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/09.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/09.webp' | relative_url }}" alt="Fila → objetos Java. El parser entrega texto por columna. Convierte cada precio y señala un registro inválido." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Convertir `CSVRecord` en `Producto`.
- Separar parsing CSV de conversión de tipos.
- Construir `List<Producto>` a partir de un fichero.

![Flujo de lectura CSV]({{ '/assets/images/ficheros/09-flujo-lectura-csv.png' | relative_url }})

## Mapeo de una fila
{: #mapeo-de-una-fila }

```java
private static Producto toProducto(CSVRecord record) {
    return new Producto(
            Long.parseLong(record.get("id")),
            record.get("nombre"),
            Double.parseDouble(record.get("precio")))
    );
}
```

## Lectura completa
{: #lectura-completa }

```java
static List<Producto> readAll(Path path) throws IOException {
    CSVFormat format = CSVFormat.DEFAULT.builder()
            .setHeader()
            .setSkipHeaderRecord(true)
            .get();

    List<Producto> productos = new ArrayList<>();

    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
         CSVParser parser = format.parse(reader)) {
        for (CSVRecord record : parser) {
            productos.add(toProducto(record));
        }
    }
    return productos;
}
```

## Dónde validar
{: #donde-validar }

El parser no sabe si un precio negativo es válido. Esa regla pertenece a tu aplicación o al modelo. Conviene distinguir errores de **formato** de errores de **negocio**.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Añade control de filas con `stock` no numérico.
2. Decide qué hacer con una fila vacía.
3. Imprime los productos después del mapeo para comprobar los tipos.


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · Importar precios CSV
{: #microproyecto-importar-precios-csv }

Recupera los precios del catálogo en el orden del fichero. Si un precio no es un número, lanza IllegalArgumentException.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F09-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F09-tarea-01.webp' | relative_url }}" alt="Importar precios CSV. Resultado esperado: Lista de precios en orden" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Lista de precios en orden.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion09/F09-tarea-01.zip' | relative_url }}">Descargar F09-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion08/' | relative_url }}">← 8 · Apache Commons CSV</a>
  <a href="{{ '/ficheros/leccion10/' | relative_url }}">10 · Escribir objetos a CSV →</a>
</div>
