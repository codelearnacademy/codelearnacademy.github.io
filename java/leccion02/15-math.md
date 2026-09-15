---
layout: lesson
route: java
lesson_id: leccion15
lesson_file: 15-math
lesson_number: "15"
title: Clase Math en Java
description: Aprende a realizar operaciones matemáticas, redondeos, potencias, raíces, trigonometría y cálculos aleatorios con Math en Java 21.
---

# Clase `Math` en Java

La clase `Math` proporciona métodos y constantes para realizar operaciones matemáticas habituales en Java.

Permite trabajar, entre otras cosas, con:

- Valores absolutos.
- Potencias y raíces.
- Máximos y mínimos.
- Redondeos.
- Logaritmos.
- Funciones trigonométricas.
- Conversión entre grados y radianes.
- Números pseudoaleatorios.
- Operaciones enteras que detectan desbordamientos.

`Math` pertenece al paquete `java.lang`, por lo que no es necesario realizar ningún `import`.

```java
public class Main {

    public static void main(String[] args) {

        double resultado = Math.sqrt(64);

        System.out.println(resultado);
    }
}
```

Salida:

```text
8.0
```

## Los métodos de `Math` son estáticos

Los métodos de `Math` son `static`.

Esto significa que se utilizan directamente a través del nombre de la clase:

```java
Math.sqrt(64);
Math.pow(2, 3);
Math.abs(-10);
```

No necesitamos crear un objeto `Math`.

No hacemos:

```java
Math matematicas = new Math();
```

La clase está diseñada para utilizar sus métodos directamente.

<div class="cla-note"><strong>Idea clave</strong><p>Los métodos de <code>Math</code> son estáticos. Se llaman escribiendo <code>Math.nombreDelMetodo(...)</code>.</p></div>

## Métodos principales

Algunos de los métodos más utilizados son:

| Método | Descripción |
| --- | --- |
| `abs(...)` | Devuelve el valor absoluto. |
| `sqrt(double)` | Calcula la raíz cuadrada. |
| `cbrt(double)` | Calcula la raíz cúbica. |
| `pow(double, double)` | Calcula una potencia. |
| `max(...)` | Devuelve el mayor de dos valores. |
| `min(...)` | Devuelve el menor de dos valores. |
| `round(...)` | Redondea al entero más cercano. |
| `ceil(double)` | Redondea hacia arriba. |
| `floor(double)` | Redondea hacia abajo. |
| `random()` | Devuelve un `double` entre `0.0` incluido y `1.0` excluido. |
| `sin(double)` | Calcula el seno de un ángulo en radianes. |
| `cos(double)` | Calcula el coseno de un ángulo en radianes. |
| `tan(double)` | Calcula la tangente de un ángulo en radianes. |
| `toRadians(double)` | Convierte grados en radianes. |
| `toDegrees(double)` | Convierte radianes en grados. |
| `log(double)` | Calcula el logaritmo natural. |
| `log10(double)` | Calcula el logaritmo en base 10. |
| `exp(double)` | Calcula `e` elevado a una potencia. |
| `hypot(double, double)` | Calcula la hipotenusa a partir de dos catetos. |
| `clamp(...)` | Limita un valor para mantenerlo dentro de un rango. |

## Constantes matemáticas

La clase `Math` proporciona constantes matemáticas.

### `Math.PI`

Representa el número π.

```java
System.out.println(Math.PI);
```

Salida aproximada:

```text
3.141592653589793
```

Podemos utilizarla, por ejemplo, para calcular el área de un círculo:

```java
double radio = 5;

double area =
    Math.PI * Math.pow(radio, 2);

System.out.println(area);
```

### `Math.E`

Representa el número de Euler `e`.

```java
System.out.println(Math.E);
```

Salida aproximada:

```text
2.718281828459045
```

### `Math.TAU`

Java 21 también dispone de la constante `Math.TAU`.

Tau representa una vuelta completa en radianes:

```text
τ = 2π
```

Ejemplo:

```java
System.out.println(Math.TAU);
```

Su valor aproximado es:

```text
6.283185307179586
```

<div class="cla-note"><strong>Para recordar</strong><p><code>Math.PI</code> representa π, <code>Math.E</code> representa el número de Euler y <code>Math.TAU</code> representa τ = 2π.</p></div>

## Valor absoluto: `abs()`

El valor absoluto representa la distancia de un número respecto a cero, sin tener en cuenta su signo.

```java
int numero = -25;

int absoluto = Math.abs(numero);

System.out.println(absoluto);
```

