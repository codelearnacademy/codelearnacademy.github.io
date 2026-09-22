---
layout: lesson
route: ficheros
lesson_id: leccion21
lesson_file: 21-leer-un-csv
lesson_number: "21"
title: Leer un CSV
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion21/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Leer un CSV

## Qué vas a conseguir

- Comprender **Leer un CSV**.
- Aplicarlo con Java 21.
- Distinguir lectura, parsing, validación y escritura.
- Relacionarlo con Maven, Spring o Docker cuando corresponda.

## Punto de partida

```text
Fichero → bytes/texto → parser → objetos Java → validación → lógica → writer → fichero
```

<div class="cla-note"><strong>Regla de la ruta</strong><p>Leer un fichero no es interpretarlo. Un parser entiende el formato; la lógica de negocio valida el significado.</p></div>

## Conceptos clave

- Acceso mediante `Path` y `Files`.
- UTF-8 explícito cuando trabajamos con texto.
- Manejo de errores mediante excepciones.
- Separación entre formato y modelo de dominio.

## Ejemplo guiado

```java
try (Reader r = Files.newBufferedReader(path);
     CSVParser parser = CSVFormat.DEFAULT.builder()
         .setHeader().setSkipHeaderRecord(true).get().parse(r)) {
    for (CSVRecord row : parser) {
        System.out.println(row.get("nombre"));
    }
}
```



## Relación con el resto de la ruta

Maven resuelve Apache Commons CSV; Commons CSV interpreta el formato. CSV es habitual en importaciones, exportaciones e informes.

## Ejercicios propuestos

1. Procesa un CSV con cabecera y transforma cada fila en el resultado de esta lección.
2. Prueba una fila con comas, comillas o columnas incompletas.
3. Recibe la ruta del CSV como argumento y conserva UTF-8 explícito.
4. Separa parsing, validación y escritura en responsabilidades distintas.
5. Añade una prueba para una fila válida y otra rechazada.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion20/">← 20 · Apache Commons CSV y Maven</a>
  <a href="/ficheros/leccion22/">22 · Cabeceras y acceso por nombre →</a>
</div>
