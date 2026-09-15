---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 15-resumen
lesson_number: "15"
title: Resumen
description: Reúne el modelo mental necesario para continuar con Java.
---

# Resumen

El recorrido completo se puede resumir así:

1. Escribes código fuente en un archivo `.java`.
2. El `javac` del JDK lo compila a bytecode `.class`.
3. La JVM carga, verifica y ejecuta ese bytecode.
4. Una distribución de OpenJDK proporciona un JDK concreto para tu sistema.

## Ideas esenciales

- Java es lenguaje y plataforma.
- La JVM es el entorno que ejecuta bytecode.
- El JDK incluye herramientas de desarrollo.
- LTS describe una política de soporte prolongado.
- OpenJDK y una distribución concreta no son exactamente lo mismo.
- Java 21 es la versión objetivo de esta ruta.

<div class="cla-note"><strong>Antes de continuar</strong><p>Deberías poder explicar qué ocurre entre <code>Main.java</code> y la salida del programa sin confundir compilador, bytecode y JVM.</p></div>

## Mapa comparativo

| Java | Python | C# |
| --- | --- | --- |
| JDK y `javac` | Intérprete y herramientas de Python | SDK y compilador .NET |
| `.class` | Bytecode del runtime | IL |
| JVM | CPython u otro runtime | CLR |

Los nombres cambian, pero la pregunta profesional es la misma: qué herramienta transforma el código, qué formato intermedio se genera y qué runtime lo ejecuta.