---
layout: lesson
route: spring
lesson_id: leccion17
lesson_file: 17-starters-de-spring-boot
lesson_number: "17"
title: Starters de Spring Boot
description: Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.
permalink: /spring/leccion17/
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
# Starters de Spring Boot

Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Starters de Spring Boot** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Maven y gestión de dependencias.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Starter: Elige una capacidad. Dependencias: Obtén el conjunto asociado. Aplicación: Usa la capacidad.]({{ "/assets/images/spring/17-starters-de-spring-boot.webp" | relative_url }})

## Ejemplo guiado

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
```

Después ejecuta:

```bash
mvn dependency:tree
```

y localiza Spring MVC y Tomcat.



## Relación con el resto de la ruta

Maven resuelve bibliotecas. Spring gestiona objetos. El árbol Maven explica qué código existe en classpath; ApplicationContext explica qué objetos existen en ejecución.



## Ejemplo adicional: aplicación práctica

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

El starter de validación permite utilizar Bean Validation en peticiones HTTP.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Starters de Spring Boot** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Starters de Spring Boot** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion16/">← 16 · Spring Boot Starter Parent y BOM</a>
  <a href="/spring/leccion18/">18 · ApplicationContext →</a>
</div>
