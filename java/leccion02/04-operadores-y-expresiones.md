---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 04-operadores-y-expresiones
lesson_number: "04"
title: Operadores y expresiones
description: Aprende a combinar valores con operadores aritméticos, relacionales y lógicos.
---

# Operadores y expresiones

Las expresiones permiten combinar variables, literales y operadores para calcular o comparar valores.

## Operadores aritméticos

```java
int a = 10;
int b = 3;

System.out.println(a + b); // 13
System.out.println(a - b); // 7
System.out.println(a * b); // 30
System.out.println(a / b); // 3
System.out.println(a % b); // 1
```

## Operadores de asignación

```java
int total = 5;
total += 3;   // total = total + 3
System.out.println(total); // 8
```

## Operadores relacionales

```java
int x = 5;
int y = 7;

System.out.println(x < y);   // true
System.out.println(x == y);  // false
System.out.println(x != y);  // true
```

## Operadores lógicos

```java
boolean aprobado = true;
boolean asistencia = false;

System.out.println(aprobado && asistencia); // false
System.out.println(aprobado || asistencia); // true
System.out.println(!aprobado);             // false
```

## Operador de concatenación

```java
String nombre = "Ana";
int edad = 22;

System.out.println("Nombre: " + nombre + ", edad: " + edad);
```

## Ejemplo práctico

```java
public class OperadoresDemo {
    public static void main(String[] args) {
        int a = 8;
        int b = 3;

        int suma = a + b;
        boolean mayor = a > b;

        System.out.println("Suma: " + suma);
        System.out.println("¿a es mayor que b? " + mayor);
    }
}
```

## Importante

- `==` compara valores.
- `=` asigna valores.
- `&&` exige que ambas condiciones sean verdaderas.
- `||` acepta que al menos una sea verdadera.

<div class="cla-note"><strong>Truco</strong><p>Si una comparación devuelve `true` o `false`, estás usando un valor booleano. Ese tipo es esencial para decidir rutas dentro del programa.</p></div>

## Ejercicio

Calcula el promedio de tres notas y comprueba si el alumno supera 5.0.

## Práctica guiada del concepto

1. Calcula la suma y la diferencia de dos valores.
2. Comprueba el resultado de `==` y `=` en un ejemplo corto.
3. Crea una expresión con `&&` y otra con `||` para ver cómo cambia el resultado.

### Código que genera error

```java
public class ErrorOperadores {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        if (a = b) {
            System.out.println("Iguales");
        }
    }
}
```

Esto falla porque `=` asigna valores, no compara. La comparación correcta sería `a == b`.

## Después de esta lección

Ahora ya puedes combinar datos y compararlos. El siguiente paso es interactuar con el usuario mediante entrada y salida.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-casting.png" alt="02 casting" loading="lazy">
</figure>

### Ejemplo guiado

Calcula el precio final de un producto aplicando IVA y descuento usando variables intermedias.

### Ejercicio propuesto

Crea un conversor Celsius/Fahrenheit y un programa que determine si un número pertenece a un intervalo.
## Ejercicios de práctica · Operadores y expresiones

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a construir cálculos y condiciones. Debes utilizar explícitamente aritméticos, relacionales, lógicos, módulo y asignación. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Operadores y expresiones**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por precedencia, división entera y expresiones ambiguas. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Operadores y expresiones**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en calcular una factura o presupuesto. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué devuelve `7 / 2` si ambos operandos son int?

- A) 3
- B) 3.5
- C) 4
- D) 1

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La división entre enteros descarta la parte decimal.</p>

</details>

### 2. ¿Qué devuelve `7 % 2`?

- A) 3
- B) 1
- C) 3.5
- D) 0

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> % obtiene el resto de la división entera.</p>

</details>

### 3. ¿Qué operador representa AND lógico?

- A) <code>&amp;&amp;</code>
- B) <code>||</code>
- C) <code>==</code>
- D) <code>%</code>

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> <code>&amp;&amp;</code> exige que ambas condiciones sean verdaderas.</p>

</details>

### 4. ¿Qué operador compara igualdad de valores primitivos?

- A) <code>==</code>
- B) =
- C) <code>=&gt;</code>
- D) <code>&lt;&gt;</code>

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> == compara igualdad; = asigna.</p>

</details>

## Ejercicios propuestos

1. Calcula el precio final aplicando IVA y descuento con variables intermedias.
2. Predice y comprueba el resultado de cinco expresiones que mezclen `/`, `%`, comparaciones y operadores lógicos.

