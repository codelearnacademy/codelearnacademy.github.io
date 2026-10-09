---
layout: lesson
route: git
lesson_id: leccion15
lesson_number: "15"
title: "Fetch, pull y push"
description: "Sincroniza repositorios locales y remotos comprendiendo qué hace realmente cada operación."
permalink: /git/leccion15/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: push
    title: "Push"
  - id: fetch
    title: "Fetch"
  - id: pull
    title: "Pull"
  - id: ejemplo-con-dos-copias
    title: "Ejemplo con dos copias"
  - id: ahead-y-behind
    title: "Ahead y behind"
  - id: rutina-segura
    title: "Rutina segura"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
  - id: markdown-de-esta-leccion
    title: "Markdown de esta lección"
  - id: laboratorio-dam-git-lab
    title: "Trabajo sobre dam-git-lab"
---

# Fetch, pull y push

Sincronizar correctamente requiere distinguir tres operaciones que suelen confundirse: consultar novedades, incorporar novedades y publicar trabajo.

<figure class="cla-diagram cla-diagram--small">
  <img src="/git/images/15-fetch-pull-push.png" alt="Direcciones de fetch, pull y push entre remoto, referencia origin/main y rama main local." loading="lazy">
</figure>

<figure class="cla-diagram cla-diagram--small">
  <img src="/git/images/15-remote-tracking.png" alt="Relación entre origin/main como último estado remoto conocido y main como rama de trabajo local." loading="lazy">
</figure>

## Qué vas a conseguir

- Comprender `git fetch`.
- Comprender `git pull`.
- Comprender `git push`.
- Interpretar una rama que está ahead o behind.
- Adoptar una secuencia segura de sincronización.

## Push

```bash
git push
```

Envía commits locales al remoto asociado.

```text
LOCAL ───────► REMOTO
       push
```

## Fetch

```bash
git fetch
```

Descarga información del remoto y actualiza referencias como `origin/main`, pero no fusiona automáticamente esos cambios en tu rama local.

```text
REMOTO ──────► referencias remotas locales
       fetch
```

Después puedes inspeccionar:

```bash
git log --oneline --all --graph
```

## Pull

```bash
git pull
```

De forma simplificada, obtiene novedades e intenta integrarlas en la rama actual según la configuración elegida.

Para alumnado principiante es importante no pensar que `pull` significa simplemente "descargar archivos".

## Ejemplo con dos copias

Supón que tienes dos clones: `equipo-a` y `equipo-b`.

En A haces un commit y `push`. En B el repositorio local todavía no conoce ese commit.

En B:

```bash
git fetch
git log --oneline --all --graph
```

Ahora puedes observar que `origin/main` ha avanzado. Después puedes integrar según el flujo definido para la práctica.

## Ahead y behind

```text
main ahead 1   → tienes commits locales aún no publicados
main behind 2  → el remoto contiene commits que no has incorporado
```

## Rutina segura

Antes de empezar una tarea compartida:

```bash
git status
git switch main
git pull
```

Después crea tu rama de trabajo.

<div class="cla-note"><strong>Antes de sincronizar</strong><p>Comprueba que no tienes cambios locales inesperados. Entender el estado antes de pull o merge reduce conflictos y sorpresas.</p></div>

## Ejercicios propuestos

**Ejercicio 1.** Utiliza dos clones para simular dos equipos y observa cómo uno queda behind.

**Ejercicio 2.** Ejecuta `git fetch` y comprueba que tu archivo local no cambia automáticamente.

**Ejercicio 3.** Explica con una flecha la dirección de `push` y de `fetch`.

**Reto.** Construye un esquema que compare `fetch`, `pull` y `push` indicando origen, destino y si modifican la rama actual.

## Markdown de esta lección

Documenta la comparación mediante una tabla:

```markdown
| Comando | Función |
|---|---|
| `fetch` | Actualiza referencias remotas |
| `pull` | Trae e integra |
| `push` | Publica commits locales |
```

## Trabajo guiado en `dam-git-lab`

Realiza un cambio desde otra copia o desde GitHub, ejecuta `git fetch` y compara `main` con `origin/main` antes de integrar. Después practica `pull` y un nuevo `push`.

## Qué debes recordar

`fetch` consulta y trae referencias, `pull` incorpora novedades a tu trabajo actual y `push` publica commits. No uses estos términos como sinónimos.

<div class="cla-lesson-nav">
  <a href="/git/leccion14/">← Lección 14 · Clonar y continuar un repositorio</a>
  <a href="/git/leccion16/">Lección 16 · Trabajo colaborativo con ramas →</a>
</div>