Salida:

```text
25
```

También podemos utilizarlo con otros tipos numéricos:

```java
double numero = -12.75;

double absoluto = Math.abs(numero);

System.out.println(absoluto);
```

Salida:

```text
12.75
```

Ejemplos:

```java
System.out.println(Math.abs(-10));
System.out.println(Math.abs(10));
System.out.println(Math.abs(-3.5));
```

Salida:

```text
10
10
3.5
```

## Raíz cuadrada: `sqrt()`

`sqrt()` calcula la raíz cuadrada de un número.

```java
double resultado = Math.sqrt(64);

System.out.println(resultado);
```

Salida:

```text
8.0
```

Otro ejemplo:

```java
double numero = 25;

System.out.println(Math.sqrt(numero));
```

Salida:

```text
5.0
```

El método devuelve un `double`.

### Raíz cuadrada de un número negativo

Si intentamos calcular:

```java
double resultado = Math.sqrt(-25);

System.out.println(resultado);
```

el resultado es:

```text
NaN
```

`NaN` significa:

```text
Not a Number
```

En los números reales no existe la raíz cuadrada de un número negativo.

## Raíz cúbica: `cbrt()`

`Math.cbrt()` calcula una raíz cúbica.

```java
double resultado = Math.cbrt(27);

System.out.println(resultado);
```

Salida:

```text
3.0
```

También admite valores negativos:

```java
System.out.println(Math.cbrt(-8));
```

Salida:

```text
-2.0
```

## Potencias: `pow()`

`Math.pow(base, exponente)` calcula una potencia.

```java
double resultado =
    Math.pow(2, 3);

System.out.println(resultado);
```

Salida:

```text
8.0
```

Tenemos:

```text
2³ = 8
```

Otro ejemplo:

```java
double cuadrado =
    Math.pow(5, 2);

System.out.println(cuadrado);
```

Salida:

```text
25.0
```

`pow()` devuelve un `double`.

Aunque trabajemos con enteros:

```java
double resultado = Math.pow(10, 2);
```

el resultado sigue siendo de tipo:

```text
double
```

## Calcular áreas con `pow()`

Ejemplo de área de un círculo:

```java
double radio = 4;

double area =
    Math.PI * Math.pow(radio, 2);

System.out.println(area);
```

La fórmula utilizada es:

```text
área = π · r²
```

## Máximo: `max()`

`Math.max()` devuelve el mayor de dos valores.

```java
int mayor = Math.max(10, 20);

System.out.println(mayor);
```

Salida:

```text
20
```

También funciona con otros tipos:

```java
double mayor =
    Math.max(15.7, 10.2);

System.out.println(mayor);
```

Salida:

```text
15.7
```

## Mínimo: `min()`

`Math.min()` devuelve el menor de dos valores.

```java
int menor = Math.min(10, 20);

System.out.println(menor);
```

Salida:

```text
10
```

Ejemplo:

```java
double temperatura1 = 18.5;
double temperatura2 = 22.7;

double minima =
    Math.min(temperatura1, temperatura2);

System.out.println(minima);
```

Salida:

```text
18.5
```

## Redondeo con `round()`

`Math.round()` redondea al entero más cercano.

```java
long resultado = Math.round(9.7);

System.out.println(resultado);
```

Salida:

```text
10
```

Otro ejemplo:

```java
System.out.println(Math.round(9.2));
```

Salida:

```text
9
```

Cuando recibe un `double`, `Math.round()` devuelve un `long`.

```java
double numero = 12.8;

long resultado = Math.round(numero);
```

Cuando recibe un `float`, devuelve un `int`.

## Redondear hacia arriba: `ceil()`

`Math.ceil()` devuelve el menor valor entero matemático que sea mayor o igual que el argumento.

```java
double resultado =
    Math.ceil(9.1);

System.out.println(resultado);
```

Salida:

```text
10.0
```

Otro ejemplo:

```java
System.out.println(Math.ceil(9.9));
```

Salida:

```text
10.0
```

El resultado es de tipo `double`.

## Redondear hacia abajo: `floor()`

`Math.floor()` devuelve el mayor valor entero matemático que sea menor o igual que el argumento.

```java
double resultado =
    Math.floor(9.9);

System.out.println(resultado);
```

Salida:

```text
9.0
```

Otro ejemplo:

```java
System.out.println(Math.floor(9.1));
```

Salida:

```text
9.0
```

## Comparación entre `round()`, `ceil()` y `floor()`

Para:

```java
double numero = 8.6;
```

