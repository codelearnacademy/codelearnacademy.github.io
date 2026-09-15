---
layout: lesson
route: testing
lesson_id: leccion25
lesson_file: 25-ejecutar-pruebas-desde-el-ide-y-desde-maven
lesson_number: "25"
title: Ejecutar pruebas desde el IDE y desde Maven
description: Bloque «Primeros pasos con JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion25/
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

# Ejecutar pruebas desde el IDE y desde Maven

Bloque «Primeros pasos con JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Ejecutar pruebas desde el IDE y desde Maven**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

El IDE facilita ejecutar un caso; Maven utiliza la configuración del proyecto para una comprobación reproducible. Verifica que ambos usan el JDK y dependencias acordados.


## Ejemplo guiado

En el proyecto de la lección 21 ejecuta `Prueba21Test` desde el IDE. Después ejecuta:

```bash
mvn -Dtest=Prueba21Test test
mvn test
```

La primera orden selecciona la clase; la segunda ejecuta los tests unitarios descubiertos. Revisa `target/surefire-reports`: debe aparecer la clase y un test satisfactorio. Si Maven no descubre nada aunque el IDE lo ejecute, revisa nombres, motor Jupiter y configuración Surefire. Un build sin pruebas no equivale a haberlas superado.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Provoca un fallo y compara el diagnóstico del IDE con el reporte.
2. Anota qué clase ejecuta cada comando.


## Qué debes recordar

IDE y Maven deben comprobar el mismo proyecto; confirma el número de pruebas ejecutadas.


<div class="cla-lesson-nav">
  <a href="/testing/leccion24/">← 24 · Arrange, Act, Assert</a>
  <a href="/testing/leccion26/">26 · assertEquals, assertTrue y assertFalse →</a>
</div>
