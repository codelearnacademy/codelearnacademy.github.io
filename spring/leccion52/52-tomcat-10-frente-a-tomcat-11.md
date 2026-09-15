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
# Tomcat 10 frente a Tomcat 11

Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.

## Qué vas a conseguir

- Comprender el concepto de **Tomcat 10 frente a Tomcat 11**.
- Aplicarlo sobre una aplicación Java/Spring pequeña.
- Relacionarlo con Maven, Tomcat, PostgreSQL, Git o Docker cuando corresponda.
- Diferenciar qué responsabilidad pertenece a Spring Framework y cuál a Spring Boot.

<div class="cla-note"><strong>Ruta de estudio</strong><p>La prioridad es comprender el modelo mental. No avances solo porque el proyecto compila: debes poder explicar quién crea los objetos, quién resuelve las bibliotecas, quién atiende HTTP y qué parte se ejecuta dentro del contenedor.</p></div>

## Punto de partida

Esta lección pertenece al bloque **Spring Boot y Tomcat**.

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

- **Servlet**
- **Tomcat**
- **JAR**
- **WAR**

## Ejemplo guiado

Relaciona generaciones:

```text
Boot 3 / Spring 6 → Jakarta Servlet 6.0 → Tomcat 10.1 habitual
Boot 4 / Spring 7 → Jakarta Servlet 6.1 → Tomcat 11
```


<div class="cla-note"><strong>Regla de compatibilidad</strong><p>No mezcles al azar Spring, Jakarta Servlet y Tomcat de generaciones distintas. Deja que Spring Boot gestione las versiones compatibles siempre que sea posible.</p></div>


## Relación con el resto de la ruta

Tomcat implementa el runtime Servlet. Docker puede contener un JAR Boot con Tomcat embebido o un WAR dentro de Tomcat externo.

Cuando utilices una anotación o dependencia, intenta responder siempre:

```text
¿Quién la proporciona?
¿Quién la interpreta?
¿Cuándo actúa?
¿Está relacionada con build, runtime, HTTP, datos o infraestructura?
```

## Ejercicios propuestos

1. Reproduce el ejemplo de **Tomcat 10 frente a Tomcat 11** y documenta qué cambia en el proyecto.
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
  <a href="/spring/leccion51/">← 51 · WAR tradicional</a>
  <a href="/spring/leccion53/">53 · Controller, Service y Repository →</a>
</div>
