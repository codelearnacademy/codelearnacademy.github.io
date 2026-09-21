---
layout: lesson
route: maven
lesson_id: principal06
lesson_number: "06"
title: "Añadir y utilizar una dependencia"
description: "Incorpora Gson y utiliza JSON desde la aplicación."
permalink: /maven/06-anadir-dependencia/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Añadir y utilizar una dependencia

Incorpora Gson y utiliza JSON desde la aplicación.
## Objetivo y punto de partida

Continúa con el POM de la lección 03. Una dependencia es una biblioteca que utiliza el código; un plugin ejecuta tareas de construcción.

## Práctica guiada

Añade dentro de `<project>`, antes de `<build>`:

```xml
<dependencies>
  <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
  </dependency>
</dependencies>
```

Sustituye el contenido de `Main.java`:

```java
package com.codelearn.tareas;

import com.google.gson.Gson;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var datos = Map.of("titulo", "Aprender Maven", "completada", false);
        System.out.println(new Gson().toJson(datos));
    }
}
```

```bash
mvn compile
mvn dependency:tree
```

Maven descarga la biblioteca cuando la necesita. El árbol debe incluir `com.google.code.gson:gson:jar:2.11.0:compile`. El scope por defecto es `compile`.

## Comprobación y errores habituales

La compilación demuestra que el import se resuelve. Ejecutar solo con `java -cp target/classes ...` ahora no incluye Gson: puede producir `NoClassDefFoundError`. La lección de empaquetado enseña a ejecutar con dependencias; no elimines el import para ocultar ese problema.

Si ya existe `<dependencies>`, añade únicamente el bloque `<dependency>` dentro de él. No coloques bibliotecas dentro de `<build><plugins>`.

## Ejercicio

Cambia el título y recompila. Retira temporalmente la dependencia y observa el error de compilación; después restáurala.

## Qué debes recordar

Maven configura el classpath de compilación. Ejecutar directamente con la JVM exige proporcionar también las bibliotecas necesarias.

Referencia: [Gson](https://github.com/google/gson).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/05-ciclos-fases-goals/' | relative_url }}">← 05 · Ciclos de vida, fases y goals</a>
<a href="{{ '/maven/07-central-repositorio-local/' | relative_url }}">07 · Maven Central y el repositorio local →</a>
</nav>
