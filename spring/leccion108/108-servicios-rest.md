---
layout: lesson
route: spring
lesson_id: leccion108
lesson_number: "108"
lesson_file: 108-servicios-rest
title: Diseño de servicios REST
permalink: /spring/leccion108/
lessons:
  - id: diseñar-el-contrato
    title: "Diseñar el contrato"
  - id: práctica-guiada
    title: "Práctica guiada"
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Diseño de servicios REST

![Cliente: Envía POST con la tarea. API REST: Valida y guarda la tarea. Respuesta: 201 y cabecera Location.]({{ "/assets/images/spring/108-servicios-rest.webp" | relative_url }})

## Diseñar el contrato

Un recurso es algo que el cliente puede identificar y consultar. En esta práctica, la colección es `/api/tareas` y una tarea concreta se identifica con `/api/tareas/{id}`. La URL HTTP identifica el recurso de la API. La ruta del JSON, el archivo SQLite y la URL JDBC de PostgreSQL identifican dónde guarda datos el repositorio.

| Operación | Petición | Respuesta esperada |
|---|---|---|
| Crear | `POST /api/tareas` con `{"titulo":"Preparar entrega"}` | `201 Created`, cabecera `Location` y tarea creada. |
| Listar | `GET /api/tareas` | `200 OK` y un array, incluso si está vacío. |
| Consultar | `GET /api/tareas/{id}` | `200 OK` o `404 Not Found`. |
| Cambiar el título | `PUT /api/tareas/{id}` con el nuevo título | `200 OK` con la tarea actualizada, `400` si es inválida o `404` si no existe. En esta práctica el título es el único campo editable. |
| Borrar | `DELETE /api/tareas/{id}` | `204 No Content` sin cuerpo o `404` si no existe. |

Usa `Content-Type: application/json` en las peticiones con cuerpo. Un título en blanco produce `400`. Cuando añadas los filtros, usa parámetros de consulta, por ejemplo `GET /api/tareas?titulo=entrega` o `GET /api/tareas?estado=pendiente` tras incorporar el campo estado.

## Práctica guiada

El [proyecto base]({{ '/spring/ejemplos/api-tareas.zip' | relative_url }}) implementa POST y los dos GET en memoria. Empieza por verificar ese contrato:

```sh
curl -i -H 'Content-Type: application/json' --data '{"titulo":"Preparar entrega"}' http://localhost:8080/api/tareas
curl -i http://localhost:8080/api/tareas/1
```

Usa el ID de la cabecera `Location` si la tarea creada tiene un ID distinto de 1. Prueba también un título vacío y un ID inexistente.

Añade `PUT` y `DELETE` al controlador. Antes de cambiar a fichero o SQL, extrae una interfaz `RepositorioTareas` e inyéctala por constructor en el servicio. Conserva las mismas peticiones de verificación para cada implementación. [Guía REST de Spring](https://spring.io/guides/gs/rest-service/).


<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion109/' | relative_url }}">109 · Swagger UI y documentación OpenAPI</a>
</div>
