---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 05-versiones-java
lesson_number: "05"
title: Versiones
description: Entiende el ciclo de publicación y cómo declarar una versión objetivo.
lessons:
  - id: versiones-lts-conocidas
    title: "Versiones LTS conocidas"
  - id: version-del-lenguaje-y-version-del-jdk
    title: "Versión del lenguaje y versión del JDK"
  - id: comparacion-de-ciclos
    title: "Comparación de ciclos"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Versiones

Desde Java 9, el proyecto sigue un ciclo de publicación frecuente. Las versiones numeradas de forma consecutiva no implican que todas tengan el mismo periodo de soporte.

## Versiones LTS conocidas
{: #versiones-lts-conocidas }

Java 8, 11, 17 y 21 son versiones LTS ampliamente utilizadas. Java 21 es la versión objetivo de esta ruta. Elegir una LTS reduce cambios operativos cuando el proyecto necesita estabilidad.
<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-versiones-lts.webp' | relative_url }}" alt="Versiones LTS de referencia en Java" loading="lazy">
</figure>


## Versión del lenguaje y versión del JDK
{: #version-del-lenguaje-y-version-del-jdk }

El JDK tiene una versión concreta, pero el proyecto también puede limitar qué características del lenguaje y qué API permite. Declara esa decisión en la configuración de build y compruébala en CI.

```text
Código fuente -> compilador del JDK -> bytecode -> JVM compatible
```

<div class="cla-note"><strong>Evita la ambigüedad</strong><p>“Java instalado” no es una especificación suficiente. Indica, como mínimo, la versión mayor del JDK y la distribución usada.</p></div>

## Comparación de ciclos
{: #comparacion-de-ciclos }

Java publica versiones con una cadencia regular y distingue algunas versiones LTS. Python utiliza versiones principales y menores con calendarios propios; JavaScript evoluciona mediante ECMAScript y depende del motor que lo implemente. En todos los casos, el proyecto debe fijar una versión reproducible.

```bash
java --version
```
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Por qué importa declarar la versión de Java de un proyecto?

- A) Porque determina APIs y características disponibles
- B) Porque cambia SQLite
- C) Porque elimina Maven
- D) Porque cambia el nombre del fichero

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La versión objetivo determina qué sintaxis y APIs se pueden utilizar.</p>

</details>

### 2. ¿Qué significa que una versión sea LTS?

- A) Que no necesita JVM
- B) Que solo dura seis meses
- C) Que es una beta
- D) Que recibe soporte durante un periodo prolongado

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> LTS significa Long-Term Support.</p>

</details>

### 3. ¿Qué conviene comprobar antes de usar una API reciente?

- A) Que el fichero sea XML
- B) Que el equipo tenga Docker
- C) Que exista en la versión objetivo
- D) Que el IDE esté en inglés

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Una API puede no estar disponible en versiones anteriores.</p>

</details>

### 4. ¿Qué comando permite ver la versión del runtime?

- A) mvn java
- B) java -version
- C) jdk --info
- D) javac -compile

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> java -version muestra la versión del runtime Java.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Consulta tu versión con `java -version` y anota versión mayor, distribución y si es LTS.

