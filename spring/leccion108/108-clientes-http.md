---
layout: lesson
route: spring
lesson_id: leccion108
lesson_file: 108-clientes-http
lesson_number: "108"
title: Clientes HTTP
description: Introduce mecanismos transversales de Spring y alternativas arquitectónicas sin perder el modelo mental.
permalink: /spring/leccion108/
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
# Clientes HTTP

Introduce mecanismos transversales de Spring y alternativas arquitectónicas sin perder el modelo mental.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Clientes HTTP** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Capacidades avanzadas de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Aplicación: Realiza la petición saliente. Cliente HTTP: Envía y recibe. Servicio: Interpreta la respuesta.]({{ "/assets/images/spring/105-clientes-http.webp" | relative_url }})

## Ejemplo guiado

Construye un cliente HTTP tipado o declarativo para consumir otra API y compáralo con llamadas manuales de bajo nivel.



## Relación con el resto de la ruta

AOP, proxies, eventos y cache explican parte del comportamiento transversal de Spring; MVC/WebFlux son modelos web distintos.



## Ejemplo adicional: aplicación práctica

```java
RestClient cliente = RestClient.builder()
    .baseUrl("https://api.ejemplo.test")
    .build();
String estado = cliente.get()
    .uri("/estado")
    .retrieve()
    .body(String.class);
```

En una aplicación real configura tiempos de espera y gestión de errores.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Construye un ejemplo pequeño y aislado de **Clientes HTTP**.
2. Compara su comportamiento con y sin la característica y explica en qué momento interviene Spring.
3. Crea una prueba que verifique el resultado observable y no solo la presencia de una anotación.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Clientes HTTP** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion107/">← 107 · Cache</a>
  <a href="/spring/leccion109/">109 · Spring MVC frente a WebFlux →</a>
</div>
