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
<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-versiones-lts.png" alt="Versiones LTS de referencia en Java" loading="lazy">
</figure>


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
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Por qué importa declarar la versión de Java de un proyecto?

- A) Porque cambia el nombre del fichero
- B) Porque determina APIs y características disponibles
- C) Porque elimina Maven
- D) Porque cambia SQLite

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La versión objetivo determina qué sintaxis y APIs se pueden utilizar.</p>

</details>

### 2. ¿Qué significa que una versión sea LTS?

- A) Que solo dura seis meses
- B) Que recibe soporte durante un periodo prolongado
- C) Que no necesita JVM
- D) Que es una beta

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> LTS significa Long-Term Support.</p>

</details>

### 3. ¿Qué conviene comprobar antes de usar una API reciente?

- A) Que exista en la versión objetivo
- B) Que el fichero sea XML
- C) Que el IDE esté en inglés
- D) Que el equipo tenga Docker

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Una API puede no estar disponible en versiones anteriores.</p>

</details>

### 4. ¿Qué comando permite ver la versión del runtime?

- A) java -version
- B) javac -compile
- C) jdk --info
- D) mvn java

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> java -version muestra la versión del runtime Java.</p>

</details>

## Ejercicios propuestos

1. Consulta tu versión con `java -version` y anota versión mayor, distribución y si es LTS.

