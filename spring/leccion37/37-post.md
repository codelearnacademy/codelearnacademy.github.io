---
layout: lesson
route: spring
lesson_id: leccion37
lesson_file: 37-post
lesson_number: "37"
title: POST
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion37/
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
# POST

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **POST** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```java
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
TaskDto create(@RequestBody CreateTaskRequest request) {
    return service.create(request);
}
```



## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

```java
@PostMapping
ResponseEntity<TareaResponse> crear(@Valid @RequestBody TareaRequest request) {
    TareaResponse creada = servicio.crear(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(creada);
}
```

POST recibe un DTO de entrada y devuelve 201 cuando se crea el recurso.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **POST**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **POST** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion36/">← 36 · GET</a>
  <a href="/spring/leccion38/">38 · Path variables →</a>
</div>
