---
layout: lesson
route: testing
lesson_id: leccion72
lesson_file: 72-cobertura-de-instrucciones-y-lineas
lesson_number: "72"
title: Cobertura de instrucciones y líneas
description: Bloque «Cobertura de código». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion72/
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

# Cobertura de instrucciones y líneas

Bloque «Cobertura de código». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Cobertura de instrucciones y líneas**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

JaCoCo mide instrucciones de bytecode y líneas asociadas a información de depuración. Una línea puede contener instrucciones ejecutadas y no ejecutadas.


## Ejemplo guiado

Considera `int precio = premium ? 8 : 10;`. Un test solo con premium=true ejecuta parte de la línea y deja sin recorrer la alternativa. Añade premium=false y comprueba el reporte de JaCoCo configurado en el proyecto. La línea representa ambas alternativas y no equivale a una única instrucción. No deduzcas porcentajes exactos sin generar el reporte: dependen del bytecode y del código incluido.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Escribe ambos casos con sus precios esperados.
2. Distingue una línea parcialmente cubierta de una aserción que comprueba el resultado.


## Qué debes recordar

Cobertura describe ejecución; interpretar líneas exige considerar las instrucciones que representan.


<div class="cla-lesson-nav">
  <a href="/testing/leccion71/">← 71 · Qué significa cobertura</a>
  <a href="/testing/leccion73/">73 · Cobertura de ramas →</a>
</div>
