---
layout: lesson
route: ides
lesson_id: leccion15
lesson_file: 15-instalar-configurar-intellij
lesson_number: "15"
title: Instalar y configurar IntelliJ IDEA
description: "Instalar y configurar IntelliJ IDEA: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion15/
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

# Instalar y configurar IntelliJ IDEA

## Qué vas a conseguir

- Instalar IntelliJ IDEA en Linux.
- Entender el modelo de distribución unificado actual.
- Configurar el JDK 21 para el proyecto.

## Punto de partida

Desde IntelliJ IDEA 2025.3 JetBrains utiliza una **distribución unificada**: las funciones principales de Java son gratuitas y las funciones avanzadas requieren una suscripción Ultimate. Ya no es necesario buscar una descarga separada llamada Community Edition.

## Conceptos clave

- JetBrains recomienda Toolbox App como uno de los métodos de instalación.
- También puede instalarse desde un archivo `.tar.gz`.
- El IDE puede traer runtime propio para ejecutarse; eso no obliga a que el proyecto use ese runtime.
- Nuestro proyecto seguirá compilándose con Java 21.

## Ejemplo guiado

Consulta las instrucciones oficiales:

[IntelliJ IDEA · Installation guide](https://www.jetbrains.com/help/idea/installation-guide.html)

Con Toolbox App, descarga el `.tar.gz`, extráelo y ejecuta Toolbox siguiendo la documentación oficial. Desde Toolbox instala **IntelliJ IDEA**.

Al iniciar IntelliJ no necesitas activar una suscripción Ultimate para realizar esta ruta; las funciones principales Java pueden seguir utilizándose gratuitamente.

## Relación con el resto de la ruta

En la siguiente lección importaremos `hola-ides` directamente desde su `pom.xml`.

## Ejercicios propuestos

1. Instala IntelliJ IDEA.
2. Identifica en `Help → About` la versión instalada.
3. Localiza la configuración de SDK/JDK.
4. Comprueba que puedes seleccionar Java 21.

## Qué debes recordar

- La antigua separación Community/Ultimate cambió: la distribución actual es unificada.
- El JDK del proyecto y el runtime que ejecuta el IDE son conceptos distintos.


<div class="cla-lesson-nav">
  <a href="/ides/leccion14/">← 14 · Trabajar con Maven y JUnit en VS Code</a>
  <a href="/ides/leccion16/">16 · Abrir y verificar el proyecto en IntelliJ IDEA →</a>
</div>
