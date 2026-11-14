---
layout: lesson
route: spring
lesson_id: leccion11
lesson_file: 11-spring-7-y-spring-boot-4
lesson_number: "11"
title: Spring 7 y Spring Boot 4
description: Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.
permalink: /spring/leccion11/
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

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>
# Spring 7 y Spring Boot 4

Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Spring 7 y Spring Boot 4** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Fundamentos y versiones de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![JDK 21: Base del aula. Boot 4.1.2: Spring Framework 7. Tomcat 11: Jakarta Servlet 6.1.]({{ "/assets/images/spring/11-spring-7-y-spring-boot-4.webp" | relative_url }})

## Ejemplo guiado

En la generación actual de la ruta:

```text
Java 21
Spring Boot 4.1.x
Spring Framework 7.0.x
Tomcat 11.x
Jakarta Servlet 6.1
```


<div class="cla-note"><strong>Base de la ruta</strong><p>La ruta utiliza Java 21 y la generación Spring Boot 4 / Spring Framework 7. Spring Boot 4.1.2 requiere como mínimo Java 17, usa Spring Framework 7.0.10 o superior y soporta Tomcat 11.0.x para el stack Servlet.</p></div>


## Relación con el resto de la ruta

La versión de Spring se relaciona con Java, Jakarta EE, Tomcat y librerías gestionadas por Spring Boot; evita combinar generaciones arbitrariamente.



## Ejemplo adicional: aplicación práctica

```xml
<!-- Al migrar a Boot 4, revisa starters y dependencias Jakarta. -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
```

La lista exacta de starters depende de la versión: consulta la documentación de la versión usada.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Spring 7 y Spring Boot 4** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Spring 7 y Spring Boot 4** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion10/">← 10 · Spring 6 y Spring Boot 3</a>
  <a href="/spring/leccion12/">12 · Cómo interpretar las versiones →</a>
</div>
