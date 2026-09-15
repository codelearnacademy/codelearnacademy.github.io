---
layout: lesson
route: testing
lesson_id: leccion55
lesson_file: 55-diseno-desacoplamiento-y-testabilidad
lesson_number: "55"
title: Diseño, desacoplamiento y testabilidad
description: Bloque «Diseño testeable». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion55/
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

# Diseño, desacoplamiento y testabilidad

Bloque «Diseño testeable». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Diseño, desacoplamiento y testabilidad**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Una interfaz pequeña puede separar una regla del mecanismo que obtiene datos. El test debe observar resultados, no fijar detalles internos sin necesidad.


## Ejemplo guiado

Guarda `Prueba55Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba55Test {
    interface Precios { int consultar(String codigo); }
    static int total(Precios precios, String codigo, int cantidad) {
        return precios.consultar(codigo) * cantidad;
    }
    @Test void calculaConUnPrecioConocido() {
        Precios precios = codigo -> 7;
        assertEquals(21, total(precios, "A", 3));
    }
}
```

Ejecuta `mvn -Dtest=Prueba55Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Crea un proveedor que rechace un código desconocido.
2. Indica una prueba adicional para un proveedor que consulta una base de datos.


## Qué debes recordar

Desacoplar facilita controlar entradas; la implementación externa conserva sus propias pruebas.


<div class="cla-lesson-nav">
  <a href="/testing/leccion54/">← 54 · Uso de Clock para controlar el tiempo</a>
  <a href="/testing/leccion56/">56 · Dummy, Stub, Fake, Mock y Spy →</a>
</div>
