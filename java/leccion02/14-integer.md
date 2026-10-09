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
## Ejercicios de práctica · Integer

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a convertir y comparar enteros. Debes utilizar explícitamente `parseInt`, `valueOf`, `compare`, `MIN_VALUE`, `MAX_VALUE`. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Integer**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por texto inválido, overflow y `null`. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Integer**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en validar configuración numérica. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

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

