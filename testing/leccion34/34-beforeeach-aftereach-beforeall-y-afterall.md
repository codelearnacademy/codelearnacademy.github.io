---
layout: lesson
route: testing
lesson_id: leccion34
lesson_file: 34-beforeeach-aftereach-beforeall-y-afterall
lesson_number: "34"
title: "@BeforeEach, @AfterEach, @BeforeAll y @AfterAll"
description: Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion34/
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

# @BeforeEach, @AfterEach, @BeforeAll y @AfterAll

Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **@BeforeEach, @AfterEach, @BeforeAll y @AfterAll**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

BeforeEach/AfterEach rodean cada test; BeforeAll/AfterAll rodean el conjunto de la clase. En el ciclo por defecto, los métodos BeforeAll/AfterAll son estáticos.


## Ejemplo guiado

Guarda `Prueba34Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba34Test {
    java.util.List<String> pedidos;
    @BeforeAll static void antesDeTodos() { System.out.println("Inicio de clase"); }
    @BeforeEach void preparar() { pedidos = new java.util.ArrayList<>(); }
    @Test void creaUno() { pedidos.add("P-01"); assertEquals(1, pedidos.size()); }
    @Test void otroCasoEmpiezaVacio() { assertTrue(pedidos.isEmpty()); }
    @AfterEach void limpiar() { pedidos.clear(); }
    @AfterAll static void despuesDeTodos() { System.out.println("Fin de clase"); }
}
```

Ejecuta `mvn -Dtest=Prueba34Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Explica por qué el segundo test no depende de ejecutar primero el otro.
2. Identifica qué recurso externo sí requeriría una liberación explícita.


## Qué debes recordar

Inicializa datos por prueba; reserva preparación compartida para recursos cuyo uso no rompa el aislamiento.


<div class="cla-lesson-nav">
  <a href="/testing/leccion33/">← 33 · @Nested</a>
  <a href="/testing/leccion35/">35 · Organización de una suite de pruebas mantenible →</a>
</div>
