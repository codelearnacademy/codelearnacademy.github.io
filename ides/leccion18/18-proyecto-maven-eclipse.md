---
layout: lesson
route: ides
lesson_id: leccion18
lesson_file: 18-proyecto-maven-eclipse
lesson_number: "18"
title: Importar y verificar el proyecto en Eclipse
description: "Importar y verificar el proyecto en Eclipse: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion18/
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

# Importar y verificar el proyecto en Eclipse

## Qué vas a conseguir

- Importar un proyecto Maven existente en Eclipse.
- Ejecutar la aplicación y JUnit.
- Comprobar el mismo build Maven.

## Punto de partida

Eclipse está instalado y el proyecto sigue sin cambios en su carpeta original.

## Conceptos clave

- La importación adecuada es **Existing Maven Projects**.
- Eclipse m2e interpreta `pom.xml`.
- JDT gestiona la compilación Java dentro del IDE.
- El comando Maven sigue siendo la comprobación independiente.

## Ejemplo guiado

En Eclipse:

```text
File
└── Import
    └── Maven
        └── Existing Maven Projects
```

Selecciona:

```text
~/laboratorio-ides/hola-ides
```

Después:

1. Ejecuta `App.java` como Java Application.
2. Ejecuta `AppTest.java` como JUnit Test.
3. Abre una terminal y ejecuta:

```bash
cd ~/laboratorio-ides/hola-ides
mvn clean test
git status
```

## Relación con el resto de la ruta

El mismo proyecto pasa ahora a Apache NetBeans.

## Ejercicios propuestos

1. Comprueba que Eclipse reconoce Java 21.
2. Ejecuta el test.
3. Identifica la integración Git.
4. Revisa que no se haya modificado `pom.xml` sin necesidad.

## Qué debes recordar

- La opción de importación Maven evita reconstruir manualmente la configuración.
- El repositorio sigue siendo el mismo.


<div class="cla-lesson-nav">
  <a href="/ides/leccion17/">← 17 · Instalar y configurar Eclipse IDE</a>
  <a href="/ides/leccion19/">19 · Instalar y configurar Apache NetBeans →</a>
</div>
