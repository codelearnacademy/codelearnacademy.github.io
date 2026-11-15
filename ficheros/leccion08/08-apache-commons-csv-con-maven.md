---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion08"
lesson_file: "apache-commons-csv-con-maven"
lesson_number: "08"
title: "Apache Commons CSV con Maven"
description: "Incorporación de Commons CSV con Maven y primeras APIs CSVParser y CSVPrinter."
permalink: "/ficheros/leccion08/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: anadir-la-biblioteca
    title: "Añadir la biblioteca"
  - id: las-tres-piezas-que-utilizaremos
    title: "Las tres piezas que utilizaremos"
  - id: microproyecto-leer-por-nombre-de-columna
    title: "Microproyecto · Leer por nombre de columna"
---

# Apache Commons CSV con Maven

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/08.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/08.webp' | relative_url }}" alt="Parser CSV. El lector interpreta campos, separadores y comillas. Busca una columna por su cabecera y tolera cambios de orden." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Añadir Commons CSV al `pom.xml`.
- Comprobar que Maven resuelve la dependencia.
- Diferenciar `CSVParser`, `CSVRecord` y `CSVPrinter`.

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/ficheros/08-split-vs-parser.png' | relative_url }}" alt="Comparación entre split y un parser CSV" loading="lazy">
  <figcaption>Un parser CSV interpreta comillas, delimitadores y campos correctamente.</figcaption>
</figure>

## Añadir la biblioteca
{: #anadir-la-biblioteca }

```xml
<properties>
  <commons-csv.version>1.11.0</commons-csv.version>
</properties>

<dependencies>
  <dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>${commons-csv.version}</version>
  </dependency>
</dependencies>
```

Después puedes verificar la resolución con:

```bash
mvn dependency:tree
```

## Las tres piezas que utilizaremos
{: #las-tres-piezas-que-utilizaremos }

- `CSVParser`: recorre un documento CSV.
- `CSVRecord`: representa un registro ya interpretado.
- `CSVPrinter`: escribe registros respetando el dialecto CSV.

```java
CSVFormat format = CSVFormat.DEFAULT.builder()
        .setHeader()
        .setSkipHeaderRecord(true)
        .get();
```

<div class="cla-note"><strong>Maven + API</strong><p>Maven incorpora Commons CSV; <code>CSVFormat</code>, <code>CSVParser</code> y <code>CSVPrinter</code> son las clases que utilizamos desde Java.</p></div>


## Microproyecto · Leer por nombre de columna
{: #microproyecto-leer-por-nombre-de-columna }

Utiliza Commons CSV y devuelve la columna nombre aunque cambie su posición en la cabecera.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F08-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F08-tarea-01.webp' | relative_url }}" alt="Leer por nombre de columna. Resultado esperado: Teclado" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Teclado.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion08/F08-tarea-01.zip' | relative_url }}">Descargar F08-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion07/' | relative_url }}">← 07 · Anterior</a>
  <a href="{{ '/ficheros/leccion09/' | relative_url }}">09 · Siguiente →</a>
</div>
