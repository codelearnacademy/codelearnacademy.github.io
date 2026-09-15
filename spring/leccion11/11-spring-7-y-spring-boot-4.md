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
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Spring 7 y Spring Boot 4

Aprende a interpretar generaciones de Spring, Spring Boot, Java, Jakarta y servidores Servlet.

## Qué vas a conseguir

- Comprender el concepto de **Spring 7 y Spring Boot 4**.
- Aplicarlo sobre una aplicación Java/Spring pequeña.
- Relacionarlo con Maven, Tomcat, PostgreSQL, Git o Docker cuando corresponda.
- Diferenciar qué responsabilidad pertenece a Spring Framework y cuál a Spring Boot.

<div class="cla-note"><strong>Ruta de estudio</strong><p>La prioridad es comprender el modelo mental. No avances solo porque el proyecto compila: debes poder explicar quién crea los objetos, quién resuelve las bibliotecas, quién atiende HTTP y qué parte se ejecuta dentro del contenedor.</p></div>

## Punto de partida

Esta lección pertenece al bloque **Historia y versiones**.

Mantén este mapa durante toda la ruta:

```text
Maven
  ↓ bibliotecas y build
Spring Framework
  ↓ objetos, IoC, MVC, transacciones...
Spring Boot
  ↓ auto-configuración + aplicación ejecutable
Tomcat
  ↓ runtime Servlet / HTTP
PostgreSQL
  ↓ persistencia
Docker
  ↓ entorno reproducible
Git + CI/CD
  ↓ versionado, verificación y entrega
```

## Conceptos clave

- **versiones**
- **compatibilidad**
- **Jakarta**
- **Tomcat**

## Ejemplo guiado

En la generación actual de la ruta:

```text
Java 21
Spring Boot 4.1.x
Spring Framework 7.0.x
Tomcat 11.x
Jakarta Servlet 6.1
```


<div class="cla-note"><strong>Base de la ruta</strong><p>La ruta utiliza Java 21 y la generación Spring Boot 4 / Spring Framework 7. Spring Boot 4.1.1 requiere como mínimo Java 17, usa Spring Framework 7.0.9 o superior y soporta Tomcat 11.0.x para el stack Servlet.</p></div>


## Relación con el resto de la ruta

La versión de Spring se relaciona con Java, Jakarta EE, Tomcat y librerías gestionadas por Spring Boot; evita combinar generaciones arbitrariamente.

Cuando utilices una anotación o dependencia, intenta responder siempre:

```text
¿Quién la proporciona?
¿Quién la interpreta?
¿Cuándo actúa?
¿Está relacionada con build, runtime, HTTP, datos o infraestructura?
```

## Ejercicios propuestos

1. Reproduce el ejemplo de **Spring 7 y Spring Boot 4** y documenta qué cambia en el proyecto.
2. Introduce una variación controlada, predice el resultado antes de ejecutarla y comprueba si tu predicción era correcta.
3. Explica qué responsabilidad corresponde a Spring, cuál a Spring Boot y cuál a Maven/Git/Docker en este escenario.

### Ejercicio de explicación

Sin ejecutar código, explica a otra persona:

- qué problema resuelve esta lección;
- qué ocurriría si eliminases la configuración o dependencia principal;
- cómo comprobarías el comportamiento con una prueba;
- si el concepto pertenece a Spring Framework, Spring Boot o a otra herramienta.

## Qué debes recordar

- **Maven** resuelve dependencias y construye; no realiza inyección de objetos.
- **Spring Framework** contiene el contenedor IoC y los módulos fundamentales.
- **Spring Boot** se apoya en Spring Framework y reduce configuración repetitiva.
- **Tomcat** participa en el stack Servlet, embebido o como servidor externo.
- El código debe poder probarse y construirse antes de empaquetarlo con Docker.

<div class="cla-lesson-nav">
  <a href="/spring/leccion10/">← 10 · Spring 6 y Spring Boot 3</a>
  <a href="/spring/leccion12/">12 · Cómo interpretar las versiones →</a>
</div>
