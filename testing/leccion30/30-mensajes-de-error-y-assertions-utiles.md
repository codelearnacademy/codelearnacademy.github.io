---
layout: lesson
route: testing
lesson_id: leccion30
lesson_file: 30-mensajes-de-error-y-assertions-utiles
lesson_number: "30"
title: Mensajes de error y assertions útiles
description: Bloque «Assertions». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion30/
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

# Mensajes de error y assertions útiles

Bloque «Assertions». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Mensajes de error y assertions útiles**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Un mensaje útil explica el contexto de negocio. Repetir «error» o imprimir todo el objeto sin identificar la expectativa dificulta diagnosticar.


## Ejemplo guiado

Guarda `Prueba30Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba30Test {
    @Test void calculaTotalSinDescuento() {
        int total = 3 * 10;
        assertEquals(30, total, "Tres unidades de 10 deben costar 30 antes de descuentos");
    }
}
```

Ejecuta `mvn -Dtest=Prueba30Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Provoca un fallo y comprueba que mensaje, esperado y real son suficientes.
2. Redacta un mensaje para una regla de cantidad mínima.


## Qué debes recordar

La aserción aporta valores; el mensaje añade contexto relevante.


<div class="cla-lesson-nav">
  <a href="/testing/leccion29/">← 29 · Agrupar comprobaciones con assertAll</a>
  <a href="/testing/leccion31/">31 · Convenciones para nombrar tests →</a>
</div>
