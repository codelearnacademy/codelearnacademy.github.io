---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 05-versiones-java
lesson_number: "05"
title: Versiones
description: Entiende el ciclo de publicación y cómo declarar una versión objetivo.
---

# Versiones

Desde Java 9, el proyecto sigue un ciclo de publicación frecuente. Las versiones numeradas de forma consecutiva no implican que todas tengan el mismo periodo de soporte.

## Versiones LTS conocidas

Java 8, 11, 17 y 21 son versiones LTS ampliamente utilizadas. Java 21 es la versión objetivo de esta ruta. Elegir una LTS reduce cambios operativos cuando el proyecto necesita estabilidad.

## Versión del lenguaje y versión del JDK

El JDK tiene una versión concreta, pero el proyecto también puede limitar qué características del lenguaje y qué API permite. Declara esa decisión en la configuración de build y compruébala en CI.

```text
Código fuente -> compilador del JDK -> bytecode -> JVM compatible
```

<div class="cla-note"><strong>Evita la ambigüedad</strong><p>“Java instalado” no es una especificación suficiente. Indica, como mínimo, la versión mayor del JDK y la distribución usada.</p></div>

## Comparación de ciclos

Java publica versiones con una cadencia regular y distingue algunas versiones LTS. Python utiliza versiones principales y menores con calendarios propios; JavaScript evoluciona mediante ECMAScript y depende del motor que lo implemente. En todos los casos, el proyecto debe fijar una versión reproducible.

```bash
java --version
```