---
layout: lesson
route: ficheros
lesson_id: leccion09
lesson_file: 09-leer-no-es-lo-mismo-que-parsear
lesson_number: "09"
title: Leer no es lo mismo que parsear
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion09/
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

# Leer no es lo mismo que parsear

## Qué vas a conseguir

- Comprender **Leer no es lo mismo que parsear**.
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
Path file = Path.of("data", "usuarios.csv");
for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
  String[] fields = line.split(",", -1);
  System.out.println("Campos encontrados: " + fields.length);
}
```



## Relación con el resto de la ruta

Estas APIs son la base común. Las librerías de formato no sustituyen Path, Files, encoding ni el manejo correcto de recursos.

## Ejercicios propuestos

1. Implementa el caso principal de esta lección con un fichero de prueba pequeño.
2. Comprueba el comportamiento cuando la ruta no existe o el contenido está incompleto.
3. Recibe la ruta del fichero como argumento y no la fijes en el código.
4. Explica qué responsabilidad corresponde a `Path`/`Files` y cuál a tu lógica.
5. Añade una prueba que cubra el caso correcto y un error esperado.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion08/">← 08 · Ficheros grandes y procesamiento progresivo</a>
  <a href="/ficheros/leccion10/">10 · Serialización, deserialización y modelo de dominio →</a>
</div>
