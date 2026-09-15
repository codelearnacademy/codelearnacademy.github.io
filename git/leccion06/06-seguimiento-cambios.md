---
layout: lesson
route: git
lesson_id: leccion06
lesson_number: "06"
title: "Seguimiento y revisión de cambios"
description: "Utiliza git diff y git status para revisar cambios antes de prepararlos y confirmarlos."
permalink: /git/leccion06/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: leer-un-diff
    title: "Leer un diff"
  - id: cambios-preparados
    title: "Cambios preparados"
  - id: rutina-antes-de-un-commit
    title: "Rutina antes de un commit"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Seguimiento y revisión de cambios

Antes de preparar o confirmar un cambio conviene revisar exactamente qué has modificado. `git diff` permite observar diferencias entre estados.

## Qué vas a conseguir

- Interpretar archivos modificados mediante `git status`.
- Consultar cambios no preparados con `git diff`.
- Consultar cambios preparados con `git diff --staged`.
- Revisar cambios antes de hacer commit.
- Adoptar una rutina de comprobación segura.

## Punto de partida

Modifica una línea de `README.md` y ejecuta:

```bash
git status
git diff
```

`git diff` muestra las diferencias que todavía no has preparado con `git add`.

## Leer un diff

De forma simplificada:

```diff
-Este proyecto sirve para practicar.
+Este proyecto sirve para aprender Git paso a paso.
```

La línea con `-` corresponde al contenido anterior y la línea con `+` al nuevo.

## Cambios preparados

Después de:

```bash
git add README.md
```

`git diff` puede quedar vacío porque el cambio ya no está en Working Directory respecto a staging.

Consulta lo preparado:

```bash
git diff --staged
```

## Rutina antes de un commit

```bash
git status
git diff
git add <archivos>
git diff --staged
git commit -m "Mensaje"
```

<div class="cla-note"><strong>Hábito profesional</strong><p>No confirmes cambios que no has revisado. Un diff de pocos minutos puede evitar subir archivos incorrectos, secretos o modificaciones accidentales.</p></div>

## Ejemplo guiado

Modifica `README.md` y `equipo.md`. Revisa ambos con `git diff`. Prepara solo `README.md` y utiliza `git diff --staged`. Comprueba que `equipo.md` sigue sin preparar.

## Ejercicios propuestos

**Ejercicio 1.** Cambia dos líneas y explica qué significan `+` y `-` en el diff.

**Ejercicio 2.** Prepara un archivo y compara la salida de `git diff` con `git diff --staged`.

**Ejercicio 3.** Diseña una checklist de tres pasos que realizarías antes de cada commit.

**Reto.** Introduce intencionadamente un cambio accidental y detecta el problema únicamente revisando el diff antes de hacer commit.

## Qué debes recordar

`git status` responde **qué estado tienen los archivos** y `git diff` responde **qué ha cambiado exactamente**. Utiliza ambos antes de confirmar.

<div class="cla-lesson-nav">
  <a href="/git/leccion05/">← Lección 05 · Commits y construcción del historial</a>
  <a href="/git/leccion07/">Lección 07 · Ignorar archivos con .gitignore →</a>
</div>
