---
layout: lesson
route: testing
lesson_id: leccion44
lesson_file: 44-una-prueba-un-comportamiento
lesson_number: "44"
title: Una prueba, un comportamiento
description: Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion44/
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

# Una prueba, un comportamiento

Bloque «Calidad de las pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Una prueba, un comportamiento**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Un comportamiento puede requerir varias aserciones. La regla ayuda a evitar mezclar operaciones independientes, no a imponer una única llamada assert.


## Ejemplo guiado

Guarda `Prueba44Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba44Test {
    record Pedido(String estado, int total) {}
    @Test void crearDevuelvePedidoPendienteConTotal() {
        Pedido resultado = new Pedido("PENDIENTE", 20);
        assertAll(
            () -> assertEquals("PENDIENTE", resultado.estado()),
            () -> assertEquals(20, resultado.total()));
    }
}
```

Ejecuta `mvn -Dtest=Prueba44Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Explica qué único resultado se describe.
2. Separa en otro escenario la cancelación de un pedido.


## Qué debes recordar

Varias propiedades del mismo resultado pueden comprobarse juntas.


<div class="cla-lesson-nav">
  <a href="/testing/leccion43/">← 43 · Tests deterministas</a>
  <a href="/testing/leccion45/">45 · Flaky tests y cómo evitarlos →</a>
</div>
