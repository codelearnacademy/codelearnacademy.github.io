---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 16-preguntas-oracle
lesson_number: "16"
title: Preguntas Oracle
description: Comprueba conceptos básicos con preguntas de estilo certificación.
lessons:
  - id: 1-que-genera-javac
    title: "1. ¿Qué genera javac?"
  - id: 2-que-componente-ejecuta-el-bytecode
    title: "2. ¿Qué componente ejecuta el bytecode?"
  - id: 3-que-necesitas-para-compilar
    title: "3. ¿Qué necesitas para compilar?"
  - id: como-razonar-la-respuesta
    title: "Cómo razonar la respuesta"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Preguntas Oracle

Responde antes de abrir la solución.

## 1. ¿Qué genera `javac`?
{: #1-que-genera-javac }

- A. Un ejecutable nativo para cada sistema operativo.
- B. Archivos de bytecode, normalmente `.class`.
- C. Una imagen de contenedor.

<details class="cla-answer"><summary>Ver respuesta</summary><p><strong>B.</strong> El compilador transforma el código fuente en bytecode que puede cargar una JVM compatible.</p></details>

## 2. ¿Qué componente ejecuta el bytecode?
{: #2-que-componente-ejecuta-el-bytecode }

- A. La JVM.
- B. El editor de código.
- C. El archivo `.java`.

<details class="cla-answer"><summary>Ver respuesta</summary><p><strong>A.</strong> La JVM carga y ejecuta las clases compiladas.</p></details>

## 3. ¿Qué necesitas para compilar?
{: #3-que-necesitas-para-compilar }

- A. Un JDK.
- B. Solo un navegador.
- C. Solo un archivo `.class`.

<details class="cla-answer"><summary>Ver respuesta</summary><p><strong>A.</strong> El JDK incluye el comando <code>javac</code> y las herramientas de desarrollo.</p></details>

## Cómo razonar la respuesta
{: #como-razonar-la-respuesta }

En preguntas de certificación, identifica primero el verbo: “compilar” requiere una herramienta de desarrollo; “ejecutar” requiere un runtime; “distribuir” puede requerir empaquetado. El mismo criterio sirve al comparar Java con `python`, `dotnet` o `go`.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. Antes de mirar una respuesta de documentación, ¿qué conviene hacer?

- A) Formular una hipótesis propia
- B) Borrar el proyecto
- C) Copiarla sin leer
- D) Cambiar de lenguaje

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Intentar responder primero mejora el aprendizaje activo.</p>

</details>

### 2. ¿Qué fuente es especialmente útil para comprobar detalles de una API Java?

- A) El nombre del fichero
- B) Un comentario sin versión
- C) Documentación oficial de la versión objetivo
- D) Una imagen cualquiera

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> La documentación de la versión objetivo es la referencia más fiable.</p>

</details>

### 3. ¿Debes asumir que una respuesta válida para una versión antigua sigue siendo idéntica hoy?

- A) No
- B) Sí

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Las APIs y herramientas evolucionan; hay que contextualizar la versión.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Elige tres afirmaciones de la página, contrástalas con la documentación de tu versión y anota la evidencia.

