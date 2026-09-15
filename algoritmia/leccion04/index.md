---
layout: lesson
route: algoritmia
lesson_id: leccion04
lesson_number: "04"
title: Introducción a los diagramas de flujo
description: Aprende a leer y construir diagramas de flujo para representar algoritmos visualmente.
permalink: /algoritmia/leccion04/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: qué-es-un-diagrama-de-flujo
    title: "Qué es un diagrama de flujo"
  - id: cómo-se-lee
    title: "Cómo se lee"
  - id: primer-ejemplo
    title: "Primer ejemplo"
  - id: del-algoritmo-al-diagrama
    title: "Del algoritmo al diagrama"
  - id: por-qué-son-útiles
    title: "Por qué son útiles"
  - id: un-diagrama-no-es-código
    title: "Un diagrama no es código"
  - id: ejemplo-media-de-tres-números
    title: "Ejemplo: media de tres números"
  - id: cómo-revisar-un-diagrama
    title: "Cómo revisar un diagrama"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Introducción a los diagramas de flujo

Los diagramas de flujo permiten representar un algoritmo de forma visual. En lugar de leer únicamente una lista de instrucciones, podemos seguir el recorrido de la solución mediante símbolos y flechas.

## Qué vas a conseguir

- Explicar qué representa un diagrama de flujo.
- Leer el recorrido de un diagrama sencillo.
- Reconocer inicio, proceso, entrada/salida y fin.
- Construir un primer diagrama secuencial.
- Relacionar un diagrama con el algoritmo que representa.

## Punto de partida

Ya sabemos que un algoritmo puede representarse de varias maneras. Los diagramas de flujo son especialmente útiles cuando queremos **ver** el orden de ejecución.

```text
Inicio
  ↓
Entrada
  ↓
Proceso
  ↓
Salida
  ↓
Fin
```

## Qué es un diagrama de flujo

Un **diagrama de flujo** es una representación gráfica de un algoritmo. Cada tipo de acción utiliza una forma determinada y las flechas indican la dirección de ejecución.

No representa el aspecto visual de un programa. Representa su **lógica**.

<!-- IMAGEN MUY RECOMENDADA: /assets/images/algoritmia/leccion04/anatomia-diagrama-flujo.svg
Diagrama vertical simple con Inicio, Entrada, Proceso, Salida y Fin usando símbolos reales. -->

## Cómo se lee

Normalmente comenzamos en el símbolo de inicio y seguimos las flechas.

```text
[Inicio]
   ↓
[Leer base y altura]
   ↓
[Calcular área]
   ↓
[Mostrar área]
   ↓
[Fin]
```

En algoritmos sencillos solo existe un camino. Más adelante aparecerán decisiones que dividirán el recorrido.

## Primer ejemplo

Problema: convertir kilómetros en metros.

```text
Entrada: kilometros
Proceso: metros = kilometros × 1000
Salida: metros
```

Diagrama conceptual:

```text
Inicio
  ↓
Leer kilometros
  ↓
metros = kilometros × 1000
  ↓
Mostrar metros
  ↓
Fin
```

Con `2.5` kilómetros, el resultado esperado es `2500` metros.

## Del algoritmo al diagrama

Para convertir una lista de pasos en diagrama:

1. Identifica dónde empieza y termina.
2. Marca qué pasos reciben o muestran información.
3. Marca qué pasos realizan operaciones.
4. Ordena los símbolos.
5. Conéctalos con flechas.

Por ejemplo:

```text
1. Obtener precio.
2. Obtener cantidad.
3. Calcular total.
4. Mostrar total.
```

se transforma en:

```text
Inicio → Leer precio y cantidad → total = precio × cantidad → Mostrar total → Fin
```

## Por qué son útiles

Un diagrama ayuda a detectar instrucciones fuera de orden, pasos que faltan y recorridos que no llegan al final. También facilita explicar una solución a otra persona antes de escribir código.

<div class="cla-note"><strong>Importante</strong><p>El diagrama no sustituye al razonamiento. Si la solución está mal pensada, dibujarla con símbolos correctos seguirá produciendo un algoritmo incorrecto.</p></div>

## Un diagrama no es código

En un diagrama puedes escribir `calcular media` o `media = suma / 3`. Todavía no necesitas saber cómo se escribe esa operación en Java.

La finalidad es conservar la lógica independiente del lenguaje.

## Ejemplo: media de tres números

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

Prueba con `5`, `7` y `9`: suma `21`, media `7`.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion04/media-tres-numeros.svg -->

## Cómo revisar un diagrama

Haz estas preguntas:

- ¿Existe un inicio claro?
- ¿Todas las flechas tienen un destino?
- ¿Las operaciones están en el orden correcto?
- ¿Se muestra el resultado necesario?
- ¿Existe un final?

## Ejercicios

**Ejercicio 1.** Dibuja un diagrama para calcular el doble de un número.

**Ejercicio 2.** Dibuja un diagrama para convertir minutos en segundos.

**Ejercicio 3.** Dibuja un diagrama para calcular el área de un círculo utilizando `area = π × radio²`.

**Reto.** Dibuja el algoritmo de un descuento visto en la lección 02. Todavía no necesitas utilizar decisiones; el porcentaje de descuento se recibe como entrada.

## Qué debes recordar

Los diagramas de flujo representan visualmente la lógica de un algoritmo. Las flechas indican el orden y los símbolos indican el tipo de acción. En la siguiente lección aprenderemos los símbolos concretos y las reglas para utilizarlos correctamente.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion03/">← Lección 03 · Representación de algoritmos</a>
  <a href="/algoritmia/leccion05/">Lección 05 · Símbolos y reglas de los diagramas de flujo →</a>
</div>
