---
layout: lesson
route: ides
lesson_id: leccion13
lesson_file: 13-configurar-vscode-java
lesson_number: "13"
title: Configurar VS Code para Java
description: "Configurar VS Code para Java: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion13/
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

# Configurar VS Code para Java

## Qué vas a conseguir

- Añadir soporte Java a VS Code.
- Detectar JDK 21 y Maven.
- Ejecutar la aplicación desde el editor.

## Punto de partida

VS Code ya abre la carpeta Maven, pero todavía debemos añadir las herramientas Java.

## Conceptos clave

La extensión recomendada para empezar es **Extension Pack for Java**, que agrupa soporte de lenguaje, depuración, pruebas y Maven.

También resulta útil revisar:

```text
Java: Configure Java Runtime
Maven
Testing
Source Control
```

## Ejemplo guiado

En **Extensions**, busca e instala:

```text
Extension Pack for Java
```

Después abre la paleta:

```text
Ctrl+Shift+P
```

Ejecuta:

```text
Java: Configure Java Runtime
```

Comprueba que aparece un JDK 21.

Abre `App.java`, ejecuta `main` y observa la salida. Desde la terminal integrada vuelve a comprobar:

```bash
mvn clean test
```

Documentación: [Java in Visual Studio Code](https://code.visualstudio.com/docs/languages/java).

## Relación con el resto de la ruta

La siguiente lección utiliza Maven y JUnit desde las vistas específicas de VS Code.

## Ejercicios propuestos

1. Localiza el JDK configurado.
2. Ejecuta `App.main`.
3. Abre el panel de Source Control y comprueba el repositorio Git.
4. No hagas commit de configuraciones locales innecesarias.

## Qué debes recordar

- VS Code debe utilizar el mismo proyecto Maven que ya funcionaba en terminal.
- El soporte Java llega mediante extensiones.


<div class="cla-lesson-nav">
  <a href="/ides/leccion12/">← 12 · Instalar Visual Studio Code</a>
  <a href="/ides/leccion14/">14 · Trabajar con Maven y JUnit en VS Code →</a>
</div>
