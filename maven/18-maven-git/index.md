---
layout: lesson
route: maven
lesson_id: principal18
lesson_number: "18"
title: "Maven dentro del flujo Git"
description: "Versiona lo necesario y reconstruye desde un clon limpio."
permalink: /maven/18-maven-git/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Maven dentro del flujo Git

Versiona lo necesario y reconstruye desde un clon limpio.
## Objetivo y punto de partida

Necesitas Git y el proyecto con Wrapper. Si tu carpeta no tiene repositorio, ejecuta `git init`.

## Práctica guiada

Crea `.gitignore`:

```gitignore
target/
.idea/
*.iml
.vscode/
tareas.json
settings-empresa.xml
```

No ignores `.mvn/`: contiene configuración necesaria. Si tienes otra ruta para settings privados, añádela explícitamente. Puedes versionar una plantilla sin secretos.

```bash
git add pom.xml src .gitignore mvnw mvnw.cmd .mvn
./mvnw clean verify
git diff --cached
git commit -m "Crea proyecto Maven verificable"
```

En Windows sustituye el comando de Wrapper por `.\mvnw.cmd clean verify`. Después, si el script necesita conservar permiso de ejecución en Git, aplica el ajuste de la lección anterior y realiza el commit correspondiente.

Para una prueba independiente usa otra carpeta:

```bash
git clone /ruta/real/gestor-tareas gestor-tareas-clon
cd gestor-tareas-clon
./mvnw clean verify
```

Sustituye la ruta por la de tu repositorio. Una clonación local permite practicar sin publicar nada. Si el proyecto utiliza repositorios privados, el equipo receptor necesita settings y permisos equivalentes.

## Comprobación y errores habituales

`git status --short` no debe mostrar `target/`. Comprueba con `git ls-files .mvn mvnw mvnw.cmd` que el Wrapper está incluido. Un archivo ya versionado no deja de estarlo por añadirlo después a `.gitignore`.

Un clon limpio valida que no dependes de archivos fuente olvidados. No demuestra por sí solo resultados idénticos byte a byte: también influyen versiones, timestamps y entorno. Evita rangos de versiones y dependencias snapshot en una entrega estable.

## Ejercicio

Crea una rama `feature/prueba-titulo`, añade una prueba, verifica y realiza un commit. Documenta cómo reproducir el build desde el clon.

## Qué debes recordar

Git guarda entradas y configuración; Maven reconstruye salidas. La reproducibilidad exige declarar lo necesario y controlar herramientas y dependencias.

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/17-maven-wrapper/' | relative_url }}">← 17 · Crear y utilizar Maven Wrapper</a>
<a href="{{ '/maven/19-maven-ci/' | relative_url }}">19 · Automatizar el build en CI →</a>
</nav>
