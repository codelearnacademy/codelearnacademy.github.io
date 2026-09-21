---
layout: lesson
route: maven
lesson_id: principal07
lesson_number: "07"
title: "Maven Central y el repositorio local"
description: "Observa cómo se resuelven, almacenan e instalan los artefactos."
permalink: /maven/07-central-repositorio-local/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Maven Central y el repositorio local

Observa cómo se resuelven, almacenan e instalan los artefactos.
## Objetivo y punto de partida

Usa el proyecto con Gson. Un repositorio Maven almacena artefactos y sus metadatos; un repositorio Git almacena el historial de archivos.

## Práctica guiada

Maven Central está disponible por defecto. La descarga termina en el repositorio local, normalmente `~/.m2/repository` en macOS/Linux y `%USERPROFILE%\.m2\repository` en Windows.

Busca estos archivos con el explorador:

```text
com/google/code/gson/gson/2.11.0/
├── gson-2.11.0.jar
└── gson-2.11.0.pom
```

El POM de una biblioteca permite conocer sus dependencias. La ruta refleja sus coordenadas.

```bash
mvn install
```

Ahora busca `com/codelearn/gestor-tareas/1.0.0-SNAPSHOT/`: contiene tu artefacto y su POM. El repositorio local guarda tanto descargas como artefactos instalados localmente; no es solo una caché de Internet.

## Comprobación y errores habituales

Después de una construcción online correcta:

```bash
mvn -o package
```

El modo offline funciona únicamente si todas las dependencias y plugins necesarios están disponibles localmente. Si falta alguno, vuelve a ejecutar online. `-U` fuerza comprobaciones de snapshots actualizados y releases ausentes; no es una solución universal para todos los errores.

## Ejercicio

Localiza el POM de Gson y el POM de tu aplicación. Explica por qué `mvn install` no publica el proyecto para otras personas.

## Qué debes recordar

`install` actúa sobre el repositorio local. Para publicar remotamente necesitas configuración y `deploy`.

Referencia: [Repositorios de Maven](https://maven.apache.org/guides/introduction/introduction-to-repositories).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/06-anadir-dependencia/' | relative_url }}">← 06 · Añadir y utilizar una dependencia</a>
<a href="{{ '/maven/08-repositorios-settings/' | relative_url }}">08 · Repositorios externos y settings.xml →</a>
</nav>
