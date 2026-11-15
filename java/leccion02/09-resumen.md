---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 09-resumen
lesson_number: "09"
title: Resumen de la lección
description: Revisa las ideas clave de la sintaxis y el flujo básico de Java.
lessons:
  - id: que-has-aprendido
    title: "Qué has aprendido"
  - id: mapa-mental
    title: "Mapa mental"
  - id: antes-de-pasar-a-la-siguiente-leccion
    title: "Antes de pasar a la siguiente lección"
  - id: error-habitual
    title: "Error habitual"
  - id: siguiente-paso
    title: "Siguiente paso"
  - id: practica-guiada-del-concepto
    title: "Práctica guiada del concepto"
  - id: despues-de-esta-leccion
    title: "Después de esta lección"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Resumen de la lección

## Qué has aprendido
{: #que-has-aprendido }

- Cómo compilar y ejecutar un programa Java.
- Qué es una clase y qué es un método `main`.
- Cómo declarar variables y elegir el tipo adecuado.
- Cómo usar operadores para calcular y comparar.
- Cómo leer y escribir por consola.
- Cómo decidir rutas con condicionales.
- Cómo repetir tareas con bucles.
- Cómo organizar la lógica en métodos.

## Mapa mental
{: #mapa-mental }

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
{: #antes-de-pasar-a-la-siguiente-leccion }

Debes ser capaz de responder estas preguntas:

- ¿Qué diferencia hay entre `=` y `==`?
- ¿Qué tipo usarías para guardar una edad?
- ¿Qué hace `Scanner`?
- ¿Cuándo usarías un `if`?
- ¿Cuándo usarías un `for`?
- ¿Qué es un método?

## Error habitual
{: #error-habitual }

La mayoría de los fallos iniciales vienen de:

- no coincidir el nombre de la clase con el archivo,
- olvidar `;`,
- mezclar `nextInt()` con `nextLine()`,
- crear un bucle sin condición que termine,
- olvidarse del `main`.

## Siguiente paso
{: #siguiente-paso }

La próxima lección profundizará en objetos, encapsulación y diseño orientado a objetos. Ya tienes la base sintáctica necesaria para entenderla con mucho más sentido.

## Práctica guiada del concepto
{: #practica-guiada-del-concepto }

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
{: #despues-de-esta-leccion }

Tras este resumen, entramos en la parte de algoritmos guiados y la práctica final.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Qué estructura repetiría código varias veces?

- A) Una constante
- B) Un package
- C) Un import
- D) Un bucle

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Los bucles modelan repetición.</p>

</details>

### 2. ¿Qué estructura permite seleccionar un camino?

- A) JDK
- B) Condicional
- C) Clase envolvente
- D) Comentario

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> if/switch seleccionan comportamiento según condiciones.</p>

</details>

### 3. ¿Para qué sirven los métodos?

- A) Encapsular y reutilizar operaciones
- B) Solo para imprimir
- C) Para sustituir variables
- D) Solo para bases de datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Permiten dividir problemas en operaciones con responsabilidades claras.</p>

</details>

### 4. ¿Qué clase hemos usado para entrada básica?

- A) Integer únicamente
- B) Math
- C) Scanner
- D) JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Scanner es el ejemplo introductorio habitual.</p>

</details>

### 5. ¿Qué debería acompañar siempre a la teoría?

- A) No compilar
- B) Copiar soluciones
- C) Solo memorización
- D) Pruebas con código y casos concretos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La práctica consolida los conceptos.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Construye un programa pequeño que combine entrada, condición, bucle y método.

