---
layout: lesson
route: git
lesson_id: leccion22
lesson_number: "22"
title: "Proyecto final colaborativo"
description: "Aplica toda la ruta en un repositorio compartido con ramas, commits, revisión, conflicto, merge y versión final."
permalink: /git/leccion22/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: proyecto-guía-colaborativa-de-herramientas-de-desarrollo
    title: "Proyecto · Guía colaborativa de herramientas de desarrollo"
  - id: requisitos-del-repositorio
    title: "Requisitos del repositorio"
  - id: fase-1-crear-el-proyecto
    title: "Fase 1 · Crear el proyecto"
  - id: fase-2-repartir-tareas
    title: "Fase 2 · Repartir tareas"
  - id: fase-3-construir-un-historial-útil
    title: "Fase 3 · Construir un historial útil"
  - id: fase-4-publicar-y-revisar
    title: "Fase 4 · Publicar y revisar"
  - id: fase-5-conflicto-controlado
    title: "Fase 5 · Conflicto controlado"
  - id: fase-6-preparar-la-versión-10
    title: "Fase 6 · Preparar la versión 1.0"
  - id: entregables
    title: "Entregables"
  - id: criterios-de-comprobación
    title: "Criterios de comprobación"
  - id: ampliación-opcional
    title: "Ampliación opcional"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Proyecto final colaborativo

El proyecto final integra trabajo local, ramas, repositorio remoto, revisión y versionado. El objetivo principal no es programar una aplicación compleja, sino demostrar un flujo de Git completo y comprensible.

## Qué vas a conseguir

- Crear y mantener un repositorio compartido.
- Trabajar mediante ramas por tarea.
- Construir un historial con commits claros.
- Abrir y revisar Pull/Merge Requests.
- Resolver al menos un conflicto controlado.
- Etiquetar y documentar una versión final.

## Proyecto · Guía colaborativa de herramientas de desarrollo

En grupos de 2 a 4 personas crearéis una pequeña guía en Markdown para alumnado que comienza a programar.

El repositorio tendrá una estructura inicial como:

```text
guia-desarrollo/
├── README.md
├── docs/
│   ├── terminal.md
│   ├── git.md
│   └── editores.md
└── recursos.md
```

Cada persona será responsable de al menos una tarea completa.

## Requisitos del repositorio

Debe incluir:

- rama principal `main`;
- `.gitignore` razonado;
- README con objetivo y participantes;
- al menos tres ramas de trabajo en total;
- varios commits pequeños y descriptivos;
- al menos dos PR/MR revisadas por otra persona;
- un conflicto provocado y resuelto de forma documentada;
- una etiqueta `v1.0.0` al finalizar.

## Fase 1 · Crear el proyecto

Una persona crea el repositorio remoto y añade un README inicial.

El resto clona:

```bash
git clone <URL>
```

Todos verifican:

```bash
git status
git remote -v
git log --oneline
```

## Fase 2 · Repartir tareas

Ejemplo:

```text
Persona A → docs/terminal.md
Persona B → docs/git.md
Persona C → docs/editores.md
Persona D → recursos.md
```

Cada persona crea su rama:

```bash
git switch main
git pull
git switch -c docs/terminal
```

## Fase 3 · Construir un historial útil

No hagas un único commit al final.

Ejemplo:

```text
Crear estructura de la guía de terminal
Añadir comandos básicos de navegación
Añadir ejemplo práctico de rutas
Corregir ejemplos de Windows y Linux
```

Revisa antes de cada commit:

```bash
git status
git diff
git add <archivos>
git diff --staged
```

## Fase 4 · Publicar y revisar

Publica tu rama:

```bash
git push -u origin docs/terminal
```

Abre una PR/MR. Otra persona debe revisar el diff y escribir al menos un comentario útil antes de aprobar.

Si hay una corrección:

```text
revisión → modificar → commit → push → nueva revisión
```

## Fase 5 · Conflicto controlado

Dos integrantes crearán ramas diferentes que modifiquen intencionadamente la misma línea de una sección de prueba del README.

Una rama se integra primero. Al actualizar la segunda, deberá resolverse el conflicto de forma razonada.

Documentad:

```text
- qué líneas estaban en conflicto;
- qué proponía cada rama;
- qué versión final se eligió;
- por qué.
```

<div class="cla-note"><strong>Objetivo del conflicto</strong><p>No se busca provocar un problema real en el proyecto, sino practicar una situación normal de colaboración en un entorno controlado.</p></div>

## Fase 6 · Preparar la versión 1.0

Cuando todas las tareas estén integradas:

```bash
git switch main
git pull
git status
```

Revisad el proyecto completo y cread una etiqueta:

```bash
git tag -a v1.0.0 -m "Primera versión de la guía"
git push origin v1.0.0
```

Si la plataforma lo permite, cread una release asociada a esa etiqueta con un resumen de los contenidos.

## Entregables

Cada grupo entregará:

1. URL del repositorio.
2. Captura o enlace al historial de commits.
3. Lista de ramas utilizadas.
4. Enlaces a las PR/MR revisadas.
5. Documento breve explicando el conflicto resuelto.
6. Tag `v1.0.0` publicado.
7. README final del proyecto.

## Criterios de comprobación

Antes de entregar, comprobad:

```text
[ ] main está actualizado y limpio
[ ] no hay credenciales ni archivos temporales
[ ] los commits tienen mensajes comprensibles
[ ] las ramas corresponden con tareas concretas
[ ] las PR/MR muestran revisión real
[ ] el conflicto está explicado
[ ] v1.0.0 apunta al estado final
```

## Ampliación opcional

Si termináis antes, añadid una pequeña mejora en una nueva rama `docs/faq-git`, completad todo el flujo de revisión y publicad después `v1.1.0`.

## Qué debes recordar

Has recorrido el ciclo completo:

```text
Repositorio local
      ↓
Cambios
      ↓
Staging
      ↓
Commits
      ↓
Ramas
      ↓
Repositorio remoto
      ↓
PR/MR y revisión
      ↓
Merge
      ↓
Versión etiquetada
```

A partir de aquí Git debe acompañar tus proyectos de programación desde el primer día. La siguiente mejora no consiste en aprender comandos más difíciles, sino en aplicar este flujo con constancia y criterio.

<div class="cla-lesson-nav">
  <a href="/git/leccion21/">← Lección 21 · Problemas frecuentes y diagnóstico</a>
  <a href="/java/">Continuar con proyectos de programación →</a>
</div>
