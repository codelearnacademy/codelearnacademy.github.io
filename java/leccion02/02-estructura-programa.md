---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 02-estructura-programa
lesson_number: "02"
title: Estructura de un programa
description: Entiende la estructura base de una clase y del método main en Java.
---

# Estructura de un programa en Java

Un programa Java se escribe como una o varias clases. Una clase agrupa datos y comportamiento relacionado.

## Forma mínima

```java
public class MiPrograma {
    public static void main(String[] args) {
        System.out.println("Programa ejecutado");
    }
}
```

## Desglose

```java
public class MiPrograma {
```

- `public`: indica acceso público.
- `class`: define una clase.
- `MiPrograma`: nombre de la clase.

```java
public static void main(String[] args) {
```

- `main`: método principal.
- `static`: pertenece a la clase, no a un objeto.
- `void`: no devuelve ningún valor.
- `String[] args`: argumentos de entrada desde consola.

```java
System.out.println("Programa ejecutado");
```

- sentencia ejecutable.
- muestra texto en consola.
- `println` añade salto de línea.

## Buenas prácticas

- Cada clase debe tener una responsabilidad clara.
- El nombre de la clase debe empezar en mayúscula.
- La clase pública debe estar en un archivo con el mismo nombre.

## Ejemplo con varios mensajes

```java
public class Saludo {
    public static void main(String[] args) {
        System.out.println("Hola");
        System.out.println("¿Cómo estás?");
        System.out.println("Java funciona");
    }
}
```

## Errores comunes

- Olvidar la llave de cierre `}`.
- Escribir `main` con una firma distinta.
- Guardar el archivo con otro nombre que no coincida con la clase.

<div class="cla-note"><strong>Regla práctica</strong><p>Cuando el programa no arranca, revisa primero si la clase se llama igual que el archivo y si el método `main` está escrito correctamente.</p></div>

## Ejercicio

Crea una clase `Mensaje` que muestre tres frases en consola.

## Práctica guiada del concepto

1. Escribe una clase simple y asegúrate de que el nombre del archivo coincide con el nombre de la clase.
2. Cambia el orden de las llaves y observa el error del compilador.
3. Refleja: ¿por qué es importante que `main` esté exactamente definido como `public static void main(String[] args)`?

### Código que genera error

```java
public class ErrorEstructura {
    public static void main(String[] args) {
        System.out.println("Hola");
    
}
```

El programa fallará por una llave faltante. La corrección es cerrar correctamente el bloque con `}`.

## Después de esta lección

Ahora ya conoces la base de una clase. El siguiente paso es aprender a guardar información real en variables y tipos.

