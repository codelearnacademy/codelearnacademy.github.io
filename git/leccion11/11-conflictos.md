---
layout: lesson
route: git
lesson_id: leccion11
lesson_number: "11"
title: "Resolver conflictos"
description: "Provoca, interpreta y resuelve conflictos de fusión sin perder el trabajo de ninguna rama."
permalink: /git/leccion11/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: crear-un-conflicto-deliberadamente
    title: "Crear un conflicto deliberadamente"
  - id: marcadores-de-conflicto
    title: "Marcadores de conflicto"
  - id: el-conflicto-no-es-un-error-catastrófico
    title: "El conflicto no es un error catastrófico"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Resolver conflictos

Git puede fusionar muchos cambios automáticamente. Un conflicto aparece cuando no puede decidir qué versión debe conservar en una zona determinada.

## Qué vas a conseguir

- Comprender por qué aparece un conflicto.
- Provocar un conflicto de forma controlada.
- Interpretar los marcadores `<<<<<<<`, `=======` y `>>>>>>>`.
- Resolver el archivo manualmente.
- Completar el merge y comprobar el historial.

## Crear un conflicto deliberadamente

En `main`, crea `saludo.txt`:

```text
Hola clase
```

Haz commit. Crea una rama:

```bash
git switch -c feature/saludo
```

Cambia la línea por:

```text
Hola equipo de desarrollo
```

Haz commit. Vuelve a `main` y modifica la misma línea:

```text
Bienvenida al curso
```

Haz otro commit. Ahora fusiona:

```bash
git merge feature/saludo
```

## Marcadores de conflicto

Git puede dejar algo parecido a:

```text
<<<<<<< HEAD
Bienvenida al curso
=======
Hola equipo de desarrollo
>>>>>>> feature/saludo
```

Tu trabajo consiste en decidir el contenido final y eliminar todos los marcadores.

Por ejemplo:

```text
Bienvenida al equipo de desarrollo
```

Después:

```bash
git add saludo.txt
git commit
```

## El conflicto no es un error catastrófico

Un conflicto significa que Git necesita una decisión humana.

<div class="cla-note"><strong>Método</strong><p>Lee ambas versiones, comprende la intención de cada cambio, construye el contenido final, prueba si es necesario y solo entonces marca el archivo como resuelto.</p></div>

<!-- IMAGEN RECOMENDADA: /assets/images/git/leccion11/conflicto-merge.svg
Dos ramas modificando la misma línea y convergiendo en un punto de conflicto. -->

## Ejercicios propuestos

**Ejercicio 1.** Reproduce el conflicto guiado y resuélvelo.

**Ejercicio 2.** Explica qué representa `HEAD` dentro de los marcadores.

**Ejercicio 3.** Tras resolver, utiliza `git status` antes del commit final y describe las instrucciones que muestra Git.

**Reto.** Provoca un conflicto en un archivo Markdown con dos cambios que quieras conservar. Resuélvelo combinando ambas ideas en lugar de elegir una sola.

## Qué debes recordar

No tengas miedo a los conflictos. Evitarlos por completo no es realista en trabajo colaborativo. La habilidad importante es reconocerlos, comprenderlos y resolverlos de forma deliberada.

<div class="cla-lesson-nav">
  <a href="/git/leccion10/">← Lección 10 · Fusionar ramas con merge</a>
  <a href="/git/leccion12/">Lección 12 · Repositorios remotos: GitHub y GitLab →</a>
</div>
