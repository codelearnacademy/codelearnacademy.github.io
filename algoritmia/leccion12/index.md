---
layout: lesson
route: algoritmia
lesson_id: leccion12
lesson_number: "12"
title: Contadores y acumuladores
description: Utiliza patrones de conteo y acumulación para procesar conjuntos de datos.
permalink: /algoritmia/leccion12/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: contadores
    title: "Contadores"
  - id: acumuladores
    title: "Acumuladores"
  - id: calcular-una-media
    title: "Calcular una media"
  - id: contador-condicionado
    title: "Contador condicionado"
  - id: combinar-varios-patrones
    title: "Combinar varios patrones"
  - id: inicialización-correcta
    title: "Inicialización correcta"
  - id: ejemplo-completo
    title: "Ejemplo completo"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Contadores y acumuladores

Cuando repetimos operaciones aparecen dos patrones fundamentales: **contar** cuántas veces ocurre algo y **acumular** valores para obtener un total.

## Qué vas a conseguir

- Diferenciar contador y acumulador.
- Inicializar correctamente ambos patrones.
- Calcular sumas y medias durante un bucle.
- Contar elementos que cumplen una condición.
- Combinar bucles, condiciones y variables de estado.

## Punto de partida

Un contador suele aumentar una cantidad fija:

```text
contador = contador + 1
```

Un acumulador incorpora un valor que puede cambiar:

```text
suma = suma + numero
```

## Contadores

Si queremos saber cuántos números positivos se han introducido:

```text
positivos = 0

REPETIR para cada numero
    SI numero > 0 ENTONCES
        positivos = positivos + 1
    FIN SI
FIN REPETIR
```

La variable no guarda los números; guarda **cuántos** cumplían la condición.

## Acumuladores

Para sumar varias notas:

```text
suma = 0
PARA i DESDE 1 HASTA 4 HACER
    Leer nota
    suma = suma + nota
FIN PARA
Mostrar suma
```

Si las notas son `5`, `7`, `8` y `6`, el acumulador evoluciona:

| Iteración | Nota | Suma antes | Suma después |
|---:|---:|---:|---:|
| 1 | 5 | 0 | 5 |
| 2 | 7 | 5 | 12 |
| 3 | 8 | 12 | 20 |
| 4 | 6 | 20 | 26 |

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion12/contador-acumulador.svg
Contrastar contador +1 frente a acumulador +valor. -->

## Calcular una media

Para una cantidad conocida de valores:

```text
suma = 0
PARA i DESDE 1 HASTA cantidad HACER
    Leer valor
    suma = suma + valor
FIN PARA
media = suma / cantidad
```

Necesitamos el total y el número de elementos.

## Contador condicionado

Podemos contar aprobados:

```text
aprobados = 0
PARA i DESDE 1 HASTA cantidad HACER
    Leer nota
    SI nota >= 5 ENTONCES
        aprobados = aprobados + 1
    FIN SI
FIN PARA
```

Aquí la condición decide cuándo cambia el contador.

## Combinar varios patrones

Para un grupo de estudiantes podemos mantener:

```text
sumaNotas = 0
aprobados = 0
suspensos = 0
```

En cada iteración acumulamos la nota y actualizamos uno de los dos contadores.

Al final podemos calcular la media del grupo y mostrar las cantidades.

## Inicialización correcta

Contadores y sumas suelen comenzar en cero. Si empezamos una suma en `10`, todos los resultados estarán desplazados.

Otros patrones, como buscar un máximo, pueden necesitar una inicialización diferente; los estudiaremos mediante trazas y ejercicios.

## Ejemplo completo

Procesar cinco ventas y obtener total vendido y número de ventas superiores a 100 €:

```text
total = 0
ventasGrandes = 0

PARA i DESDE 1 HASTA 5 HACER
    Leer importe
    total = total + importe
    SI importe > 100 ENTONCES
        ventasGrandes = ventasGrandes + 1
    FIN SI
FIN PARA

Mostrar total
Mostrar ventasGrandes
```

## Ejercicios

**Ejercicio 1.** Suma los números del 1 al 100.

**Ejercicio 2.** Cuenta cuántos de diez números son negativos.

**Ejercicio 3.** Calcula la media de cinco temperaturas.

**Ejercicio 4.** Procesa seis notas y muestra cuántas están aprobadas y cuántas suspendidas.

**Reto.** Lee importes hasta recibir `0`; muestra el total y el número de importes procesados. Piensa qué ocurre si el primer valor ya es `0`.

## Qué debes recordar

Un contador responde "¿cuántos?" y un acumulador responde "¿cuánto en total?". Ambos dependen de una inicialización correcta y se vuelven especialmente potentes cuando se combinan con condiciones dentro de un bucle.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion11/">← Lección 11 · Estructuras repetitivas</a>
  <a href="/algoritmia/leccion13/">Lección 13 · Trazado de algoritmos →</a>
</div>
