---
layout: lesson
route: spring
lesson_id: leccion43
lesson_file: 43-request-body-y-json
lesson_number: "43"
title: Request body y JSON
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
# Request body y JSON

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Request body y JSON** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Cliente: Envía JSON. @RequestBody: Convierte el cuerpo. Objeto Java: Contiene el título.]({{ "/assets/images/spring/40-request-body-y-json.webp" | relative_url }})

## Ejemplo guiado

Envía:

```json
{"title":"Estudiar Spring","completed":false}
```

y recíbelo como DTO con `@RequestBody`.



## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

```java
public class TareaRequest {
    @NotBlank private String titulo;
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
}
```

El JSON de entrada se vincula a una clase sin exponer entidades JPA.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **Request body y JSON**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Request body y JSON** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion42/">← 42 · Query parameters</a>
  <a href="/spring/leccion44/">44 · DTOs →</a>
</div>
