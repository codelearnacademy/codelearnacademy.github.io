---
layout: lesson
route: ides
lesson_id: leccion11
lesson_file: 11-crear-proyecto-maven-comun
lesson_number: "11"
title: Crear el proyecto Maven común
description: "Crear el proyecto Maven común: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion11/
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

# Crear el proyecto Maven común

## Qué vas a conseguir

- Preparar el proyecto que se reutilizará en todos los IDEs.
- Verificarlo solo con Maven.
- Crear un primer commit estable.

## Punto de partida

La carpeta `recursos/hola-ides` de esta ruta contiene un proyecto Maven mínimo con Java 21 y JUnit.

## Conceptos clave

- La estructura Maven es independiente del IDE.
- `src/main/java` contiene código de aplicación.
- `src/test/java` contiene pruebas.
- `target/` es generado por Maven y no debe versionarse.

## Ejemplo guiado

Copia el recurso a tu carpeta de trabajo:

```bash
cp -r recursos/hola-ides ~/laboratorio-ides/
cd ~/laboratorio-ides/hola-ides
```

Ejecuta:

```bash
mvn clean test
```

Después:

```bash
git init
printf "target/\n.idea/\n.vscode/\n.classpath\n.project\n.settings/\nnbproject/private/\n" > .gitignore
git add .
git commit -m "Proyecto base para comparar IDEs"
```

Comprueba la estructura:

```text
hola-ides/
├── pom.xml
└── src/
    ├── main/java/es/ies/puerto/ides/App.java
    └── test/java/es/ies/puerto/ides/AppTest.java
```

## Relación con el resto de la ruta

Desde este momento **no crearemos un proyecto nuevo en cada IDE**. Abriremos exactamente esta carpeta.

## Ejercicios propuestos

1. Ejecuta `mvn clean test`.
2. Ejecuta `git status`.
3. Crea el primer commit.
4. Ejecuta `java` o Maven desde terminal antes de abrir VS Code.

## Qué debes recordar

- El punto de verdad del proyecto es `pom.xml` y el código fuente.
- Si un IDE modifica innecesariamente el proyecto, Git permitirá identificarlo.


<div class="cla-lesson-nav">
  <a href="/ides/leccion10/">← 10 · Instalar y configurar Git</a>
  <a href="/ides/leccion12/">12 · Instalar Visual Studio Code →</a>
</div>
