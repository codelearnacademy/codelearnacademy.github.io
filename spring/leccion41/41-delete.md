---
layout: lesson
route: spring
lesson_id: leccion41
lesson_file: 41-delete
lesson_number: "41"
title: "DELETE · Eliminar una tarea"
description: "Usa @DeleteMapping y distingue 204 sin cuerpo de 404."
permalink: /spring/leccion41/
lessons:
  - id: cuándo-usarlo
    title: Cuándo usarlo
  - id: implementación-en-spring-mvc
    title: Implementación en Spring MVC
  - id: práctica-con-la-api
    title: Práctica con la API
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# DELETE · Eliminar una tarea

## Cuándo usarlo

Usa `DELETE /api/tareas/{id}` para borrar la tarea identificada por la URL. La práctica envía la petición sin cuerpo. Si el servicio elimina la tarea, devuelve `204 No Content`. Si el ID ya no existe, devuelve `404` con el detalle del problema.

**Ejercicio breve.** Antes de enviar la petición, explica qué diferencia esperas entre el cuerpo del DELETE exitoso y el de un GET exitoso.

## Implementación en Spring MVC

Busca este método en `TareaController.java` del ejemplo descargable.

```java
@DeleteMapping("/{id}")
ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
    if (servicio.eliminar(id)) {
        return ResponseEntity.noContent().build();
    }
    throw tareaNoEncontrada();
}
```

## Práctica con la API

Descarga el [ejemplo de tareas]({{ '/spring/ejemplos/api-tareas.zip' | relative_url }}) y arráncalo con `mvn spring-boot:run`. Crea una tarea de práctica.

```sh
api=http://localhost:8080/api/tareas
curl -i -H 'Content-Type: application/json' --data '{"titulo":"Preparar entrega"}' "$api"
tarea="$api/1"
```

Ajusta `tarea` con la ruta de la cabecera `Location` si el ID que devuelve el POST es distinto de 1.

```sh
curl -i -X DELETE "$tarea"
curl -i "$tarea"
curl -i -X DELETE "$tarea"
```

**Ejercicio breve.** Comprueba que el primer resultado es `204` y que no aparece contenido después de las cabeceras. El GET y el segundo DELETE devuelven `404`. Explica por qué DELETE es idempotente aunque cambie el código de respuesta: tras una o varias peticiones, la tarea sigue ausente.

<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion40/' | relative_url }}">← PATCH</a>
  <a href="{{ '/spring/leccion42/' | relative_url }}">42 · Query parameters →</a>
</div>
