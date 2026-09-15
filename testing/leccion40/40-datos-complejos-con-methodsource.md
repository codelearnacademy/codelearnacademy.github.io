---
layout: lesson
route: testing
lesson_id: leccion40
lesson_file: 40-datos-complejos-con-methodsource
lesson_number: "40"
title: Datos complejos con @MethodSource
description: Bloque «Casos límite y parametrización». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion40/
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

# Datos complejos con @MethodSource

Bloque «Casos límite y parametrización». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Datos complejos con @MethodSource**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

MethodSource permite suministrar varios argumentos por caso. La fuente es estática en el ciclo de vida por defecto y cada fila debe corresponder a los parámetros del test.


## Ejemplo guiado

Guarda `Prueba40Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba40Test {
    static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> casos() {
        return java.util.stream.Stream.of(
            org.junit.jupiter.params.provider.Arguments.of(1, 10),
            org.junit.jupiter.params.provider.Arguments.of(3, 30));
    }
    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("casos")
    void calculaTotal(int cantidad, int esperado) {
        assertEquals(esperado, cantidad * 10);
    }
}
```

Ejecuta `mvn -Dtest=Prueba40Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade una fila para cinco unidades.
2. Observa que el reporte contiene una ejecución por fila.


## Qué debes recordar

La fuente organiza datos; cada invocación conserva una expectativa concreta.


<div class="cla-lesson-nav">
  <a href="/testing/leccion39/">← 39 · Datos con @CsvSource</a>
  <a href="/testing/leccion41/">41 · Principios FIRST →</a>
</div>
