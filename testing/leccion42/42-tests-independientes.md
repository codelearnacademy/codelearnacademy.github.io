---
layout: lesson
route: testing
lesson_id: leccion42
lesson_file: 42-tests-independientes
lesson_number: "42"
title: Tests independientes
description: Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion42/
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

# Tests independientes

Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Tests independientes**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Cada test debe poder ejecutarse solo, repetido o en un orden diferente. El estado creado por otro método no forma parte de su preparación.


## Ejemplo guiado

Guarda `Prueba42Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba42Test {
    java.util.List<String> pedidos;
    @BeforeEach void preparar() { pedidos = new java.util.ArrayList<>(); }
    @Test void inserta() { pedidos.add("P-01"); assertEquals(1, pedidos.size()); }
    @Test void empiezaVacio() { assertTrue(pedidos.isEmpty()); }
}
```

Ejecuta `mvn -Dtest=Prueba42Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Ejecuta empiezaVacio solo y después la clase completa.
2. Explica el problema de una lista static modificada por varios tests.


## Qué debes recordar

Cada escenario crea sus precondiciones; no uses el orden para esconder dependencia.


<div class="cla-lesson-nav">
  <a href="/testing/leccion41/">← 41 · Principios FIRST</a>
  <a href="/testing/leccion43/">43 · Tests deterministas →</a>
</div>
