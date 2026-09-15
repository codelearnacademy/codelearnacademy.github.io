---
layout: lesson
route: git
lesson_id: leccion01
lesson_number: "01"
title: "Introducción a Git y al control de versiones"
description: "Comprende qué problema resuelve Git y diferencia un repositorio local de un servicio como GitHub o GitLab."
permalink: /git/leccion01/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: qué-problema-resuelve-el-control-de-versiones
    title: "Qué problema resuelve el control de versiones"
  - id: git-no-es-github
    title: "Git no es GitHub"
  - id: qué-es-un-repositorio
    title: "Qué es un repositorio"
  - id: qué-es-un-commit
    title: "Qué es un commit"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicio-guiado
    title: "Ejercicio guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Introducción a Git y al control de versiones

Git es una herramienta para **registrar la evolución de un proyecto**. Permite saber qué cambió, cuándo cambió, quién realizó el cambio y recuperar estados anteriores cuando algo sale mal.

## Qué vas a conseguir

- Comprender por qué se utiliza control de versiones.
- Diferenciar Git, GitHub y GitLab.
- Entender qué es un repositorio y qué representa un commit.
- Reconocer las ventajas del historial frente a las copias manuales.
- Identificar el flujo general de trabajo que utilizaremos durante la ruta.

## Punto de partida

Imagina que trabajas durante varias semanas sobre un proyecto y terminas con carpetas como estas:

```text
proyecto/
proyecto-bueno/
proyecto-bueno-2/
proyecto-final/
proyecto-final-ahora-si/
```

Este método parece sencillo, pero pronto aparecen preguntas difíciles: ¿qué archivo cambió?, ¿qué versión funcionaba?, ¿qué hizo otra persona?, ¿cómo combinamos dos trabajos distintos?

Git resuelve estas preguntas guardando un **historial estructurado** de cambios.

## Qué problema resuelve el control de versiones

Un sistema de control de versiones permite:

- registrar cambios de forma ordenada;
- recuperar versiones anteriores;
- comparar estados del proyecto;
- experimentar sin destruir una versión estable;
- trabajar con otras personas;
- saber qué cambio introdujo un error.

<div class="cla-note"><strong>Idea clave</strong><p>Git no sustituye a las copias de seguridad. Su objetivo principal es gestionar la evolución del contenido de un proyecto y facilitar el trabajo coordinado.</p></div>

## Git no es GitHub

**Git** es el sistema de control de versiones que funciona en tu equipo.

**GitHub** y **GitLab** son plataformas que pueden alojar repositorios Git en servidores y añadir funciones de colaboración.

```text
Tu ordenador
┌──────────────────┐
│ Git              │
│ repositorio local│
└────────┬─────────┘
         │ Internet
         ▼
┌──────────────────┐
│ GitHub / GitLab  │
│ repositorio remoto│
└──────────────────┘
```

Puedes utilizar Git sin GitHub ni GitLab. Durante las primeras lecciones trabajaremos solamente en local para comprender bien el modelo.

<!-- IMAGEN RECOMENDADA: /assets/images/git/leccion01/git-local-remoto.svg
Mostrar un portátil con un repositorio Git local y, separado, GitHub/GitLab como repositorios remotos. -->

## Qué es un repositorio

Un **repositorio** es un proyecto cuyo historial está gestionado por Git.

Un repositorio contiene los archivos actuales y la información necesaria para reconstruir su evolución.

Por ejemplo:

```text
guia-clase/
├── README.md
├── equipo.md
└── recursos.md
```

Git puede registrar cómo cambia cada archivo a lo largo del tiempo.

## Qué es un commit

Un **commit** representa un punto concreto del historial del proyecto.

Podemos imaginarlo como una fotografía identificada y acompañada de un mensaje:

```text
Commit A  Crear README inicial
    ↓
Commit B  Añadir normas del equipo
    ↓
Commit C  Añadir recursos recomendados
```

Los commits permiten volver atrás, comparar versiones y comprender la evolución del trabajo.

## Ejemplo guiado

Supón que estás creando una guía de clase.

Día 1:

```text
README.md
```

Día 2 añades:

```text
recursos.md
```

Día 3 corriges el README.

Sin Git solo tienes el estado actual. Con Git puedes conservar una historia como:

```text
A -- B -- C
```

Cada letra representa un commit y cada commit describe un cambio significativo.

## Ejercicio guiado

Sin utilizar todavía ningún comando, escribe en una hoja o documento tres cambios que harías en un proyecto sencillo, por ejemplo una guía de películas.

Ejemplo:

```text
1. Crear lista inicial de películas.
2. Añadir una sección de ciencia ficción.
3. Corregir títulos y descripciones.
```

Convierte cada cambio en un posible mensaje de commit:

```text
Crear lista inicial de películas
Añadir sección de ciencia ficción
Corregir títulos de películas
```

## Ejercicios propuestos

**Ejercicio 1.** Explica con tus palabras la diferencia entre Git y GitHub.

**Ejercicio 2.** Escribe tres problemas que pueden aparecer al compartir un proyecto mediante archivos ZIP enviados por correo.

**Ejercicio 3.** Indica cuáles de estas situaciones podrían resolverse mejor con Git: recuperar una versión anterior, enviar un mensaje instantáneo, saber quién modificó una línea, fusionar trabajo paralelo.

**Reto.** Diseña el historial de cinco commits para un proyecto ficticio. Cada mensaje debe describir una modificación concreta.

## Qué debes recordar

Git gestiona **historial**, no simplemente archivos. GitHub y GitLab pueden alojar ese historial y facilitar la colaboración, pero el aprendizaje comienza en local.

<div class="cla-lesson-nav">
  <a href="/git/">← Ruta Git</a>
  <a href="/git/leccion02/">Lección 02 · Instalación y configuración de Git →</a>
</div>
