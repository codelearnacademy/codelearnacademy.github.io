---
layout: lesson
route: testing
lesson_id: leccion13
lesson_file: 13-coste-velocidad-y-aislamiento-de-las-pruebas
lesson_number: "13"
title: Coste, velocidad y aislamiento de las pruebas
description: Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion13/
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

# Coste, velocidad y aislamiento de las pruebas

Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Coste, velocidad y aislamiento de las pruebas**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Las pruebas con procesos externos suelen requerir más preparación y coordinación que una función aislada. Velocidad y aislamiento se evalúan junto con el riesgo que cubre cada prueba.


## Ejemplo guiado

| Caso | Dependencias | Evidencia |
|---|---|---|
| Calcular total | Ninguna externa | Regla aritmética |
| Guardar y recuperar | Base de datos de prueba | SQL y mapeo |
| Comprar desde navegador | Aplicación, navegador y proveedor de pruebas | Recorrido integrado |

Ejecutamos muchos casos de cálculo sin iniciar un navegador y reservamos recorridos completos para riesgos que lo necesitan. Medimos tiempos reales de la suite en lugar de asumir que toda prueba denominada unitaria es rápida.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Selecciona el nivel más pequeño que detecte un SQL incorrecto.
2. Identifica un coste de preparación del caso E2E.


## Qué debes recordar

Aislar reduce dependencias; integrar comprueba colaboraciones. Elige según la evidencia necesaria.


<div class="cla-lesson-nav">
  <a href="/testing/leccion12/">← 12 · Qué probar y qué no probar</a>
  <a href="/testing/leccion14/">14 · Tests como documentación del comportamiento →</a>
</div>
