---
layout: lesson
route: testing
lesson_id: leccion82
lesson_file: 82-decisiones-ramas-y-caminos-de-ejecucion
lesson_number: "82"
title: Decisiones, ramas y caminos de ejecución
description: Bloque «Complejidad y quality gates». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion82/
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

# Decisiones, ramas y caminos de ejecución

Bloque «Complejidad y quality gates». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Decisiones, ramas y caminos de ejecución**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Decisiones, ramas y caminos no son equivalentes. Cubrir cada resultado de decisiones individuales no garantiza todas sus combinaciones.


## Ejemplo guiado

Guarda `Prueba82Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba82Test {
    static int tarifa(boolean premium, boolean urgente) {
        int total = 10;
        if (premium) total -= 2;
        if (urgente) total += 5;
        return total;
    }
    @Test void cubreDosCombinaciones() {
        assertEquals(13, tarifa(true, true));
        assertEquals(10, tarifa(false, false));
    }
    @Test void compruebaCombinacionesRestantes() {
        assertEquals(8, tarifa(true, false));
        assertEquals(15, tarifa(false, true));
    }
}
```

Ejecuta `mvn -Dtest=Prueba82Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Explica qué ramas cubre el primer test y qué combinaciones faltan.
2. Relaciona la selección de casos con una regla de negocio, no solo con subir cobertura.


## Qué debes recordar

La cobertura de ramas no garantiza cobertura de todos los caminos posibles.


<div class="cla-lesson-nav">
  <a href="/testing/leccion81/">← 81 · Introducción a la complejidad ciclomática</a>
  <a href="/testing/leccion83/">83 · Complejidad cubierta y no cubierta en JaCoCo →</a>
</div>
