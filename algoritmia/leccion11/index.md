---
layout: lesson
route: algoritmia
lesson_id: leccion11
lesson_number: "11"
title: Estructuras repetitivas
description: Aprende a repetir instrucciones de forma controlada mediante bucles.
permalink: /algoritmia/leccion11/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: patrón-de-un-bucle
    title: "Patrón de un bucle"
  - id: repetición-mientras-se-cumpla-una-condición
    title: "Repetición mientras se cumpla una condición"
  - id: por-qué-termina
    title: "Por qué termina"
  - id: repetición-por-contador
    title: "Repetición por contador"
  - id: repetición-hasta-que-ocurra-algo
    title: "Repetición hasta que ocurra algo"
  - id: ejemplo-tabla-de-multiplicar
    title: "Ejemplo: tabla de multiplicar"
  - id: error-de-uno
    title: "Error de uno"
  - id: ejemplo-cuenta-atrás
    title: "Ejemplo: cuenta atrás"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Estructuras repetitivas

Una estructura repetitiva permite ejecutar un conjunto de instrucciones varias veces. Los bucles evitan escribir manualmente la misma operación y permiten procesar cantidades de datos que no conocemos de antemano.

## Qué vas a conseguir

- Comprender por qué necesitamos bucles.
- Identificar inicialización, condición y actualización.
- Diferenciar repetición controlada por condición y por contador.
- Detectar bucles infinitos.
- Construir algoritmos repetitivos sencillos.

## Punto de partida

Mostrar los números del 1 al 5 podría escribirse así:

```text
Mostrar 1
Mostrar 2
Mostrar 3
Mostrar 4
Mostrar 5
```

Pero si quisiéramos llegar hasta 1000, esta estrategia dejaría de ser razonable.

## Patrón de un bucle

Un bucle suele necesitar tres piezas:

```text
Inicialización
      ↓
¿Condición?
  Sí → Cuerpo → Actualización ─┐
  No                          │
   ↓                           │
  Fin ←────────────────────────┘
```

<!-- IMAGEN MUY RECOMENDADA: /assets/images/algoritmia/leccion11/anatomia-bucle.svg -->

## Repetición mientras se cumpla una condición

```text
contador = 1
MIENTRAS contador <= 5 HACER
    Mostrar contador
    contador = contador + 1
FIN MIENTRAS
```

Resultado:

```text
1 2 3 4 5
```

## Por qué termina

En cada vuelta aumentamos `contador`. Llegará un momento en que `contador <= 5` será falso.

Si olvidamos:

```text
contador = contador + 1
```

la condición seguirá siendo verdadera para siempre y tendremos un **bucle infinito**.

## Repetición por contador

Cuando conocemos de antemano cuántas veces queremos repetir algo, podemos expresar:

```text
PARA i DESDE 1 HASTA 10 HACER
    Mostrar i
FIN PARA
```

Conceptualmente sigue existiendo un contador, aunque la estructura gestione su actualización.

## Repetición hasta que ocurra algo

En algunos problemas queremos ejecutar al menos una vez y comprobar después:

```text
REPETIR
    Leer valor
HASTA QUE valor >= 0
```

Aquí la lectura se realiza antes de comprobar la condición de salida.

## Ejemplo: tabla de multiplicar

```text
Leer numero
contador = 1
MIENTRAS contador <= 10 HACER
    resultado = numero * contador
    Mostrar numero, "x", contador, "=", resultado
    contador = contador + 1
FIN MIENTRAS
```

Para `numero = 3` producirá desde `3 × 1` hasta `3 × 10`.

## Error de uno

Si escribimos:

```text
contador < 10
```

en lugar de:

```text
contador <= 10
```

la última iteración no se ejecutará. Estos errores se conocen habitualmente como errores de límite u **off-by-one**.

## Ejemplo: cuenta atrás

```text
contador = 5
MIENTRAS contador >= 1 HACER
    Mostrar contador
    contador = contador - 1
FIN MIENTRAS
Mostrar "¡Despegue!"
```

## Ejercicios

**Ejercicio 1.** Muestra los números del 1 al 20.

**Ejercicio 2.** Muestra solo los números pares del 2 al 20.

**Ejercicio 3.** Genera la tabla de multiplicar de un número recibido como entrada.

**Ejercicio 4.** Diseña una cuenta atrás desde un valor introducido por el usuario.

**Reto.** Pide números hasta que el usuario introduzca `0`. De momento céntrate en controlar correctamente la condición de finalización.

## Qué debes recordar

Todo bucle necesita una condición de continuación o finalización bien diseñada. Comprueba qué valor tiene la variable de control antes de empezar, cómo cambia y cuándo hará falsa la condición.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion10/">← Lección 10 · Condicionales múltiples</a>
  <a href="/algoritmia/leccion12/">Lección 12 · Contadores y acumuladores →</a>
</div>
