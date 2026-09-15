---
layout: lesson
route: software
lesson_id: leccion02
lesson_file: 02-tipos-de-software
lesson_number: "02"
title: Tipos de software
description: Distinguir software de sistema, escritorio, web, móvil, servicios, APIs y software embebido.
permalink: /software/leccion02/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: desarrollo
    title: Desarrollo
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-otras-rutas
    title: Relación con otras rutas
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Tipos de software

## Qué vas a conseguir

Distinguir software de sistema, escritorio, web, móvil, servicios, APIs y software embebido.

## Punto de partida

CodeTasks podría ofrecerse como web o aplicación de escritorio. Elegir una categoría exige indicar qué estamos clasificando.

## Conceptos clave

- **Finalidad:** software de sistema o de aplicación.
- **Plataforma:** web, escritorio, móvil o sistema embebido.
- **Interfaz:** mecanismo de interacción, como una API.

## Desarrollo

El software de sistema facilita el funcionamiento del equipo: un sistema operativo administra recursos. El software de aplicación resuelve necesidades de usuarios, como editar documentos o gestionar tareas. El software embebido opera integrado en un dispositivo, por ejemplo un controlador de climatización.

Web, escritorio y móvil describen formas de acceso o ejecución. Una API describe un contrato de comunicación entre programas, no una categoría excluyente frente a las anteriores. Un mismo producto puede tener web, aplicación móvil y API. Por eso una clasificación útil admite varios ejes.

## Ejemplo guiado

CodeTasks es software de aplicación por su finalidad. Su versión accesible con navegador es web. Si un cliente móvil consulta sus tareas mediante HTTP, sigue siendo el mismo producto con otra interfaz. El sistema operativo del servidor es software de sistema, no otra pantalla de CodeTasks.

## Relación con otras rutas

Java permite construir aplicaciones y servicios; Spring desarrolla servicios web; Angular permite construir interfaces web.

## Ejercicios propuestos

1. Clasifica un navegador, un sistema operativo y el programa de una lavadora por finalidad y plataforma.
2. Explica por qué «web» y «API» pueden coexistir.
3. Compara una versión local de CodeTasks con una web: instalación, conexión y actualización.

## Qué debes recordar

Las categorías dependen del criterio. Una API puede formar parte de una aplicación web o móvil.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion01/' | relative_url }}">← 01 · Qué es el software</a>
  <a href="{{ '/software/leccion03/' | relative_url }}">03 · Software como producto →</a>
</div>
