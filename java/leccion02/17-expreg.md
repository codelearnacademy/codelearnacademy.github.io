---
layout: lesson
route: java
lesson_id: leccion17
lesson_file: 17-expresiones-regulares
lesson_number: "17"
title: Expresiones regulares en Java
description: Aprende a validar, buscar, extraer, dividir y reemplazar texto mediante expresiones regulares con Pattern y Matcher en Java 21.
---

# Expresiones regulares en Java

Una **expresión regular**, también conocida como *regular expression* o **regex**, es un patrón que permite describir conjuntos de cadenas de texto.

Se utilizan habitualmente para:

- Validar datos.
- Buscar texto.
- Extraer partes de una cadena.
- Sustituir contenido.
- Dividir cadenas.
- Comprobar formatos.
- Analizar entradas de usuario.

Por ejemplo, podemos comprobar si un texto contiene únicamente dígitos:

```java
String texto = "12345";

boolean valido = texto.matches("\\d+");

System.out.println(valido);
```

Salida:

```text
true
```

La expresión regular:

```text
\d+
```

significa:

```text
uno o más dígitos
```

En Java debemos escribir:

```java
"\\d+"
```

porque la barra invertida `\` también tiene un significado especial dentro de los literales `String`.

<div class="cla-note"><strong>Idea clave</strong><p>Una expresión regular describe un patrón de texto. En Java, muchas expresiones necesitan duplicar la barra invertida porque primero son interpretadas como un <code>String</code> y después como una expresión regular.</p></div>


## Tabla de metacaracteres de expresiones regulares

Los **metacaracteres** son símbolos que tienen un significado especial dentro de una expresión regular.

En Java debemos tener especialmente en cuenta la barra invertida `\`, ya que dentro de un `String` debe escribirse normalmente como `\\`.

| Metacarácter | En Java | Significado | Ejemplo | Coincide con |
| --- | --- | --- | --- | --- |
| `.` | `"."` | Cualquier carácter | `a.c` | `abc`, `a1c`, `a-c` |
| `\d` | `"\\d"` | Un dígito | `\d` | `0`, `5`, `9` |
| `\D` | `"\\D"` | Un carácter que no sea dígito | `\D` | `A`, `#`, `-` |
| `\w` | `"\\w"` | Letra, dígito o `_` | `\w` | `A`, `7`, `_` |
| `\W` | `"\\W"` | Carácter que no pertenece a `\w` | `\W` | `@`, `-`, espacio |
| `\s` | `"\\s"` | Espacio en blanco | `\s` | espacio, tabulador |
| `\S` | `"\\S"` | No espacio en blanco | `\S` | `A`, `8`, `@` |
| `[abc]` | `"[abc]"` | Uno de los caracteres indicados | `[abc]` | `a`, `b`, `c` |
| `[^abc]` | `"[^abc]"` | Cualquier carácter excepto los indicados | `[^abc]` | `d`, `7`, `@` |
| `[a-z]` | `"[a-z]"` | Letra minúscula entre `a` y `z` | `[a-z]` | `a`, `m`, `z` |
| `[A-Z]` | `"[A-Z]"` | Letra mayúscula | `[A-Z]` | `A`, `M`, `Z` |
| `[0-9]` | `"[0-9]"` | Dígito entre `0` y `9` | `[0-9]` | `0`, `4`, `9` |
| `?` | `"?"` | Cero o una aparición | `colou?r` | `color`, `colour` |
| `*` | `"*"` | Cero o más apariciones | `a*` | ``, `a`, `aaa` |
| `+` | `"+"` | Una o más apariciones | `a+` | `a`, `aa`, `aaaa` |
| `{n}` | `"{n}"` | Exactamente `n` apariciones | `\d{5}` | `38001` |
| `{n,}` | `"{n,}"` | Como mínimo `n` apariciones | `\d{3,}` | `123`, `12345` |
| `{n,m}` | `"{n,m}"` | Entre `n` y `m` apariciones | `\d{2,4}` | `12`, `123`, `1234` |
| `^` | `"^"` | Inicio de cadena | `^Java` | `Java 21` |
| `$` | `"$"` | Final de cadena | `Java$` | `Aprende Java` |
| `|` | `"|"` | Alternativa lógica OR | `Java|Python` | `Java`, `Python` |
| `()` | `"()"` | Agrupa elementos | `(Java|Python)` | `Java`, `Python` |
| `(?:...)` | `"(?:...)"` | Grupo sin captura | `(?:Java|Python)` | `Java`, `Python` |
| `\.` | `"\\."` | Punto literal | `\.` | `.` |
| `\\` | `"\\\\"` | Barra invertida literal | `\\` | `\` |

### Ejemplos básicos

Un solo dígito:

```java
String regex = "\\d";
```

Coincide con:

```text
0
5
9
```

No coincide con:

```text
10
A
```

Uno o más dígitos:

```java
String regex = "\\d+";
```

Coincide con:

```text
1
123
987654
```

Tres dígitos exactamente:

```java
String regex = "\\d{3}";
```

Coincide con:

```text
123
999
001
```

No coincide con:

```text
12
1234
ABC
```

## Combinación de metacaracteres

La verdadera potencia de las expresiones regulares aparece cuando combinamos diferentes elementos.

### Una letra seguida de tres números

Regex:

```text
[A-Z]\d{3}
```

Java:

```java
String regex = "[A-Z]\\d{3}";
```

Coincide con:

```text
A123
B456
Z999
```

No coincide con:

```text
AA123
A12
a123
```

### Tres letras y cuatro números

Regex:

```text
[A-Z]{3}\d{4}
```

Java:

```java
String regex = "[A-Z]{3}\\d{4}";
```

Coincide con:

```text
ABC1234
XYZ9876
```

### Código con guion

Formato:

```text
ABC-1234
```

Regex:

```text
[A-Z]{3}-\d{4}
```

Java:

```java
String regex =
    "[A-Z]{3}-\\d{4}";
```

Ejemplo:

```java
String codigo = "ABC-1234";

System.out.println(
    codigo.matches(
        "[A-Z]{3}-\\d{4}"
    )
);
```

Salida:

```text
true
```

### Palabra formada únicamente por letras

Regex:

```text
[A-Za-z]+
```

Java:

```java
String regex =
    "[A-Za-z]+";
```

Coincide con:

```text
Java
Programacion
Alumno
```

No coincide con:

```text
Java21
Alumno_1
```

Para admitir letras Unicode como `á`, `ñ` o `ü` es preferible:

```java
String regex =
    "\\p{L}+";
```

### Letras y números

Regex:

```text
[A-Za-z0-9]+
```

Java:

```java
String regex =
    "[A-Za-z0-9]+";
```

Coincide con:

```text
Java21
Alumno2026
ABC123
```

### Letras, números y guion bajo

Regex:

```text
[A-Za-z0-9_]+
```

Java:

```java
String regex =
    "[A-Za-z0-9_]+";
```

Coincide con:

```text
alumno
alumno21
alumno_21
```

## Ejemplos típicos de expresiones regulares

### Código postal

Un código postal de cinco dígitos:

Regex:

```text
^\d{5}$
```

Java:

```java
String regex =
    "^\\d{5}$";
```

Ejemplo:

```java
String codigoPostal = "38001";

boolean valido =
    codigoPostal.matches(
        "^\\d{5}$"
    );

System.out.println(valido);
```

Salida:

```text
true
```

Coinciden:

```text
38001
28080
35001
```

No coinciden:

```text
3800
380001
38A01
```

### Teléfono de nueve cifras

Regex:

```text
^\d{9}$
```

Java:

```java
String regex =
    "^\\d{9}$";
```

Ejemplo:

```java
String telefono =
    "612345678";

boolean valido =
    telefono.matches(
        "^\\d{9}$"
    );
