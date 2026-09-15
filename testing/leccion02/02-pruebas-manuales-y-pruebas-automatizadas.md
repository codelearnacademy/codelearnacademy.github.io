---
layout: lesson
route: testing
lesson_id: leccion02
lesson_file: 02-pruebas-manuales-y-pruebas-automatizadas
lesson_number: "02"
title: Pruebas manuales y pruebas automatizadas
description: Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion02/
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

# Pruebas manuales y pruebas automatizadas

Bloque «Fundamentos del testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Pruebas manuales y pruebas automatizadas**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Una comprobación manual la ejecuta e interpreta una persona; una automatizada expresa pasos y expectativas ejecutables. Pueden comprobar la misma regla, pero la exploración humana y la repetición automática aportan cosas distintas.


## Ejemplo guiado

Regla del pedido: la cantidad debe ser positiva.

| Entrada | Acción manual | Resultado esperado |
|---|---|---|
| 2 | Crear pedido con cantidad 2 | Pedido aceptado |
| 0 | Crear pedido con cantidad 0 | Error y ningún pedido nuevo |
| -1 | Crear pedido con cantidad -1 | Error y ningún pedido nuevo |

La automatización enviaría esas entradas a la operación y comprobaría su resultado. La persona también puede observar si el mensaje se entiende o si el foco del formulario permite corregirlo. No basta automatizar clics sin verificar resultados.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade un caso manual sobre claridad del error.
2. Especifica qué comprobaría automáticamente el caso 0.


## Qué debes recordar

Automatizar hace repetible una comprobación; no elimina la necesidad de explorar ni de definir resultados esperados.


<div class="cla-lesson-nav">
  <a href="/testing/leccion01/">← 01 · Introducción al testing de software</a>
  <a href="/testing/leccion03/">03 · Bugs, defectos y regresiones →</a>
</div>
