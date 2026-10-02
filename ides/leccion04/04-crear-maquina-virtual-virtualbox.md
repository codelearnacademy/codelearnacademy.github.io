---
layout: lesson
route: ides
lesson_id: leccion04
lesson_file: 04-crear-maquina-virtual-virtualbox
lesson_number: "4"
title: Crear la máquina virtual
description: "Crear la máquina virtual: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion04/
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

# Crear la máquina virtual

## Qué vas a conseguir

- Crear una VM preparada para Debian 13.7.0.
- Conectar la ISO `netinst`.
- Definir recursos adecuados para trabajar con IDEs Java.

## Punto de partida

Ya tienes VirtualBox instalado y la ISO de Debian descargada. Ahora debes crear el hardware virtual antes de arrancar el instalador.

## Conceptos clave

- RAM y CPU asignadas a la VM se comparten con el host mientras está encendida.
- Un disco dinámico puede tener 80 GB de capacidad sin ocuparlos inicialmente.
- NAT es suficiente para descargar paquetes y herramientas.
- Una instantánea permite volver a un estado anterior del laboratorio.

## Ejemplo guiado

En VirtualBox:

1. Crea una máquina llamada `debian-java-ides`.
2. Selecciona Linux / Debian 64-bit.
3. Asigna **4 CPU** y **8 GB de RAM** como configuración recomendada.
4. Crea un disco **VDI dinámico de 80 GB**.
5. Mantén el adaptador de red en **NAT**.
6. Monta `debian-13.7.0-amd64-netinst.iso` en la unidad óptica.
7. Arranca la VM.

Antes de continuar comprueba que aparece el menú del instalador de Debian.

## Relación con el resto de la ruta

La siguiente lección recorre las decisiones de instalación que dejarán una Debian con Xfce preparada para el laboratorio.

## Ejercicios propuestos

1. Haz una captura de la configuración de CPU, RAM y disco.
2. Explica qué ventaja tiene un disco dinámico.
3. Verifica que el instalador arranca desde la ISO.

## Qué debes recordar

- La ISO es un medio de arranque; no es el disco del sistema.
- El disco virtual de 80 GB contendrá Debian, el JDK, Maven y los IDEs.


<div class="cla-lesson-nav">
  <a href="/ides/leccion03/">← 3 · Descargar Debian 13.7.0 netinst</a>
  <a href="/ides/leccion05/">5 · Instalar Debian 13.7.0 con Xfce →</a>
</div>
