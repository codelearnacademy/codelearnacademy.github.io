---
layout: lesson
route: ides
lesson_id: leccion20
lesson_file: 20-proyecto-maven-netbeans
lesson_number: "20"
title: Abrir y verificar el proyecto en NetBeans
description: "Abrir y verificar el proyecto en NetBeans: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion20/
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

# Abrir y verificar el proyecto en NetBeans

## Qué vas a conseguir

- Abrir el proyecto Maven con NetBeans.
- Ejecutar aplicación y pruebas.
- Comprobar el build desde terminal.

## Punto de partida

NetBeans está ejecutándose. No necesitas crear un proyecto nuevo porque `pom.xml` ya describe el proyecto.

## Conceptos clave

- NetBeans reconoce proyectos Maven de forma nativa.
- La acción Run puede asociarse al `main`.
- La vista de tests permite ejecutar JUnit.
- Git puede trabajar sobre el mismo repositorio.

## Ejemplo guiado

Utiliza **File → Open Project** y selecciona:

```text
~/laboratorio-ides/hola-ides
```

Después:

1. Espera a que Maven resuelva el proyecto.
2. Comprueba Java 21 en las propiedades.
3. Ejecuta `App`.
4. Ejecuta `AppTest`.
5. Desde terminal:

```bash
cd ~/laboratorio-ides/hola-ides
mvn clean test
git status
```

## Relación con el resto de la ruta

Ya hemos validado el mismo código en los cuatro IDEs. Ahora compararemos qué aporta cada herramienta.

## Ejercicios propuestos

1. Ejecuta aplicación y test.
2. Localiza las dependencias Maven en el IDE.
3. Localiza el historial Git.
4. Compara el tiempo de apertura con los otros IDEs.

## Qué debes recordar

- NetBeans interpreta el mismo `pom.xml`.
- El proyecto debe seguir funcionando aunque elimines los metadatos locales de un IDE.


<div class="cla-lesson-nav">
  <a href="/ides/leccion19/">← 19 · Instalar y configurar Apache NetBeans</a>
  <a href="/ides/leccion21/">21 · El mismo proyecto en cuatro IDEs →</a>
</div>
