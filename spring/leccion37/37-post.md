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

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

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

## Infografía

![El cliente envía POST /api/tareas con Preparar entrega. El controlador valida, el servicio guarda en memoria y la API devuelve 201 con Location. Si el título está en blanco devuelve 400.]({{ "/assets/images/spring/37-post.webp" | relative_url }})

<div class="cla-lesson-nav"><a href='{{ "/spring/ejemplos/api-tareas.zip" | relative_url }}'>Descargar el proyecto base con JDK 21 y Spring Boot 4.1.2</a></div>

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

## Probar la API con Swagger UI

1. Arranca el ejemplo con `mvn spring-boot:run`.
2. Abre <a class="cla-maven-card-link" href="http://localhost:8080/swagger-ui/index.html">Swagger UI</a>. La descripción OpenAPI está en [`/v3/api-docs`](http://localhost:8080/v3/api-docs).
3. Despliega `POST /api/tareas`, pulsa **Try it out**, escribe `{"titulo":"Preparar entrega"}` y pulsa **Execute**. Comprueba el **201** y copia el identificador que aparece en el cuerpo o en la cabecera `Location`.
4. Abre `GET /api/tareas/{id}`, escribe ese identificador y verifica el **200** y el título. Repite el POST con `{"titulo":" "}` y verifica el **400**.

Observa el campo **Request URL**. Es la URL HTTP que recibe la petición. Cuando cambies el almacenamiento a fichero, SQLite o PostgreSQL, podrás repetir la práctica desde la misma interfaz y comprobar el dato en el almacenamiento de ese perfil.

El ejemplo de partida ofrece creación y consulta. Cuando implementes actualización, borrado y búsquedas en el controlador, springdoc incorporará esas operaciones a Swagger UI.

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
