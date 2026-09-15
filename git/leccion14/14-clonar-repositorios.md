---
layout: lesson
route: git
lesson_id: leccion14
lesson_number: "14"
title: "Clonar y continuar un repositorio"
description: "Clona proyectos existentes y aprende el flujo habitual para continuar trabajando desde otro equipo."
permalink: /git/leccion14/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: clonar
    title: "Clonar"
  - id: clone-no-es-descargar-zip
    title: "Clone no es descargar ZIP"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Clonar y continuar un repositorio

Cuando un proyecto ya existe en GitHub o GitLab, normalmente no usamos `git init`. Lo habitual es clonar el repositorio completo.

## Qué vas a conseguir

- Crear una copia local con `git clone`.
- Comprender qué información se descarga.
- Verificar `origin` y la rama actual.
- Realizar cambios, commits y push desde el clon.
- Reconocer el flujo habitual al trabajar desde otro equipo.

## Clonar

Sitúate fuera de otros repositorios y ejecuta:

```bash
git clone <URL_DEL_REPOSITORIO>
```

Git crea una carpeta, descarga el historial y configura `origin`.

Entra en la carpeta:

```bash
cd nombre-repositorio
```

Comprueba:

```bash
git status
git remote -v
git log --oneline
```

## Clone no es descargar ZIP

Un ZIP contiene archivos. Un clon contiene además el historial y la configuración necesaria para continuar trabajando con Git.

```text
ZIP:   archivos actuales
CLONE: archivos + historial + referencias remotas
```

## Ejemplo guiado

Clona tu repositorio publicado en una carpeta diferente para simular otro equipo:

```bash
cd ..
git clone <URL> copia-practica
cd copia-practica
```

Modifica un archivo, crea un commit y publica:

```bash
git add README.md
git commit -m "Ampliar documentación desde el clon"
git push
```

## Ejercicios propuestos

**Ejercicio 1.** Clona un repositorio propio.

**Ejercicio 2.** Identifica automáticamente qué remoto ha creado Git.

**Ejercicio 3.** Explica por qué no deberías ejecutar `git init` dentro de un repositorio recién clonado.

**Reto.** Clona el mismo repositorio en dos carpetas diferentes y explica cómo pueden llegar a tener estados distintos.

## Qué debes recordar

Para comenzar a trabajar con un proyecto remoto existente, `git clone` es normalmente el punto de entrada. Obtienes los archivos y también la historia que los explica.

<div class="cla-lesson-nav">
  <a href="/git/leccion13/">← Lección 13 · Publicar un proyecto local en la nube</a>
  <a href="/git/leccion15/">Lección 15 · Fetch, pull y push →</a>
</div>
