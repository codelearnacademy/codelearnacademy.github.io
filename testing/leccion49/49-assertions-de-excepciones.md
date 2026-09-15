---
layout: lesson
route: testing
lesson_id: leccion49
lesson_file: 49-assertions-de-excepciones
lesson_number: "49"
title: Assertions de excepciones
description: Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion49/
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

# Assertions de excepciones

Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Assertions de excepciones**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Una aserción de excepción debe envolver solo la operación que se espera que falle y comprobar el tipo y, cuando sea contrato, el mensaje.


## Ejemplo guiado

Guarda `Prueba49Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba49Test {
    static void validar(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("cantidad positiva requerida");
    }
    @Test void rechazaCero() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> validar(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("cantidad positiva requerida");
    }
}
```

Ejecuta `mvn -Dtest=Prueba49Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade una prueba de cantidad válida.
2. Explica cómo evitar que una excepción de preparación haga pasar el test por error.


## Qué debes recordar

Delimita la acción que falla y comprueba un contrato específico.


<div class="cla-lesson-nav">
  <a href="/testing/leccion48/">← 48 · Assertions sobre colecciones</a>
  <a href="/testing/leccion50/">50 · JUnit Assertions frente a AssertJ →</a>
</div>
