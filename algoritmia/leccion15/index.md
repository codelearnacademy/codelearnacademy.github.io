---
layout: lesson
route: algoritmia
lesson_id: leccion15
lesson_number: "15"
title: Subalgoritmos y funciones
description: Divide soluciones complejas en bloques pequeños, reutilizables y fáciles de comprobar.
permalink: /algoritmia/leccion15/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: qué-es-un-subalgoritmo
    title: "Qué es un subalgoritmo"
  - id: parámetros
    title: "Parámetros"
  - id: valor-de-retorno
    title: "Valor de retorno"
  - id: procedimientos
    title: "Procedimientos"
  - id: ejemplo-comprobar-si-un-número-es-par
    title: "Ejemplo: comprobar si un número es par"
  - id: diseñar-funciones-pequeñas
    title: "Diseñar funciones pequeñas"
  - id: ejemplo-completo
    title: "Ejemplo completo"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Subalgoritmos y funciones

A medida que una solución crece, resulta útil dividirla en piezas con una responsabilidad concreta. Los subalgoritmos y funciones permiten reutilizar lógica, reducir complejidad y comprobar cada parte por separado.

## Qué vas a conseguir

- Comprender por qué dividir un algoritmo en funciones.
- Diferenciar parámetros y resultados.
- Diseñar funciones con una responsabilidad clara.
- Reutilizar una misma operación varias veces.
- Componer una solución grande a partir de soluciones pequeñas.

## Punto de partida

Considera un programa que necesita calcular el área de varios rectángulos. Repetir siempre la fórmula funciona, pero podemos encapsularla:

```text
FUNCION calcularArea(base, altura)
    RETORNAR base * altura
FIN FUNCION
```

Después:

```text
area1 ← calcularArea(5, 3)
area2 ← calcularArea(8, 2)
```

## Qué es un subalgoritmo

Un subalgoritmo es una parte de la solución que puede describirse y ejecutarse como una unidad.

Una buena división responde a una pregunta concreta:

```text
calcularMedia
esPar
calcularDescuento
mostrarMenu
```

Evita funciones vagas como `hacerCosas`.

## Parámetros

Los parámetros son los datos que necesita la función.

```text
FUNCION calcularDescuento(precio, porcentaje)
```

En este caso la función no necesita conocer ninguna otra parte del algoritmo para realizar su trabajo.

## Valor de retorno

Una función puede producir un resultado:

```text
FUNCION calcularDescuento(precio, porcentaje)
    descuento ← precio * porcentaje / 100
    RETORNAR descuento
FIN FUNCION
```

Uso:

```text
importe ← calcularDescuento(100, 20)
```

`importe` recibe `20`.

## Procedimientos

Algunos subalgoritmos realizan una acción sin devolver un valor principal:

```text
PROCEDIMIENTO mostrarSeparador()
    ESCRIBIR "----------------"
FIN PROCEDIMIENTO
```

La distinción exacta dependerá del lenguaje, pero conceptualmente es útil separar acciones y cálculos.

## Ejemplo: comprobar si un número es par

```text
FUNCION esPar(numero)
    RETORNAR numero MOD 2 = 0
FIN FUNCION
```

Podemos utilizarla:

```text
SI esPar(8) ENTONCES
    ESCRIBIR "Par"
FIN SI
```

La función oculta el detalle y hace que la intención sea muy clara.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion15/descomposicion-funciones.svg
Problema principal dividido en varias funciones pequeñas conectadas. -->

## Diseñar funciones pequeñas

Una función debería tener una responsabilidad fácil de explicar. Si para describirla necesitas usar muchas veces la palabra "y", quizá realiza demasiadas tareas.

```text
Mejor:
calcularSubtotal
calcularImpuesto
calcularTotal

Peor:
calcularTodoYMostrarYValidar
```

## Ejemplo completo

```text
FUNCION calcularSubtotal(precio, cantidad)
    RETORNAR precio * cantidad
FIN FUNCION

FUNCION calcularImpuesto(subtotal, porcentaje)
    RETORNAR subtotal * porcentaje / 100
FIN FUNCION

INICIO
    LEER precio
    LEER cantidad
    subtotal ← calcularSubtotal(precio, cantidad)
    impuesto ← calcularImpuesto(subtotal, 7)
    total ← subtotal + impuesto
    ESCRIBIR total
FIN
```

Cada pieza puede probarse por separado.

## Ejercicios

**Ejercicio 1.** Diseña una función `calcularCuadrado(numero)`.

**Ejercicio 2.** Diseña `esMayorDeEdad(edad)` que devuelva verdadero o falso.

**Ejercicio 3.** Divide el cálculo del coste de combustible en funciones pequeñas.

**Ejercicio 4.** Crea una función para convertir Celsius a Fahrenheit y úsala con tres temperaturas diferentes.

**Reto.** Revisa un algoritmo largo de lecciones anteriores y divídelo en al menos tres subalgoritmos con nombres significativos.

## Qué debes recordar

Dividir una solución no cambia el problema; cambia cómo organizamos su complejidad. Las funciones permiten razonar, probar y reutilizar partes pequeñas antes de integrarlas en una solución mayor.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion14/">← Lección 14 · Pseudocódigo</a>
  <a href="/algoritmia/leccion16/">Lección 16 · Errores frecuentes en algoritmos →</a>
</div>
