---
layout: lesson
route: java
lesson_id: leccion12
lesson_file: 12-clases-envolventes
lesson_number: "12"
title: Clases envolventes en Java
description: Aprende a trabajar con las clases envolventes, autoboxing, unboxing y conversión de tipos en Java 21.
---

# Clases envolventes en Java

Java dispone de **tipos primitivos** como `int`, `double`, `char` o `boolean`. Estos tipos almacenan valores simples y no son objetos.

Sin embargo, en determinadas situaciones necesitamos trabajar con esos valores como objetos. Para ello Java proporciona las **clases envolventes**, también conocidas como *wrapper classes*.

Cada tipo primitivo tiene asociada una clase envolvente.

| Tipo primitivo | Clase envolvente |
| --- | --- |
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

Por ejemplo:

```java
int numero = 10;
Integer numeroObjeto = 10;
```

Aunque ambos representan el valor `10`, no son exactamente lo mismo:

- `int` es un tipo primitivo.
- `Integer` es una clase y, por tanto, sus valores son objetos.

## ¿Para qué sirven las clases envolventes?

Las clases envolventes son necesarias cuando una API de Java necesita trabajar con objetos en lugar de tipos primitivos.

Un ejemplo habitual son las colecciones.

No podemos escribir:

```java
ArrayList<int> numeros;
```

Debemos utilizar la clase envolvente:

```java
ArrayList<Integer> numeros;
```

Ejemplo completo:

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        System.out.println(numeros);
    }
}
```

Salida:

```text
[10, 20, 30]
```

Java convierte automáticamente los valores `int` en objetos `Integer`.

Este proceso se denomina **autoboxing**.

## Autoboxing

El **autoboxing** es la conversión automática de un tipo primitivo a su clase envolvente.

```java
int numero = 25;

Integer numeroObjeto = numero;
```

Java realiza automáticamente una conversión equivalente a:

```java
Integer numeroObjeto = Integer.valueOf(numero);
```

Otros ejemplos:

```java
Double precio = 19.95;
Boolean activo = true;
Character letra = 'A';
```

## Unboxing

El **unboxing** es el proceso contrario: convertir automáticamente un objeto envolvente en su tipo primitivo correspondiente.

```java
Integer numeroObjeto = 50;

int numero = numeroObjeto;
```

También podemos hacerlo explícitamente:

```java
int numero = numeroObjeto.intValue();
```

Ejemplo:

```java
public class Main {

    public static void main(String[] args) {

        Integer numeroObjeto = 100;

        int numero = numeroObjeto;

        System.out.println(numero);
    }
}
```

Salida:

```text
100
```

<div class="cla-note"><strong>Idea clave</strong><p>Autoboxing convierte automáticamente un valor primitivo en un objeto envolvente. Unboxing realiza el proceso contrario.</p></div>

## Métodos comunes

Las clases envolventes proporcionan métodos que permiten:

- Convertir cadenas de texto en números.
- Convertir objetos envolventes en valores primitivos.
- Comparar valores.
- Consultar valores máximos y mínimos.
- Analizar caracteres.

## Clase `Byte`

La clase `Byte` representa valores de tipo `byte`.

Métodos habituales:

- `byteValue()`: devuelve el valor como `byte`.
- `parseByte(String)`: convierte una cadena en un `byte`.
- `valueOf(String)`: convierte una cadena en un objeto `Byte`.
- `compareTo(Byte)`: compara dos objetos `Byte`.

Ejemplo:

```java
String texto = "100";

byte numero = Byte.parseByte(texto);

System.out.println(numero);
```

## Clase `Short`

La clase `Short` representa valores de tipo `short`.

Métodos habituales:

- `shortValue()`
- `parseShort(String)`
- `valueOf(String)`
- `compareTo(Short)`

Ejemplo:

```java
String texto = "32000";

short numero = Short.parseShort(texto);

System.out.println(numero);
```

## Clase `Integer`

`Integer` es la clase envolvente correspondiente al tipo primitivo `int`.

Algunos de sus métodos más utilizados son:

- `intValue()`
- `parseInt(String)`
- `valueOf(String)`
- `compareTo(Integer)`
- `compare(int, int)`
- `toString(int)`

### `parseInt()`

`Integer.parseInt()` convierte un `String` en un valor primitivo `int`.

```java
String texto = "250";

