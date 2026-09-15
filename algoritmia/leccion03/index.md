---
layout: lesson
route: algoritmia
lesson_id: leccion03
lesson_number: "03"
title: Representación de algoritmos
description: Conoce distintas formas de representar una solución antes de convertirla en código.
permalink: /algoritmia/leccion03/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: lenguaje-natural
    title: "Lenguaje natural"
  - id: representación-estructurada
    title: "Representación estructurada"
  - id: diagrama-de-flujo
    title: "Diagrama de flujo"
  - id: pseudocódigo
    title: "Pseudocódigo"
  - id: comparar-representaciones
    title: "Comparar representaciones"
  - id: el-mismo-problema-de-cuatro-formas
    title: "El mismo problema de cuatro formas"
  - id: cómo-elegir-una-representación
    title: "Cómo elegir una representación"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Representación de algoritmos

Un algoritmo puede describirse de varias formas. En esta lección compararás lenguaje natural, representaciones estructuradas, diagramas de flujo y pseudocódigo para elegir la forma más útil en cada momento.

## Qué vas a conseguir

- Comprender que una misma solución puede representarse de distintas maneras.
- Utilizar lenguaje natural con suficiente precisión.
- Reconocer las ventajas de los diagramas de flujo y del pseudocódigo.
- Transformar un problema sencillo entre distintas representaciones.
- Elegir una representación adecuada según el objetivo.

## Punto de partida

En las dos primeras lecciones hemos escrito algoritmos como listas de pasos. Esa es una representación válida, pero no es la única.

Partiremos del mismo problema durante toda la lección:

> Calcular el área de un rectángulo a partir de su base y su altura.

## Lenguaje natural

La representación más sencilla utiliza frases normales:

```text
1. Pedir la base.
2. Pedir la altura.
3. Multiplicar la base por la altura.
4. Mostrar el resultado.
```

Es fácil de leer, pero puede volverse ambiguo cuando el algoritmo contiene muchas decisiones o repeticiones.

## Representación estructurada

Podemos hacer el algoritmo más regular utilizando acciones breves:

```text
INICIO
Obtener base
Obtener altura
Calcular area = base × altura
Mostrar area
FIN
```

Esta forma ya se parece a la lógica que usaremos posteriormente en pseudocódigo.

## Diagrama de flujo

Un **diagrama de flujo** representa gráficamente el recorrido del algoritmo mediante símbolos conectados por flechas.

```text
Inicio
  ↓
Leer base y altura
  ↓
area = base × altura
  ↓
Mostrar area
  ↓
Fin
```

El diagrama permite observar de un vistazo el orden y, cuando aparezcan decisiones, las diferentes ramas posibles.

<!-- IMAGEN RECOMENDADA: /assets/images/algoritmia/leccion03/representacion-diagrama-flujo.svg
Dibujar el ejemplo del área con símbolos reales de diagrama de flujo. -->

## Pseudocódigo

El **pseudocódigo** utiliza una notación textual estructurada, independiente de un lenguaje concreto.

```text
INICIO
    LEER base
    LEER altura
    area ← base * altura
    ESCRIBIR area
FIN
```

No pretende compilarse. Su función es expresar la lógica con claridad.

## Comparar representaciones

| Representación | Ventaja principal | Cuándo resulta útil |
|---|---|---|
| Lenguaje natural | Muy accesible | Primer análisis del problema |
| Lista estructurada | Orden claro | Algoritmos sencillos |
| Diagrama de flujo | Visualiza recorridos y decisiones | Aprendizaje y diseño visual |
| Pseudocódigo | Se acerca a la programación | Paso previo al código |

Ninguna representación es siempre mejor que las demás. Cada una ayuda a observar el algoritmo desde una perspectiva diferente.

## El mismo problema de cuatro formas

Problema: convertir horas en minutos.

**Lenguaje natural:** multiplicar las horas por 60.

**Lista de pasos:**

```text
1. Obtener horas.
2. Multiplicar horas por 60.
3. Mostrar minutos.
```

**Esquema visual:**

```text
Inicio → Leer horas → minutos = horas × 60 → Mostrar minutos → Fin
```

**Pseudocódigo:**

```text
INICIO
    LEER horas
    minutos ← horas * 60
    ESCRIBIR minutos
FIN
```

El contenido lógico es el mismo. Solo cambia la manera de expresarlo.

## Cómo elegir una representación

Si todavía estás comprendiendo el problema, empieza con palabras sencillas. Si necesitas observar decisiones y caminos, utiliza un diagrama de flujo. Si quieres preparar la futura implementación, el pseudocódigo suele resultar especialmente práctico.

<div class="cla-note"><strong>No memorices formatos por separado</strong><p>Intenta reconocer siempre la misma lógica detrás de todas las representaciones. El objetivo no es dibujar por dibujar, sino comprender la solución.</p></div>

## Ejemplo guiado

Queremos calcular el precio total de una compra.

```text
Entrada: precioUnidad, cantidad
Proceso: total = precioUnidad × cantidad
Salida: total
```

Lista de pasos:

```text
1. Obtener precioUnidad.
2. Obtener cantidad.
3. Calcular total.
4. Mostrar total.
```

Pseudocódigo inicial:

```text
INICIO
    LEER precioUnidad
    LEER cantidad
    total ← precioUnidad * cantidad
    ESCRIBIR total
FIN
```

## Ejercicios

**Ejercicio 1.** Representa el cálculo del perímetro de un cuadrado mediante lenguaje natural y pseudocódigo.

**Ejercicio 2.** Convierte este algoritmo a una lista ordenada: `Inicio → leer kilómetros → multiplicar por 1000 → mostrar metros → fin`.

**Ejercicio 3.** Explica qué representación utilizarías para enseñar un algoritmo con varias decisiones y por qué.

**Reto.** Elige un problema de la lección anterior y exprésalo de tres formas distintas. Comprueba que todas describen exactamente la misma solución.

## Qué debes recordar

Un algoritmo es independiente de su representación. Podemos expresarlo mediante palabras, diagramas o pseudocódigo. En las próximas lecciones profundizaremos primero en los **diagramas de flujo** y más adelante en el **pseudocódigo**.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion02/">← Lección 02 · Resolución de problemas</a>
  <a href="/algoritmia/leccion04/">Lección 04 · Introducción a los diagramas de flujo →</a>
</div>
