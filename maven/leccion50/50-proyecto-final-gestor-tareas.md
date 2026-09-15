---
layout: lesson
route: maven
lesson_id: leccion50
lesson_file: 50-proyecto-final-gestor-tareas
lesson_number: "50"
title: Proyecto final · Gestor de tareas
description: Integra Maven, Java, testing, Git y CI en un proyecto pequeño pero reproducible.
permalink: /maven/leccion50/
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
  - id: proyecto-final
    title: Proyecto final
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Proyecto final · Gestor de tareas

Integra Maven, Java, testing, Git y CI en un proyecto pequeño pero reproducible.

## Qué vas a conseguir

- Comprender **Java 21** en el contexto de un proyecto Maven.
- Comprender **Gson** en el contexto de un proyecto Maven.
- Comprender **JUnit** en el contexto de un proyecto Maven.
- Comprender **Maven Wrapper** en el contexto de un proyecto Maven.
- Relacionar lo aprendido con un flujo real de desarrollo.
- Aplicar el concepto mediante una práctica guiada.

<div class="cla-note"><strong>Ruta de estudio</strong><p>Trabaja esta lección desde terminal siempre que sea posible. El objetivo no es memorizar comandos, sino entender qué cambia en el proyecto y por qué.</p></div>

## Punto de partida

Maven se entiende mejor cuando cada concepto se conecta con una necesidad concreta del proyecto. En esta lección nos centraremos en **Java 21** y observaremos su efecto en un proyecto Java sencillo.

Antes de ejecutar un comando, intenta responder:

```text
¿Qué problema estamos resolviendo?
¿Qué archivo o fase interviene?
¿Qué resultado esperamos obtener?
¿Cómo comprobaríamos que ha funcionado?
```

## Conceptos clave

- **Java 21**
- **Gson**
- **JUnit**
- **Maven Wrapper**
- **Git**
- **CI**
- **tag**

La idea importante es separar responsabilidades. Java aporta el lenguaje y la plataforma; Maven aporta un modelo de proyecto, resolución de dependencias y automatización del proceso de construcción.

## Ejemplo guiado

```text
gestor-tareas/
├── pom.xml
├── README.md
├── .gitignore
├── mvnw
├── .mvn/
└── src/
    ├── main/java/
    ├── main/resources/
    └── test/java/
```

### Cómo trabajar el ejemplo

1. Ejecuta o reproduce el ejemplo.
2. Observa los archivos que cambian.
3. Ejecuta `git status` si el proyecto ya está versionado.
4. Explica con tus propias palabras qué ha hecho Maven.
5. Repite el proceso cambiando un dato controlado.

<div class="cla-note"><strong>Regla práctica</strong><p>Si no puedes explicar qué entrada recibe una herramienta y qué salida produce, todavía no has terminado de comprender el paso.</p></div>

## Requisitos funcionales

La aplicación de consola permitirá:

1. Añadir una tarea.
2. Listar tareas.
3. Marcar una tarea como completada.
4. Eliminar una tarea.
5. Guardar tareas en JSON.
6. Recuperar tareas al iniciar.

## Requisitos técnicos

Debes utilizar:

- Java 21.
- Maven.
- Gson para serialización JSON.
- JUnit para pruebas.
- Maven Wrapper.
- Git con un historial coherente.
- GitHub o GitLab como repositorio remoto.
- Un pipeline de CI.
- Una etiqueta final `v1.0.0`.

## Estructura recomendada

```text
gestor-tareas/
├── .gitignore
├── README.md
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .mvn/
└── src/
    ├── main/
    │   ├── java/com/codelearn/tareas/
    │   │   ├── Main.java
    │   │   ├── Tarea.java
    │   │   ├── GestorTareas.java
    │   │   └── RepositorioTareas.java
    │   └── resources/
    └── test/
        └── java/com/codelearn/tareas/
            └── GestorTareasTest.java
```

## Hitos del proyecto

### Hito 1 · Proyecto reproducible

```bash
./mvnw clean verify
```

debe funcionar desde un clon limpio.

### Hito 2 · Dependencias

El `pom.xml` debe declarar al menos:

- Gson.
- JUnit Jupiter.

### Hito 3 · Calidad

Debe existir un conjunto mínimo de pruebas para:

- añadir tareas;
- completar tareas;
- eliminar tareas;
- tratar identificadores inexistentes.

### Hito 4 · Git

Trabaja al menos con:

```text
main
feature/modelo-tarea
feature/persistencia-json
feature/pruebas
```

Realiza commits pequeños y descriptivos.

### Hito 5 · Integración continua

Cada `push` y Pull/Merge Request debe ejecutar:

```bash
./mvnw clean verify
```

### Hito 6 · Entrega

Crea:

```text
v1.0.0
```

y documenta en `README.md`:

- requisitos;
- cómo construir;
- cómo probar;
- cómo ejecutar;
- estructura del proyecto;
- dependencias utilizadas.

## Criterio de finalización

El proyecto no se considera terminado solo porque funcione en tu IDE.

Otra persona debe poder ejecutar:

```bash
git clone <repositorio>
cd gestor-tareas
./mvnw clean verify
./mvnw package
```

y obtener un build correcto sin copiar manualmente ninguna biblioteca.


## Conexión con otros ecosistemas

El objetivo es reproducir un flujo profesional pequeño: parecido a lo que harías con Node + npm + Jest + GitHub Actions, Python + uv/Poetry + pytest + CI o Go Modules + go test + CI.

No busques equivalencias exactas. La pregunta útil es:

> ¿Qué responsabilidad está resolviendo esta herramienta dentro del proyecto?

Por ejemplo, una herramienta puede encargarse solo de instalar paquetes, mientras otra también define construcción, pruebas y empaquetado.

## Ejercicios propuestos

1. Entrega el proyecto con `./mvnw clean verify` en verde.
2. Publica una versión `v1.0.0` y documenta cómo otra persona puede clonar y construir el proyecto.

### Ejercicio de reflexión

Responde brevemente:

- ¿Qué parte de esta lección pertenece a Java?
- ¿Qué parte pertenece a Maven?
- ¿Qué parte podría automatizar GitHub Actions o GitLab CI?
- ¿Qué información debería quedar versionada en Git?

## Proyecto final

Esta lección constituye el proyecto integrador de la ruta. Debes aplicar los conceptos de todas las lecciones anteriores y demostrar que el proyecto puede construirse desde un clon limpio.


## Qué debes recordar

- Maven debe ayudarte a que el proyecto sea **reproducible**.
- El `pom.xml` debe describir información necesaria para construir el proyecto.
- Los archivos generados no sustituyen al código fuente ni a la configuración versionada.
- Git almacena el estado fuente del proyecto; Maven reconstruye los resultados derivados.
- CI ejecuta automáticamente el mismo proceso que debería funcionar en tu equipo.

<div class="cla-lesson-nav">
  <a href="/maven/leccion49/">← 49 · Elegir herramientas comprendiendo el problema</a>
  <a href="/git/">Continuar con Git / CI →</a>
</div>
