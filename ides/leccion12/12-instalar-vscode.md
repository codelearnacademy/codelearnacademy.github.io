---
layout: lesson
route: ides
lesson_id: leccion12
lesson_file: 12-instalar-vscode
lesson_number: "12"
title: Instalar Visual Studio Code
description: "Instalar Visual Studio Code: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion12/
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

# Instalar Visual Studio Code

## Qué vas a conseguir

- Instalar Visual Studio Code en Debian.
- Añadir el repositorio oficial para recibir actualizaciones.
- Comprobar el comando `code`.

## Punto de partida

VS Code es un editor extensible. Para convertirlo en un entorno Java añadiremos posteriormente las extensiones necesarias.

## Conceptos clave

- Microsoft distribuye un paquete `.deb` y un repositorio APT para Debian.
- La instalación oficial permite actualizar VS Code con el sistema.
- `code .` abre la carpeta actual desde terminal.

## Ejemplo guiado

La documentación oficial permite instalar el paquete `.deb` directamente:

```bash
sudo apt install ./<archivo-vscode>.deb
```

También documenta la configuración manual de su repositorio APT. Consulta siempre la versión actual de las instrucciones:

[Installing Visual Studio Code on Linux](https://code.visualstudio.com/docs/setup/linux)

Tras instalarlo:

```bash
code --version
```

Y desde el proyecto:

```bash
cd ~/laboratorio-ides/hola-ides
code .
```

## Relación con el resto de la ruta

Ahora instalaremos las extensiones Java y comprobaremos que VS Code detecta el JDK y Maven.

## Ejercicios propuestos

1. Instala VS Code mediante el método oficial para Debian.
2. Ejecuta `code --version`.
3. Abre `hola-ides` utilizando `code .`.

## Qué debes recordar

- VS Code no incluye por sí solo todo el soporte Java de un IDE.
- El proyecto debe abrirse por su carpeta raíz, donde está `pom.xml`.


<div class="cla-lesson-nav">
  <a href="/ides/leccion11/">← 11 · Crear el proyecto Maven común</a>
  <a href="/ides/leccion13/">13 · Configurar VS Code para Java →</a>
</div>
