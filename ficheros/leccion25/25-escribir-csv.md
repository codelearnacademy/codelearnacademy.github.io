---
layout: lesson
route: ficheros
lesson_id: leccion25
lesson_file: 25-escribir-csv
lesson_number: "25"
title: Escribir CSV
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion25/
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

# Escribir CSV

## Qué vas a conseguir

- Comprender **Escribir CSV**.
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

Añade `org.apache.commons:commons-csv:1.14.1` a las dependencias Maven del proyecto. Este ejemplo escribe realmente CSV y vuelve a parsearlo para comprobar el tratamiento de comas y comillas. Guarda la clase como `EscribirCsv.java` en `src/main/java`.

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import org.apache.commons.csv.*;

public class EscribirCsv {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("usuarios.csv");
        try (Writer out = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT)) {
            printer.printRecord("nombre", "nota");
            printer.printRecord("Ana, María", "Dijo \"hola\"");
        }
        try (Reader in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             CSVParser parser = CSVFormat.DEFAULT.builder()
                 .setHeader().setSkipHeaderRecord(true).get().parse(in)) {
            for (CSVRecord row : parser) {
                if (!row.get("nombre").equals("Ana, María")) {
                    throw new IllegalStateException("Nombre alterado");
                }
                System.out.println(row.get("nota"));
            }
        }
    }
}
```

La salida debe ser `Dijo "hola"`. El archivo contiene dos registros; el escritor se ocupa del escape de comas y comillas. No construyas el CSV concatenando campos con comas.

Para ejecutar esta clase con sus dependencias consulta [empaquetar y ejecutar la aplicación]({{ '/maven/16-empaquetar-ejecutar/' | relative_url }}); usa `EscribirCsv` como clase principal. Referencia: [CSVPrinter](https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVPrinter.html).


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
  <a href="/ficheros/leccion24/">← 24 · Validar datos CSV</a>
  <a href="/ficheros/leccion26/">26 · Importaciones masivas y tratamiento de errores →</a>
</div>
