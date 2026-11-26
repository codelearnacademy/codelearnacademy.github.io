---
layout: lesson
route: spring
lesson_id: leccion78
lesson_file: 78-testing-mvc
lesson_number: "78"
title: Pruebas de la API de tareas con MockMvc
description: Comprueba unidades, contexto, MVC, persistencia e integración con una estrategia progresiva.
permalink: /spring/leccion78/
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
# Pruebas de la API de tareas con MockMvc

Comprueba unidades, contexto, MVC, persistencia e integración con una estrategia progresiva.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Testing MVC** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Pruebas automatizadas.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Petición: Envía JSON de prueba. MockMvc: Ejecuta el flujo MVC. Verificar: Estado y cuerpo esperados.]({{ "/assets/images/spring/75-testing-mvc.webp" | relative_url }})

## Ejemplo guiado

### 1. Ejecutar una prueba real de la API

Descarga el [ejemplo de tareas]({{ '/spring/ejemplos/api-tareas.zip' | relative_url }}). Abre `src/test/java/aula/tareas/TareaControllerTest.java` y ejecuta `mvn test`. `@SpringBootTest` carga la configuración del ejemplo y `@AutoConfigureMockMvc` permite usar `MockMvc` sin abrir un puerto HTTP.

```java
mvc.perform(post("/api/tareas")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"titulo\":\" \"}"))
   .andExpect(status().isBadRequest())
   .andExpect(jsonPath("$.errores[0].campo").value("titulo"));
```

**Ejercicio breve.** Ejecuta solo ese método con `mvn -Dtest=TareaControllerTest#identificaElCampoInvalido test`. Cambia temporalmente la expectativa a `isCreated()`, observa el fallo y vuelve a `isBadRequest()`.

### 2. Comprobar estado, cuerpo y cabeceras

La prueba del ciclo de vida usa el `Location` del POST para actualizar y borrar el recurso que acaba de crear. La prueba de errores verifica `400`, `405` con `Allow` y `415`.

**Ejercicio breve.** Añade una comprobación de `$.titulo` en la respuesta al POST y ejecuta nuevamente la clase con `mvn -Dtest=TareaControllerTest test`. Mantén las peticiones que modifican una misma tarea en el mismo escenario.

## Relación con el resto de la ruta

Maven ejecuta pruebas; Spring ofrece utilidades de test; Testcontainers aporta infraestructura real y Docker hace reproducible esa infraestructura.



## Ejemplo adicional: aplicación práctica

**Ejercicio breve.** Después del PATCH válido, añade un PATCH con `{"titulo":null}` y comprueba `400`. Haz un GET y verifica que la tarea sigue teniendo el título anterior. El ejercicio comprueba el rechazo y la ausencia de efectos secundarios.

## Ejercicios propuestos

1. Añade una comprobación de `application/problem+json` en la prueba del JSON incompleto.
2. Comprueba que `PUT` y `PATCH` con cuerpo válido devuelven `404` sobre la ruta después del borrado.
3. Ejecuta la clase completa y uno de sus métodos por separado. Registra qué verifica cada caso y qué resultado obtuviste.

## Qué debes recordar

- **Testing MVC** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion77/">← 77 · Testing del contexto Spring</a>
  <a href="/spring/leccion79/">79 · Testing del Repository →</a>
</div>
