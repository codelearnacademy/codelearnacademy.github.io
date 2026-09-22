---
layout: lesson
route: ficheros
lesson_id: leccion08
lesson_file: 08-ficheros-grandes-y-procesamiento-progresivo
lesson_number: "08"
title: Ficheros grandes y procesamiento progresivo
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion08/
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

# Ficheros grandes y procesamiento progresivo

## Qué vas a conseguir

- Comprender **Ficheros grandes y procesamiento progresivo**.
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

Lee una línea cada vez sin conservar el archivo completo. Guarda como `ContarLineas.java`; ejecútalo con Java 21 pasando la ruta de un archivo de texto UTF-8.

```java
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContarLineas {
    public static void main(String[] args) throws Exception {
        long total = 0;
        try (BufferedReader reader = Files.newBufferedReader(
                Path.of(args[0]), StandardCharsets.UTF_8)) {
            while (reader.readLine() != null) {
                total++;
            }
        }
        System.out.println(total);
    }
}
```

Ejecuta `java ContarLineas.java datos.txt`. Un archivo con tres líneas produce `3`; uno vacío produce `0`. El lector se cierra incluso si ocurre un error. La memoria depende del tamaño de la línea actual y del búfer, no de todo el archivo; líneas gigantes requieren procesamiento por bloques. `Files.readString` y acumular todas las líneas en una lista no sirven para demostrar este procesamiento progresivo.

Referencia: [Files en Java 21](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html).


## Relación con el resto de la ruta

Estas APIs son la base común. Las librerías de formato no sustituyen Path, Files, encoding ni el manejo correcto de recursos.

## Ejercicios propuestos

1. Implementa el caso principal de esta lección con un fichero de prueba pequeño.
2. Comprueba el comportamiento cuando la ruta no existe o el contenido está incompleto.
3. Recibe la ruta del fichero como argumento y no la fijes en el código.
4. Explica qué responsabilidad corresponde a `Path`/`Files` y cuál a tu lógica.
5. Añade una prueba que cubra el caso correcto y un error esperado.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion07/">← 07 · try-with-resources</a>
  <a href="/ficheros/leccion09/">09 · Leer no es lo mismo que parsear →</a>
</div>