```

Coinciden:

```text
612345678
922123456
```

No coinciden:

```text
61234567
612-345-678
+34612345678
```

### Teléfono móvil español sencillo

Si queremos exigir que empiece por `6` o `7`:

Regex:

```text
^[67]\d{8}$
```

Java:

```java
String regex =
    "^[67]\\d{8}$";
```

Coinciden:

```text
612345678
712345678
```

No coinciden:

```text
512345678
61234567
```

### DNI español: formato

Un DNI tiene:

```text
8 números + una letra
```

Una expresión sencilla sería:

```text
^\d{8}[A-Z]$
```

Java:

```java
String regex =
    "^\\d{8}[A-Z]$";
```

Ejemplo:

```java
String dni = "12345678Z";

boolean formatoCorrecto =
    dni.matches(
        "^\\d{8}[A-Z]$"
    );
```

Podemos limitar las letras a las utilizadas por el algoritmo de control del DNI:

```text
^\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]$
```

Java:

```java
String regex =
    "^\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
```

<div class="cla-note"><strong>Importante</strong><p>Esta expresión regular únicamente comprueba el formato del DNI. No garantiza que la letra corresponda realmente a los ocho números. La letra de control debe calcularse mediante el algoritmo del DNI.</p></div>

### NIE: formato básico

Los NIE suelen comenzar por:

```text
X
Y
Z
```

seguidos de siete números y una letra.

Regex:

```text
^[XYZ]\d{7}[A-Z]$
```

Java:

```java
String regex =
    "^[XYZ]\\d{7}[A-Z]$";
```

Ejemplo de estructura:

```text
X1234567L
```

### Correo electrónico sencillo

Una expresión regular habitual para validaciones básicas es:

```text
^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$
```

Java:

```java
String regex =
    "^[A-Za-z0-9._%+-]+"
    + "@[A-Za-z0-9.-]+"
    + "\\.[A-Za-z]{2,}$";
```

Ejemplo:

```java
String email =
    "alumno@example.com";

boolean valido =
    email.matches(
        "^[A-Za-z0-9._%+-]+"
        + "@[A-Za-z0-9.-]+"
        + "\\.[A-Za-z]{2,}$"
    );

System.out.println(valido);
```

Salida:

```text
true
```

Coinciden:

```text
alumno@example.com
nombre.apellido@gmail.com
usuario21@centro.es
nombre+prueba@example.org
```

No coinciden:

```text
alumno@
@example.com
alumno@example
```

<div class="cla-note"><strong>Importante</strong><p>La sintaxis real de las direcciones de correo electrónico admite muchos casos especiales. Esta regex es adecuada como ejemplo didáctico o validación básica, pero no implementa por completo todos los formatos permitidos por los estándares de correo.</p></div>

### URL sencilla

Para aceptar URLs que comiencen por:

```text
http://
https://
```

podemos utilizar:

```text
^https?://(?:www\.)?[A-Za-z0-9.-]+\.[A-Za-z]{2,}(?:/\S*)?$
```

En Java:

```java
String regex =
    "^https?://"
    + "(?:www\\.)?"
    + "[A-Za-z0-9.-]+"
    + "\\.[A-Za-z]{2,}"
    + "(?:/\\S*)?$";
```

Ejemplos válidos:

```text
https://example.com
http://example.com
https://www.example.com
https://example.com/cursos/java
```

Ejemplo:

```java
String url =
    "https://www.example.com/java";

boolean valida =
    url.matches(
        "^https?://"
        + "(?:www\\.)?"
        + "[A-Za-z0-9.-]+"
        + "\\.[A-Za-z]{2,}"
        + "(?:/\\S*)?$"
    );

System.out.println(valida);
```

Salida:

```text
true
```

<div class="cla-note"><strong>Importante</strong><p>Las URLs reales pueden tener puertos, parámetros, fragmentos, caracteres escapados, direcciones IP y muchos otros elementos. En aplicaciones reales suele ser preferible utilizar clases como <code>URI</code> o <code>URL</code> para analizarlas.</p></div>

### Nombre de usuario

Supongamos estas reglas:

- Entre 4 y 12 caracteres.
- Letras.
- Números.
- Guion bajo.

Regex:

```text
^[A-Za-z0-9_]{4,12}$
```

Java:

```java
String regex =
    "^[A-Za-z0-9_]{4,12}$";
```

Coinciden:

```text
juan
juan21
juan_21
alumno2026
```

No coinciden:

```text
abc
juan-perez
este_nombre_es_demasiado_largo
```

### Usuario que debe comenzar por una letra

Regex:

```text
^[A-Za-z][A-Za-z0-9_]{3,11}$
```

Java:

```java
String regex =
    "^[A-Za-z][A-Za-z0-9_]{3,11}$";
```

Coinciden:

```text
juan
juan21
a_123
```

No coinciden:

```text
1juan
_juan
abc
```

### Contraseña sencilla

Supongamos:

- Entre 8 y 20 caracteres.
- Al menos una letra.
- Al menos un número.

Regex:

```text
^(?=.*[A-Za-z])(?=.*\d).{8,20}$
```

Java:

```java
String regex =
    "^(?=.*[A-Za-z])"
    + "(?=.*\\d)"
    + ".{8,20}$";
```

Coinciden:

```text
Java2026
clave1234
Programacion21
```

No coinciden:

```text
abcdefgh
12345678
Java21
```

Si queremos además una mayúscula, una minúscula y un número:

```text
^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,20}$
```

Java:

```java
String regex =
    "^(?=.*[a-z])"
    + "(?=.*[A-Z])"
    + "(?=.*\\d)"
    + ".{8,20}$";
```

### Fecha con formato `dd/mm/aaaa`

Regex:

```text
^\d{2}/\d{2}/\d{4}$
```

Java:

```java
String regex =
    "^\\d{2}/\\d{2}/\\d{4}$";
```

Coincide:

```text
11/09/2026
01/01/2025
```

Pero también podría aceptar:

```text
99/99/2026
```

porque únicamente estamos comprobando el formato.

<div class="cla-note"><strong>Importante</strong><p>Para validar que una fecha existe realmente debes utilizar la API <code>java.time</code>. Una expresión regular es adecuada para comprobar la estructura, pero no para sustituir el procesamiento real de fechas.</p></div>

### Hora con formato `hh:mm`

Regex:

```text
^(?:[01]\d|2[0-3]):[0-5]\d$
```

Java:

```java
String regex =
    "^(?:[01]\\d|2[0-3]):"
    + "[0-5]\\d$";
```

Coinciden:

```text
00:00
09:30
18:45
23:59
```

No coinciden:

```text
24:00
18:75
9:30
```

### Número entero positivo

Regex:

```text
^\d+$
```

Java:

```java
String regex =
    "^\\d+$";
```

Coinciden:

```text
0
1
25
10000
```

### Número entero con signo opcional

Regex:

```text
^[+-]?\d+$
```

Java:

```java
String regex =
    "^[+-]?\\d+$";
```

Coinciden:

```text
10
-10
+10
0
```

### Número decimal

Regex:

```text
^[+-]?\d+(?:\.\d+)?$
```

Java:

```java
String regex =
    "^[+-]?\\d+"
    + "(?:\\.\\d+)?$";
```

Coinciden:

```text
10
10.5
-20.75
+3.14
```

No coinciden:

```text
10.
.25
ABC
```

### Matrícula española moderna

El formato habitual es:

```text
4 números + 3 letras
```

Ejemplo:

```text
1234BCD
```

Regex:

```text
^\d{4}[B-DF-HJ-NP-TV-Z]{3}$
```

Java:

```java
String regex =
    "^\\d{4}"
    + "[B-DF-HJ-NP-TV-Z]{3}$";
```

Ejemplo:

```java
String matricula =
    "1234BCD";