int numero = Integer.parseInt(texto);
```

El resultado es de tipo:

```text
int
```

### `valueOf()`

`Integer.valueOf()` puede convertir una cadena en un objeto `Integer`.

```java
String texto = "250";

Integer numero = Integer.valueOf(texto);
```

El resultado es de tipo:

```text
Integer
```

Por tanto:

```java
int numero1 = Integer.parseInt("250");
Integer numero2 = Integer.valueOf("250");
```

La diferencia principal es:

```text
parseInt() -> int
valueOf()  -> Integer
```

## Clase `Long`

`Long` es la clase envolvente correspondiente a `long`.

Métodos habituales:

- `longValue()`
- `parseLong(String)`
- `valueOf(String)`
- `compareTo(Long)`

Ejemplo:

```java
String texto = "5000000";

long numero = Long.parseLong(texto);

System.out.println(numero);
```

## Clase `Float`

`Float` representa valores de tipo `float`.

Métodos habituales:

- `floatValue()`
- `parseFloat(String)`
- `valueOf(String)`
- `compareTo(Float)`

Ejemplo:

```java
String texto = "12.5";

float numero = Float.parseFloat(texto);

System.out.println(numero);
```

## Clase `Double`

`Double` representa valores de tipo `double`.

Métodos habituales:

- `doubleValue()`
- `parseDouble(String)`
- `valueOf(String)`
- `compareTo(Double)`

Ejemplo:

```java
String texto = "19.95";

double precio = Double.parseDouble(texto);

System.out.println(precio);
```

## Clase `Character`

`Character` es la clase envolvente correspondiente a `char`.

Además de representar caracteres como objetos, proporciona numerosos métodos para analizarlos.

Algunos de los más utilizados son:

- `charValue()`
- `isLetter(char)`
- `isDigit(char)`
- `isLetterOrDigit(char)`
- `isUpperCase(char)`
- `isLowerCase(char)`
- `toUpperCase(char)`
- `toLowerCase(char)`

Ejemplo:

```java
char caracter = '8';

if (Character.isDigit(caracter)) {
    System.out.println("Es un número");
}
```

Salida:

```text
Es un número
```

## Clase `Boolean`

`Boolean` representa valores de tipo `boolean`.

Métodos habituales:

- `booleanValue()`
- `parseBoolean(String)`
- `valueOf(String)`
- `compareTo(Boolean)`

Ejemplo:

```java
String texto = "true";

boolean activo = Boolean.parseBoolean(texto);

System.out.println(activo);
```

Salida:

```text
true
```

## Conversión de texto a números

Uno de los usos más habituales de las clases envolventes es convertir cadenas de caracteres en valores numéricos.

```java
String edadTexto = "25";

int edad = Integer.parseInt(edadTexto);

System.out.println(edad + 1);
```

Salida:

```text
26
```

Podemos convertir distintos tipos mediante:

```java
byte valorByte = Byte.parseByte("10");
short valorShort = Short.parseShort("1000");
int valorInt = Integer.parseInt("200");
long valorLong = Long.parseLong("500000");
float valorFloat = Float.parseFloat("10.5");
double valorDouble = Double.parseDouble("20.75");
boolean valorBoolean = Boolean.parseBoolean("true");
```

## ¿Qué ocurre si el texto no contiene un número?

Observa este código:

```java
String texto = "hola";

int numero = Integer.parseInt(texto);
```

El programa compila, pero durante la ejecución Java lanza una excepción:

```text
NumberFormatException
```

Podemos controlar este problema utilizando `try-catch`:

```java
public class Main {

    public static void main(String[] args) {

        String texto = "hola";

        try {

            int numero = Integer.parseInt(texto);

            System.out.println(numero);

        } catch (NumberFormatException e) {

            System.out.println("El valor introducido no es un número válido");
        }
    }
}
```

<div class="cla-note"><strong>Importante</strong><p>Los métodos como <code>Integer.parseInt()</code> o <code>Double.parseDouble()</code> pueden lanzar una <code>NumberFormatException</code> cuando el texto no representa un valor válido.</p></div>

## Comparar objetos envolventes

Los objetos envolventes pueden compararse utilizando `compareTo()`.

```java
Integer numero1 = 100;
Integer numero2 = 200;

