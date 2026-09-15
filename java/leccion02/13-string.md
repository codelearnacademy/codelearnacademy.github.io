---
layout: lesson
route: java
lesson_id: leccion13
lesson_file: 13-string
lesson_number: "13"
title: Clase String en Java
description: Aprende a crear, comparar, buscar, transformar y dividir cadenas de caracteres con la clase String en Java 21.
---

# Clase `String` en Java

La clase `String` representa cadenas de caracteres en Java.

Una cadena puede contener letras, números, espacios, símbolos o cualquier otra secuencia de caracteres.

```java
String nombre = "Ana";
String mensaje = "Hola Mundo";
String codigo = "A-1024";
```

`String` pertenece al paquete `java.lang`, por lo que no es necesario realizar ningún `import` para utilizarla.

```java
public class Main {

    public static void main(String[] args) {

        String mensaje = "Hola, Java 21";

        System.out.println(mensaje);
    }
}
```

Salida:

```text
Hola, Java 21
```

## `String` es una clase

Aunque utilizamos `String` constantemente y su sintaxis parece sencilla, no es un tipo primitivo.

Por ejemplo:

```java
int edad = 25;
String nombre = "Lucía";
```

En este código:

- `int` es un tipo primitivo.
- `String` es una clase.
- `nombre` contiene una referencia a un objeto `String`.

Los literales de texto se escriben entre comillas dobles:

```java
String texto = "Hola";
```

Un único carácter se representa mediante `char` y comillas simples:

```java
char letra = 'H';
```

<div class="cla-note"><strong>Idea clave</strong><p><code>String</code> representa cadenas de caracteres y es una clase. <code>char</code> representa un único carácter y es un tipo primitivo.</p></div>

## Las cadenas son inmutables

Una característica fundamental de `String` es que sus objetos son **inmutables**.

Esto significa que, una vez creado un objeto `String`, su contenido no puede modificarse.

Observa:

```java
String texto = "Hola";

texto.toUpperCase();

System.out.println(texto);
```

Salida:

```text
Hola
```

El método `toUpperCase()` no modifica el objeto original. Devuelve un nuevo `String`.

Para conservar el resultado debemos asignarlo:

```java
String texto = "Hola";

texto = texto.toUpperCase();

System.out.println(texto);
```

Salida:

```text
HOLA
```

Otro ejemplo:

```java
String nombre = "ana";

String mayusculas = nombre.toUpperCase();

System.out.println(nombre);
System.out.println(mayusculas);
```

Salida:

```text
ana
ANA
```

<div class="cla-note"><strong>Regla importante</strong><p>Los métodos de <code>String</code> no modifican la cadena original. Cuando una operación cambia el texto, normalmente devuelve un nuevo objeto <code>String</code>.</p></div>

## Crear cadenas

La forma habitual de crear una cadena es mediante un literal:

```java
String lenguaje = "Java";
```

También existe la posibilidad de utilizar un constructor:

```java
String lenguaje = new String("Java");
```

Sin embargo, para cadenas normales se prefiere:

```java
String lenguaje = "Java";
```

porque es más sencillo y permite aprovechar el tratamiento interno que Java realiza con los literales de cadena.

## Longitud de una cadena: `length()`

El método `length()` devuelve el número de caracteres de una cadena.

```java
String texto = "Java";

int longitud = texto.length();

System.out.println(longitud);
```

Salida:

```text
4
```

Los espacios también cuentan como caracteres:

```java
String texto = "Hola Mundo";

System.out.println(texto.length());
```

Salida:

```text
10
```

En la cadena `"Hola Mundo"` tenemos:

```text
Hola  -> 4 caracteres
espacio -> 1 carácter
Mundo -> 5 caracteres

Total -> 10
```

## Posiciones e índices

Los caracteres de un `String` se numeran comenzando en `0`.

Para:

```text
Java
```

los índices son:

```text
J a v a
0 1 2 3
```

Por tanto, el último índice siempre es:

```text
length() - 1
```

Ejemplo:

```java
String texto = "Java";

int ultimoIndice = texto.length() - 1;

System.out.println(ultimoIndice);
```

Salida:

```text
3
```

## Obtener un carácter: `charAt()`

El método `charAt(int index)` devuelve el carácter situado en una posición determinada.

