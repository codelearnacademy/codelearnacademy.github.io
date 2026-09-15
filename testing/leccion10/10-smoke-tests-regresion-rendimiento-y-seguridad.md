---
layout: lesson
route: testing
lesson_id: leccion10
lesson_file: 10-smoke-tests-regresion-rendimiento-y-seguridad
lesson_number: "10"
title: Smoke tests, regresión, rendimiento y seguridad
description: Bloque «Tipos de pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion10/
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

# Smoke tests, regresión, rendimiento y seguridad

Bloque «Tipos de pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Smoke tests, regresión, rendimiento y seguridad**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Smoke, regresión, rendimiento y seguridad responden a objetivos diferentes. No forman una secuencia obligatoria ni son niveles intercambiables.


## Ejemplo guiado

| Objetivo | Comprobación del sistema de pedidos |
|---|---|
| Smoke | Arranca y responde su consulta básica |
| Regresión | El descuento corregido sigue calculándose bien |
| Rendimiento | Con carga y datos fijados, la latencia cumple el umbral acordado |
| Seguridad | Un usuario no puede consultar el pedido de otro |

Que pase el smoke no implica que pasen los demás. Para rendimiento, por ejemplo, fijamos 20 sesiones y 1.000 pedidos durante diez minutos; el umbral se acuerda antes y se registra el entorno. Son condiciones didácticas, no una recomendación universal.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Propón un fallo que escape al smoke.
2. Añade una expectativa observable a la prueba de acceso ajeno.


## Qué debes recordar

El propósito determina datos, entorno y evidencia; una etiqueta no sustituye el diseño del caso.


<div class="cla-lesson-nav">
  <a href="/testing/leccion09/">← 09 · Pruebas end-to-end y de aceptación</a>
  <a href="/testing/leccion11/">11 · La pirámide de testing →</a>
</div>
