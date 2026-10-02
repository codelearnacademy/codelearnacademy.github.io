---
layout: lesson
route: ides
lesson_id: leccion16
lesson_file: 16-proyecto-maven-intellij
lesson_number: "16"
title: Abrir y verificar el proyecto en IntelliJ IDEA
description: "Abrir y verificar el proyecto en IntelliJ IDEA: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion16/
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

# Abrir y verificar el proyecto en IntelliJ IDEA

## Qué vas a conseguir

- Abrir el proyecto Maven existente en IntelliJ.
- Configurar Project SDK 21.
- Ejecutar aplicación, pruebas y Maven.

## Punto de partida

No utilices el asistente **New Project**. Ya existe un proyecto válido y versionado.

## Conceptos clave

- IntelliJ importa el modelo a partir de `pom.xml`.
- Project SDK debe apuntar a Java 21.
- La ventana Maven muestra fases y plugins.
- JUnit puede ejecutarse desde el gutter o desde Maven.

## Ejemplo guiado

1. Selecciona **Open**.
2. Abre:

```text
~/laboratorio-ides/hola-ides
```

3. Confirma la importación Maven.
4. Comprueba el SDK del proyecto.
5. Ejecuta `App.main`.
6. Ejecuta `AppTest`.
7. Desde la ventana Maven ejecuta `clean` y `test`.
8. En la terminal integrada:

```bash
mvn clean test
git status
```

## Relación con el resto de la ruta

Después de verificar IntelliJ, cerraremos el proyecto y repetiremos el proceso con Eclipse.

## Ejercicios propuestos

1. Localiza la ventana Maven.
2. Ejecuta un test individual.
3. Ejecuta todos los tests con Maven.
4. Revisa con Git qué archivos locales ha generado IntelliJ.

## Qué debes recordar

- Abrimos el proyecto existente; no lo recreamos.
- El resultado de Maven debe ser el mismo en terminal e IntelliJ.


<div class="cla-lesson-nav">
  <a href="/ides/leccion15/">← 15 · Instalar y configurar IntelliJ IDEA</a>
  <a href="/ides/leccion17/">17 · Instalar y configurar Eclipse IDE →</a>
</div>