```java
String texto = "Java";

char letra = texto.charAt(1);

System.out.println(letra);
```

Salida:

```text
a
```

Para obtener el primer carácter:

```java
char primero = texto.charAt(0);
```

Para obtener el último:

```java
char ultimo = texto.charAt(texto.length() - 1);
```

Ejemplo completo:

```java
String texto = "Java";

System.out.println("Primero: " + texto.charAt(0));
System.out.println("Último: " + texto.charAt(texto.length() - 1));
```

Salida:

```text
Primero: J
Último: a
```

### Índices incorrectos

Si intentamos acceder a una posición que no existe:

```java
String texto = "Java";

System.out.println(texto.charAt(10));
```

durante la ejecución se produce una excepción relacionada con un índice fuera de rango.

Por ello, los índices válidos están entre:

```text
0
```

y:

```text
length() - 1
```

## Obtener una subcadena: `substring()`

El método `substring()` permite extraer una parte de una cadena.

### Desde una posición hasta el final

```java
String texto = "Hola Mundo";

String resultado = texto.substring(5);

System.out.println(resultado);
```

Salida:

```text
Mundo
```

### Entre dos posiciones

```java
String texto = "Hola Mundo";

String resultado = texto.substring(0, 4);

System.out.println(resultado);
```

Salida:

```text
Hola
```

El primer índice se incluye y el segundo se excluye.

```text
substring(0, 4)

incluye: 0
incluye: 1
incluye: 2
incluye: 3
excluye: 4
```

<div class="cla-note"><strong>Idea clave</strong><p>En <code>substring(inicio, fin)</code>, el índice inicial se incluye y el índice final no se incluye.</p></div>

## Buscar texto: `indexOf()`

`indexOf()` devuelve la posición de la primera aparición de un carácter o una cadena.

```java
String texto = "Hola Mundo";

int posicion = texto.indexOf("Mundo");

System.out.println(posicion);
```

Salida:

```text
5
```

También podemos buscar un carácter:

```java
String texto = "Java";

System.out.println(texto.indexOf('v'));
```

Salida:

```text
2
```

Si el texto no aparece, `indexOf()` devuelve:

```text
-1
```

Ejemplo:

```java
String texto = "Java";

int posicion = texto.indexOf("Python");

System.out.println(posicion);
```

Salida:

```text
-1
```

Esto permite realizar comprobaciones:

```java
String texto = "Programación en Java";

if (texto.indexOf("Java") != -1) {
    System.out.println("Se ha encontrado Java");
}
```

## Buscar la última aparición: `lastIndexOf()`

`lastIndexOf()` devuelve la posición de la última aparición.

```java
String texto = "Java es Java";

System.out.println(texto.indexOf("Java"));
System.out.println(texto.lastIndexOf("Java"));
```

Salida:

```text
0
8
```

## Comprobar si contiene texto: `contains()`

`contains()` devuelve `true` si una cadena contiene una determinada secuencia de caracteres.

```java
String texto = "Programación en Java";

boolean contiene = texto.contains("Java");

System.out.println(contiene);
```

Salida:

```text
true
```

Ejemplo:

```java
String email = "alumno@example.com";

if (email.contains("@")) {
    System.out.println("El texto contiene una arroba");
}
```

### Buscar un `char` con `contains()`

`contains()` recibe una secuencia de caracteres, no un `char`.

Si tenemos:

```java
char caracter = 'm';
```

podemos convertirlo a `String`:

```java
String texto = "Hola, mundo!";
char caracter = 'm';

boolean contiene = texto.contains(String.valueOf(caracter));

System.out.println(contiene);
```

Salida:

```text
true
```

Otra alternativa es utilizar `indexOf(char)`:

```java
boolean contiene = texto.indexOf(caracter) >= 0;
```

## Comprobar el comienzo y el final

### `startsWith()`

Comprueba si una cadena comienza con un determinado texto.

```java
String url = "https://example.com";

System.out.println(url.startsWith("https://"));
```

Salida:

```text
true
```

### `endsWith()`

Comprueba si termina con un determinado texto.

```java
String archivo = "documento.pdf";

System.out.println(archivo.endsWith(".pdf"));
```

Salida:

```text
true
```

Ejemplo:

```java
String archivo = "imagen.png";

if (archivo.endsWith(".png")) {
    System.out.println("Es una imagen PNG");
}
```

