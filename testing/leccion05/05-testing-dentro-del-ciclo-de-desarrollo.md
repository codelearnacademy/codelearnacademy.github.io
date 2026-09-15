---
layout: lesson
route: testing
lesson_id: leccion05
lesson_file: 05-testing-dentro-del-ciclo-de-desarrollo
lesson_number: "05"
title: Testing dentro del ciclo de desarrollo
description: Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion05/
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

# Testing dentro del ciclo de desarrollo

Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Testing dentro del ciclo de desarrollo**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Las pruebas acompañan al análisis, construcción, entrega y mantenimiento. Distintas comprobaciones proporcionan información en momentos diferentes.


## Ejemplo guiado

Para crear pedidos: durante requisitos acordamos cantidad positiva; antes de implementar escribimos ejemplos 1 → aceptado y 0 → rechazado; durante desarrollo probamos la regla; al integrar comprobamos que se guarda el pedido; antes de entregar recorremos la compra; tras un error añadimos una regresión. No esperamos a terminar toda la aplicación para definir qué significa funcionar.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Sitúa una prueba de persistencia y una de uso en el recorrido.
2. Indica qué prueba añadirías después de corregir un descuento.


## Qué debes recordar

La estrategia debe producir información temprana y conservarla durante la evolución.


<div class="cla-lesson-nav">
  <a href="/testing/leccion04/">← 04 · Qué puede demostrar una prueba</a>
  <a href="/testing/leccion06/">06 · Pruebas unitarias →</a>
</div>
