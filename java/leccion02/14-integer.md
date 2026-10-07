---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 14-integer
lesson_number: "14"
title: Integer
description: Trabaja con la clase envolvente Integer y las conversiones entre texto y enteros.
---

# Integer

`Integer` es la clase envolvente del tipo primitivo `int`. Permite trabajar con enteros donde Java necesita objetos y ofrece métodos útiles para convertir, comparar y consultar límites.

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-wrapper.png" alt="Relación entre int e Integer" loading="lazy">
</figure>

## `parseInt()`

Convierte una cadena que contiene un entero válido en un `int`:

```java
String texto = "42";
int numero = Integer.parseInt(texto);
```

Si el texto no representa un entero válido se produce `NumberFormatException`.

## `valueOf()`

Devuelve un objeto `Integer`:

```java
Integer numero = Integer.valueOf("42");
```

## Comparar valores

```java
int resultado = Integer.compare(10, 20);
```

El resultado es negativo, cero o positivo según el primer valor sea menor, igual o mayor que el segundo.

## Límites

```java
System.out.println(Integer.MIN_VALUE);
System.out.println(Integer.MAX_VALUE);
```

<div class="cla-note"><strong>Idea clave</strong><p>`int` es un tipo primitivo; `Integer` es un objeto y puede utilizarse, por ejemplo, en colecciones genéricas como `List&lt;Integer&gt;`.</p></div>

## Ejemplo guiado

1. Guarda `"25"` en una variable `String`.
2. Convierte el texto con `Integer.parseInt`.
3. Suma 5 al resultado y muéstralo.
4. Sustituye `"25"` por `"veinticinco"` y observa la excepción.
5. Recupera el programa usando `try/catch` si ya has estudiado excepciones.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué hace Integer.parseInt("25")?

- A) Devuelve el int 25
- B) Devuelve String
- C) Devuelve null
- D) No compila

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> parseInt convierte una representación textual válida a int.</p>

</details>

### 2. ¿Qué ocurre con Integer.parseInt("hola")?

- A) Devuelve 0
- B) Lanza NumberFormatException
- C) Devuelve null
- D) Convierte a hash

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El texto no representa un entero válido.</p>

</details>

### 3. ¿Qué constante indica el mayor int representable?

- A) Integer.MAX_VALUE
- B) Integer.TOP
- C) Math.MAX_INT
- D) Int.MAX

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> MAX_VALUE expone el límite superior de int.</p>

</details>

### 4. ¿Integer es un tipo primitivo?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Integer es una clase envolvente.</p>

</details>

## Ejercicios propuestos

1. Lee cinco textos y convierte solo los que representen enteros válidos, controlando el error.

