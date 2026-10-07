---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: Colecciones y tipos avanzados
search_title: Lección 06 - Colecciones y tipos avanzados
search_description: Usarás colecciones y tipos avanzados para modelar datos de forma flexible.
description: Utilizarás arrays, colecciones, genéricos, regex y documentos de datos.
lessons:
  - id: arrays
    title: Arrays y colecciones
  - id: genericos
    title: Genéricos e iteradores
  - id: operaciones
    title: Operaciones y expresiones regulares
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion06/
---

## Arrays y colecciones

Un array tiene tamaño fijo. `List` representa una secuencia, `Set` evita duplicados y `Map` asocia claves con valores.

```java
List<String> nombres = new ArrayList<>(List.of("Ada", "Linus", "Ada"));
Set<String> únicos = new LinkedHashSet<>(nombres);
Map<String, Integer> visitas = new HashMap<>();
visitas.merge("inicio", 1, Integer::sum);
System.out.println(únicos + " " + visitas);
```

Elige la colección por el comportamiento que necesitas, no por costumbre. Si importa conservar orden, documenta esa decisión.

## Genéricos e iteradores


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/06-elegir-coleccion.png" alt="Criterios para elegir List Set o Map" loading="lazy">
</figure>

Los genéricos expresan el tipo de los elementos y evitan conversiones inseguras.

```java
public static <T> T primero(List<T> elementos) {
  if (elementos.isEmpty()) throw new NoSuchElementException();
  return elementos.get(0);
}

for (String nombre : nombres) {
  System.out.println(nombre.toUpperCase());
}
```

## Operaciones y expresiones regulares


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/06-stream-pipeline.png" alt="Pipeline de operaciones Stream" loading="lazy">
</figure>

Los streams permiten encadenar operaciones sin modificar la colección original:

```java
List<String> largos = nombres.stream()
    .filter(nombre -> nombre.length() >= 4)
    .map(String::toUpperCase)
    .sorted()
    .toList();
```

Para validar un código sencillo puedes usar `Pattern` y `Matcher`:

```java
boolean válido = Pattern.matches("[A-Z]{2}-\\d{4}", "AB-2026");
```

## Ejercicios

1. Calcula máximos, mínimos y medias de un array.
2. Elimina duplicados conservando el orden de entrada.
3. Cuenta palabras con un `Map`.
4. Agrupa alumnos por curso usando streams.
5. Valida códigos postales y matrículas con regex.
6. Lee un JSON o XML de prueba y transforma sus datos en objetos.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/06-colecciones.png" alt="Comparación visual entre Array, List, Set y Map y sus características principales" loading="lazy">
</figure>

### Ejemplo guiado

Parte de una lista de notas: calcula media, filtra aprobados y genera otra lista transformada con Stream.

### Ejercicio propuesto

Crea un contador de palabras con `Map` y unas estadísticas de notas con List/Set/Stream.

## Tarea para casa

Crea estadísticas de notas utilizando `List`, `Map` y Stream: media, máximo, mínimo, aprobados y distribución por calificación.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué colección mantiene orden y permite duplicados normalmente?

- A) List
- B) Set
- C) Map como única opción
- D) boolean

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> List modela secuencias ordenadas.</p>

</details>

### 2. ¿Qué colección se usa cuando quieres unicidad de elementos?

- A) Set
- B) List obligatoriamente
- C) String
- D) Scanner

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Set no admite duplicados según igualdad.</p>

</details>

### 3. ¿Qué estructura representa pares clave-valor?

- A) Map
- B) List
- C) Set
- D) Array primitivo

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Map asocia claves con valores.</p>

</details>

### 4. ¿Qué hace filter en un Stream?

- A) Conserva elementos que cumplen un predicado
- B) Transforma cada elemento
- C) Ordena siempre
- D) Cierra la JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> filter selecciona elementos.</p>

</details>

### 5. ¿Qué hace map en un Stream?

- A) Transforma elementos
- B) Elimina duplicados siempre
- C) Abre un fichero
- D) Crea una interfaz

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> map aplica una función y produce otro flujo de valores.</p>

</details>

## Ejercicios propuestos

1. Implementa un contador de palabras con `Map<String,Integer>`.
2. Elimina duplicados de una lista usando un `Set` y analiza qué información se pierde.
3. A partir de una lista de notas, usa streams para filtrar aprobados, ordenar y obtener estadísticas.

## Actividades principales de la lección

### Actividad 1 · Lista de tareas

**Modalidad:** clase · **Tiempo orientativo:** 35–45 minutos

**Objetivo:** practicar las operaciones básicas de `List`.

Implementa una lista de tareas con opciones para añadir, listar, buscar y eliminar. Evita posiciones inválidas y muestra siempre el estado actualizado de la colección.

**Comprobación:** prueba tareas duplicadas y explica si la colección elegida las permite.

### Actividad 2 · Contador de palabras

**Modalidad:** clase · **Tiempo orientativo:** 45–55 minutos

**Objetivo:** entender la diferencia entre `Set` y `Map`.

Dado un texto, crea un `Set<String>` con sus palabras únicas y un `Map<String,Integer>` con el número de apariciones de cada palabra. Normaliza mayúsculas/minúsculas antes de contar.

**Comprobación:** explica qué información proporciona el `Map` que no puede proporcionar el `Set` por sí solo.

### Actividad 3 · Estadísticas de alumnos con Streams

**Modalidad:** casa · **Tiempo orientativo:** 75–90 minutos

**Objetivo:** usar colecciones y streams en un problema completo.

A partir de una lista de alumnos con nombre y nota, obtiene:

- alumnos aprobados;
- nombres en mayúsculas;
- alumnos ordenados por nota;
- media de la clase;
- mejor nota.

**Entrega:** una versión funcional y una explicación breve de qué hace cada etapa del pipeline de streams.

<div class="cla-lesson-nav"><a href="/java/leccion05/">← 05 · Entrada y salida</a><a href="/java/leccion07/">07 · Herencia e interfaces →</a></div>
