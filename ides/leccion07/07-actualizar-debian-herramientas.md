---
layout: lesson
route: ides
lesson_id: leccion07
lesson_file: 07-actualizar-debian-herramientas
lesson_number: "7"
title: Actualizar Debian y preparar herramientas básicas
description: "Actualizar Debian y preparar herramientas básicas: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion07/
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

# Actualizar Debian y preparar herramientas básicas

## Qué vas a conseguir

- Actualizar el sistema.
- Instalar utilidades que usaremos durante toda la ruta.
- Comprobar arquitectura, versión y conectividad.

## Punto de partida

Tenemos una instalación limpia. Antes de añadir repositorios o IDEs debemos actualizar los paquetes de Debian.

## Conceptos clave

- `apt update` actualiza el índice de paquetes.
- `apt full-upgrade` aplica las actualizaciones disponibles resolviendo cambios de dependencias.
- `curl`, `wget`, `unzip`, `zip` y `gpg` aparecerán en varias instalaciones.
- `lsb_release` y `/etc/os-release` ayudan a identificar el sistema.

## Ejemplo guiado

```bash
sudo apt update
sudo apt full-upgrade -y

sudo apt install -y   curl wget unzip zip gpg ca-certificates   build-essential
```

Comprueba:

```bash
uname -m
cat /etc/os-release
ip a
```

Esperamos una arquitectura:

```text
x86_64
```

## Relación con el resto de la ruta

El sistema ya está preparado para instalar el JDK 21, que será la base común de todos los IDEs.

## Ejercicios propuestos

1. Ejecuta la actualización completa.
2. Comprueba que tienes conexión con `ping -c 3 debian.org`.
3. Anota la versión mostrada en `/etc/os-release`.

## Qué debes recordar

- Actualizar el sistema antes de añadir herramientas reduce problemas de dependencias.
- Las órdenes con `sudo` modifican el sistema y deben entenderse antes de ejecutarse.


<div class="cla-lesson-nav">
  <a href="/ides/leccion06/">← 6 · Integrar Debian con VirtualBox</a>
  <a href="/ides/leccion08/">8 · Instalar y configurar JDK 21 →</a>
</div>
