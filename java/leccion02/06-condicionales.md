---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 06-condicionales
lesson_number: "06"
title: Condicionales
description: Toma decisiones dentro del programa según condiciones booleanas.
---

# Condicionales

Los condicionales permiten ejecutar un bloque u otro según una condición.

## if

```java
int edad = 18;

if (edad >= 18) {
    System.out.println("Eres mayor de edad");
}
```

## if-else

```java
int nota = 7;

if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```

## else if

```java
int nota = 8;

if (nota >= 9) {
    System.out.println("Sobresaliente");
} else if (nota >= 7) {
    System.out.println("Notable");
} else if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```

## switch

```java
int opcion = 2;

switch (opcion) {
    case 1:
        System.out.println("Uno");
        break;
    case 2:
        System.out.println("Dos");
        break;
    default:
        System.out.println("Opción no válida");
}
```

## Condiciones complejas

```java
int edad = 20;
boolean carnet = true;

if (edad >= 18 && carnet) {
    System.out.println("Puede conducir");
}
```

## Ejemplo práctico

```java
public class CondicionalesDemo {
    public static void main(String[] args) {
        int temperatura = 30;

        if (temperatura > 25) {
            System.out.println("Hace calor");
        } else {
            System.out.println("Hace frío");
        }
    }
}
```

<div class="cla-note"><strong>Importante</strong><p>Las condiciones deben devolver un valor booleano. Si no, no se pueden evaluar como `true` o `false`.</p></div>

## Ejercicio

Pide una edad por consola y muestra si la persona es menor de edad, mayor de edad o adulta.

## Práctica guiada del concepto

1. Escribe una condición con `if` para decidir si un número es positivo.
2. Añade un `else if` para diferenciar varios rangos.
3. Prueba uno de los errores típicos: comparar un valor con `=` en lugar de `==`.

### Código que genera error

```java
public class ErrorCondicional {
    public static void main(String[] args) {
        int edad = 18;
        if (edad = 18) {
            System.out.println("Tiene 18 años");
        }
    }
}
```

La condición debe ser `edad == 18`, no `edad = 18`. La primera asigna, la segunda compara.

## Después de esta lección

Después de entender decisiones, el siguiente paso es automatizar repeticiones con bucles.

