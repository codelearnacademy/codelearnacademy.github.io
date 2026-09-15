---
layout: lesson
route: testing
lesson_id: leccion18
lesson_file: 18-el-ciclo-de-compilacion-del-codigo-de-test
lesson_number: "18"
title: El ciclo de compilación del código de test
description: Bloque «Java 21 y Maven para testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion18/
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

# El ciclo de compilación del código de test

Bloque «Java 21 y Maven para testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **El ciclo de compilación del código de test**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Compilar pruebas y ejecutarlas son pasos distintos. Un error de compilación de un test impide llegar a sus aserciones.


## Ejemplo guiado

En un proyecto con JUnit configurado, crea una clase `PrecioTest` válida. Ejecuta `mvn test-compile`: busca el .class en `target/test-classes`; todavía no esperes un resultado de ejecución de Surefire por esa fase sola. Ejecuta después `mvn test` y consulta el reporte. Sustituye temporalmente una llamada por un método inexistente: debe fallar compilación. Restaura y cambia el esperado por uno incorrecto: ahora compila y falla la aserción. Son diagnósticos diferentes.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Anota cómo distingue el log ambos fallos.
2. Explica por qué test-compile satisfactorio no demuestra que las pruebas pasen.


## Qué debes recordar

Compilación valida código; ejecución comprueba expectativas. Localiza la fase antes de diagnosticar.


<div class="cla-lesson-nav">
  <a href="/testing/leccion17/">← 17 · src/main/java y src/test/java</a>
  <a href="/testing/leccion19/">19 · Records, sealed classes y testing en Java 21 →</a>
</div>
