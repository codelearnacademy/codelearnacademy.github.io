---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 13-primer-programa
lesson_number: "13"
title: Tu primer programa
description: Escribe un programa mínimo y reconoce su estructura esencial.
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

- `public class Main` declara una clase pública llamada `Main`.
- `main` es el punto de entrada convencional de una aplicación Java.
- `String[] args` recibe argumentos de la línea de comandos.
- `System.out.println` escribe una línea en la salida estándar.

El nombre del archivo debe coincidir con el de la clase pública. Esa regla permite al compilador y a las herramientas localizar la clase de forma predecible.

<div class="cla-note"><strong>Prueba rápida</strong><p>Guarda el archivo exactamente como <code>Main.java</code>. El siguiente apartado lo compilará desde el terminal.</p></div>

## Un segundo ejemplo

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

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-main-anatomia.png" alt="01 main anatomia" loading="lazy">
</figure>

### Ejemplo guiado

Escribe `Main.java` desde cero, compílalo y cambia únicamente el texto mostrado para verificar qué parte del programa has modificado.

### Ejercicio propuesto

Crea un programa que muestre nombre, curso y lenguaje en tres líneas.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Cuál es el punto de entrada clásico de una aplicación Java de consola?

- A) main
- B) start
- C) runJava
- D) initSql

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La JVM invoca el método public static void main(String[] args).</p>

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

- A) El nombre de la clase pública
- B) El nombre del método main
- C) El texto impreso
- D) La versión de Java

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Una clase pública debe residir en un fichero con el mismo nombre.</p>

</details>

### 4. ¿Qué tipo devuelve `main`?

- A) int
- B) String
- C) void
- D) boolean

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El método main clásico no devuelve un valor al llamador Java.</p>

</details>

### 5. ¿Qué recibe `main` en `String[] args`?

- A) Argumentos de línea de comandos
- B) Objetos de la JVM
- C) Variables de entorno únicamente
- D) SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Ese array contiene argumentos pasados al iniciar el programa.</p>

</details>

## Ejercicios propuestos

1. Crea un programa que muestre tu nombre, curso y tres tecnologías que quieras aprender.
2. Pasa un argumento por línea de comandos y muéstralo desde `args`.

