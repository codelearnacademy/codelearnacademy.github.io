---
layout: lesson
route: ides
lesson_id: leccion09
lesson_file: 09-instalar-maven
lesson_number: "9"
title: Instalar y verificar Maven
description: "Instalar y verificar Maven: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion09/
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

# Instalar y verificar Maven

## Qué vas a conseguir

- Instalar Maven desde los repositorios de Debian.
- Verificar qué Java utiliza Maven.
- Ejecutar un ciclo de vida básico.

## Punto de partida

El JDK funciona desde terminal. Maven utilizará ese entorno para compilar y ejecutar pruebas.

## Conceptos clave

- Maven se configura mediante `pom.xml`.
- `mvn -version` muestra tanto Maven como el Java utilizado.
- `clean` elimina resultados anteriores.
- `test` compila y ejecuta las pruebas.
- `package` genera el artefacto del proyecto.

## Ejemplo guiado

```bash
sudo apt install -y maven
mvn -version
```

Comprueba que la salida incluye Java 21.

Crea una carpeta temporal y verifica que Maven responde:

```bash
mkdir -p ~/laboratorio-ides
cd ~/laboratorio-ides
mvn -version
```

## Relación con el resto de la ruta

En la lección 11 utilizaremos Maven para comprobar el proyecto antes de abrir ningún IDE.

## Ejercicios propuestos

1. Instala Maven.
2. Identifica la versión de Java mostrada por `mvn -version`.
3. Explica por qué esta comprobación debe hacerse antes de abrir un IDE.

## Qué debes recordar

- Maven es una herramienta externa al IDE.
- Si `mvn` funciona en terminal, tenemos una referencia independiente para diagnosticar problemas.


<div class="cla-lesson-nav">
  <a href="/ides/leccion08/">← 8 · Instalar y configurar JDK 21</a>
  <a href="/ides/leccion10/">10 · Instalar y configurar Git →</a>
</div>
