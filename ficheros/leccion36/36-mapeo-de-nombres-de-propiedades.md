---
layout: lesson
route: ficheros
lesson_id: leccion36
lesson_file: 36-mapeo-de-nombres-de-propiedades
lesson_number: "36"
title: Mapeo de nombres de propiedades
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion36/
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

# Mapeo de nombres de propiedades

## Qué vas a conseguir

- Comprender **Mapeo de nombres de propiedades**.
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

Adapta el ejemplo al concepto de esta lección y comprueba el resultado con un fichero pequeño antes de aumentar el volumen de datos.



## Relación con el resto de la ruta

Spring MVC utiliza Jackson habitualmente para convertir JSON HTTP en DTOs Java y viceversa.

## Ejercicios propuestos

1. Reproduce el ejemplo y guarda el resultado en un repositorio Git.
2. Introduce un fichero válido y otro mal formado; compara el comportamiento.
3. Cambia el nombre/ruta del fichero para recibirlo como argumento del programa.
4. Explica qué parte resuelve Java estándar y cuál depende de una biblioteca externa.
5. Escribe una prueba para el caso principal o describe cómo la automatizarías.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion35/">← 35 · Records y Jackson</a>
  <a href="/ficheros/leccion37/">37 · Campos ignorados, opcionales y null →</a>
</div>
