---
layout: lesson
route: testing
lesson_id: leccion53
lesson_file: 53-aislar-reloj-filesystem-red-y-servicios-externos
lesson_number: "53"
title: Aislar reloj, filesystem, red y servicios externos
description: Bloque «Diseño testeable». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion53/
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

# Aislar reloj, filesystem, red y servicios externos

Bloque «Diseño testeable». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **Aislar reloj, filesystem, red y servicios externos**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Reloj, archivos y red requieren mecanismos de control distintos. Un directorio temporal no sustituye un contrato de red, ni un mock demuestra que un archivo se haya escrito.


## Ejemplo guiado

Guarda `Prueba53Test.java` en `src/test/java` del [proyecto de práctica]({{ '/testing/ejemplos/' | relative_url }}).

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Prueba53Test {
    @org.junit.jupiter.api.io.TempDir java.nio.file.Path dir;
    @Test void escribeEnUnDirectorioAislado() throws Exception {
        var archivo = dir.resolve("pedido.txt");
        java.nio.file.Files.writeString(archivo, "P-01", java.nio.charset.StandardCharsets.UTF_8);
        assertEquals("P-01", java.nio.file.Files.readString(archivo, java.nio.charset.StandardCharsets.UTF_8));
    }
}
```

Ejecuta `mvn -Dtest=Prueba53Test test`. Todas las comprobaciones mostradas deben pasar antes de realizar las variaciones del ejercicio.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Explica qué evita usar un directorio fijo compartido.
2. Diseña una frontera para un cliente HTTP y otra prueba para su adaptación real.


## Qué debes recordar

Controla cada efecto con un mecanismo apropiado y declara qué queda fuera del caso.


<div class="cla-lesson-nav">
  <a href="/testing/leccion52/">← 52 · Dependency Injection y testing</a>
  <a href="/testing/leccion54/">54 · Uso de Clock para controlar el tiempo →</a>
</div>
