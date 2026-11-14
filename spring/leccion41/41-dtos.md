---
layout: lesson
route: spring
lesson_id: leccion41
lesson_file: 41-dtos
lesson_number: "41"
title: DTOs
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion41/
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
# DTOs

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **DTOs** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![DTO de entrada: Solo los datos necesarios. Modelo: Representa la tarea. DTO de salida: Expone la respuesta acordada.]({{ "/assets/images/spring/41-dtos.webp" | relative_url }})

## Ejemplo guiado

```text
JSON ↔ DTO ↔ Service ↔ Entity
```

Evita exponer directamente la entidad JPA como contrato HTTP.



### Modelo HTTP mediante una clase Java

El contrato de la API se representa con un DTO independiente de la entidad de persistencia:

```java
public class TaskResponse {
    private Long id;
    private String title;
    private boolean completed;

    public TaskResponse() {}

    public TaskResponse(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
```

El controlador devuelve el DTO y no expone las relaciones y detalles internos de `TaskEntity`.

## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

```java
public class TareaResponse {
    private Long id;
    private String titulo;
    public TareaResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
}
```

Los DTOs son clases que definen qué datos expone la API.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **DTOs**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **DTOs** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion40/">← 40 · Request body y JSON</a>
  <a href="/spring/leccion42/">42 · Códigos de estado HTTP →</a>
</div>
