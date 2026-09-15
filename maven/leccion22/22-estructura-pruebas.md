---
layout: lesson
route: maven
lesson_id: leccion22
lesson_file: 22-estructura-pruebas
lesson_number: "22"
title: Estructura de pruebas
description: Organiza las pruebas Java siguiendo la estructura estándar de Maven.
permalink: /maven/leccion22/
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
# Estructura de pruebas

Organiza las pruebas Java siguiendo la estructura estándar de Maven.

## Qué vas a conseguir

- Comprender **src/test/java** en el contexto de un proyecto Maven.
- Comprender **test resources** en el contexto de un proyecto Maven.
- Comprender **separación producción/pruebas** en el contexto de un proyecto Maven.
- Relacionar lo aprendido con un flujo real de desarrollo.
- Aplicar el concepto mediante una práctica guiada.

<div class="cla-note"><strong>Ruta de estudio</strong><p>Trabaja esta lección desde terminal siempre que sea posible. El objetivo no es memorizar comandos, sino entender qué cambia en el proyecto y por qué.</p></div>

## Punto de partida

Maven se entiende mejor cuando cada concepto se conecta con una necesidad concreta del proyecto. En esta lección nos centraremos en **src/test/java** y observaremos su efecto en un proyecto Java sencillo.

Antes de ejecutar un comando, intenta responder:

```text
¿Qué problema estamos resolviendo?
¿Qué archivo o fase interviene?
¿Qué resultado esperamos obtener?
¿Cómo comprobaríamos que ha funcionado?
```

## Conceptos clave

- **src/test/java**
- **test resources**
- **separación producción/pruebas**

La idea importante es separar responsabilidades. Java aporta el lenguaje y la plataforma; Maven aporta un modelo de proyecto, resolución de dependencias y automatización del proceso de construcción.

## Ejemplo guiado

```text
src/
├── main/java/
└── test/java/
```

### Cómo trabajar el ejemplo

1. Ejecuta o reproduce el ejemplo.
2. Observa los archivos que cambian.
3. Ejecuta `git status` si el proyecto ya está versionado.
4. Explica con tus propias palabras qué ha hecho Maven.
5. Repite el proceso cambiando un dato controlado.

<div class="cla-note"><strong>Regla práctica</strong><p>Si no puedes explicar qué entrada recibe una herramienta y qué salida produce, todavía no has terminado de comprender el paso.</p></div>



## Conexión con otros ecosistemas

Separar código de producción y pruebas es un patrón universal: pytest, Jest, Go test y JUnit siguen convenciones distintas pero buscan el mismo objetivo.

No busques equivalencias exactas. La pregunta útil es:

> ¿Qué responsabilidad está resolviendo esta herramienta dentro del proyecto?

Por ejemplo, una herramienta puede encargarse solo de instalar paquetes, mientras otra también define construcción, pruebas y empaquetado.

## Ejercicios propuestos

1. Crea una clase de prueba paralela a una clase de producción.
2. Explica por qué `src/test/java` no forma parte del artefacto principal.

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
  <a href="/maven/leccion21/">← 21 · Versiones y conflictos</a>
  <a href="/maven/leccion23/">23 · JUnit como dependencia →</a>
</div>
