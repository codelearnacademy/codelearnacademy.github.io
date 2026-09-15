---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 04-caracteristicas
lesson_number: "04"
title: Características
description: Identifica las propiedades que condicionan la forma de trabajar con Java.
---

# Características

Java combina varias decisiones de diseño que influyen en el código y en la operación de las aplicaciones.

## Propiedades esenciales

- **Tipado estático:** los tipos se comprueban durante la compilación.
- **Orientación a objetos:** el diseño se expresa mediante clases, objetos, estado y comportamiento.
- **Portabilidad:** el bytecode se ejecuta sobre JVM compatibles.
- **Gestión automática de memoria:** el recolector de basura recupera objetos que ya no son alcanzables.
- **Biblioteca estándar amplia:** incluye colecciones, entrada y salida, concurrencia, fechas y redes.
- **Ecosistema maduro:** existen herramientas, bibliotecas y prácticas consolidadas para equipos grandes.

## Qué no significa

La gestión automática de memoria no evita fugas lógicas, y la portabilidad no hace que una aplicación sea independiente de su entorno. Java aporta mecanismos; la calidad final depende del diseño, las pruebas y la operación del proyecto.

<div class="cla-note"><strong>Criterio profesional</strong><p>Describe Java con propiedades observables, no solo con adjetivos como “rápido” o “seguro”. Cada afirmación debe poder relacionarse con una decisión técnica.</p></div>

## Comparación con otros lenguajes

Java comparte el tipado estático con C# y Go, pero su ejecución depende de la JVM. Python y JavaScript permiten probar ideas con menos código inicial gracias a su tipado dinámico, mientras que Java detecta más errores antes de ejecutar.

```java
int total = 3;
total = total + 2;
```

El tipo `int` hace explícita la intención y ayuda al compilador, al IDE y a quienes mantienen el código.