## Convertir a mayúsculas y minúsculas

### `toUpperCase()`

Convierte el contenido a mayúsculas.

```java
String texto = "Hola Mundo";

String resultado = texto.toUpperCase();

System.out.println(resultado);
```

Salida:

```text
HOLA MUNDO
```

### `toLowerCase()`

Convierte el contenido a minúsculas.

```java
String texto = "Hola Mundo";

String resultado = texto.toLowerCase();

System.out.println(resultado);
```

Salida:

```text
hola mundo
```

Recuerda que la cadena original no cambia:

```java
String texto = "Java";

String resultado = texto.toUpperCase();

System.out.println(texto);
System.out.println(resultado);
```

Salida:

```text
Java
JAVA
```

## Eliminar espacios: `trim()` y `strip()`

### `trim()`

`trim()` elimina determinados espacios al principio y al final de una cadena.

```java
String texto = "   Hola Mundo   ";

String limpio = texto.trim();

System.out.println(limpio);
```

Salida:

```text
Hola Mundo
```

### `strip()`

En Java moderno también disponemos de `strip()`.

```java
String texto = "   Hola Mundo   ";

String limpio = texto.strip();

System.out.println(limpio);
```

`strip()` trabaja con una definición más amplia de espacio en blanco basada en caracteres Unicode, por lo que suele ser preferible en código moderno cuando queremos eliminar espacios al inicio y al final.

También existen:

```java
stripLeading()
stripTrailing()
```

Ejemplo:

```java
String texto = "   Java   ";

System.out.println("|" + texto.stripLeading() + "|");
System.out.println("|" + texto.stripTrailing() + "|");
```

## Comprobar si una cadena está vacía

### `isEmpty()`

Devuelve `true` cuando la longitud es `0`.

```java
String texto = "";

System.out.println(texto.isEmpty());
```

Salida:

```text
true
```

Sin embargo:

```java
String texto = "   ";

System.out.println(texto.isEmpty());
```

Salida:

```text
false
```

porque existen caracteres de espacio.

### `isBlank()`

`isBlank()` devuelve `true` cuando la cadena está vacía o contiene únicamente espacios en blanco.

```java
String texto = "   ";

System.out.println(texto.isBlank());
```

Salida:

```text
true
```

Comparación:

```java
String a = "";
String b = "   ";
String c = "Java";

System.out.println(a.isBlank());
System.out.println(b.isBlank());
System.out.println(c.isBlank());
```

Salida:

```text
true
true
false
```

<div class="cla-note"><strong>Para recordar</strong><p><code>isEmpty()</code> comprueba si la longitud es cero. <code>isBlank()</code> también considera vacía una cadena formada únicamente por espacios en blanco.</p></div>

## Reemplazar contenido: `replace()`

`replace()` devuelve una nueva cadena sustituyendo texto por otro.

```java
String texto = "Hola Mundo";

String resultado = texto.replace("Mundo", "Java");

System.out.println(resultado);
```

Salida:

```text
Hola Java
```

También podemos sustituir caracteres:

```java
String texto = "casa";

String resultado = texto.replace('a', 'o');

System.out.println(resultado);
```

Salida:

```text
coso
```

La cadena original sigue siendo la misma.

```java
String texto = "Hola Mundo";

String nuevo = texto.replace("Mundo", "Java");

System.out.println(texto);
System.out.println(nuevo);
```

Salida:

```text
Hola Mundo
Hola Java
```

## Comparar cadenas

Una de las reglas más importantes al trabajar con `String` es conocer la diferencia entre `==` y `equals()`.

### `equals()`

`equals()` compara el contenido de las cadenas.

```java
String texto1 = "Java";
String texto2 = "Java";

System.out.println(texto1.equals(texto2));
```

Salida:

```text
true
```

### No utilizar `==` para comparar el contenido

El operador `==` compara referencias cuando trabajamos con objetos.

Por ejemplo:

```java
String texto1 = new String("Java");
String texto2 = new String("Java");

System.out.println(texto1 == texto2);
System.out.println(texto1.equals(texto2));
```

Salida:

```text
false
true
```

Por tanto, para comprobar si dos cadenas contienen el mismo texto debemos utilizar:

```java
texto1.equals(texto2)
```

