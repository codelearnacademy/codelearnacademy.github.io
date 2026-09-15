---
layout: lesson
route: ficheros
lesson_id: leccion19
lesson_file: 19-por-que-split-no-es-un-parser-csv
lesson_number: "19"
title: Por qué split no es un parser CSV
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion19/
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

# Por qué split no es un parser CSV

## Qué vas a conseguir

- Comprender **Por qué split no es un parser CSV**.
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

Adapta el ejemplo al concepto de esta lección y comprueba el resultado con un fichero pequeño antes de aumentar el volumen de datos.



## Relación con el resto de la ruta

Maven resuelve Apache Commons CSV; Commons CSV interpreta el formato. CSV es habitual en importaciones, exportaciones e informes.

## Ejercicios propuestos

1. Reproduce el ejemplo y guarda el resultado en un repositorio Git.
2. Introduce un fichero válido y otro mal formado; compara el comportamiento.
3. Cambia el nombre/ruta del fichero para recibirlo como argumento del programa.
4. Explica qué parte resuelve Java estándar y cuál depende de una biblioteca externa.
5. Escribe una prueba para el caso principal o describe cómo la automatizarías.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion18/">← 18 · Qué es CSV y para qué se utiliza</a>
  <a href="/ficheros/leccion20/">20 · Apache Commons CSV y Maven →</a>
</div>
