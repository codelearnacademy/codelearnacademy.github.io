---
layout: lesson
route: ides
lesson_id: leccion08
lesson_file: 08-instalar-jdk-21
lesson_number: "8"
title: Instalar y configurar JDK 21
description: "Instalar y configurar JDK 21: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion08/
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

# Instalar y configurar JDK 21

## Qué vas a conseguir

- Instalar OpenJDK 21 desde Debian.
- Comprobar `java` y `javac`.
- Identificar el JDK que usarán los proyectos.

## Punto de partida

Debian 13 estable ofrece OpenJDK 21 como paquete. Utilizaremos el JDK del sistema como referencia común para terminal, Maven y los cuatro IDEs.

## Conceptos clave

- **JRE** ejecuta aplicaciones Java.
- **JDK** incluye compilador y herramientas de desarrollo.
- `java` ejecuta bytecode.
- `javac` compila código Java.
- Un IDE puede tener runtime propio, pero el proyecto seguirá configurado para Java 21.

## Ejemplo guiado

```bash
sudo apt install -y openjdk-21-jdk
```

Comprueba:

```bash
java -version
javac -version
```

Localiza Java:

```bash
readlink -f "$(which java)"
```

Y consulta alternativas:

```bash
update-alternatives --list java
update-alternatives --list javac
```

Referencia: [paquete openjdk-21-jdk de Debian estable](https://packages.debian.org/stable/java/openjdk-21-jdk).

## Relación con el resto de la ruta

Maven utilizará este JDK para compilar el proyecto común.

## Ejercicios propuestos

1. Instala el JDK 21.
2. Guarda la salida de `java -version`.
3. Explica por qué comprobar también `javac -version`.

## Qué debes recordar

- Para desarrollar necesitamos el JDK, no solo el runtime.
- Java debe funcionar desde terminal antes de configurar cualquier IDE.


<div class="cla-lesson-nav">
  <a href="/ides/leccion07/">← 7 · Actualizar Debian y preparar herramientas básicas</a>
  <a href="/ides/leccion09/">9 · Instalar y verificar Maven →</a>
</div>