System.out.println(
    matricula.matches(
        "^\\d{4}"
        + "[B-DF-HJ-NP-TV-Z]{3}$"
    )
);
```

Salida:

```text
true
```

### Dirección IPv4: ejemplo didáctico

Una versión muy sencilla:

```text
^\d{1,3}(?:\.\d{1,3}){3}$
```

Java:

```java
String regex =
    "^\\d{1,3}"
    + "(?:\\.\\d{1,3}){3}$";
```

Coincide estructuralmente con:

```text
192.168.1.1
10.0.0.1
```

Pero también:

```text
999.999.999.999
```

Por tanto, comprueba la estructura, pero no el rango válido `0-255`.

### Fichero con extensión concreta

Para comprobar si un fichero termina en `.pdf`:

Regex:

```text
^.+\.pdf$
```

Java:

```java
String regex =
    "^.+\\.pdf$";
```

Coinciden:

```text
documento.pdf
factura.pdf
tema01.pdf
```

También podemos ignorar mayúsculas y minúsculas:

```java
String regex =
    "(?i)^.+\\.pdf$";
```

Ahora coinciden:

```text
documento.pdf
documento.PDF
Documento.Pdf
```

# Combinaciones frecuentes

| Objetivo | Regex | Java |
| --- | --- | --- |
| Solo números | `^\d+$` | `"^\\d+$"` |
| Exactamente 5 números | `^\d{5}$` | `"^\\d{5}$"` |
| Solo letras ASCII | `^[A-Za-z]+$` | `"^[A-Za-z]+$"` |
| Letras Unicode | `^\p{L}+$` | `"^\\p{L}+$"` |
| Letras y números | `^[A-Za-z0-9]+$` | `"^[A-Za-z0-9]+$"` |
| Alfanumérico y `_` | `^\w+$` | `"^\\w+$"` |
| Entero con signo | `^[+-]?\d+$` | `"^[+-]?\\d+$"` |
| Decimal | `^[+-]?\d+(?:\.\d+)?$` | `"^[+-]?\\d+(?:\\.\\d+)?$"` |
| Código postal | `^\d{5}$` | `"^\\d{5}$"` |
| Teléfono 9 cifras | `^\d{9}$` | `"^\\d{9}$"` |
| DNI formato | `^\d{8}[A-Z]$` | `"^\\d{8}[A-Z]$"` |
| Usuario 4-12 caracteres | `^[A-Za-z0-9_]{4,12}$` | `"^[A-Za-z0-9_]{4,12}$"` |
| Fecha `dd/mm/aaaa` | `^\d{2}/\d{2}/\d{4}$` | `"^\\d{2}/\\d{2}/\\d{4}$"` |
| Hora `hh:mm` | `^(?:[01]\d|2[0-3]):[0-5]\d$` | `"^(?:[01]\\d|2[0-3]):[0-5]\\d$"` |
| Código `ABC-1234` | `^[A-Z]{3}-\d{4}$` | `"^[A-Z]{3}-\\d{4}$"` |
| Archivo PDF | `(?i)^.+\.pdf$` | `"(?i)^.+\\.pdf$"` |

## Ejemplo de validador con varios patrones

```java
public class Validador {

    public static void main(String[] args) {

        String email =
            "alumno@example.com";

        String dni =
            "12345678Z";

        String telefono =
            "612345678";

        String codigoPostal =
            "38001";

        String fecha =
            "11/09/2026";

        String usuario =
            "alumno_21";

        System.out.println(
            "Email: "
            + email.matches(
                "^[A-Za-z0-9._%+-]+"
                + "@[A-Za-z0-9.-]+"
                + "\\.[A-Za-z]{2,}$"
            )
        );

        System.out.println(
            "DNI: "
            + dni.matches(
                "^\\d{8}"
                + "[TRWAGMYFPDXBNJZSQVHLCKE]$"
            )
        );

        System.out.println(
            "Teléfono: "
            + telefono.matches(
                "^[67]\\d{8}$"
            )
        );

        System.out.println(
            "Código postal: "
            + codigoPostal.matches(
                "^\\d{5}$"
            )
        );

        System.out.println(
            "Fecha: "
            + fecha.matches(
                "^\\d{2}/"
                + "\\d{2}/"
                + "\\d{4}$"
            )
        );

        System.out.println(
            "Usuario: "
            + usuario.matches(
                "^[A-Za-z]"
                + "[A-Za-z0-9_]{3,11}$"
            )
        );
    }
}
```

Una posible salida sería:

```text
Email: true
DNI: true
Teléfono: true
Código postal: true
Fecha: true
Usuario: true
```

## Regla final

Conviene distinguir entre:

```text
validar formato
```

y:

```text
validar el dato
```

Por ejemplo, una regex puede comprobar el formato de un DNI, pero para comprobarlo completamente debemos calcular su letra.

En una fecha, una regex puede comprobar `dd/mm/aaaa`, pero `java.time` debe comprobar que la fecha existe realmente.

Y para una URL, una expresión regular puede realizar una comprobación básica, pero para analizar una URL real es preferible utilizar las clases específicas de Java.

<div class="cla-note"><strong>Idea clave</strong><p>Las expresiones regulares son excelentes para reconocer estructuras de texto. No debemos convertirlas en sustitutos de las APIs especializadas cuando necesitamos validar el significado real de los datos.</p></div>


## ¿Dónde se utilizan las expresiones regulares en Java?

Java permite trabajar con expresiones regulares principalmente mediante:

```java
java.util.regex.Pattern
java.util.regex.Matcher
```

También existen métodos de `String` que utilizan expresiones regulares:

```java
matches()
split()
replaceAll()
replaceFirst()
```

Ejemplo:

```java
String texto = "12345";

System.out.println(
    texto.matches("\\d+")
);
```

Salida:

```text
true
```

## Importar `Pattern` y `Matcher`

Las clases relacionadas con expresiones regulares pertenecen al paquete:

```text
java.util.regex
```

Por tanto, cuando utilizamos `Pattern` y `Matcher` debemos importarlas:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;
```

También podemos importar todas las clases de ese paquete:

```java
import java.util.regex.*;
```

## Expresión regular frente a cadena Java

Este es uno de los puntos que más confusión genera.

Supongamos que queremos utilizar esta expresión regular:

```text
\d+
```

que significa:

```text
uno o más dígitos
```

Dentro de un `String` Java debemos escribir:

```java
"\\d+"
```

Esto ocurre porque:

```text
\d+
```

es la expresión regular.

Pero Java interpreta primero el literal:

```java
"\\d+"
```

y produce internamente:

```text
\d+
```

que después interpreta el motor de expresiones regulares.

Otro ejemplo:

Expresión regular:

```text
\w+
```

En Java:

```java
"\\w+"
```

<div class="cla-note"><strong>Regla importante</strong><p>Cuando una expresión regular contiene una barra invertida, normalmente debes escribirla duplicada dentro de un literal <code>String</code> de Java.</p></div>

## Caracteres literales

La expresión regular más sencilla es un texto literal.

```java
String texto = "Java";

System.out.println(
    texto.matches("Java")
);
```

Salida:

```text
true
```

Mientras que:

```java
String texto = "Java 21";

System.out.println(
    texto.matches("Java")
);
```

devuelve:

```text
false
```

porque `matches()` exige que **toda la cadena** coincida con el patrón.

## `matches()`

El método:

```java
String.matches(String regex)
```

comprueba si toda la cadena coincide con una expresión regular.

Ejemplo:

```java
String codigo = "12345";

boolean valido =
    codigo.matches("\\d+");

System.out.println(valido);
```

Salida:

```text
true
```

Sin embargo:

```java
String codigo = "ABC123";

System.out.println(
    codigo.matches("\\d+")
);
```

Salida:

```text
false
```

porque la cadena contiene letras.

## `matches()` comprueba toda la cadena

Observa:

```java
String texto = "Mi número es 123";

System.out.println(
    texto.matches("\\d+")
);
```

Salida:

```text
false
```