<div class="cla-note"><strong>Regla importante</strong><p>Para comparar el contenido de dos objetos <code>String</code>, utiliza <code>equals()</code>. No utilices <code>==</code> para decidir si contienen el mismo texto.</p></div>

## Comparar ignorando mayúsculas y minúsculas

`equalsIgnoreCase()` compara dos cadenas sin distinguir entre mayúsculas y minúsculas.

```java
String a = "java";
String b = "JAVA";

System.out.println(a.equalsIgnoreCase(b));
```

Salida:

```text
true
```

Puede ser útil al procesar opciones introducidas por el usuario:

```java
String respuesta = "SI";

if (respuesta.equalsIgnoreCase("si")) {
    System.out.println("Respuesta afirmativa");
}
```

## Comparación alfabética: `compareTo()`

`compareTo()` compara dos cadenas lexicográficamente.

```java
String a = "Ana";
String b = "Luis";

int resultado = a.compareTo(b);

System.out.println(resultado);
```

Interpretamos el resultado así:

- Valor negativo: la primera cadena aparece antes.
- `0`: ambas cadenas son iguales.
- Valor positivo: la primera cadena aparece después.

No debemos depender del valor numérico exacto, sino de su signo.

Ejemplo:

```java
if (a.compareTo(b) < 0) {
    System.out.println(a + " aparece antes que " + b);
}
```

## Dividir una cadena: `split()`

`split()` divide una cadena en diferentes partes y devuelve un array de `String`.

```java
String texto = "rojo,verde,azul";

String[] colores = texto.split(",");

for (String color : colores) {
    System.out.println(color);
}
```

Salida:

```text
rojo
verde
azul
```

Otro ejemplo:

```java
String nombreCompleto = "Ana García López";

String[] partes = nombreCompleto.split(" ");

for (String parte : partes) {
    System.out.println(parte);
}
```

Salida:

```text
Ana
García
López
```

### `split()` utiliza expresiones regulares

El argumento de `split()` es una **expresión regular**.

Esto es importante porque algunos caracteres tienen un significado especial.

Por ejemplo, para dividir por un punto debemos escaparlo:

```java
String version = "21.0.2";

String[] partes = version.split("\\.");

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

## Concatenar cadenas

Podemos unir cadenas mediante el operador `+`.

```java
String nombre = "Ana";
String apellido = "García";

String completo = nombre + " " + apellido;

System.out.println(completo);
```

Salida:

```text
Ana García
```

También podemos concatenar texto con otros tipos:

```java
String nombre = "Ana";
int edad = 25;

System.out.println(nombre + " tiene " + edad + " años");
```

Salida:

```text
Ana tiene 25 años
```

### Atención al orden de las operaciones

Observa:

```java
System.out.println("Resultado: " + 10 + 20);
```

Salida:

```text
Resultado: 1020
```

Esto ocurre porque, después de encontrar un `String`, Java concatena los valores.

Si queremos realizar primero la suma:

```java
System.out.println("Resultado: " + (10 + 20));
```

Salida:

```text
Resultado: 30
```

## Concatenar con `concat()`

También existe el método `concat()`:

```java
String saludo = "Hola";
String nombre = " Ana";

String mensaje = saludo.concat(nombre);

System.out.println(mensaje);
```

Salida:

```text
Hola Ana
```

Para concatenaciones sencillas suele ser más habitual utilizar `+`.

## Convertir valores a texto: `String.valueOf()`

`String.valueOf()` permite convertir distintos tipos de datos a texto.

```java
int edad = 25;

String texto = String.valueOf(edad);

System.out.println(texto);
```

También:

```java
double precio = 19.95;
boolean activo = true;
char letra = 'A';

String a = String.valueOf(precio);
String b = String.valueOf(activo);
String c = String.valueOf(letra);
```

Ejemplo:

```java
char caracter = 'm';

String textoCaracter = String.valueOf(caracter);

System.out.println(textoCaracter);
```

## Unir varias cadenas: `String.join()`

`String.join()` permite unir varios textos utilizando un separador.

```java
String resultado = String.join(
    ", ",
    "Java",
    "Python",
    "JavaScript"
);

System.out.println(resultado);
```

Salida:

```text
Java, Python, JavaScript
```

Otro ejemplo:

```java
String ruta = String.join(
    "/",
    "usuarios",
    "alumno",
    "documentos"
);

