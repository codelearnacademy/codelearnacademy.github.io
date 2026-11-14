---
layout: lesson
route: spring
lesson_id: leccion27
lesson_file: 27-crear-el-primer-proyecto-spring-boot
lesson_number: "27"
title: Crear el primer proyecto Spring Boot
description: Comprende cómo Spring Boot reduce configuración mediante starters, auto-configuración y convenciones.
permalink: /spring/leccion27/
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

# Crear el primer proyecto Spring Boot

Comprende cómo Spring Boot reduce configuración mediante starters, auto-configuración y convenciones.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Crear el primer proyecto Spring Boot** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Primer proyecto Spring Boot y configuración.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Abrir: Ejemplo api-tareas. Ejecutar: mvn spring-boot:run. Comprobar: GET /api/tareas devuelve 200.]({{ "/assets/images/spring/27-crear-el-primer-proyecto-spring-boot.webp" | relative_url }})

<div class="cla-lesson-nav"><a href='{{ "/spring/ejemplos/api-tareas.zip" | relative_url }}'>Descargar el proyecto base con JDK 21 y Spring Boot 4.1.2</a></div>

## Ejemplo guiado

Crea un proyecto con Java 21, Maven y `spring-boot-starter-webmvc`. Ejecuta:

```bash
./mvnw spring-boot:run
```



## Relación con el resto de la ruta

Boot aplica convenciones y auto-configuración sobre Spring Framework; Maven o Gradle siguen siendo responsables del build.



## Ejemplo adicional: aplicación práctica

```bash
./mvnw spring-boot:run
curl -i http://localhost:8080/api/tareas
```

Arranca la aplicación antes de realizar la primera petición HTTP.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Probar la API con Swagger UI

Con el ejemplo descargable en marcha, abre <a class="cla-maven-card-link" href="http://localhost:8080/swagger-ui/index.html">Swagger UI</a>. Despliega `GET /api/tareas`, pulsa **Try it out** y **Execute**, y comprueba el estado **200**. La [lección 37]({{ "/spring/leccion37/" | relative_url }}) muestra cómo crear y verificar una tarea desde la interfaz.

<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion109/' | relative_url }}">109 · Swagger UI y documentación OpenAPI</a>
</div>

## Ejercicios propuestos

1. Aplica **Crear el primer proyecto Spring Boot** en una aplicación Spring Boot mínima con Maven.
2. Ejecuta la aplicación con `./mvnw spring-boot:run` y observa qué configuración está activa.
3. Modifica un valor de configuración y registra cómo cambia el comportamiento sin editar las clases de negocio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Crear el primer proyecto Spring Boot** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion26/">← 26 · Qué problema resuelve Spring Boot</a>
  <a href="/spring/leccion28/">28 · @SpringBootApplication →</a>
</div>
