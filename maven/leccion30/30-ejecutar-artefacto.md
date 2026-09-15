---
layout: lesson
route: maven
lesson_id: leccion30
lesson_file: 30-ejecutar-artefacto
lesson_number: "30"
title: Ejecutar el artefacto
description: Ejecuta el resultado fuera del IDE y comprende la diferencia entre proyecto y artefacto.
permalink: /maven/leccion30/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: conexión-con-otros-ecosistemas
    title: Conexión con otros ecosistemas
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Ejecutar el artefacto

Ejecuta el resultado fuera del IDE y comprende la diferencia entre proyecto y artefacto.

## Qué vas a conseguir

- Comprender **java -jar** en el contexto de un proyecto Maven.
- Comprender **classpath** en el contexto de un proyecto Maven.
- Comprender **ejecutable** en el contexto de un proyecto Maven.
- Relacionar lo aprendido con un flujo real de desarrollo.
- Aplicar el concepto mediante una práctica guiada.

<div class="cla-note"><strong>Ruta de estudio</strong><p>Trabaja esta lección desde terminal siempre que sea posible. El objetivo no es memorizar comandos, sino entender qué cambia en el proyecto y por qué.</p></div>

## Punto de partida

Maven se entiende mejor cuando cada concepto se conecta con una necesidad concreta del proyecto. En esta lección nos centraremos en **java -jar** y observaremos su efecto en un proyecto Java sencillo.

Antes de ejecutar un comando, intenta responder:

```text
¿Qué problema estamos resolviendo?
¿Qué archivo o fase interviene?
¿Qué resultado esperamos obtener?
¿Cómo comprobaríamos que ha funcionado?
```

## Conceptos clave

- **java -jar**
- **classpath**
- **ejecutable**

La idea importante es separar responsabilidades. Java aporta el lenguaje y la plataforma; Maven aporta un modelo de proyecto, resolución de dependencias y automatización del proceso de construcción.

## Ejemplo guiado

Un JAR convencional necesita una clase principal declarada en el manifiesto para ejecutarse con `java -jar`. Usa este POM completo para una aplicación Java 21 sin dependencias externas:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.codelearn</groupId>
  <artifactId>mi-app</artifactId>
  <version>1.0.0</version>
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
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.4.2</version>
        <configuration>
          <archive><manifest><mainClass>com.codelearn.App</mainClass></manifest></archive>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

Guarda `src/main/java/com/codelearn/App.java`:

```java
package com.codelearn;
public class App {
    public static void main(String[] args) {
        System.out.println("Hola desde el JAR");
    }
}
```

```bash
mvn clean package
java -jar target/mi-app-1.0.0.jar
```

Debe imprimir `Hola desde el JAR`. Si aparece `no main manifest attribute`, revisa Main-Class. Si falta una clase de biblioteca, declarar Main-Class no resuelve sus dependencias: Maven no las mete automáticamente dentro del JAR.

Para una clase que usa dependencias, una alternativa explícita es copiarlas junto al JAR y ejecutar con classpath:

```bash
mvn package org.apache.maven.plugins:maven-dependency-plugin:3.8.1:copy-dependencies -DincludeScope=runtime -DoutputDirectory=target/lib
java -cp "target/mi-app-1.0.0.jar:target/lib/*" com.codelearn.App
```

En Windows utiliza `;` en lugar de `:`. Sustituye la clase principal si ejecutas otro ejemplo, como `EscribirCsv`. Otra opción es generar un JAR con dependencias mediante un plugin específico; es una decisión adicional de empaquetado. `java -jar` no combina su ejecución con el classpath indicado mediante `-cp`.

Referencia: [Maven Archiver: manifiesto y classpath](https://maven.apache.org/shared/maven-archiver/examples/classpath.html).


## Conexión con otros ecosistemas

Ejecutar el artefacto final equivale a desplegar/usar el resultado del build, no el entorno de desarrollo. Esta distinción aparece también en Docker, npm y Go.

No busques equivalencias exactas. La pregunta útil es:

> ¿Qué responsabilidad está resolviendo esta herramienta dentro del proyecto?

Por ejemplo, una herramienta puede encargarse solo de instalar paquetes, mientras otra también define construcción, pruebas y empaquetado.

## Ejercicios propuestos

1. Ejecuta el JAR desde terminal.
2. Explica qué necesita el artefacto para funcionar en otro equipo.

### Ejercicio de reflexión

Responde brevemente:

- ¿Qué parte de esta lección pertenece a Java?
- ¿Qué parte pertenece a Maven?
- ¿Qué parte podría automatizar GitHub Actions o GitLab CI?
- ¿Qué información debería quedar versionada en Git?



## Qué debes recordar

- Maven debe ayudarte a que el proyecto sea **reproducible**.
- El `pom.xml` debe describir información necesaria para construir el proyecto.
- Los archivos generados no sustituyen al código fuente ni a la configuración versionada.
- Git almacena el estado fuente del proyecto; Maven reconstruye los resultados derivados.
- CI ejecuta automáticamente el mismo proceso que debería funcionar en tu equipo.

<div class="cla-lesson-nav">
  <a href="/maven/leccion29/">← 29 · Empaquetar una aplicación</a>
  <a href="/maven/leccion31/">31 · Código de producción y pruebas →</a>
</div>
