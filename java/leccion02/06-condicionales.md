---
layout: lesson
route: java
lesson_id: leccion02
lesson_file: 06-condicionales
lesson_number: "06"
title: Condicionales
description: Toma decisiones dentro del programa según condiciones booleanas.
---

# Condicionales

Los condicionales permiten ejecutar un bloque u otro según una condición.

## if

```java
int edad = 18;

if (edad >= 18) {
    System.out.println("Eres mayor de edad");
}
```

## if-else

```java
int nota = 7;

if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```

## else if

```java
int nota = 8;

if (nota >= 9) {
    System.out.println("Sobresaliente");
} else if (nota >= 7) {
    System.out.println("Notable");
} else if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```

## switch


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-switch.png" alt="Selección de casos con switch" loading="lazy">
</figure>

```java
int opcion = 2;

switch (opcion) {
    case 1:
        System.out.println("Uno");
        break;
    case 2:
        System.out.println("Dos");
        break;
    default:
        System.out.println("Opción no válida");
}
```

## Condiciones complejas

```java
int edad = 20;
boolean carnet = true;

if (edad >= 18 && carnet) {
    System.out.println("Puede conducir");
}
```

## Ejemplo práctico

```java
public class CondicionalesDemo {
    public static void main(String[] args) {
        int temperatura = 30;

        if (temperatura > 25) {
            System.out.println("Hace calor");
        } else {
            System.out.println("Hace frío");
        }
    }
}
```

<div class="cla-note"><strong>Importante</strong><p>Las condiciones deben devolver un valor booleano. Si no, no se pueden evaluar como `true` o `false`.</p></div>

## Ejercicio

Pide una edad por consola y muestra si la persona es menor de edad, mayor de edad o adulta.

## Práctica guiada del concepto

1. Escribe una condición con `if` para decidir si un número es positivo.
2. Añade un `else if` para diferenciar varios rangos.
3. Prueba uno de los errores típicos: comparar un valor con `=` en lugar de `==`.

### Código que genera error

```java
public class ErrorCondicional {
    public static void main(String[] args) {
        int edad = 18;
        if (edad = 18) {
            System.out.println("Tiene 18 años");
        }
    }
}
```

La condición debe ser `edad == 18`, no `edad = 18`. La primera asigna, la segunda compara.

## Después de esta lección

Después de entender decisiones, el siguiente paso es automatizar repeticiones con bucles.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/02-if-else.png" alt="Diagrama de flujo de if-else: una condición dirige la ejecución al bloque verdadero o al bloque falso" loading="lazy">
</figure>

### Ejemplo guiado

Clasifica una edad en infancia, adolescencia, adultez y senior. Prueba valores frontera.

### Ejercicio propuesto

Implementa clasificación de notas y un menú con `switch`.
## Ejercicios de práctica · Condicionales

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a seleccionar acciones según reglas. Debes utilizar explícitamente `if`, `else if`, `else`, `switch` y operadores lógicos. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Condicionales**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por límites, condiciones solapadas y `default`. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Condicionales**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en clasificar notas, edades o permisos. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Cuándo se ejecuta un bloque `if`?

- A) Cuando su condición es true
- B) Siempre
- C) Solo si es false
- D) Al compilar

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> if selecciona el bloque cuando la condición es verdadera.</p>

</details>

### 2. ¿Para qué sirve `else`?

- A) Para un camino alternativo cuando la condición anterior no se cumple
- B) Para crear un bucle
- C) Para declarar variables
- D) Para importar paquetes

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> else define el camino alternativo.</p>

</details>

### 3. ¿Qué estructura es útil cuando comparas una misma expresión con varios casos discretos?

- A) switch
- B) while únicamente
- C) class
- D) package

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> switch expresa bien selecciones por casos.</p>

</details>

### 4. ¿Qué resultado produce una expresión relacional como `edad >= 18`?

- A) boolean
- B) String
- C) double
- D) char

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Las comparaciones producen true o false.</p>

</details>

### 5. ¿Qué operador usarías para exigir dos condiciones a la vez?

- A) <code>&amp;&amp;</code>
- B) <code>||</code>
- C) <code>+</code>
- D) <code>%</code>

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> AND lógico requiere ambas condiciones.</p>

</details>

## Ejercicios propuestos

1. Clasifica una nota en cinco categorías usando `if/else if`.
2. Crea un menú de cuatro opciones usando `switch`.

