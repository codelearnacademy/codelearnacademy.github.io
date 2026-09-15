---
layout: lesson
route: algoritmia
lesson_id: leccion14
lesson_number: "14"
title: Pseudocódigo
description: Expresa algoritmos con una notación estructurada independiente de un lenguaje de programación.
permalink: /algoritmia/leccion14/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: entrada-y-salida
    title: "Entrada y salida"
  - id: asignación
    title: "Asignación"
  - id: condiciones
    title: "Condiciones"
  - id: repeticiones
    title: "Repeticiones"
  - id: ejemplo-completo-media-de-tres-números
    title: "Ejemplo completo: media de tres números"
  - id: del-diagrama-al-pseudocódigo
    title: "Del diagrama al pseudocódigo"
  - id: convenciones-de-estilo
    title: "Convenciones de estilo"
  - id: ejemplo-con-bucle-y-condición
    title: "Ejemplo con bucle y condición"
  - id: qué-no-debe-contener
    title: "Qué no debe contener"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Pseudocódigo

El pseudocódigo permite escribir algoritmos de forma textual y estructurada sin depender de la sintaxis de un lenguaje concreto. Es el puente natural entre el razonamiento y el código.

## Qué vas a conseguir

- Escribir algoritmos con una notación coherente.
- Utilizar instrucciones de entrada, salida, asignación, decisión y repetición.
- Mantener indentación y nombres claros.
- Traducir un diagrama de flujo a pseudocódigo.
- Preparar algoritmos para su futura implementación.

## Punto de partida

No existe un único estándar universal de pseudocódigo. En esta ruta utilizaremos una notación sencilla y consistente.

```text
INICIO
    instrucciones
FIN
```

## Entrada y salida

```text
LEER nombre
ESCRIBIR "Hola", nombre
```

`LEER` representa una entrada y `ESCRIBIR` una salida.

## Asignación

Utilizaremos `←` para indicar que una variable recibe un valor:

```text
area ← base * altura
contador ← contador + 1
```

La flecha ayuda a distinguir asignación de comparación.

## Condiciones

```text
SI edad >= 18 ENTONCES
    ESCRIBIR "Mayor de edad"
SINO
    ESCRIBIR "Menor de edad"
FIN SI
```

La indentación muestra visualmente qué instrucciones pertenecen a cada rama.

## Repeticiones

```text
contador ← 1
MIENTRAS contador <= 5 HACER
    ESCRIBIR contador
    contador ← contador + 1
FIN MIENTRAS
```

También podemos expresar una repetición contada:

```text
PARA i DESDE 1 HASTA 10 HACER
    ESCRIBIR i
FIN PARA
```

## Ejemplo completo: media de tres números

```text
INICIO
    LEER n1
    LEER n2
    LEER n3
    suma ← n1 + n2 + n3
    media ← suma / 3
    ESCRIBIR media
FIN
```

El algoritmo es prácticamente una descripción directa de la solución.

## Del diagrama al pseudocódigo

Diagrama conceptual:

```text
Inicio → Leer número → ¿número >= 0? → Mostrar mensaje → Fin
```

Pseudocódigo:

```text
INICIO
    LEER numero
    SI numero >= 0 ENTONCES
        ESCRIBIR "No negativo"
    SINO
        ESCRIBIR "Negativo"
    FIN SI
FIN
```

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion14/diagrama-a-pseudocodigo.svg
Mostrar a la izquierda el diagrama y a la derecha su pseudocódigo. -->

## Convenciones de estilo

Utiliza un nombre por concepto, evita cambiar entre `precio`, `p` y `importe` para representar la misma cosa, indenta bloques internos y mantén una palabra clave consistente para cada estructura.

El pseudocódigo debe poder leerse como una explicación técnica de la solución.

## Ejemplo con bucle y condición

Contar aprobados entre cinco notas:

```text
INICIO
    aprobados ← 0

    PARA i DESDE 1 HASTA 5 HACER
        LEER nota
        SI nota >= 5 ENTONCES
            aprobados ← aprobados + 1
        FIN SI
    FIN PARA

    ESCRIBIR aprobados
FIN
```

Aquí combinamos entrada, bucle, condición, contador y salida.

## Qué no debe contener

Evita detalles específicos innecesarios de un lenguaje, como tipos concretos, llaves o llamadas a bibliotecas, salvo que formen parte del objetivo de la explicación.

```text
Pseudocódigo: LEER edad
Java: edad = scanner.nextInt();
```

El primero describe la intención; el segundo es una implementación concreta.

## Ejercicios

**Ejercicio 1.** Escribe en pseudocódigo el área de un rectángulo.

**Ejercicio 2.** Escribe un algoritmo que indique si un número es par.

**Ejercicio 3.** Escribe un bucle que muestre los múltiplos de 3 entre 3 y 30.

**Ejercicio 4.** Escribe el pseudocódigo para calcular media y número de aprobados de cinco notas.

**Reto.** Elige un diagrama de flujo creado en lecciones anteriores y conviértelo a pseudocódigo sin cambiar su comportamiento.

## Qué debes recordar

El pseudocódigo expresa la lógica sin obligarnos a pensar todavía en la sintaxis de un lenguaje. Debe ser claro, estructurado, coherente y suficientemente preciso como para servir de guía durante la implementación.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion13/">← Lección 13 · Trazado de algoritmos</a>
  <a href="/algoritmia/leccion15/">Lección 15 · Subalgoritmos y funciones →</a>
</div>
