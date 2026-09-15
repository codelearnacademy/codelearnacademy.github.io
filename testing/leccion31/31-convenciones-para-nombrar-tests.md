---
layout: lesson
route: testing
lesson_id: leccion31
lesson_file: 31-convenciones-para-nombrar-tests
lesson_number: "31"
title: Convenciones para nombrar tests
description: Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion31/
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

# Convenciones para nombrar tests

Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Convenciones para nombrar tests**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

El nombre debe comunicar condición y resultado. No necesita seguir una única convención, pero sí permitir identificar el comportamiento en el reporte.


## Ejemplo guiado

Guarda `Prueba31Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba31Test {
    static boolean acepta(int cantidad) { return cantidad > 0; }
    @Test void rechazaCantidadCero() { assertFalse(acepta(0)); }
    @Test void aceptaUnaUnidad() { assertTrue(acepta(1)); }
}
```

Ejecuta `mvn -Dtest=Prueba31Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Sustituye test1 y test2 por nombres de comportamiento.
2. Añade un nombre claro para el caso negativo.


## Qué debes recordar

Los nombres ayudan a localizar reglas rotas; evita depender del orden de ejecución.


<div class="cla-lesson-nav">
  <a href="/testing/leccion30/">← 30 · Mensajes de error y assertions útiles</a>
  <a href="/testing/leccion32/">32 · @DisplayName →</a>
</div>