tenemos:

```java
System.out.println(Math.round(numero));
System.out.println(Math.ceil(numero));
System.out.println(Math.floor(numero));
```

Salida:

```text
9
9.0
8.0
```

Resumen:

| Método | Comportamiento |
| --- | --- |
| `round()` | Redondea al entero más cercano. |
| `ceil()` | Se dirige hacia el entero superior. |
| `floor()` | Se dirige hacia el entero inferior. |

<div class="cla-note"><strong>Atención</strong><p><code>ceil()</code> y <code>floor()</code> devuelven <code>double</code>, aunque el valor obtenido represente matemáticamente un número entero.</p></div>

## Limitar un valor: `clamp()`

Java 21 incorpora métodos `Math.clamp()` para mantener un valor dentro de unos límites.

Por ejemplo:

```java
double temperatura = 150;

double limitada =
    Math.clamp(temperatura, 0, 100);

System.out.println(limitada);
```

Salida:

```text
100.0
```

Si el valor está dentro del rango, se mantiene:

```java
double valor =
    Math.clamp(50, 0, 100);

System.out.println(valor);
```

Salida:

```text
50.0
```

Si está por debajo:

```java
double valor =
    Math.clamp(-20, 0, 100);

System.out.println(valor);
```

Salida:

```text
0.0
```

Esto resulta útil para:

- Porcentajes.
- Volumen.
- Brillo.
- Temperaturas limitadas.
- Coordenadas.
- Valores de interfaces gráficas.

Por ejemplo:

```java
double porcentaje = 135;

porcentaje =
    Math.clamp(porcentaje, 0, 100);

System.out.println(porcentaje);
```

Salida:

```text
100.0
```

## Generar números pseudoaleatorios: `random()`

`Math.random()` devuelve un `double` comprendido en este intervalo:

```text
0.0 <= valor < 1.0
```

Ejemplo:

```java
double aleatorio =
    Math.random();

System.out.println(aleatorio);
```

Una posible salida sería:

```text
0.5832749281
```

El valor cambia entre ejecuciones.

## Número aleatorio entre 0 y 9

Podemos multiplicar por `10`:

```java
double aleatorio =
    Math.random() * 10;

System.out.println(aleatorio);
```

Podríamos obtener:

```text
7.4321
```

Si queremos un entero:

```java
int numero =
    (int) (Math.random() * 10);

System.out.println(numero);
```

Los posibles resultados son:

```text
0
1
2
3
4
5
6
7
8
9
```

## Número aleatorio entre 1 y 10

Podemos sumar `1`:

```java
int numero =
    (int) (Math.random() * 10) + 1;

System.out.println(numero);
```

Ahora los posibles valores son:

```text
1 ... 10
```

## Fórmula para un rango aleatorio

Para obtener un entero entre `min` y `max`, ambos incluidos:

```java
int numero =
    (int) (Math.random() * (max - min + 1))
    + min;
```

Ejemplo entre `5` y `15`:

```java
int min = 5;
int max = 15;

int numero =
    (int) (Math.random() * (max - min + 1))
    + min;

System.out.println(numero);
```

<div class="cla-note"><strong>Nota</strong><p><code>Math.random()</code> resulta cómodo para ejemplos sencillos. Para programas que necesitan un control más explícito de la generación de números aleatorios, Java también dispone de APIs específicas de generación aleatoria.</p></div>

## Trigonometría

La clase `Math` proporciona funciones trigonométricas como:

```java
Math.sin()
Math.cos()
Math.tan()
```

Estas funciones reciben los ángulos en **radianes**, no en grados.

## Seno: `sin()`

```java
double resultado =
    Math.sin(Math.PI / 2);

System.out.println(resultado);
```

Salida:

```text
1.0
```

Porque:

```text
π / 2 radianes = 90 grados
```

## Coseno: `cos()`

```java
double resultado =
    Math.cos(0);

System.out.println(resultado);
```

Salida:

```text
1.0
```

## Tangente: `tan()`

```java
double resultado =
    Math.tan(Math.PI / 4);

System.out.println(resultado);
```

El resultado será aproximadamente:

```text
1.0
```

Debido a la representación en coma flotante, algunas operaciones matemáticas pueden producir aproximaciones muy cercanas al valor esperado.

## Convertir grados a radianes

`Math.toRadians()` convierte grados en radianes.

```java
double grados = 180;

double radianes =
    Math.toRadians(grados);

System.out.println(radianes);
```

Salida aproximada:

```text
3.141592653589793
```

