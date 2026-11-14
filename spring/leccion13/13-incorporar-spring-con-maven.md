---
layout: lesson
route: spring
lesson_id: leccion13
lesson_file: 13-incorporar-spring-con-maven
lesson_number: "13"
title: Incorporar Spring con Maven
description: Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.
permalink: /spring/leccion13/
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
# Incorporar Spring con Maven

Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Incorporar Spring con Maven** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Maven y gestión de dependencias.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![pom.xml: Declara Spring. Maven: Resuelve bibliotecas. Classpath: Spring queda disponible.]({{ "/assets/images/spring/13-incorporar-spring-con-maven.webp" | relative_url }})

## Ejemplo guiado

Proyecto Spring Framework sin Boot:

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>7.0.10</version>
</dependency>
```



## Relación con el resto de la ruta

Maven resuelve bibliotecas. Spring gestiona objetos. El árbol Maven explica qué código existe en classpath; ApplicationContext explica qué objetos existen en ejecución.



## Ejemplo adicional: aplicación práctica

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>${spring.version}</version>
</dependency>
```

En Spring Framework sin Boot debes gestionar la compatibilidad de versiones.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Incorporar Spring con Maven** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Incorporar Spring con Maven** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion12/">← 12 · Cómo interpretar las versiones</a>
  <a href="/spring/leccion14/">14 · Maven no hace Dependency Injection →</a>
</div>
