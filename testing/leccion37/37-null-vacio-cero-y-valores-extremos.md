---
layout: lesson
route: testing
lesson_id: leccion37
lesson_file: 37-null-vacio-cero-y-valores-extremos
lesson_number: "37"
title: Null, vacío, cero y valores extremos
description: Bloque «Casos límite y parametrización». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion37/
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

# Null, vacío, cero y valores extremos

Bloque «Casos límite y parametrización». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Null, vacío, cero y valores extremos**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Null, vacío, blanco, cero y negativo son casos distintos. Define su significado según el contrato en lugar de tratarlos como equivalentes.


## Ejemplo guiado

Guarda `Prueba37Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba37Test {
    static boolean valido(String titulo) { return titulo != null && !titulo.isBlank(); }
    @Test void distingueEntradasSinTitulo() {
        assertAll(
            () -> assertFalse(valido(null)),
            () -> assertFalse(valido("")),
            () -> assertFalse(valido("   ")),
            () -> assertTrue(valido("Pedido")));
    }
}
```

Ejecuta `mvn -Dtest=Prueba37Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Define qué ocurriría con cantidad cero y negativa.
2. Añade un extremo numérico sin provocar desbordamientos inadvertidos en el esperado.


## Qué debes recordar

Los casos límite deben surgir de reglas explícitas, incluidos tipos y rangos.


<div class="cla-lesson-nav">
  <a href="/testing/leccion36/">← 36 · Boundary testing</a>
  <a href="/testing/leccion38/">38 · @ParameterizedTest y @ValueSource →</a>
</div>
