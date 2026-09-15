---
layout: lesson
route: algoritmia
lesson_id: leccion10
lesson_number: "10"
title: Condicionales múltiples
description: Resuelve problemas con varias alternativas y aprende a ordenar correctamente las condiciones.
permalink: /algoritmia/leccion10/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: cadena-de-alternativas
    title: "Cadena de alternativas"
  - id: condiciones-por-rangos
    title: "Condiciones por rangos"
  - id: evitar-huecos
    title: "Evitar huecos"
  - id: evitar-solapamientos
    title: "Evitar solapamientos"
  - id: selección-por-valor
    title: "Selección por valor"
  - id: ejemplo-tarifa-por-edad
    title: "Ejemplo: tarifa por edad"
  - id: decisiones-anidadas
    title: "Decisiones anidadas"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Condicionales múltiples

Muchos problemas no se resuelven con solo dos alternativas. Una nota puede ser insuficiente, suficiente, notable o sobresaliente; una tarifa puede depender de varios rangos. Para estos casos utilizamos decisiones múltiples.

## Qué vas a conseguir

- Construir cadenas de condiciones alternativas.
- Ordenar correctamente condiciones por rangos.
- Evitar solapamientos y huecos.
- Comprender cuándo conviene anidar decisiones.
- Diseñar una selección entre varios casos.

## Punto de partida

Queremos clasificar una nota:

```text
0–4.99  → Insuficiente
5–6.99  → Aprobado
7–8.99  → Notable
9–10    → Sobresaliente
```

Necesitamos más de dos caminos.

## Cadena de alternativas

Una forma estructurada es:

```text
SI nota < 5 ENTONCES
    Mostrar "Insuficiente"
SINO SI nota < 7 ENTONCES
    Mostrar "Aprobado"
SINO SI nota < 9 ENTONCES
    Mostrar "Notable"
SINO
    Mostrar "Sobresaliente"
FIN SI
```

El orden importa. Cuando llegamos a `nota < 7`, ya sabemos que la nota no era menor que 5.

## Condiciones por rangos

También podríamos escribir explícitamente:

```text
nota >= 5 Y nota < 7
```

Es más largo, pero a veces resulta más fácil de leer. Elige una estrategia consistente.

## Evitar huecos

Un error típico sería:

```text
nota < 5
nota > 5 Y nota < 7
```

¿Qué ocurre exactamente con `5`? No entra en ningún caso.

Los valores frontera deben pertenecer a alguna rama.

## Evitar solapamientos

Otro error:

```text
edad >= 12
edad >= 18
```

Una persona de 20 años cumple ambas. Si las condiciones forman una cadena, la primera podría capturar casos que queríamos tratar después.

Por eso, cuando utilizamos límites descendentes, puede ser mejor comenzar por el mayor:

```text
SI edad >= 65 ...
SINO SI edad >= 18 ...
SINO SI edad >= 12 ...
SINO ...
```

## Selección por valor

Cuando comparamos una misma variable con valores concretos, podemos pensar en una selección por casos:

```text
SEGÚN opcion
    1: Mostrar "Alta"
    2: Mostrar "Consulta"
    3: Mostrar "Salir"
    OTRO: Mostrar "Opción no válida"
FIN SEGÚN
```

Más adelante cada lenguaje tendrá su propia sintaxis para expresar esta idea.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion10/clasificacion-nota.svg
Diagrama con varias ramas de clasificación. -->

## Ejemplo: tarifa por edad

```text
SI edad < 5 ENTONCES
    precio = 0
SINO SI edad < 18 ENTONCES
    precio = 5
SINO SI edad < 65 ENTONCES
    precio = 10
SINO
    precio = 6
FIN SI
```

Prueba con edades `4`, `5`, `17`, `18`, `64` y `65`.

## Decisiones anidadas

Una decisión puede contener otra:

```text
SI usuarioCorrecto ENTONCES
    SI claveCorrecta ENTONCES
        Mostrar "Acceso"
    SINO
        Mostrar "Clave incorrecta"
    FIN SI
SINO
    Mostrar "Usuario inexistente"
FIN SI
```

Úsalas cuando una segunda pregunta solo tenga sentido después de la primera.

## Ejercicios

**Ejercicio 1.** Clasifica una temperatura como bajo cero, templada o alta usando límites que tú definas.

**Ejercicio 2.** Clasifica una nota de 0 a 10 en cuatro niveles y prueba todos los valores frontera.

**Ejercicio 3.** Diseña un menú con opciones `1`, `2`, `3` y un mensaje para cualquier otro valor.

**Reto.** Calcula el coste de envío: gratis a partir de 50 €, 3 € entre 25 y 49.99 €, y 6 € por debajo de 25 €.

## Qué debes recordar

En una decisión múltiple, el orden de las condiciones puede cambiar el resultado. Revisa siempre los límites para evitar huecos y solapamientos. Probar justo en los valores frontera es una excelente forma de detectar errores.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion09/">← Lección 09 · Estructuras condicionales</a>
  <a href="/algoritmia/leccion11/">Lección 11 · Estructuras repetitivas →</a>
</div>
