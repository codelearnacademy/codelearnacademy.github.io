---
layout: lesson
route: spring
lesson_id: leccion07
lesson_file: 07-el-ecosistema-spring
lesson_number: "07"
title: El ecosistema Spring
description: Sitúa Spring Framework y Spring Boot dentro del ecosistema y distingue sus responsabilidades.
permalink: /spring/leccion07/
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
# El ecosistema Spring

Sitúa Spring Framework y Spring Boot dentro del ecosistema y distingue sus responsabilidades.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **El ecosistema Spring** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Fundamentos y versiones de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

### Situación guiada

Trabaja sobre un proyecto `tasks-api` y aplica **El ecosistema Spring**.

1. Parte de un estado conocido y con tests en verde.
2. Haz un único cambio relacionado con el concepto.
3. Ejecuta `./mvnw test` o `./mvnw verify`.
4. Inspecciona logs, contexto o respuesta HTTP según corresponda.
5. Registra qué comportamiento proviene de Spring Framework y cuál de Spring Boot.




## Relación con el resto de la ruta

Spring Boot se apoya en Spring Framework. Spring Data, Security y otros proyectos amplían responsabilidades concretas del ecosistema.



## Ejemplo adicional: aplicación práctica

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
</dependencies>
```

Cada starter incorpora un conjunto de dependencias relacionado con una capacidad.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **El ecosistema Spring** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **El ecosistema Spring** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion06/">← 06 · Qué es Spring Framework</a>
  <a href="/spring/leccion08/">08 · Spring Framework frente a Spring Boot →</a>
</div>
