---
layout: lesson
route: testing
lesson_id: leccion35
lesson_file: 35-organizacion-de-una-suite-de-pruebas-mantenible
lesson_number: "35"
title: Organización de una suite de pruebas mantenible
description: Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion35/
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

# Organización de una suite de pruebas mantenible

Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Organización de una suite de pruebas mantenible**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Una suite mantenible separa reglas, preparación y efectos externos. Evita una única clase enorme con escenarios sin relación.


## Ejemplo guiado

Organización propuesta:

```text
src/test/java/pedidos/CalculoTotalTest.java
src/test/java/pedidos/ValidacionCantidadTest.java
src/test/java/pedidos/PedidoRepositoryIT.java
```

Los dos Test comprueban reglas sin base de datos. RepositoryIT usa un entorno aislado y se ejecuta mediante Failsafe configurado. Un constructor de datos facilita crear pedidos, pero cada test declara los campos relevantes. Cambiar una regla de cantidad debe llevar a su grupo de tests, no obligar a entender toda la aplicación.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Propón dos clases para un sistema de reservas.
2. Identifica un helper útil y un dato que debe quedar explícito en el test.


## Qué debes recordar

Organiza por responsabilidad y frontera de prueba; compartir helpers no significa compartir estado mutable.


<div class="cla-lesson-nav">
  <a href="/testing/leccion34/">← 34 · @BeforeEach, @AfterEach, @BeforeAll y @AfterAll</a>
  <a href="/testing/leccion36/">36 · Boundary testing →</a>
</div>
