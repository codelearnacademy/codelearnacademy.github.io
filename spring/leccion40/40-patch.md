---
layout: lesson
route: spring
lesson_id: leccion40
lesson_file: 40-patch
lesson_number: "40"
title: "PATCH · Modificar parte de una tarea"
description: "Usa @PatchMapping y distingue un campo ausente de un valor inválido."
permalink: /spring/leccion40/
lessons:
  - id: cuándo-usarlo
    title: Cuándo usarlo
  - id: implementación-en-spring-mvc
    title: Implementación en Spring MVC
  - id: práctica-con-la-api
    title: Práctica con la API
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# PATCH · Modificar parte de una tarea

## Cuándo usarlo

Usa `PATCH /api/tareas/{id}` cuando el cliente envíe solo los campos que quiere cambiar. El ejemplo acepta un objeto JSON con `Content-Type: application/json`. Con `{}`, devuelve `200` y la tarea actual. Si aparece `titulo`, debe ser texto no vacío. Un valor nulo o una propiedad desconocida devuelve `400`. Con un cuerpo válido, un ID inexistente devuelve `404`.

**Ejercicio breve.** Predice el resultado de enviar `{}` con PUT y con PATCH sobre la misma tarea. Comprueba qué anotación recibe cada petición y dónde se decide si el título es obligatorio.

## Implementación en Spring MVC

Busca este método en `TareaController.java` del ejemplo descargable.

```java
@PatchMapping("/{id}")
ResponseEntity<Tarea> modificar(@PathVariable("id") long id, @RequestBody Map<String, Object> cambios) {
    if (cambios.isEmpty()) {
        return ResponseEntity.ok(exigirTarea(servicio.buscar(id)));
    }
    if (cambios.size() != 1 || !(cambios.get("titulo") instanceof String titulo) || titulo.isBlank()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Envía un objeto vacío o un título de texto no vacío como único campo.");
    }
    return ResponseEntity.ok(exigirTarea(servicio.actualizar(id, titulo)));
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
curl -i -X PATCH -H 'Content-Type: application/json' --data '{"titulo":"Entrega final"}' "$tarea"
curl -i -X PATCH -H 'Content-Type: application/json' --data '{}' "$tarea"
curl -i -X PATCH -H 'Content-Type: application/json' --data '{"titulo":null}' "$tarea"
curl -i "$tarea"
```

**Ejercicio breve.** Comprueba `200`, `200`, `400` y `200`. Verifica que el último GET conserva «Entrega final». Cambia el cuerpo inválido por `{"estado":"hecha"}` y explica por qué también devuelve `400`.

<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion39/' | relative_url }}">← PUT</a>
  <a href="{{ '/spring/leccion41/' | relative_url }}">DELETE →</a>
</div>
