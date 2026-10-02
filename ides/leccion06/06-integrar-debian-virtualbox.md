---
layout: lesson
route: ides
lesson_id: leccion06
lesson_file: 06-integrar-debian-virtualbox
lesson_number: "6"
title: Integrar Debian con VirtualBox
description: "Integrar Debian con VirtualBox: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion06/
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

# Integrar Debian con VirtualBox

## Qué vas a conseguir

- Mejorar el uso de Debian dentro de VirtualBox.
- Preparar resolución, portapapeles y carpetas compartidas.
- Crear una instantánea del sistema recién instalado.

## Punto de partida

Debian ya arranca desde el disco virtual. Antes de instalar herramientas de desarrollo conviene dejar cómoda la interacción con la VM.

## Conceptos clave

- Las Guest Additions conectan mejor el sistema invitado con VirtualBox.
- Algunas funciones requieren módulos de kernel y cabeceras.
- Una instantánea antes de instalar IDEs facilita recuperar el laboratorio.

## Ejemplo guiado

Actualiza primero los índices e instala herramientas para compilar módulos:

```bash
sudo apt update
sudo apt install build-essential dkms linux-headers-amd64
```

En VirtualBox utiliza **Devices → Insert Guest Additions CD Image**. Dentro de Debian monta el medio si fuese necesario y ejecuta el instalador de Linux de las Guest Additions siguiendo las indicaciones de VirtualBox.

Después reinicia:

```bash
sudo reboot
```

Comprueba:

- cambio dinámico de resolución;
- portapapeles bidireccional;
- integración del ratón.

Finalmente crea una instantánea llamada:

```text
debian-13.7-base
```

## Relación con el resto de la ruta

A partir de aquí trabajaremos dentro de Debian. La siguiente lección prepara `apt` y herramientas comunes.

## Ejercicios propuestos

1. Activa el portapapeles bidireccional.
2. Redimensiona la ventana y comprueba que cambia la resolución.
3. Crea la instantánea `debian-13.7-base`.

## Qué debes recordar

- Las Guest Additions son integración de VirtualBox, no parte del JDK.
- Una instantánea no sustituye a Git ni a una copia de seguridad del proyecto.


<div class="cla-lesson-nav">
  <a href="/ides/leccion05/">← 5 · Instalar Debian 13.7.0 con Xfce</a>
  <a href="/ides/leccion07/">7 · Actualizar Debian y preparar herramientas básicas →</a>
</div>
