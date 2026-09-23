---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion13"
lesson_file: "13-apache-commons-csv"
lesson_number: "13"
title: "Apache Commons CSV"
description: "Apache Commons CSV: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion13/"
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

# Apache Commons CSV

## Qué vas a conseguir

- Configurar Apache Commons CSV.
- Leer cabeceras y registros sin parsing manual.

## Punto de partida

Ya conoces el problema; ahora delegas la sintaxis CSV en una librería específica.

<div class="cla-note"><strong>Commons CSV</strong><p>Deja que la biblioteca resuelva la sintaxis CSV y concentra tu código en convertir registros a objetos de dominio.</p></div>

## Conceptos clave

- `CSVFormat` describe el dialecto.
- `CSVParser` produce registros.
- Las cabeceras permiten acceder por nombre en vez de por posición.

## Ejemplo guiado

```java
CSVFormat format = CSVFormat.DEFAULT.builder()
        .setHeader()
        .setSkipHeaderRecord(true)
        .get();

try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
     CSVParser parser = format.parse(reader)) {
    for (CSVRecord row : parser) {
        System.out.println(row.get("nombre"));
    }
}
```

## Relación con el resto de la ruta

Esta lección se centra solo en la sintaxis CSV; en la siguiente convertirás cada `CSVRecord` a `Producto`.

## Ejercicios propuestos

1. Añade Commons CSV al `pom.xml`.
2. Lee un CSV con columnas `id,nombre,precio` e imprime solo `nombre`.

## Qué debes recordar

- Configura el dialecto explícitamente.
- El parser resuelve sintaxis CSV; tú sigues siendo responsable de convertir tipos.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion12/">← 12 · El formato CSV</a>
  <a href="/ficheros/leccion14/">14 · Leer CSV a objetos Java →</a>
</div>