System.out.println(ruta);
```

Salida:

```text
usuarios/alumno/documentos
```

## Repetir texto: `repeat()`

`repeat()` devuelve una cadena repetida varias veces.

```java
String linea = "-".repeat(20);

System.out.println(linea);
```

Salida:

```text
--------------------
```

Otro ejemplo:

```java
String texto = "Java ";

System.out.println(texto.repeat(3));
```

Salida:

```text
Java Java Java 
```

## Formatear cadenas

Java permite construir cadenas con valores utilizando `formatted()`.

```java
String nombre = "Ana";
int edad = 25;

String mensaje = "%s tiene %d años".formatted(nombre, edad);

System.out.println(mensaje);
```

Salida:

```text
Ana tiene 25 años
```

Algunos especificadores habituales son:

| Especificador | Uso |
| --- | --- |
| `%s` | Texto |
| `%d` | Entero |
| `%f` | Número decimal |
| `%n` | Salto de línea |

Ejemplo:

```java
String producto = "Teclado";
double precio = 49.95;

String mensaje = "Producto: %s - Precio: %.2f €"
        .formatted(producto, precio);

System.out.println(mensaje);
```

## Bloques de texto

Java permite representar textos de varias líneas mediante **text blocks**.

Se escriben utilizando tres comillas dobles:

```java
String mensaje = """
        Hola
        Este texto ocupa
        varias líneas
        """;

System.out.println(mensaje);
```

Son especialmente útiles para:

- HTML.
- JSON.
- SQL.
- Mensajes largos.
- Datos de prueba.

Ejemplo:

```java
String html = """
        <html>
            <body>
                <h1>Hola Java</h1>
            </body>
        </html>
        """;
```

## Recorrer los caracteres de un `String`

Podemos utilizar `length()` y `charAt()` para recorrer todos sus caracteres.

```java
String texto = "Java";

for (int i = 0; i < texto.length(); i++) {

    char caracter = texto.charAt(i);

    System.out.println(caracter);
}
```

Salida:

```text
J
a
v
a
```

También podemos mostrar el índice:

```java
String texto = "Java";

for (int i = 0; i < texto.length(); i++) {

    System.out.println(
        i + " -> " + texto.charAt(i)
    );
}
```

Salida:

```text
0 -> J
1 -> a
2 -> v
3 -> a
```

## Contar caracteres

Podemos combinar `charAt()` con un bucle para contar apariciones.

```java
String texto = "programacion";
char buscado = 'a';

int contador = 0;

for (int i = 0; i < texto.length(); i++) {

    if (texto.charAt(i) == buscado) {
        contador++;
    }
}

System.out.println(
    "El carácter aparece " + contador + " veces"
);
```

Salida:

```text
El carácter aparece 2 veces
```

En este caso sí utilizamos `==` porque estamos comparando valores de tipo primitivo `char`, no objetos `String`.

## `String` y `null`

Una variable `String` puede contener `null`.

```java
String texto = null;
```

Pero `null` significa que no existe ningún objeto `String` asociado.

Por tanto:

```java
String texto = null;

System.out.println(texto.length());
```

provoca una:

```text
NullPointerException
```

Podemos comprobarlo previamente:

```java
String texto = null;

if (texto != null) {
    System.out.println(texto.length());
}
```

### Comparaciones seguras frente a `null`

Observa:

```java
String respuesta = null;

