---
layout: lesson
route: git
lesson_id: leccion02
lesson_number: "02"
title: "Instalación y configuración de Git"
description: "Instala Git, identifica su versión y configura tu identidad para comenzar a trabajar con repositorios."
permalink: /git/leccion02/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: configurar-la-identidad
    title: "Configurar la identidad"
  - id: configuración-global-y-local
    title: "Configuración global y local"
  - id: preparar-el-entorno-de-prácticas
    title: "Preparar el entorno de prácticas"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Instalación y configuración de Git

Antes de crear repositorios necesitamos comprobar que Git está disponible y configurar la identidad que quedará asociada a nuestros commits.

## Qué vas a conseguir

- Comprobar que Git está instalado.
- Configurar nombre y correo del autor.
- Diferenciar configuración global y local.
- Consultar los valores activos de configuración.
- Preparar una carpeta de trabajo para las siguientes prácticas.

## Punto de partida

Abre un terminal. En Windows puedes utilizar PowerShell, Windows Terminal o la terminal integrada de tu editor. En Linux y macOS puedes utilizar el terminal del sistema.

Comprueba Git:

```bash
git --version
```

Deberías obtener una respuesta similar a:

```text
git version 2.x.x
```

No es necesario que tu número coincida exactamente.

## Configurar la identidad

Git guarda un autor en cada commit. Configura tu nombre:

```bash
git config --global user.name "Ana Pérez"
```

Y tu correo:

```bash
git config --global user.email "ana@example.com"
```

Comprueba ambos valores:

```bash
git config --global user.name
git config --global user.email
```

<div class="cla-note"><strong>Importante</strong><p>En un equipo compartido del aula, revisa siempre la identidad antes de hacer commits. No utilices los datos de otra persona.</p></div>

## Configuración global y local

La opción `--global` aplica una configuración al usuario del equipo.

Dentro de un repositorio también podemos definir valores específicos:

```bash
git config user.name "Ana Aula"
```

Un valor local tiene prioridad dentro de ese repositorio.

Consulta todas las opciones activas y su origen:

```bash
git config --list --show-origin
```

## Preparar el entorno de prácticas

Crea una carpeta donde realizarás los ejercicios:

```bash
mkdir practicas-git
cd practicas-git
```

Todavía no es un repositorio Git. En la siguiente lección lo convertiremos en uno.

## Ejemplo guiado

Comprueba estos comandos en orden:

```bash
git --version
git config --global user.name
git config --global user.email
```

Si falta alguno de los dos valores de identidad, configúralo y vuelve a consultarlo.

## Ejercicios propuestos

**Ejercicio 1.** Localiza la versión de Git instalada en tu equipo.

**Ejercicio 2.** Configura tu nombre y correo y verifica que se muestran correctamente.

**Ejercicio 3.** Ejecuta `git config --list --show-origin` e identifica qué archivo contiene `user.name`.

**Reto.** Explica cuándo podría ser útil tener un nombre o correo local diferente del global.

## Qué debes recordar

Antes de comenzar: `git --version` verifica la instalación y `git config` controla la configuración. Cada commit debe quedar asociado a la identidad correcta.

<div class="cla-lesson-nav">
  <a href="/git/leccion01/">← Lección 01 · Introducción a Git y al control de versiones</a>
  <a href="/git/leccion03/">Lección 03 · Crear el primer repositorio →</a>
</div>
