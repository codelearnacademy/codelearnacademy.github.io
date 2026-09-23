---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion19"
lesson_file: "19-jackson-con-maven"
lesson_number: "19"
title: "Jackson con Maven"
description: "Jackson con Maven: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion19/"
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

# Jackson con Maven

## Qué vas a conseguir

- Añadir Jackson Databind al proyecto.
- Crear y configurar un `ObjectMapper`.

## Punto de partida

Jackson separa módulos: `databind` aporta el mapeo de objetos y utiliza internamente core/annotations.

<div class="cla-note"><strong>Jackson Databind</strong><p><code>ObjectMapper</code> es reutilizable. Evita crear uno nuevo para cada operación si puedes inyectar o compartir una configuración común.</p></div>

## Conceptos clave

- `ObjectMapper` es el punto de entrada habitual para JSON.
- La dependencia se declara en Maven; la instancia se crea en Java.
- Conviene reutilizar un mapper configurado en lugar de crear uno distinto en cada método.

## Ejemplo guiado

```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

```java
ObjectMapper mapper = new ObjectMapper();
```

## Relación con el resto de la ruta

La próxima lección utiliza el mapper para convertir un array JSON en `List<Producto>`.

## Ejercicios propuestos

1. Añade `jackson-databind` al `pom.xml`.
2. Crea un único `ObjectMapper` y pásalo por constructor a una clase `JsonProductoReader`.

## Qué debes recordar

- Maven aporta la librería; `ObjectMapper` realiza el mapeo.
- Centraliza la configuración del mapper.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion18/">← 18 · El formato JSON</a>
  <a href="/ficheros/leccion20/">20 · Deserializar JSON →</a>
</div>
