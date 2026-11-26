---
layout: lesson
route: spring
lesson_id: leccion45
lesson_file: 45-codigos-de-estado-http
lesson_number: "45"
title: Códigos HTTP y diagnóstico de respuestas
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion45/
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
# Códigos HTTP y diagnóstico de respuestas

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Códigos de estado HTTP** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Éxito: 200 para consultar y 201 para crear. Entrada inválida: 400. Recurso ausente: 404.]({{ "/assets/images/spring/42-codigos-de-estado-http.webp" | relative_url }})

## Ejemplo guiado

Arranca el [ejemplo de tareas]({{ '/spring/ejemplos/api-tareas.zip' | relative_url }}) con `mvn spring-boot:run`. En otra terminal, define `api=http://localhost:8080/api/tareas`. Antes de cada petición, predice el estado, el cuerpo y las cabeceras relevantes.

### 1. Comparar éxito con ausencia

| Petición | Resultado |
|---|---|
| `GET /api/tareas` en un arranque limpio | `200` con `[]`. La colección existe y está vacía. |
| `GET /api/tareas/999999` en ese mismo arranque | `404` porque esa tarea no existe. |
| POST válido | `201`, cuerpo con la tarea y cabecera `Location`. |
| DELETE sobre una tarea existente | `204` sin cuerpo. |

**Ejercicio breve.** Ejecuta `curl -i "$api"` y `curl -i "$api/999999"`. Explica qué parte de la URL cambia el recurso que estás solicitando.

### 2. Identificar qué debe corregir el cliente

```sh
curl -i -X DELETE "$api"
curl -i -H 'Content-Type: text/plain' --data 'Preparar entrega' "$api"
curl -i -H 'Content-Type: application/json' --data '{' "$api"
```

**Ejercicio breve.** Asigna un código a cada petición antes de ejecutarla. Comprueba `405` y la cabecera `Allow`, `415` por el tipo de contenido y `400` por JSON incompleto. Cambia el tercer cuerpo por `{"titulo":"Preparar entrega"}` y comprueba `201`.

## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

### 3. Razonar sobre permisos, conflictos y fallos

Estos casos se trabajan como decisiones de diseño. La API base funciona en memoria y carece de autenticación y de reglas de archivo.

| Situación | Respuesta que corresponde |
|---|---|
| Una API protegida requiere credenciales válidas y la petición carece de ellas | `401 Unauthorized`, con el desafío de autenticación aplicable en `WWW-Authenticate`. |
| El usuario está autenticado y carece del permiso requerido | `403 Forbidden`. |
| Una regla impide reabrir una tarea archivada | `409 Conflict` por el estado actual de la tarea. |
| Una excepción inesperada impide completar la petición | `500 Internal Server Error`. El servidor registra la causa y el cliente recibe un mensaje genérico. |

**Ejercicio breve.** Compara un título en blanco con una solicitud válida para reabrir una tarea archivada. El primer caso exige corregir el cuerpo (`400`). En el segundo, la regla impide la transición solicitada (`409`). Indica qué podría hacer el cliente en cada caso.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **Códigos de estado HTTP**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Códigos de estado HTTP** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion44/">← 44 · DTOs</a>
  <a href="/spring/leccion46/">46 · ResponseEntity →</a>
</div>
