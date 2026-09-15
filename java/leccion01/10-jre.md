---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 10-jre
lesson_number: "10"
title: JRE
description: Sitúa el concepto histórico de JRE frente al modelo actual del JDK.
---

# JRE

El Java Runtime Environment era el conjunto de componentes necesarios para ejecutar aplicaciones Java sin incluir las herramientas de desarrollo. Conceptualmente reunía la JVM y las bibliotecas de ejecución.

## El matiz en Java moderno

Desde Java 9 cambió la distribución de la plataforma y dejó de ser habitual descargar un JRE independiente como producto separado. Un JDK moderno incluye el entorno de ejecución; también pueden crearse runtimes reducidos con herramientas como `jlink`.

```text
JDK = herramientas de desarrollo + JVM + bibliotecas de ejecución
Runtime reducido = selección de módulos para ejecutar una aplicación
```

<div class="cla-note"><strong>Pregunta frecuente</strong><p>No confundas el concepto de entorno de ejecución con la existencia de un instalador JRE independiente para cada versión moderna de Java.</p></div>

## Desarrollo y despliegue

Durante el desarrollo necesitas las herramientas del JDK. En despliegue puedes usar el JDK completo, una imagen de runtime o un runtime reducido; la elección depende del tamaño y la forma de distribuir la aplicación.

La distinción es comparable a separar el SDK y el runtime en .NET. En JavaScript, el navegador o Node.js actúan como runtime, pero no ofrecen exactamente el mismo conjunto de APIs.