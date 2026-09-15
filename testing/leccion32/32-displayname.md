---
layout: lesson
route: testing
lesson_id: leccion32
lesson_file: 32-displayname
lesson_number: "32"
title: "@DisplayName"
description: Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion32/
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

# @DisplayName

Bloque «Organización de pruebas JUnit». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **@DisplayName**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

@DisplayName proporciona un nombre legible en reportes compatibles. El identificador Java del método sigue existiendo y no cambia cómo se calcula su resultado.


## Ejemplo guiado

Guarda `Prueba32Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba32Test {
    @Test
    @DisplayName("Una cantidad cero no crea un pedido")
    void cantidadCero() {
        assertFalse(0 > 0);
    }
}
```

Ejecuta `mvn -Dtest=Prueba32Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Consulta el nombre presentado por el IDE.
2. Añade un display name para cantidad positiva.


## Qué debes recordar

El nombre visible describe intención; las aserciones siguen siendo necesarias.


<div class="cla-lesson-nav">
  <a href="/testing/leccion31/">← 31 · Convenciones para nombrar tests</a>
  <a href="/testing/leccion33/">33 · @Nested →</a>
</div>
