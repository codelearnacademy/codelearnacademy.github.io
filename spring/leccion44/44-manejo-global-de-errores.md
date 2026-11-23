---
layout: lesson
route: spring
lesson_id: leccion44
lesson_file: 44-manejo-global-de-errores
lesson_number: "44"
title: Manejo global de errores con ProblemDetail
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion44/
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
# Manejo global de errores con ProblemDetail

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Manejo global de errores** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Excepción: La tarea no existe. Advice: Traduce el error. Respuesta: 404 con un cuerpo común.]({{ "/assets/images/spring/44-manejo-global-de-errores.webp" | relative_url }})

## Ejemplo guiado

### 1. Inspeccionar un problema HTTP

El ejemplo incluye `ErroresRest`, una clase `@RestControllerAdvice` que extiende `ResponseEntityExceptionHandler`. Spring transforma las excepciones MVC que reconoce este manejador en respuestas `ProblemDetail`. El controlador señala la ausencia de una tarea con una `ResponseStatusException` de estado `404`.

**Ejercicio breve.** Con el ejemplo recién arrancado, ejecuta `curl -i http://localhost:8080/api/tareas/999999`. Identifica el estado de la respuesta, el tipo `application/problem+json` y los campos `status`, `detail` e `instance`. Distingue el código HTTP del valor incluido en el cuerpo.

### 2. Indicar qué campo falló

Al fallar `@Valid`, el manejador añade la lista `errores` al problema. Cada entrada indica el campo y su mensaje. El texto del mensaje puede variar según el idioma configurado.

```json
{
  "title": "Bad Request",
  "status": 400,
  "detail": "Revisa los campos indicados.",
  "errores": [{"campo": "titulo", "mensaje": "must not be blank"}]
}
```

**Ejercicio breve.** Envía un POST con `{"titulo":" "}` y otro con el cuerpo `{`. Ambos deben devolver `400`. Localiza `errores` en la respuesta de validación y explica por qué el cuerpo incompleto falla antes de validar campos.

## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

**Ejercicio breve.** Localiza el texto «Revisa los campos indicados» en `ErroresRest.java`. Cámbialo, reinicia el ejemplo y comprueba que cambia `detail` y el estado sigue siendo `400`. En una aplicación real, conserva los detalles internos de un fallo inesperado en el registro del servidor y expón un mensaje genérico al cliente.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **Manejo global de errores**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Manejo global de errores** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion43/">← 43 · ResponseEntity</a>
  <a href="/spring/leccion45/">45 · Validación →</a>
</div>
