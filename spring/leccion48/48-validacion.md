---
layout: lesson
route: spring
lesson_id: leccion48
lesson_file: 48-validacion
lesson_number: "48"
title: Validación de POST, PUT y PATCH
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion48/
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

# Validación de POST, PUT y PATCH

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Validación** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Entrada: Título en blanco. Validación: @Valid y @NotBlank. Respuesta: 400 antes de guardar.]({{ "/assets/images/spring/45-validacion.webp" | relative_url }})

<div class="cla-lesson-nav"><a href='{{ "/spring/ejemplos/api-tareas.zip" | relative_url }}'>Descargar el proyecto base con JDK 21 y Spring Boot 4.1.2</a></div>

## Ejemplo guiado

### 1. Validar un cuerpo completo

POST y PUT reciben `NuevaTarea`. `@RequestBody` convierte el JSON en un objeto Java. `@Valid` activa la restricción `@NotBlank` del título.

```java
public record NuevaTarea(@NotBlank String titulo) {}
```

**Ejercicio breve.** En `POST /api/tareas`, prueba en orden `{}`, `{"titulo":null}`, `{"titulo":" "}` y `{"titulo":"Preparar entrega"}`. Predice cuáles devuelven `400` y cuál devuelve `201`. Guarda la ruta de `Location`.

### 2. Validar únicamente el cambio solicitado

PATCH usa un objeto JSON donde el título puede estar ausente. En este ejemplo, `{}` conserva el valor actual. Si el título aparece, debe ser texto no vacío. El controlador también rechaza propiedades desconocidas.

**Ejercicio breve.** Envía `{}` primero con PUT y luego con PATCH a la ruta guardada. Comprueba `400` y `200`, respectivamente. Repite PATCH con `{"titulo":null}`, `{"titulo":42}` y `{"estado":"hecha"}`. Después consulta la tarea para verificar que conserva el título original.

## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

```java
public class TareaRequest {
    @NotBlank
    @Size(max = 120)
    private String titulo;
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
}
```

Usa @Valid en @RequestBody para activar la validación.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **Validación**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Validación** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion47/">← 47 · Manejo global de errores</a>
  <a href="/spring/leccion49/">49 · Qué es Tomcat →</a>
</div>
