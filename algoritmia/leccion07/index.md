---
layout: lesson
route: algoritmia
lesson_id: leccion07
lesson_number: "07"
title: Variables, constantes y expresiones
description: Aprende a representar datos, almacenar valores y construir expresiones para realizar cálculos.
permalink: /algoritmia/leccion07/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: qué-es-una-variable
    title: "Qué es una variable"
  - id: elegir-buenos-nombres
    title: "Elegir buenos nombres"
  - id: qué-es-una-constante
    title: "Qué es una constante"
  - id: asignación
    title: "Asignación"
  - id: expresiones-aritméticas
    title: "Expresiones aritméticas"
  - id: precedencia-y-paréntesis
    title: "Precedencia y paréntesis"
  - id: variable-auxiliar-intercambio-de-valores
    title: "Variable auxiliar: intercambio de valores"
  - id: ejemplo-completo
    title: "Ejemplo completo"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Variables, constantes y expresiones

Los algoritmos necesitan trabajar con datos. Para poder referirnos a esos datos utilizamos nombres: variables cuando el valor puede cambiar y constantes cuando representa un valor que queremos mantener fijo.

## Qué vas a conseguir

- Explicar qué representa una variable.
- Diferenciar variable y constante.
- Elegir nombres descriptivos.
- Comprender la asignación de valores.
- Construir expresiones aritméticas sencillas.
- Utilizar variables auxiliares para resolver problemas.

## Punto de partida

En ejemplos anteriores hemos escrito nombres como `precio`, `cantidad`, `subtotal` o `media`. Esos nombres representan datos que el algoritmo necesita conservar.

## Qué es una variable

Una **variable** es un nombre asociado a un valor que puede utilizarse y modificarse durante la ejecución del algoritmo.

```text
edad = 18
edad = 19
```

El nombre sigue siendo `edad`, pero su contenido cambia.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion07/variable-caja.svg
Representar una variable como una caja etiquetada cuyo contenido puede sustituirse. -->

## Elegir buenos nombres

Compara:

```text
x = p * c
```

con:

```text
precioTotal = precioUnidad * cantidad
```

Ambas expresiones pueden producir el mismo resultado, pero la segunda explica por sí sola qué representa cada dato.

Utiliza nombres como `numeroAlumnos`, `temperaturaMedia` o `totalCompra` y evita abreviaturas innecesarias.

## Qué es una constante

Una **constante** representa un valor que conceptualmente no debe cambiar durante el algoritmo.

Ejemplos:

```text
PI = 3.141592
MINUTOS_POR_HORA = 60
IVA_GENERAL = 7
```

Nombrar estos valores evita repetir números cuyo significado no sería evidente.

## Asignación

Cuando escribimos:

```text
total = 10
```

indicamos que la variable `total` recibe el valor `10`.

En pseudocódigo utilizaremos a menudo una flecha para evitar confundir asignación con igualdad matemática:

```text
total ← 10
```

Una operación como:

```text
contador ← contador + 1
```

significa: toma el valor actual de `contador`, súmale uno y guarda el nuevo valor en la misma variable.

## Expresiones aritméticas

Los operadores más habituales son:

| Operación | Símbolo habitual | Ejemplo |
|---|---|---|
| Suma | `+` | `a + b` |
| Resta | `-` | `a - b` |
| Multiplicación | `*` | `a * b` |
| División | `/` | `a / b` |
| Resto | `%` o `MOD` | `a MOD b` |

El resto será útil para problemas como determinar si un número es par.

## Precedencia y paréntesis

```text
resultado = 2 + 3 * 4
```

La multiplicación se evalúa antes: el resultado es `14`.

Si queremos sumar primero:

```text
resultado = (2 + 3) * 4
```

obtenemos `20`.

Utiliza paréntesis cuando ayuden a hacer explícita la intención.

## Variable auxiliar: intercambio de valores

Supongamos:

```text
a = 10
b = 20
```

Queremos intercambiarlos. Utilizamos una variable temporal:

```text
temporal = a
a = b
b = temporal
```

Resultado:

```text
a = 20
b = 10
```

Este ejemplo muestra cómo una variable puede guardar un valor mientras realizamos otras operaciones.

## Ejemplo completo

Calculamos el área y la circunferencia de un círculo:

```text
PI = 3.141592
radio = 5
area = PI * radio * radio
circunferencia = 2 * PI * radio
```

Las dos expresiones utilizan una constante y una variable de entrada.

## Ejercicios

**Ejercicio 1.** Propón nombres mejores para `a`, `b` y `r` en un algoritmo de precio y descuento.

**Ejercicio 2.** Calcula mentalmente `2 + 5 * 3` y `(2 + 5) * 3`.

**Ejercicio 3.** Utiliza una constante `MINUTOS_POR_HORA` para convertir horas en minutos.

**Ejercicio 4.** Diseña el intercambio de tres valores para que `a` pase a `b`, `b` a `c` y `c` a `a`.

**Reto.** Expresa el coste de combustible de un viaje utilizando variables descriptivas y al menos una variable intermedia.

## Qué debes recordar

Las variables permiten conservar y transformar datos. Las constantes dan nombre a valores estables. Las expresiones combinan datos mediante operadores. Elegir nombres claros es una parte importante del diseño del algoritmo, no una cuestión estética.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion06/">← Lección 06 · Algoritmos secuenciales</a>
  <a href="/algoritmia/leccion08/">Lección 08 · Entrada y salida de datos →</a>
</div>
