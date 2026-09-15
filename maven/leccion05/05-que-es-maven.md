---
layout: lesson
route: maven
lesson_id: leccion05
lesson_file: 05-que-es-maven
lesson_number: "05"
title: Qué es Maven
description: Sitúa Maven dentro del ecosistema Java y comprende sus responsabilidades reales.
permalink: /maven/leccion05/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: conexion-con-otros-ecosistemas
    title: Conexión con otros ecosistemas
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Qué es Maven

Sitúa Maven dentro del ecosistema Java y comprende sus responsabilidades reales.

## Qué vas a conseguir

- Comprender **build tool** en el contexto de un proyecto Maven.
- Comprender **gestión de dependencias** en el contexto de un proyecto Maven.
- Comprender **ciclo de vida** en el contexto de un proyecto Maven.
- Comprender **plugins** en el contexto de un proyecto Maven.
- Relacionar lo aprendido con un flujo real de desarrollo.
- Aplicar el concepto mediante una práctica guiada.

<div class="cla-note"><strong>Ruta de estudio</strong><p>Trabaja esta lección desde terminal siempre que sea posible. El objetivo no es memorizar comandos, sino entender qué cambia en el proyecto y por qué.</p></div>

## Punto de partida

Maven se entiende mejor cuando cada concepto se conecta con una necesidad concreta del proyecto. En esta lección nos centraremos en **build tool** y observaremos su efecto en un proyecto Java sencillo.

Antes de ejecutar un comando, intenta responder:

```text
¿Qué problema estamos resolviendo?
¿Qué archivo o fase interviene?
¿Qué resultado esperamos obtener?
¿Cómo comprobaríamos que ha funcionado?
```

## Conceptos clave

- **build tool**
- **gestión de dependencias**
- **ciclo de vida**
- **plugins**
- **POM**

La idea importante es separar responsabilidades. Java aporta el lenguaje y la plataforma; Maven aporta un modelo de proyecto, resolución de dependencias y automatización del proceso de construcción.

## Ejemplo guiado

```text
Maven
├── estructura
├── dependencias
├── construcción
└── automatización
```

### Cómo trabajar el ejemplo

1. Ejecuta o reproduce el ejemplo.
2. Observa los archivos que cambian.
3. Ejecuta `git status` si el proyecto ya está versionado.
4. Explica con tus propias palabras qué ha hecho Maven.
5. Repite el proceso cambiando un dato controlado.

<div class="cla-note"><strong>Regla práctica</strong><p>Si no puedes explicar qué entrada recibe una herramienta y qué salida produce, todavía no has terminado de comprender el paso.</p></div>

## Una aclaración importante: Maven no hace inyección de dependencias

En Maven, una **dependencia** es una biblioteca que el proyecto necesita para compilar, probar o ejecutarse.

En Spring, la **inyección de dependencias** es un patrón por el que un contenedor crea objetos y les proporciona otros objetos que necesitan.

Son conceptos diferentes:

```text
Maven dependency
→ biblioteca disponible para el proyecto

Spring Dependency Injection
→ objetos colaborando mediante un contenedor IoC
```

Esta diferencia será importante cuando avances hacia la ruta de Spring.


## Conexión con otros ecosistemas

Maven se parece a Gradle dentro de Java/JVM. Comparte responsabilidades parciales con npm scripts, Poetry/uv y `go` tooling, aunque no son equivalentes exactos.

No busques equivalencias exactas. La pregunta útil es:

> ¿Qué responsabilidad está resolviendo esta herramienta dentro del proyecto?

Por ejemplo, una herramienta puede encargarse solo de instalar paquetes, mientras otra también define construcción, pruebas y empaquetado.

## Ejercicios propuestos

1. Explica por qué Maven no es un framework.
2. Diferencia gestionar dependencias con Maven de la inyección de dependencias de Spring.

### Ejercicio de reflexión

Responde brevemente:

- ¿Qué parte de esta lección pertenece a Java?
- ¿Qué parte pertenece a Maven?
- ¿Qué parte podría automatizar GitHub Actions o GitLab CI?
- ¿Qué información debería quedar versionada en Git?



## Qué debes recordar

- Maven debe ayudarte a que el proyecto sea **reproducible**.
- El `pom.xml` debe describir información necesaria para construir el proyecto.
- Los archivos generados no sustituyen al código fuente ni a la configuración versionada.
- Git almacena el estado fuente del proyecto; Maven reconstruye los resultados derivados.
- CI ejecuta automáticamente el mismo proceso que debería funcionar en tu equipo.

<div class="cla-lesson-nav">
  <a href="/maven/leccion04/">← 04 · Por qué copiar JAR no escala</a>
  <a href="/maven/leccion06/">06 · Maven frente a otros ecosistemas →</a>
</div>
