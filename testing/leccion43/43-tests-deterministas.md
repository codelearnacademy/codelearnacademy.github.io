---
layout: lesson
route: testing
lesson_id: leccion43
lesson_file: 43-tests-deterministas
lesson_number: "43"
title: Tests deterministas
description: Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion43/
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

# Tests deterministas

Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Tests deterministas**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Un test determinista controla las entradas que influyen en su expectativa, incluidas hora, zona y aleatoriedad.


## Ejemplo guiado

Guarda `Prueba43Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba43Test {
    static boolean vencido(java.time.LocalDate fecha, java.time.Clock reloj) {
        return fecha.isBefore(java.time.LocalDate.now(reloj));
    }
    @Test void ayerEstaVencido() {
        var reloj = java.time.Clock.fixed(java.time.Instant.parse("2025-01-10T12:00:00Z"), java.time.ZoneOffset.UTC);
        assertTrue(vencido(java.time.LocalDate.of(2025, 1, 9), reloj));
        assertFalse(vencido(java.time.LocalDate.of(2025, 1, 10), reloj));
    }
}
```

Ejecuta `mvn -Dtest=Prueba43Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Comprueba que el resultado no depende del día de ejecución.
2. Añade una fecha futura.


## Qué debes recordar

Inyectar el reloj permite comprobar reglas temporales con expectativas estables.


<div class="cla-lesson-nav">
  <a href="/testing/leccion42/">← 42 · Tests independientes</a>
  <a href="/testing/leccion44/">44 · Una prueba, un comportamiento →</a>
</div>
