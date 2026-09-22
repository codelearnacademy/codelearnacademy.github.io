---
layout: lesson
route: ficheros
lesson_id: leccion30
lesson_file: 30-objeto-java-a-json
lesson_number: "30"
title: Objeto Java a JSON
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion30/
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

# Objeto Java a JSON

## Qué vas a conseguir

- Comprender **Objeto Java a JSON**.
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

```java
ObjectMapper mapper = new ObjectMapper();
Usuario u = new Usuario("Ana", "ana@example.com", 22);
String json = mapper.writeValueAsString(u);
Usuario copia = mapper.readValue(json, Usuario.class);
```



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
  <a href="/ficheros/leccion29/">← 29 · ObjectMapper</a>
  <a href="/ficheros/leccion31/">31 · JSON a objeto Java →</a>
</div>
