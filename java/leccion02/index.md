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

# Ejercicios de repaso de la lección

Estos ejercicios se realizan después de estudiar todos los apartados. Hay cinco retos de repaso por cada concepto trabajado en la lección 2.

## Primeros pasos con Java

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible compilar y ejecutar desde terminal. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Primeros pasos con Java** a un contexto distinto del explicado en clase, por ejemplo una pequeña aplicación con dos clases. Usa `javac`, `java`, archivos `.java` y `.class` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Primeros pasos con Java** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con errores de sintaxis y cambios sin recompilar. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Primeros pasos con Java**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Estructura de un programa

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible organizar clase, `main`, bloques y sentencias. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Estructura de un programa** a un contexto distinto del explicado en clase, por ejemplo refactorizar un `main` largo en métodos. Usa llaves, punto y coma, métodos y convenciones y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Estructura de un programa** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con llaves desequilibradas, `main` incorrecto y nombre de clase. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Estructura de un programa**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Variables y tipos

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible declarar datos adecuados para un dominio. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Variables y tipos** a un contexto distinto del explicado en clase, por ejemplo modelar un producto o vehículo. Usa primitivos, `String`, `final` y casting y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Variables y tipos** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con rangos, pérdida de precisión y tipos incompatibles. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Variables y tipos**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Operadores y expresiones

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible construir cálculos y condiciones. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Operadores y expresiones** a un contexto distinto del explicado en clase, por ejemplo calcular una factura o presupuesto. Usa aritméticos, relacionales, lógicos, módulo y asignación y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Operadores y expresiones** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con precedencia, división entera y expresiones ambiguas. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Operadores y expresiones**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Entrada y salida

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible leer datos con `Scanner` y mostrar resultados. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Entrada y salida** a un contexto distinto del explicado en clase, por ejemplo crear un formulario de consola. Usa `nextLine`, `nextInt`, `nextDouble`, `print` y `println` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Entrada y salida** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con salto pendiente, valores vacíos y tipos incorrectos. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Entrada y salida**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Condicionales

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible seleccionar acciones según reglas. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Condicionales** a un contexto distinto del explicado en clase, por ejemplo clasificar notas, edades o permisos. Usa `if`, `else if`, `else`, `switch` y operadores lógicos y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Condicionales** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con límites, condiciones solapadas y `default`. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Condicionales**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Bucles

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible repetir procesos y acumular resultados. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Bucles** a un contexto distinto del explicado en clase, por ejemplo estadísticas, menús repetitivos o patrones. Usa `for`, `while`, `do while`, `break`, `continue` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Bucles** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con bucle infinito, límites e inicialización. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Bucles**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Métodos y parámetros

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible separar y reutilizar comportamiento. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Métodos y parámetros** a un contexto distinto del explicado en clase, por ejemplo refactorizar una calculadora monolítica. Usa parámetros, argumentos, `return`, `void`, ámbito y sobrecarga y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Métodos y parámetros** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con retornos ausentes, ámbito y firmas ambiguas. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Métodos y parámetros**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Clases envolventes

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible convertir y manejar valores objeto. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Clases envolventes** a un contexto distinto del explicado en clase, por ejemplo procesar un formulario recibido como texto. Usa autoboxing, unboxing, parseo, `equals` y constantes y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Clases envolventes** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con `null`, `NumberFormatException` y comparación con `==`. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Clases envolventes**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## String

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible analizar y transformar cadenas. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **String** a un contexto distinto del explicado en clase, por ejemplo normalizar nombres, correos o identificadores. Usa índices, `substring`, búsqueda, normalización y comparación y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **String** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con índices inválidos, inmutabilidad y `==` frente a `equals`. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **String**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Integer

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible convertir y comparar enteros. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Integer** a un contexto distinto del explicado en clase, por ejemplo validar configuración numérica. Usa `parseInt`, `valueOf`, `compare`, `MIN_VALUE`, `MAX_VALUE` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Integer** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con texto inválido, overflow y `null`. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Integer**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Math

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible realizar cálculos matemáticos. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Math** a un contexto distinto del explicado en clase, por ejemplo simular dados o resolver un problema geométrico. Usa `abs`, `sqrt`, `pow`, `min`, `max`, `round`, `ceil`, `floor`, `random` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Math** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con redondeos, rangos aleatorios y valores negativos. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Math**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Fechas y horas

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible trabajar con calendario y tiempo. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Fechas y horas** a un contexto distinto del explicado en clase, por ejemplo agenda, cumpleaños o plazos. Usa `LocalDate`, `LocalTime`, `LocalDateTime`, `Period`, `Duration`, formatter y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Fechas y horas** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con fechas inválidas, límites de mes y comparación. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Fechas y horas**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Expresiones regulares

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible validar y buscar patrones de texto. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Expresiones regulares** a un contexto distinto del explicado en clase, por ejemplo validar matrículas, usuarios o códigos. Usa metacaracteres, cuantificadores, anclas, grupos, `Pattern`, `Matcher` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Expresiones regulares** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con patrones demasiado permisivos y diferencia `matches`/`find`. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Expresiones regulares**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Ejercicio de repaso integrador · Presupuesto de pintura

