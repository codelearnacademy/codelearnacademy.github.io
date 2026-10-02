---
layout: lesson
route: ides
lesson_id: leccion10
lesson_file: 10-instalar-configurar-git
lesson_number: "10"
title: Instalar y configurar Git
description: "Instalar y configurar Git: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion10/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Instalar y configurar Git

## Qué vas a conseguir

- Instalar Git.
- Configurar identidad básica.
- Preparar un repositorio para el proyecto de la ruta.

## Punto de partida

Java y Maven ya están instalados. Git permitirá seguir cambios del proyecto mientras probamos distintos IDEs.

## Conceptos clave

- `user.name` y `user.email` identifican los commits.
- `.gitignore` evita versionar artefactos generados.
- El historial pertenece al proyecto, no al IDE.
- Cada IDE puede ofrecer una interfaz Git distinta sobre el mismo repositorio.

## Ejemplo guiado

```bash
sudo apt install -y git
git --version
```

Configura tu identidad:

```bash
git config --global user.name "Nombre Apellidos"
git config --global user.email "correo@example.com"
```

Comprueba:

```bash
git config --global --list
```

## Relación con el resto de la ruta

El proyecto Maven común se convertirá en repositorio Git antes de abrirlo en los cuatro entornos.

## Ejercicios propuestos

1. Instala Git.
2. Configura nombre y correo.
3. Ejecuta `git config --global --list` y revisa el resultado.

## Qué debes recordar

- La configuración global identifica tus commits.
- No copies literalmente el nombre y correo del ejemplo.


<div class="cla-lesson-nav">
  <a href="/ides/leccion09/">← 9 · Instalar y verificar Maven</a>
  <a href="/ides/leccion11/">11 · Crear el proyecto Maven común →</a>
</div>
