---
layout: lesson
route: testing
lesson_id: leccion69
lesson_file: 69-fases-integration-test-y-verify
lesson_number: "69"
title: Fases integration-test y verify
description: Bloque «Tests de integración y Maven Failsafe». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion69/
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

# Fases integration-test y verify

Bloque «Tests de integración y Maven Failsafe». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Fases integration-test y verify**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Failsafe ejecuta integración y comprueba su resultado al verificar. Invocar solo integration-test puede omitir limpieza y la evaluación final de sus fallos.


## Ejemplo guiado

Añade dentro de `build/plugins`, con JUnit ya configurado:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-failsafe-plugin</artifactId>
  <version>3.5.2</version>
  <executions>
    <execution><goals><goal>integration-test</goal><goal>verify</goal></goals></execution>
  </executions>
</plugin>
```

Crea `PedidoIT.java` con un test Jupiter que compruebe un resultado conocido. Ejecuta `mvn verify` y revisa `target/failsafe-reports`. Introduce una aserción incorrecta: Failsafe debe registrar el fallo y el build debe fallar en su verificación. Si necesitas iniciar y detener servicios, configura también su preparación y limpieza: Failsafe no los proporciona automáticamente.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Compara el reporte de un caso correcto y uno fallido.
2. Explica por qué se recomienda verify para completar el recorrido.


## Qué debes recordar

Ejecutar casos y evaluar su resultado son pasos distintos del flujo de integración.


<div class="cla-lesson-nav">
  <a href="/testing/leccion68/">← 68 · Configurar maven-failsafe-plugin</a>
  <a href="/testing/leccion70/">70 · mvn test frente a mvn verify →</a>
</div>
