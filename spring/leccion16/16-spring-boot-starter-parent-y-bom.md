---
layout: lesson
route: spring
lesson_id: leccion16
lesson_file: 16-spring-boot-starter-parent-y-bom
lesson_number: "16"
title: Spring Boot Starter Parent y BOM
description: Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.
permalink: /spring/leccion16/
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
# Spring Boot Starter Parent y BOM

Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Spring Boot Starter Parent y BOM** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Maven y gestión de dependencias.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Parent: Hereda gestión y configuración. BOM: Importa versiones gestionadas.]({{ "/assets/images/spring/16-spring-boot-starter-parent-y-bom.webp" | relative_url }})

## Ejemplo guiado

Con Spring Boot parent, muchas versiones se omiten:

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>4.1.2</version>
</parent>
```



## Relación con el resto de la ruta

Maven resuelve bibliotecas. Spring gestiona objetos. El árbol Maven explica qué código existe en classpath; ApplicationContext explica qué objetos existen en ejecución.



## Ejemplo adicional: aplicación práctica

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>${spring-boot.version}</version>
    <relativePath/>
</parent>
```

En un proyecto real, la versión del parent debe ser resoluble; normalmente se escribe directamente en el POM.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Spring Boot Starter Parent y BOM** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Spring Boot Starter Parent y BOM** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion15/">← 15 · Dependencias transitivas de Spring</a>
  <a href="/spring/leccion17/">17 · Starters de Spring Boot →</a>
</div>
