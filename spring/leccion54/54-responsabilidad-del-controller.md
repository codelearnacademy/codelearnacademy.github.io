---
layout: lesson
route: spring
lesson_id: leccion54
lesson_file: 54-responsabilidad-del-controller
lesson_number: "54"
title: Responsabilidad del Controller
description: Organiza una aplicación separando HTTP, negocio y persistencia con dependencias explícitas.
permalink: /spring/leccion54/
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
# Responsabilidad del Controller

Organiza una aplicación separando HTTP, negocio y persistencia con dependencias explícitas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Responsabilidad del Controller** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Arquitectura por capas.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Entrada HTTP: Recibe DTO y ruta. Controlador: Delega al servicio. Salida HTTP: Devuelve estado y cuerpo.]({{ "/assets/images/spring/54-responsabilidad-del-controller.webp" | relative_url }})

## Ejemplo guiado

El Controller transforma HTTP en llamadas de aplicación:

```text
HTTP → validar DTO → service → respuesta HTTP
```



## Relación con el resto de la ruta

Relaciona capas con Clean Code, testing y Dependency Inversion. Cada capa debe tener una responsabilidad verificable.



## Ejemplo adicional: aplicación práctica

```java
@GetMapping("/{id}")
ResponseEntity<TareaResponse> obtener(@PathVariable Long id) {
    return service.obtener(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
}
```

El controlador traduce los resultados del servicio a HTTP.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Sitúa **Responsabilidad del Controller** en la estructura `controller` → `service` → `repository`.
2. Crea un método de servicio con una regla simple y delega la persistencia en el repositorio.
3. Escribe un test aislado del servicio usando una dependencia simulada; no accedas a la base desde el controlador.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Responsabilidad del Controller** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion53/">← 53 · Controller, Service y Repository</a>
  <a href="/spring/leccion55/">55 · Responsabilidad del Service →</a>
</div>
