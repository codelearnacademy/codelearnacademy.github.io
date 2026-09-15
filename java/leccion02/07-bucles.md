---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 07-bucles
lesson_number: "07"
title: Bucles
description: Repite acciones automáticamente con for, while y do while.
---

# Bucles

Los bucles permiten repetir instrucciones varias veces sin escribir el mismo código manualmente.

## for

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Iteración: " + i);
}
```

## while

```java
int contador = 0;

while (contador < 5) {
    System.out.println("contador = " + contador);
    contador++;
}
```

## do while

```java
int numero = 0;

do {
    System.out.println(numero);
    numero++;
} while (numero < 3);
```

## break y continue

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        continue; // salta la iteración actual
    }
    if (i == 8) {
        break; // sale del bucle
    }
    System.out.println(i);
}
```

## Ejemplo práctico

```java
public class BuclesDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Tabla del 2: " + i * 2);
        }
    }
}
```

## Cuándo usar cada uno

- `for`: cuando sabes cuántas veces quieres repetir.
- `while`: cuando la condición depende de algo que cambia durante la ejecución.
- `do while`: cuando al menos una ejecución debe ocurrir antes de comprobar la condición.

<div class="cla-note"><strong>Regla</strong><p>Todos los bucles necesitan una condición que eventualmente deje de cumplirse; de lo contrario se convierte en un bucle infinito.</p></div>

## Ejercicio

Escribe un programa que imprima los números del 1 al 10 y luego la suma de todos ellos.

## Práctica guiada del concepto

1. Haz un bucle `for` para imprimir del 1 al 10.
2. Haz el mismo ejercicio con `while`.
3. Intenta crear un bucle infinito y observa qué ocurre. ¿Qué condición debes usar para evitarlo?

### Código que genera error

```java
public class ErrorBucle {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            // i++ falta aquí
        }
    }
}
```

Este bucle no termina porque la variable `i` nunca cambia. La corrección es incrementar `i` dentro del bloque.

## Después de esta lección

Cuando ya sabes repetir tareas, el siguiente paso es encapsular lógica en métodos.

