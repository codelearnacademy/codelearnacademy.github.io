---
layout: lesson
route: spring
lesson_id: leccion79
lesson_file: 79-autenticacion-y-autorizacion
lesson_number: "79"
title: Autenticación y autorización
description: Introduce autenticación, autorización y protección de credenciales con Spring Security.
permalink: /spring/leccion79/
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
# Autenticación y autorización

Introduce autenticación, autorización y protección de credenciales con Spring Security.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Autenticación y autorización** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Seguridad.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```text
Autenticación → ¿quién eres?
Autorización  → ¿qué puedes hacer?
```



## Relación con el resto de la ruta

Spring Security es un framework del ecosistema Spring; no debes mezclar autenticación con reglas de negocio ni guardar secretos en código.



## Ejemplo adicional: aplicación práctica

```java
@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/{id}")
ResponseEntity<Void> eliminar(@PathVariable Long id) {
    servicio.eliminar(id);
    return ResponseEntity.noContent().build();
}
```

Diferencia autenticación (quién eres) y autorización (qué puedes hacer).

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Aplica **Autenticación y autorización** a un endpoint de la API de tareas.
2. Comprueba los códigos HTTP para peticiones anónimas, autenticadas y sin permisos.
3. Añade pruebas que validen explícitamente que un usuario no puede consultar o modificar recursos ajenos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Autenticación y autorización** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion78/">← 78 · Testcontainers</a>
  <a href="/spring/leccion80/">80 · Introducción a Spring Security →</a>
</div>
