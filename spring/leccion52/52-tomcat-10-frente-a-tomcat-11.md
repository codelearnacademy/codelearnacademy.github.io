---
layout: lesson
route: spring
lesson_id: leccion52
lesson_file: 52-tomcat-10-frente-a-tomcat-11
lesson_number: "52"
title: Tomcat 10 frente a Tomcat 11
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
# Tomcat 10 frente a Tomcat 11

Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Tomcat 10 frente a Tomcat 11** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Tomcat y empaquetado.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

Relaciona generaciones:

```text
Boot 3 / Spring 6 → Jakarta Servlet 6.0 → Tomcat 10.1 habitual
Boot 4 / Spring 7 → Jakarta Servlet 6.1 → Tomcat 11
```


<div class="cla-note"><strong>Regla de compatibilidad</strong><p>No mezcles al azar Spring, Jakarta Servlet y Tomcat de generaciones distintas. Deja que Spring Boot gestione las versiones compatibles siempre que sea posible.</p></div>


## Relación con el resto de la ruta

Tomcat implementa el runtime Servlet. Docker puede contener un JAR Boot con Tomcat embebido o un WAR dentro de Tomcat externo.



## Ejemplo adicional: aplicación práctica

```bash
java -version
./mvnw dependency:tree -Dincludes=org.apache.tomcat.embed
```

Comprueba qué versión de Tomcat resuelve realmente el proyecto.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Explica cómo interviene **Tomcat 10 frente a Tomcat 11** cuando arranca una aplicación Spring Boot.
2. Empaqueta la aplicación y comprueba si puede ejecutarse mediante `java -jar` o si necesita un contenedor externo.
3. Compara qué responsabilidad asume el servidor web y qué responsabilidad conserva Spring MVC.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Tomcat 10 frente a Tomcat 11** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion51/">← 51 · WAR tradicional</a>
  <a href="/spring/leccion53/">53 · Controller, Service y Repository →</a>
</div>
