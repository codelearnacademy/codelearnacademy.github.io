---
layout: lesson
route: spring
lesson_id: leccion01
lesson_file: 01-de-java-tradicional-a-aplicaciones-empresariales
lesson_number: "01"
title: De Java tradicional a aplicaciones empresariales
description: Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.
permalink: /spring/leccion01/
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
# De Java tradicional a aplicaciones empresariales

Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.

## Qué vas a conseguir

- Comprender el concepto de **De Java tradicional a aplicaciones empresariales**.
- Aplicarlo sobre una aplicación Java/Spring pequeña.
- Relacionarlo con Maven, Tomcat, PostgreSQL, Git o Docker cuando corresponda.
- Diferenciar qué responsabilidad pertenece a Spring Framework y cuál a Spring Boot.

<div class="cla-note"><strong>Ruta de estudio</strong><p>La prioridad es comprender el modelo mental. No avances solo porque el proyecto compila: debes poder explicar quién crea los objetos, quién resuelve las bibliotecas, quién atiende HTTP y qué parte se ejecuta dentro del contenedor.</p></div>

## Punto de partida

Esta lección pertenece al bloque **Fundamentos: el problema que Spring resuelve**.

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

- **acoplamiento**
- **IoC**
- **Dependency Injection**
- **diseño**

## Ejemplo guiado

Partimos de código Java que crea manualmente todos sus colaboradores:

```java
var repository = new PedidoRepositoryJdbc();
var email = new EmailService();
var service = new PedidoService(repository, email);
var controller = new PedidoController(service);
```

Añade una segunda implementación de `EmailService` y observa cuántos lugares debes modificar.



## Relación con el resto de la ruta

Relaciona estas ideas con SOLID y Clean Code: Spring puede facilitar el desacoplamiento, pero no sustituye un buen diseño.

Cuando utilices una anotación o dependencia, intenta responder siempre:

```text
¿Quién la proporciona?
¿Quién la interpreta?
¿Cuándo actúa?
¿Está relacionada con build, runtime, HTTP, datos o infraestructura?
```

## Ejercicios propuestos

1. Reproduce el ejemplo de **De Java tradicional a aplicaciones empresariales** y documenta qué cambia en el proyecto.
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
  <span></span>
  <a href="/spring/leccion02/">02 · Acoplamiento entre clases →</a>
</div>
