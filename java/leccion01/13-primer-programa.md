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