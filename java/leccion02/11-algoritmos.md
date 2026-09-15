---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 11-algoritmos
lesson_number: "10"
title: Algoritmos guiados
description: Practica algoritmos progresivos con Java, desde lo más sencillo hasta problemas de mayor complejidad.
---

# Algoritmos guiados

Esta sección tiene como objetivo que el alumno practique la lógica de programación a partir de las nociones aprendidas: variables, condiciones, bucles y métodos.

## ¿Qué es un algoritmo?

Un algoritmo es una secuencia ordenada de pasos para resolver un problema. En Java, un algoritmo se implementa con variables, decisiones y repeticiones.

## Progresión recomendada

Te propongo trabajar con 20 algoritmos:

### 1. Saludo básico

```java
public class Algoritmo1 {
    public static void main(String[] args) {
        System.out.println("Hola, mundo");
    }
}
```

### 2. Suma de dos números

```java
public class Algoritmo2 {
    public static void main(String[] args) {
        int a = 4; //Yo soy una variable
        int b = 6; //Yo soy otra variable
        System.out.println(a + b);
    }
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo2.java</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 3. Diferencia entre dos números

```java
int a = 10;
int b = 3;
System.out.println(a - b);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo3.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 4. Par o impar

```java
int n = 7;
if (n % 2 == 0) {
    System.out.println("Par");
} else {
    System.out.println("Impar");
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo4.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 5. Mayor de dos números

```java
int a = 8;
int b = 12;
if (a > b) {
    System.out.println("a es mayor");
} else {
    System.out.println("b es mayor");
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo5.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>


### 6. Número positivo, negativo o cero

```java
int n = 0;
if (n > 0) {
    System.out.println("Positivo");
} else if (n < 0) {
    System.out.println("Negativo");
} else {
    System.out.println("Cero");
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo6.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>


<div class="cla-note"><strong>Optimiza:</strong><p>Crea el fichero <strong>Algoritmo6B.java</strong>, construye el  método Main, <strong>optimiza el código</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>



### 7. Tabla de multiplicar del 5

```java
for (int i = 1; i <= 10; i++) {
    System.out.println("5 x " + i + " = " + (5 * i));
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo7.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Optimiza:</strong><p>Crea el fichero <strong>Algoritmo7B.java</strong>, construye el  método Main, <strong>optimiza el código, solicitando el número que deseamos múltiplicar,</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 8. Suma de los 10 primeros números

```java
int suma = 0;
for (int i = 1; i <= 10; i++) {
    suma += i;
}
System.out.println(suma);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo8.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 9. Media de tres notas

```java
double n1 = 7.5;
double n2 = 6.0;
double n3 = 8.5;
System.out.println((n1 + n2 + n3) / 3);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo9.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Optimiza:</strong><p>Crea el fichero <strong>Algoritmo9B.java</strong>, construye el  método Main, <strong>optimiza el código, solicitando los números que deseamos,</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 10. Aprobado o suspenso

```java
double media = 6.8;
if (media >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo10.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Optimiza:</strong><p>Crea el fichero <strong>Algoritmo10B.java</strong>, construye el  método Main, <strong>optimiza el código, solicitando los números que deseamos para calcula la media, realiza la media</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 11. Número perfecto o no

```java
int n = 6;
int suma = 0;
for (int i = 1; i < n; i++) {
    if (n % i == 0) {
        suma += i;
    }
}
System.out.println(suma == n ? "Perfecto" : "No perfecto");
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo11.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 12. Factorial

```java
int n = 5;
int resultado = 1;
for (int i = 1; i <= n; i++) {
    resultado *= i;
}
System.out.println(resultado);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo12.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Optimiza:</strong><p>Crea el fichero <strong>Algoritmo12B.java</strong>, construye el  método Main, <strong>optimiza el código</strong>, solicita el número por teclado, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 13. Números pares del 1 al 20

```java
for (int i = 1; i <= 20; i++) {
    if (i % 2 == 0) {
        System.out.println(i);
    }
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo13.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Optimiza:</strong><p>Crea el fichero <strong>Algoritmo13B.java</strong>, construye el  método Main, <strong>optimiza el código</strong>, solicita el número por teclado, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>


### 14. Cálculo del área de un rectángulo

```java
int base = 4;
int altura = 5;
System.out.println(base * altura);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo14.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Optimiza:</strong><p>Crea el fichero <strong>Algoritmo14B.java</strong>, construye el  método Main, <strong>optimiza el código</strong>, solicita los números por teclado, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 15. Mínimo y máximo de una lista

```java
int[] valores = {3, 7, 1, 10, 5};
int max = valores[0];
int min = valores[0];
for (int v : valores) {
    if (v > max) max = v;
    if (v < min) min = v;
}
System.out.println("Máximo: " + max);
System.out.println("Mínimo: " + min);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo15.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Cambia:</strong><p>Crea el fichero <strong>Algoritmo15B.java</strong>, construye el  método Main, <strong>cambia el bucle a otro que no sea el for</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 16. Conteo de vocales

```java
String texto = "java";
int vocales = 0;
for (int i = 0; i < texto.length(); i++) {
    char c = texto.charAt(i);
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        vocales++;
    }
}
System.out.println(vocales);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo16.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Cambia:</strong><p>Crea el fichero <strong>Algoritmo16B.java</strong>, construye el  método Main, <strong>cambia el bucle a otro que no sea el for</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 17. Serie Fibonacci

```java
int n = 10;
int a = 0;
int b = 1;
for (int i = 0; i < n; i++) {
    System.out.print(a + " ");
    int siguiente = a + b;
    a = b;
    b = siguiente;
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo17.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Cambia:</strong><p>Crea el fichero <strong>Algoritmo17B.java</strong>, construye el  método Main, <strong>cambia el bucle a otro que no sea el for</strong>, solicita los valores por teclado, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 18. Número primo

```java
int n = 13;
boolean primo = true;
for (int i = 2; i < n; i++) {
    if (n % i == 0) {
        primo = false;
        break;
    }
}
System.out.println(primo ? "Es primo" : "No es primo");
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo18.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Cambia:</strong><p>Crea el fichero <strong>Algoritmo18B.java</strong>, construye el  método Main, <strong>cambia el bucle a otro que no sea el for</strong>, solicita los valores por teclado, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>


### 19. Suma de elementos pares

```java
int[] numeros = {1, 2, 3, 4, 5, 6};
int suma = 0;
for (int n : numeros) {
    if (n % 2 == 0) {
        suma += n;
    }
}
System.out.println(suma);
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo19.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Cambia:</strong><p>Crea el fichero <strong>Algoritmo19B.java</strong>, construye el  método Main, <strong>cambia el bucle a otro que no sea el for</strong>, solicita los valores por teclado, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

### 20. Verificación de contraseña simple

```java
String password = "java123";
if (password.length() >= 6) {
    System.out.println("Contraseña válida");
} else {
    System.out.println("Contraseña incorrecta");
}
```

<div class="cla-note"><strong>Realiza:</strong><p>Crea el fichero <strong>Algoritmo20.java</strong>, construye el  método Main, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

<div class="cla-note"><strong>Cambia:</strong><p>Crea el fichero <strong>Algoritmo20B.java</strong>, construye el  método Main, <strong>solicita la palabra por teclado, y el tamaño de verificación de la contraseña</strong>, compila desde la terminal y ejecuta el fichero .class. Describe los pasos que has realizado.</p></div>

## Cómo trabajar esta sección

Como programador debes:

1. leer el problema,
2. Utilizar papel para reflexionar sobre lo que tienes que construir, y plasmarlo. Esto es Pseudocódigo.
3. identificar qué datos necesita,
4. decidir si necesita variables, condicionales o bucles,
5. escribir el algoritmo y probarlo,
6. revisar el resultado y detectar errores.

## Preguntas de reflexión

- ¿Qué problema resuelve cada algoritmo?
- ¿Qué estructura de control conviene en cada caso?
- ¿Qué cambia si usas `for` en vez de `while`?
- ¿Qué ocurre si la condición nunca cambia?

## Práctica e intante los siguientes conceptos

1. Resuelve los algoritmos sin mirar la solución.
2. Intenta reescribir uno con otra estructura de control.
3. Cambia un operador o una condición y observa el resultado.
4. Corrige errores como `=` por `==`, `>` por `<` o bucles sin incremento.

### Código que genera error

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    // falta i++
}
```

El programa queda atrapado en un bucle infinito porque `i` nunca cambia. La corrección es incluir `i++` dentro del bloque.

## Después de esta lección

Con estos algoritmos, tendrás la lógica básica de Java. El siguiente paso es ver clases y objetos en profundidad.

## Continua practicando

Utiliza la web <a href="https://retosdeprogramacion.com/ejercicios/" target="_blank">Retos de Programación</a>, y selecciona cualquiera de los algoritmos. Sigue los pasos para solventarlos.