Aunque existe una parte numérica, el texto completo no está formado únicamente por dígitos.

Si queremos **buscar** un patrón dentro de un texto, normalmente utilizaremos `Matcher.find()`.

## Clases de caracteres

Las clases de caracteres permiten representar grupos de caracteres.

### `\d`

Representa un dígito.

Expresión regular:

```text
\d
```

En Java:

```java
"\\d"
```

Ejemplo:

```java
System.out.println(
    "5".matches("\\d")
);
```

Salida:

```text
true
```

Pero:

```java
System.out.println(
    "55".matches("\\d")
);
```

Salida:

```text
false
```

porque `\d` representa un único dígito.

## `\D`

Representa un carácter que no es un dígito.

Java:

```java
"\\D"
```

Ejemplo:

```java
System.out.println(
    "A".matches("\\D")
);
```

Salida:

```text
true
```

## `\w`

Representa un carácter considerado de palabra por el motor de expresiones regulares en su configuración habitual.

Suele utilizarse para letras, dígitos y guion bajo.

Java:

```java
"\\w"
```

Ejemplo:

```java
System.out.println(
    "A".matches("\\w")
);
```

Salida:

```text
true
```

## `\W`

Representa un carácter que no pertenece a `\w`.

```java
System.out.println(
    "#".matches("\\W")
);
```

Salida:

```text
true
```

## `\s`

Representa un carácter de espacio en blanco.

Java:

```java
"\\s"
```

Ejemplo:

```java
System.out.println(
    " ".matches("\\s")
);
```

Salida:

```text
true
```

## `\S`

Representa un carácter que no es espacio en blanco.

```java
System.out.println(
    "A".matches("\\S")
);
```

Salida:

```text
true
```

## Resumen de clases de caracteres

| Expresión | Java | Significado |
| --- | --- | --- |
| `\d` | `"\\d"` | Dígito |
| `\D` | `"\\D"` | No dígito |
| `\w` | `"\\w"` | Carácter de palabra |
| `\W` | `"\\W"` | No carácter de palabra |
| `\s` | `"\\s"` | Espacio en blanco |
| `\S` | `"\\S"` | No espacio en blanco |
| `.` | `"."` | Casi cualquier carácter |

## El punto `.`

El punto representa normalmente cualquier carácter excepto determinados terminadores de línea.

```java
System.out.println(
    "A".matches(".")
);
```

Salida:

```text
true
```

También:

```java
System.out.println(
    "7".matches(".")
);
```

Salida:

```text
true
```

## Corchetes `[]`

Los corchetes permiten definir un conjunto de caracteres permitidos.

Por ejemplo:

```text
[abc]
```

significa:

```text
a, b o c
```

Ejemplo:

```java
System.out.println(
    "a".matches("[abc]")
);
```

Salida:

```text
true
```

Pero:

```java
System.out.println(
    "d".matches("[abc]")
);
```

Salida:

```text
false
```

## Rangos de caracteres

Podemos definir rangos dentro de los corchetes.

### Letras minúsculas

```text
[a-z]
```

Ejemplo:

```java
System.out.println(
    "m".matches("[a-z]")
);
```

Salida:

```text
true
```

### Letras mayúsculas

```text
[A-Z]
```

### Dígitos

```text
[0-9]
```

Ejemplo:

```java
System.out.println(
    "7".matches("[0-9]")
);
```

Salida:

```text
true
```

## Combinar rangos

Podemos combinar varios rangos:

```text
[a-zA-Z0-9]
```

Permite una letra mayúscula, una minúscula o un dígito.

Ejemplo:

```java
String caracter = "G";

System.out.println(
    caracter.matches("[a-zA-Z0-9]")
);
```

Salida:

```text
true
```

## Negación dentro de corchetes

El símbolo `^` al principio de una clase de caracteres indica negación.

```text
[^0-9]
```

significa:

```text
cualquier carácter que no sea un dígito
```

Ejemplo:

```java
System.out.println(
    "A".matches("[^0-9]")
);
```

Salida:

```text
true
```

## Cuantificadores

Los cuantificadores indican cuántas veces puede aparecer un elemento.

Los principales son:

| Cuantificador | Significado |
| --- | --- |
| `?` | Cero o una vez |
| `*` | Cero o más veces |
| `+` | Una o más veces |
| `{n}` | Exactamente `n` veces |
| `{n,}` | `n` o más veces |
| `{n,m}` | Entre `n` y `m` veces |

## `?`: cero o una vez

Ejemplo:

```text
colou?r
```

acepta:

```text
color
colour
```

porque la `u` puede aparecer cero o una vez.

En Java:

```java
System.out.println(
    "color".matches("colou?r")
);

System.out.println(
    "colour".matches("colou?r")
);
```

Ambos resultados son:

```text
true
```

## `*`: cero o más veces

```text
a*
```

acepta:

```text
cadena vacía
a
aa
aaa
...
```

Ejemplo:

```java
System.out.println(
    "aaaa".matches("a*")
);
```

Salida:

```text
true
```

## `+`: una o más veces

```text
a+
```

requiere al menos una `a`.

```java
System.out.println(
    "aaaa".matches("a+")
);
```

Salida:

```text
true
```

Pero una cadena vacía no coincide.

El patrón:

```text
\d+
```

significa:

```text
uno o más dígitos
```

En Java:

```java
String numero = "123456";

System.out.println(
    numero.matches("\\d+")
);
```

Salida:

```text
true
```

## `{n}`: número exacto

```text
\d{5}
```

significa:

```text
exactamente cinco dígitos
```

En Java:

```java
String codigo = "12345";

System.out.println(
    codigo.matches("\\d{5}")
);
```

Salida:

```text
true
```

Para:

```java
String codigo = "1234";
```

el resultado sería:

```text
false
```

## `{n,}`: mínimo de repeticiones

```text
\d{3,}
```

significa:

```text
tres o más dígitos
```

Ejemplo:

```java
System.out.println(
    "123456".matches("\\d{3,}")
);
```

Salida:

```text
true
```

## `{n,m}`: intervalo de repeticiones

```text
\d{2,4}
```

acepta entre dos y cuatro dígitos.

Ejemplo:

```java
System.out.println(
    "123".matches("\\d{2,4}")
);
```

Salida:

```text
true
```

## Anclas

Las anclas permiten indicar posiciones dentro del texto.

Las más conocidas son:

```text
^
$
```

### `^`

Representa el comienzo de la cadena o línea, según el modo.

### `$`

Representa el final.

Ejemplo:

```text
^\d{5}$
```

representa una cadena formada exactamente por cinco dígitos.

En Java:

```java
String codigo = "12345";

boolean valido =
    codigo.matches("^\\d{5}$");

System.out.println(valido);
```

Salida:

```text
true
```

Con `String.matches()` los anclajes suelen ser redundantes para muchas validaciones porque `matches()` ya intenta hacer coincidir toda la cadena, pero siguen siendo habituales para expresar de forma explícita la intención del patrón.

## Alternativas con `|`

El símbolo:

```text
|
```

significa:

```text
o
```

Ejemplo:

```text
rojo|verde|azul
```

En Java:

```java
String color = "verde";

System.out.println(
    color.matches("rojo|verde|azul")
);
```

Salida:

```text
true
```

## Grupos con paréntesis

Los paréntesis permiten agrupar partes de una expresión.

Por ejemplo:

```text
(Java|Python)
```

acepta:

```text
Java
Python
```

En Java:

```java
String lenguaje = "Java";

System.out.println(
    lenguaje.matches("(Java|Python)")
);
```

Salida:

```text
true
```

Los grupos también permiten aplicar cuantificadores a una secuencia completa.

Por ejemplo:

```text
(ab)+
```

acepta:

```text
ab
abab
ababab
```

## Validar un código postal sencillo

Un código postal español puede representarse de forma básica como cinco dígitos:

```text
\d{5}
```

