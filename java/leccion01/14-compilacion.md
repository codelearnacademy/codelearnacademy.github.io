---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 14-compilacion
lesson_number: "14"
title: Compilación
description: Compila y ejecuta el programa distinguiendo cada fase del proceso.
lessons:
  - id: separar-las-fases
    title: "Separar las fases"
  - id: compilar-a-otra-carpeta
    title: "Compilar a otra carpeta"
  - id: refuerzo-practico
    title: "Refuerzo práctico"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Compilación

Desde la carpeta que contiene `Main.java`, ejecuta:

```bash
javac Main.java
java Main
```

El primer comando genera `Main.class`. El segundo recibe el nombre de la clase, no el nombre del archivo y tampoco la extensión `.class`.

## Separar las fases
{: #separar-las-fases }

```text
Main.java --javac--> Main.class --java--> JVM --> Hola Java 21
```

Si el compilador muestra un error, corrige el código fuente y vuelve a compilar. Si la compilación funciona pero la ejecución falla, revisa el directorio actual, el `CLASSPATH` y el nombre de la clase.

<div class="cla-note"><strong>Observación</strong><p>El archivo <code>.class</code> es un artefacto generado. En un proyecto real normalmente se guarda en una carpeta de build y no se versiona junto al código fuente.</p></div>

## Compilar a otra carpeta
{: #compilar-a-otra-carpeta }

Separa el código fuente de los artefactos generados:

```bash
mkdir -p out
javac -d out Main.java
java -cp out Main
```

La opción `-d` indica dónde escribir las clases y `-cp` indica dónde buscarlas al ejecutar. Maven y Gradle automatizan estas decisiones, igual que `dotnet build` en .NET.

## Refuerzo práctico
{: #refuerzo-practico }

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-compilar-ejecutar.webp' | relative_url }}" alt="01 compilar ejecutar" loading="lazy">
</figure>

### Ejemplo guiado

Ejecuta `javac Main.java`, comprueba que aparece `Main.class` y después ejecuta `java Main`.

### Ejercicio propuesto

Detecta el error en `java Main.java`, `javac Main` y `java Main.class` y escribe la forma correcta.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. Tras compilar Main.java, ¿cómo ejecutas Main desde la misma carpeta y sin paquetes?

- A) java Main
- B) java Main.class
- C) javac Main
- D) javac Main.class

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El lanzador java recibe el nombre de la clase y busca su bytecode.</p>

</details>

### 2. Tras compilar correctamente, ¿qué fichero esperas encontrar?

- A) Main.exe obligatoriamente
- B) Main.class
- C) Main.png
- D) Main.sql

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El compilador genera bytecode en .class.</p>

</details>

### 3. ¿Qué comando ejecuta normalmente una clase Main compilada?

- A) javac Main
- B) run Main.java
- C) java Main
- D) java Main.class

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Se pasa el nombre de la clase, no la extensión .class.</p>

</details>

### 4. ¿Un error de compilación impide obtener bytecode válido?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Si la compilación falla, no se genera una clase válida a partir de ese código.</p>

</details>

### 5. ¿Compilar y ejecutar son la misma fase?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Son fases diferentes: primero se produce bytecode y después se ejecuta.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Compila y ejecuta una clase desde terminal sin usar el botón Run del IDE.
2. Provoca un error de compilación, copia el mensaje y explica cómo lo corregiste.

