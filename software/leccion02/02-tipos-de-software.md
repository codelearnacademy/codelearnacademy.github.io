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
  - id: infografía
    title: Infografía
  - id: explicación-y-ejemplo
    title: Explicación y ejemplo
  - id: práctica
    title: Práctica
  - id: para-repasar
    title: Para repasar
---

# Tipos de software

## Qué vas a conseguir

Distinguir software de sistema, escritorio, web, móvil, servicios, APIs y software embebido.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/02-tipos-de-software.webp' | relative_url }}" aria-label="Ampliar infografía: Tipos de software">
    <img src="{{ '/assets/images/software/infografias/02-tipos-de-software.webp' | relative_url }}" alt="Resumen visual: Tipos de software" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Las categorías dependen del criterio. Una API puede formar parte de una aplicación web o móvil.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/02-tipos-de-software.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Finalidad:** software de sistema o de aplicación.
- **Plataforma:** web, escritorio, móvil o sistema embebido.
- **Interfaz:** mecanismo de interacción, como una API.

CodeTasks podría ofrecerse como web o aplicación de escritorio. Elegir una categoría exige indicar qué estamos clasificando.

El software de sistema facilita el funcionamiento del equipo: un sistema operativo administra recursos. El software de aplicación resuelve necesidades de usuarios, como editar documentos o gestionar tareas. El software embebido opera integrado en un dispositivo, por ejemplo un controlador de climatización.

Web, escritorio y móvil describen formas de acceso o ejecución. Una API describe un contrato de comunicación entre programas, no una categoría excluyente frente a las anteriores. Un mismo producto puede tener web, aplicación móvil y API. Por eso una clasificación útil admite varios ejes.

### Ejemplo guiado

CodeTasks es software de aplicación por su finalidad. Su versión accesible con navegador es web. Si un cliente móvil consulta sus tareas mediante HTTP, sigue siendo el mismo producto con otra interfaz. El sistema operativo del servidor es software de sistema, no otra pantalla de CodeTasks.

## Práctica

1. Clasifica un navegador, un sistema operativo y el programa de una lavadora por finalidad y plataforma.
2. Explica por qué «web» y «API» pueden coexistir.
3. Compara una versión local de CodeTasks con una web: instalación, conexión y actualización.

## Para repasar

Java permite construir aplicaciones y servicios; Spring desarrolla servicios web; Angular permite construir interfaces web.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion01/' | relative_url }}">← 01 · Qué es el software</a>
  <a href="{{ '/software/leccion03/' | relative_url }}">03 · Software como producto →</a>
</div>
