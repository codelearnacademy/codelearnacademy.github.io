---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion05"
lesson_file: "05-maven-y-dependencias"
lesson_number: "5"
title: "Maven y dependencias"
description: "Maven y dependencias: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion05/"
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

# Maven y dependencias

## Qué vas a conseguir

- Entender qué problema resuelve Maven.
- Añadir librerías externas sin copiar JAR manualmente.

## Punto de partida

Java 21 incluye `Properties`, pero no incluye un parser CSV completo ni Jackson.

<div class="cla-note"><strong>Maven</strong><p>Una dependencia Maven incorpora una biblioteca al proyecto; no sustituye el código que decide cómo utilizar su API.</p></div>

## Conceptos clave

- Una dependencia Maven se identifica por `groupId`, `artifactId` y `version`.
- `pom.xml` describe dependencias y configuración de compilación.
- Un `import` Java no descarga la librería: solo referencia una clase que debe estar en el classpath.

## Ejemplo guiado

```xml
<properties>
  <maven.compiler.release>21</maven.compiler.release>
</properties>

<dependencies>
  <dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>1.11.0</version>
  </dependency>
</dependencies>
```

## Relación con el resto de la ruta

A partir de CSV incorporarás Commons CSV; en JSON y XML incorporarás módulos de Jackson usando el mismo mecanismo.

## Ejercicios propuestos

1. Localiza en el `pom-ejemplo.xml` las dependencias de CSV, JSON y XML.
2. Explica la diferencia entre `<dependency>` e `import`.

## Qué debes recordar

- Maven gestiona dependencias; no parsea los datos.
- El código Java importa clases que Maven coloca en el classpath.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion04/">← 4 · IOException y try-with-resources</a>
  <a href="/ficheros/leccion06/">6 · Modelo común Producto →</a>
</div>