En Java:

```java
String codigoPostal = "38001";

boolean valido =
    codigoPostal.matches("\\d{5}");

System.out.println(valido);
```

Salida:

```text
true
```

Este patrón comprueba únicamente la estructura de cinco dígitos, no si el código postal existe realmente.

<div class="cla-note"><strong>Importante</strong><p>Una expresión regular normalmente valida el <strong>formato</strong> de un dato. No garantiza necesariamente que el dato exista o sea válido desde el punto de vista del negocio.</p></div>

## Validar un número de teléfono sencillo

Por ejemplo, nueve dígitos:

```text
\d{9}
```

En Java:

```java
String telefono = "612345678";

boolean valido =
    telefono.matches("\\d{9}");

System.out.println(valido);
```

Salida:

```text
true
```

## Validar letras

Podemos exigir que un texto contenga únicamente letras ASCII:

```text
[a-zA-Z]+
```

En Java:

```java
String nombre = "Carlos";

boolean valido =
    nombre.matches("[a-zA-Z]+");

System.out.println(valido);
```

Salida:

```text
true
```

Sin embargo, este patrón no acepta directamente letras como:

```text
á
é
í
ó
ú
ñ
```

Para textos humanos internacionales conviene tener en cuenta Unicode.

## Propiedades Unicode

Java permite utilizar propiedades Unicode en expresiones regulares.

Por ejemplo:

```text
\p{L}
```

representa una letra Unicode.

Dentro de Java:

```java
String nombre = "Álvaro";

boolean valido =
    nombre.matches("\\p{L}+");

System.out.println(valido);
```

Salida:

```text
true
```

Otro ejemplo:

```java
String nombre = "María José";

boolean valido =
    nombre.matches("[\\p{L} ]+");

System.out.println(valido);
```

Este patrón permite letras Unicode y espacios.

## Validar un identificador sencillo

Supongamos que queremos:

- Primera posición: letra.
- Resto: letras, números o `_`.
- Longitud mínima: 3 caracteres.

Podemos utilizar:

```text
[A-Za-z][A-Za-z0-9_]{2,}
```

En Java:

```java
String usuario = "alumno_21";

boolean valido =
    usuario.matches(
        "[A-Za-z][A-Za-z0-9_]{2,}"
    );

System.out.println(valido);
```

Salida:

```text
true
```

## Validar una contraseña por estructura

Supongamos una regla sencilla:

- Entre 8 y 20 caracteres.
- Al menos una letra.
- Al menos un dígito.

Podemos utilizar anticipaciones (*lookaheads*):

```text
(?=.*[A-Za-z])(?=.*\d).{8,20}
```

En Java:

```java
String password = "Java2026";

boolean valida =
    password.matches(
        "(?=.*[A-Za-z])(?=.*\\d).{8,20}"
    );

System.out.println(valida);
```

Salida:

```text
true
```

Este ejemplo sirve para estudiar regex, aunque en aplicaciones reales las reglas de contraseñas deben diseñarse con cuidado y no depender únicamente de requisitos arbitrarios de complejidad.

## Validación básica de correo electrónico

Podemos crear una expresión regular sencilla como:

```text
^[\w.+-]+@[\w.-]+\.[A-Za-z]{2,}$
```

En Java:

```java
String email =
    "alumno@example.com";

boolean valido =
    email.matches(
        "^[\\w.+-]+@[\\w.-]+\\.[A-Za-z]{2,}$"
    );

System.out.println(valido);
```

Salida:

```text
true
```

Este patrón es útil como ejemplo didáctico, pero no pretende implementar completamente todas las reglas posibles de las direcciones de correo electrónico.

<div class="cla-note"><strong>Idea clave</strong><p>Para datos complejos como correos electrónicos, URLs o fechas, evita asumir que una expresión regular sencilla cubre todos los casos válidos posibles. En muchos contextos existen APIs específicas más apropiadas.</p></div>

# `Pattern`

Para operaciones más completas utilizamos la clase:

```java
Pattern
```

Primero importamos:

```java
import java.util.regex.Pattern;
```

Después compilamos la expresión:

```java
Pattern patron =
    Pattern.compile("\\d+");
```

Un objeto `Pattern` representa una expresión regular compilada.

## Crear un `Pattern`

Ejemplo:

```java
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Pattern patron =
            Pattern.compile("\\d+");

        System.out.println(patron.pattern());
    }
}
```

Salida:

```text
\d+
```

## Ventaja de reutilizar `Pattern`

Si vamos a aplicar la misma expresión muchas veces, podemos compilarla una sola vez.

```java
Pattern patron =
    Pattern.compile("\\d{5}");
```

Después podemos utilizarla sobre distintos textos.

```java
boolean a =
    patron.matcher("38001").matches();

boolean b =
    patron.matcher("123").matches();
```

Esto evita tener que volver a definir conceptualmente el patrón en cada comprobación.

# `Matcher`

La clase `Matcher` aplica un `Pattern` sobre un texto.

Importamos:

```java
import java.util.regex.Matcher;
```

Ejemplo:

```java
Pattern patron =
    Pattern.compile("\\d+");

Matcher matcher =
    patron.matcher("12345");
```

Después podemos comprobar:

```java
boolean coincide =
    matcher.matches();
```

## Ejemplo con `Pattern` y `Matcher`

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {

        Pattern patron =
            Pattern.compile("\\d{5}");

        Matcher matcher =
            patron.matcher("38001");

        if (matcher.matches()) {
            System.out.println(
                "Formato correcto"
            );
        } else {
            System.out.println(
                "Formato incorrecto"
            );
        }
    }
}
```

Salida:

```text
Formato correcto
```

## `matches()` de `Matcher`

`Matcher.matches()` comprueba si **todo el texto** coincide con el patrón.

```java
Pattern patron =
    Pattern.compile("\\d+");

Matcher matcher =
    patron.matcher("12345");

System.out.println(
    matcher.matches()
);
```

Salida:

```text
true
```

Pero:

```java
Matcher matcher =
    patron.matcher("abc12345");
```

produce:

```text
false
```

# Buscar con `find()`

`find()` busca la siguiente parte del texto que coincide con el patrón.

Ejemplo:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {

        String texto =
            "Pedido 123, producto 456";

        Pattern patron =
            Pattern.compile("\\d+");

        Matcher matcher =
            patron.matcher(texto);

        while (matcher.find()) {

            System.out.println(
                matcher.group()
            );
        }
    }
}
```

Salida:

```text
123
456
```

Esto es diferente de `matches()`.

```text
matches() -> comprueba todo el texto
find()    -> busca coincidencias dentro del texto
```

<div class="cla-note"><strong>Regla importante</strong><p>Utiliza <code>matches()</code> cuando quieras validar el texto completo y <code>find()</code> cuando quieras localizar partes que coinciden dentro de un texto más grande.</p></div>

## Obtener la coincidencia con `group()`

Después de que `find()` encuentre una coincidencia:

```java
matcher.group()
```

devuelve el texto encontrado.

Ejemplo:

```java
String texto =
    "La temperatura es 25 grados";

Pattern patron =
    Pattern.compile("\\d+");

Matcher matcher =
    patron.matcher(texto);

if (matcher.find()) {

    System.out.println(
        matcher.group()
    );
}
```

Salida:

```text
25
```

## Posición de una coincidencia

Podemos obtener la posición inicial y final.

```java
matcher.start()
matcher.end()
```

Ejemplo:

```java
String texto = "ABC 123 XYZ";

Pattern patron =
    Pattern.compile("\\d+");

Matcher matcher =
    patron.matcher(texto);

if (matcher.find()) {

    System.out.println(
        "Texto: " + matcher.group()
    );

    System.out.println(
        "Inicio: " + matcher.start()
    );

    System.out.println(
        "Fin: " + matcher.end()
    );
}
```

Salida:

