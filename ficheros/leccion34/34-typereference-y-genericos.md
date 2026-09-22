---
layout: lesson
route: ficheros
lesson_id: leccion34
lesson_file: 34-typereference-y-genericos
lesson_number: "34"
title: TypeReference y genéricos
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion34/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# TypeReference y genéricos

## Qué vas a conseguir

- Comprender **TypeReference y genéricos**.
- Aplicarlo con Java 21.
- Distinguir lectura, parsing, validación y escritura.
- Relacionarlo con Maven, Spring o Docker cuando corresponda.

## Punto de partida

```text
Fichero → bytes/texto → parser → objetos Java → validación → lógica → writer → fichero
```

<div class="cla-note"><strong>Regla de la ruta</strong><p>Leer un fichero no es interpretarlo. Un parser entiende el formato; la lógica de negocio valida el significado.</p></div>

## Conceptos clave

- Acceso mediante `Path` y `Files`.
- UTF-8 explícito cuando trabajamos con texto.
- Manejo de errores mediante excepciones.
- Separación entre formato y modelo de dominio.

## Ejemplo guiado

Usa Jackson 2 con la dependencia `com.fasterxml.jackson.core:jackson-databind:2.19.4`. En un método que declare `throws Exception`, con los imports indicados, deserializa una colección conservando su tipo de elemento:

```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
```

```java
record Usuario(String nombre, int edad) {}
ObjectMapper mapper = new ObjectMapper();
String json = "[{\"nombre\":\"Ana\",\"edad\":22}]";
List<Usuario> usuarios = mapper.readValue(json, new TypeReference<List<Usuario>>() {});
System.out.println(usuarios.get(0).nombre());
```

Debe imprimir `Ana`. `List.class` no expresa el tipo Usuario; la subclase anónima de TypeReference conserva esa información para Jackson. No conviertas una lista de mapas a `List<Usuario>` mediante un cast: el cast no transforma sus elementos. El ejemplo se centra en Jackson 2; Jackson 3 cambia paquetes y requiere adaptar imports.


## Relación con el resto de la ruta

Spring MVC utiliza Jackson habitualmente para convertir JSON HTTP en DTOs Java y viceversa.

## Ejercicios propuestos

1. Implementa la operación JSON específica de esta lección con Jackson.
2. Prueba un JSON válido, uno incompleto y otro con un tipo incorrecto.
3. Conserva el modelo Java separado del acceso al fichero.
4. Comprueba la salida y explica qué ocurre ante una propiedad desconocida o ausente.
5. Añade una prueba de serialización o deserialización para el caso principal.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion33/">← 33 · Arrays y listas JSON</a>
  <a href="/ficheros/leccion35/">35 · Records y Jackson →</a>
</div>
