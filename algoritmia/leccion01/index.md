---
layout: lesson
route: algoritmia
lesson_id: leccion01
lesson_number: "01"
title: Introducción a la algoritmia
description: Comprende qué es un algoritmo y aprende a describir soluciones paso a paso.
permalink: /algoritmia/leccion01/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: qué-es-la-algoritmia
    title: "Qué es la algoritmia"
  - id: qué-es-un-algoritmo
    title: "Qué es un algoritmo"
  - id: problema-algoritmo-y-programa
    title: "Problema, algoritmo y programa"
  - id: entrada-proceso-y-salida
    title: "Entrada, proceso y salida"
  - id: características-de-un-buen-algoritmo
    title: "Características de un buen algoritmo"
  - id: ejemplo-resuelto
    title: "Ejemplo resuelto"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Introducción a la algoritmia

Esta lección presenta la algoritmia como punto de partida para aprender programación: qué es un algoritmo, cómo se utiliza para resolver problemas y por qué conviene diseñar una solución antes de escribir código.

## Qué vas a conseguir

- Comprender qué es la algoritmia.
- Explicar qué es un algoritmo con vocabulario preciso.
- Diferenciar problema, algoritmo y programa.
- Identificar entrada, proceso y salida.
- Describir soluciones mediante pasos ordenados.
- Comprobar manualmente algoritmos sencillos.

<div class="cla-note"><strong>Ruta de estudio</strong><p>En esta primera lección no necesitas escribir código. El objetivo es aprender a pensar una solución antes de decidir cómo implementarla en un lenguaje de programación.</p></div>

## Punto de partida

No necesitas experiencia previa con programación.

Durante esta ruta aprenderás progresivamente a pasar de un problema expresado en lenguaje natural a una solución que posteriormente podrá convertirse en código.

```text
Problema
   ↓
Análisis
   ↓
Algoritmo
   ↓
Diagrama de flujo
   ↓
Pseudocódigo
   ↓
Programa
```

> **Idea clave:** primero pensamos la solución. Después escribimos el código.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion01/problema-algoritmo-programa.svg
Representar visualmente el recorrido Problema → Algoritmo → Programa. -->

## Qué es la algoritmia

La **algoritmia** estudia cómo diseñar procedimientos ordenados para resolver problemas. Nos ayuda a separar dos tareas diferentes: pensar una solución y expresarla posteriormente en un lenguaje de programación.

Un programador puede conocer muchas instrucciones de Java y, aun así, tener dificultades si no sabe decidir qué pasos debe ejecutar el programa. Por eso esta ruta comienza por la lógica y no por la sintaxis.

## Qué es un algoritmo

Un **algoritmo** es una secuencia finita y ordenada de pasos que permite resolver un problema o realizar una tarea.

Por ejemplo, para calcular la media de tres números podemos describir la solución así:

```text
1. Obtener el primer número.
2. Obtener el segundo número.
3. Obtener el tercer número.
4. Sumar los tres números.
5. Dividir la suma entre tres.
6. Mostrar el resultado.
```

No hemos utilizado ningún lenguaje de programación, pero ya hemos definido la lógica principal de la solución.

## Problema, algoritmo y programa

Un **problema** plantea algo que queremos resolver. Un **algoritmo** describe los pasos de la solución. Un **programa** implementa esos pasos con un lenguaje de programación.

```text
PROBLEMA
Calcular el área de un rectángulo
        ↓
ALGORITMO
Obtener base y altura → multiplicar → mostrar
        ↓
PROGRAMA
Código escrito en Java, Python u otro lenguaje
```

La misma lógica puede implementarse con lenguajes diferentes.

## Entrada, proceso y salida

Una forma sencilla de analizar muchos problemas es utilizar el modelo:

```text
Entrada → Proceso → Salida
```

Para calcular el área de un rectángulo:

```text
Entrada: base = 5, altura = 3
Proceso: area = base × altura
Salida: 15
```

<!-- IMAGEN MUY RECOMENDADA: /assets/images/algoritmia/leccion01/entrada-proceso-salida.svg
Tres bloques horizontales: Entrada → Proceso → Salida, usando el ejemplo 5 × 3 = 15. -->

## Características de un buen algoritmo

Un algoritmo debería ser **claro**, porque otra persona debe poder interpretarlo; **ordenado**, porque la secuencia importa; **finito**, porque debe terminar; y **comprobable**, porque debemos poder verificar sus resultados.

Compara:

```text
Mal:  Hacer los cálculos y mostrar algo.
Bien: Obtener dos números, sumarlos y mostrar la suma.
```

La segunda descripción permite saber exactamente qué debe ocurrir.

## Ejemplo resuelto

Queremos calcular el precio total de una compra con varias unidades del mismo artículo.

```text
Entrada:
precioUnidad = 12
cantidad = 4

Proceso:
precioTotal = precioUnidad × cantidad
precioTotal = 12 × 4
precioTotal = 48

Salida:
48
```

Algoritmo:

```text
1. Obtener el precio de una unidad.
2. Obtener la cantidad de unidades.
3. Multiplicar precio por cantidad.
4. Mostrar el precio total.
```

## Ejercicios

**Ejercicio 1.** Describe los pasos necesarios para calcular la media de tres números. Identifica entrada, proceso y salida.

**Ejercicio 2.** Diseña un algoritmo para calcular el área de un triángulo utilizando `area = base × altura / 2`.

**Ejercicio 3.** Explica mediante pasos cómo convertir una cantidad de horas en minutos.

**Reto.** Piensa en una tarea cotidiana —por ejemplo, preparar una mochila— y descríbela como un algoritmo. Intenta que otra persona pueda seguirlo sin hacerte preguntas.

## Qué debes recordar

La algoritmia enseña a **resolver problemas de forma ordenada**. El algoritmo describe la solución y el programa la implementa. Antes de comenzar a programar, acostúmbrate a identificar entrada, proceso y salida y a comprobar si los pasos realmente producen el resultado esperado.

<div class="cla-lesson-nav">
  <a href="/algoritmia/">← Volver a Algoritmia</a>
  <a href="/algoritmia/leccion02/">Lección 02 · Resolución de problemas →</a>
</div>
