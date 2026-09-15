---
layout: lesson
route: spring
lesson_id: leccion24
lesson_file: 24-scopes-de-los-beans
lesson_number: "24"
title: Scopes de los beans
description: Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.
permalink: /spring/leccion24/
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
# Scopes de los beans

Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.

## Qué vas a conseguir

- Comprender el concepto de **Scopes de los beans**.
- Aplicarlo sobre una aplicación Java/Spring pequeña.
- Relacionarlo con Maven, Tomcat, PostgreSQL, Git o Docker cuando corresponda.
- Diferenciar qué responsabilidad pertenece a Spring Framework y cuál a Spring Boot.

<div class="cla-note"><strong>Ruta de estudio</strong><p>La prioridad es comprender el modelo mental. No avances solo porque el proyecto compila: debes poder explicar quién crea los objetos, quién resuelve las bibliotecas, quién atiende HTTP y qué parte se ejecuta dentro del contenedor.</p></div>

## Punto de partida

Esta lección pertenece al bloque **Spring Core sin Spring Boot**.

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

- **ApplicationContext**
- **beans**
- **component scanning**
- **inyección**

## Ejemplo guiado

`singleton` significa una instancia por **definición de bean y contenedor**, no una sola instancia de cada clase en toda la aplicación. `prototype` crea una instancia por solicitud al contenedor; inyectarlo una vez en un singleton no crea automáticamente uno nuevo en cada uso.

```java
@Configuration
class Config {
    @Bean StringBuilder primero() { return new StringBuilder(); }
    @Bean StringBuilder segundo() { return new StringBuilder(); }
    @Bean @Scope("prototype")
    StringBuilder temporal() { return new StringBuilder(); }
}
```

Importa las anotaciones de `org.springframework.context.annotation`. Con Spring Context configurado, ejecuta dentro de un método:

```java
try (var context = new AnnotationConfigApplicationContext(Config.class)) {
    System.out.println(context.getBean("primero") == context.getBean("primero"));
    System.out.println(context.getBean("primero") == context.getBean("segundo"));
    System.out.println(context.getBean("temporal") == context.getBean("temporal"));
}
```

Importa también `AnnotationConfigApplicationContext` desde ese paquete. El resultado es `true`, `false`, `false`. Hay dos beans singleton de StringBuilder y no son el mismo objeto. Para obtener prototipos repetidamente desde un singleton, utiliza una solicitud explícita, por ejemplo mediante `ObjectProvider`.

Referencia: [scopes de Spring](https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html).


## Relación con el resto de la ruta

Estos conceptos existen aunque no uses Spring Boot. Entenderlos evita tratar las anotaciones de Boot como magia.

Cuando utilices una anotación o dependencia, intenta responder siempre:

```text
¿Quién la proporciona?
¿Quién la interpreta?
¿Cuándo actúa?
¿Está relacionada con build, runtime, HTTP, datos o infraestructura?
```

## Ejercicios propuestos

1. Reproduce el ejemplo de **Scopes de los beans** y documenta qué cambia en el proyecto.
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
  <a href="/spring/leccion23/">← 23 · Varias implementaciones: @Qualifier y @Primary</a>
  <a href="/spring/leccion25/">25 · Ciclo de vida del bean →</a>
</div>
