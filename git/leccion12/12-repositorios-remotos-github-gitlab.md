---
layout: lesson
route: git
lesson_id: leccion12
lesson_number: "12"
title: "Repositorios remotos: GitHub y GitLab"
description: "Diferencia Git de GitHub y GitLab y comprende origin, remotos y autenticación."
permalink: /git/leccion12/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: git-frente-a-github-y-gitlab
    title: "Git frente a GitHub y GitLab"
  - id: qué-es-un-remoto
    title: "Qué es un remoto"
  - id: https-y-ssh
    title: "HTTPS y SSH"
  - id: ejemplo-conceptual
    title: "Ejemplo conceptual"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Repositorios remotos: GitHub y GitLab

Hasta ahora todo el trabajo ha ocurrido en tu equipo. Un repositorio remoto permite almacenar y compartir el historial en otro servidor.

## Qué vas a conseguir

- Diferenciar repositorio local y remoto.
- Comprender el papel de GitHub y GitLab.
- Conocer el nombre habitual `origin`.
- Consultar remotos con `git remote`.
- Entender las opciones habituales de autenticación sin compartir credenciales.

## Git frente a GitHub y GitLab

```text
Git
Sistema de control de versiones
        ↓ puede sincronizarse con
GitHub / GitLab
Servicios que alojan repositorios y añaden colaboración
```

Entre las funciones de estas plataformas encontramos:

- repositorios privados o públicos;
- gestión de usuarios y permisos;
- Pull Requests o Merge Requests;
- revisión de cambios;
- incidencias;
- automatización CI/CD.

## Qué es un remoto

Git puede asociar nombres a ubicaciones remotas.

Consulta:

```bash
git remote -v
```

Un repositorio creado únicamente con `git init` normalmente no tendrá ninguno.

El nombre más común del remoto principal es:

```text
origin
```

`origin` es una convención, no una palabra mágica.

## HTTPS y SSH

Las plataformas suelen permitir conexiones mediante HTTPS o SSH. La configuración concreta depende de la plataforma y de las políticas de tu organización.

Nunca incluyas contraseñas o tokens dentro de archivos versionados.

<div class="cla-note"><strong>Seguridad</strong><p>Utiliza los mecanismos de autenticación proporcionados por GitHub, GitLab o tu centro. No pegues tokens, claves privadas ni credenciales en README, capturas o commits.</p></div>

## Ejemplo conceptual

Tu repositorio local puede contener:

```text
A --- B --- C  main
```

Y el remoto puede tener inicialmente:

```text
A --- B
```

Al publicar el commit C, ambos quedan sincronizados.

## Ejercicios propuestos

**Ejercicio 1.** Explica qué ventajas aporta un remoto frente a copiar la carpeta en una memoria USB.

**Ejercicio 2.** Indica qué funciones pertenecen a Git y cuáles pertenecen a GitHub/GitLab: commit, branch, Pull Request, merge, issue.

**Ejercicio 3.** Ejecuta `git remote -v` en un repositorio local aún no conectado.

**Reto.** Dibuja local y remoto con historiales diferentes y explica qué tendría que ocurrir para sincronizarlos.

## Qué debes recordar

Git funciona en local. GitHub y GitLab alojan repositorios Git y añaden herramientas de colaboración. A partir de la siguiente lección conectaremos ambos mundos.

<div class="cla-lesson-nav">
  <a href="/git/leccion11/">← Lección 11 · Resolver conflictos</a>
  <a href="/git/leccion13/">Lección 13 · Publicar un proyecto local en la nube →</a>
</div>
