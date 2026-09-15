---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 04-operadores-y-expresiones
lesson_number: "04"
title: Operadores y expresiones
description: Aprende a combinar valores con operadores aritméticos, relacionales y lógicos.
---

# Operadores y expresiones

Las expresiones permiten combinar variables, literales y operadores para calcular o comparar valores.

## Operadores aritméticos

```java
int a = 10;
int b = 3;

System.out.println(a + b); // 13
System.out.println(a - b); // 7
System.out.println(a * b); // 30
System.out.println(a / b); // 3
System.out.println(a % b); // 1
```

## Operadores de asignación

```java
int total = 5;
total += 3;   // total = total + 3
System.out.println(total); // 8
```

## Operadores relacionales

```java
int x = 5;
int y = 7;

System.out.println(x < y);   // true
System.out.println(x == y);  // false
System.out.println(x != y);  // true
```

## Operadores lógicos

```java
boolean aprobado = true;
boolean asistencia = false;

System.out.println(aprobado && asistencia); // false
System.out.println(aprobado || asistencia); // true
System.out.println(!aprobado);             // false
```

## Operador de concatenación

```java
String nombre = "Ana";
int edad = 22;

System.out.println("Nombre: " + nombre + ", edad: " + edad);
```

## Ejemplo práctico

```java
public class OperadoresDemo {
    public static void main(String[] args) {
        int a = 8;
        int b = 3;

        int suma = a + b;
        boolean mayor = a > b;

        System.out.println("Suma: " + suma);
        System.out.println("¿a es mayor que b? " + mayor);
    }
}
```

## Importante

- `==` compara valores.
- `=` asigna valores.
- `&&` exige que ambas condiciones sean verdaderas.
- `||` acepta que al menos una sea verdadera.

<div class="cla-note"><strong>Truco</strong><p>Si una comparación devuelve `true` o `false`, estás usando un valor booleano. Ese tipo es esencial para decidir rutas dentro del programa.</p></div>

## Ejercicio

Calcula el promedio de tres notas y comprueba si el alumno supera 5.0.

## Práctica guiada del concepto

1. Calcula la suma y la diferencia de dos valores.
2. Comprueba el resultado de `==` y `=` en un ejemplo corto.
3. Crea una expresión con `&&` y otra con `||` para ver cómo cambia el resultado.

### Código que genera error

```java
public class ErrorOperadores {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        if (a = b) {
            System.out.println("Iguales");
        }
    }
}
```

Esto falla porque `=` asigna valores, no compara. La comparación correcta sería `a == b`.

## Después de esta lección

Ahora ya puedes combinar datos y compararlos. El siguiente paso es interactuar con el usuario mediante entrada y salida.

