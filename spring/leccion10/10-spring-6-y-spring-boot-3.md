---
layout: lesson
route: spring
lesson_id: leccion10
lesson_file: 10-spring-6-y-spring-boot-3
lesson_number: "10"
title: Spring 6 y Spring Boot 3
description: Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.
permalink: /spring/leccion10/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Spring 6 y Spring Boot 3

Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Spring 6 y Spring Boot 3** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Fundamentos y versiones de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

Compara imports antiguos y modernos:

```java
// generaciones antiguas
javax.servlet.*

// Spring 6 / Boot 3 y posteriores
jakarta.servlet.*
```



## Relación con el resto de la ruta

La versión de Spring se relaciona con Java, Jakarta EE, Tomcat y librerías gestionadas por Spring Boot; evita combinar generaciones arbitrariamente.



## Ejemplo adicional: aplicación práctica

```xml
<properties>
    <java.version>17</java.version>
</properties>
<!-- Para Boot 3, usa una versión compatible del starter parent. -->
```

Fija las versiones compatibles de Spring Boot, Spring Framework y Java conjuntamente.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Spring 6 y Spring Boot 3** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Spring 6 y Spring Boot 3** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion09/">← 09 · Historia de Spring y Spring Boot</a>
  <a href="/spring/leccion11/">11 · Spring 7 y Spring Boot 4 →</a>
</div>
