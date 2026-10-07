---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 17-preguntas-trampa
lesson_number: "17"
title: Preguntas trampa
description: Corrige confusiones frecuentes sobre la plataforma Java moderna.
---

# Preguntas trampa

Estas preguntas están diseñadas para revelar respuestas demasiado rápidas.

## ¿OpenJDK y Temurin son lo mismo?

No exactamente. OpenJDK es el proyecto y la base de implementación; Temurin es una distribución de JDK basada en OpenJDK.

## ¿La JVM compila el archivo `.java`?

No. `javac` compila el código fuente a bytecode. La JVM ejecuta ese bytecode y puede optimizarlo durante la ejecución.

## ¿Java es totalmente independiente del sistema operativo?

No. La JVM abstrae gran parte del sistema, pero la aplicación sigue interactuando con archivos, red, codificaciones, procesos y variables del entorno.

## ¿Existe un JRE independiente en Java 21?

No debe asumirse. El JDK incluye el entorno de ejecución y se pueden construir runtimes reducidos según las necesidades de la aplicación.

<div class="cla-note"><strong>Regla para el examen</strong><p>Cuando una afirmación usa “siempre”, “nunca” o “totalmente”, busca la condición que puede hacerla falsa.</p></div>

## Contraste con otros ecosistemas

Python distingue entre el lenguaje, CPython y sus distribuciones; JavaScript distingue el estándar del motor y de Node.js; C# distingue el lenguaje, el runtime y el SDK de .NET. Separar esos niveles evita trasladar una respuesta correcta de un ecosistema a otro sin comprobar sus reglas.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Cuál es el objetivo de una pregunta trampa bien diseñada?

- A) Confundir sin enseñar
- B) Detectar una idea errónea frecuente
- C) Memorizar letras
- D) Evitar ejecutar código

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Debe revelar y corregir modelos mentales incorrectos.</p>

</details>

### 2. Si dudas sobre qué imprime un código corto, ¿qué práctica ayuda?

- A) Predecir primero y ejecutar después
- B) Mirar solo la solución
- C) No compilar
- D) Cambiar el código antes de leerlo

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La predicción seguida de comprobación produce aprendizaje útil.</p>

</details>

### 3. ¿Una pregunta con opción correcta basta si no entiendes por qué?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La explicación de la respuesta es parte esencial de la autoevaluación.</p>

</details>

## Ejercicios propuestos

1. Crea dos preguntas trampa propias sobre compilación o JVM y explica la respuesta correcta.