**Modalidad:** repaso individual o por parejas · **Tiempo orientativo:** 35–50 minutos

**Objetivo:** consolidar lectura de datos con `Scanner`, variables, tipos numéricos, operadores aritméticos, cálculo de áreas y presentación de resultados mediante un problema cercano a una situación real.

### Enunciado

Una empresa de pintura necesita una pequeña aplicación de consola para calcular el presupuesto de pintar una pared rectangular.

El programa debe solicitar al usuario:

- nombre del cliente;
- ancho de la pared en metros;
- alto de la pared en metros;
- precio de la pintura por metro cuadrado.

A partir de esos datos debe calcular:

```text
superficie = ancho × alto
coste = superficie × precioPorMetro
```

El resultado debe mostrar, como mínimo:

- nombre del cliente;
- superficie total en metros cuadrados;
- precio por metro cuadrado;
- coste total del trabajo.

### Ejemplo de ejecución

```text
Nombre del cliente: Ana
Ancho de la pared: 5
Alto de la pared: 2.5
Precio por metro cuadrado: 8

Cliente: Ana
Superficie: 12.5 m²
Precio por m²: 8.0 €
Coste total: 100.0 €
```

### Requisitos mínimos

El programa debe:

1. contener una clase con método `main`;
2. utilizar `Scanner` para leer todos los datos;
3. usar `String` para el nombre del cliente;
4. usar `double` para medidas, superficies y precios;
5. emplear nombres de variables descriptivos;
6. realizar los cálculos mediante operadores aritméticos;
7. mostrar el resultado de forma clara con `System.out.println()` o `printf()`;
8. cerrar el `Scanner` al finalizar.

### Antes de programar

Completa primero este análisis:

```text
ENTRADA
- nombre
- ancho
- alto
- precioMetro

PROCESO
- calcular superficie
- calcular coste

SALIDA
- cliente
- superficie
- precio por m²
- coste total
```

Después transforma ese análisis en código Java. No empieces escribiendo directamente la solución completa.

### Comprobación

Prueba como mínimo estos casos:

| Caso | Ancho | Alto | Precio/m² | Superficie esperada | Coste esperado |
|---|---:|---:|---:|---:|---:|
| 1 | 5 | 2.5 | 8 | 12.5 m² | 100 € |
| 2 | 3 | 3 | 10 | 9 m² | 90 € |
| 3 | 7.5 | 2 | 6.5 | 15 m² | 97.5 € |

Añade un cuarto caso elegido por ti y anota el resultado esperado antes de ejecutar el programa.

### Ampliación 1 · Dos paredes

Modifica el programa para calcular el presupuesto de dos paredes:

```text
superficiePared1 = ancho1 × alto1
superficiePared2 = ancho2 × alto2
superficieTotal = superficiePared1 + superficiePared2
```

El presupuesto debe calcularse sobre la superficie total.

### Ampliación 2 · IVA

Añade un IVA del 21 % y muestra por separado:

```text
subtotal
IVA
TOTAL
```

El cálculo debe realizarse mediante variables, no escribiendo directamente el resultado esperado.

### Ampliación 3 · Descuento

Si ya se han estudiado los condicionales, añade esta regla:

> Si el coste antes de IVA supera los 500 €, se aplica un descuento del 10 %.

La salida debe indicar:

- coste inicial;
- descuento aplicado;
- subtotal después del descuento;
- IVA;
- total final.

### Entrega

Entrega:

```text
PresupuestoPintura.java
README.md
```

El `README.md` debe contener:

```markdown
# Presupuesto de pintura

## Datos de entrada

Describe los datos que solicita el programa.

## Cálculos realizados

Explica las fórmulas utilizadas.

## Casos de prueba

Incluye al menos cuatro ejecuciones y sus resultados.
```

### Criterios de revisión

Se comprobará que:

- el programa compila y se ejecuta;
- los datos se leen desde teclado;
- los tipos elegidos son adecuados;
- el cálculo del área es correcto;
- el coste se obtiene a partir de los datos introducidos;
- la salida es comprensible;
- se han realizado y documentado los casos de prueba;
- el código utiliza nombres de variables claros.

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
