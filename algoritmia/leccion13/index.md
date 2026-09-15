---
layout: lesson
route: algoritmia
lesson_id: leccion13
lesson_number: "13"
title: Trazado de algoritmos
description: Comprueba algoritmos paso a paso mediante tablas de seguimiento y ejecución manual.
permalink: /algoritmia/leccion13/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: tabla-de-traza
    title: "Tabla de traza"
  - id: trazar-una-condición
    title: "Trazar una condición"
  - id: trazar-un-bucle
    title: "Trazar un bucle"
  - id: elegir-buenos-casos-de-prueba
    title: "Elegir buenos casos de prueba"
  - id: detectar-un-error-con-una-traza
    title: "Detectar un error con una traza"
  - id: traza-y-depuración
    title: "Traza y depuración"
  - id: ejemplo-contar-pares
    title: "Ejemplo: contar pares"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Trazado de algoritmos

Una traza consiste en ejecutar un algoritmo manualmente y registrar cómo cambian sus variables. Es una de las mejores técnicas para comprender la lógica y detectar errores antes de programar.

## Qué vas a conseguir

- Ejecutar un algoritmo paso a paso.
- Construir tablas de seguimiento.
- Observar cómo cambian las variables.
- Comprobar condiciones y bucles.
- Detectar errores mediante casos concretos.

## Punto de partida

Considera:

```text
x = 3
y = x + 2
x = y * 2
```

Si solo miramos el resultado final podemos perdernos. Una traza muestra cada estado.

## Tabla de traza

| Paso | Instrucción | x | y |
|---:|---|---:|---:|
| 1 | `x = 3` | 3 | — |
| 2 | `y = x + 2` | 3 | 5 |
| 3 | `x = y * 2` | 10 | 5 |

La tabla obliga a respetar el orden real de ejecución.

## Trazar una condición

Algoritmo:

```text
Leer edad
SI edad >= 18 ENTONCES
    mensaje = "Mayor"
SINO
    mensaje = "Menor"
FIN SI
```

Con `edad = 17`:

| Paso | edad | Condición `edad >= 18` | mensaje |
|---:|---:|---|---|
| 1 | 17 | — | — |
| 2 | 17 | Falso | — |
| 3 | 17 | — | Menor |

Solo debemos trazar la rama que realmente se ejecuta.

## Trazar un bucle

```text
contador = 1
suma = 0
MIENTRAS contador <= 3 HACER
    suma = suma + contador
    contador = contador + 1
FIN MIENTRAS
```

| Iteración | contador antes | suma antes | suma después | contador después |
|---:|---:|---:|---:|---:|
| 1 | 1 | 0 | 1 | 2 |
| 2 | 2 | 1 | 3 | 3 |
| 3 | 3 | 3 | 6 | 4 |

Cuando `contador` vale `4`, la condición es falsa y el bucle termina.

## Elegir buenos casos de prueba

No pruebes siempre valores cómodos. Incluye:

- valores normales;
- cero cuando tenga sentido;
- valores negativos si son posibles;
- límites exactos;
- valores justo por debajo y por encima del límite.

Para `edad >= 18`, prueba `17`, `18` y `19`.

## Detectar un error con una traza

Supongamos:

```text
contador = 1
MIENTRAS contador <= 5 HACER
    Mostrar contador
FIN MIENTRAS
```

La traza revela que `contador` nunca cambia. La condición seguirá siendo verdadera y el algoritmo no terminará.

## Traza y depuración

La traza manual es una forma de **depuración**. Cuando más adelante utilices un depurador en Java, observarás ideas similares: valor de variables, instrucción actual y recorrido ejecutado.

<div class="cla-note"><strong>Hábito recomendable</strong><p>Cuando un algoritmo no produzca el resultado esperado, no lo leas una y otra vez. Elige un caso pequeño y ejecútalo paso a paso.</p></div>

## Ejemplo: contar pares

```text
pares = 0
PARA numero DESDE 1 HASTA 5 HACER
    SI numero MOD 2 = 0 ENTONCES
        pares = pares + 1
    FIN SI
FIN PARA
```

Resultado final: `pares = 2` porque los valores pares son `2` y `4`.

## Ejercicios

**Ejercicio 1.** Traza `a = 2; b = a * 3; a = b - 1`.

**Ejercicio 2.** Realiza una traza del algoritmo que clasifica una nota usando `4.9`, `5`, `6.9`, `7` y `9`.

**Ejercicio 3.** Traza un bucle que muestre números del 1 al 4.

**Reto.** Traza el algoritmo de media de cinco notas e incluye suma, contador y media final.

## Qué debes recordar

Una traza convierte la ejecución en datos observables. Permite comprobar qué instrucción se ejecuta, qué valor tiene cada variable y por qué una condición toma un camino determinado. Utilízala siempre que dudes de un algoritmo.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion12/">← Lección 12 · Contadores y acumuladores</a>
  <a href="/algoritmia/leccion14/">Lección 14 · Pseudocódigo →</a>
</div>
