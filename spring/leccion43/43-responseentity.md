---
layout: lesson
route: spring
lesson_id: leccion43
lesson_file: 43-responseentity
lesson_number: "43"
title: ResponseEntity, cabeceras y cuerpo
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion43/
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
# ResponseEntity, cabeceras y cuerpo

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **ResponseEntity** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Estado: 201 Created. Cabecera: Location. Cuerpo: Tarea creada.]({{ "/assets/images/spring/43-responseentity.webp" | relative_url }})

## Ejemplo guiado

### 1. Crear y localizar un recurso

En `TareaController.crear`, la respuesta construye el estado, la cabecera y el cuerpo en una sola expresión.

```java
return ResponseEntity.created(URI.create("/api/tareas/" + tarea.id())).body(tarea);
```

**Ejercicio breve.** Ejecuta el POST de la [práctica REST]({{ '/spring/leccion108/' | relative_url }}). Copia la ruta de `Location` y consúltala con GET. Compara el ID de ambas respuestas.

### 2. Borrar y comprobar el cuerpo

```java
return ResponseEntity.noContent().build();
```

**Ejercicio breve.** Ejecuta `curl -i -X DELETE` sobre la URL de la tarea creada. Comprueba que termina después de las cabeceras. Repite la petición y compara el `404` con el `204` anterior. ¿Cuántas tareas quedan con ese ID en cada caso?

## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

**Ejercicio breve.** Busca `ResponseEntity.ok`, `created` y `noContent` en el controlador descargable. Asocia cada construcción con una petición y anota si tendría sentido llamar a `body(...)`. En el caso `404`, sigue el lanzamiento de la excepción hasta el manejo de errores de la [lección 44]({{ '/spring/leccion44/' | relative_url }}).

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **ResponseEntity**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **ResponseEntity** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion42/">← 42 · Códigos de estado HTTP</a>
  <a href="/spring/leccion44/">44 · Manejo global de errores →</a>
</div>
