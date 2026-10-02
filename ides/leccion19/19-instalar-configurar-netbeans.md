---
layout: lesson
route: ides
lesson_id: leccion19
lesson_file: 19-instalar-configurar-netbeans
lesson_number: "19"
title: Instalar y configurar Apache NetBeans
description: "Instalar y configurar Apache NetBeans: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion19/
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

# Instalar y configurar Apache NetBeans

## Qué vas a conseguir

- Instalar Apache NetBeans.
- Ejecutar NetBeans con un JDK compatible.
- Preparar el IDE para el proyecto Java 21.

## Punto de partida

Apache NetBeans publica un binario multiplataforma y, según la versión, enlaces a paquetes creados por colaboradores. Para mantener control sobre el entorno utilizaremos el binario oficial y nuestro JDK 21.

## Conceptos clave

- La versión estable actual debe consultarse siempre en la página oficial.
- En el momento de preparar esta ruta, Apache NetBeans 31 es la versión más reciente y soporta ejecutarse sobre JDK 21.
- El binario oficial es multiplataforma.
- La versión de Java del proyecto puede configurarse de manera independiente del runtime del IDE.

## Ejemplo guiado

Consulta:

[Apache NetBeans Releases](https://netbeans.apache.org/front/main/download/)

Descarga el binario oficial de la versión estable (`netbeans-<version>-bin.zip`), descomprímelo en una ubicación de aplicaciones del usuario o del sistema y arranca NetBeans desde su directorio `bin`.

Comprueba antes:

```bash
java -version
```

La página de NetBeans indica qué JDK soporta cada versión.

## Relación con el resto de la ruta

En la siguiente lección abriremos `hola-ides` como proyecto Maven existente.

## Ejercicios propuestos

1. Localiza la versión estable actual.
2. Comprueba que soporta JDK 21.
3. Descarga y descomprime el binario.
4. Inicia NetBeans.

## Qué debes recordar

- Distingue siempre una release oficial Apache de instaladores comunitarios.
- Consulta la compatibilidad de JDK de la versión que descargues.


<div class="cla-lesson-nav">
  <a href="/ides/leccion18/">← 18 · Importar y verificar el proyecto en Eclipse</a>
  <a href="/ides/leccion20/">20 · Abrir y verificar el proyecto en NetBeans →</a>
</div>
