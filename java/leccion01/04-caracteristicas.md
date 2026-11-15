---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 04-caracteristicas
lesson_number: "04"
title: Características
description: Identifica las propiedades que condicionan la forma de trabajar con Java.
lessons:
  - id: propiedades-esenciales
    title: "Propiedades esenciales"
  - id: que-no-significa
    title: "Qué no significa"
  - id: comparacion-con-otros-lenguajes
    title: "Comparación con otros lenguajes"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Características

Java combina varias decisiones de diseño que influyen en el código y en la operación de las aplicaciones.

## Propiedades esenciales
{: #propiedades-esenciales }

- **Tipado estático:** los tipos se comprueban durante la compilación.
- **Orientación a objetos:** el diseño se expresa mediante clases, objetos, estado y comportamiento.
- **Portabilidad:** el bytecode se ejecuta sobre JVM compatibles.
- **Gestión automática de memoria:** el recolector de basura recupera objetos que ya no son alcanzables.
- **Biblioteca estándar amplia:** incluye colecciones, entrada y salida, concurrencia, fechas y redes.
- **Ecosistema maduro:** existen herramientas, bibliotecas y prácticas consolidadas para equipos grandes.
<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-caracteristicas-java.webp' | relative_url }}" alt="Características esenciales del lenguaje y la plataforma Java" loading="lazy">
</figure>


## Qué no significa
{: #que-no-significa }

La gestión automática de memoria no evita fugas lógicas, y la portabilidad no hace que una aplicación sea independiente de su entorno. Java aporta mecanismos; la calidad final depende del diseño, las pruebas y la operación del proyecto.

<div class="cla-note"><strong>Criterio profesional</strong><p>Describe Java con propiedades observables, no solo con adjetivos como “rápido” o “seguro”. Cada afirmación debe poder relacionarse con una decisión técnica.</p></div>

## Comparación con otros lenguajes
{: #comparacion-con-otros-lenguajes }

Java comparte el tipado estático con C# y Go, pero su ejecución depende de la JVM. Python y JavaScript permiten probar ideas con menos código inicial gracias a su tipado dinámico, mientras que Java detecta más errores antes de ejecutar.

```java
int total = 3;
total = total + 2;
```

El tipo `int` hace explícita la intención y ayuda al compilador, al IDE y a quienes mantienen el código.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Qué característica favorece ejecutar Java en distintos sistemas?

- A) Compilación a C
- B) Portabilidad
- C) Herencia múltiple de clases
- D) Macros

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La portabilidad es una de las características centrales de Java.</p>

</details>

### 2. ¿Qué mecanismo gestiona automáticamente memoria no utilizada?

- A) javac
- B) Scanner
- C) Maven
- D) Garbage Collector

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> El recolector de basura ayuda a recuperar memoria de objetos no alcanzables.</p>

</details>

### 3. ¿Qué paradigma tiene un peso importante en Java?

- A) Programación visual
- B) Programación orientada a objetos
- C) Solo ensamblador
- D) Solo programación funcional

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Java está fuertemente orientado a objetos, aunque incorpora otras capacidades.</p>

</details>

### 4. ¿Qué afirmación es correcta?

- A) Java carece de excepciones
- B) Todas las variables son String
- C) Java tiene tipado estático
- D) Java no comprueba tipos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Los tipos se comprueban de forma estática durante la compilación.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Elige cuatro características de Java y escribe un ejemplo concreto de por qué pueden ser útiles en un proyecto.

