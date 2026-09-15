---
layout: lesson
route: testing
lesson_id: leccion45
lesson_file: 45-flaky-tests-y-como-evitarlos
lesson_number: "45"
title: Flaky tests y cómo evitarlos
description: Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion45/
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

# Flaky tests y cómo evitarlos

Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Flaky tests y cómo evitarlos**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Un flaky test cambia de resultado sin un cambio relevante del producto. Causas habituales incluyen tiempos, datos compartidos y dependencias externas no controladas.


## Ejemplo guiado

Guarda `Prueba45Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba45Test {
    @Test void esperaResultadoConLimite() throws Exception {
        var futuro = java.util.concurrent.CompletableFuture.completedFuture("P-01");
        assertEquals("P-01", futuro.get(1, java.util.concurrent.TimeUnit.SECONDS));
    }
}
```

Ejecuta `mvn -Dtest=Prueba45Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Explica por qué dormir un tiempo fijo no demuestra que una operación haya terminado.
2. Para una operación realmente asíncrona, identifica una señal de finalización y un timeout razonado.


## Qué debes recordar

Espera condiciones observables con un límite. Reintentar sin investigar puede ocultar un fallo real.


<div class="cla-lesson-nav">
  <a href="/testing/leccion44/">← 44 · Una prueba, un comportamiento</a>
  <a href="/testing/leccion46/">46 · Introducción a AssertJ →</a>
</div>
