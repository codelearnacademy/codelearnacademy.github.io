---
layout: lesson
route: testing
lesson_id: leccion17
lesson_file: 17-src-main-java-y-src-test-java
lesson_number: "17"
title: src/main/java y src/test/java
description: Bloque «Java 21 y Maven para testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.
permalink: /testing/leccion17/
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

# src/main/java y src/test/java

Bloque «Java 21 y Maven para testing». Trabaja el concepto desde Java 21 y llévalo siempre al build reproducible de Maven.

## Qué vas a conseguir

- Comprender **src/main/java y src/test/java**.
- Aplicarlo con Java 21.
- Relacionarlo con el lifecycle y los plugins Maven.
- Saber qué evidencia revisar cuando el build falla.

## Punto de partida

```text
Java 21 → JUnit/Mockito → Surefire → Failsafe → JaCoCo → quality gates → mvn verify
```

## Conceptos clave

Maven separa fuentes de producción y de prueba. Con el empaquetado JAR convencional, las clases de test no forman parte del artefacto de producción.


## Ejemplo guiado

Crea este árbol:

```text
src/main/java/ejemplo/Precio.java
src/test/java/ejemplo/PrecioTest.java
```

Precio declara `package ejemplo;` y `public static int doble(int n) { return n * 2; }` dentro de su clase. PrecioTest, en el mismo paquete, llama `assertEquals(8, Precio.doble(4))` desde un método `@Test`. Con JUnit configurado, ejecuta `mvn test`: debe pasar. Tras `mvn package`, inspecciona el JAR: debe incluir Precio.class, pero no PrecioTest.class. No pongas dependencias exclusivas de test en el alcance de producción.


## Integración con Maven

Los ejemplos ejecutables usan Java 21 y el [POM de práctica]({{ '/testing/ejemplos/' | relative_url }}), con JUnit Jupiter y Surefire. Los casos de análisis se resuelven indicando entradas, resultados y alcance; no todos requieren código. Las pruebas de integración necesitan su configuración de Failsafe y entorno cuando se indique.


## Ejercicios propuestos

1. Crea las dos clases completas con sus imports.
2. Inspecciona target/classes y target/test-classes.


## Qué debes recordar

La separación permite compilar pruebas con acceso al código productivo sin distribuirlas como parte de la aplicación.


<div class="cla-lesson-nav">
  <a href="/testing/leccion16/">← 16 · Configurar Java 21 con Maven</a>
  <a href="/testing/leccion18/">18 · El ciclo de compilación del código de test →</a>
</div>
