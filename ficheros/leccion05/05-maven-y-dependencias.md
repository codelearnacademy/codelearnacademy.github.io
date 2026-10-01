---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion05"
lesson_file: "maven-y-dependencias"
lesson_number: "05"
title: "Maven y dependencias externas"
description: "Cómo incorporar Commons CSV y Jackson al proyecto mediante Maven."
permalink: "/ficheros/leccion05/"
---

# Maven y dependencias externas

## Qué vas a conseguir

- Entender qué resuelve Maven en esta ruta.
- Distinguir una dependencia Maven de un `import` Java.
- Preparar el proyecto para incorporar Commons CSV y Jackson de forma progresiva.

## Punto de partida

Java 21 incluye `Path`, `Files`, `Reader`, `Writer` y `Properties`, pero no incorpora un parser CSV completo ni los módulos de Jackson que utilizaremos para JSON y XML.

```xml
<properties>
  <maven.compiler.release>21</maven.compiler.release>
</properties>
```

<div class="cla-note"><strong>Idea importante</strong><p>Maven coloca una biblioteca en el classpath. El código Java decide después cómo utilizar su API.</p></div>

## Dependencias que aparecerán en la ruta

Las añadiremos cuando realmente hagan falta:

```text
CSV  → org.apache.commons:commons-csv
JSON → com.fasterxml.jackson.core:jackson-databind
XML  → com.fasterxml.jackson.dataformat:jackson-dataformat-xml
```

No es necesario añadirlas todas desde el primer día. Ver cómo crece el `pom.xml` forma parte del aprendizaje.

## Maven frente a import

```java
import org.apache.commons.csv.CSVParser;
```

El `import` no descarga nada. Para que esa clase exista en el proyecto, Commons CSV debe estar declarada como dependencia Maven.

## Ejercicio

Crea un proyecto Java 21 con Maven, ejecuta `mvn compile` y localiza el repositorio local donde Maven almacena las dependencias descargadas.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion04/">← 04 · Anterior</a>
  <a href="/ficheros/leccion06/">06 · Siguiente →</a>
</div>
