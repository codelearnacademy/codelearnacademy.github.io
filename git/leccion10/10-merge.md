---
layout: lesson
route: git
lesson_id: leccion10
lesson_number: "10"
title: "Fusionar ramas con merge"
description: "Integra el trabajo de una rama en otra y comprende los casos de fast-forward y merge commit."
permalink: /git/leccion10/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: fast-forward
    title: "Fast-forward"
  - id: verificar-el-resultado
    title: "Verificar el resultado"
  - id: eliminar-la-rama-terminada
    title: "Eliminar la rama terminada"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Fusionar ramas con merge

Después de desarrollar una tarea en una rama necesitamos integrar sus commits en otra rama, normalmente `main`.

## Qué vas a conseguir

- Comprender qué significa fusionar ramas.
- Integrar una rama mediante `git merge`.
- Reconocer una fusión fast-forward.
- Eliminar una rama local que ya no necesitas.
- Verificar el historial después del merge.

## Punto de partida

Partimos de:

```text
A --- B  main
       \
        C --- D  feature/recursos
```

Para integrar la rama, primero vuelve a `main`:

```bash
git switch main
```

Después:

```bash
git merge feature/recursos
```

## Fast-forward

Si `main` no ha avanzado desde que creaste la rama, Git puede mover simplemente la referencia hacia delante:

```text
Antes:
A --- B  main
       \
        C --- D  feature/recursos

Después:
A --- B --- C --- D  main
```

## Verificar el resultado

```bash
git log --oneline --graph --all
```

Comprueba también que los archivos de la funcionalidad aparecen en `main`.

## Eliminar la rama terminada

Si ya está integrada:

```bash
git branch -d feature/recursos
```

Esto elimina la referencia de rama, no los commits que ya forman parte de `main`.

## Ejemplo guiado

1. Crea `feature/faq`.
2. Añade `faq.md`.
3. Haz commit.
4. Vuelve a `main`.
5. Fusiona `feature/faq`.
6. Verifica el historial.
7. Elimina la rama local.

## Ejercicios propuestos

**Ejercicio 1.** Integra una rama sin cambios paralelos y observa el mensaje de fast-forward.

**Ejercicio 2.** Explica por qué debes situarte en la rama que recibirá los cambios antes de ejecutar `git merge`.

**Ejercicio 3.** Comprueba qué ocurre al intentar borrar con `-d` una rama que no ha sido integrada.

**Reto.** Dibuja el historial antes y después de un merge y señala qué referencia se mueve.

## Qué debes recordar

`git merge otra-rama` incorpora la historia de `otra-rama` en la rama actual. Antes de fusionar, confirma siempre en qué rama estás con `git status` o `git branch`.

<div class="cla-lesson-nav">
  <a href="/git/leccion09/">← Lección 09 · Ramas: trabajar en paralelo</a>
  <a href="/git/leccion11/">Lección 11 · Resolver conflictos →</a>
</div>
