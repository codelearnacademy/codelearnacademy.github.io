---
layout: lesson
route: git
lesson_id: leccion19
lesson_number: "19"
title: "Etiquetas, versiones y releases"
description: "Marca versiones importantes con tags y relaciona las etiquetas de Git con releases de GitHub o GitLab."
permalink: /git/leccion19/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: crear-una-etiqueta
    title: "Crear una etiqueta"
  - id: etiqueta-anotada
    title: "Etiqueta anotada"
  - id: publicar-tags
    title: "Publicar tags"
  - id: versiones
    title: "Versiones"
  - id: releases
    title: "Releases"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Etiquetas, versiones y releases

Las ramas se mueven cuando aparecen nuevos commits. Una etiqueta puede marcar un commit concreto como una versión importante.

## Qué vas a conseguir

- Comprender qué es un tag.
- Crear etiquetas sencillas y anotadas.
- Consultar etiquetas existentes.
- Publicarlas en el remoto.
- Relacionar tags con releases de GitHub o GitLab.

## Crear una etiqueta

Consulta el historial:

```bash
git log --oneline
```

En el commit actual puedes crear:

```bash
git tag v1.0.0
```

Lista etiquetas:

```bash
git tag
```

## Etiqueta anotada

También puedes crear una etiqueta con información adicional:

```bash
git tag -a v1.0.0 -m "Primera versión estable"
```

## Publicar tags

Los tags locales no siempre se envían automáticamente con un push normal.

Publica uno:

```bash
git push origin v1.0.0
```

O, según el flujo del equipo, todos los tags pendientes:

```bash
git push --tags
```

## Versiones

Una convención habitual utiliza números como:

```text
v1.0.0
v1.1.0
v2.0.0
```

En esta ruta no profundizaremos en todas las reglas de versionado semántico; el objetivo es comprender que una etiqueta identifica un commit concreto.

## Releases

GitHub y GitLab pueden crear una **release** asociada a un tag, con notas, enlaces o artefactos. La release pertenece a la plataforma; el tag pertenece a Git.

## Ejercicios propuestos

**Ejercicio 1.** Crea el tag `v0.1.0` en tu repositorio de prácticas.

**Ejercicio 2.** Comprueba qué commit señala.

**Ejercicio 3.** Publica el tag y comprueba que aparece en la plataforma.

**Reto.** Escribe unas notas de versión con tres cambios incluidos en una hipotética `v1.0.0`.

## Qué debes recordar

Un tag marca un punto del historial. Las releases construyen sobre esa referencia y sirven para comunicar versiones entregables del proyecto.

<div class="cla-lesson-nav">
  <a href="/git/leccion18/">← Lección 18 · Revisión de código y buenas prácticas</a>
  <a href="/git/leccion20/">Lección 20 · Flujo de trabajo profesional con Git →</a>
</div>
