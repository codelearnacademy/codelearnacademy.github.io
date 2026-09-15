---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: Estructuras de control
search_title: Lección 03 - Estructuras de control
search_description: Practicarás estructuras condicionales y repetitivas para controlar el flujo de ejecución.
description: Controlarás el flujo de ejecución y depurarás programas Java.
lessons:
  - id: condiciones
    title: Condiciones
  - id: bucles
    title: Bucles
  - id: excepciones-y-depuracion
    title: Excepciones y depuración
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion03/
---

## Condiciones

Las estructuras `if`, `else` y `switch` permiten seleccionar un camino según el estado del programa.

```java
int nota = 7;
String resultado = nota >= 5 ? "Aprobado" : "Pendiente";
System.out.println(resultado);

String día = "sábado";
switch (día) {
  case "sábado", "domingo" -> System.out.println("Descanso");
  default -> System.out.println("Clase");
}
```

## Bucles

Usa `for` cuando conoces el recorrido, `while` cuando depende de una condición y `do-while` cuando debe ejecutarse al menos una vez.

```java
int suma = 0;
for (int número = 1; número <= 5; número++) {
  suma += número;
}
System.out.println(suma);

int intentos = 0;
while (intentos < 3) {
  System.out.println("Intento " + (++intentos));
}
```

`break` termina el bucle y `continue` salta a la siguiente iteración. Úsalos con una condición evidente para no ocultar el flujo.

## Excepciones y depuración

Las excepciones representan situaciones que interrumpen el flujo normal. Captura el problema donde puedas actuar y conserva información útil.

```java
try {
  int valor = Integer.parseInt("abc");
  System.out.println(valor);
} catch (NumberFormatException error) {
  System.out.println("El valor no es un entero");
}
```

Durante la depuración, reproduce el fallo, coloca un punto de ruptura, inspecciona variables y confirma la corrección con una nueva prueba. Una aserción documenta una condición que debería cumplirse durante el desarrollo:

```java
assert saldo >= 0 : "El saldo no puede ser negativo";
```

## Ejercicios

1. Clasifica un número como positivo, negativo o cero.
2. Calcula la suma y la media de los números introducidos.
3. Imprime una tabla de multiplicar usando un bucle.
4. Solicita números hasta recibir cero y controla entradas no numéricas.
5. Implementa factorial iterativo y recursivo.
6. Introduce un error de índice, depúralo y documenta la causa.
