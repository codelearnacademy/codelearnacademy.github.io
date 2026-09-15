---
layout: lesson
route: testing
lesson_id: leccion19
lesson_file: 19-records-sealed-classes-y-testing-en-java-21
lesson_number: "19"
title: Records, sealed classes y testing en Java 21
description: Bloque «Java 21 y Maven para testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion19/
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

# Records, sealed classes y testing en Java 21

Bloque «Java 21 y Maven para testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Records, sealed classes y testing en Java 21**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Los records tienen igualdad por componentes. Una jerarquía sealed limita sus subtipos permitidos; las pruebas deben cubrir comportamientos de cada variante, no solo comprobar que las clases existen.


## Ejemplo guiado

Guarda `Prueba19Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba19Test {
    sealed interface Resultado permits Aceptado, Rechazado {}
    record Aceptado(int total) implements Resultado {}
    record Rechazado(String motivo) implements Resultado {}
    static Resultado comprar(int cantidad) {
        return cantidad > 0 ? new Aceptado(cantidad * 10) : new Rechazado("cantidad");
    }
    @Test void aceptaCantidadPositiva() { assertEquals(new Aceptado(20), comprar(2)); }
    @Test void rechazaCantidadCero() { assertEquals(new Rechazado("cantidad"), comprar(0)); }
}
```

Ejecuta `mvn -Dtest=Prueba19Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Añade cantidad negativa y su resultado.
2. Explica por qué assertSame no representa la comparación de estos records.


## Qué debes recordar

Prueba resultados y variantes del contrato. Java 21 admite estos tipos sin opciones de preview.


<div class="cla-lesson-nav">
  <a href="/testing/leccion18/">← 18 · El ciclo de compilación del código de test</a>
  <a href="/testing/leccion20/">20 · Maven como eje de automatización de calidad →</a>
</div>
