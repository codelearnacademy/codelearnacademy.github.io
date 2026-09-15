---
layout: lesson
route: testing
lesson_id: leccion04
lesson_file: 04-que-puede-demostrar-una-prueba
lesson_number: "04"
title: Qué puede demostrar una prueba
description: Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion04/
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

# Qué puede demostrar una prueba

Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Qué puede demostrar una prueba**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Una prueba aporta evidencia para las entradas y condiciones ejercitadas. Pasar un caso no demuestra corrección para todas las entradas ni ausencia de requisitos omitidos.


## Ejemplo guiado

Supón una función incorrecta `total(cantidad)` que siempre devuelve 20. Una prueba con precio unitario 10 y cantidad 2 pasa, aunque la función esté mal. Agregar el caso cantidad 3 → total 30 revela el defecto. También faltaría decidir qué ocurre con cero y negativos. El problema no se resuelve solo ejecutando más veces el primer caso.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade dos entradas que distingan cálculo y constante.
2. Explica qué requisito no puedes inferir del caso cantidad 2.


## Qué debes recordar

Una comprobación que pasa puede ser insuficiente. Diseña casos que discriminen errores plausibles.


<div class="cla-lesson-nav">
  <a href="/testing/leccion03/">← 03 · Bugs, defectos y regresiones</a>
  <a href="/testing/leccion05/">05 · Testing dentro del ciclo de desarrollo →</a>
</div>
