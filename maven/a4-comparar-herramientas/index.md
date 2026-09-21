---
layout: lesson
route: maven
lesson_id: ampliacion04
lesson_number: "A4"
title: "A4 · Maven frente a otras herramientas"
description: "Compara responsabilidades y elige una herramienta según el proyecto."
permalink: /maven/a4-comparar-herramientas/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: comparación-guiada
    title: "Comparación guiada"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# A4 · Maven frente a otras herramientas

Compara responsabilidades y elige una herramienta según el proyecto.
## Objetivo y punto de partida

Esta ampliación reúne las comparaciones de la ruta anterior. Necesitas comprender el flujo Java antes de buscar analogías con otros ecosistemas.

## Comparación guiada

| Ecosistema | Descriptor habitual | Dependencias y construcción |
|---|---|---|
| Maven/Java | `pom.xml` | Modelo de proyecto, dependencias, ciclos de vida y plugins |
| Gradle/Java | `build.gradle` o `build.gradle.kts` | Dependencias y grafo de tareas configurado con DSL |
| Node/npm | `package.json` | Paquetes y scripts definidos por el proyecto |
| Python | `pyproject.toml` | Metadatos y configuración; herramientas y backend elegidos por el proyecto |
| Go | `go.mod` | Módulos junto a compilación y pruebas de su toolchain |

`npm test` ejecuta el script `test` del proyecto; no garantiza un framework concreto. `pip` instala paquetes; no representa por sí solo todo el flujo de construcción y pruebas. Gradle permite adaptar tareas y utiliza un Wrapper, pero sus tareas no equivalen una a una a las fases Maven.

## Práctica guiada

Toma tres requisitos del gestor de tareas: resolver Gson, ejecutar tests y distribuir la aplicación. Localiza para cada uno la configuración Maven que lo realiza. Después elige otro ecosistema y consulta su documentación para identificar qué herramienta desempeña cada responsabilidad.

## Comprobación y errores habituales

No compares únicamente extensión del descriptor o cantidad de comandos. Un script `build` puede delegar en varias herramientas. Un lockfile de dependencias y un Wrapper de herramienta controlan aspectos distintos y no son sustitutos exactos.

Para elegir entre Maven y Gradle, considera el proyecto existente, conocimientos del equipo, plugins necesarios y complejidad del proceso. En un proyecto Maven sencillo, cambiar de herramienta solo por evitar XML puede añadir trabajo de migración sin resolver un problema concreto.

## Ejercicio

Escribe una decisión de cinco líneas: proyecto, requisitos, herramienta elegida, motivo y coste principal. Utiliza el gestor de tareas como caso concreto.

## Qué debes recordar

Compara responsabilidades y restricciones reales. Las analogías ayudan a orientarte, pero no deben ocultar diferencias en resolución, pruebas o distribución.

Referencias: [Gradle](https://docs.gradle.org/current/userguide/userguide.html), [Scripts npm](https://docs.npmjs.com/cli/using-npm/scripts), [Packaging Python](https://packaging.python.org/en/latest/), [Módulos Go](https://go.dev/ref/mod).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/a3-jar-dependencias/' | relative_url }}">← A3 · A3 · Generar un JAR con dependencias</a>
<a href="{{ '/maven/' | relative_url }}">Volver al índice →</a>
</nav>