if (respuesta.equals("si")) {
    System.out.println("Correcto");
}
```

Este código puede producir `NullPointerException`.

Una alternativa segura cuando comparamos con un literal es:

```java
if ("si".equals(respuesta)) {
    System.out.println("Correcto");
}
```

Si `respuesta` vale `null`, `equals()` simplemente devuelve `false`.

## Métodos importantes de `String`

| Método | Descripción |
| --- | --- |
| `length()` | Devuelve la longitud de la cadena. |
| `charAt(int)` | Devuelve el carácter de una posición. |
| `substring(int)` | Devuelve una subcadena desde un índice hasta el final. |
| `substring(int, int)` | Devuelve una subcadena entre dos índices. |
| `indexOf(...)` | Busca la primera aparición. |
| `lastIndexOf(...)` | Busca la última aparición. |
| `contains(...)` | Comprueba si contiene una secuencia. |
| `startsWith(...)` | Comprueba el comienzo de la cadena. |
| `endsWith(...)` | Comprueba el final de la cadena. |
| `toLowerCase()` | Convierte a minúsculas. |
| `toUpperCase()` | Convierte a mayúsculas. |
| `trim()` | Elimina determinados espacios iniciales y finales. |
| `strip()` | Elimina espacios Unicode iniciales y finales. |
| `stripLeading()` | Elimina espacios al principio. |
| `stripTrailing()` | Elimina espacios al final. |
| `isEmpty()` | Comprueba si la longitud es cero. |
| `isBlank()` | Comprueba si está vacía o solo contiene espacios en blanco. |
| `replace(...)` | Sustituye caracteres o secuencias. |
| `equals(...)` | Compara el contenido de dos cadenas. |
| `equalsIgnoreCase(...)` | Compara ignorando mayúsculas y minúsculas. |
| `compareTo(...)` | Compara lexicográficamente. |
| `split(...)` | Divide una cadena utilizando una expresión regular. |
| `concat(...)` | Concatena dos cadenas. |
| `repeat(int)` | Repite una cadena. |
| `formatted(...)` | Inserta valores utilizando un formato. |
| `String.valueOf(...)` | Convierte un valor a `String`. |
| `String.join(...)` | Une varias cadenas utilizando un separador. |

## Ejemplo completo

El siguiente programa utiliza varios de los métodos estudiados:

```java
public class StringExample {

    public static void main(String[] args) {

        String texto = "  Hola Mundo  ";

        // 1. Longitud
        System.out.println(
            "Longitud: " + texto.length()
        );

        // 2. Obtener un carácter
        char caracter = texto.charAt(7);

        System.out.println(
            "Carácter en la posición 7: " + caracter
        );

        // 3. Subcadena
        String subcadena = texto.substring(2, 6);

        System.out.println(
            "Subcadena: " + subcadena
        );

        // 4. Buscar
        int posicion = texto.indexOf("Mundo");

        System.out.println(
            "Posición de Mundo: " + posicion
        );

        // 5. Minúsculas
        System.out.println(
            texto.toLowerCase()
        );

        // 6. Mayúsculas
        System.out.println(
            texto.toUpperCase()
        );

        // 7. Eliminar espacios
        String limpio = texto.strip();

        System.out.println(
            "Sin espacios: " + limpio
        );

        // 8. Reemplazar
        String reemplazado =
            limpio.replace("Mundo", "Java");

        System.out.println(
            reemplazado
        );

        // 9. Comparar
        String otro = "Hola Mundo";

        System.out.println(
            "Son iguales: " + limpio.equals(otro)
        );

        // 10. Dividir
        String[] partes = limpio.split(" ");

        for (String parte : partes) {
            System.out.println(parte);
        }

        // 11. contains
        char buscado = 'm';

        boolean contiene = limpio
            .toLowerCase()
            .contains(String.valueOf(buscado));

        System.out.println(
            "¿Contiene '" + buscado + "'? " + contiene
        );
    }
}
```

Salida aproximada:

```text
Longitud: 14
Carácter en la posición 7: M
Subcadena: Hola
Posición de Mundo: 7
  hola mundo  
  HOLA MUNDO  
Sin espacios: Hola Mundo
Hola Java
Son iguales: true
Hola
Mundo
¿Contiene 'm'? true
```

## Para recordar

- `String` es una clase, no un tipo primitivo.
- Las cadenas son **inmutables**.
- Los índices comienzan en `0`.
- `length()` devuelve la cantidad de caracteres.
- `charAt()` obtiene un carácter por su posición.
- `substring()` extrae partes de una cadena.
- `indexOf()` devuelve `-1` cuando no encuentra el texto.
- `contains()` permite comprobar si una secuencia aparece dentro de otra.
- `equals()` compara el contenido.
- `==` no debe utilizarse para comparar el contenido de objetos `String`.
- `equalsIgnoreCase()` ignora diferencias entre mayúsculas y minúsculas.
- `strip()` es una alternativa moderna a `trim()`.
- `isBlank()` detecta cadenas vacías o formadas solo por espacios en blanco.
- `split()` devuelve un array de cadenas.
- `String.valueOf()` convierte valores en texto.
- Una variable `String` puede contener `null`.

## Ejercicio rápido

Dado:

```java
String lenguaje = "Programación Java";
```

Indica el resultado de las siguientes expresiones:

```java
lenguaje.length();

