---
layout: lesson
route: java
lesson_id: leccion05
lesson_number: "05"
title: Entrada y salida
search_title: Lección 05 - Entrada y salida
search_description: Trabajarás con entrada y salida de datos en aplicaciones de consola.
description: Leerás y escribirás información con consola, ficheros y formatos.
lessons:
  - id: consola
    title: Consola y streams
  - id: ficheros
    title: Ficheros
  - id: formatos
    title: CSV, XML y JSON
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion05/
---

<div class="cla-note"><strong>Qué se pretende</strong><p>Dominar la entrada y salida de información desde una aplicación Java, pasando de la consola a ficheros, formatos de intercambio e interfaces gráficas.</p></div>

<div class="cla-note"><strong>Qué se consigue</strong><p>Al finalizar, podrás leer datos de forma validada, gestionar recursos, guardar información y construir una interfaz JavaFX básica con eventos y FXML.</p></div>

## Consola y streams

`System.in`, `System.out` y `System.err` conectan la aplicación con la consola. `Scanner` facilita la lectura inicial; valida siempre el formato recibido.

```java
try (Scanner scanner = new Scanner(System.in)) {
  System.out.print("Nombre: ");
  String nombre = scanner.nextLine();
  System.out.print("Edad: ");
  int edad = Integer.parseInt(scanner.nextLine());
  System.out.printf("%s tiene %d años%n", nombre, edad);
}
```

### Ejemplos

**Ejemplo 1: salida simple**

```java
System.out.println("Aplicación iniciada");
System.err.println("Mensaje de diagnóstico");
```

**Ejemplo 2: varios valores**

```java
String producto = "teclado";
int unidades = 2;
System.out.printf("%s: %d unidades%n", producto, unidades);
```

**Ejemplo 3: entrada segura**

```java
String texto = scanner.nextLine();
try {
  int edad = Integer.parseInt(texto);
  System.out.println("Edad: " + edad);
} catch (NumberFormatException error) {
  System.out.println("Introduce un número entero");
}
```

**Ejemplo 4: argumentos del proceso**

```java
public static void main(String[] args) {
  String nombre = args.length == 0 ? "invitado" : args[0];
  System.out.println("Hola, " + nombre);
}
```

## Ficheros


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/05-formatos.png" alt="Comparación entre CSV JSON y XML" loading="lazy">
</figure>

La API `java.nio.file` ofrece una forma directa de trabajar con rutas y ficheros. `try-with-resources` garantiza el cierre de recursos.

```java
Path ruta = Path.of("datos", "alumnos.txt");
Files.createDirectories(ruta.getParent());
Files.writeString(ruta, "Ada\nGrace\n", StandardCharsets.UTF_8);
List<String> nombres = Files.readAllLines(ruta, StandardCharsets.UTF_8);
```

Para archivos grandes, usa `Files.lines` y procesa el stream sin cargarlo completo en memoria.

### Ejemplos

**Ejemplo 1: crear y leer texto**

```java
Path ruta = Path.of("saludo.txt");
Files.writeString(ruta, "Hola Java", StandardCharsets.UTF_8);
System.out.println(Files.readString(ruta, StandardCharsets.UTF_8));
```

**Ejemplo 2: añadir contenido**

```java
Files.writeString(ruta, "\nSegunda línea", StandardCharsets.UTF_8,
    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
```

**Ejemplo 3: recorrer un directorio**

```java
try (Stream<Path> entradas = Files.list(Path.of("datos"))) {
  entradas.filter(Files::isRegularFile).forEach(System.out::println);
}
```

**Ejemplo 4: filtrar líneas**

```java
try (Stream<String> líneas = Files.lines(ruta, StandardCharsets.UTF_8)) {
  líneas.filter(línea -> línea.contains("Java")).forEach(System.out::println);
}
```

## CSV, XML y JSON

CSV es sencillo y compacto, pero requiere acordar separador y escape de comillas. XML estructura los datos con etiquetas. JSON suele ser práctico para intercambiar objetos entre aplicaciones. No dividas una línea CSV con `split(",")` si el formato permite comas entrecomilladas: usa una biblioteca adecuada.

### Ejemplos

**Ejemplo 1: CSV sencillo**

```text
id,nombre,activo
1,Ada,true
```

**Ejemplo 2: XML jerárquico**

```xml
<alumno><nombre>Ada</nombre><curso>1DAM</curso></alumno>
```

**Ejemplo 3: JSON de un objeto**

```json
{"id":1,"nombre":"Ada","activo":true}
```

**Ejemplo 4: elegir un formato**

```java
String formato = "json";
if (formato.equals("csv")) {
  System.out.println("Exportación tabular");
} else if (formato.equals("json")) {
  System.out.println("Intercambio entre aplicaciones");
}
```

## Ejercicios

1. Crea un menú de consola que repita opciones hasta elegir salir.
2. Guarda productos en un fichero de texto y recupéralos al iniciar.
3. Cuenta líneas, palabras y caracteres de un fichero.
4. Diseña un lector CSV que informe de filas incompletas.
5. Exporta una lista de objetos a JSON y documenta el formato.
6. Gestiona correctamente rutas inexistentes y errores de codificación.

## Interfaces gráficas con JavaFX

