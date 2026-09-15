---
layout: lesson
route: testing
lesson_id: leccion33
lesson_file: 33-nested
lesson_number: "33"
title: "@Nested"
description: Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion33/
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

# @Nested

Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **@Nested**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

@Nested permite agrupar contextos relacionados en clases internas no estáticas. Cada escenario debe conservar independencia aunque comparta preparación.


## Ejemplo guiado

Guarda `Prueba33Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba33Test {
    @Nested
    class ConListaVacia {
        java.util.List<String> pedidos;
        @BeforeEach void preparar() { pedidos = new java.util.ArrayList<>(); }
        @Test void comienzaSinPedidos() { assertTrue(pedidos.isEmpty()); }
        @Test void permiteAnadirUno() {
            pedidos.add("P-01");
            assertEquals(1, pedidos.size());
        }
    }
}
```

Ejecuta `mvn -Dtest=Prueba33Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Ejecuta cada método por separado.
2. Añade un contexto distinto con una lista inicialmente poblada.


## Qué debes recordar

La estructura debe hacer visibles contextos, sin introducir dependencia entre tests.


<div class="cla-lesson-nav">
  <a href="/testing/leccion32/">← 32 · @DisplayName</a>
  <a href="/testing/leccion34/">34 · @BeforeEach, @AfterEach, @BeforeAll y @AfterAll →</a>
</div>
