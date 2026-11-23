---
layout: lesson
route: spring
lesson_id: leccion109
lesson_number: "109"
lesson_file: 109-swagger-openapi
title: Swagger UI y contrato OpenAPI
permalink: /spring/leccion109/
lessons:
  - id: openapi-y-swagger-ui
    title: "OpenAPI y Swagger UI"
  - id: probar-y-documentar
    title: "Probar y documentar"
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Swagger UI y contrato OpenAPI

![OpenAPI: Describe POST y sus respuestas. Swagger UI: Envía la petición de prueba. Resultado: Comprueba 201 o 400.]({{ "/assets/images/spring/109-swagger-openapi.webp" | relative_url }})

## OpenAPI y Swagger UI

OpenAPI describe las operaciones, parámetros, cuerpos y respuestas de la API. Swagger UI lee esa descripción y permite ejecutar peticiones desde el navegador. El ejemplo usa Spring Boot 4.1.2, JDK 21 y springdoc-openapi 3.2.0.

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>3.2.0</version>
</dependency>
```

La dependencia ya está en el [proyecto base]({{ '/spring/ejemplos/api-tareas.zip' | relative_url }}). Ejecuta `mvn spring-boot:run` desde la carpeta del proyecto.

## Probar y documentar

1. Abre [Swagger UI](http://localhost:8080/swagger-ui/index.html). En `POST /api/tareas`, pulsa **Try it out**, introduce `{"titulo":"Preparar entrega"}` y pulsa **Execute**.
2. Comprueba **Request URL**, el estado `201` y la cabecera `Location`. Consulta ese ID con `GET /api/tareas/{id}`. Repite el POST con un título en blanco y comprueba el `400`.
3. Abre [el JSON de OpenAPI](http://localhost:8080/v3/api-docs). Busca `paths`, localiza `/api/tareas` y compara la definición del POST con lo que muestra Swagger UI.
4. Documenta el resultado real del POST añadiendo estas anotaciones encima de `@PostMapping`. Los códigos documentados deben coincidir con los que compruebas al ejecutar la API.

```java
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
```

```java
@Operation(summary = "Crear una tarea")
@ApiResponse(responseCode = "201", description = "Tarea creada; Location identifica el recurso")
@ApiResponse(responseCode = "400", description = "Título inválido")
```

**Ejercicio breve.** Antes de añadir las anotaciones, compara el `400` real con el que aparezca en OpenAPI. Busca `application/problem+json` y el campo de validación `errores`. Anota qué información falta en la especificación y amplía la documentación de POST para describirla.

Reinicia la aplicación y comprueba que el resumen y ambos códigos aparecen en OpenAPI y en Swagger UI. Guarda la especificación con `curl -fsS http://localhost:8080/v3/api-docs -o openapi.json`. Entrega ese archivo y una evidencia de cada respuesta. [Documentación oficial de springdoc](https://springdoc.org/).


<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion108/' | relative_url }}">108 · Diseño de servicios REST</a>
</div>
