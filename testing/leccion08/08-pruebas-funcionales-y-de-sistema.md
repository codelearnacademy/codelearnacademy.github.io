---
layout: lesson
route: testing
lesson_id: leccion08
lesson_file: 08-pruebas-funcionales-y-de-sistema
lesson_number: "08"
title: Pruebas funcionales y de sistema
description: Bloque «Tipos de pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion08/
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

# Pruebas funcionales y de sistema

Bloque «Tipos de pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Pruebas funcionales y de sistema**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Funcional describe qué se comprueba; sistema describe el nivel o alcance de la prueba. Una prueba funcional puede existir en distintos niveles, y una prueba de sistema también puede medir cualidades no funcionales.


## Ejemplo guiado

Sistema de pedidos desplegado con base de datos de prueba:

1. Crear pedido válido mediante su API.
2. Consultarlo en una petición independiente.
3. Comprobar cantidad, total y estado.
4. Rechazar cantidad cero sin crear un registro.

Esto comprueba comportamiento funcional a nivel de sistema. Medir el tiempo de respuesta bajo una carga definida sería otra prueba del sistema, de rendimiento. Repetir solo una función en memoria no cubre aquí la configuración y persistencia del conjunto.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Clasifica una prueba de cálculo y otra de rendimiento por objetivo y alcance.
2. Añade una condición de limpieza de datos al escenario.


## Qué debes recordar

Nivel y objetivo son dimensiones distintas; funcional no es sinónimo de sistema.


<div class="cla-lesson-nav">
  <a href="/testing/leccion07/">← 07 · Pruebas de integración</a>
  <a href="/testing/leccion09/">09 · Pruebas end-to-end y de aceptación →</a>
</div>
