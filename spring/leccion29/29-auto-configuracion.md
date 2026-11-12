---
layout: lesson
route: spring
lesson_id: leccion29
lesson_file: 29-auto-configuracion
lesson_number: "29"
title: Auto-configuración
description: Comprende cómo Spring Boot reduce configuración mediante starters, auto-configuración y convenciones.
permalink: /spring/leccion29/
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
# Auto-configuración

Comprende cómo Spring Boot reduce configuración mediante starters, auto-configuración y convenciones.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Auto-configuración** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Primer proyecto Spring Boot y configuración.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

Añade `spring-boot-starter-webmvc` y observa que Boot configura infraestructura web porque ciertas clases están en el classpath.



## Relación con el resto de la ruta

Boot aplica convenciones y auto-configuración sobre Spring Framework; Maven o Gradle siguen siendo responsables del build.



## Ejemplo adicional: aplicación práctica

```properties
debug=true
server.port=8080
spring.main.banner-mode=off
```

Activa temporalmente el informe de auto-configuración para estudiar sus condiciones.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Aplica **Auto-configuración** en una aplicación Spring Boot mínima con Maven.
2. Ejecuta la aplicación con `./mvnw spring-boot:run` y observa qué configuración está activa.
3. Modifica un valor de configuración y registra cómo cambia el comportamiento sin editar las clases de negocio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Auto-configuración** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion28/">← 28 · @SpringBootApplication</a>
  <a href="/spring/leccion30/">30 · Convention over configuration →</a>
</div>
