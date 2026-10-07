---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: Fundamentos de Java
description: Aprenderás la sintaxis básica, el flujo de control y los primeros elementos del lenguaje Java.
permalink: /java/leccion02/
lessons:
  - id: primeros-pasos
    title: Primeros pasos
  - id: estructura-programa
    title: Estructura del programa
  - id: variables-y-tipos
    title: Variables y tipos
  - id: operadores-y-expresiones
    title: Operadores y expresiones
  - id: entrada-y-salida
    title: Entrada y salida
  - id: condicionales
    title: Condicionales
  - id: bucles
    title: Bucles
  - id: metodos
    title: Métodos
  - id: resumen
    title: Resumen
  - id: algoritmos
    title: Algoritmos guiados
  - id: practica-final
    title: Práctica final
---

<section class="cla-lesson-overview">
	<div class="cla-lesson-kicker">Ruta Java · Fundamentos</div>
	<h1>Lección 02 · Fundamentos de Java</h1>
	<p class="cla-lesson-intro">Escribe, compila y ejecuta tus primeros programas Java con confianza: variables, decisiones, bucles y métodos.</p>
	<div class="cla-lesson-stats" aria-label="Resumen de la lección">
		<div class="cla-lesson-stat"><strong>11</strong><span>apartados</span></div>
		<div class="cla-lesson-stat"><strong>Java 21</strong><span>versión objetivo</span></div>
		<div class="cla-lesson-stat"><strong>Inicial</strong><span>nivel</span></div>
	</div>
</section>

## Objetivos

- Comprender la estructura de un programa Java.
- Declarar variables y elegir el tipo correcto.
- Usar operadores y expresiones de forma segura.
- Leer y escribir datos por consola.
- Tomar decisiones con condicionales.
- Repetir tareas con bucles.
- Organizar la lógica en métodos simples.

## Contenido

<div class="cla-content-map">
	<a href="01-primeros-pasos/"><span>01</span><strong>Primeros pasos</strong><em>Compila y ejecuta</em></a>
	<a href="02-estructura-programa/"><span>02</span><strong>Estructura del programa</strong><em>class, main y sentencias</em></a>
	<a href="03-variables-y-tipos/"><span>03</span><strong>Variables y tipos</strong><em>Datos básicos</em></a>
	<a href="04-operadores-y-expresiones/"><span>04</span><strong>Operadores</strong><em>Expresiones y cálculo</em></a>
	<a href="05-entrada-y-salida/"><span>05</span><strong>Entrada y salida</strong><em>Scanner y consola</em></a>
	<a href="06-condicionales/"><span>06</span><strong>Condicionales</strong><em>if, else y switch</em></a>
	<a href="07-bucles/"><span>07</span><strong>Bucles</strong><em>for, while y do while</em></a>
	<a href="08-metodos-y-parametros/"><span>08</span><strong>Métodos</strong><em>Reutilización y modularidad</em></a>
	<a href="09-resumen/"><span>09</span><strong>Resumen</strong><em>Lo esencial</em></a>
	<a href="11-algoritmos/"><span>10</span><strong>Algoritmos guiados</strong><em>20 ejercicios de progresión</em></a>
	<a href="10-practica-final/"><span>11</span><strong>Práctica final clases</strong><em>Guía para el alumno</em></a>
  <a href="12-clases-envolventes/"><span>12</span><strong>Clases envolventes</strong><em>Wrapper classes, boxing y unboxing</em></a>
  <a href="13-string/"><span>13</span><strong>Clase String</strong><em>Cadenas de caracteres y métodos principales</em></a>
  <a href="14-integer/"><span>14</span><strong>Clase Integer</strong><em>Conversión, constantes y métodos principales</em></a>
  <a href="15-math/"><span>15</span><strong>Clase Math</strong><em>Operaciones matemáticas y utilidades de la API</em></a>
  <a href="16-fechas/"><span>16</span><strong>Fechas y horas</strong><em>API de fechas y horas en Java</em></a>
  <a href="17-expreg/"><span>16</span><strong>Expresiones regulares</strong><em>API de expresiones regulares en Java</em></a>

</div>

## Referencias reutilizables

{% for reference in site.data.references.java %}
- [{{ reference.title }}]({{ reference.url | relative_url }}): {{ reference.description }}
{% endfor %}
- <a href="https://retosdeprogramacion.com/ejercicios/" target="_blank">Retos de programación</a>

## Tarea para casa

Construye una calculadora modular con `Scanner`, menú repetitivo, métodos para cada operación, validación básica y control de división por cero.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Actividades principales de la lección

### Actividad 1 · Ficha de alumno

**Modalidad:** clase · **Tiempo orientativo:** 35–45 minutos

**Objetivo:** integrar variables, tipos, `Scanner`, operadores y condicionales.

Crea un programa que solicite nombre, edad y nota de un alumno. Después debe mostrar una ficha y determinar si está aprobado.

**Requisitos:**

- utilizar tipos adecuados;
- leer los datos con `Scanner`;
- validar que la nota esté entre 0 y 10;
- usar un condicional para indicar `APROBADO` o `SUSPENSO`;
- mostrar una salida clara y legible.

**Comprobación:** prueba una nota suspensa, una aprobada y una entrada límite como `0` o `10`.

### Actividad 2 · Calculadora modular

**Modalidad:** clase · **Tiempo orientativo:** 50–60 minutos

**Objetivo:** practicar bucles, `switch`, métodos y validación.

Construye una calculadora con menú repetitivo que permita sumar, restar, multiplicar y dividir. Cada operación debe estar implementada en un método diferente.

**Requisitos mínimos:**

- menú dentro de un bucle;
- opción para salir;
- métodos `sumar`, `restar`, `multiplicar` y `dividir`;
- impedir la división entre cero;
- informar de opciones de menú incorrectas.

**Comprobación:** realiza al menos un caso de prueba por operación y uno de división entre cero.

### Actividad 3 · Gestor de notas

**Modalidad:** casa · **Tiempo orientativo:** 60–90 minutos

**Objetivo:** integrar bucles, métodos, condicionales y acumuladores.

El programa debe solicitar varias notas y calcular:

- media;
- nota máxima;
- nota mínima;
- número de aprobados;
- número de suspensos.

Separa las operaciones principales en métodos y documenta al menos cinco casos de prueba en un `README.md`.

<div class="cla-lesson-nav"><a href="/java/leccion01/">← 01 · Introducción a Java</a><a href="/java/leccion03/">03 · Estructuras de control →</a></div>
