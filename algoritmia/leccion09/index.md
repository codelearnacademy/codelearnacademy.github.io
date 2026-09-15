---
layout: lesson
route: algoritmia
lesson_id: leccion09
lesson_number: "09"
title: Estructuras condicionales
description: Aprende a tomar decisiones en un algoritmo mediante condiciones y alternativas.
permalink: /algoritmia/leccion09/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: operadores-de-comparación
    title: "Operadores de comparación"
  - id: condición-simple
    title: "Condición simple"
  - id: condición-con-alternativa
    title: "Condición con alternativa"
  - id: ejemplo-número-par
    title: "Ejemplo: número par"
  - id: condiciones-compuestas
    title: "Condiciones compuestas"
  - id: cuidado-con-los-límites
    title: "Cuidado con los límites"
  - id: ejemplo-completo-descuento-por-importe
    title: "Ejemplo completo: descuento por importe"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Estructuras condicionales

Hasta ahora los algoritmos seguían siempre el mismo camino. Las estructuras condicionales permiten elegir qué instrucciones ejecutar según se cumpla o no una condición.

## Qué vas a conseguir

- Comprender qué es una condición.
- Utilizar comparaciones para obtener verdadero o falso.
- Construir decisiones simples y alternativas.
- Representar condiciones mediante diagramas de flujo.
- Combinar condiciones sencillas con operadores lógicos.

## Punto de partida

Considera este problema:

> Mostrar si una persona es mayor de edad.

No podemos mostrar siempre el mismo mensaje. Debemos evaluar:

```text
edad >= 18
```

La expresión será verdadera o falsa.

## Operadores de comparación

| Comparación | Significado |
|---|---|
| `a = b` | iguales |
| `a ≠ b` | distintos |
| `a > b` | mayor que |
| `a < b` | menor que |
| `a >= b` | mayor o igual |
| `a <= b` | menor o igual |

El resultado de una comparación es lógico: verdadero o falso.

## Condición simple

Si solo necesitamos actuar cuando se cumple una condición:

```text
SI temperatura < 0 ENTONCES
    Mostrar "Riesgo de hielo"
FIN SI
```

Si la condición es falsa, el algoritmo continúa sin ejecutar ese bloque.

## Condición con alternativa

Para la mayoría de edad:

```text
SI edad >= 18 ENTONCES
    Mostrar "Mayor de edad"
SINO
    Mostrar "Menor de edad"
FIN SI
```

Solo se ejecuta una de las dos ramas.

<!-- IMAGEN MUY RECOMENDADA: /assets/images/algoritmia/leccion09/condicional-mayoria-edad.svg
Rombo edad >= 18 con ramas Sí/No. -->

## Ejemplo: número par

El resto de dividir un número entre dos permite comprobar si es par:

```text
SI numero MOD 2 = 0 ENTONCES
    Mostrar "Par"
SINO
    Mostrar "Impar"
FIN SI
```

Para `8`, el resto es `0`. Para `7`, el resto es `1`.

## Condiciones compuestas

A veces necesitamos combinar comparaciones.

```text
edad >= 18 Y tieneEntrada = verdadero
```

Los operadores habituales son:

- `Y`: deben cumplirse ambas condiciones.
- `O`: basta con que se cumpla al menos una.
- `NO`: invierte el valor lógico.

Ejemplo:

```text
SI edad >= 18 Y saldo >= precio ENTONCES
    Mostrar "Compra posible"
FIN SI
```

## Cuidado con los límites

`edad > 18` y `edad >= 18` no significan lo mismo. Si la norma dice "18 años o más", debemos usar `>=`.

Los valores frontera son especialmente importantes durante las pruebas.

## Ejemplo completo: descuento por importe

Regla: si la compra alcanza 100 €, aplicar un 10 % de descuento.

```text
SI total >= 100 ENTONCES
    descuento = total * 10 / 100
    total = total - descuento
FIN SI
Mostrar total
```

Prueba con `99`, `100` y `150` para verificar el límite.

## Ejercicios

**Ejercicio 1.** Indica si un número es positivo o no positivo.

**Ejercicio 2.** Muestra el mayor de dos números.

**Ejercicio 3.** Comprueba si una temperatura está por debajo de cero.

**Ejercicio 4.** Permite el acceso si la persona tiene 18 años o más **y** dispone de entrada.

**Reto.** Diseña un algoritmo que indique si un año es divisible entre 4. De momento ignora las excepciones del calendario gregoriano; céntrate en construir la condición.

## Qué debes recordar

Una condición produce verdadero o falso y permite seleccionar un camino. Los valores límite deben tratarse con especial cuidado. En la siguiente lección ampliaremos esta idea para problemas con **más de dos alternativas**.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion08/">← Lección 08 · Entrada y salida de datos</a>
  <a href="/algoritmia/leccion10/">Lección 10 · Condicionales múltiples →</a>
</div>
