---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion11"
lesson_file: "11-ejercicio-configuracion-de-aplicacion"
lesson_number: "11"
title: "Ejercicio: configuración de aplicación"
description: "Ejercicio: configuración de aplicación: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion11/"
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

# Ejercicio: configuración de aplicación

## Qué vas a conseguir

- Diseñar una configuración realista para una aplicación de ficheros.
- Practicar lectura, validación y actualización sin copiar el ejemplo CRUD.

## Punto de partida

Ahora debes decidir qué claves necesita la aplicación y qué ocurre si falta alguna.

<div class="cla-note"><strong>Configuración de aplicación</strong><p>Separa los valores configurables del código para poder cambiar el comportamiento sin recompilar.</p></div>

## Conceptos clave

- Una configuración útil define defaults y valores obligatorios.
- Las rutas pueden almacenarse como texto y convertirse a `Path`.
- No guardes secretos sensibles en un fichero versionado.

## Ejemplo guiado

```properties
input.path=data/productos.csv
output.path=data/salida.json
output.format=json
encoding=UTF-8
backup.enabled=true
```

## Relación con el resto de la ruta

Estas mismas claves reaparecerán en la lección 32 para controlar el proyecto integrador.

## Ejercicios propuestos

1. Implementa una clase `AppConfig` que cargue las cinco claves del ejemplo.
2. Valida que `output.format` solo acepte `csv`, `json` o `xml`.
3. Añade una opción `backup.enabled` y conviértela a `boolean`.

## Qué debes recordar

- La configuración describe cómo se ejecuta el programa; no contiene la lógica del programa.
- Define qué claves son obligatorias y cuáles tienen valor por defecto.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion10/">← 10 · CRUD con .properties</a>
  <a href="/ficheros/leccion12/">12 · El formato CSV →</a>
</div>
