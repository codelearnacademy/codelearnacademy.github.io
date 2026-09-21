---
layout: lesson
route: maven
lesson_id: ampliacion03
lesson_number: "A3"
title: "A3 · Generar un JAR con dependencias"
description: "Comprende y verifica el artefacto de distribución generado por Shade."
permalink: /maven/a3-jar-dependencias/
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
# A3 · Generar un JAR con dependencias

Comprende y verifica el artefacto de distribución generado por Shade.
## Objetivo y punto de partida

Usa el proyecto de un módulo de la ruta principal. El perfil `distribucion` ya contiene Shade; no añadas una segunda ejecución del mismo plugin.

## Práctica guiada

Conserva `<maven-shade-plugin.version>3.6.0</maven-shade-plugin.version>` en `<properties>`, como se configuró en la lección 12.

Este es el bloque del plugin usado dentro de `<profiles><profile><build><plugins>`:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-shade-plugin</artifactId>
  <version>${maven-shade-plugin.version}</version>
  <executions>
    <execution>
      <phase>package</phase>
      <goals><goal>shade</goal></goals>
      <configuration>
        <shadedArtifactAttached>true</shadedArtifactAttached>
        <shadedClassifierName>all</shadedClassifierName>
        <createDependencyReducedPom>false</createDependencyReducedPom>
        <transformers>
          <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
            <mainClass>com.codelearn.tareas.Main</mainClass>
          </transformer>
        </transformers>
      </configuration>
    </execution>
  </executions>
</plugin>
```

`package` ejecuta `shade`; `shadedArtifactAttached` mantiene el artefacto convencional y añade otro con classifier `all`. El transformador configura `Main-Class`. `createDependencyReducedPom=false` evita generar un POM reducido en este ejemplo.

```bash
./mvnw -Pdistribucion clean verify
jar tf target/gestor-tareas-1.0.0-SNAPSHOT-all.jar
java -jar target/gestor-tareas-1.0.0-SNAPSHOT-all.jar
```

Si ya has realizado la entrega estable de la lección 21, usa `1.0.0` en ambos nombres. En PowerShell cambia el comando de Wrapper a `.\mvnw.cmd`.

## Comprobación y errores habituales

Busca tanto `com/codelearn/tareas/Main.class` como `com/google/gson/Gson.class` y `aplicacion.properties` en el JAR. El artefacto convencional no contiene las clases de Gson. Copia solo el JAR `-all` a otra carpeta y ejecútalo: debe funcionar con JDK 21 sin añadir bibliotecas al classpath.

Un JAR con todas las dependencias no incluye automáticamente el JDK. Para bibliotecas con servicios Java, firmas o recursos de igual nombre pueden necesitarse transformadores y reglas adicionales; este ejemplo resuelve la aplicación sencilla con Gson.

## Ejercicio

Compara tamaño y contenido del JAR convencional y del JAR `-all`. Documenta cuál entregas y comprueba la persistencia externa de tareas si ya has terminado la aplicación.

## Qué debes recordar

Empaquetar dependencias es una decisión explícita. El classifier distingue artefactos con la misma versión y diferente propósito.

Referencia: [Shade y JAR ejecutable](https://maven.apache.org/plugins/maven-shade-plugin/examples/executable-jar.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/a2-varios-modulos/' | relative_url }}">← A2 · A2 · Proyectos con varios módulos</a>
<a href="{{ '/maven/a4-comparar-herramientas/' | relative_url }}">A4 · A4 · Maven frente a otras herramientas →</a>
</nav>
