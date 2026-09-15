---
layout: lesson
route: testing
lesson_id: leccion74
lesson_file: 74-cobertura-de-metodos-y-clases
lesson_number: "74"
title: Cobertura de métodos y clases
description: Bloque «Cobertura de código». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion74/
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

# Cobertura de métodos y clases

Bloque «Cobertura de código». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Cobertura de métodos y clases**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

La cobertura de métodos y clases indica si se ejecutó código de esas unidades, no si todos sus caminos se comprobaron. JaCoCo también cuenta constructores e inicializadores según el bytecode.


## Ejemplo guiado

Una clase tiene un constructor, `crear()` y `cancelar()`. Un test construye la clase y llama solo a crear. La clase puede aparecer cubierta aunque cancelar no se haya ejecutado. Si crear contiene varios caminos, ejecutar uno tampoco los cubre todos. Genera el reporte y revisa métodos y ramas en lugar de interpretar «clase cubierta» como «clase verificada».


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade un caso de cancelación y observa los contadores.
2. Identifica un camino de crear todavía no ejercitado.


## Qué debes recordar

Una unidad cubierta puede contener comportamiento sin comprobar; utiliza el detalle del reporte.


<div class="cla-lesson-nav">
  <a href="/testing/leccion73/">← 73 · Cobertura de ramas</a>
  <a href="/testing/leccion75/">75 · Por qué 100 % de cobertura no significa software correcto →</a>
</div>
