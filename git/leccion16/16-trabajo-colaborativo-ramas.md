---
layout: lesson
route: git
lesson_id: leccion16
lesson_number: "16"
title: "Trabajo colaborativo con ramas"
description: "Organiza el trabajo de varias personas utilizando ramas pequeñas, sincronización frecuente e integración controlada."
permalink: /git/leccion16/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: flujo-recomendado
    title: "Flujo recomendado"
  - id: comenzar-una-tarea
    title: "Comenzar una tarea"
  - id: una-rama-por-tarea
    title: "Una rama por tarea"
  - id: evitar-conflictos
    title: "Evitar conflictos"
  - id: ejemplo-guiado-por-parejas
    title: "Ejemplo guiado por parejas"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
  - id: markdown-de-esta-leccion
    title: "Markdown de esta lección"
  - id: laboratorio-dam-git-lab
    title: "Trabajo sobre dam-git-lab"
---

# Trabajo colaborativo con ramas

Cuando varias personas participan en un repositorio, las ramas permiten aislar tareas y reducir interferencias.

<figure class="cla-diagram cla-diagram--small">
  <img src="/git/images/16-colaboracion-ramas.png" alt="Rama main y varias ramas de alumnado que se integran mediante Pull Requests." loading="lazy">
</figure>

<figure class="cla-diagram cla-diagram--small">
  <img src="/git/images/16-flujo-colaborativo.png" alt="Secuencia pull, branch, commit, push y Pull Request en un flujo colaborativo." loading="lazy">
</figure>

## Qué vas a conseguir

- Organizar una tarea en una rama propia.
- Actualizar `main` antes de comenzar.
- Publicar una rama remota.
- Reducir conflictos mediante tareas pequeñas.
- Comprender un flujo colaborativo básico.

## Flujo recomendado

```text
Actualizar main
      ↓
Crear rama
      ↓
Realizar cambios
      ↓
Revisar diff
      ↓
Commits
      ↓
Publicar rama
      ↓
Solicitar integración
```

## Comenzar una tarea

```bash
git switch main
git pull
git switch -c feature/documentar-instalacion
```

Trabaja y crea commits:

```bash
git add docs/instalacion.md
git commit -m "Documentar instalación inicial"
```

Publica la rama:

```bash
git push -u origin feature/documentar-instalacion
```

## Una rama por tarea

Es más fácil revisar:

```text
feature/documentar-instalacion
```

que una rama enorme con diez tareas distintas.

## Evitar conflictos

No existe una técnica que elimine todos los conflictos, pero ayudan:

- sincronizar con frecuencia;
- dividir las tareas;
- evitar editar las mismas líneas sin coordinación;
- integrar cambios con regularidad;
- comunicar qué está modificando cada persona.

## Ejemplo guiado por parejas

Persona A crea `feature/recursos`.

Persona B crea `feature/normas`.

Cada persona modifica un archivo diferente, realiza dos commits y publica su rama. Todavía no fusionéis en `main`: eso será el objetivo de la siguiente lección.

## Ejercicios propuestos

**Ejercicio 1.** Crea una rama con nombre relacionado con una tarea real.

**Ejercicio 2.** Publica esa rama y comprueba que aparece en GitHub o GitLab.

**Ejercicio 3.** Explica por qué trabajar todos directamente en `main` dificulta la revisión.

**Reto.** En un grupo de tres personas, repartid tres archivos y cread tres ramas independientes sin editar `main` directamente.

## Markdown de esta lección

Utiliza listas de tareas en Markdown:

```markdown
## Antes de abrir la PR

- [ ] He actualizado `main`.
- [ ] El proyecto compila.
- [ ] He revisado `git diff`.
- [ ] Los commits son comprensibles.
```

## Trabajo colaborativo sobre `dam-git-lab`

Cada integrante trabaja en una rama con una responsabilidad concreta. Evita que varias personas trabajen directamente sobre `main`. Publica la rama solo después de revisar sus commits y diferencias.

## Qué debes recordar

La rama no es solo una herramienta técnica: también expresa una **unidad de trabajo**. Cuanto más clara y pequeña sea la tarea, más sencilla será su revisión e integración.

<div class="cla-lesson-nav">
  <a href="/git/leccion15/">← Lección 15 · Fetch, pull y push</a>
  <a href="/git/leccion17/">Lección 17 · Pull Requests y Merge Requests →</a>
</div>
