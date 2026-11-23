---
layout: lesson
route: spring
lesson_id: leccion108
lesson_number: "108"
lesson_file: 108-servicios-rest
title: Diseño de servicios REST y práctica CRUD
permalink: /spring/leccion108/
lessons:
  - id: diseñar-el-contrato
    title: "Diseñar el contrato"
  - id: implementar-put-patch-y-delete
    title: "Implementar PUT, PATCH y DELETE"
  - id: práctica-guiada
    title: "Práctica guiada"
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Diseño de servicios REST y práctica CRUD

![Cliente: Envía POST con la tarea. API REST: Valida y guarda la tarea. Respuesta: 201 y cabecera Location.]({{ "/assets/images/spring/108-servicios-rest.webp" | relative_url }})

## Diseñar el contrato

Un recurso es algo que el cliente puede identificar y consultar. En esta práctica, la colección es `/api/tareas` y una tarea concreta se identifica con `/api/tareas/{id}`. La URL HTTP identifica el recurso de la API. La ruta del JSON, el archivo SQLite y la URL JDBC de PostgreSQL identifican dónde guarda datos el repositorio.

| Operación | Petición | Respuesta esperada |
|---|---|---|
| Crear | `POST /api/tareas` con `{"titulo":"Preparar entrega"}` | `201 Created`, cabecera `Location` y tarea creada. |
| Listar | `GET /api/tareas` | `200 OK` y un array, incluso si está vacío. |
| Consultar | `GET /api/tareas/{id}` | `200 OK` o `404 Not Found`. |
| Cambiar el título | `PUT /api/tareas/{id}` con el nuevo título | `200 OK` con la tarea actualizada, `400` si es inválida o `404` si no existe. En esta práctica el título es el único campo editable. |
| Modificar parcialmente | `PATCH /api/tareas/{id}` con `{"titulo":"Entrega final"}` | `200 OK` con la tarea actualizada, `400` si el cambio es inválido o `404` si no existe. |
| Borrar | `DELETE /api/tareas/{id}` | `204 No Content` sin cuerpo o `404` si no existe. |

Usa `Content-Type: application/json` en las peticiones con cuerpo. Un título en blanco produce `400`. Cuando añadas los filtros, usa parámetros de consulta, por ejemplo `GET /api/tareas?titulo=entrega` o `GET /api/tareas?estado=pendiente` tras incorporar el campo estado.

Para ejecutar los ejercicios, descarga el [ejemplo de tareas]({{ '/spring/ejemplos/api-tareas.zip' | relative_url }}) y arráncalo con `mvn spring-boot:run`.

**Ejercicio breve.** Dibuja las dos URLs de la tabla. Coloca POST en la colección y PUT y DELETE en una tarea concreta. Predice qué ocurrirá si envías DELETE a la colección y comprueba el `405` con `curl -i -X DELETE http://localhost:8080/api/tareas`.

## Implementar PUT, PATCH y DELETE

Practica cada método en su propia lección: [PUT]({{ '/spring/leccion110/' | relative_url }}), [PATCH]({{ '/spring/leccion111/' | relative_url }}) y [DELETE]({{ '/spring/leccion112/' | relative_url }}). La [lección 38]({{ '/spring/leccion38/' | relative_url }}) explica cómo `@PathVariable` obtiene el ID.

El ejemplo incluye el controlador y el servicio completos. En `TareaController.java`, `@RequestMapping("/api/tareas")` establece la ruta común y `@PathVariable long id` recupera el identificador de `/{id}`.

- `@PutMapping("/{id}")` sustituye los campos editables. El título es obligatorio y `@Valid` aplica la restricción `@NotBlank`. El identificador permanece fijo.
- `@PatchMapping("/{id}")` aplica los campos presentes en el objeto JSON. Con `{}`, devuelve la tarea actual. Un título nulo, vacío, en blanco o de otro tipo produce `400`, al igual que una propiedad desconocida.
- `@DeleteMapping("/{id}")` devuelve `204` sin cuerpo al borrar el recurso. Si repites la petición, devuelve `404` porque la tarea ya no existe. El estado final sigue siendo el mismo, por lo que DELETE es idempotente.

En `TareaService.java`, `computeIfPresent` actualiza el título solo si el ID existe. Así, PUT y PATCH devuelven `404` para un ID inexistente cuando el cuerpo es válido. El borrado usa el resultado de `remove` para saber si eliminó una tarea.

**Ejercicio breve.** Antes de ejecutar la secuencia completa, predice el resultado de enviar `{}` con PUT y con PATCH sobre una tarea existente. Explica la diferencia usando el contrato de cada operación.

## Práctica guiada

Crea una tarea y usa la ruta de la cabecera `Location` en las siguientes peticiones. Los comandos suponen que la primera tarea recibe el ID 1.

```sh
api=http://localhost:8080/api/tareas
curl -i "$api"
curl -i -H 'Content-Type: application/json' --data '{"titulo":"Preparar entrega"}' "$api"
tarea="$api/1"
curl -i "$tarea"
curl -i -X PUT -H 'Content-Type: application/json' --data '{"titulo":"Revisar entrega"}' "$tarea"
curl -i -X PATCH -H 'Content-Type: application/json' --data '{"titulo":"Entrega final"}' "$tarea"
curl -i -X PATCH -H 'Content-Type: application/json' --data '{}' "$tarea"
curl -i -X PATCH -H 'Content-Type: application/json' --data '{"titulo":null}' "$tarea"
curl -i -X DELETE "$tarea"
curl -i "$tarea"
curl -i -X DELETE "$tarea"
```

Comprueba en orden `200`, `201`, `200`, `200`, `200`, `200`, `400`, `204`, `404` y `404`. Verifica que el PATCH vacío devuelve el título «Entrega final» y que DELETE devuelve un cuerpo vacío. Prueba también un PUT con un título en blanco y un PATCH con una propiedad desconocida antes de borrar la tarea. Ambos deben devolver `400`.

Puedes repetir las operaciones en [Swagger UI](http://localhost:8080/swagger-ui/index.html). Para probar HEAD, usa `curl -I "$api"` y comprueba que recibes las cabeceras sin cuerpo. Con `curl -i -X OPTIONS "$api"`, consulta los métodos permitidos en la cabecera `Allow`. Spring MVC proporciona ambos comportamientos a partir de las rutas registradas.

<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion109/' | relative_url }}">109 · Swagger UI y documentación OpenAPI</a>
</div>
