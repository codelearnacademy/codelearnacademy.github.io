---
layout: lesson
route: testing
lesson_id: leccion26
lesson_file: 26-assertequals-asserttrue-y-assertfalse
lesson_number: "26"
title: assertEquals, assertTrue y assertFalse
description: Bloque «Assertions». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion26/
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

# assertEquals, assertTrue y assertFalse

Bloque «Assertions». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **assertEquals, assertTrue y assertFalse**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

assertEquals compara un valor esperado con el obtenido; assertTrue y assertFalse comprueban condiciones booleanas. Escoge la aserción que muestre mejor la diferencia si falla.


## Ejemplo guiado

Guarda `Prueba26Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba26Test {
    @Test void validaResumenDelPedido() {
        int total = 2 * 15;
        java.util.List<String> lineas = java.util.List.of("libro", "cuaderno");
        assertEquals(30, total);
        assertTrue(lineas.contains("libro"));
        assertFalse(lineas.isEmpty());
    }
}
```

Ejecuta `mvn -Dtest=Prueba26Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Cambia el total esperado y observa los valores del mensaje.
2. Explica qué información perderías con assertTrue(total == 30).


## Qué debes recordar

Los esperados deben proceder del contrato, y la aserción debe facilitar el diagnóstico.


<div class="cla-lesson-nav">
  <a href="/testing/leccion25/">← 25 · Ejecutar pruebas desde el IDE y desde Maven</a>
  <a href="/testing/leccion27/">27 · assertNull, assertNotNull, assertSame y assertNotSame →</a>
</div>
