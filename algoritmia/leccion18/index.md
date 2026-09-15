---
layout: lesson
route: algoritmia
lesson_id: leccion18
lesson_number: "18"
title: Ejercicios y retos de algoritmia
description: Practica la resolución de problemas combinando secuencias, decisiones, bucles y funciones.
permalink: /algoritmia/leccion18/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: método-de-trabajo
    title: "Método de trabajo"
  - id: ejemplo-resuelto-suma-de-pares
    title: "Ejemplo resuelto: suma de pares"
  - id: nivel-1-secuencias
    title: "Nivel 1 · Secuencias"
  - id: nivel-2-condiciones
    title: "Nivel 2 · Condiciones"
  - id: nivel-3-bucles
    title: "Nivel 3 · Bucles"
  - id: nivel-4-funciones
    title: "Nivel 4 · Funciones"
  - id: reto-1-cajero-sencillo
    title: "Reto 1 · Cajero sencillo"
  - id: reto-2-estadísticas-de-notas
    title: "Reto 2 · Estadísticas de notas"
  - id: reto-3-adivinanza-controlada
    title: "Reto 3 · Adivinanza controlada"
  - id: autoevaluación
    title: "Autoevaluación"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Ejercicios y retos de algoritmia

Esta lección reúne problemas progresivos para practicar toda la ruta. El objetivo no es escribir código rápidamente, sino aplicar un método constante: analizar, representar, comprobar y solo después pensar en una implementación.

## Qué vas a conseguir

- Integrar secuencias, decisiones y bucles.
- Practicar contadores y acumuladores.
- Diseñar funciones sencillas.
- Crear diagramas y pseudocódigo de una misma solución.
- Elegir casos de prueba adecuados.

## Método de trabajo

Para cada ejercicio entrega, siempre que sea posible:

```text
1. Entrada, proceso y salida.
2. Algoritmo en lenguaje estructurado.
3. Diagrama de flujo.
4. Pseudocódigo.
5. Al menos tres casos de prueba.
```

<div class="cla-note"><strong>No saltes directamente a la solución</strong><p>Si un problema parece difícil, reduce sus datos, prueba un ejemplo manual y divide el objetivo en partes más pequeñas.</p></div>

## Ejemplo resuelto: suma de pares

Problema: sumar los números pares desde `1` hasta `10`.

Análisis:

```text
Entrada: límite = 10
Proceso: recorrer números y acumular los pares
Salida: sumaPares
```

Pseudocódigo:

```text
sumaPares ← 0
PARA numero DESDE 1 HASTA 10 HACER
    SI numero MOD 2 = 0 ENTONCES
        sumaPares ← sumaPares + numero
    FIN SI
FIN PARA
ESCRIBIR sumaPares
```

Resultado esperado: `30`.

## Nivel 1 · Secuencias

**Ejercicio 1.** Calcula el área y perímetro de un rectángulo.

**Ejercicio 2.** Convierte segundos totales en minutos y segundos restantes.

**Ejercicio 3.** Calcula el coste de una compra con impuesto fijo.

**Ejercicio 4.** Convierte kilómetros por hora a metros por segundo usando `m/s = km/h / 3.6`.

## Nivel 2 · Condiciones

**Ejercicio 5.** Indica si un número es positivo, negativo o cero.

**Ejercicio 6.** Muestra el mayor de tres números.

**Ejercicio 7.** Determina si una persona obtiene descuento según edad y tipo de cliente.

**Ejercicio 8.** Clasifica una nota con los rangos utilizados en la lección 10.

## Nivel 3 · Bucles

**Ejercicio 9.** Muestra los múltiplos de 5 hasta 100.

**Ejercicio 10.** Suma los números desde `1` hasta un límite indicado por el usuario.

**Ejercicio 11.** Lee diez números y cuenta cuántos son positivos, negativos y cero.

**Ejercicio 12.** Calcula la media de `n` notas. Decide qué hacer si `n = 0`.

## Nivel 4 · Funciones

**Ejercicio 13.** Diseña `esPar(numero)`.

**Ejercicio 14.** Diseña `calcularDescuento(precio, porcentaje)`.

**Ejercicio 15.** Divide un conversor de temperatura en funciones.

**Ejercicio 16.** Diseña una función que devuelva el mayor de dos valores y úsala para obtener el mayor de tres.

## Reto 1 · Cajero sencillo

El usuario dispone de un saldo inicial y solicita retirar una cantidad.

Reglas:

```text
- La cantidad debe ser positiva.
- No puede superar el saldo.
- Si es válida, se descuenta.
- Debe mostrarse el saldo final.
```

Diseña entradas, condiciones, salidas y casos de prueba.

## Reto 2 · Estadísticas de notas

Lee una cantidad de notas y calcula:

```text
media
aprobados
suspensos
nota más alta
nota más baja
```

Piensa cuidadosamente cómo inicializar máximo y mínimo.

## Reto 3 · Adivinanza controlada

Supón que el algoritmo conoce un número secreto fijo. El usuario introduce intentos hasta acertar. Después de cada intento se indica si el secreto es mayor o menor.

Además, cuenta cuántos intentos fueron necesarios.

## Autoevaluación

Antes de pasar al proyecto final deberías poder responder afirmativamente:

- ¿Sé separar entrada, proceso y salida?
- ¿Sé elegir entre secuencia, condición y bucle?
- ¿Sé usar contadores y acumuladores?
- ¿Puedo trazar un algoritmo paso a paso?
- ¿Puedo convertir un diagrama en pseudocódigo?
- ¿Sé dividir una solución en funciones?

Si alguna respuesta es no, vuelve a la lección correspondiente y resuelve uno o dos ejercicios adicionales.

## Qué debes recordar

La habilidad algorítmica mejora resolviendo problemas, no solo leyendo soluciones. Intenta justificar cada decisión y conserva tus casos de prueba: serán útiles cuando conviertas estos algoritmos en código.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion17/">← Lección 17 · Del algoritmo al código</a>
  <a href="/algoritmia/leccion19/">Lección 19 · Proyecto final de algoritmia →</a>
</div>
