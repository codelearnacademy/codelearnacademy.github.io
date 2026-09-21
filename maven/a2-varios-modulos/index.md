---
layout: lesson
route: maven
lesson_id: ampliacion02
lesson_number: "A2"
title: "A2 · Proyectos con varios módulos"
description: "Separa dominio y consola y comprende agregación e herencia."
permalink: /maven/a2-varios-modulos/
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
# A2 · Proyectos con varios módulos

Separa dominio y consola y comprende agregación e herencia.
## Objetivo y punto de partida

Haz esta práctica en otra carpeta o rama para no romper la entrega final. Un POM puede agregar módulos y también ser padre; son funciones distintas aunque a menudo coincidan.

## Práctica guiada

Crea `tareas-modulos/pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.codelearn</groupId>
  <artifactId>tareas-padre</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <packaging>pom</packaging>
  <modules>
    <module>dominio</module>
    <module>consola</module>
  </modules>
  <properties>
    <maven.compiler.release>21</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven-compiler-plugin.version>3.13.0</maven-compiler-plugin.version>
    <maven-surefire-plugin.version>3.5.2</maven-surefire-plugin.version>
    <maven-jar-plugin.version>3.4.2</maven-jar-plugin.version>
  </properties>
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>${maven-compiler-plugin.version}</version>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>${maven-surefire-plugin.version}</version>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>${maven-jar-plugin.version}</version>
      </plugin>
    </plugins>
  </build>
</project>
```

Los módulos heredan las propiedades y plugins del padre. La dependencia entre módulos utiliza `${project.version}` para mantener la misma versión del reactor. Las versiones de las coordenadas del padre siguen siendo explícitas.

Crea `dominio/pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.codelearn</groupId>
    <artifactId>tareas-padre</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <relativePath>../pom.xml</relativePath>
  </parent>
  <artifactId>tareas-dominio</artifactId>
</project>
```

Crea `consola/pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.codelearn</groupId>
    <artifactId>tareas-padre</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <relativePath>../pom.xml</relativePath>
  </parent>
  <artifactId>tareas-consola</artifactId>
  <dependencies>
    <dependency>
      <groupId>com.codelearn</groupId>
      <artifactId>tareas-dominio</artifactId>
      <version>${project.version}</version>
    </dependency>
  </dependencies>
</project>
```

Copia `GestorTareas.java` de la lección 13 al árbol `dominio/src/main/java/com/codelearn/tareas/`. Crea `consola/src/main/java/com/codelearn/tareas/Main.java`:

```java
package com.codelearn.tareas;
public class Main {
    public static void main(String[] args) {
        var gestor = new GestorTareas();
        gestor.anadir("Construir varios módulos");
        System.out.println(gestor.listar());
    }
}
```

Desde `tareas-modulos`:

```bash
mvn clean verify
mvn -pl consola -am package
```

## Comprobación y errores habituales

El resumen reactor debe incluir padre, dominio y consola. `-pl consola` selecciona el módulo y `-am` incluye los módulos que necesita. Ejecutar solo desde `consola/` puede requerir que dominio esté instalado localmente; construir desde la raíz evita ese requisito en este ejemplo.

La lista `<modules>` agrega proyectos; `<parent>` transmite configuración. `dependencyManagement` y `pluginManagement` en el padre establecen defaults, pero no declaran automáticamente todos los componentes que cada módulo necesita.

## Ejercicio

Añade JUnit y las pruebas de dominio usando el BOM de la lección 12 y una propiedad `junit.version` en el padre. Omite la versión de `junit-jupiter` en el módulo porque la gestiona el BOM; conserva Surefire con su propiedad compartida. Verifica que la consola depende del dominio y que el dominio no depende de la consola.

## Qué debes recordar

Divide módulos cuando existan responsabilidades claras. Maven construye el reactor respetando sus dependencias.

Referencia: [Proyectos múltiples](https://maven.apache.org/guides/mini/guide-multiple-modules.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/a1-publicar-artefactos/' | relative_url }}">← A1 · A1 · Publicar artefactos en un repositorio privado</a>
<a href="{{ '/maven/a3-jar-dependencias/' | relative_url }}">A3 · A3 · Generar un JAR con dependencias →</a>
</nav>