lenguaje.charAt(0);

lenguaje.contains("Java");

lenguaje.indexOf("Java");

lenguaje.toUpperCase();

lenguaje.endsWith("Java");
```

Comprueba después tus respuestas ejecutando un programa.

## Práctica guiada del concepto

Crea un programa llamado `AnalizadorTexto.java`.

El programa debe trabajar con:

```java
String texto = "  Java es un lenguaje de programación  ";
```

Realiza las siguientes operaciones:

1. Muestra el texto original.
2. Elimina los espacios iniciales y finales.
3. Muestra la longitud del texto limpio.
4. Comprueba si contiene la palabra `"Java"`.
5. Convierte el texto a mayúsculas.
6. Sustituye `"Java"` por `"Java 21"`.
7. Divide el texto en palabras.
8. Muestra cada palabra en una línea.
9. Muestra el primer carácter.
10. Muestra el último carácter.

Una posible solución es:

```java
public class AnalizadorTexto {

    public static void main(String[] args) {

        String texto =
            "  Java es un lenguaje de programación  ";

        System.out.println(
            "Original: |" + texto + "|"
        );

        String limpio = texto.strip();

        System.out.println(
            "Limpio: |" + limpio + "|"
        );

        System.out.println(
            "Longitud: " + limpio.length()
        );

        System.out.println(
            "Contiene Java: "
            + limpio.contains("Java")
        );

        System.out.println(
            "Mayúsculas: "
            + limpio.toUpperCase()
        );

        String reemplazado =
            limpio.replace("Java", "Java 21");

        System.out.println(
            "Reemplazado: " + reemplazado
        );

        String[] palabras = limpio.split(" ");

        System.out.println("Palabras:");

        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        System.out.println(
            "Primer carácter: "
            + limpio.charAt(0)
        );

        System.out.println(
            "Último carácter: "
            + limpio.charAt(limpio.length() - 1)
        );
    }
}
```

## Prueba tus conocimientos

### Caso 1

```java
String texto = "Java";

texto.toUpperCase();

System.out.println(texto);
```

Resultado:

```text
Java
```

El objeto original no cambia porque `String` es inmutable.

### Caso 2

```java
String texto = "Java";

texto = texto.toUpperCase();

System.out.println(texto);
```

Resultado:

```text
JAVA
```

Ahora guardamos la nueva cadena devuelta por `toUpperCase()`.

### Caso 3

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);
System.out.println(a.equals(b));
```

Resultado:

```text
false
true
```

`==` compara las referencias y `equals()` compara el contenido.

### Caso 4

```java
String texto = "Hola";

System.out.println(texto.indexOf("Java"));
```

Resultado:

```text
-1
```

porque `"Java"` no aparece.

### Caso 5

```java
String texto = "   ";

System.out.println(texto.isEmpty());
System.out.println(texto.isBlank());
```

Resultado:

```text
false
true
```

La cadena contiene caracteres, pero todos ellos son espacios en blanco.

### Caso 6

```java
String texto = null;

System.out.println(texto.length());
```

Durante la ejecución se produce una:

```text
NullPointerException
```

porque no existe ningún objeto sobre el que ejecutar `length()`.

## Después de esta lección

Tras completar este apartado debes ser capaz de crear y manipular cadenas de caracteres utilizando los métodos principales de `String`.

Debes comprender especialmente tres ideas:

1. Los objetos `String` son inmutables.
2. Los índices comienzan en `0`.
3. El contenido de dos cadenas se compara mediante `equals()`, no mediante `==`.

También debes saber utilizar métodos como:

```java
length()
charAt()
substring()
indexOf()
contains()
startsWith()
endsWith()
toUpperCase()
toLowerCase()
strip()
isBlank()
replace()
equals()
equalsIgnoreCase()
split()
repeat()
formatted()
```

Estos métodos aparecen constantemente en programas Java al procesar datos introducidos por usuarios, ficheros, formularios, comunicaciones y cualquier información textual.

El siguiente paso es estudiar con más detalle la clase `Integer` y otras operaciones de conversión y tratamiento de valores enteros.
