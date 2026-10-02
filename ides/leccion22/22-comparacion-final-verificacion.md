---
layout: lesson
route: ides
lesson_id: leccion22
lesson_file: 22-comparacion-final-verificacion
lesson_number: "22"
title: Comparación final y verificación del entorno
description: "Comparación final y verificación del entorno: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion22/
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

# Comparación final y verificación del entorno

## Qué vas a conseguir

- Verificar que el laboratorio queda reproducible.
- Realizar una comprobación final de Debian, Java, Maven, Git y los cuatro IDEs.
- Documentar qué entorno utilizarías en distintos contextos.

## Punto de partida

La ruta comenzó con una ISO `netinst`; termina con una VM capaz de abrir y probar el mismo proyecto desde cuatro entornos diferentes.

## Conceptos clave

El laboratorio está completo cuando:

```text
Debian 13.7.0 inicia correctamente
Java 21 funciona desde terminal
Maven compila y ejecuta JUnit
Git controla el proyecto
VS Code abre y prueba hola-ides
IntelliJ IDEA abre y prueba hola-ides
Eclipse abre y prueba hola-ides
NetBeans abre y prueba hola-ides
```

## Ejemplo guiado

Ejecuta:

```bash
cat /etc/os-release
java -version
javac -version
mvn -version
git --version
```

En el proyecto:

```bash
cd ~/laboratorio-ides/hola-ides
git status
mvn clean test
```

Crea una instantánea final de VirtualBox:

```text
debian-java-ides-completo
```

<div class="cla-note"><strong>Actividad final</strong><p>Entrega una breve ficha con la configuración de la VM, versiones instaladas, tabla comparativa y una captura o evidencia de <code>mvn clean test</code> funcionando.</p></div>

## Relación con el resto de la ruta

La máquina resultante puede reutilizarse en las rutas de Java, Maven, Git, Testing, Ficheros y Spring.

## Ejercicios propuestos

1. Completa la ficha final del laboratorio.
2. Indica qué IDE utilizarías para una práctica rápida, cuál para un proyecto Java grande y por qué.
3. Comprueba que el proyecto sigue limpio con `git status`.
4. Crea la instantánea final.

## Qué debes recordar

- El objetivo no era memorizar instaladores, sino comprender cómo se construye un entorno reproducible.
- El mismo proyecto debe sobrevivir al cambio de IDE.
- Terminal, Maven y Git son las referencias comunes para diagnosticar el entorno.


<div class="cla-lesson-nav">
  <a href="/ides/leccion21/">← 21 · El mismo proyecto en cuatro IDEs</a>
</div>