```text
Texto: 123
Inicio: 4
Fin: 7
```

El índice devuelto por `end()` corresponde a la primera posición posterior a la coincidencia.

## Encontrar todas las coincidencias

```java
String texto =
    "Productos: 10, 25, 30 y 100";

Pattern patron =
    Pattern.compile("\\d+");

Matcher matcher =
    patron.matcher(texto);

while (matcher.find()) {

    System.out.println(
        "Número encontrado: "
        + matcher.group()
    );
}
```

Salida:

```text
Número encontrado: 10
Número encontrado: 25
Número encontrado: 30
Número encontrado: 100
```

# Grupos de captura

Los paréntesis permiten crear **grupos de captura**.

Por ejemplo:

```text
(\d{2})/(\d{2})/(\d{4})
```

Podría representar una fecha con este formato:

```text
11/09/2026
```

En Java:

```java
Pattern patron =
    Pattern.compile(
        "(\\d{2})/(\\d{2})/(\\d{4})"
    );
```

Podemos recuperar cada grupo:

```java
String texto = "11/09/2026";

Matcher matcher =
    patron.matcher(texto);

if (matcher.matches()) {

    System.out.println(
        matcher.group(1)
    );

    System.out.println(
        matcher.group(2)
    );

    System.out.println(
        matcher.group(3)
    );
}
```

Salida:

```text
11
09
2026
```

Tenemos:

```text
group(0) -> coincidencia completa
group(1) -> primer grupo
group(2) -> segundo grupo
group(3) -> tercer grupo
```

## Ejemplo completo con grupos

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FechaRegex {

    public static void main(String[] args) {

        String fecha = "11/09/2026";

        Pattern patron =
            Pattern.compile(
                "(\\d{2})/(\\d{2})/(\\d{4})"
            );

        Matcher matcher =
            patron.matcher(fecha);

        if (matcher.matches()) {

            String dia =
                matcher.group(1);

            String mes =
                matcher.group(2);

            String anio =
                matcher.group(3);

            System.out.println(
                "Día: " + dia
            );

            System.out.println(
                "Mes: " + mes
            );

            System.out.println(
                "Año: " + anio
            );
        }
    }
}
```

<div class="cla-note"><strong>Importante</strong><p>Este patrón comprueba la estructura <code>dd/mm/aaaa</code>, pero no verifica que la fecha exista. Por ejemplo, una regex sencilla podría aceptar <code>99/99/2026</code>. Para validar fechas reales es preferible utilizar la API <code>java.time</code>.</p></div>

# Grupos con nombre

Java permite asignar nombres a grupos de captura.

Sintaxis:

```text
(?<nombre>...)
```

Ejemplo:

```java
Pattern patron =
    Pattern.compile(
        "(?<dia>\\d{2})/"
        + "(?<mes>\\d{2})/"
        + "(?<anio>\\d{4})"
    );
```

Después:

```java
Matcher matcher =
    patron.matcher("11/09/2026");

if (matcher.matches()) {

    System.out.println(
        matcher.group("dia")
    );

    System.out.println(
        matcher.group("mes")
    );

    System.out.println(
        matcher.group("anio")
    );
}
```

Salida:

```text
11
09
2026
```

Los nombres pueden hacer que determinados patrones complejos sean más legibles.

# Grupos no capturantes

Si necesitamos agrupar elementos pero no queremos guardar el grupo, podemos utilizar:

```text
(?:...)
```

Ejemplo:

```text
(?:Java|Python)
```

Esto agrupa las alternativas sin crear un grupo de captura convencional.

# `replaceAll()`

El método:

```java
replaceAll(regex, reemplazo)
```

reemplaza todas las coincidencias.

Ejemplo:

```java
String texto =
    "Pedido 123, factura 456";

String resultado =
    texto.replaceAll(
        "\\d+",
        "XXX"
    );

System.out.println(resultado);
```

Salida:

```text
Pedido XXX, factura XXX
```

## Eliminar varios espacios

Podemos sustituir una o más apariciones de espacio en blanco por un único espacio:

```java
String texto =
    "Java    es    interesante";

String limpio =
    texto.replaceAll(
        "\\s+",
        " "
    );

System.out.println(limpio);
```

Salida:

```text
Java es interesante
```

## Eliminar caracteres no numéricos

```java
String texto =
    "Tel: 612-345-678";

String numero =
    texto.replaceAll(
        "\\D",
        ""
    );

System.out.println(numero);
```

Salida:

```text
612345678
```

# `replaceFirst()`

`replaceFirst()` sustituye únicamente la primera coincidencia.

```java
String texto =
    "123 456 789";

String resultado =
    texto.replaceFirst(
        "\\d+",
        "XXX"
    );

System.out.println(resultado);
```

Salida:

```text
XXX 456 789
```

# `split()`

El método `String.split()` utiliza una expresión regular para dividir texto.

Ejemplo:

```java
String texto =
    "Java,Python,C++";

String[] lenguajes =
    texto.split(",");

for (String lenguaje : lenguajes) {
    System.out.println(lenguaje);
}
```

Salida:

```text
Java
Python
C++
```

## Dividir usando varios espacios

```java
String texto =
    "Java   Python    C++";

String[] partes =
    texto.split("\\s+");

for (String parte : partes) {
    System.out.println(parte);
}
```

Salida:

```text
Java
Python
C++
```

## El punto es un metacarácter

Si queremos dividir:

```text
21.0.2
```

por los puntos, no debemos utilizar simplemente:

```java
split(".")
```

porque `.` significa cualquier carácter en regex.

Debemos escapar el punto.

La regex es:

```text
\.
```

En Java:

```java
"\\."
```

Ejemplo:

```java
String version =
    "21.0.2";

String[] partes =
    version.split("\\.");

for (String parte : partes) {
    System.out.println(parte);
}
```

Salida:

```text
21
0
2
```

# Metacaracteres

Algunos caracteres tienen significado especial en las expresiones regulares.

Entre ellos:

```text
.
^
$
*
+
?
(
)
[
]
{
}
|
\
```

Si queremos interpretar uno de ellos literalmente, normalmente tendremos que escaparlo.

Por ejemplo, para buscar un punto literal:

Regex:

```text
\.
```

Java:

```java
"\\."
```

## `Pattern.quote()`

Si tenemos texto que queremos tratar literalmente, podemos utilizar:

```java
Pattern.quote()
```

Ejemplo:

```java
String separador = ".";

String regex =
    Pattern.quote(separador);

String[] partes =
    "21.0.2".split(regex);
```

Esto evita tener que conocer manualmente si el texto contiene metacaracteres.

Ejemplo completo:

```java
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String separador = ".";

        String[] partes =
            "21.0.2".split(
                Pattern.quote(separador)
            );

        for (String parte : partes) {
            System.out.println(parte);
        }
    }
}
```

# Ignorar mayúsculas y minúsculas

Podemos compilar un patrón utilizando:

```java
Pattern.CASE_INSENSITIVE
```

Ejemplo:

```java
Pattern patron =
    Pattern.compile(
        "java",
        Pattern.CASE_INSENSITIVE
    );

Matcher matcher =
    patron.matcher("JAVA");

System.out.println(
    matcher.matches()
);
```

Salida:

```text
true
```

También puede utilizarse una bandera dentro de la propia expresión:

```text
(?i)
```

Ejemplo:

```java
String texto = "JAVA";

System.out.println(
    texto.matches("(?i)java")
);
```

Salida:

```text
true
```

# `PatternSyntaxException`

Si una expresión regular tiene una sintaxis incorrecta, Java puede lanzar:

```text
PatternSyntaxException
```

Ejemplo:

```java
Pattern patron =
    Pattern.compile("[abc");