Es decir:

```text
180° = π radianes
```

## Convertir radianes a grados

`Math.toDegrees()` realiza la operación inversa.

```java
double radianes = Math.PI;

double grados =
    Math.toDegrees(radianes);

System.out.println(grados);
```

Salida:

```text
180.0
```

## Trigonometría utilizando grados

Si tenemos un ángulo en grados:

```java
double grados = 30;
```

primero lo convertimos:

```java
double radianes =
    Math.toRadians(grados);
```

Después calculamos:

```java
double seno =
    Math.sin(radianes);

System.out.println(seno);
```

Salida aproximada:

```text
0.5
```

<div class="cla-note"><strong>Regla importante</strong><p><code>sin()</code>, <code>cos()</code> y <code>tan()</code> trabajan con radianes. Si dispones de grados, utiliza primero <code>Math.toRadians()</code>.</p></div>

## Funciones trigonométricas inversas

También existen:

```java
Math.asin()
Math.acos()
Math.atan()
Math.atan2()
```

Por ejemplo:

```java
double radianes =
    Math.asin(1);

double grados =
    Math.toDegrees(radianes);

System.out.println(grados);
```

Salida:

```text
90.0
```

## Logaritmo natural: `log()`

`Math.log()` calcula el logaritmo natural, es decir, en base `e`.

```java
double resultado =
    Math.log(Math.E);

System.out.println(resultado);
```

Salida:

```text
1.0
```

Porque:

```text
ln(e) = 1
```

## Logaritmo en base 10: `log10()`

```java
double resultado =
    Math.log10(1000);

System.out.println(resultado);
```

Salida:

```text
3.0
```

porque:

```text
10³ = 1000
```

## Exponencial: `exp()`

`Math.exp(x)` calcula:

```text
eˣ
```

Ejemplo:

```java
double resultado =
    Math.exp(1);

System.out.println(resultado);
```

El resultado es aproximadamente:

```text
2.718281828459045
```

equivalente a:

```java
Math.E
```

## Calcular una hipotenusa: `hypot()`

`Math.hypot(x, y)` calcula:

```text
√(x² + y²)
```

Resulta útil para aplicar el teorema de Pitágoras.

```java
double catetoA = 3;
double catetoB = 4;

double hipotenusa =
    Math.hypot(catetoA, catetoB);

System.out.println(hipotenusa);
```

Salida:

```text
5.0
```

Podríamos calcular lo mismo mediante:

```java
double hipotenusa =
    Math.sqrt(
        Math.pow(catetoA, 2)
        + Math.pow(catetoB, 2)
    );
```

pero `Math.hypot()` expresa mejor la intención.

## Operaciones exactas y desbordamiento

Los tipos enteros tienen un rango limitado.

Por ejemplo:

```java
int numero = Integer.MAX_VALUE;

System.out.println(numero + 1);
```

produce un desbordamiento.

La clase `Math` dispone de métodos terminados en `Exact` que pueden detectar determinados desbordamientos.

## `addExact()`

```java
int resultado =
    Math.addExact(10, 20);

System.out.println(resultado);
```

Salida:

```text
30
```

Pero:

```java
int resultado =
    Math.addExact(Integer.MAX_VALUE, 1);
```

lanza:

```text
ArithmeticException
```

en lugar de producir silenciosamente un desbordamiento.

## `subtractExact()`

```java
int resultado =
    Math.subtractExact(20, 5);

System.out.println(resultado);
```

Salida:

```text
15
```

## `multiplyExact()`

```java
int resultado =
    Math.multiplyExact(10, 20);

System.out.println(resultado);
```

Salida:

```text
200
```

## `incrementExact()` y `decrementExact()`

```java
int a = Math.incrementExact(9);
int b = Math.decrementExact(9);

System.out.println(a);
System.out.println(b);
```

Salida:

```text
10
8
```

## `negateExact()`

```java
int resultado =
    Math.negateExact(50);

System.out.println(resultado);
```

Salida:

```text
-50
```

<div class="cla-note"><strong>Idea clave</strong><p>Los métodos terminados en <code>Exact</code> son útiles cuando un desbordamiento entero debe detectarse mediante una <code>ArithmeticException</code>.</p></div>

## Ejemplo completo

El siguiente programa utiliza varios de los métodos estudiados:

