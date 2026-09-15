---
layout: lesson
route: algoritmia
lesson_id: leccion17
lesson_number: "17"
title: Del algoritmo al código
description: Relaciona algoritmos, pseudocódigo y diagramas de flujo con una primera implementación en Java.
permalink: /algoritmia/leccion17/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: variables
    title: "Variables"
  - id: operaciones
    title: "Operaciones"
  - id: salida
    title: "Salida"
  - id: condiciones
    title: "Condiciones"
  - id: bucles
    title: "Bucles"
  - id: funciones
    title: "Funciones"
  - id: ejemplo-completo-calcular-una-media
    title: "Ejemplo completo: calcular una media"
  - id: la-entrada-real-en-java
    title: "La entrada real en Java"
  - id: qué-debe-permanecer-igual
    title: "Qué debe permanecer igual"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Del algoritmo al código

Hasta ahora hemos trabajado con soluciones independientes de un lenguaje. En esta lección veremos cómo esas mismas ideas aparecen en Java, manteniendo el foco en la correspondencia entre lógica y código.

## Qué vas a conseguir

- Relacionar variables algorítmicas con variables Java.
- Reconocer equivalencias de entrada, salida, condiciones y bucles.
- Convertir pseudocódigo sencillo en Java.
- Mantener separada la lógica del detalle sintáctico.
- Prepararte para continuar en la ruta de Java.

## Punto de partida

Partiremos siempre de esta secuencia:

```text
Problema → Algoritmo → Pseudocódigo → Código
```

No utilizaremos Java para descubrir la solución; lo utilizaremos para **implementar una solución que ya entendemos**.

<!-- IMAGEN RECOMENDADA: /assets/images/algoritmia/leccion17/algoritmo-a-java.svg -->

## Variables

Pseudocódigo:

```text
edad ← 18
```

Una posible implementación Java:

```java
int edad = 18;
```

Java necesita indicar un tipo y finalizar la instrucción con `;`, pero la idea algorítmica es la misma: almacenar un valor con un nombre.

## Operaciones

Pseudocódigo:

```text
total ← precio * cantidad
```

Java:

```java
double total = precio * cantidad;
```

La expresión prácticamente no cambia.

## Salida

Pseudocódigo:

```text
ESCRIBIR total
```

Java:

```java
System.out.println(total);
```

La intención es mostrar un resultado; Java aporta la sintaxis concreta.

## Condiciones

Pseudocódigo:

```text
SI edad >= 18 ENTONCES
    ESCRIBIR "Mayor"
SINO
    ESCRIBIR "Menor"
FIN SI
```

Java:

```java
if (edad >= 18) {
    System.out.println("Mayor");
} else {
    System.out.println("Menor");
}
```

La estructura lógica es equivalente.

## Bucles

Pseudocódigo:

```text
contador ← 1
MIENTRAS contador <= 5 HACER
    ESCRIBIR contador
    contador ← contador + 1
FIN MIENTRAS
```

Java:

```java
int contador = 1;
while (contador <= 5) {
    System.out.println(contador);
    contador++;
}
```

## Funciones

Pseudocódigo:

```text
FUNCION cuadrado(numero)
    RETORNAR numero * numero
FIN FUNCION
```

Java:

```java
static int cuadrado(int numero) {
    return numero * numero;
}
```

De nuevo, cambia la sintaxis, no la idea.

## Ejemplo completo: calcular una media

Pseudocódigo:

```text
INICIO
    n1 ← 5
    n2 ← 7
    n3 ← 9
    suma ← n1 + n2 + n3
    media ← suma / 3
    ESCRIBIR media
FIN
```

Java:

```java
public class Media {
    public static void main(String[] args) {
        double n1 = 5;
        double n2 = 7;
        double n3 = 9;

        double suma = n1 + n2 + n3;
        double media = suma / 3;

        System.out.println(media);
    }
}
```

La salida esperada es `7.0`.

## La entrada real en Java

Leer datos desde teclado requiere una herramienta concreta del lenguaje. Esa parte pertenece ya a la ruta de Java. Aquí basta con reconocer que sustituirá a una instrucción conceptual como `LEER edad`.

<div class="cla-note"><strong>Siguiente ruta recomendada</strong><p>Cuando termines Algoritmia, continúa con <a href="/java/">Java</a>. Allí aprenderás tipos, compilación, entrada de datos, clases y el resto de elementos necesarios para convertir estos algoritmos en programas completos.</p></div>

## Qué debe permanecer igual

Al pasar a código no deberían cambiar:

- el problema que resolvemos;
- las entradas y salidas;
- las condiciones de negocio;
- el orden lógico;
- los casos de prueba esperados.

Si al programar descubres que la lógica no funciona, vuelve al algoritmo y corrígelo allí primero.

## Ejercicios

**Ejercicio 1.** Traduce a Java una asignación y una suma sencilla.

**Ejercicio 2.** Convierte un `SI/SINO` de mayoría de edad a `if/else`.

**Ejercicio 3.** Convierte un bucle que muestre del 1 al 10 a `while`.

**Reto.** Toma el pseudocódigo de contar aprobados y localiza qué estructuras Java necesitarás. No es necesario dominar todavía la entrada por teclado.

## Qué debes recordar

La sintaxis cambia entre lenguajes; la lógica permanece. Cuanto mejor diseñado esté el algoritmo, más directa será la implementación. La ruta de Java profundizará en los detalles técnicos que aquí solo hemos presentado como equivalencias.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion16/">← Lección 16 · Errores frecuentes en algoritmos</a>
  <a href="/algoritmia/leccion18/">Lección 18 · Ejercicios y retos de algoritmia →</a>
</div>
