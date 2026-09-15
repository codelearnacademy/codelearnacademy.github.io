---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 08-metodos-y-parametros
lesson_number: "08"
title: Métodos y parámetros
description: Organiza la lógica en bloques reutilizables y bien definidos.
---

# Métodos y parámetros

Un método encapsula una tarea concreta. Permite reutilizar código y mantener el programa más legible.

## Sintaxis básica

```java
public class MetodosDemo {
    public static void saludar() {
        System.out.println("Hola desde un método");
    }

    public static void main(String[] args) {
        saludar();
    }
}
```

## Método con parámetros

```java
public class Calculadora {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int resultado = sumar(5, 3);
        System.out.println(resultado);
    }
}
```

## Método con retorno

```java
public static double calcularMedia(double a, double b) {
    return (a + b) / 2;
}
```

## Buenas prácticas

- Los métodos deben hacer una sola cosa.
- El nombre debe describir la acción.
- Si un método devuelve un valor, debe hacerlo con `return`.
- No mezcles lógica de cálculo con salida por consola si puedes evitarlo.

## Ejemplo de reutilización

```java
public class Area {
    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static void main(String[] args) {
        double area = areaCirculo(3.0);
        System.out.println("Área: " + area);
    }
}
```

## Ejercicio

Escribe un método `multiplicar(int a, int b)` y muestra el resultado en `main`.

## Práctica guiada del concepto

1. Crea un método que sume dos números.
2. Crea otro que imprima un saludo.
3. Cambia el orden de los parámetros y observa el error al compilar.

### Código que genera error

```java
public class ErrorMetodo {
    public static void sumar(int a, int b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        sumar(2); // falta el segundo parámetro
    }
}
```

Falta un argumento. La corrección es llamar al método con ambos valores: `sumar(2, 3)`.

## Después de esta lección

Tras dominar la modularización, llega el momento de consolidar todo con resumen y práctica final.

