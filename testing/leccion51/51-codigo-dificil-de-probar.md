---
layout: lesson
route: testing
lesson_id: leccion51
lesson_file: 51-codigo-dificil-de-probar
lesson_number: "51"
title: Código difícil de probar
description: Bloque «Diseño testeable». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion51/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: integración-con-maven
    title: Integración con Maven
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Código difícil de probar

Bloque «Diseño testeable». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Código difícil de probar**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Las dependencias ocultas dificultan preparar escenarios. Leer el reloj, crear conexiones y enviar mensajes dentro de una misma operación obliga a controlar efectos ajenos a la regla.


## Ejemplo guiado

Diseño difícil: `confirmar` crea un cliente de correo, obtiene la fecha del sistema y escribe directamente en la base de datos. Para probarlo necesitarías todos esos servicios. Refactorización propuesta: recibe un Clock, un repositorio y un notificador. Primero prueba el cambio de estado con colaboradores de memoria; después prueba cada adaptación externa en integración. La refactorización no elimina la necesidad de comprobar esas integraciones.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Identifica tres dependencias ocultas en el diseño.
2. Describe qué evidencia necesita la prueba del repositorio real.


## Qué debes recordar

Hacer dependencias explícitas permite aislar reglas y reservar integración para sus adaptadores.


<div class="cla-lesson-nav">
  <a href="/testing/leccion50/">← 50 · JUnit Assertions frente a AssertJ</a>
  <a href="/testing/leccion52/">52 · Dependency Injection y testing →</a>
</div>