```java
public class MathExample {

    public static void main(String[] args) {

        // 1. Valor absoluto
        int absoluto =
            Math.abs(-25);

        System.out.println(
            "Valor absoluto: " + absoluto
        );

        // 2. Raíz cuadrada
        double raiz =
            Math.sqrt(64);

        System.out.println(
            "Raíz cuadrada: " + raiz
        );

        // 3. Potencia
        double potencia =
            Math.pow(2, 3);

        System.out.println(
            "2 elevado a 3: " + potencia
        );

        // 4. Aleatorio
        double aleatorio =
            Math.random();

        System.out.println(
            "Aleatorio: " + aleatorio
        );

        // 5. Máximo
        int mayor =
            Math.max(10, 20);

        System.out.println(
            "Mayor: " + mayor
        );

        // 6. Mínimo
        int menor =
            Math.min(10, 20);

        System.out.println(
            "Menor: " + menor
        );

        // 7. Seno de 90 grados
        double seno =
            Math.sin(
                Math.toRadians(90)
            );

        System.out.println(
            "Seno de 90º: " + seno
        );

        // 8. Coseno de 0 grados
        double coseno =
            Math.cos(
                Math.toRadians(0)
            );

        System.out.println(
            "Coseno de 0º: " + coseno
        );

        // 9. Logaritmo natural
        double logaritmo =
            Math.log(Math.E);

        System.out.println(
            "ln(e): " + logaritmo
        );

        // 10. Redondeo
        long redondeado =
            Math.round(9.7);

        System.out.println(
            "Redondeo: " + redondeado
        );

        // 11. Limitar un valor
        double porcentaje =
            Math.clamp(125.0, 0.0, 100.0);

        System.out.println(
            "Porcentaje limitado: "
            + porcentaje
        );

        // 12. Hipotenusa
        double hipotenusa =
            Math.hypot(3, 4);

        System.out.println(
            "Hipotenusa: " + hipotenusa
        );
    }
}
```

Salida aproximada:

```text
Valor absoluto: 25
Raíz cuadrada: 8.0
2 elevado a 3: 8.0
Aleatorio: 0.5832749281
Mayor: 20
Menor: 10
Seno de 90º: 1.0
Coseno de 0º: 1.0
ln(e): 1.0
Redondeo: 10
Porcentaje limitado: 100.0
Hipotenusa: 5.0
```

El número generado mediante `Math.random()` será diferente en distintas ejecuciones.

## Para recordar

- `Math` pertenece a `java.lang`.
- No es necesario importar la clase.
- Sus métodos se utilizan de forma estática.
- `Math.abs()` obtiene el valor absoluto.
- `Math.sqrt()` calcula raíces cuadradas.
- `Math.cbrt()` calcula raíces cúbicas.
- `Math.pow()` calcula potencias.
- `Math.max()` y `Math.min()` comparan dos valores.
- `Math.round()` redondea al entero más cercano.
- `Math.ceil()` redondea hacia arriba.
- `Math.floor()` redondea hacia abajo.
- `Math.clamp()` permite limitar valores a un intervalo.
- `Math.random()` devuelve un valor desde `0.0` incluido hasta `1.0` excluido.
- `Math.sin()`, `Math.cos()` y `Math.tan()` trabajan en radianes.
- `Math.toRadians()` convierte grados en radianes.
- `Math.toDegrees()` convierte radianes en grados.
- `Math.log()` calcula el logaritmo natural.
- `Math.log10()` calcula el logaritmo en base 10.
- `Math.hypot()` permite calcular una hipotenusa.
- `Math.PI`, `Math.E` y `Math.TAU` son constantes matemáticas.
- Los métodos terminados en `Exact` permiten detectar determinados desbordamientos enteros.

## Ejercicio rápido

Indica el resultado de las siguientes operaciones:

```java
Math.abs(-15);

Math.sqrt(81);

Math.pow(3, 2);

Math.max(7, 12);

Math.min(7, 12);

Math.round(5.8);

Math.ceil(5.1);

Math.floor(5.9);

Math.log10(100);

Math.toDegrees(Math.PI);
```

Respuestas:

```text
Math.abs(-15)           -> 15
Math.sqrt(81)           -> 9.0
Math.pow(3, 2)          -> 9.0
Math.max(7, 12)         -> 12
Math.min(7, 12)         -> 7
Math.round(5.8)         -> 6
Math.ceil(5.1)          -> 6.0
Math.floor(5.9)         -> 5.0
Math.log10(100)         -> 2.0
Math.toDegrees(Math.PI) -> 180.0
```

## Práctica guiada del concepto

Crea un programa llamado `CalculadoraMath.java`.

El programa debe:

