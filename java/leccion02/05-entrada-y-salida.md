---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 05-entrada-y-salida
lesson_number: "05"
title: Entrada y salida
description: Lee datos desde consola y escribe información útil para el usuario.
---

# Entrada y salida

La consola es una de las formas más básicas de comunicación entre el programa y el usuario.

## Salida por consola

```java
System.out.println("Hola");
System.out.print("Este texto no salta de línea");
```

## Entrada por teclado


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-scanner-flujo.png" alt="Flujo de entrada mediante Scanner" loading="lazy">
</figure>

Para leer datos del usuario, normalmente se usa `Scanner`.

```java
import java.util.Scanner;

public class EntradaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Hola, " + nombre);
        sc.close();
    }
}
```

## Lectura de números

```java
import java.util.Scanner;

public class NumerosDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        System.out.println("Tu edad es: " + edad);
        sc.close();
    }
}
```

## Diferencia entre `nextLine()` y `nextInt()`

- `nextLine()` lee texto completo hasta pulsar Enter.
- `nextInt()` lee un número entero.

Si mezclas ambos en un mismo programa, puede aparecer un comportamiento inesperado. En esos casos, suele ser útil consumir el salto de línea con `nextLine()`.

## Ejemplo completo

```java
import java.util.Scanner;

public class DatosPersona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.println(nombre + " tiene " + edad + " años");
        sc.close();
    }
}
```

<div class="cla-note"><strong>Consejo</strong><p>En las primeras aplicaciones, la consola es una herramienta excelente para depurar. Un `println` bien colocado suele responder muchas dudas.</p></div>

## Ejercicio

Escribe un programa que pida `nombre`, `apellidos` y `edad`, y luego muestre un resumen completo.

## Práctica guiada del concepto

1. Pide tu nombre con `Scanner` y muéstralo en pantalla.
2. Pide dos números y muestra su suma.
3. Haz una prueba con `nextInt()` seguido de `nextLine()` para detectar el problema típico de lectura.

### Código que genera error

```java
import java.util.Scanner;

public class ErrorScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad = sc.nextInt();
        String nombre = sc.nextLine();
        System.out.println(nombre + " tiene " + edad + " años");
    }
}
```

Este patrón suele dejar `nombre` vacío porque el salto de línea queda pendiente. La corrección es consumir el salto de línea con `sc.nextLine()` después de leer el entero.

## Después de esta lección

Tras dominar la interacción con consola, el siguiente paso es tomar decisiones con condiciones.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-scanner-buffer.png" alt="02 scanner buffer" loading="lazy">
</figure>

### Ejemplo guiado

Lee edad con `nextInt()` y nombre con `nextLine()`, reproduce el problema del salto pendiente y corrígelo.

### Ejercicio propuesto

Construye una ficha de alumno leyendo nombre, edad y nota por consola.
## Ejercicios de práctica · Entrada y salida

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a leer datos con `Scanner` y mostrar resultados. Debes utilizar explícitamente `nextLine`, `nextInt`, `nextDouble`, `print` y `println`. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Entrada y salida**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por salto pendiente, valores vacíos y tipos incorrectos. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Entrada y salida**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en crear un formulario de consola. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué clase se usa habitualmente en ejemplos básicos para leer teclado?

- A) Scanner
- B) Math
- C) StringBuilder
- D) LocalDate

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Scanner permite leer la entrada estándar.</p>

</details>

### 2. ¿Qué problema típico aparece al mezclar nextInt() y nextLine()?

- A) Puede quedar pendiente un salto de línea
- B) Se borra la JVM
- C) No compila nunca
- D) Convierte todo a double

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> nextInt no consume necesariamente el salto de línea posterior.</p>

</details>

### 3. ¿Qué hace `System.out.print` frente a `println`?

- A) No añade salto de línea automáticamente
- B) Lee teclado
- C) Compila
- D) Lanza excepción siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> print mantiene el cursor en la misma línea.</p>

</details>

### 4. ¿Qué objeto representa normalmente la entrada estándar?

- A) System.in
- B) System.out
- C) System.err únicamente
- D) Math.in

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> System.in es el flujo de entrada estándar.</p>

</details>

## Ejercicios propuestos

1. Construye una ficha de alumno leyendo nombre, edad y nota.
2. Reproduce el problema `nextInt()` + `nextLine()` y corrígelo.