Esta ampliación conecta la entrada y salida de consola con una interfaz visual. Al terminar, el alumno podrá crear una ventana, colocar controles, reaccionar a eventos y separar la vista FXML del controlador.

### Ejemplo 1: ventana mínima

```java
public class App extends Application {
  @Override public void start(Stage stage) {
    stage.setScene(new Scene(new StackPane(new Label("Hola JavaFX")), 320, 180));
    stage.setTitle("Primera ventana");
    stage.show();
  }
  public static void main(String[] args) { launch(); }
}
```

### Ejemplo 2: formulario y evento

```java
TextField nombre = new TextField();
Button botón = new Button("Saludar");
Label salida = new Label();
botón.setOnAction(event -> salida.setText("Hola, " + nombre.getText()));
VBox raíz = new VBox(10, nombre, botón, salida);
```

### Ejemplo 3: selección

```java
ComboBox<String> curso = new ComboBox<>();
curso.getItems().addAll("1DAM", "2DAM");
curso.setOnAction(event -> System.out.println(curso.getValue()));
```

### Ejemplo 4: vista FXML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.control.Button?>
<Button xmlns:fx="http://javafx.com/fxml" text="Aceptar" onAction="#aceptar" />
```

El controlador asociado concentra `aceptar`, mientras FXML describe la vista. Para Java moderno, añade JavaFX mediante Maven o Gradle.

### Ejercicios JavaFX

1. Crea una ventana con nombre, edad y un botón que valide los datos.
2. Construye un conversor de euros a dólares.
3. Muestra una lista de alumnos en `ListView` y responde a la selección.
4. Repite el formulario usando FXML y un controlador separado.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/05-io-flujo.png" alt="Flujo de entrada y salida: los datos entran al programa, se procesan y se envían a consola o fichero" loading="lazy">
</figure>

### Ejemplo guiado

Lee líneas de un fichero de texto y genera un fichero resumen.

### Ejercicio propuesto

Construye un informe simple a partir de un fichero y justifica cuándo usarías CSV, JSON o XML.

## Tarea para casa

Lee un fichero de datos sencillo y genera un informe de salida. Documenta qué responsabilidades pertenecen a entrada, procesamiento y escritura.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué representa System.in?

- A) Entrada estándar
- B) Salida estándar
- C) Error de compilación
- D) JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> System.in es el flujo de entrada estándar.</p>

</details>

### 2. ¿Qué API moderna simplifica operaciones con rutas y ficheros?

- A) Path y Files
- B) Math e Integer
- C) Pattern y Matcher
- D) LocalDate y Period

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> java.nio.file ofrece Path y Files.</p>

</details>

### 3. ¿Qué formato es tabular y suele separar campos por delimitadores?

- A) CSV
- B) JSON únicamente
- C) XML únicamente
- D) Bytecode

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> CSV representa filas y columnas mediante delimitadores.</p>

</details>

### 4. ¿Qué formato representa datos mediante objetos/arrays y pares clave-valor?

- A) JSON
- B) CSV exclusivamente
- C) Bytecode
- D) JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> JSON usa objetos y arrays.</p>

</details>

### 5. ¿Dónde debería profundizarse en CSV/JSON/XML dentro de este proyecto formativo?

- A) En la ruta especializada de Ficheros
- B) Solo en JVM
- C) En Git
- D) En CSS

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La ruta Java introduce el tema y la ruta Ficheros lo desarrolla.</p>

</details>

## Ejercicios propuestos

1. Lee un fichero de texto y genera otro con las líneas numeradas.
2. Representa el mismo `Producto` en CSV, JSON y XML y compara legibilidad y estructura.
3. Decide qué contenido debe quedarse aquí y qué estudiarías en la ruta Ficheros.

## Actividades principales de la lección

### Actividad 1 · Procesar un fichero de texto

**Modalidad:** clase · **Tiempo orientativo:** 30–40 minutos

**Objetivo:** leer información desde un fichero y procesarla en Java.

Crea `alumnos.txt` con un nombre por línea. Lee el fichero, muestra cada alumno numerado y cuenta cuántas líneas válidas contiene.

**Comprobación:** añade líneas vacías y decide explícitamente si deben contarse o ignorarse.

### Actividad 2 · Generar un informe

**Modalidad:** clase · **Tiempo orientativo:** 40–50 minutos

**Objetivo:** combinar lectura, procesamiento y escritura.

Lee un fichero de notas, calcula número de notas, media, máxima y mínima y escribe los resultados en `informe.txt`.

**Comprobación:** compara el fichero generado con los cálculos obtenidos manualmente para un conjunto pequeño de datos.

### Actividad 3 · Transformador de datos

**Modalidad:** casa · **Tiempo orientativo:** 60–75 minutos

**Objetivo:** construir un pequeño proceso de transformación de ficheros.

Lee registros de productos o alumnos desde un fichero de texto, valida los datos y genera un segundo fichero normalizado. Registra las líneas descartadas y el motivo.

**Ampliación:** continúa el problema en la ruta especializada de Ficheros utilizando CSV, JSON o XML.

<div class="cla-lesson-nav"><a href="/java/leccion04/">← 04 · Organización de clases</a><a href="/java/leccion06/">06 · Colecciones y tipos avanzados →</a></div>
