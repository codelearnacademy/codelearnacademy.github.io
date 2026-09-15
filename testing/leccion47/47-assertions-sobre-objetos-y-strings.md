---
layout: lesson
route: testing
lesson_id: leccion47
lesson_file: 47-assertions-sobre-objetos-y-strings
lesson_number: "47"
title: Assertions sobre objetos y strings
description: Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion47/
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

# Assertions sobre objetos y strings

Bloque «Assertions expresivas». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Assertions sobre objetos y strings**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

AssertJ ofrece aserciones encadenables. Para objetos, distingue igualdad de valores, identidad y propiedades; para textos, precisa si importan mayúsculas, espacios u orden.


## Ejemplo guiado

Guarda `Prueba47Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba47Test {
    record Pedido(String codigo, String estado) {}
    @Test void compruebaObjetoYTexto() {
        var pedido = new Pedido("P-01", "PENDIENTE");
        org.assertj.core.api.Assertions.assertThat(pedido).isEqualTo(new Pedido("P-01", "PENDIENTE"));
        org.assertj.core.api.Assertions.assertThat(pedido.codigo()).startsWith("P-").hasSize(4);
    }
}
```

Ejecuta `mvn -Dtest=Prueba47Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Cambia el estado esperado y observa la comparación.
2. Añade una regla de texto que pertenezca al contrato, no al formato accidental de toString.


## Qué debes recordar

La expresividad ayuda cuando representa reglas verificables.


<div class="cla-lesson-nav">
  <a href="/testing/leccion46/">← 46 · Introducción a AssertJ</a>
  <a href="/testing/leccion48/">48 · Assertions sobre colecciones →</a>
</div>
