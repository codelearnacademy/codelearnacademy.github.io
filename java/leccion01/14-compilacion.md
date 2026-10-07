---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 14-compilacion
lesson_number: "14"
title: Compilación
description: Compila y ejecuta el programa distinguiendo cada fase del proceso.
---

# Compilación

Desde la carpeta que contiene `Main.java`, ejecuta:

```bash
javac Main.java
java Main
```

El primer comando genera `Main.class`. El segundo recibe el nombre de la clase, no el nombre del archivo y tampoco la extensión `.class`.

## Separar las fases

```text
Main.java --javac--> Main.class --java--> JVM --> Hola Java 21
```

Si el compilador muestra un error, corrige el código fuente y vuelve a compilar. Si la compilación funciona pero la ejecución falla, revisa el directorio actual, el `CLASSPATH` y el nombre de la clase.

<div class="cla-note"><strong>Observación</strong><p>El archivo <code>.class</code> es un artefacto generado. En un proyecto real normalmente se guarda en una carpeta de build y no se versiona junto al código fuente.</p></div>

## Compilar a otra carpeta

Separa el código fuente de los artefactos generados:

```bash
mkdir -p out
javac -d out Main.java
java -cp out Main
```

La opción `-d` indica dónde escribir las clases y `-cp` indica dónde buscarlas al ejecutar. Maven y Gradle automatizan estas decisiones, igual que `dotnet build` en .NET.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-compilar-ejecutar.png" alt="01 compilar ejecutar" loading="lazy">
</figure>

### Ejemplo guiado

Ejecuta `javac Main.java`, comprueba que aparece `Main.class` y después ejecuta `java Main`.

### Ejercicio propuesto

Detecta el error en `java Main.java`, `javac Main` y `java Main.class` y escribe la forma correcta.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué comando compila Main.java?

- A) java Main.java siempre
- B) javac Main.java
- C) java Main.class
- D) compile Main

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> javac recibe el fichero fuente.</p>

</details>

### 2. Tras compilar correctamente, ¿qué fichero esperas encontrar?

- A) Main.class
- B) Main.sql
- C) Main.exe obligatoriamente
- D) Main.png

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El compilador genera bytecode en .class.</p>

</details>

### 3. ¿Qué comando ejecuta normalmente una clase Main compilada?

- A) java Main
- B) javac Main
- C) java Main.class
- D) run Main.java

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Se pasa el nombre de la clase, no la extensión .class.</p>

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

1. Compila y ejecuta una clase desde terminal sin usar el botón Run del IDE.
2. Provoca un error de compilación, copia el mensaje y explica cómo lo corregiste.

