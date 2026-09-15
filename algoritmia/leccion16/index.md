---
layout: lesson
route: algoritmia
lesson_id: leccion16
lesson_number: "16"
title: Errores frecuentes en algoritmos
description: Identifica fallos lógicos habituales y aprende a localizar su causa antes de programar.
permalink: /algoritmia/leccion16/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: error-de-requisitos
    title: "Error de requisitos"
  - id: condición-incorrecta
    title: "Condición incorrecta"
  - id: casos-no-contemplados
    title: "Casos no contemplados"
  - id: bucle-infinito
    title: "Bucle infinito"
  - id: error-de-inicialización
    title: "Error de inicialización"
  - id: error-de-límite
    title: "Error de límite"
  - id: dividir-entre-cero
    title: "Dividir entre cero"
  - id: nombres-confusos
    title: "Nombres confusos"
  - id: estrategia-de-depuración
    title: "Estrategia de depuración"
  - id: ejemplo-de-depuración
    title: "Ejemplo de depuración"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Errores frecuentes en algoritmos

Los errores son una parte normal del desarrollo. Aprender a reconocer patrones de fallo permite corregirlos antes de que lleguen al código.

## Qué vas a conseguir

- Diferenciar errores de comprensión y errores lógicos.
- Detectar condiciones incorrectas y casos no contemplados.
- Reconocer bucles infinitos y errores de límite.
- Identificar variables mal inicializadas.
- Aplicar una estrategia básica de depuración.

## Punto de partida

Un algoritmo puede estar perfectamente escrito y aun así resolver el problema equivocado. Por eso debemos comprobar tanto la **interpretación del enunciado** como la **lógica de la solución**.

## Error de requisitos

Enunciado: calcular el precio con un 20 % de descuento.

Algoritmo incorrecto:

```text
precioFinal = precio * 20 / 100
```

Eso calcula el importe del descuento, no el precio final.

La solución requiere:

```text
descuento = precio * 20 / 100
precioFinal = precio - descuento
```

## Condición incorrecta

Si la mayoría de edad comienza a los 18:

```text
edad > 18
```

excluye incorrectamente a quien tiene exactamente 18. Debe ser:

```text
edad >= 18
```

Los límites son una fuente frecuente de errores.

## Casos no contemplados

Clasificar un número como positivo o negativo deja sin respuesta el valor `0` si el problema requiere distinguirlo.

```text
SI numero > 0 ...
SINO SI numero < 0 ...
SINO ...  ← cero
```

## Bucle infinito

```text
contador = 1
MIENTRAS contador <= 10 HACER
    Mostrar contador
FIN MIENTRAS
```

Falta modificar `contador`. La condición nunca cambia.

## Error de inicialización

Para sumar valores:

```text
suma = 10
```

introduce un valor que no pertenece a los datos. Normalmente deberíamos comenzar en `0`.

## Error de límite

```text
PARA i DESDE 1 HASTA 9
```

no procesa diez elementos si esperábamos posiciones del 1 al 10. Siempre comprueba cuántas iteraciones produce realmente el rango.

## Dividir entre cero

Si calculamos una media:

```text
media = suma / cantidad
```

 debemos pensar qué ocurre cuando `cantidad = 0`. Aunque todavía estemos diseñando el algoritmo, esta situación debe estar contemplada.

## Nombres confusos

```text
x = a * b
```

puede ser correcto, pero dificulta detectar errores. Nombres como `total = precio * cantidad` hacen visible la intención.

## Estrategia de depuración

Cuando algo falla:

```text
1. Define un caso de prueba pequeño.
2. Anota el resultado esperado.
3. Realiza una traza paso a paso.
4. Localiza el primer punto donde el valor real deja de coincidir.
5. Corrige una causa cada vez.
6. Repite las pruebas.
```

<div class="cla-note"><strong>Regla útil</strong><p>Busca el primer estado incorrecto, no solo el resultado final incorrecto. La causa suele encontrarse cerca de ese punto.</p></div>

## Ejemplo de depuración

Queremos sumar del 1 al 3:

```text
suma = 0
contador = 1
MIENTRAS contador < 3 HACER
    suma = suma + contador
    contador = contador + 1
FIN MIENTRAS
```

La traza produce `1 + 2 = 3`, pero esperábamos `6`. El error está en `< 3`; para incluir el 3 necesitamos `<= 3`.

## Ejercicios

**Ejercicio 1.** Corrige una condición que pretende aceptar edades de 18 o más pero utiliza `edad > 18`.

**Ejercicio 2.** Encuentra por qué un bucle con `contador = contador - 1` nunca termina si la condición es `contador <= 10` y comienza en 1.

**Ejercicio 3.** Diseña casos de prueba para un descuento aplicado a partir de 100 €.

**Reto.** Crea deliberadamente tres errores diferentes en un algoritmo de media, intercámbialo con otra persona y tratad de localizarlos mediante trazas.

## Qué debes recordar

Los errores se detectan mejor con casos concretos, valores frontera y trazas. No confíes únicamente en que un algoritmo "parece correcto". Debe producir los resultados esperados en situaciones normales y especiales.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion15/">← Lección 15 · Subalgoritmos y funciones</a>
  <a href="/algoritmia/leccion17/">Lección 17 · Del algoritmo al código →</a>
</div>
