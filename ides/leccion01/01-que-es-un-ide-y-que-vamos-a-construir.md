---
layout: lesson
route: ides
lesson_id: leccion01
lesson_file: 01-que-es-un-ide-y-que-vamos-a-construir
lesson_number: "1"
title: Qué es un IDE y qué vamos a construir
description: "Qué es un IDE y qué vamos a construir: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion01/
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

# Qué es un IDE y qué vamos a construir

## Qué vas a conseguir

- Distinguir editor, IDE, JDK, Maven y Git.
- Entender qué componentes serán comunes a los cuatro entornos.
- Conocer el resultado final de la ruta.

## Punto de partida

Un IDE reúne edición de código, navegación, compilación, depuración, pruebas e integración con herramientas externas. En esta ruta no aprenderás cuatro proyectos diferentes: prepararás **un único proyecto Java/Maven** y lo abrirás con cuatro herramientas.

<div class="cla-note"><strong>Objetivo del laboratorio</strong><p>Crear una máquina virtual Debian 13.7.0 y dejarla preparada para desarrollar Java con VS Code, IntelliJ IDEA, Eclipse y Apache NetBeans.</p></div>

## Conceptos clave

- **JDK:** compilador, runtime y herramientas de desarrollo Java.
- **Maven:** describe y construye el proyecto de forma independiente del IDE.
- **Git:** controla las versiones del código.
- **IDE:** ofrece una interfaz y herramientas para trabajar con el proyecto.
- **Máquina virtual:** crea un laboratorio aislado y reproducible.

## Ejemplo guiado

```text
Debian 13.7.0
      │
      ├── JDK 21
      ├── Maven
      ├── Git
      │
      └── hola-ides/
            ├── pom.xml
            └── src/
                 │
                 ├── VS Code
                 ├── IntelliJ IDEA
                 ├── Eclipse
                 └── NetBeans
```

## Relación con el resto de la ruta

Las siguientes lecciones construyen primero la máquina virtual, después el entorno Java común y finalmente los cuatro IDEs.

## Ejercicios propuestos

1. Escribe una frase que explique la diferencia entre JDK e IDE.
2. Explica por qué `pom.xml` debe poder utilizarse sin abrir ningún IDE.
3. Anota qué IDE has utilizado anteriormente, si alguno.

## Qué debes recordar

- Un IDE facilita el trabajo, pero no debe definir la estructura del proyecto.
- La terminal será nuestra referencia para comprobar que Java y Maven funcionan.


<div class="cla-lesson-nav">
  <span></span>
  <a href="/ides/leccion02/">2 · Máquinas virtuales e hipervisores →</a>
</div>
