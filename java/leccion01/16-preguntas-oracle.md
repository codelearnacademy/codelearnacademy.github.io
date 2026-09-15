---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 16-preguntas-oracle
lesson_number: "16"
title: Preguntas Oracle
description: Comprueba conceptos básicos con preguntas de estilo certificación.
---

# Preguntas Oracle

Responde antes de abrir la solución.

## 1. ¿Qué genera `javac`?

- A. Un ejecutable nativo para cada sistema operativo.
- B. Archivos de bytecode, normalmente `.class`.
- C. Una imagen de contenedor.

<details class="cla-answer"><summary>Ver respuesta</summary><p><strong>B.</strong> El compilador transforma el código fuente en bytecode que puede cargar una JVM compatible.</p></details>

## 2. ¿Qué componente ejecuta el bytecode?

- A. La JVM.
- B. El editor de código.
- C. El archivo `.java`.

<details class="cla-answer"><summary>Ver respuesta</summary><p><strong>A.</strong> La JVM carga y ejecuta las clases compiladas.</p></details>

## 3. ¿Qué necesitas para compilar?

- A. Un JDK.
- B. Solo un navegador.
- C. Solo un archivo `.class`.

<details class="cla-answer"><summary>Ver respuesta</summary><p><strong>A.</strong> El JDK incluye el comando <code>javac</code> y las herramientas de desarrollo.</p></details>

## Cómo razonar la respuesta

En preguntas de certificación, identifica primero el verbo: “compilar” requiere una herramienta de desarrollo; “ejecutar” requiere un runtime; “distribuir” puede requerir empaquetado. El mismo criterio sirve al comparar Java con `python`, `dotnet` o `go`.