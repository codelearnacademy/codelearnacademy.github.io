---
layout: lesson
route: ides
lesson_id: leccion05
lesson_file: 05-instalar-debian-13-7-xfce
lesson_number: "5"
title: Instalar Debian 13.7.0 con Xfce
description: "Instalar Debian 13.7.0 con Xfce: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion05/
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

# Instalar Debian 13.7.0 con Xfce

## Qué vas a conseguir

- Instalar Debian 13.7.0 desde `netinst`.
- Crear un usuario con capacidad de usar `sudo`.
- Instalar el escritorio Xfce y las utilidades estándar.

## Punto de partida

La VM arranca desde la ISO. Utilizaremos el instalador gráfico para reducir errores y mantener una configuración homogénea en el aula.

## Conceptos clave

- Si dejas **vacía la contraseña de root**, Debian deshabilita el inicio directo de `root` e instala `sudo`; el primer usuario podrá realizar tareas administrativas.
- Para una VM nueva, el particionado guiado usando el disco completo es adecuado.
- Xfce consume menos recursos que escritorios más pesados y deja más memoria disponible para el IDE.
- En `tasksel` conviene mantener **Utilidades estándar del sistema**.

## Ejemplo guiado

Selección recomendada:

```text
Instalador:       Graphical install
Idioma:           Español
Ubicación:        España
Teclado:          Español
Nombre máquina:   debian-java
Dominio:           (vacío)
root:             contraseña vacía
Usuario:          alumno
Particionado:     Guiado → utilizar todo el disco
```

En la selección de software:

```text
[✓] Entorno de escritorio Debian
[ ] GNOME
[✓] Xfce
[ ] KDE Plasma
[ ] Cinnamon
[ ] MATE
[ ] LXDE/LXQt
[✓] Utilidades estándar del sistema
```

Instala GRUB cuando el instalador lo solicite. Al terminar, reinicia y retira la ISO virtual si VirtualBox no lo hace automáticamente.

Fuente de referencia: [Guía oficial de instalación de Debian 13](https://www.debian.org/releases/trixie/amd64/index.es.html).

## Relación con el resto de la ruta

Con Debian ya instalado prepararemos integración de pantalla, portapapeles y uso cómodo de la VM.

## Ejercicios propuestos

1. Inicia sesión con el usuario creado.
2. Abre una terminal y ejecuta `cat /etc/debian_version`.
3. Comprueba que `sudo -v` acepta la contraseña de tu usuario.

## Qué debes recordar

- No trabajaremos habitualmente como `root`.
- Xfce es una decisión del laboratorio, no un requisito de Java.


<div class="cla-lesson-nav">
  <a href="/ides/leccion04/">← 4 · Crear la máquina virtual</a>
  <a href="/ides/leccion06/">6 · Integrar Debian con VirtualBox →</a>
</div>