1. Crear dos números `10` y `25`.
2. Mostrar cuál es el mayor.
3. Mostrar cuál es el menor.
4. Calcular `10` elevado a `2`.
5. Calcular la raíz cuadrada de `25`.
6. Mostrar el valor absoluto de `-25`.
7. Redondear `12.7`.
8. Convertir `180` grados a radianes.
9. Calcular el seno de `90` grados.
10. Generar un entero aleatorio entre `1` y `10`.
11. Limitar el valor `120` al intervalo `0-100`.
12. Calcular la hipotenusa de un triángulo cuyos catetos miden `3` y `4`.

Una posible solución es:

```java
public class CalculadoraMath {

    public static void main(String[] args) {

        int a = 10;
        int b = 25;

        System.out.println(
            "Mayor: " + Math.max(a, b)
        );

        System.out.println(
            "Menor: " + Math.min(a, b)
        );

        System.out.println(
            "10²: " + Math.pow(a, 2)
        );

        System.out.println(
            "Raíz de 25: " + Math.sqrt(b)
        );

        System.out.println(
            "Absoluto de -25: "
            + Math.abs(-25)
        );

        System.out.println(
            "12.7 redondeado: "
            + Math.round(12.7)
        );

        double radianes =
            Math.toRadians(180);

        System.out.println(
            "180º en radianes: "
            + radianes
        );

        double seno =
            Math.sin(
                Math.toRadians(90)
            );

        System.out.println(
            "Seno de 90º: " + seno
        );

        int aleatorio =
            (int) (Math.random() * 10) + 1;

        System.out.println(
            "Aleatorio 1-10: "
            + aleatorio
        );

        double limitado =
            Math.clamp(120.0, 0.0, 100.0);

        System.out.println(
            "120 limitado a 0-100: "
            + limitado
        );

        double hipotenusa =
            Math.hypot(3, 4);

        System.out.println(
            "Hipotenusa: "
            + hipotenusa
        );
    }
}
```

## Prueba tus conocimientos

### Caso 1

```java
System.out.println(
    Math.sqrt(100)
);
```

Salida:

```text
10.0
```

### Caso 2

```java
System.out.println(
    Math.pow(2, 4)
);
```

Salida:

```text
16.0
```

### Caso 3

```java
System.out.println(
    Math.ceil(4.01)
);
```

Salida:

```text
5.0
```

### Caso 4

```java
System.out.println(
    Math.floor(4.99)
);
```

Salida:

```text
4.0
```

### Caso 5

```java
System.out.println(
    Math.round(4.5)
);
```

Salida:

```text
5
```

### Caso 6

```java
double grados = 90;

System.out.println(
    Math.sin(grados)
);
```

Este código no calcula directamente el seno de `90°`.

`sin()` interpreta el valor `90` como **90 radianes**.

Lo correcto sería:

```java
System.out.println(
    Math.sin(
        Math.toRadians(90)
    )
);
```

Resultado:

```text
1.0
```

### Caso 7

```java
double valor =
    Math.random();
```

La variable puede contener:

```text
0.0 <= valor < 1.0
```

Nunca devuelve exactamente `1.0`.

### Caso 8

```java
double resultado =
    Math.sqrt(-9);

System.out.println(resultado);
```

Salida:

```text
NaN
```

### Caso 9

```java
double porcentaje =
    Math.clamp(150.0, 0.0, 100.0);

System.out.println(porcentaje);
```

Salida:

```text
100.0
```

### Caso 10

```java
int resultado =
    Math.addExact(
        Integer.MAX_VALUE,
        1
    );
```

Durante la ejecución se produce:

```text
ArithmeticException
```

porque la suma no puede representarse como un `int`.

## Después de esta lección

Tras completar este apartado debes ser capaz de utilizar la clase `Math` para resolver operaciones matemáticas habituales sin implementar manualmente los cálculos.

Debes manejar especialmente:

```java
Math.abs()
Math.sqrt()
Math.cbrt()
Math.pow()
Math.max()
Math.min()
Math.round()
Math.ceil()
Math.floor()
Math.clamp()
Math.random()
Math.sin()
Math.cos()
Math.tan()
Math.toRadians()
Math.toDegrees()
Math.log()
Math.log10()
Math.hypot()
Math.PI
Math.E
Math.TAU
```

También debes comprender que las funciones trigonométricas trabajan con radianes y que los métodos terminados en `Exact` pueden utilizarse cuando necesitas detectar desbordamientos de enteros.

El siguiente paso es aprender a trabajar con fechas y horas mediante la API `java.time` de Java 21.
