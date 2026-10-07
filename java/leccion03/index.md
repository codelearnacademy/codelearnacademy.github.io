---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: Estructuras de control
search_title: Lección 03 - Estructuras de control
search_description: Practicarás estructuras condicionales y repetitivas para controlar el flujo de ejecución.
description: Controlarás el flujo de ejecución y depurarás programas Java.
lessons:
  - id: condiciones
    title: Condiciones
  - id: bucles
    title: Bucles
  - id: excepciones-y-depuracion
    title: Excepciones y depuración
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion03/
---

## Condiciones

Las estructuras `if`, `else` y `switch` permiten seleccionar un camino según el estado del programa.

```java
int nota = 7;
String resultado = nota >= 5 ? "Aprobado" : "Pendiente";
System.out.println(resultado);

String día = "sábado";
switch (día) {
  case "sábado", "domingo" -> System.out.println("Descanso");
  default -> System.out.println("Clase");
}
```

## Bucles

Usa `for` cuando conoces el recorrido, `while` cuando depende de una condición y `do-while` cuando debe ejecutarse al menos una vez.

```java
int suma = 0;
for (int número = 1; número <= 5; número++) {
  suma += número;
}
System.out.println(suma);

int intentos = 0;
while (intentos < 3) {
  System.out.println("Intento " + (++intentos));
}
```

`break` termina el bucle y `continue` salta a la siguiente iteración. Úsalos con una condición evidente para no ocultar el flujo.

## Excepciones y depuración


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/03-stacktrace.png" alt="Partes principales de un stack trace" loading="lazy">
</figure>

Las excepciones representan situaciones que interrumpen el flujo normal. Captura el problema donde puedas actuar y conserva información útil.

```java
try {
  int valor = Integer.parseInt("abc");
  System.out.println(valor);
} catch (NumberFormatException error) {
  System.out.println("El valor no es un entero");
}
```

Durante la depuración, reproduce el fallo, coloca un punto de ruptura, inspecciona variables y confirma la corrección con una nueva prueba. Una aserción documenta una condición que debería cumplirse durante el desarrollo:

```java
assert saldo >= 0 : "El saldo no puede ser negativo";
```

## Ejercicios


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/03-debugger.png" alt="Flujo de trabajo con el depurador" loading="lazy">
</figure>

1. Clasifica un número como positivo, negativo o cero.
2. Calcula la suma y la media de los números introducidos.
3. Imprime una tabla de multiplicar usando un bucle.
4. Solicita números hasta recibir cero y controla entradas no numéricas.
5. Implementa factorial iterativo y recursivo.
6. Introduce un error de índice, depúralo y documenta la causa.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/03-excepciones.png" alt="03 excepciones" loading="lazy">
</figure>

### Ejemplo guiado

Lee un entero con `Integer.parseInt(scanner.nextLine())`, captura el error y repite hasta recibir un valor válido.

### Ejercicio propuesto

Implementa división segura, entrada numérica robusta y documenta un bug localizado con el depurador.

## Tarea para casa

Construye un programa de entrada robusta que repita preguntas hasta recibir datos válidos y documenta al menos un error localizado con el depurador.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué bloque captura una excepción compatible?

- A) catch
- B) for
- C) package
- D) import

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> catch maneja excepciones lanzadas en el try asociado.</p>

</details>

### 2. ¿Qué bloque puede ejecutarse tanto si hay excepción como si no?

- A) finally
- B) switch
- C) class
- D) case

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> finally se usa para acciones finales, aunque existen matices si el proceso termina abruptamente.</p>

</details>

### 3. ¿Qué información útil suele aportar un stack trace?

- A) Cadena de llamadas y líneas relacionadas con el error
- B) Solo la versión de Java
- C) El contenido de la base de datos
- D) La lista de dependencias

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Permite seguir dónde se originó y propagó la excepción.</p>

</details>

### 4. ¿Qué hace un breakpoint?

- A) Pausa la ejecución en un punto para inspeccionar estado
- B) Borra una línea
- C) Compila más rápido
- D) Crea una excepción

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los breakpoints permiten depuración interactiva.</p>

</details>

### 5. ¿Qué diferencia hay entre step into y step over?

- A) Into entra en llamadas; over ejecuta la llamada sin recorrerla internamente
- B) No hay diferencia
- C) Over finaliza el programa
- D) Into compila

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Son dos controles básicos del depurador.</p>

</details>

## Ejercicios propuestos

1. Crea una lectura de entero que repita la pregunta hasta recibir un valor válido.
2. Depura un bucle con un error lógico usando breakpoint y documenta el valor que causa el fallo.
3. Provoca una excepción, interpreta su stack trace y localiza la primera línea de tu código implicada.

## Actividades principales de la lección

### Actividad 1 · Entrada numérica segura

**Modalidad:** clase · **Tiempo orientativo:** 30–40 minutos

**Objetivo:** utilizar excepciones para recuperar el programa ante una entrada incorrecta.

Crea un programa que pida una edad y continúe preguntando hasta recibir un entero válido entre 0 y 130. Usa `try/catch` para controlar entradas no numéricas.

**Comprobación:** prueba texto, números negativos, un valor superior a 130 y una edad válida.

### Actividad 2 · Encuentra el bug con el depurador

**Modalidad:** clase · **Tiempo orientativo:** 35–45 minutos

**Objetivo:** usar breakpoints e inspección de variables para localizar un error lógico.

Parte de un programa con un bucle que debería sumar del 1 al 10 pero produce un resultado incorrecto. Coloca un breakpoint, recorre las iteraciones y registra cómo cambian el contador y el acumulador hasta descubrir el fallo.

**Comprobación:** explica por escrito cuál era el error, en qué iteración se hace visible y cómo lo corregiste.

### Actividad 3 · Menú resistente a errores

**Modalidad:** casa · **Tiempo orientativo:** 60–75 minutos

**Objetivo:** crear una aplicación que no termine inesperadamente ante entradas inválidas.

Diseña un menú con al menos tres operaciones. Debe controlar opciones inexistentes, datos no numéricos y operaciones no permitidas. Los mensajes de error deben explicar qué ocurrió y cómo continuar.

**Entrega:** código, `README.md` y cinco pruebas, incluyendo al menos tres entradas erróneas.

<div class="cla-lesson-nav"><a href="/java/leccion02/">← 02 · Fundamentos de Java</a><a href="/java/leccion04/">04 · Organización de clases →</a></div>
