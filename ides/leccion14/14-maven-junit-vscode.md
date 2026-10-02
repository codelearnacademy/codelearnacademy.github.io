---
layout: lesson
route: ides
lesson_id: leccion14
lesson_file: 14-maven-junit-vscode
lesson_number: "14"
title: Trabajar con Maven y JUnit en VS Code
description: "Trabajar con Maven y JUnit en VS Code: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion14/
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

# Trabajar con Maven y JUnit en VS Code

## Qué vas a conseguir

- Ejecutar tests JUnit desde VS Code.
- Comparar el resultado con `mvn test`.
- Identificar archivos locales creados por el editor.

## Punto de partida

La aplicación se ejecuta y VS Code reconoce Java. Ahora comprobaremos las funciones que suelen motivar el uso de un IDE.

## Conceptos clave

- La vista **Testing** permite ejecutar y localizar tests.
- Maven sigue siendo la referencia del build.
- Un test verde en el IDE debe ser también verde con `mvn test`.
- Git muestra qué configuración local ha creado el editor.

## Ejemplo guiado

1. Abre `AppTest.java`.
2. Ejecuta el test desde el icono de ejecución.
3. Abre la vista **Testing** y vuelve a ejecutarlo.
4. En terminal:

```bash
mvn clean test
```

5. Revisa:

```bash
git status
```

Crea un pequeño cambio en `App.mensaje`, actualiza el test y repite ambas ejecuciones.

## Relación con el resto de la ruta

Una vez validado VS Code, cerraremos el editor y abriremos el mismo directorio con IntelliJ IDEA.

## Ejercicios propuestos

1. Provoca de forma temporal un fallo de test y observa cómo se presenta.
2. Corrige el test.
3. Compara el mensaje de error de Maven y el de VS Code.

## Qué debes recordar

- El IDE mejora la visualización, pero no cambia el significado de la prueba.
- `mvn clean test` debe seguir funcionando siempre.


<div class="cla-lesson-nav">
  <a href="/ides/leccion13/">← 13 · Configurar VS Code para Java</a>
  <a href="/ides/leccion15/">15 · Instalar y configurar IntelliJ IDEA →</a>
</div>
