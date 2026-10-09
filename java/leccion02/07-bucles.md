---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 07-bucles
lesson_number: "07"
title: Bucles
description: Repite acciones automáticamente con for, while y do while.
---

# Bucles

Los bucles permiten repetir instrucciones varias veces sin escribir el mismo código manualmente.

## for

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Iteración: " + i);
}
```

## while

```java
int contador = 0;

while (contador < 5) {
    System.out.println("contador = " + contador);
    contador++;
}
```

## do while

```java
int numero = 0;

do {
    System.out.println(numero);
    numero++;
} while (numero < 3);
```

## break y continue

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        continue; // salta la iteración actual
    }
    if (i == 8) {
        break; // sale del bucle
    }
    System.out.println(i);
}
```

## Ejemplo práctico

```java
public class BuclesDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Tabla del 2: " + i * 2);
        }
    }
}
```

## Cuándo usar cada uno


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-bucles-comparacion.png" alt="Comparación entre for while y do while" loading="lazy">
</figure>

- `for`: cuando sabes cuántas veces quieres repetir.
- `while`: cuando la condición depende de algo que cambia durante la ejecución.
- `do while`: cuando al menos una ejecución debe ocurrir antes de comprobar la condición.

<div class="cla-note"><strong>Regla</strong><p>Todos los bucles necesitan una condición que eventualmente deje de cumplirse; de lo contrario se convierte en un bucle infinito.</p></div>

## Ejercicio

Escribe un programa que imprima los números del 1 al 10 y luego la suma de todos ellos.

## Práctica guiada del concepto

1. Haz un bucle `for` para imprimir del 1 al 10.
2. Haz el mismo ejercicio con `while`.
3. Intenta crear un bucle infinito y observa qué ocurre. ¿Qué condición debes usar para evitarlo?

### Código que genera error

```java
public class ErrorBucle {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            // i++ falta aquí
        }
    }
}
```

Este bucle no termina porque la variable `i` nunca cambia. La corrección es incrementar `i` dentro del bloque.

## Después de esta lección

Cuando ya sabes repetir tareas, el siguiente paso es encapsular lógica en métodos.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-for.png" alt="02 for" loading="lazy">
</figure>

### Ejemplo guiado

Traza un `for` del 1 al 5 en una tabla con contador, condición y salida. Después crea un acumulador.

### Ejercicio propuesto

Haz una tabla de multiplicar, suma pares y dibuja un triángulo de asteriscos con bucles.
## Ejercicios de práctica · Bucles

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a repetir procesos y acumular resultados. Debes utilizar explícitamente `for`, `while`, `do while`, `break`, `continue`. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Bucles**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por bucle infinito, límites e inicialización. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Bucles**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en estadísticas, menús repetitivos o patrones. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué bucle es cómodo cuando conoces el número de iteraciones?

- A) for
- B) if
- C) switch
- D) try

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> for concentra inicialización, condición y actualización.</p>

</details>

### 2. ¿Puede un `while` ejecutarse cero veces?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Comprueba la condición antes de entrar.</p>

</details>

### 3. ¿Qué diferencia principal tiene `do while`?

- A) Ejecuta el cuerpo al menos una vez
- B) Nunca comprueba condición
- C) No puede repetir
- D) Solo funciona con Strings

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La condición se evalúa después del cuerpo.</p>

</details>

### 4. ¿Qué es un acumulador?

- A) Una variable que va combinando resultados durante iteraciones
- B) Una clase de JVM
- C) Un operador SQL
- D) Un paquete

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Por ejemplo, suma += valor.</p>

</details>

### 5. ¿Qué riesgo tiene un bucle cuya condición nunca pasa a false?

- A) Bucle infinito
- B) Error de sintaxis necesariamente
- C) Autoboxing
- D) Garbage collection inmediata

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El programa puede quedar repitiendo indefinidamente.</p>

</details>

## Ejercicios propuestos

1. Genera la tabla de multiplicar de un número leído por teclado.
2. Pide números hasta introducir 0 y muestra suma y cantidad de valores introducidos.

