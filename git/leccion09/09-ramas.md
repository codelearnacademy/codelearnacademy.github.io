---
layout: lesson
route: git
lesson_id: leccion09
lesson_number: "09"
title: "Ramas: trabajar en paralelo"
description: "Crea y cambia de rama para desarrollar funcionalidades sin modificar directamente la línea principal."
permalink: /git/leccion09/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: consultar-ramas
    title: "Consultar ramas"
  - id: crear-una-rama
    title: "Crear una rama"
  - id: trabajar-en-la-rama
    title: "Trabajar en la rama"
  - id: por-qué-usar-ramas
    title: "Por qué usar ramas"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Ramas: trabajar en paralelo

Las ramas permiten desarrollar cambios sin modificar directamente la línea principal del proyecto.

## Qué vas a conseguir

- Comprender qué representa una rama.
- Consultar ramas existentes.
- Crear una rama con `git switch -c`.
- Cambiar entre ramas.
- Comprobar cómo cada rama puede avanzar de forma independiente.

## Punto de partida

Imagina este historial:

```text
A --- B --- C  main
```

Quieres desarrollar una nueva sección sin tocar `main`. Creas una rama:

```text
A --- B --- C  main
             \
              D --- E  feature/recursos
```

## Consultar ramas

```bash
git branch
```

La rama actual aparece marcada con `*`.

## Crear una rama

```bash
git switch -c feature/recursos
```

Comprueba:

```bash
git branch
```

## Trabajar en la rama

Crea `recursos.md`, añade contenido y confirma:

```bash
git add recursos.md
git commit -m "Añadir recursos recomendados"
```

Ahora vuelve a `main`:

```bash
git switch main
```

Observa que el commit de la nueva funcionalidad pertenece a la otra rama.

<!-- IMAGEN MUY RECOMENDADA: /assets/images/git/leccion09/ramas.svg
Mostrar main en horizontal y feature/recursos separándose y avanzando con dos commits. -->

## Por qué usar ramas

Las ramas permiten:

- aislar tareas;
- experimentar;
- revisar cambios antes de integrarlos;
- trabajar varias personas en paralelo.

## Ejercicios propuestos

**Ejercicio 1.** Crea `feature/contacto` desde `main`.

**Ejercicio 2.** Realiza un commit en esa rama y vuelve a `main`.

**Ejercicio 3.** Utiliza `git log --oneline --all --graph` para observar ambas líneas de trabajo.

**Reto.** Crea dos ramas diferentes desde `main`, realiza un commit distinto en cada una y dibuja el historial resultante.

## Qué debes recordar

Una rama es una referencia móvil a una línea de commits. Trabajar por ramas permite separar tareas y preparar la colaboración que utilizaremos más adelante con GitHub y GitLab.

<div class="cla-lesson-nav">
  <a href="/git/leccion08/">← Lección 08 · Corregir errores y recuperar cambios</a>
  <a href="/git/leccion10/">Lección 10 · Fusionar ramas con merge →</a>
</div>
