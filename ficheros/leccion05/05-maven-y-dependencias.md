---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion05"
lesson_file: "maven-y-dependencias"
lesson_number: "05"
title: "Maven y dependencias externas"
description: "Cómo incorporar Commons CSV y Jackson al proyecto mediante Maven."
permalink: "/ficheros/leccion05/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: dependencias-que-apareceran-en-la-ruta
    title: "Dependencias que aparecerán en la ruta"
  - id: maven-frente-a-import
    title: "Maven frente a import"
  - id: ejercicio
    title: "Ejercicio"
  - id: microproyecto-leer-con-una-dependencia-maven
    title: "Microproyecto · Leer con una dependencia Maven"
---

# Maven y dependencias externas

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/05.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/05.webp' | relative_url }}" alt="POM → biblioteca → import. Maven resuelve la dependencia indicada en pom.xml. import permite usar un tipo que el proyecto ya tiene disponible." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Entender qué resuelve Maven en esta ruta.
- Distinguir una dependencia Maven de un `import` Java.
- Preparar el proyecto para incorporar Commons CSV y Jackson de forma progresiva.

## Punto de partida
{: #punto-de-partida }

Java 21 incluye `Path`, `Files`, `Reader`, `Writer` y `Properties`, pero no incorpora un parser CSV completo ni los módulos de Jackson que utilizaremos para JSON y XML.

```xml
<properties>
  <maven.compiler.release>21</maven.compiler.release>
</properties>
```

<div class="cla-note"><strong>Idea importante</strong><p>Maven coloca una biblioteca en el classpath. El código Java decide después cómo utilizar su API.</p></div>

## Dependencias que aparecerán en la ruta
{: #dependencias-que-apareceran-en-la-ruta }

Las añadiremos cuando realmente hagan falta:

```text
CSV  → org.apache.commons:commons-csv
JSON → com.fasterxml.jackson.core:jackson-databind
XML  → com.fasterxml.jackson.dataformat:jackson-dataformat-xml
```

No es necesario añadirlas todas desde el primer día. Ver cómo crece el `pom.xml` forma parte del aprendizaje.

## Maven frente a import
{: #maven-frente-a-import }

```java
import org.apache.commons.csv.CSVParser;
```

El `import` no descarga nada. Para que esa clase exista en el proyecto, Commons CSV debe estar declarada como dependencia Maven.

## Ejercicio
{: #ejercicio }

Crea un proyecto Java 21 con Maven, ejecuta `mvn compile` y localiza el repositorio local donde Maven almacena las dependencias descargadas.


## Microproyecto · Leer con una dependencia Maven
{: #microproyecto-leer-con-una-dependencia-maven }

Añade Commons CSV al POM y cuenta registros de un CSV sin cabecera. Un campo entrecomillado puede contener comas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F05-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F05-tarea-01.webp' | relative_url }}" alt="Leer con una dependencia Maven. Resultado esperado: 2 registros" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** 2 registros.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion05/F05-tarea-01.zip' | relative_url }}">Descargar F05-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion04/' | relative_url }}">← 04 · Anterior</a>
  <a href="{{ '/ficheros/leccion06/' | relative_url }}">06 · Siguiente →</a>
</div>
