---
layout: lesson
route: testing
lesson_id: leccion50
lesson_file: 50-junit-assertions-frente-a-assertj
lesson_number: "50"
title: JUnit Assertions frente a AssertJ
description: Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion50/
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

# JUnit Assertions frente a AssertJ

Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **JUnit Assertions frente a AssertJ**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

JUnit y AssertJ pueden utilizarse juntos. AssertJ aporta una biblioteca de aserciones; no sustituye al motor que descubre y ejecuta @Test.


## Ejemplo guiado

Guarda `Prueba50Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba50Test {
    @Test void expresaLaMismaExpectativa() {
        var codigos = java.util.List.of("P-01", "P-02");
        assertEquals(java.util.List.of("P-01", "P-02"), codigos);
        org.assertj.core.api.Assertions.assertThat(codigos).containsExactly("P-01", "P-02");
    }
}
```

Ejecuta `mvn -Dtest=Prueba50Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Compara el mensaje de ambas alternativas al faltar un elemento.
2. Elige una alternativa para un test real y elimina la comprobación duplicada.


## Qué debes recordar

El ejemplo compara estilos; no es necesario duplicar aserciones equivalentes en la suite.


<div class="cla-lesson-nav">
  <a href="/testing/leccion49/">← 49 · Assertions de excepciones</a>
  <a href="/testing/leccion51/">51 · Código difícil de probar →</a>
</div>
