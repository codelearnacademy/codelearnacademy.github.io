---
layout: lesson
route: git
lesson_id: leccion03
lesson_number: "03"
title: "Crear el primer repositorio"
description: "Crea un repositorio local, reconoce la carpeta .git y aprende a consultar su estado."
permalink: /git/leccion03/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: consultar-el-estado
    title: "Consultar el estado"
  - id: qué-significa-untracked
    title: "Qué significa untracked"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Crear el primer repositorio

En esta lección convertirás una carpeta normal en un repositorio Git y aprenderás a preguntar a Git qué está ocurriendo en cada momento.

## Qué vas a conseguir

- Crear un repositorio con `git init`.
- Reconocer la función de `.git`.
- Utilizar `git status` como herramienta principal de diagnóstico.
- Crear el primer archivo de trabajo.
- Entender qué significa que un archivo esté sin seguimiento.

## Punto de partida

Sitúate en una carpeta vacía:

```bash
mkdir mi-primer-repo
cd mi-primer-repo
```

Inicializa Git:

```bash
git init
```

Git crea internamente una carpeta llamada `.git`.

<div class="cla-note"><strong>No edites .git manualmente</strong><p>La carpeta `.git` contiene la base de datos y configuración interna del repositorio. Mientras aprendes, deja que Git la gestione.</p></div>

## Consultar el estado

Ejecuta:

```bash
git status
```

En un repositorio recién creado no habrá commits ni archivos pendientes.

Ahora crea `README.md`:

```text
# Mi primer repositorio

Este proyecto se utilizará para aprender Git.
```

Vuelve a ejecutar:

```bash
git status
```

Git mostrará `README.md` como **untracked** o archivo sin seguimiento.

## Qué significa untracked

Git ve el archivo, pero todavía no forma parte de su historial.

```text
Carpeta de trabajo
├── README.md   ← Git lo ve
└── .git/       ← historial y metadatos
```

En la siguiente lección decidiremos explícitamente qué cambios deben entrar en el próximo commit.

## Ejemplo guiado

Crea dos archivos:

```text
README.md
equipo.md
```

Ejecuta:

```bash
git status
```

Observa que Git no registra automáticamente todo lo que aparece en la carpeta. Primero debes seleccionar qué cambios quieres preparar.

## Ejercicios propuestos

**Ejercicio 1.** Crea un repositorio llamado `biblioteca-git`.

**Ejercicio 2.** Añade `README.md` y `libros.md` sin ejecutar todavía `git add`.

**Ejercicio 3.** Usa `git status` y describe con tus palabras qué informa Git.

**Reto.** Averigua qué ocurre si ejecutas `git init` por segunda vez dentro del mismo repositorio. No borres `.git`.

## Qué debes recordar

`git init` convierte una carpeta en repositorio. `git status` debe convertirse en uno de tus comandos más utilizados: antes de actuar, pregunta a Git cuál es el estado actual.

<div class="cla-lesson-nav">
  <a href="/git/leccion02/">← Lección 02 · Instalación y configuración de Git</a>
  <a href="/git/leccion04/">Lección 04 · El modelo de trabajo de Git →</a>
</div>
