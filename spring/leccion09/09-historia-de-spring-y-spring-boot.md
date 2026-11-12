---
layout: lesson
route: spring
lesson_id: leccion09
lesson_file: 09-historia-de-spring-y-spring-boot
lesson_number: "09"
title: Historia de Spring y Spring Boot
description: Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.
permalink: /spring/leccion09/
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
# Historia de Spring y Spring Boot

Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Historia de Spring y Spring Boot** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Fundamentos y versiones de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

Construye una línea temporal:

```text
Spring Framework 4 → Spring Boot 1
Spring Framework 5 → Spring Boot 2
Spring Framework 6 → Spring Boot 3
Spring Framework 7 → Spring Boot 4
```



## Relación con el resto de la ruta

La versión de Spring se relaciona con Java, Jakarta EE, Tomcat y librerías gestionadas por Spring Boot; evita combinar generaciones arbitrariamente.


## Ejemplo adicional: comprobación de versiones

```bash
java -version
./mvnw -version
./mvnw dependency:tree -Dincludes=org.springframework
```

Estos comandos permiten comparar la versión de Java de la máquina con las dependencias de Spring utilizadas en el proyecto. Las versiones concretas deben contrastarse con la documentación de la edición que se esté estudiando.

**Comprueba:** distingue la evolución histórica de las versiones que realmente resuelve Maven.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Historia de Spring y Spring Boot** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Historia de Spring y Spring Boot** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion08/">← 08 · Spring Framework frente a Spring Boot</a>
  <a href="/spring/leccion10/">10 · Spring 6 y Spring Boot 3 →</a>
</div>
