---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion01"
lesson_file: "01-introduccion-a-ficheros-en-java-21"
lesson_number: "1"
title: "Introducción a ficheros en Java 21"
description: "Introducción a ficheros en Java 21: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion01/"
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

# Introducción a ficheros en Java 21

## Qué vas a conseguir

- Entender qué aprenderás en la ruta y qué papel tiene cada formato.
- Distinguir acceso al fichero, parsing, modelo Java y persistencia.

## Punto de partida

Antes de elegir una librería conviene separar dos preguntas: cómo accedo al fichero y cómo interpreto su contenido.

<div class="cla-note"><strong>Objetivo de la ruta</strong><p>Aprender el formato sin acoplar toda la aplicación a su parser o serializador.</p></div>

## Conceptos clave

- `Path` y `Files` pertenecen al acceso al sistema de ficheros.
- `.properties`, CSV, JSON y XML representan datos de formas diferentes.
- Una librería de parsing transforma texto/bytes en estructuras útiles; no sustituye a `Files`.

## Ejemplo guiado

```text
.properties → java.util.Properties → configuración
CSV         → Commons CSV         → filas / objetos
JSON        → Jackson             → objetos Java
XML         → Jackson XML         → objetos Java
```

## Relación con el resto de la ruta

Esta lección presenta el mapa completo. A partir de la siguiente se estudian primero las herramientas comunes de Java 21.

## Ejercicios propuestos

1. Crea una carpeta de trabajo con cuatro ficheros vacíos: `config.properties`, `productos.csv`, `productos.json` y `productos.xml`.
2. Escribe una frase explicando qué información guardarías en cada formato.

## Qué debes recordar

- El formato del fichero y el mecanismo para abrirlo son responsabilidades distintas.
- El modelo Java puede mantenerse aunque cambie el formato externo.

<div class="cla-lesson-nav">
  <a href="/ficheros/">← Índice de la ruta</a>
  <a href="/ficheros/leccion02/">2 · Path y Files →</a>
</div>
