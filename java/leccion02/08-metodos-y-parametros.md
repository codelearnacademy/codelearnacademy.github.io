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

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-metodo-flujo.png" alt="02 metodo flujo" loading="lazy">
</figure>

### Ejemplo guiado

Parte de una calculadora monolítica y extrae `sumar`, `restar`, `multiplicar` y `dividir`.

### Ejercicio propuesto

Implementa `esPar`, `mayor` y `calcularArea` y úsales desde `main`.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué son los argumentos?

- A) Valores enviados al invocar un método
- B) Variables globales obligatorias
- C) Errores de compilación
- D) Paquetes

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los argumentos proporcionan valores a los parámetros.</p>

</details>

### 2. ¿Qué indica `void` como tipo de retorno?

- A) El método no devuelve un valor
- B) El método no ejecuta nada
- C) El método es privado
- D) El método recibe cero parámetros

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> void significa ausencia de valor de retorno.</p>

</details>

### 3. ¿Qué hace `return` en un método no void?

- A) Devuelve un valor al llamador
- B) Importa una clase
- C) Inicia un bucle
- D) Declara un paquete

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> return entrega el resultado y finaliza esa ejecución del método.</p>

</details>

### 4. ¿Qué es la sobrecarga?

- A) Métodos con mismo nombre y distinta lista de parámetros
- B) Dos clases con el mismo fichero
- C) Un bucle infinito
- D) Una excepción

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La firma permite distinguir versiones sobrecargadas.</p>

</details>

### 5. ¿Una variable local existe fuera de su ámbito?

- A) Sí siempre
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Su ámbito está limitado al bloque/método donde se declara.</p>

</details>

## Ejercicios propuestos

1. Refactoriza una calculadora para que cada operación esté en un método.
2. Implementa `esPar`, `mayor` y `calcularArea` y crea pruebas manuales desde `main`.

