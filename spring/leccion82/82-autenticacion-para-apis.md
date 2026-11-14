---
layout: lesson
route: spring
lesson_id: leccion82
lesson_file: 82-autenticacion-para-apis
lesson_number: "82"
title: Autenticación para APIs
description: Introduce autenticación, autorización y protección de credenciales con Spring Security.
permalink: /spring/leccion82/
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
# Autenticación para APIs

Introduce autenticación, autorización y protección de credenciales con Spring Security.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Autenticación para APIs** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Seguridad.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Cliente: Presenta una credencial. Seguridad: Verifica la identidad. API: Aplica permisos.]({{ "/assets/images/spring/82-autenticacion-para-apis.webp" | relative_url }})

## Ejemplo guiado

Compara sesión/cookie con token bearer para una API. No implementes JWT hasta comprender expiración, firma, almacenamiento y revocación.



## Relación con el resto de la ruta

Spring Security es un framework del ecosistema Spring; no debes mezclar autenticación con reglas de negocio ni guardar secretos en código.



## Ejemplo adicional: aplicación práctica

```java
@GetMapping("/api/perfil")
Map<String, String> perfil(Authentication auth) {
    return Map.of("usuario", auth.getName());
}
```

El principal autenticado procede del mecanismo de seguridad configurado.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Aplica **Autenticación para APIs** a un endpoint de la API de tareas.
2. Comprueba los códigos HTTP para peticiones anónimas, autenticadas y sin permisos.
3. Añade pruebas que validen explícitamente que un usuario no puede consultar o modificar recursos ajenos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Autenticación para APIs** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion81/">← 81 · Password hashing</a>
  <a href="/spring/leccion83/">83 · Logging →</a>
</div>
