---
layout: lesson
route: spring
lesson_id: leccion52
lesson_file: 52-cambiar-tomcat-por-otro-servidor
lesson_number: "52"
title: Cambiar Tomcat por otro servidor
description: Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.
permalink: /spring/leccion52/
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
# Cambiar Tomcat por otro servidor

Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Cambiar Tomcat por otro servidor** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Tomcat y empaquetado.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Dependencias: Selecciona el servidor. Arranque: Ejecuta la misma API. Comprobación: Identifica el servidor en el log.]({{ "/assets/images/spring/49-cambiar-tomcat-por-otro-servidor.webp" | relative_url }})

## Ejemplo guiado

Excluye Tomcat y añade Jetty como ejercicio conceptual. Comprueba qué cambia en el árbol Maven.



## Relación con el resto de la ruta

Tomcat implementa el runtime Servlet. Docker puede contener un JAR Boot con Tomcat embebido o un WAR dentro de Tomcat externo.



## Ejemplo adicional: aplicación práctica

```xml
<!-- Alternativa a Tomcat embebido: starter Jetty compatible con tu Boot. -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

Revisa las exclusiones del starter web correspondiente antes de cambiar de servidor.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Explica cómo interviene **Cambiar Tomcat por otro servidor** cuando arranca una aplicación Spring Boot.
2. Empaqueta la aplicación y comprueba si puede ejecutarse mediante `java -jar` o si necesita un contenedor externo.
3. Compara qué responsabilidad asume el servidor web y qué responsabilidad conserva Spring MVC.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Cambiar Tomcat por otro servidor** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion51/">← 51 · ¿Quién arranca a quién?</a>
  <a href="/spring/leccion53/">53 · JAR ejecutable →</a>
</div>
