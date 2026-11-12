---
layout: lesson
route: spring
lesson_id: leccion51
lesson_file: 51-war-tradicional
lesson_number: "51"
title: WAR tradicional
description: Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.
permalink: /spring/leccion51/
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
# WAR tradicional

Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **WAR tradicional** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Tomcat y empaquetado.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```xml
<packaging>war</packaging>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-tomcat</artifactId>
  <scope>provided</scope>
</dependency>
```



## Relación con el resto de la ruta

Tomcat implementa el runtime Servlet. Docker puede contener un JAR Boot con Tomcat embebido o un WAR dentro de Tomcat externo.



## Ejemplo adicional: aplicación práctica

```xml
<packaging>war</packaging>
<!-- Para Tomcat externo, adapta el starter del contenedor al despliegue. -->
```

El empaquetado WAR requiere configuración adicional del arranque y servidor.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Explica cómo interviene **WAR tradicional** cuando arranca una aplicación Spring Boot.
2. Empaqueta la aplicación y comprueba si puede ejecutarse mediante `java -jar` o si necesita un contenedor externo.
3. Compara qué responsabilidad asume el servidor web y qué responsabilidad conserva Spring MVC.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **WAR tradicional** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion50/">← 50 · JAR ejecutable</a>
  <a href="/spring/leccion52/">52 · Tomcat 10 frente a Tomcat 11 →</a>
</div>
