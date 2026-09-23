---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion02"
lesson_file: "02-path-y-files"
lesson_number: "2"
title: "Path y Files"
description: "Path y Files: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion02/"
lessons:
  - id: "qué-vas-a-conseguir"
    title: "Qué vas a conseguir"
  - id: "punto-de-partida"
    title: "Punto de partida"
  - id: "conceptos-clave"
    title: "Conceptos clave"
  - id: "ejemplo-guiado"
    title: "Ejemplo guiado"
  - id: "relación-con-el-resto-de-la-ruta"
    title: "Relación con el resto de la ruta"
  - id: "ejercicios-propuestos"
    title: "Ejercicios propuestos"
  - id: "qué-debes-recordar"
    title: "Qué debes recordar"
---

# Path y Files

## Qué vas a conseguir

- Construir rutas portables con `Path`.
- Comprobar, crear y resolver rutas usando `Files`.

## Punto de partida

Las rutas absolutas hacen que un ejemplo funcione en un equipo y falle en otro.

<div class="cla-note"><strong>Rutas portables</strong><p>Construye rutas con <code>Path</code> y evita concatenar separadores del sistema manualmente.</p></div>

## Conceptos clave

- `Path.of(...)` representa una ruta sin abrir el fichero.
- `resolve(...)` compone rutas sin concatenar separadores manualmente.
- `Files.exists`, `createDirectories` y `isRegularFile` permiten validar el entorno.

## Ejemplo guiado

```java
Path data = Path.of("data");
Files.createDirectories(data);
Path csv = data.resolve("productos.csv");
System.out.println(csv.toAbsolutePath());
```

## Relación con el resto de la ruta

Todas las lecciones posteriores reciben o construyen rutas con `Path`; así los ejemplos de formatos no dependen del sistema operativo.

## Ejercicios propuestos

1. Crea `data/entrada` y `data/salida` con `Files.createDirectories`.
2. Resuelve dentro de ellas las rutas de un CSV de entrada y un JSON de salida.

## Qué debes recordar

- No concatenes rutas con `"/"` o `"\"`.
- `Path` describe; `Files` actúa sobre el sistema de ficheros.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion01/">← 1 · Introducción a ficheros en Java 21</a>
  <a href="/ficheros/leccion03/">3 · Lectura y escritura de texto →</a>
</div>
