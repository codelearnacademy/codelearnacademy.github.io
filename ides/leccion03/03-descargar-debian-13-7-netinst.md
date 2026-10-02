---
layout: lesson
route: ides
lesson_id: leccion03
lesson_file: 03-descargar-debian-13-7-netinst
lesson_number: "3"
title: Descargar Debian 13.7.0 netinst
description: "Descargar Debian 13.7.0 netinst: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion03/
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

# Descargar Debian 13.7.0 netinst

## Qué vas a conseguir

- Descargar la imagen pequeña oficial de Debian 13.7.0.
- Identificar la arquitectura `amd64`.
- Verificar que trabajas con la ISO `netinst`.

## Punto de partida

Debian ofrece una imagen de instalación pequeña que descarga durante la instalación los paquetes que necesita. Es adecuada para este laboratorio porque la VM tendrá conexión a Internet.

## Conceptos clave

- Debian 13 usa el nombre en clave **trixie**.
- La versión utilizada en la ruta es **Debian 13.7.0 estable**.
- Para un PC convencional de 64 bits utilizaremos **amd64**.
- La modalidad **netinst** contiene el instalador y un conjunto mínimo de paquetes.

## Ejemplo guiado

Entra en la página oficial:

- [Descargar Debian](https://www.debian.org/distrib/)
- [Guía de instalación de Debian 13](https://www.debian.org/releases/trixie/installmanual.es.html)

Selecciona:

```text
PC de 64 bits
└── netinst ISO
```

El fichero tendrá un nombre similar a:

```text
debian-13.7.0-amd64-netinst.iso
```

<div class="cla-note"><strong>Importante</strong><p>La imagen netinst necesita conexión a Internet durante la instalación para descargar el escritorio y otros paquetes seleccionados.</p></div>

## Relación con el resto de la ruta

La ISO descargada será el medio de instalación que montaremos al crear la VM.

## Ejercicios propuestos

1. Descarga la ISO `amd64 netinst`.
2. Localiza en la web de Debian los ficheros de suma de comprobación.
3. Guarda la ISO en una carpeta dedicada al laboratorio.

## Qué debes recordar

- `amd64` identifica la arquitectura PC de 64 bits.
- `netinst` no es una edición de escritorio: es un medio de instalación pequeño basado en red.


<div class="cla-lesson-nav">
  <a href="/ides/leccion02/">← 2 · Máquinas virtuales e hipervisores</a>
  <a href="/ides/leccion04/">4 · Crear la máquina virtual →</a>
</div>