```

Falta cerrar:

```text
]
```

Durante la ejecución se producirá un error de sintaxis de expresión regular.

Podemos tratarlo:

```java
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {

    public static void main(String[] args) {

        try {

            Pattern patron =
                Pattern.compile("[abc");

        } catch (PatternSyntaxException e) {

            System.out.println(
                "Expresión regular incorrecta"
            );
        }
    }
}
```

# Cuantificadores codiciosos

Por defecto, muchos cuantificadores son **codiciosos** (*greedy*).

Intentan abarcar la mayor cantidad de texto posible.

Por ejemplo:

```text
<.*>
```

aplicado a:

```text
<b>Java</b><i>21</i>
```

puede abarcar desde el primer `<` hasta el último `>`.

## Cuantificadores perezosos

Podemos utilizar:

```text
*?
+?
??
```

para hacerlos menos codiciosos.

Por ejemplo:

```text
<.*?>
```

intenta detenerse en el primer `>` posible.

Este concepto resulta útil al estudiar patrones más avanzados.

# Anticipaciones: lookahead

Una anticipación positiva utiliza:

```text
(?=...)
```

Comprueba que algo aparece a continuación sin consumirlo como parte de la coincidencia.

Por ejemplo:

```text
\d+(?=€)
```

busca un número seguido de `€`.

Java:

```java
String texto =
    "Precio: 25€";

Pattern patron =
    Pattern.compile("\\d+(?=€)");

Matcher matcher =
    patron.matcher(texto);

if (matcher.find()) {
    System.out.println(
        matcher.group()
    );
}
```

Salida:

```text
25
```

# Anticipación negativa

Se escribe:

```text
(?!...)
```

Comprueba que algo no aparezca a continuación.

Es una herramienta más avanzada y suele utilizarse en patrones de validación complejos.

# Validar matrículas o códigos

Supongamos un código con:

```text
3 letras + guion + 4 dígitos
```

Ejemplo:

```text
ABC-1234
```

Regex:

```text
[A-Z]{3}-\d{4}
```

Java:

```java
String codigo =
    "ABC-1234";

boolean valido =
    codigo.matches(
        "[A-Z]{3}-\\d{4}"
    );

System.out.println(valido);
```

Salida:

```text
true
```

# Validar un nombre de usuario

Reglas:

- Entre 4 y 12 caracteres.
- Letras.
- Números.
- Guion bajo.

Regex:

```text
[A-Za-z0-9_]{4,12}
```

Java:

```java
String usuario =
    "alumno_21";

boolean valido =
    usuario.matches(
        "[A-Za-z0-9_]{4,12}"
    );

System.out.println(valido);
```

Salida:

```text
true
```

# Buscar números en un texto

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BuscarNumeros {

    public static void main(String[] args) {

        String texto =
            "Ana tiene 20 años y Luis 25";

        Pattern patron =
            Pattern.compile("\\d+");

        Matcher matcher =
            patron.matcher(texto);

        while (matcher.find()) {

            System.out.println(
                "Encontrado: "
                + matcher.group()
            );
        }
    }
}
```

Salida:

```text
Encontrado: 20
Encontrado: 25
```

# Extraer palabras

Podemos buscar secuencias de letras Unicode:

```java
Pattern patron =
    Pattern.compile("\\p{L}+");
```

Ejemplo:

```java
String texto =
    "Java 21 es muy útil";

Matcher matcher =
    patron.matcher(texto);

while (matcher.find()) {
    System.out.println(
        matcher.group()
    );
}
```

Salida:

```text
Java
es
muy
útil
```

# Ejemplo completo

El siguiente programa combina validación, búsqueda, grupos y reemplazo:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExample {

    public static void main(String[] args) {

        // 1. Validar código postal
        String codigoPostal = "38001";

        boolean cpValido =
            codigoPostal.matches("\\d{5}");

        System.out.println(
            "Código postal válido: "
            + cpValido
        );

        // 2. Validar usuario
        String usuario = "alumno_21";

        boolean usuarioValido =
            usuario.matches(
                "[A-Za-z][A-Za-z0-9_]{2,}"
            );

        System.out.println(
            "Usuario válido: "
            + usuarioValido
        );

        // 3. Buscar números
        String texto =
            "Pedidos 123, 456 y 789";

        Pattern patronNumeros =
            Pattern.compile("\\d+");

        Matcher matcherNumeros =
            patronNumeros.matcher(texto);

        while (matcherNumeros.find()) {

            System.out.println(
                "Número encontrado: "
                + matcherNumeros.group()
            );
        }

        // 4. Extraer grupos
        String fecha = "11/09/2026";

        Pattern patronFecha =
            Pattern.compile(
                "(\\d{2})/(\\d{2})/(\\d{4})"
            );

        Matcher matcherFecha =
            patronFecha.matcher(fecha);

        if (matcherFecha.matches()) {

            System.out.println(
                "Día: "
                + matcherFecha.group(1)
            );

            System.out.println(
                "Mes: "
                + matcherFecha.group(2)
            );

            System.out.println(
                "Año: "
                + matcherFecha.group(3)
            );
        }

        // 5. Reemplazar números
        String anonimizado =
            texto.replaceAll(
                "\\d+",
                "XXX"
            );

        System.out.println(
            anonimizado
        );

        // 6. Limpiar espacios
        String frase =
            "Java     es    sencillo";

        String limpia =
            frase.replaceAll(
                "\\s+",
                " "
            );

        System.out.println(
            limpia
        );
    }
}
```

Salida:

```text
Código postal válido: true
Usuario válido: true
Número encontrado: 123
Número encontrado: 456
Número encontrado: 789
Día: 11
Mes: 09
Año: 2026
Pedidos XXX, XXX y XXX
Java es sencillo
```

# Tabla de referencia rápida

| Expresión | Significado |
| --- | --- |
| `.` | Cualquier carácter, salvo ciertas excepciones de salto de línea |
| `\d` | Dígito |
| `\D` | No dígito |
| `\w` | Carácter de palabra |
| `\W` | No carácter de palabra |
| `\s` | Espacio en blanco |
| `\S` | No espacio en blanco |
| `[abc]` | `a`, `b` o `c` |
| `[^abc]` | Cualquier carácter excepto `a`, `b` o `c` |
| `[a-z]` | Letra entre `a` y `z` |
| `[A-Z]` | Letra entre `A` y `Z` |
| `[0-9]` | Dígito entre `0` y `9` |
| `?` | Cero o una vez |
| `*` | Cero o más |
| `+` | Una o más |
| `{n}` | Exactamente `n` |
| `{n,}` | Al menos `n` |
| `{n,m}` | Entre `n` y `m` |
| `^` | Inicio |
| `$` | Final |
| `a|b` | `a` o `b` |
| `(abc)` | Grupo de captura |
| `(?:abc)` | Grupo no capturante |
| `(?<x>abc)` | Grupo con nombre |
| `(?=abc)` | Lookahead positivo |
| `(?!abc)` | Lookahead negativo |

# Java y las barras invertidas

Una tabla especialmente importante:

| Regex deseada | Código Java |
| --- | --- |
| `\d+` | `"\\d+"` |
| `\s+` | `"\\s+"` |
| `\w+` | `"\\w+"` |
| `\.` | `"\\."` |
| `\d{5}` | `"\\d{5}"` |
| `\p{L}+` | `"\\p{L}+"` |

<div class="cla-note"><strong>Para recordar</strong><p>Cuando copies una expresión regular desde una herramienta externa, recuerda que posiblemente tendrás que escapar de nuevo las barras invertidas para convertirla en un literal <code>String</code> válido de Java.</p></div>

# Buenas prácticas

Al trabajar con expresiones regulares conviene:

- Mantener los patrones sencillos siempre que sea posible.
- Utilizar nombres descriptivos para las variables.
- Separar patrones complejos en constantes.
- Añadir comentarios cuando una regex no sea evidente.
- Utilizar `Pattern` si el patrón se reutiliza muchas veces.
- No utilizar regex para problemas que tienen una API específica más apropiada.
- Probar casos válidos y no válidos.
- Tener cuidado con entradas extremadamente grandes o patrones innecesariamente complejos.
- Recordar que validar formato no equivale a validar significado.

Ejemplo de constante:

```java
private static final Pattern CODIGO_POSTAL =
    Pattern.compile("\\d{5}");
