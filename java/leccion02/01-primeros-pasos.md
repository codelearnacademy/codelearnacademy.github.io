---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 01-primeros-pasos
lesson_number: "01"
title: Primeros pasos con Java
description: Compila y ejecuta tu primer programa Java desde el terminal.
---

# Primeros pasos con Java

Antes de escribir una aplicación compleja, conviene dominar el ciclo mínimo de trabajo: crear archivo, compilar y ejecutar.

## El ciclo básico

1. Escribes un archivo con extensión `.java`.
2. Lo compilas con `javac`.
3. Ejecutas el resultado con `java`.

```bash
javac Main.java
java Main
```

## Primer programa

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hola, Java 21");
    }
}
```

## Qué significa cada parte

- `public class Main`: define una clase pública llamada `Main`.
- `public static void main(String[] args)`: punto de entrada de la aplicación.
- `System.out.println(...)`: escribe un mensaje por consola.

## Regla importante

El nombre del archivo debe coincidir con el nombre de la clase pública. Si la clase se llama `Main`, el archivo debe llamarse `Main.java`.

## Ejercicio rápido

Crea un archivo llamado `Saludo.java` con este contenido:

```java
public class Saludo {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Java");
    }
}
```

Compílalo y ejecútalo:

```bash
javac Saludo.java
java Saludo
```

<div class="cla-note"><strong>Idea clave</strong><p>Cuando ves un programa Java, siempre debe existir una clase, y normalmente esa clase contiene un método `main` que inicia la ejecución.</p></div>

## Para recordar

- `.java` = código fuente.
- `.class` = bytecode compilado.
- `java` = ejecuta la aplicación.

Siguiente paso: aprender la estructura general de un programa Java y no solo copiar líneas sueltas.

## Práctica guiada del concepto

1. Crea un archivo `HolaJava.java` y ejecuta el programa desde el terminal.
2. Cambia el texto del mensaje y verifica que cambia la salida.
3. Responde: ¿Qué ocurre si eliminas la palabra `static` del método `main`?

### Código que genera error

```java
public class HolaJava {
    public void main(String[] args) {
        System.out.println("Esto falla");
    }
}
```

¿Qué ocurre al compilar? El método `main` ya no tiene la firma correcta para que Java lo identifique como punto de entrada. Lo correcto es `public static void main(String[] args)`.

## Después de esta lección

Tras completar este apartado, ya puedes pasar a la estructura del programa y entender cómo encaja el método `main` dentro de una clase.

