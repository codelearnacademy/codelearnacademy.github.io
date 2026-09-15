---
layout: lesson
route: git
lesson_id: leccion04
lesson_number: "04"
title: "El modelo de trabajo de Git"
description: "Domina el recorrido Working Directory → Staging Area → Repository con status, add y commit."
permalink: /git/leccion04/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: working-directory
    title: "Working Directory"
  - id: staging-area
    title: "Staging Area"
  - id: repository
    title: "Repository"
  - id: por-qué-existe-staging
    title: "Por qué existe staging"
  - id: ejemplo-guiado-completo
    title: "Ejemplo guiado completo"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# El modelo de trabajo de Git

Esta es una de las lecciones más importantes de toda la ruta. Git separa los cambios que estás realizando, los que has preparado y los que ya forman parte del historial.

## Qué vas a conseguir

- Diferenciar Working Directory, Staging Area y Repository.
- Utilizar `git status`, `git add` y `git commit` conscientemente.
- Preparar solo los cambios que quieres incluir.
- Comprender por qué guardar un archivo no equivale a crear un commit.

## Punto de partida

El modelo básico es:

```text
Working Directory
      │ git add
      ▼
Staging Area
      │ git commit
      ▼
Repository
```

<!-- IMAGEN MUY RECOMENDADA: /assets/images/git/leccion04/modelo-tres-areas.svg
Tres columnas: Working Directory → Staging Area → Repository, con git add y git commit sobre las flechas. -->

## Working Directory

Es la versión que estás editando en tu carpeta.

Modifica `README.md`:

```text
# Mi primer repositorio

Estoy aprendiendo el modelo de trabajo de Git.
```

Consulta:

```bash
git status
```

## Staging Area

La zona de preparación permite seleccionar lo que formará parte del siguiente commit.

```bash
git add README.md
```

Después:

```bash
git status
```

El archivo aparecerá como preparado para commit.

## Repository

Crea el commit:

```bash
git commit -m "Crear README inicial"
```

Ahora:

```bash
git status
```

Si no quedan cambios, Git indicará que el directorio está limpio.

## Por qué existe staging

Supón que has modificado tres archivos, pero solo dos corresponden a la misma tarea. Puedes preparar únicamente esos dos:

```bash
git add README.md equipo.md
git commit -m "Documentar proyecto y equipo"
```

El tercer archivo queda fuera del commit.

<div class="cla-note"><strong>Modelo mental</strong><p>Guardar escribe cambios en el disco. git add selecciona cambios para el próximo commit. git commit registra una versión en el historial.</p></div>

## Ejemplo guiado completo

```bash
git status
git add README.md
git status
git commit -m "Crear README inicial"
git status
```

Lee la salida después de cada comando. No ejecutes la secuencia de memoria sin observar los cambios de estado.

## Ejercicios propuestos

**Ejercicio 1.** Modifica dos archivos y prepara solo uno. Comprueba con `git status` que están en estados diferentes.

**Ejercicio 2.** Crea un commit únicamente con el archivo preparado.

**Ejercicio 3.** Explica por qué `git add` no significa "subir a GitHub".

**Reto.** Dibuja de memoria las tres áreas de Git y coloca `git add` y `git commit` en el lugar correcto.

## Qué debes recordar

Si entiendes las tres áreas, muchos comandos de Git dejan de parecer arbitrarios. Cuando tengas dudas, vuelve a preguntar: **¿en qué área está ahora mi cambio y a qué área quiero moverlo?**

<div class="cla-lesson-nav">
  <a href="/git/leccion03/">← Lección 03 · Crear el primer repositorio</a>
  <a href="/git/leccion05/">Lección 05 · Commits y construcción del historial →</a>
</div>
