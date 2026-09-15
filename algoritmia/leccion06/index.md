---
layout: lesson
route: algoritmia
lesson_id: leccion06
lesson_number: "06"
title: Algoritmos secuenciales
description: Construye algoritmos que ejecutan instrucciones ordenadas de principio a fin.
permalink: /algoritmia/leccion06/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: dependencia-entre-operaciones
    title: "Dependencia entre operaciones"
  - id: ejemplo-conversión-de-temperatura
    title: "Ejemplo: conversión de temperatura"
  - id: ejemplo-factura-sencilla
    title: "Ejemplo: factura sencilla"
  - id: variables-intermedias
    title: "Variables intermedias"
  - id: orden-de-las-expresiones
    title: "Orden de las expresiones"
  - id: diagrama-secuencial
    title: "Diagrama secuencial"
  - id: cómo-comprobar-una-secuencia
    title: "Cómo comprobar una secuencia"
  - id: errores-frecuentes
    title: "Errores frecuentes"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Algoritmos secuenciales

Un algoritmo secuencial ejecuta sus instrucciones una detrás de otra, sin tomar decisiones ni repetir bloques. Es la estructura más sencilla y la base sobre la que construiremos las demás.

## Qué vas a conseguir

- Reconocer una estructura secuencial.
- Ordenar operaciones respetando sus dependencias.
- Construir algoritmos con varios cálculos consecutivos.
- Representar secuencias mediante diagramas de flujo.
- Comprobar resultados paso a paso.

## Punto de partida

Hasta ahora muchos ejemplos ya eran secuenciales:

```text
Leer datos → Calcular → Mostrar resultado
```

La característica importante es que **todas las instrucciones se ejecutan exactamente una vez y en el mismo orden**.

## Dependencia entre operaciones

Considera:

```text
subtotal = precio × cantidad
impuesto = subtotal × 0.07
total = subtotal + impuesto
```

No podemos calcular `impuesto` antes de `subtotal`, porque depende de su valor. El orden expresa una dependencia.

## Ejemplo: conversión de temperatura

Queremos convertir Celsius a Fahrenheit:

```text
fahrenheit = celsius × 9 / 5 + 32
```

Para `20` grados:

```text
fahrenheit = 20 × 9 / 5 + 32
fahrenheit = 68
```

Algoritmo:

```text
1. Leer celsius.
2. Calcular fahrenheit.
3. Mostrar fahrenheit.
```

## Ejemplo: factura sencilla

Datos:

```text
precioUnidad = 25
cantidad = 3
iva = 7
```

Proceso:

```text
subtotal = precioUnidad × cantidad
importeIva = subtotal × iva / 100
total = subtotal + importeIva
```

Resultado:

```text
subtotal = 75
importeIva = 5.25
total = 80.25
```

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion06/factura-secuencial.svg
Diagrama con tres procesos consecutivos y la salida final. -->

## Variables intermedias

No siempre es obligatorio guardar cada resultado, pero hacerlo suele mejorar la claridad.

```text
Difícil de leer:
total = precio × cantidad + precio × cantidad × iva / 100

Más claro:
subtotal = precio × cantidad
importeIva = subtotal × iva / 100
total = subtotal + importeIva
```

La segunda versión permite comprobar cada paso por separado.

## Orden de las expresiones

En una expresión matemática se aplican reglas de precedencia. Cuando exista duda, utiliza paréntesis.

```text
media = (n1 + n2 + n3) / 3
```

Sin paréntesis, la operación podría interpretarse de manera diferente.

## Diagrama secuencial

Para calcular una media:

```text
Inicio
  ↓
Leer n1, n2, n3
  ↓
suma = n1 + n2 + n3
  ↓
media = suma / 3
  ↓
Mostrar media
  ↓
Fin
```

No existen ramas. El recorrido es único.

## Cómo comprobar una secuencia

Crea una tabla sencilla:

| Paso | Operación | Resultado |
|---:|---|---:|
| 1 | `subtotal = 25 × 3` | 75 |
| 2 | `importeIva = 75 × 7 / 100` | 5.25 |
| 3 | `total = 75 + 5.25` | 80.25 |

Esta técnica prepara el trabajo posterior con trazas.

## Errores frecuentes

Los errores más comunes son ejecutar operaciones fuera de orden, utilizar una variable antes de calcularla, olvidar paréntesis o mostrar un resultado intermedio cuando se solicitaba el final.

## Ejercicios

**Ejercicio 1.** Convierte metros en centímetros y milímetros.

**Ejercicio 2.** Calcula el área y el perímetro de un rectángulo a partir de base y altura.

**Ejercicio 3.** Calcula el salario bruto conociendo horas trabajadas y precio por hora, y después descuenta un porcentaje fijo.

**Ejercicio 4.** Calcula cuántas horas, minutos y segundos representa una cantidad dada de segundos. De momento puedes suponer que dispones de división entera y resto.

**Reto.** Diseña un algoritmo que calcule el coste total de un viaje usando distancia, consumo cada 100 km y precio por litro.

## Qué debes recordar

En una secuencia, cada instrucción se ejecuta en orden. Los resultados intermedios pueden convertirse en entradas de operaciones posteriores. Diseñar bien ese orden hace que el algoritmo sea más claro y fácil de comprobar.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion05/">← Lección 05 · Símbolos y reglas de los diagramas de flujo</a>
  <a href="/algoritmia/leccion07/">Lección 07 · Variables, constantes y expresiones →</a>
</div>
