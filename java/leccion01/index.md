---
layout: lesson
route: java
lesson_id: leccion01
lesson_number: "01"
title: Introducción a Java
description: Primer contacto con Java 21.
permalink: /java/leccion01/
lessons:
  - id: objetivos
    title: Objetivos
  - id: contenido
    title: Contenido
  - id: referencias-reutilizables
    title: Referencias reutilizables
---

<section class="cla-lesson-overview">
	<div class="cla-lesson-kicker">Ruta Java · Fundamentos</div>
	<h1>Lección 01 · Introducción a Java</h1>
	<p class="cla-lesson-intro">Construye un modelo mental sólido de Java: desde el código fuente hasta la ejecución en la JVM.</p>
	<div class="cla-lesson-stats" aria-label="Resumen de la lección">
		<div class="cla-lesson-stat"><strong>18</strong><span>apartados</span></div>
		<div class="cla-lesson-stat"><strong>Java 21</strong><span>versión objetivo</span></div>
		<div class="cla-lesson-stat"><strong>Inicial</strong><span>nivel</span></div>
	</div>
</section>
<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-mapa-ruta-java.png" alt="Mapa visual de la ruta de aprendizaje de Java" loading="lazy">
</figure>


## Objetivos

- Comprender qué es Java.
- Instalar Java 21.
- Entender la JVM.
- Ejecutar el primer programa.

## Contenido

<div class="cla-content-map">
	<a href="01-bienvenida/"><span>01</span><strong>Bienvenido</strong><em>Orientación y objetivos</em></a>
	<a href="02-que-es-java/"><span>02</span><strong>¿Qué es Java?</strong><em>Lenguaje y plataforma</em></a>
	<a href="03-historia/"><span>03</span><strong>Historia</strong><em>De Oak a Java 21</em></a>
	<a href="04-caracteristicas/"><span>04</span><strong>Características</strong><em>Principios del ecosistema</em></a>
	<a href="05-versiones-java/"><span>05</span><strong>Versiones</strong><em>Ritmo de publicación</em></a>
	<a href="06-java-lts/"><span>06</span><strong>Java LTS</strong><em>Soporte y mantenimiento</em></a>
	<a href="07-jvm/"><span>07</span><strong>JVM</strong><em>La máquina virtual</em></a>
	<a href="08-bytecode/"><span>08</span><strong>Bytecode</strong><em>El formato intermedio</em></a>
	<a href="09-jdk/"><span>09</span><strong>JDK</strong><em>Kit de desarrollo</em></a>
	<a href="10-jre/"><span>10</span><strong>JRE</strong><em>Entorno de ejecución</em></a>
	<a href="11-openjdk/"><span>11</span><strong>OpenJDK</strong><em>Implementaciones</em></a>
	<a href="12-instalacion/"><span>12</span><strong>Instalación</strong><em>Preparar el entorno</em></a>
	<a href="13-primer-programa/"><span>13</span><strong>Primer programa</strong><em>Hola, Java</em></a>
	<a href="14-compilacion/"><span>14</span><strong>Compilación</strong><em>Del .java al .class</em></a>
	<a href="15-resumen/"><span>15</span><strong>Resumen</strong><em>Ideas esenciales</em></a>
	<a href="16-preguntas-oracle/"><span>16</span><strong>Preguntas Oracle</strong><em>Comprueba lo aprendido</em></a>
	<a href="17-preguntas-trampa/"><span>17</span><strong>Preguntas trampa</strong><em>Corrige conceptos</em></a>
	<a href="18-ejercicios/"><span>18</span><strong>Ejercicios</strong><em>Practica y entrega</em></a>
</div>

## Referencias reutilizables

{% for reference in site.data.references.java %}
- [{{ reference.title }}]({{ reference.url | relative_url }}): {{ reference.description }}
{% endfor %}

## Tarea para casa

Prepara `EntornoJava.md` con la versión instalada, distribución, salidas de `java -version` y `javac -version`, y un esquema propio del proceso de compilación y ejecución.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Actividades principales de la lección

Estas tres actividades sirven para consolidar la lección. Las dos primeras están pensadas para realizarse en clase y la tercera puede utilizarse como tarea para casa.

### Actividad 1 · Investiga tu instalación de Java

**Modalidad:** clase · **Tiempo orientativo:** 20–30 minutos

**Objetivo:** identificar el JDK instalado y relacionar los comandos del sistema con los conceptos estudiados.

1. Ejecuta `java -version` y `javac -version`.
2. Anota la distribución y la versión mayor instalada.
3. Comprueba si se trata de una versión LTS.
4. Localiza, si es posible, el directorio donde está instalado el JDK.
5. Explica con una frase qué función cumple `java` y cuál cumple `javac`.

**Comprobación:** la entrega debe permitir distinguir claramente JDK, JVM, compilador y versión de Java.

### Actividad 2 · Del código fuente a la JVM

**Modalidad:** clase · **Tiempo orientativo:** 30–40 minutos

**Objetivo:** observar de forma práctica las fases de compilación y ejecución.

1. Crea `HolaJava.java` con un mensaje sencillo.
2. Compílalo con `javac HolaJava.java`.
3. Comprueba que aparece `HolaJava.class`.
4. Ejecuta el programa con `java HolaJava`.
5. Inspecciona el bytecode con `javap -c HolaJava`.
6. Dibuja o escribe el recorrido `fuente → compilador → bytecode → JVM → ejecución`.

**Comprobación:** elimina el `.class` e intenta ejecutar de nuevo. Explica el resultado.

### Actividad 3 · Mi entorno Java

**Modalidad:** casa · **Tiempo orientativo:** 45–60 minutos

**Objetivo:** documentar de forma autónoma un entorno de desarrollo Java.

Crea un fichero `EntornoJava.md` que incluya:

- versión y distribución instalada;
- salida de `java -version` y `javac -version`;
- explicación propia de JDK, JVM y bytecode;
- comandos para compilar y ejecutar un programa;
- un pequeño esquema textual del proceso de ejecución;
- dos errores que hayas encontrado y cómo los resolviste.

**Entrega:** `EntornoJava.md` y un programa `HolaJava.java` compilable.

<div class="cla-lesson-nav"><a href="/java/">← Volver a la ruta</a><a href="/java/leccion02/">02 · Fundamentos de Java →</a></div>
