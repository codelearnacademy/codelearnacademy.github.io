---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 10-jre
lesson_number: "10"
title: JRE
description: Sitúa el concepto histórico de JRE frente al modelo actual del JDK.
lessons:
  - id: el-matiz-en-java-moderno
    title: "El matiz en Java moderno"
  - id: desarrollo-y-despliegue
    title: "Desarrollo y despliegue"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# JRE

El Java Runtime Environment era el conjunto de componentes necesarios para ejecutar aplicaciones Java sin incluir las herramientas de desarrollo. Conceptualmente reunía la JVM y las bibliotecas de ejecución.

## El matiz en Java moderno
{: #el-matiz-en-java-moderno }

Desde Java 9 cambió la distribución de la plataforma y dejó de ser habitual descargar un JRE independiente como producto separado. Un JDK moderno incluye el entorno de ejecución; también pueden crearse runtimes reducidos con herramientas como `jlink`.
<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-runtime-moderno.webp' | relative_url }}" alt="Comparación entre el JRE clásico y los runtimes modernos de Java" loading="lazy">
</figure>


```text
JDK = herramientas de desarrollo + JVM + bibliotecas de ejecución
Runtime reducido = selección de módulos para ejecutar una aplicación
```

<div class="cla-note"><strong>Pregunta frecuente</strong><p>No confundas el concepto de entorno de ejecución con la existencia de un instalador JRE independiente para cada versión moderna de Java.</p></div>

## Desarrollo y despliegue
{: #desarrollo-y-despliegue }

Durante el desarrollo necesitas las herramientas del JDK. En despliegue puedes usar el JDK completo, una imagen de runtime o un runtime reducido; la elección depende del tamaño y la forma de distribuir la aplicación.

La distinción es comparable a separar el SDK y el runtime en .NET. En JavaScript, el navegador o Node.js actúan como runtime, pero no ofrecen exactamente el mismo conjunto de APIs.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Qué función histórica se asociaba al JRE?

- A) Compilar C++
- B) Crear CSS
- C) Proporcionar un entorno para ejecutar aplicaciones Java
- D) Gestionar Git

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El JRE se entendía como el entorno necesario para ejecutar Java.</p>

</details>

### 2. ¿En Java moderno es imprescindible distribuir siempre un JRE separado?

- A) No
- B) Sí

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El modelo de distribución moderno permite runtimes y empaquetados más flexibles.</p>

</details>

### 3. ¿Qué herramienta permite construir runtimes personalizados en Java moderno?

- A) jlink
- B) sqlite3
- C) Scanner
- D) javap

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> jlink permite crear imágenes de runtime adaptadas a una aplicación modular.</p>

</details>

### 4. ¿Qué concepto continúa siendo central aunque cambie la distribución?

- A) El uso obligatorio de applets
- B) La ejecución mediante el runtime/JVM
- C) El uso de XML para todo
- D) La necesidad de Internet Explorer

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La forma de empaquetar cambia, pero el runtime de Java sigue siendo esencial.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Explica con tus palabras la diferencia entre el concepto histórico de JRE y el enfoque de runtimes modernos.

