---
layout: lesson
route: maven
lesson_id: principal19
lesson_number: "19"
title: "Automatizar el build en CI"
description: "Configura GitHub Actions o GitLab CI con JDK 21 y Maven Wrapper."
permalink: /maven/19-maven-ci/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: github-actions
    title: "GitHub Actions"
  - id: gitlab-ci
    title: "GitLab CI"
  - id: acceso-a-repositorios-privados
    title: "Acceso a repositorios privados"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Automatizar el build en CI

Configura GitHub Actions o GitLab CI con JDK 21 y Maven Wrapper.
## Objetivo y punto de partida

El proyecto debe construirse desde un clon limpio. Elige la plataforma que uses; no necesitas activar ambas. CI ejecuta el proceso Maven, no sustituye al POM.

## GitHub Actions

Guarda `.github/workflows/maven.yml`:

```yaml
name: Maven CI
on:
  push:
  pull_request:
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '21'
          cache: maven
      - run: chmod +x mvnw
      - run: ./mvnw -Pdistribucion clean verify
      - uses: actions/upload-artifact@v4
        with:
          name: gestor-tareas
          path: target/*-all.jar
          if-no-files-found: error
```

## GitLab CI

Guarda `.gitlab-ci.yml`:

```yaml
image: eclipse-temurin:21-jdk
stages:
  - test
build:
  stage: test
  script:
    - chmod +x mvnw
    - ./mvnw -Pdistribucion clean verify
  artifacts:
    paths:
      - target/*-all.jar
    reports:
      junit: target/surefire-reports/TEST-*.xml
```

Ambos utilizan la versión de Maven del Wrapper. La imagen proporciona el JDK. En un equipo que necesite control exacto de la imagen, fija también su digest conforme a la política del proyecto.

## Acceso a repositorios privados

Versiona una plantilla de settings sin valores reales, por ejemplo `config/settings-ci.xml`, basada en la lección 09. En GitLab define `MAVEN_REPO_USER` y `MAVEN_REPO_TOKEN` como variables de CI y ajusta el comando a `./mvnw -s config/settings-ci.xml -Pdistribucion clean verify`.

En GitHub, en el paso de ejecución puedes añadir:

{% raw %}
```yaml
- run: ./mvnw -s config/settings-ci.xml -Pdistribucion clean verify
  env:
    MAVEN_REPO_USER: ${{ secrets.MAVEN_REPO_USER }}
    MAVEN_REPO_TOKEN: ${{ secrets.MAVEN_REPO_TOKEN }}
```

{% endraw %}

Los eventos procedentes de forks pueden no recibir secretos; decide con tu equipo qué comprobaciones pueden ejecutarse en ese contexto. La distribución del Wrapper también debe ser accesible por la red del runner.

## Comprobación y errores habituales

Introduce una aserción incorrecta en una rama de práctica: el job debe fallar. Corrígela y verifica que el artefacto se puede descargar y ejecutar. Si pasa localmente y falla en CI, compara JDK, rutas, permisos, settings y variables disponibles.

## Ejercicio

Configura una sola plataforma y conserva el enlace al job correcto en el README. No añadas permisos de publicación para una tarea que solo construye.

## Qué debes recordar

El comando de CI debe poder reproducirse localmente. La caché acelera el proceso; no sustituye la configuración de repositorios ni las credenciales.

Referencias: [setup-java](https://github.com/actions/setup-java), [Sintaxis de GitLab CI](https://docs.gitlab.com/ci/yaml/).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/18-maven-git/' | relative_url }}">← 18 · Maven dentro del flujo Git</a>
<a href="{{ '/maven/20-diagnosticar-build/' | relative_url }}">20 · Diagnosticar y reparar problemas de Maven →</a>
</nav>
