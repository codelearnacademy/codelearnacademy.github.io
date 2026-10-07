---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 09-resumen
lesson_number: "09"
title: Resumen de la lección
description: Revisa las ideas clave de la sintaxis y el flujo básico de Java.
---

# Resumen de la lección

## Qué has aprendido

- Cómo compilar y ejecutar un programa Java.
- Qué es una clase y qué es un método `main`.
- Cómo declarar variables y elegir el tipo adecuado.
- Cómo usar operadores para calcular y comparar.
- Cómo leer y escribir por consola.
- Cómo decidir rutas con condicionales.
- Cómo repetir tareas con bucles.
- Cómo organizar la lógica en métodos.

## Mapa mental

```text
Programa Java
  ├── clase
  ├── método main
  ├── variables
  ├── operadores
  ├── entrada/salida
  ├── condiciones
  ├── bucles
  └── métodos
```

## Antes de pasar a la siguiente lección

Debes ser capaz de responder estas preguntas:

- ¿Qué diferencia hay entre `=` y `==`?
- ¿Qué tipo usarías para guardar una edad?
- ¿Qué hace `Scanner`?
- ¿Cuándo usarías un `if`?
- ¿Cuándo usarías un `for`?
- ¿Qué es un método?

## Error habitual

La mayoría de los fallos iniciales vienen de:

- no coincidir el nombre de la clase con el archivo,
- olvidar `;`,
- mezclar `nextInt()` con `nextLine()`,
- crear un bucle sin condición que termine,
- olvidarse del `main`.

## Siguiente paso

La próxima lección profundizará en objetos, encapsulación y diseño orientado a objetos. Ya tienes la base sintáctica necesaria para entenderla con mucho más sentido.

## Práctica guiada del concepto

1. Haz una pequeña lista de las estructuras que has visto (variables, condicionales, bucles, métodos).
2. Explica para qué sirve cada una con una frase breve.
3. Revisa si una variable se usa fuera de su alcance o si un `if` está incompleto.

### Código que genera error

```java
public class ErrorResumen {
    public static void main(String[] args) {
        int x = 10;
        if (x > 5) {
            System.out.println("Mayor que 5");
        }
        System.out.println(x);
    }
}
```

Este ejemplo no falla, pero es útil para reflexionar: si el `if` está bien escrito, el bloque se ejecuta; si no, quizá el programa no haga lo que esperas. El objetivo es revisar la lógica, no solo la sintaxis.

## Después de esta lección

Tras este resumen, entramos en la parte de algoritmos guiados y la práctica final.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué estructura repetiría código varias veces?

- A) Un bucle
- B) Una constante
- C) Un import
- D) Un package

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los bucles modelan repetición.</p>

</details>

### 2. ¿Qué estructura permite seleccionar un camino?

- A) Condicional
- B) Comentario
- C) Clase envolvente
- D) JDK

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> if/switch seleccionan comportamiento según condiciones.</p>

</details>

### 3. ¿Para qué sirven los métodos?

- A) Encapsular y reutilizar operaciones
- B) Solo para imprimir
- C) Solo para bases de datos
- D) Para sustituir variables

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Permiten dividir problemas en operaciones con responsabilidades claras.</p>

</details>

### 4. ¿Qué clase hemos usado para entrada básica?

- A) Scanner
- B) Math
- C) Integer únicamente
- D) JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Scanner es el ejemplo introductorio habitual.</p>

</details>

### 5. ¿Qué debería acompañar siempre a la teoría?

- A) Pruebas con código y casos concretos
- B) Solo memorización
- C) No compilar
- D) Copiar soluciones

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La práctica consolida los conceptos.</p>

</details>

## Ejercicios propuestos

1. Construye un programa pequeño que combine entrada, condición, bucle y método.

