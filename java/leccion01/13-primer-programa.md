---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 13-primer-programa
lesson_number: "13"
title: Tu primer programa
description: Escribe un programa mínimo y reconoce su estructura esencial.
lessons:
  - id: que-significa-cada-parte
    title: "Qué significa cada parte"
  - id: un-segundo-ejemplo
    title: "Un segundo ejemplo"
  - id: refuerzo-practico
    title: "Refuerzo práctico"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Tu primer programa

Crea un archivo llamado `Main.java` con este contenido:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Java 21");
    }
}
```

## Qué significa cada parte
{: #que-significa-cada-parte }

- `public class Main` declara una clase pública llamada `Main`.
- `main` es el punto de entrada convencional de una aplicación Java.
- `String[] args` recibe argumentos de la línea de comandos.
- `System.out.println` escribe una línea en la salida estándar.

El nombre del archivo debe coincidir con el de la clase pública. Esa regla permite al compilador y a las herramientas localizar la clase de forma predecible.

<div class="cla-note"><strong>Prueba rápida</strong><p>Guarda el archivo exactamente como <code>Main.java</code>. El siguiente apartado lo compilará desde el terminal.</p></div>

## Un segundo ejemplo
{: #un-segundo-ejemplo }

Puedes recibir un argumento y mostrarlo sin cambiar el punto de entrada:

```java
public class Main {
    public static void main(String[] args) {
        String nombre = args.length > 0 ? args[0] : "estudiante";
        System.out.println("Hola, " + nombre);
    }
}
```

Ejecuta `java Main Ada`. La expresión condicional evita acceder a una posición inexistente cuando no se proporciona ningún argumento.

## Refuerzo práctico
{: #refuerzo-practico }

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-main-anatomia.webp' | relative_url }}" alt="01 main anatomia" loading="lazy">
</figure>

### Ejemplo guiado

Escribe `Main.java` desde cero, compílalo y cambia únicamente el texto mostrado para verificar qué parte del programa has modificado.

### Ejercicio propuesto

Crea un programa que muestre nombre, curso y lenguaje en tres líneas.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Cuál es el punto de entrada clásico de una aplicación Java de consola?

- A) start
- B) runJava
- C) initSql
- D) main

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La JVM invoca el método public static void main(String[] args).</p>

</details>

### 2. ¿Qué hace System.out.println?

- A) Lee teclado
- B) Escribe una línea en la salida estándar
- C) Compila la clase
- D) Crea un objeto JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> println envía texto a la salida estándar y añade salto de línea.</p>

</details>

### 3. ¿Qué debe coincidir normalmente con el nombre del fichero cuando la clase es public?

- A) La versión de Java
- B) El texto impreso
- C) El nombre del método main
- D) El nombre de la clase pública

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Una clase pública debe residir en un fichero con el mismo nombre.</p>

</details>

### 4. ¿Qué tipo devuelve `main`?

- A) void
- B) String
- C) boolean
- D) int

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El método main clásico no devuelve un valor al llamador Java.</p>

</details>

### 5. ¿Qué recibe `main` en `String[] args`?

- A) Variables de entorno únicamente
- B) SQL
- C) Argumentos de línea de comandos
- D) Objetos de la JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Ese array contiene argumentos pasados al iniciar el programa.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Crea un programa que muestre tu nombre, curso y tres tecnologías que quieras aprender.
2. Pasa un argumento por línea de comandos y muéstralo desde `args`.

