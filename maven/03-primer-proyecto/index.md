---
layout: lesson
route: maven
lesson_id: principal03
lesson_number: "03"
title: "Crear el primer proyecto Maven"
description: "Crea un proyecto completo y configura Java 21 desde el comienzo."
permalink: /maven/03-primer-proyecto/
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
# Crear el primer proyecto Maven

Crea un proyecto completo y configura Java 21 desde el comienzo.
## Objetivo y punto de partida

Necesitas el entorno de la lección 02. Crea una carpeta `gestor-tareas` y ábrela en tu editor. Todos los comandos siguientes se ejecutan desde la carpeta que contiene `pom.xml`.

## Práctica guiada

Crea esta estructura manualmente; también puedes usar el Explorador de Windows:

```text
gestor-tareas/
├── pom.xml
└── src/main/java/com/codelearn/tareas/Main.java
```

Guarda este POM completo:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.codelearn</groupId>
  <artifactId>gestor-tareas</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <properties>
    <maven.compiler.release>21</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.13.0</version>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.5.2</version>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.4.2</version>
      </plugin>
    </plugins>
  </build>
</project>
```

Las coordenadas son `com.codelearn:gestor-tareas:1.0.0-SNAPSHOT`. `groupId` identifica la organización, `artifactId` el artefacto y `version` su versión. `modelVersion` identifica el modelo del POM, no la versión de Maven. Sin `<packaging>`, el proyecto utiliza `jar`.

Guarda `Main.java`:

```java
package com.codelearn.tareas;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gestor de tareas preparado");
    }
}
```

Los plugins fijados anticipan compilación, pruebas y empaquetado. `release` selecciona lenguaje, bytecode y API de Java 21; no descarga un JDK.

## Comprobación y errores habituales

```bash
mvn validate
```

Debe terminar con `BUILD SUCCESS`. Esta fase comprueba la estructura del proyecto, pero todavía no demuestra que el código compile. Un error de XML suele indicar etiquetas mal cerradas o fragmentos colocados fuera de `<project>`.

## Ejercicio

Cambia únicamente `artifactId`, ejecuta `mvn validate` y devuelve el nombre a `gestor-tareas` para continuar la ruta.

## Qué debes recordar

Un fragmento XML no sustituye al POM completo. Mantén un único bloque `<properties>` y un único `<build>` al incorporar los ejemplos posteriores.

Referencia: [POM de Maven](https://maven.apache.org/pom.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/02-instalar-jdk-maven/' | relative_url }}">← 02 · Instalar JDK 21 y Maven</a>
<a href="{{ '/maven/04-compilar-target/' | relative_url }}">04 · Compilar y entender los archivos generados →</a>
</nav>
