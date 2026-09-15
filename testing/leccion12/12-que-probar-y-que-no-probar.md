---
layout: lesson
route: testing
lesson_id: leccion12
lesson_file: 12-que-probar-y-que-no-probar
lesson_number: "12"
title: Qué probar y qué no probar
description: Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion12/
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

# Qué probar y qué no probar

Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Qué probar y qué no probar**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Prioriza comportamientos propios y riesgos relevantes. No necesitas repetir todas las pruebas internas de una biblioteca, pero sí comprobar que tu integración satisface el contrato utilizado.


## Ejemplo guiado

Para un pedido, comprobamos cantidad positiva, cálculo y persistencia. No escribimos una prueba que solo confirme que `ArrayList.add` funciona; sí comprobamos que la operación añade exactamente el pedido esperado. Si una consulta utiliza una regla particular de la base de datos, una prueba con esa base aporta evidencia que una lista en memoria no ofrece.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Clasifica tres pruebas posibles por riesgo cubierto.
2. Elimina una comprobación redundante y justifica qué evidencia conservas.


## Qué debes recordar

Prueba decisiones y contratos del producto, incluidos sus límites de integración.


<div class="cla-lesson-nav">
  <a href="/testing/leccion11/">← 11 · La pirámide de testing</a>
  <a href="/testing/leccion13/">13 · Coste, velocidad y aislamiento de las pruebas →</a>
</div>
