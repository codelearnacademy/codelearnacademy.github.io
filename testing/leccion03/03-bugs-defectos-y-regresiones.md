---
layout: lesson
route: testing
lesson_id: leccion03
lesson_file: 03-bugs-defectos-y-regresiones
lesson_number: "03"
title: Bugs, defectos y regresiones
description: Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion03/
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

# Bugs, defectos y regresiones

Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Bugs, defectos y regresiones**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Un defecto es un problema en el producto; un fallo es su manifestación durante la ejecución. Una regresión aparece cuando un cambio rompe un comportamiento que antes funcionaba.


## Ejemplo guiado

Una compra de 100 euros tiene un descuento del 10 % y debe cobrar 90. Un cambio resta 10 % dos veces y cobra 81. Localizamos el defecto en el cálculo, conservamos el caso 100 → 90 y corregimos. Añadimos además 50 → 45 para evitar una reparación que solo devuelva 90 para cualquier entrada. Si ya existía el comportamiento correcto, este fallo es una regresión; la prueba lo protege en próximas versiones.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Distingue defecto y fallo en el ejemplo.
2. Propón otro importe y su resultado esperado.


## Qué debes recordar

La prueba de regresión debe expresar el comportamiento correcto y distinguirlo de una corrección incompleta.


<div class="cla-lesson-nav">
  <a href="/testing/leccion02/">← 02 · Pruebas manuales y pruebas automatizadas</a>
  <a href="/testing/leccion04/">04 · Qué puede demostrar una prueba →</a>
</div>
