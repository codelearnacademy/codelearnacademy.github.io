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

### Ejercicios de práctica · Arrays y colecciones

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a elegir estructuras para almacenar datos. Debes utilizar explícitamente array, `List`, `Set`, `Map` y operaciones básicas. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Arrays y colecciones**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por duplicados, orden, claves ausentes e índices. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Arrays y colecciones**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en inventario, ranking o contador. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

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

### Ejercicios de práctica · Genéricos e iteradores

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a trabajar con tipos parametrizados y recorridos seguros. Debes utilizar explícitamente `<T>`, `Iterator`, for-each y restricciones de tipo. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Genéricos e iteradores**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por casts inseguros y modificación durante iteración. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Genéricos e iteradores**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en una caja o repositorio genérico. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

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

### Ejercicios de práctica · Operaciones y expresiones regulares

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a procesar colecciones con streams y validar texto. Debes utilizar explícitamente `filter`, `map`, `sorted`, collectors, `Pattern` y `Matcher`. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Operaciones y expresiones regulares**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por pipelines mal ordenados y regex demasiado amplias. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Operaciones y expresiones regulares**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en estadísticas o validación masiva. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

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

## Ejercicios de repaso de la lección

Realiza estos retos después de completar los ejercicios de práctica. Cada concepto de la lección dispone de cinco ejercicios de repaso más autónomos.

### Arrays y colecciones

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible elegir estructuras para almacenar datos. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Arrays y colecciones** a un contexto distinto del explicado en clase, por ejemplo inventario, ranking o contador. Usa array, `List`, `Set`, `Map` y operaciones básicas y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Arrays y colecciones** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con duplicados, orden, claves ausentes e índices. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Arrays y colecciones**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Genéricos e iteradores

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible trabajar con tipos parametrizados y recorridos seguros. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Genéricos e iteradores** a un contexto distinto del explicado en clase, por ejemplo una caja o repositorio genérico. Usa `<T>`, `Iterator`, for-each y restricciones de tipo y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Genéricos e iteradores** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con casts inseguros y modificación durante iteración. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Genéricos e iteradores**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Operaciones y expresiones regulares

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible procesar colecciones con streams y validar texto. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Operaciones y expresiones regulares** a un contexto distinto del explicado en clase, por ejemplo estadísticas o validación masiva. Usa `filter`, `map`, `sorted`, collectors, `Pattern` y `Matcher` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Operaciones y expresiones regulares** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con pipelines mal ordenados y regex demasiado amplias. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Operaciones y expresiones regulares**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

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
