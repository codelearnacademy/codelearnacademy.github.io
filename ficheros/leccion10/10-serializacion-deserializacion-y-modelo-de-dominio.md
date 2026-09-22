---
layout: lesson
route: ficheros
lesson_id: leccion10
lesson_file: 10-serializacion-deserializacion-y-modelo-de-dominio
lesson_number: "10"
title: Serialización, deserialización y modelo de dominio
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion10/
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

# Serialización, deserialización y modelo de dominio

## Qué vas a conseguir

- Comprender **Serialización, deserialización y modelo de dominio**.
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
record Usuario(String nombre, String correo) {}

Usuario user = new Usuario("Ana", "ana@example.com");
Path file = Path.of("data", "usuario.txt");
Files.createDirectories(file.getParent());
Files.writeString(file, user.nombre() + "\n" + user.correo(), StandardCharsets.UTF_8);
String[] values = Files.readString(file, StandardCharsets.UTF_8).split("\\R", -1);
Usuario recovered = new Usuario(values[0], values[1]);
System.out.println(recovered);
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
  <a href="/ficheros/leccion09/">← 09 · Leer no es lo mismo que parsear</a>
  <a href="/ficheros/leccion11/">11 · Qué es un fichero properties →</a>
</div>
