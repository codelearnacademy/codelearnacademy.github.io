---
layout: lesson
route: algoritmia
lesson_id: leccion02
lesson_number: "02"
title: Resolución de problemas
description: Aprende a analizar un problema, identificar sus datos y construir una solución paso a paso.
permalink: /algoritmia/leccion02/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: comprender-el-problema
    title: "Comprender el problema"
  - id: entrada-proceso-y-salida
    title: "Entrada, proceso y salida"
  - id: dividir-el-problema
    title: "Dividir el problema"
  - id: diseñar-la-solución
    title: "Diseñar la solución"
  - id: comprobar-la-solución
    title: "Comprobar la solución"
  - id: ejemplo-completo-calcular-una-media
    title: "Ejemplo completo: calcular una media"
  - id: estrategia-de-resolución
    title: "Estrategia de resolución"
  - id: errores-frecuentes
    title: "Errores frecuentes"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Resolución de problemas

Programar consiste, en gran medida, en **resolver problemas**. Antes de escribir código debemos comprender qué nos están pidiendo, qué información tenemos disponible y qué operaciones necesitamos realizar para llegar a una solución.

## Qué vas a conseguir

- Analizar un problema antes de intentar resolverlo.
- Identificar datos de entrada y resultados de salida.
- Distinguir información necesaria de información irrelevante.
- Dividir un problema grande en problemas más pequeños.
- Diseñar una solución mediante pasos ordenados.
- Comprobar manualmente si una solución funciona.

<div class="cla-note"><strong>Ruta de estudio</strong><p>No intentes escribir código todavía. Trabajaremos con problemas, datos, operaciones y soluciones. Separar la lógica de la sintaxis facilitará el aprendizaje posterior de cualquier lenguaje.</p></div>

## Punto de partida

En la lección anterior vimos qué es un algoritmo. Ahora aprenderemos a construirlo a partir de un enunciado.

```text
Problema → Comprender → Identificar datos → Diseñar → Comprobar → Algoritmo
```

## Comprender el problema

Considera este enunciado:

> Una tienda quiere calcular el precio total de una compra sabiendo el precio de una unidad y la cantidad adquirida.

Antes de calcular nada, responde:

- ¿Qué queremos obtener? El precio total.
- ¿Qué datos tenemos? Precio por unidad y cantidad.
- ¿Qué relación existe entre ellos? Se multiplican.

```text
precioTotal = precioUnidad × cantidad
```

<div class="cla-note"><strong>Consejo</strong><p>Si un problema parece difícil, intenta explicarlo primero con tus propias palabras. Si no puedes explicarlo con claridad, todavía no estás preparado para programarlo.</p></div>

## Entrada, proceso y salida

Para el ejemplo anterior:

```text
ENTRADA
precioUnidad = 12
cantidad = 4
        ↓
PROCESO
precioTotal = 12 × 4
        ↓
SALIDA
48
```

Este esquema ayuda a separar lo que conocemos, lo que hacemos y lo que obtenemos.

## Dividir el problema

Supón que debemos calcular el precio final después de aplicar un descuento.

```text
precio = 100
descuento = 20
```

Podemos dividirlo:

```text
cantidadDescuento = precio × descuento / 100
precioFinal = precio - cantidadDescuento
```

Con los valores del ejemplo:

```text
cantidadDescuento = 20
precioFinal = 80
```

> **Principio de descomposición:** un problema grande suele resultar más sencillo cuando se divide en problemas pequeños.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion02/descomposicion-problema.svg
Mostrar un problema general dividido en dos operaciones más pequeñas. -->

## Diseñar la solución

Para calcular la distancia recorrida conociendo velocidad y tiempo:

```text
distancia = velocidad × tiempo
```

Podemos escribir:

```text
1. Obtener la velocidad.
2. Obtener el tiempo.
3. Multiplicar velocidad por tiempo.
4. Guardar el resultado como distancia.
5. Mostrar la distancia.
```

Las instrucciones deben ser concretas y aparecer en el orden correcto.

## Comprobar la solución

Diseñar un algoritmo no garantiza que sea correcto. Debemos probarlo con datos concretos.

```text
base = 5
altura = 3
area = base × altura
area = 15
```

También conviene probar valores distintos:

| Entrada | Operación | Resultado esperado |
|---|---|---:|
| 5 y 3 | 5 × 3 | 15 |
| 0 y 7 | 0 × 7 | 0 |
| 2.5 y 4 | 2.5 × 4 | 10 |

## Ejemplo completo: calcular una media

Enunciado: calcular la media de tres notas.

```text
Entrada:
nota1, nota2, nota3

Proceso:
suma = nota1 + nota2 + nota3
media = suma / 3

Salida:
media
```

Con `6`, `7` y `8`:

```text
suma = 21
media = 7
```

## Estrategia de resolución

Utiliza este procedimiento cada vez que aparezca un nuevo problema:

```text
1. Leer y comprender.
2. Identificar qué debe producirse.
3. Identificar qué datos son necesarios.
4. Encontrar las operaciones que relacionan los datos.
5. Dividir el problema si contiene varias tareas.
6. Ordenar los pasos.
7. Probar con datos concretos.
```

<!-- IMAGEN RECOMENDADA: /assets/images/algoritmia/leccion02/metodo-resolucion.svg -->

## Errores frecuentes

Evita empezar a programar demasiado pronto, utilizar datos que no aportan nada, saltarte operaciones intermedias o confiar en una solución sin probarla.

Una instrucción como `hacer los cálculos necesarios` no es suficientemente precisa. Debemos indicar cuáles son esos cálculos.

## Ejercicios

**Ejercicio 1.** Calcula el área de un rectángulo. Prueba con base `8` y altura `5`.

**Ejercicio 2.** Convierte minutos en segundos. Prueba con `3` minutos.

**Ejercicio 3.** Calcula el salario semanal conociendo horas trabajadas y precio por hora.

**Ejercicio 4.** Convierte grados Celsius a Fahrenheit usando `fahrenheit = celsius × 9 / 5 + 32`.

**Reto.** Calcula el coste de combustible de un viaje conociendo kilómetros, consumo cada 100 km y precio por litro. Divide el problema en al menos dos operaciones.

## Qué debes recordar

Antes de programar, responde: **qué quiero obtener, qué datos necesito, qué operaciones debo realizar, en qué orden y cómo comprobaré el resultado**. Esa disciplina evita muchos errores posteriores.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion01/">← Lección 01 · Introducción a la algoritmia</a>
  <a href="/algoritmia/leccion03/">Lección 03 · Representación de algoritmos →</a>
</div>
