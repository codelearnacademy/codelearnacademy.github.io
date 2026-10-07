---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 03-variables-y-tipos
lesson_number: "03"
title: Variables y tipos
description: Declara datos y selecciona el tipo correcto según la información que necesitas guardar.
---

# Variables y tipos

Las variables sirven para guardar información que el programa usa durante su ejecución.

## Sintaxis básica

```java
int edad = 20;
double precio = 19.99;
boolean activo = true;
char inicial = 'A';
String nombre = "Ana";
```

## Tipos principales


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-tipos-java.png" alt="Tipos de datos principales en Java" loading="lazy">
</figure>

### Enteros

```java
byte b = 10;
short s = 200;
int numero = 1000;
long largo = 100000L;
```

### Decimales

```java
float nota = 8.5f;
double pi = 3.14159;
```

### Texto y lógica

```java
char letra = 'Z';
String texto = "Hola";
boolean correcto = true;
```

## Reglas

- Las variables deben tener un nombre descriptivo.
- En Java, los nombres suelen escribirse en minúscula y usar camelCase.
- Una variable no puede empezar por un número.

## Ejemplos correctos

```java
int contador = 0;
String nombreCompleto = "Luis";
double salarioMensual = 1450.50;
```

## Constantes

Cuando un valor no debe cambiar, se usa `final`:

```java
final double IVA = 0.21;
```

## Ejemplo completo

```java
public class VariablesDemo {
    public static void main(String[] args) {
        String nombre = "Maria";
        int edad = 25;
        double altura = 1.73;

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
    }
}
```

<div class="cla-note"><strong>Importante</strong><p>Usa el tipo más preciso para cada dato. Un número entero no debe guardarse como `double` si no hace falta, y un valor fijo debe ser constante.</p></div>

## Ejercicio

Crea una clase `Persona` que almacene nombre, edad y altura, y la muestre por consola.

## Práctica guiada del concepto

1. Declara una variable para la edad y otra para el nombre.
2. Cambia una variable de tipo `int` a `String` y observa cómo se altera el programa.
3. Responde: ¿qué tipo usarías para guardar un precio con decimales? ¿y para guardar una respuesta binaria?

### Código que genera error

```java
public class ErrorTipos {
    public static void main(String[] args) {
        int edad = "25";
        System.out.println(edad);
    }
}
```

El programa falla porque no puedes asignar un texto a una variable `int` sin convertirlo antes. La corrección sería `int edad = Integer.parseInt("25");`.

## Después de esta lección

Ya sabes cómo guardar información. El siguiente paso es operar con esa información usando operadores y expresiones.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-variable-tipo-valor.png" alt="02 variable tipo valor" loading="lazy">
</figure>

### Ejemplo guiado

Crea variables para nombre, edad, altura y matrícula. Muestra todos los valores y cambia solo los que deban ser mutables.

### Ejercicio propuesto

Elige tipos para precio, stock, fecha textual, aprobado y matrícula y justifica cada elección.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué declaración es válida?

- A) int edad = "20";
- B) double precio = 19.95;
- C) boolean activo = "true";
- D) char letra = "A";

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> 19.95 es un literal compatible con double.</p>

</details>

### 2. ¿Qué tipo usarías para verdadero/falso?

- A) boolean
- B) double
- C) String obligatoriamente
- D) char

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> boolean representa valores lógicos.</p>

</details>

### 3. ¿Qué palabra impide reasignar una variable una vez inicializada?

- A) final
- B) const
- C) fixed
- D) readonly

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Java usa final para referencias/variables que no pueden reasignarse.</p>

</details>

### 4. ¿Qué tipo es adecuado para un número entero habitual?

- A) int
- B) boolean
- C) char
- D) String

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> int es el entero de uso general más habitual.</p>

</details>

### 5. ¿Puede una variable Java empezar por un número?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Los identificadores no pueden comenzar por un dígito.</p>

</details>

## Ejercicios propuestos

1. Modela un producto con id, nombre, precio, stock y disponible eligiendo tipos adecuados.
2. Añade una constante para el IVA y calcula el precio con impuesto.

