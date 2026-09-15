---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 10-practica-final
lesson_number: "10"
title: Práctica final guiada
description: Proyecto integrador guiado de una hora para consolidar variables, condicionales, bucles y métodos.
---

# Práctica final guiada

Esta práctica tiene una duración estimada de 60 minutos. Está diseñada para apliques todo lo aprendido en la lección: variables, operadores, entrada/salida, condicionales, bucles y métodos.

## Objetivo

Crea una pequeña aplicación que gestione la nota final de varios alumnos y calcule si han aprobado o suspendido.

## Enunciado

Desarrolla una aplicación en Java que:

1. Pida el nombre del alumno.
2. Pida tres notas.
3. Calcule la media.
4. Muestre si el alumno aprueba o suspende.
5. Repite el proceso para varios alumnos hasta que el usuario decida salir.
6. Al final muestre cuántos alumnos han aprobado y cuántos han suspendido.

## Requisitos de la práctica

- Debes usar `Scanner` para leer datos.
- Usa variables para almacenar nombre y notas.
- Aplica `if` para decidir si aprueba o suspende.
- Usa un `for` o `while` para repetir el proceso.
- Divide la lógica en métodos, por ejemplo:
  - `leerNota()`
  - `calcularMedia()`
  - `evaluarAlumno(double media)`
  - `mostrarResultado()`

## Estructura sugerida

- Crea el fichero PracticaNotas.java

```java
import java.util.Scanner;

public class PracticaNotas {
    

    public static void main(String[] args) {

    }
}
```

## Alternativas de práctica

### Alternativa A: versión mínima

- Solo pide un alumno.
- No hace bucle.
- Requiere media y aprobación.
- Nota estimada si funciona todo: 5.

### Alternativa B: versión guiada completa

- Repite para varios alumnos.
- Cuenta aprobados y suspendidos.
- Muestra resumen final.
- Nota estimada si funciona todo: 8.

### Alternativa C: versión ampliada

- Añade nota de comportamiento.
- Calcula media ponderada.
- Permite registrar 10 alumnos.
- Nota estimada si funciona todo: 9.

## Guía de trabajo por bloques

### Bloque 1: planteamiento

Responde estas preguntas:

- ¿Qué datos necesito guardar?
- ¿Qué datos se leen desde consola?
- ¿Qué cálculo es necesario?
- ¿Qué información se muestra al usuario?

### Bloque 2: código base

Implementa:

- `main`
- `Scanner`
- lectura de nombre y notas
- cálculo de media

### Bloque 3: decisiones y resultados

Implementa:

- `if` para evaluar aprobación
- mensaje con resultado
- contador de aprobados y suspendidos

### Bloque 4: repetición

Añade:

- bucle para varios alumnos
- pregunta final de continuidad

### Bloque 5: mejora

Añade una mejora opcional:

- mostrar el mejor alumno,
- validar notas entre 0 y 10,
- mostrar el número total de alumnos procesados,
- formatear el resultado con una salida clara.

## Preguntas de reflexión

- ¿Qué parte del programa se repite y puede convertirse en método?
- ¿Qué ocurre si introduces una nota fuera de rango?
- ¿Qué cambiarías para que el programa fuera más legible?
- ¿Cuál es la diferencia entre `if` y `while`?

## Criterio de evaluación

Se considera que la práctica está completada si:

- puede leer datos desde consola,
- calcula la media correctamente,
- usa condicionales para decidir el resultado,
- repite la lógica con un bucle,
- organiza las tareas en métodos,
- y entrega una salida clara y comprensible.

## Práctica guiada del concepto

1. Haz una versión mínima del programa para un único alumno.
2. Añade una segunda vuelta para más alumnos.
3. Introduce un valor erróneo en la nota y observa el resultado incorrecto.
4. Corrige el dato y verifica que el programa responde de forma correcta.

### Código que genera error

```java
if (media >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```

Este ejemplo puede no fallar, pero si la nota se introduce como texto o fuera de rango, el resultado no será correcto. La corrección pasa por validación y por controlar el tipo de dato.

<div class="cla-note"><strong>Objetivo final</strong><p>Como alumno no solo debes “hacer que funcione”, sino explicar por qué cada bloque del código existe y qué responsabilidad tiene cada método, además de mostrar en el informe su correcto funcionamiento con varios casos</p></div>

## Después de esta lección

Esta lección termina con la consolidación de fundamentos. La siguiente etapa es la programación orientada a objetos, donde se aprenden clases, atributos, encapsulación y relaciones entre objetos.
