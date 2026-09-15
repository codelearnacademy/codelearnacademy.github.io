---
layout: lesson
route: testing
lesson_id: leccion60
lesson_file: 60-cuando-no-utilizar-mocks
lesson_number: "60"
title: Cuándo no utilizar mocks
description: Bloque «Test doubles y Mockito». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion60/
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

# Cuándo no utilizar mocks

Bloque «Test doubles y Mockito». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Cuándo no utilizar mocks**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

No necesitas un mock para cada objeto. Valores y colecciones reales suelen ser más claros; simular la clase que quieres comprobar elimina evidencia sobre su comportamiento.


## Ejemplo guiado

Guarda `Prueba60Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba60Test {
    record Linea(int cantidad, int precio) {}
    static int total(java.util.List<Linea> lineas) {
        return lineas.stream().mapToInt(l -> l.cantidad() * l.precio()).sum();
    }
    @Test void sumaLineasReales() {
        assertEquals(26, total(java.util.List.of(new Linea(2, 10), new Linea(1, 6))));
    }
}
```

Ejecuta `mvn -Dtest=Prueba60Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Explica por qué no hace falta mockear Linea.
2. Identifica una dependencia externa que sí convendría sustituir para una prueba aislada.


## Qué debes recordar

Usa dobles donde ayuden a controlar una frontera; conserva objetos simples y la unidad probada reales.


<div class="cla-lesson-nav">
  <a href="/testing/leccion59/">← 59 · verify, @Mock, @InjectMocks y ArgumentCaptor</a>
  <a href="/testing/leccion61/">61 · Qué es Maven Surefire →</a>
</div>