```

Después:

```java
boolean valido =
    CODIGO_POSTAL
        .matcher("38001")
        .matches();
```

# Para recordar

- Una expresión regular describe un patrón de texto.
- En Java se utilizan principalmente `Pattern` y `Matcher`.
- `String.matches()` comprueba toda la cadena.
- `Matcher.matches()` también comprueba toda la entrada.
- `Matcher.find()` busca coincidencias dentro del texto.
- `Matcher.group()` devuelve el texto encontrado.
- `Matcher.start()` y `Matcher.end()` permiten conocer posiciones.
- Los grupos permiten extraer partes de una coincidencia.
- `replaceAll()` sustituye todas las coincidencias.
- `replaceFirst()` sustituye únicamente la primera.
- `split()` utiliza expresiones regulares.
- `\d` representa dígitos.
- `\s` representa espacios en blanco.
- `\w` representa caracteres de palabra.
- `+`, `*`, `?` y `{n,m}` son cuantificadores.
- `[]` define clases de caracteres.
- `()` permite agrupar.
- `|` representa alternativas.
- En Java debemos duplicar muchas barras invertidas.
- `Pattern.quote()` permite tratar texto como literal.
- Una regex valida normalmente la estructura, no necesariamente el significado real de un dato.

# Ejercicio rápido

Indica qué cadenas coinciden con cada patrón.

## Patrón 1

```java
"\\d{3}"
```

Cadenas:

```text
123
12
ABC
999
```

Respuesta:

```text
123 -> true
12  -> false
ABC -> false
999 -> true
```

## Patrón 2

```java
"[A-Z]{2}\\d{2}"
```

Cadenas:

```text
AB12
Ab12
XY99
ABC1
```

Respuesta:

```text
AB12 -> true
Ab12 -> false
XY99 -> true
ABC1 -> false
```

## Patrón 3

```java
"[A-Za-z]+"
```

Cadenas:

```text
Java
Java21
Python
123
```

Respuesta:

```text
Java   -> true
Java21 -> false
Python -> true
123    -> false
```

# Práctica guiada del concepto

Crea un programa llamado:

```text
ValidadorRegex.java
```

El programa debe:

1. Validar un código postal de cinco dígitos.
2. Validar un teléfono de nueve dígitos.
3. Validar un usuario formado por letras, números y `_`.
4. Buscar todos los números dentro de una frase.
5. Extraer día, mes y año de una fecha con formato `dd/mm/aaaa`.
6. Sustituir todos los números encontrados en un texto por `XXX`.
7. Reducir secuencias de varios espacios a uno solo.

Una posible solución es:

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidadorRegex {

    public static void main(String[] args) {

        // Código postal
        String codigoPostal = "38001";

        System.out.println(
            "CP válido: "
            + codigoPostal.matches("\\d{5}")
        );

        // Teléfono
        String telefono = "612345678";

        System.out.println(
            "Teléfono válido: "
            + telefono.matches("\\d{9}")
        );

        // Usuario
        String usuario = "alumno_21";

        System.out.println(
            "Usuario válido: "
            + usuario.matches(
                "[A-Za-z0-9_]{4,12}"
            )
        );

        // Buscar números
        String texto =
            "Pedidos 12, 35 y 900";

        Pattern patron =
            Pattern.compile("\\d+");

        Matcher matcher =
            patron.matcher(texto);

        while (matcher.find()) {

            System.out.println(
                "Encontrado: "
                + matcher.group()
            );
        }

        // Extraer fecha
        String fecha =
            "11/09/2026";

        Pattern patronFecha =
            Pattern.compile(
                "(\\d{2})/(\\d{2})/(\\d{4})"
            );

        Matcher matcherFecha =
            patronFecha.matcher(fecha);

        if (matcherFecha.matches()) {

            System.out.println(
                "Día: "
                + matcherFecha.group(1)
            );

            System.out.println(
                "Mes: "
                + matcherFecha.group(2)
            );

            System.out.println(
                "Año: "
                + matcherFecha.group(3)
            );
        }

        // Anonimizar números
        String anonimizado =
            texto.replaceAll(
                "\\d+",
                "XXX"
            );

        System.out.println(
            anonimizado
        );

        // Limpiar espacios
        String frase =
            "Java      21    regex";

        String limpia =
            frase.replaceAll(
                "\\s+",
                " "
            );

        System.out.println(
            limpia
        );
    }
}
```

Salida aproximada:

```text
CP válido: true
Teléfono válido: true
Usuario válido: true
Encontrado: 12
Encontrado: 35
Encontrado: 900
Día: 11
Mes: 09
Año: 2026
Pedidos XXX, XXX y XXX
Java 21 regex
```

# Prueba tus conocimientos

## Caso 1

```java
String texto = "12345";

System.out.println(
    texto.matches("\\d+")
);
```

Salida:

```text
true
```

porque todos los caracteres son dígitos.

## Caso 2

```java
String texto = "ABC123";

System.out.println(
    texto.matches("\\d+")
);
```

Salida:

```text
false
```

porque `matches()` intenta hacer coincidir toda la cadena.

## Caso 3

```java
Pattern patron =
    Pattern.compile("\\d+");

Matcher matcher =
    patron.matcher("ABC123XYZ");

System.out.println(
    matcher.find()
);
```

Salida:

```text
true
```

porque `find()` busca una coincidencia dentro del texto.

## Caso 4

```java
String texto =
    "Java    21";

String resultado =
    texto.replaceAll(
        "\\s+",
        " "
    );

System.out.println(resultado);
```

Salida:

```text
Java 21
```

## Caso 5

```java
String version = "21.0.2";

String[] partes =
    version.split("\\.");
```

El array contiene:

```text
21
0
2
```

## Caso 6

```java
String codigo =
    "AB-1234";

boolean valido =
    codigo.matches(
        "[A-Z]{2}-\\d{4}"
    );

System.out.println(valido);
```

Salida:

```text
true
```

## Caso 7

```java
Pattern patron =
    Pattern.compile(
        "(\\d{2})/(\\d{2})/(\\d{4})"
    );

Matcher matcher =
    patron.matcher("11/09/2026");

if (matcher.matches()) {
    System.out.println(
        matcher.group(2)
    );
}
```

Salida:

```text
09
```

porque `group(2)` corresponde al segundo grupo de captura.

## Caso 8

```java
Pattern patron =
    Pattern.compile("[abc");
```

Durante la ejecución se produce una:

```text
PatternSyntaxException
```

porque la expresión regular está incompleta.

# Después de esta lección

Tras completar este apartado debes ser capaz de utilizar expresiones regulares para validar, buscar, extraer y reemplazar información textual.

Debes manejar especialmente:

```java
String.matches()
String.split()
String.replaceAll()
String.replaceFirst()
Pattern.compile()
Pattern.matcher()
Matcher.matches()
Matcher.find()
Matcher.group()
Matcher.start()
Matcher.end()
```

También debes comprender patrones como:

```text
\d+
[A-Z]{3}
[A-Za-z0-9_]+
\s+
(\d{2})/(\d{2})/(\d{4})
```

y su representación dentro de Java:

```java
"\\d+"
"[A-Z]{3}"
"[A-Za-z0-9_]+"
"\\s+"
"(\\d{2})/(\\d{2})/(\\d{4})"
```

Las expresiones regulares son especialmente útiles para procesar texto, validar formatos y extraer información, pero deben utilizarse con moderación: cuando Java proporciona una API específica para un tipo de dato, como fechas y horas, suele ser preferible combinar una validación estructural sencilla con esa API especializada.
