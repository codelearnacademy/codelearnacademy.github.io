---
layout: lesson
route: maven
lesson_id: principal12
lesson_number: "12"
title: "Propiedades y gestión de versiones"
description: "Centraliza versiones y entiende dependencyManagement y los BOM."
permalink: /maven/12-propiedades-versiones/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: versiones-de-plugins-y-criterio-para-continuar
    title: Versiones de plugins y criterio para continuar
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Propiedades y gestión de versiones

Centraliza versiones y entiende dependencyManagement y los BOM.
## Objetivo y punto de partida

Continúa con el proyecto después de retirar las bibliotecas de la práctica anterior. Conserva las propiedades existentes de Java y codificación.

## Práctica guiada

Añade a `<properties>`:

```xml
<gson.version>2.11.0</gson.version>
<junit.version>5.11.0</junit.version>
<maven-compiler-plugin.version>3.13.0</maven-compiler-plugin.version>
<maven-surefire-plugin.version>3.5.2</maven-surefire-plugin.version>
<maven-jar-plugin.version>3.4.2</maven-jar-plugin.version>
<maven-shade-plugin.version>3.6.0</maven-shade-plugin.version>
<maven-dependency-plugin.version>3.8.1</maven-dependency-plugin.version>
<maven-wrapper-plugin.version>3.3.2</maven-wrapper-plugin.version>
```

En la dependencia Gson sustituye la versión por `<version>${gson.version}</version>`. Comprueba con `mvn compile`.

Para separar la política de versiones de las bibliotecas utilizadas, añade bajo `<project>`:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>${gson.version}</version>
    </dependency>
    <dependency>
      <groupId>org.junit</groupId>
      <artifactId>junit-bom</artifactId>
      <version>${junit.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

Retira `<version>` únicamente de Gson en el bloque normal `<dependencies>`. La versión la aporta ahora `dependencyManagement`. El BOM alinea las versiones de los artefactos JUnit; la siguiente lección declara cuál utiliza el proyecto.

## Versiones de plugins y criterio para continuar

Desde esta lección, **declara las versiones de dependencias y plugins mediante propiedades**. Si una dependencia recibe su versión de `dependencyManagement` o de un BOM, omite su `<version>` en `<dependencies>`; la versión gestionada debe partir de una propiedad. No repitas valores numéricos en cada declaración.

En los plugins existentes de `<build><plugins>`, sustituye sus versiones:

```xml
<!-- maven-compiler-plugin -->
<version>${maven-compiler-plugin.version}</version>
<!-- maven-surefire-plugin -->
<version>${maven-surefire-plugin.version}</version>
<!-- maven-jar-plugin -->
<version>${maven-jar-plugin.version}</version>
```

En el plugin Shade del perfil `distribucion`, utiliza `<version>${maven-shade-plugin.version}</version>`. Las propiedades del proyecto también están disponibles en ese perfil.

Añade estos dos plugins al bloque principal `<build><plugins>` para que los comandos posteriores utilicen las versiones declaradas:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-dependency-plugin</artifactId>
  <version>${maven-dependency-plugin.version}</version>
</plugin>
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-wrapper-plugin</artifactId>
  <version>${maven-wrapper-plugin.version}</version>
</plugin>
```

No añadas otro `<build>` ni otro `<properties>`: modifica los bloques existentes. Si incorporas una nueva biblioteca o plugin en las siguientes lecciones, declara primero su propiedad de versión. Las versiones de las coordenadas del propio proyecto, de su padre y de la distribución de Maven son conceptos distintos; esta regla se aplica a dependencias, BOM y plugins.

## Comprobación y errores habituales

```bash
mvn dependency:tree
mvn help:effective-pom -Doutput=target/pom-efectivo.xml
```

Debe mantenerse Gson 2.11.0. `dependencyManagement` no añade Gson por sí solo: si retiras su declaración de `<dependencies>`, el import Java deja de resolverse.

Para una sustitución puntual puedes usar `mvn -Dgson.version=2.11.0 compile`. Los plugins utilizan `<build><plugins>` y, para gestionar sus defaults por herencia, `<pluginManagement>`; no se gestionan en `dependencyManagement`.

## Ejercicio

Identifica en el POM efectivo de dónde salen las versiones de Gson y JUnit. No copies el POM efectivo sobre el original: es un resultado de diagnóstico.

## Qué debes recordar

Una propiedad evita repetir un valor; `dependencyManagement` establece versiones y configuración; un BOM agrupa una política de versiones. Ninguno sustituye la declaración de las bibliotecas utilizadas.

Referencia: [Dependencias y BOM](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/11-transitivas-scopes-conflictos/' | relative_url }}">← 11 · Dependencias transitivas, scopes y conflictos</a>
<a href="{{ '/maven/13-junit-surefire/' | relative_url }}">13 · Añadir y ejecutar pruebas con JUnit →</a>
</nav>
