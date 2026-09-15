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
