---
layout: lesson
route: testing
lesson_id: leccion63
lesson_file: 63-como-detecta-maven-los-tests-unitarios
lesson_number: "63"
title: Cómo detecta Maven los tests unitarios
description: Bloque «Maven Surefire». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion63/
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

# Cómo detecta Maven los tests unitarios

Bloque «Maven Surefire». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Cómo detecta Maven los tests unitarios**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Surefire descubre clases según convenciones o configuración. Las anotaciones identifican métodos, pero el nombre del archivo puede impedir que Maven seleccione su clase.


## Ejemplo guiado

Con la configuración predeterminada habitual de Surefire, los patrones incluyen Test*, *Test, *Tests y *TestCase. Usa `PedidoTest.java` con un método Jupiter válido. Comprueba su ejecución con `mvn test`. Una clase `ComprobacionPedido.java` puede quedar fuera de esa selección; usa `mvn -Dtest=ComprobacionPedido test` para seleccionarla explícitamente o adapta la convención. Compara los reportes, no solo el código de salida. Las convenciones no determinan por sí solas si la prueba es unitaria: lo determina lo que ejecuta.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Renombra una clase y compara cuántos tests se ejecutan.
2. Explica por qué una clase *Test que accede a la base de datos sigue siendo una prueba de integración.


## Qué debes recordar

Nombre, anotaciones y configuración participan en descubrimiento; el alcance real determina el tipo de prueba.


<div class="cla-lesson-nav">
  <a href="/testing/leccion62/">← 62 · Configurar maven-surefire-plugin</a>
  <a href="/testing/leccion64/">64 · Reportes en target/surefire-reports →</a>
</div>
