---
layout: lesson
route: testing
lesson_id: leccion14
lesson_file: 14-tests-como-documentacion-del-comportamiento
lesson_number: "14"
title: Tests como documentación del comportamiento
description: Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion14/
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

# Tests como documentación del comportamiento

Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Tests como documentación del comportamiento**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Un test comunica una regla cuando su nombre, datos y expectativa explican el comportamiento. Copiar el algoritmo productivo para calcular el esperado puede reproducir el mismo defecto.


## Ejemplo guiado

Guarda `Prueba14Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba14Test {
    static int total(int unidades) { return unidades * 10; }
    @Test void tresUnidadesCuestanTreinta() {
        assertEquals(30, total(3));
    }
}
```

Ejecuta `mvn -Dtest=Prueba14Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade un caso con una unidad y nombre descriptivo.
2. Explica por qué el esperado 30 es más claro aquí que duplicar el cálculo.


## Qué debes recordar

Datos pequeños y resultados explícitos convierten la prueba en un ejemplo legible del contrato.


<div class="cla-lesson-nav">
  <a href="/testing/leccion13/">← 13 · Coste, velocidad y aislamiento de las pruebas</a>
  <a href="/testing/leccion15/">15 · Diseñar una estrategia de testing para un proyecto →</a>
</div>
