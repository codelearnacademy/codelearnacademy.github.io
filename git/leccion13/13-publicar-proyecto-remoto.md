---
layout: lesson
route: git
lesson_id: leccion13
lesson_number: "13"
title: "Publicar un proyecto local en la nube"
description: "Conecta un repositorio local con un remoto y publica su historial mediante push."
permalink: /git/leccion13/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: preparar-el-remoto
    title: "Preparar el remoto"
  - id: añadir-origin
    title: "Añadir origin"
  - id: primer-push
    title: "Primer push"
  - id: qué-significa-u
    title: "Qué significa -u"
  - id: verificar-en-la-plataforma
    title: "Verificar en la plataforma"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Publicar un proyecto local en la nube

En esta lección conectarás un repositorio existente con un repositorio vacío en GitHub o GitLab y publicarás su historial.

## Qué vas a conseguir

- Crear o disponer de un repositorio remoto vacío.
- Añadirlo como `origin`.
- Verificar la dirección configurada.
- Realizar el primer `push`.
- Comprender qué significa configurar upstream.

## Preparar el remoto

En GitHub o GitLab crea un repositorio vacío. Para esta práctica evita que la plataforma cree automáticamente README u otros commits si tu proyecto local ya tiene historial.

Obtendrás una dirección del repositorio.

## Añadir origin

Desde tu repositorio local:

```bash
git remote add origin <URL_DEL_REPOSITORIO>
```

Comprueba:

```bash
git remote -v
```

## Primer push

Publica `main` y establece la rama remota asociada:

```bash
git push -u origin main
```

Después del primer envío suele bastar con:

```bash
git push
```

## Qué significa -u

La opción configura una relación de seguimiento entre la rama local y su rama remota correspondiente.

Podemos pensar:

```text
main local  ←→  origin/main
```

## Verificar en la plataforma

Abre el repositorio en GitHub o GitLab y comprueba:

- archivos;
- commits;
- mensajes;
- rama principal.

El historial remoto debe corresponder con el local.

## Ejemplo guiado

```bash
git status
git log --oneline
git remote add origin <URL>
git remote -v
git push -u origin main
```

No copies la URL de otra persona ni publiques credenciales.

## Ejercicios propuestos

**Ejercicio 1.** Publica un repositorio con al menos tres commits.

**Ejercicio 2.** Compara `git log --oneline` con el historial mostrado en la web.

**Ejercicio 3.** Explica con tus palabras la diferencia entre `origin` y `main`.

**Reto.** Realiza un nuevo commit local, comprueba que todavía no aparece en la web, ejecuta `git push` y verifica el cambio.

## Qué debes recordar

`git remote add` conecta el repositorio con una dirección; `git push` envía commits y referencias al remoto. Publicar no crea los commits: los commits ya existían en local.

<div class="cla-lesson-nav">
  <a href="/git/leccion12/">← Lección 12 · Repositorios remotos: GitHub y GitLab</a>
  <a href="/git/leccion14/">Lección 14 · Clonar y continuar un repositorio →</a>
</div>