int resultado = numero1.compareTo(numero2);

System.out.println(resultado);
```

Cuando utilizamos `compareTo()`:

- Devuelve un valor negativo si el primer valor es menor.
- Devuelve `0` si ambos valores son iguales.
- Devuelve un valor positivo si el primer valor es mayor.

También existen métodos estáticos como:

```java
int resultado = Integer.compare(10, 20);
```

## Comparación con `equals()`

Cuando trabajamos con objetos envolventes debemos tener cuidado con `==`.

```java
Integer numero1 = 1000;
Integer numero2 = 1000;

System.out.println(numero1 == numero2);
```

No debemos depender de `==` para decidir si dos objetos `Integer` contienen el mismo valor.

Para comparar su contenido utilizamos:

```java
System.out.println(numero1.equals(numero2));
```

Resultado:

```text
true
```

<div class="cla-note"><strong>Regla importante</strong><p>Para comparar el contenido de objetos envolventes utiliza normalmente <code>equals()</code>. No dependas de <code>==</code> para comprobar si contienen el mismo valor.</p></div>

## Constantes útiles

Las clases envolventes también contienen constantes que permiten conocer los límites de los tipos numéricos.

```java
System.out.println(Integer.MIN_VALUE);
System.out.println(Integer.MAX_VALUE);
```

Salida:

```text
-2147483648
2147483647
```

También podemos consultar:

```java
Byte.MIN_VALUE
Byte.MAX_VALUE

Short.MIN_VALUE
Short.MAX_VALUE

Integer.MIN_VALUE
Integer.MAX_VALUE

Long.MIN_VALUE
Long.MAX_VALUE
```

## Métodos `xxxValue()`

Cada clase envolvente permite obtener un valor primitivo.

```java
Integer numero = 100;

int valor = numero.intValue();
```

Otros ejemplos:

```java
Byte datoByte = 10;
byte b = datoByte.byteValue();

Short datoShort = 20;
short s = datoShort.shortValue();

Long datoLong = 100L;
long l = datoLong.longValue();

Float datoFloat = 12.5f;
float f = datoFloat.floatValue();

Double datoDouble = 25.75;
double d = datoDouble.doubleValue();

Character datoCharacter = 'A';
char c = datoCharacter.charValue();

Boolean datoBoolean = true;
boolean activo = datoBoolean.booleanValue();
```

En muchos casos Java realiza el **unboxing** automáticamente.

## Clases numéricas y `Number`

Las principales clases envolventes numéricas heredan de la clase abstracta `Number`.

Entre ellas se encuentran:

```text
Byte
Short
Integer
Long
Float
Double
```

Gracias a ello comparten métodos como:

```java
byteValue()
shortValue()
intValue()
longValue()
floatValue()
doubleValue()
```

Ejemplo:

```java
Integer numero = 25;

System.out.println(numero.intValue());
System.out.println(numero.doubleValue());
```

Salida:

```text
25
25.0
```

## Clases envolventes y `null`

Al tratarse de objetos, una variable de una clase envolvente puede contener `null`.

```java
Integer numero = null;
```

Un tipo primitivo no puede contener `null`.

Debemos tener especial cuidado al realizar unboxing de un valor `null`.

```java
Integer numeroObjeto = null;

int numero = numeroObjeto;
```

El programa compila, pero durante la ejecución produce:

```text
NullPointerException
```

Podemos evitarlo comprobando previamente el valor:

```java
Integer numeroObjeto = null;

if (numeroObjeto != null) {
    int numero = numeroObjeto;
    System.out.println(numero);
}
```

<div class="cla-note"><strong>Atención</strong><p>Una clase envolvente puede contener <code>null</code>. Intentar realizar unboxing de <code>null</code> provoca una <code>NullPointerException</code>.</p></div>

## Ejemplo completo

El siguiente programa combina conversión, autoboxing, unboxing y comparación:

```java
public class Main {

