---
layout: lesson
route: ides
lesson_id: leccion02
lesson_file: 02-maquinas-virtuales-e-hipervisores
lesson_number: "2"
title: Máquinas virtuales e hipervisores
description: "Máquinas virtuales e hipervisores: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion02/
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

# Máquinas virtuales e hipervisores

## Qué vas a conseguir

- Entender qué papel tienen host, hipervisor y guest.
- Identificar los recursos que necesita la VM del laboratorio.
- Preparar VirtualBox en la máquina física.

## Punto de partida

La máquina física será el **host**. VirtualBox actuará como hipervisor y Debian será el sistema **guest**. La VM nos permite repetir el laboratorio sin modificar el entorno principal del equipo.

## Conceptos clave

- **Host:** sistema operativo real del equipo.
- **Guest:** sistema operativo instalado dentro de la VM.
- **Hipervisor:** software que crea y ejecuta máquinas virtuales.
- **NAT:** red sencilla para que Debian tenga acceso a Internet.
- **Disco dinámico:** ocupa espacio en el host según se va utilizando.

## Ejemplo guiado

Configuración recomendada para esta ruta:

```text
Nombre:       debian-java-ides
SO invitado:  Debian (64-bit)
CPU:          4 vCPU
RAM:          8 GB recomendados
Disco:        60 GB VDI dinámico
Red:          NAT
Vídeo:        128 MB
```

> Si el equipo físico tiene pocos recursos, puedes reducir la RAM de la VM, pero los cuatro IDEs no deben ejecutarse simultáneamente.

Descarga VirtualBox desde su [sitio oficial](https://www.virtualbox.org/wiki/Downloads) para el sistema operativo del host.

## Relación con el resto de la ruta

En la siguiente lección descargaremos la imagen `netinst` que se conectará a la unidad óptica virtual.

## Ejercicios propuestos

1. Comprueba que la virtualización por hardware está habilitada en tu equipo.
2. Descarga e instala [VirtualBox](https://www.oracle.com/es/virtualization/technologies/vm/downloads/virtualbox-downloads.html).
3. Anota CPU, RAM y espacio libre del host y decide qué recursos puedes dedicar a la VM.

## Qué debes recordar

- La VM debe tener recursos suficientes sin dejar al host sin memoria.
- No necesitas cuatro máquinas: todos los IDEs se instalarán en la misma Debian.


<div class="cla-lesson-nav">
  <a href="/ides/leccion01/">← 1 · Qué es un IDE y qué vamos a construir</a>
  <a href="/ides/leccion03/">3 · Descargar Debian 13.7.0 netinst →</a>
</div>
