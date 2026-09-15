---
layout: academy
title: Proyecto de práctica de Testing
permalink: /testing/ejemplos/
---

<main class="cla-main">
<section class="cla-section">
<div class="cla-container" markdown="1">

# Proyecto de práctica de Testing

Utiliza Java 21 y Maven para ejecutar los ejemplos de la ruta. Las versiones siguientes fijan una base de práctica; no pretenden ser las últimas disponibles. JUnit Jupiter incluye soporte de pruebas parametrizadas y AssertJ permite ejecutar los ejemplos de aserciones fluidas.

Guarda este archivo como `pom.xml` en una carpeta nueva:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.codelearn</groupId>
  <artifactId>practica-testing</artifactId>
  <version>1.0.0</version>
  <properties>
    <maven.compiler.release>21</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.11.0</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.assertj</groupId>
      <artifactId>assertj-core</artifactId>
      <version>3.26.3</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.13.0</version>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.5.2</version>
        <configuration><failIfNoTests>true</failIfNoTests></configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

Crea `src/test/java` y copia allí la clase completa de la lección que quieras practicar, con el nombre indicado. Los ejemplos sin paquete se guardan directamente en ese directorio. Ejecuta:

```bash
java -version
mvn -version
mvn test
```

Confirma que Maven utiliza Java 21. Los reportes aparecen en `target/surefire-reports`; comprueba el número de pruebas y los fallos. Para seleccionar una clase, utiliza por ejemplo `mvn -Dtest=Prueba21Test test`.

Los ejemplos aritméticos y los tipos pequeños están incluidos en los tests para hacerlos independientes. En una aplicación real las pruebas llaman al código productivo de `src/main/java`, en lugar de duplicar su implementación dentro del test.

Este POM ejecuta pruebas con Surefire. No configura automáticamente Failsafe, cobertura, servicios externos ni un despliegue. Añade esos elementos cuando la lección los requiera. Si la carpeta aún no contiene tests, el build falla de forma deliberada para evitar confundir ausencia de comprobaciones con éxito.

Referencias: [JUnit 5.11: guía](https://docs.junit.org/5.11.0/user-guide/), [Maven Surefire](https://maven.apache.org/surefire/maven-surefire-plugin/), [AssertJ](https://assertj.github.io/doc/).

[Volver a la ruta Testing]({{ '/testing/' | relative_url }})

</div>
</section>
</main>
