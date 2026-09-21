---
layout: lesson
route: maven
lesson_id: principal10
lesson_number: "10"
title: "Profiles: activar configuraciones de Maven"
description: "Declara, activa y comprueba perfiles sin duplicar el proyecto."
permalink: /maven/10-profiles/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada-distribución-opcional
    title: "Práctica guiada: distribución opcional"
  - id: activación-automática
    title: "Activación automática"
  - id: pom-frente-a-settings
    title: "POM frente a settings"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Profiles: activar configuraciones de Maven

Declara, activa y comprueba perfiles sin duplicar el proyecto.
## Objetivo y punto de partida

Continúa con el POM del proyecto. Un perfil altera el modelo de construcción antes de ejecutar las tareas. No equivale a un perfil de Spring, que configura una aplicación y su entorno de ejecución.

## Práctica guiada: distribución opcional

Añade este bloque bajo `<project>`, después de `<build>`:

```xml
<profiles>
  <profile>
    <id>distribucion</id>
    <build>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-shade-plugin</artifactId>
          <version>3.6.0</version>
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
      </plugins>
    </build>
  </profile>
  <profile>
    <id>informe</id>
    <properties>
      <maven.compiler.showWarnings>true</maven.compiler.showWarnings>
    </properties>
  </profile>
</profiles>
```

```bash
mvn clean package
mvn -Pdistribucion clean package
java -jar target/gestor-tareas-1.0.0-SNAPSHOT-all.jar
mvn -Pdistribucion,informe clean verify
mvn -Pdistribucion help:active-profiles
mvn -Pdistribucion help:effective-pom
```

El build normal genera el JAR convencional. El perfil `distribucion` genera además un JAR `-all` con dependencias y manifiesto ejecutable. Debe imprimir el JSON de la lección 06. El perfil `informe` activa avisos de compilación; no crea un informe HTML. Después de crear Wrapper, sustituye `mvn` por `./mvnw` o `.\mvnw.cmd`.

## Activación automática

Dentro de un perfil puedes añadir una de estas activaciones, según el caso:

```xml
<activation><property><name>informe</name><value>true</value></property></activation>
```

Se activa con `mvn -Dinforme=true compile`. Otros ejemplos son `<activation><jdk>[21,22)</jdk></activation>`, `<activation><os><family>Windows</family></os></activation>` y `<activation><file><exists>activar-informe.txt</exists></file></activation>`. La selección por JDK utiliza el Java con que corre Maven; no instala ni selecciona otro JDK.

Con `<activation><activeByDefault>true</activeByDefault></activation>`, el perfil se activa por defecto, pero se desactiva cuando se activa otro perfil del mismo POM. No lo uses como garantía permanente de una comprobación esencial.

## POM frente a settings

Los perfiles del POM pueden modificar dependencias, plugins y construcción. Los perfiles de settings admiten propiedades y repositorios, incluidos los de plugins; no admiten un bloque `<build>`. Settings puede activarlos con `<activeProfiles><activeProfile>repositorio-publico</activeProfile></activeProfiles>`.

## Comprobación y errores habituales

`help:active-profiles` muestra qué perfiles participan y `help:effective-pom` muestra el modelo resultante. Si dos perfiles alteran la misma propiedad, inspecciona el resultado en lugar de asumir que el orden de `-P` determina la prioridad.

## Ejercicio

Añade la activación por propiedad al perfil `informe` y comprueba su presencia con `mvn -Dinforme=true help:active-profiles`. Mantén `distribucion` como optativo.

## Qué debes recordar

Utiliza perfiles para variantes de construcción. Para cambiar un único valor que ya es una propiedad, suele bastar `-Dnombre=valor`. Las pruebas esenciales deben permanecer en el build normal.

Referencia: [Perfiles de Maven](https://maven.apache.org/guides/introduction/introduction-to-profiles).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/09-privados-mirrors-proxy/' | relative_url }}">← 09 · Repositorios privados, mirrors y proxy</a>
<a href="{{ '/maven/11-transitivas-scopes-conflictos/' | relative_url }}">11 · Dependencias transitivas, scopes y conflictos →</a>
</nav>
