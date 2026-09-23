---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion34"
lesson_file: "34-retos-y-ampliaciones"
lesson_number: "34"
title: "Retos y ampliaciones"
description: "Retos y ampliaciones: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion34/"
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

# Retos y ampliaciones

## Qué vas a conseguir

- Extender el proyecto con retos que obliguen a tomar decisiones de diseño.
- Reconocer cuándo un fichero deja de ser la herramienta adecuada.

## Punto de partida

La ruta termina cuando puedes modificar el proyecto sin romper la separación entre formato, persistencia y lógica.

<div class="cla-note"><strong>Ampliación</strong><p>Los retos finales deben mejorar robustez, pruebas o diseño sin romper el contrato común construido en la ruta.</p></div>

## Conceptos clave

- Los ficheros grandes pueden requerir streaming.
- Escrituras concurrentes y transacciones son límites importantes del almacenamiento en fichero.
- Tests con `@TempDir` permiten aislar casos de persistencia.

## Ejemplo guiado

```text
Retos sugeridos:
- importación por streaming de un CSV grande
- copia de seguridad antes de reescribir
- validación acumulando errores por registro
- tests temporales con @TempDir
- nuevo formato sin modificar la lógica de negocio
```

## Relación con el resto de la ruta

Estos retos no añaden otro formato: profundizan en robustez, pruebas y extensibilidad sobre la arquitectura que ya construiste.

## Ejercicios propuestos

1. Añade tests de CRUD con `@TempDir` a un repositorio.
2. Implementa backup antes de cada escritura.
3. Añade un cuarto repositorio ficticio en memoria para comprobar que la lógica no depende de ficheros.
4. Documenta cuándo migrarías de ficheros a una base de datos.

## Qué debes recordar

- Los ficheros son excelentes para intercambio, configuración y datasets pequeños/medios; no resuelven todos los problemas de persistencia.
- La separación lograda facilita cambiar la tecnología cuando sea necesario.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion33/">← 33 · Proyecto final: DataBridge</a>
  <a href="/ficheros/">Volver al índice →</a>
</div>
