---
layout: lesson
route: spring
lesson_id: leccion81
lesson_file: 81-testcontainers
lesson_number: "81"
title: Testcontainers
description: Comprueba unidades, contexto, MVC, persistencia e integración con una estrategia progresiva.
permalink: /spring/leccion81/
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
# Testcontainers

Comprueba unidades, contexto, MVC, persistencia e integración con una estrategia progresiva.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Testcontainers** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Pruebas automatizadas.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Preparar: Inicia PostgreSQL de prueba. Ejecutar: Conecta la aplicación. Limpiar: El contenedor termina.]({{ "/assets/images/spring/78-testcontainers.webp" | relative_url }})

## Ejemplo guiado

```text
JUnit
 ↓
Testcontainers
 ↓
PostgreSQL real en contenedor
```

La prueba controla el ciclo de vida de la base.



## Relación con el resto de la ruta

Maven ejecuta pruebas; Spring ofrece utilidades de test; Testcontainers aporta infraestructura real y Docker hace reproducible esa infraestructura.



## Ejemplo adicional: aplicación práctica

```java
@Testcontainers
class PostgreSqlIntegrationTest {
    @Container
    static PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>("postgres:16-alpine");
}
```

Testcontainers requiere Docker disponible y la dependencia correspondiente.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Crea una prueba sobre **Testcontainers** que tenga un resultado esperado verificable.
2. Añade un caso sin registros y otro con datos válidos; evita que las pruebas compartan estado.
3. Ejecuta las pruebas dos veces en distinto orden y comprueba que el resultado no depende de otras pruebas.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Testcontainers** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion80/">← 80 · Tests de integración</a>
  <a href="/spring/leccion82/">82 · Autenticación y autorización →</a>
</div>
