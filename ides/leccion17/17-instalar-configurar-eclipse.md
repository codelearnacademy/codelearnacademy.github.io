---
layout: lesson
route: ides
lesson_id: leccion17
lesson_file: 17-instalar-configurar-eclipse
lesson_number: "17"
title: Instalar y configurar Eclipse IDE
description: "Instalar y configurar Eclipse IDE: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion17/
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

# Instalar y configurar Eclipse IDE

## Qué vas a conseguir

- Instalar Eclipse IDE para desarrollo Java.
- Seleccionar el paquete adecuado.
- Preparar un workspace separado del proyecto.

## Punto de partida

Eclipse distribuye varios paquetes. Para esta ruta utilizaremos **Eclipse IDE for Java Developers**, que incluye herramientas Java, Git y Maven.

## Conceptos clave

- El **workspace** guarda metadatos de Eclipse y no tiene que coincidir con la carpeta del repositorio.
- Eclipse Installer permite elegir el paquete y la carpeta de instalación.
- Las versiones actuales del paquete Java incluyen integración Maven.
- El proyecto seguirá viviendo en `~/laboratorio-ides/hola-ides`.

## Ejemplo guiado

Descarga el **Eclipse Installer** para Linux desde:

[Eclipse Downloads](https://www.eclipse.org/downloads/packages/)

En Linux, descomprime el instalador y ejecútalo. Selecciona:

```text
Eclipse IDE for Java Developers
```

Crea un workspace, por ejemplo:

```text
~/workspace-eclipse
```

## Relación con el resto de la ruta

La próxima lección importa el proyecto mediante Maven y comprueba JDK, JUnit y Git.

## Ejercicios propuestos

1. Instala Eclipse IDE for Java Developers.
2. Configura `~/workspace-eclipse`.
3. Abre las preferencias de Java y localiza los JRE/JDK instalados.

## Qué debes recordar

- Workspace y repositorio son conceptos diferentes.
- No copies el proyecto dentro del workspace si no es necesario.


<div class="cla-lesson-nav">
  <a href="/ides/leccion16/">← 16 · Abrir y verificar el proyecto en IntelliJ IDEA</a>
  <a href="/ides/leccion18/">18 · Importar y verificar el proyecto en Eclipse →</a>
</div>
