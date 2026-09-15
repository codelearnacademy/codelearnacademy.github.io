---
layout: lesson
route: testing
lesson_id: leccion15
lesson_file: 15-disenar-una-estrategia-de-testing-para-un-proyecto
lesson_number: "15"
title: Diseñar una estrategia de testing para un proyecto
description: Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion15/
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

# Diseñar una estrategia de testing para un proyecto

Bloque «Estrategia de testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Diseñar una estrategia de testing para un proyecto**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Una estrategia relaciona riesgos, comprobaciones, frecuencia y entorno. No exige un porcentaje universal entre niveles.


## Ejemplo guiado

| Riesgo | Comprobación | Momento |
|---|---|---|
| Total incorrecto | Casos de cálculo y límites | Cada cambio |
| Datos perdidos | Guardar, reiniciar y consultar en entorno aislado | Integración |
| Acceso ajeno | Consulta con dos cuentas | Cada cambio de autorización y antes de entrega |
| Compra inutilizable | Recorrido de compra | Antes de entregar |

Para cada fila asignamos quién mantiene datos y evidencia. Un fallo bloqueante debe impedir publicar hasta analizarlo; no se vuelve aceptable por reintentar sin investigar.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade un riesgo propio y cómo detectarlo.
2. Indica qué datos deben aislarse para ejecución concurrente.


## Qué debes recordar

La estrategia debe explicar por qué existe cada comprobación y qué decisión provoca su resultado.


<div class="cla-lesson-nav">
  <a href="/testing/leccion14/">← 14 · Tests como documentación del comportamiento</a>
  <a href="/testing/leccion16/">16 · Configurar Java 21 con Maven →</a>
</div>