    public static void main(String[] args) {

        String texto = "123";

        int numero = Integer.parseInt(texto);

        System.out.println("Número: " + numero);

        Integer numeroObjeto = numero;

        System.out.println("Objeto Integer: " + numeroObjeto);

        int numeroPrimitivo = numeroObjeto;

        System.out.println("Primitivo: " + numeroPrimitivo);

        Integer otroNumero = 200;

        if (numeroObjeto.compareTo(otroNumero) < 0) {
            System.out.println(numeroObjeto + " es menor que " + otroNumero);
        }
    }
}
```

Salida:

```text
Número: 123
Objeto Integer: 123
Primitivo: 123
123 es menor que 200
```

## Para recordar

- Los tipos primitivos no son objetos.
- Cada tipo primitivo dispone de una clase envolvente.
- `int` utiliza `Integer`.
- `double` utiliza `Double`.
- `char` utiliza `Character`.
- `boolean` utiliza `Boolean`.
- El **autoboxing** convierte automáticamente un primitivo en un objeto envolvente.
- El **unboxing** convierte un objeto envolvente en un primitivo.
- `parseInt()`, `parseDouble()` y métodos similares convierten texto en valores primitivos.
- `valueOf()` permite obtener objetos envolventes.
- Las clases envolventes son necesarias para trabajar con colecciones.
- Para comparar objetos por su contenido utiliza `equals()`.
- Un objeto envolvente puede contener `null`.
- El unboxing de `null` provoca una `NullPointerException`.

## Ejercicio rápido

Indica qué tipo tendrá cada variable:

```java
int a = 10;

Integer b = 20;

Integer c = a;

int d = b;

int e = Integer.parseInt("50");

Integer f = Integer.valueOf("60");
```

Respuestas:

```text
a -> int
b -> Integer
c -> Integer
d -> int
e -> int
f -> Integer
```

Ahora identifica dónde se produce autoboxing y unboxing:

```java
Integer numero1 = 10;

int numero2 = numero1;

Integer numero3 = numero2;
```

Respuesta:

```text
Integer numero1 = 10;  -> autoboxing

int numero2 = numero1; -> unboxing

Integer numero3 = numero2; -> autoboxing
```

## Práctica guiada del concepto

Crea un programa llamado `Conversor.java`.

El programa debe:

1. Crear una variable `String` con el valor `"125"`.
2. Convertir el texto en un `int`.
3. Convertir ese `int` en un objeto `Integer`.
4. Mostrar ambos valores.
5. Mostrar el valor máximo que puede almacenar un `int`.
6. Comparar el número con `100`.

Puedes comenzar con:

```java
public class Conversor {

    public static void main(String[] args) {

        String texto = "125";

        int numero = Integer.parseInt(texto);

        Integer numeroObjeto = numero;

        System.out.println("Valor primitivo: " + numero);
        System.out.println("Objeto Integer: " + numeroObjeto);

        System.out.println(
            "Máximo valor de int: " + Integer.MAX_VALUE
        );

        if (numeroObjeto.compareTo(100) > 0) {
            System.out.println("El número es mayor que 100");
        }
    }
}
```

Salida esperada:

```text
Valor primitivo: 125
Objeto Integer: 125
Máximo valor de int: 2147483647
El número es mayor que 100
```

## Prueba tus conocimientos

### Caso 1

```java
Integer numero = 10;

int resultado = numero;
```

Se realiza **unboxing** automáticamente.

### Caso 2

```java
int numero = 10;

Integer resultado = numero;
```

Se realiza **autoboxing** automáticamente.

### Caso 3

```java
int numero = Integer.parseInt("hola");
```

Se produce una:

```text
NumberFormatException
```

### Caso 4

```java
Integer numero = null;

int resultado = numero;
```

Se produce una:

```text
NullPointerException
```

### Caso 5

```java
Integer a = 500;
Integer b = 500;

System.out.println(a.equals(b));
```

El resultado es:

```text
true
```

porque `equals()` compara los valores de los objetos.

## Después de esta lección

Tras completar este apartado debes saber distinguir entre `int` e `Integer` y comprender cuándo Java convierte automáticamente entre ambos.

También debes ser capaz de utilizar métodos como:

```java
Integer.parseInt()
Integer.valueOf()
Double.parseDouble()
Character.isDigit()
Character.isLetter()
```

Las clases envolventes aparecerán continuamente cuando trabajemos con colecciones, conversiones de datos y diferentes partes de la API de Java.

El siguiente paso es estudiar con mayor detalle la clase `String` y aprender a trabajar con cadenas de caracteres en Java.
