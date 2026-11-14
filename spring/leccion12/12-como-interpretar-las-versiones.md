---
layout: lesson
route: spring
lesson_id: leccion12
lesson_file: 12-como-interpretar-las-versiones
lesson_number: "12"
title: Cómo interpretar las versiones
description: Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.
permalink: /spring/leccion12/
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
# Cómo interpretar las versiones

Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Cómo interpretar las versiones** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Fundamentos y versiones de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Identificar: Lee la versión exacta de Boot. Comprobar: Contrasta Java, Spring y Servlet.]({{ "/assets/images/spring/12-como-interpretar-las-versiones.webp" | relative_url }})

## Ejemplo guiado

No fijes Spring Framework manualmente si Spring Boot ya gestiona la versión:

```text
Spring Boot version
      ↓
dependency management
      ↓
Spring Framework + Tomcat + Jackson + Hibernate + ...
```



## Relación con el resto de la ruta

La versión de Spring se relaciona con Java, Jakarta EE, Tomcat y librerías gestionadas por Spring Boot; evita combinar generaciones arbitrariamente.



## Ejemplo adicional: aplicación práctica

```bash
./mvnw dependency:tree
./mvnw help:effective-pom
java -version
```

Estos comandos permiten comprobar dependencias resueltas y versión de Java.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Cómo interpretar las versiones** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Cómo interpretar las versiones** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion11/">← 11 · Spring 7 y Spring Boot 4</a>
  <a href="/spring/leccion13/">13 · Incorporar Spring con Maven →</a>
</div>
