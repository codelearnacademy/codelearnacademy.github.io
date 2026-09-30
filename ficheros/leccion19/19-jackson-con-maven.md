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

---

## Ampliación práctica: el mismo catálogo de productos

El proyecto integra Jackson Databind y Jackson XML con una propiedad de versión común. Este es su `pom.xml` completo, preparado para Java 21: 

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.ejemplo</groupId><artifactId>catalogo-repositorios</artifactId><version>1.0.0</version>
  <properties>
    <maven.compiler.release>21</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <jackson.version>2.22.3</jackson.version>
    <junit.version>5.13.4</junit.version>
  </properties>
  <dependencies>
    <dependency><groupId>org.apache.commons</groupId><artifactId>commons-csv</artifactId><version>1.14.1</version></dependency>
    <dependency><groupId>com.fasterxml.jackson.core</groupId><artifactId>jackson-databind</artifactId><version>${jackson.version}</version></dependency>
    <dependency><groupId>com.fasterxml.jackson.dataformat</groupId><artifactId>jackson-dataformat-xml</artifactId><version>${jackson.version}</version></dependency>
    <dependency><groupId>org.junit.jupiter</groupId><artifactId>junit-jupiter</artifactId><version>${junit.version}</version><scope>test</scope></dependency>
  </dependencies>
  <build><plugins>
    <plugin><groupId>org.apache.maven.plugins</groupId><artifactId>maven-compiler-plugin</artifactId><version>3.14.0</version><configuration><release>21</release></configuration></plugin>
    <plugin><groupId>org.apache.maven.plugins</groupId><artifactId>maven-surefire-plugin</artifactId><version>3.5.3</version></plugin>
    <plugin><groupId>org.codehaus.mojo</groupId><artifactId>exec-maven-plugin</artifactId><version>3.6.2</version><configuration><mainClass>com.ejemplo.catalogo.Main</mainClass></configuration></plugin>
  </plugins></build>
</project>
```
`ObjectMapper` se inyecta por constructor en `ProductoJsonRepository`; de esta manera puedes sustituirlo por uno configurado o de pruebas. `TypeReference<List<Producto>>` conserva el tipo de los elementos de la lista.
