---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 14-compilacion
lesson_number: "14"
title: Compilación
description: Compila y ejecuta el programa distinguiendo cada fase del proceso.
---

# Compilación

Desde la carpeta que contiene `Main.java`, ejecuta:

```bash
javac Main.java
java Main
```

El primer comando genera `Main.class`. El segundo recibe el nombre de la clase, no el nombre del archivo y tampoco la extensión `.class`.

## Separar las fases

```text
Main.java --javac--> Main.class --java--> JVM --> Hola Java 21
```

Si el compilador muestra un error, corrige el código fuente y vuelve a compilar. Si la compilación funciona pero la ejecución falla, revisa el directorio actual, el `CLASSPATH` y el nombre de la clase.

<div class="cla-note"><strong>Observación</strong><p>El archivo <code>.class</code> es un artefacto generado. En un proyecto real normalmente se guarda en una carpeta de build y no se versiona junto al código fuente.</p></div>

## Compilar a otra carpeta

Separa el código fuente de los artefactos generados:

```bash
mkdir -p out
javac -d out Main.java
java -cp out Main
```

La opción `-d` indica dónde escribir las clases y `-cp` indica dónde buscarlas al ejecutar. Maven y Gradle automatizan estas decisiones, igual que `dotnet build` en .NET.