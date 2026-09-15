---
layout: lesson
route: spring
lesson_id: leccion34
lesson_file: 34-controller-frente-a-restcontroller
lesson_number: "34"
title: "@Controller frente a @RestController"
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion34/
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
# @Controller frente a @RestController

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

- Comprender el concepto de **@Controller frente a @RestController**.
- Aplicarlo sobre una aplicación Java/Spring pequeña.
- Relacionarlo con Maven, Tomcat, PostgreSQL, Git o Docker cuando corresponda.
- Diferenciar qué responsabilidad pertenece a Spring Framework y cuál a Spring Boot.

<div class="cla-note"><strong>Ruta de estudio</strong><p>La prioridad es comprender el modelo mental. No avances solo porque el proyecto compila: debes poder explicar quién crea los objetos, quién resuelve las bibliotecas, quién atiende HTTP y qué parte se ejecuta dentro del contenedor.</p></div>

## Punto de partida

Esta lección pertenece al bloque **Spring MVC y HTTP**.

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

- **HTTP**
- **DispatcherServlet**
- **controllers**
- **DTOs**

## Ejemplo guiado

En un proyecto Spring Boot Servlet con `spring-boot-starter-web` y `spring-boot-starter-thymeleaf`, coloca estas clases en el paquete de la aplicación o un subpaquete. Cada clase pública debe guardarse en su propio archivo; importa las anotaciones web desde `org.springframework.web.bind.annotation` y Controller desde `org.springframework.stereotype`.

```java
@Controller
public class PageController {
    @GetMapping("/pagina")
    public String pagina() {
        return "saludo";
    }

    @GetMapping("/texto")
    @ResponseBody
    public String texto() {
        return "Hola";
    }
}
```

Crea `src/main/resources/templates/saludo.html` con `<h1>Hola desde la vista</h1>`.

```java
@RestController
public class TaskController {
    public record Saludo(String mensaje) {}

    @GetMapping("/api/saludo")
    public Saludo saludo() {
        return new Saludo("Hola");
    }
}
```

Con la aplicación arrancada en el puerto 8080, consulta `curl -i http://localhost:8080/pagina`, `/texto` y `/api/saludo`. Espera HTML renderizado, texto `Hola` y JSON `{"mensaje":"Hola"}` respectivamente. Sin la plantilla o un motor de vistas, devolver `saludo` no basta para producir esa página.

`@RestController` incorpora la semántica de `@ResponseBody`; los convertidores escriben la respuesta. También puede devolverse un cuerpo desde `@Controller`, como demuestra `/texto`. Un RestController no obliga a devolver siempre JSON: depende del valor, los convertidores y la negociación de contenido.

Referencia: [valores de retorno de Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/return-types.html).


## Relación con el resto de la ruta

Los clientes consumen un contrato HTTP cuyo cuerpo puede ser JSON, texto, HTML u otro formato acordado. El contrato API debe ser independiente de la implementación concreta del frontend.

Cuando utilices una anotación o dependencia, intenta responder siempre:

```text
¿Quién la proporciona?
¿Quién la interpreta?
¿Cuándo actúa?
¿Está relacionada con build, runtime, HTTP, datos o infraestructura?
```

## Ejercicios propuestos

1. Reproduce el ejemplo de **@Controller frente a @RestController** y documenta qué cambia en el proyecto.
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
  <a href="/spring/leccion33/">← 33 · Qué ocurre cuando llega una petición HTTP</a>
  <a href="/spring/leccion35/">35 · @RequestMapping →</a>
</div>
