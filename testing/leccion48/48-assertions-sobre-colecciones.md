---
layout: lesson
route: testing
lesson_id: leccion48
lesson_file: 48-assertions-sobre-colecciones
lesson_number: "48"
title: Assertions sobre colecciones
description: Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion48/
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

# Assertions sobre colecciones

Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Assertions sobre colecciones**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Al comprobar colecciones, decide si el orden, duplicados y ausencia de elementos extra forman parte del contrato.


## Ejemplo guiado

Guarda `Prueba48Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba48Test {
    @Test void comparaColeccionesConYSinOrden() {
        var codigos = java.util.List.of("P-01", "P-02");
        org.assertj.core.api.Assertions.assertThat(codigos).containsExactly("P-01", "P-02");
        org.assertj.core.api.Assertions.assertThat(codigos).containsExactlyInAnyOrder("P-02", "P-01");
    }
}
```

Ejecuta `mvn -Dtest=Prueba48Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Invierte la lista y predice qué aserción falla.
2. Añade un elemento extra y comprueba la diferencia frente a contains.


## Qué debes recordar

Comprobar que algo está presente no comprueba que sea el contenido completo.


<div class="cla-lesson-nav">
  <a href="/testing/leccion47/">← 47 · Assertions sobre objetos y strings</a>
  <a href="/testing/leccion49/">49 · Assertions de excepciones →</a>
</div>
