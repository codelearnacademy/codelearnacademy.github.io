---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 03-historia
lesson_number: "03"
title: Historia
description: Conoce los hitos que explican la evolución de Java.
lessons:
  - id: hitos-principales
    title: "Hitos principales"
  - id: una-consecuencia-practica
    title: "Una consecuencia práctica"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Historia

Java nació en Sun Microsystems como parte del proyecto Green. El lenguaje se llamó inicialmente Oak y se orientó a dispositivos embebidos; en 1995 pasó a llamarse Java y se presentó como una tecnología adecuada para la web.

## Hitos principales
{: #hitos-principales }

| Periodo | Hito | Consecuencia |
| --- | --- | --- |
| 1995 | Primera publicación de Java | Se populariza la ejecución mediante máquina virtual. |
| 2006 | Publicación de OpenJDK | El desarrollo de la plataforma gana una base abierta. |
| 2010 | Oracle adquiere Sun | Oracle pasa a liderar la evolución comercial de Java. |
| 2017 | Nuevo ciclo de publicación | Las versiones aparecen con mayor frecuencia. |
| 2018 | Versiones LTS | Algunas versiones reciben un ciclo de soporte más largo. |
<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-historia-java.webp' | relative_url }}" alt="Línea temporal simplificada de la evolución de Java" loading="lazy">
</figure>


La historia explica por qué conviven especificaciones, implementaciones y distribuciones. En un proyecto profesional conviene declarar siempre la versión del lenguaje, el JDK utilizado y la política de soporte.

## Una consecuencia práctica
{: #una-consecuencia-practica }

El ritmo histórico ha dejado APIs antiguas junto a alternativas modernas. Que una clase exista desde hace mucho tiempo no la convierte automáticamente en la mejor opción: consulta la documentación de la versión objetivo y revisa si está marcada como obsoleta.

En Python ocurre algo parecido entre Python 2 y Python 3, y en JavaScript entre distintas ediciones de ECMAScript: actualizar una versión implica revisar herramientas y dependencias, no solo cambiar un número.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Dónde nació Java?

- A) Oracle
- B) Microsoft
- C) IBM
- D) Sun Microsystems

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Java nació en Sun Microsystems dentro del proyecto Green.</p>

</details>

### 2. ¿Cómo se llamó inicialmente el lenguaje?

- A) Oak
- B) Duke
- C) JVM
- D) GreenLang

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El nombre inicial fue Oak antes de adoptar el nombre Java.</p>

</details>

### 3. ¿Qué ocurrió en 2006?

- A) Oracle adquirió Sun
- B) Se eliminó la JVM
- C) Apareció Java 21
- D) Se publicó OpenJDK

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La publicación de OpenJDK dio a la plataforma una base abierta.</p>

</details>

### 4. ¿Qué cambio relevante aparece a partir de 2017?

- A) Solo existen versiones LTS
- B) Desaparece el bytecode
- C) Se adopta un ciclo de publicaciones más frecuente
- D) Java deja de versionarse

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> La plataforma pasó a un ritmo de publicación más frecuente.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Construye una línea temporal con cuatro hitos de Java y explica qué cambió para los desarrolladores en cada uno.

