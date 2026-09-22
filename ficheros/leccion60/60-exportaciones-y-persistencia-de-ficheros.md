---
layout: lesson
route: ficheros
lesson_id: leccion60
lesson_file: 60-exportaciones-y-persistencia-de-ficheros
lesson_number: "60"
title: Exportaciones y persistencia de ficheros
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion60/
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

# Exportaciones y persistencia de ficheros

## Qué vas a conseguir

- Comprender **Exportaciones y persistencia de ficheros**.
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

```text
src/main/resources → recursos empaquetados
src/test/resources → fixtures
Docker volume      → ficheros externos
Spring MultipartFile → subida HTTP
```



## Relación con el resto de la ruta

Maven, Spring y Docker añaden empaquetado, endpoints, recursos, configuración externa y volúmenes alrededor de las mismas APIs.

## Ejercicios propuestos

1. Aplica la arquitectura o técnica de esta lección a una operación real de lectura o escritura.
2. Separa las responsabilidades y sustituye la dependencia concreta en una prueba.
3. Comprueba el comportamiento con un recurso temporal o externo.
4. Documenta qué ocurre ante errores de lectura, escritura o configuración.
5. Añade una prueba aislada que demuestre el beneficio de la solución.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion59/">← 59 · Ficheros, volúmenes y configuración en Docker</a>
  <a href="/ficheros/leccion61/">61 · Java frente a JavaScript, Python y Go →</a>
</div>
