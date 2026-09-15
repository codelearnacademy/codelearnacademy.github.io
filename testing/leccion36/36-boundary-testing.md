---
layout: lesson
route: testing
lesson_id: leccion36
lesson_file: 36-boundary-testing
lesson_number: "36"
title: Boundary testing
description: Bloque «Casos límite y parametrización». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion36/
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

# Boundary testing

Bloque «Casos límite y parametrización». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Boundary testing**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Las fronteras son puntos donde cambia la aceptación. Para un máximo de 120 caracteres, comprobar solo un título de diez caracteres no cubre el límite.


## Ejemplo guiado

Guarda `Prueba36Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba36Test {
    static boolean valido(String titulo) { return titulo != null && !titulo.isBlank() && titulo.length() <= 120; }
    @Test void compruebaFronteraSuperior() {
        assertTrue(valido("a".repeat(119)));
        assertTrue(valido("a".repeat(120)));
        assertFalse(valido("a".repeat(121)));
    }
}
```

Ejecuta `mvn -Dtest=Prueba36Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade frontera inferior: vacío y un carácter.
2. Aclara si el límite del producto se mide en unidades UTF-16, puntos de código u otra unidad.


## Qué debes recordar

Ejercita justo antes, en y después del cambio de regla. El ejemplo mide String.length, no caracteres visuales.


<div class="cla-lesson-nav">
  <a href="/testing/leccion35/">← 35 · Organización de una suite de pruebas mantenible</a>
  <a href="/testing/leccion37/">37 · Null, vacío, cero y valores extremos →</a>
</div>
