---
layout: lesson
route: testing
lesson_id: leccion09
lesson_file: 09-pruebas-end-to-end-y-de-aceptacion
lesson_number: "09"
title: Pruebas end-to-end y de aceptación
description: Bloque «Tipos de pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion09/
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

# Pruebas end-to-end y de aceptación

Bloque «Tipos de pruebas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Pruebas end-to-end y de aceptación**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

End-to-end describe un recorrido completo a través de componentes; aceptación comprueba condiciones para considerar adecuada una entrega. Pueden coincidir, pero no son sinónimos.


## Ejemplo guiado

Criterio de aceptación: una compra confirmada muestra su identificador y puede consultarse después. Caso E2E de práctica: abrir la interfaz, añadir un artículo, confirmar usando un proveedor de pago de pruebas, observar el identificador y consultar el pedido. Esperamos un único pedido confirmado. Este caso no valida cobros reales si el proveedor es simulado; hay que declarar ese límite. Otra aceptación, como comprender un mensaje, puede evaluarse sin ejecutar toda la cadena.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Especifica datos iniciales y resultado del recorrido.
2. Indica qué integración queda sin validar al simular el pago.


## Qué debes recordar

Declara la frontera de la prueba y los criterios que pretende aceptar.


<div class="cla-lesson-nav">
  <a href="/testing/leccion08/">← 08 · Pruebas funcionales y de sistema</a>
  <a href="/testing/leccion10/">10 · Smoke tests, regresión, rendimiento y seguridad →</a>
</div>
