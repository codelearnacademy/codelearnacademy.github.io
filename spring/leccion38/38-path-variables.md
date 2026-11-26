---
layout: lesson
route: spring
lesson_id: leccion38
lesson_file: 38-path-variables
lesson_number: "38"
title: Path variables
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion38/
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
# Path variables

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Path variables** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![URL: /api/tareas/1. @PathVariable: Extrae el id 1. Resultado: Una tarea o 404.]({{ "/assets/images/spring/38-path-variables.webp" | relative_url }})

## Ejemplo guiado

`@PathVariable` extrae un dato de la ruta, por ejemplo, el ID de `/api/tareas/12`. PATCH es el método HTTP de actualización parcial. Una petición `PATCH /api/tareas/12` combina ambos conceptos: PATCH indica qué operación realizar y `12` identifica sobre qué tarea.

**Ejercicio breve.** Predice qué devuelve GET para un ID existente, un número inexistente y un texto como `abc`. Prueba las tres URLs en la API base. Espera `200`, `404` y `400`, respectivamente.

```java
@GetMapping("/{id}")
TaskDto findById(@PathVariable Long id) {
    return service.findById(id);
}
```



## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

```java
@GetMapping("/{id}")
ResponseEntity<TareaResponse> buscar(@PathVariable Long id) {
    return servicio.buscar(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
}
```

Prueba un ID existente y otro inexistente. En la [práctica de servicios REST]({{ "/spring/leccion111/" | relative_url }}) verás cómo PUT, PATCH y DELETE también usan `@PathVariable` para identificar la tarea.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **Path variables**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Path variables** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion37/">← 37 · POST</a>
  <a href="{{ '/spring/leccion39/' | relative_url }}">PUT →</a>
</div>
