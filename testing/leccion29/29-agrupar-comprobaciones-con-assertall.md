---
layout: lesson
route: testing
lesson_id: leccion29
lesson_file: 29-agrupar-comprobaciones-con-assertall
lesson_number: "29"
title: Agrupar comprobaciones con assertAll
description: Bloque «Assertions». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion29/
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

# Agrupar comprobaciones con assertAll

Bloque «Assertions». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Agrupar comprobaciones con assertAll**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

assertAll agrupa comprobaciones relacionadas y recoge los fallos de sus ejecutables. Sirve para describir varias propiedades del mismo resultado.


## Ejemplo guiado

Guarda `Prueba29Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba29Test {
    record Pedido(String codigo, int total) {}
    @Test void devuelvePedidoCompleto() {
        Pedido pedido = new Pedido("P-01", 30);
        assertAll("pedido creado",
            () -> assertEquals("P-01", pedido.codigo()),
            () -> assertEquals(30, pedido.total()));
    }
}
```

Ejecuta `mvn -Dtest=Prueba29Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Cambia ambos esperados y observa los dos fallos.
2. Explica por qué agrupar dos operaciones de negocio independientes sería menos claro.


## Qué debes recordar

Agrupa propiedades de un resultado, no escenarios sin relación.


<div class="cla-lesson-nav">
  <a href="/testing/leccion28/">← 28 · Comprobar excepciones con assertThrows</a>
  <a href="/testing/leccion30/">30 · Mensajes de error y assertions útiles →</a>
</div>
