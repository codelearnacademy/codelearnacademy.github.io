---
layout: lesson
route: docker
lesson_id: leccion57
lesson_file: 57-github-actions-y-gitlab-ci
lesson_number: "57"
title: "GitHub Actions y GitLab CI"
description: "Relaciona jobs, runners y construcción de imágenes en GitHub Actions y GitLab CI."
permalink: /docker/leccion57/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
  - id: referencias
    title: Referencias
---

# GitHub Actions y GitLab CI

## Qué vas a conseguir

- Localizar la configuración del pipeline en cada plataforma.
- Entender qué aporta el runner al construir una imagen.
- Separar validación, construcción, publicación y despliegue.

## Conceptos clave

| Concepto | GitHub Actions | GitLab CI |
|---|---|---|
| Configuración | `.github/workflows/*.yml` | `.gitlab-ci.yml` |
| Unidad de trabajo | Job con steps | Job con script |
| Ejecutor | Runner | Runner |

El runner necesita acceso a un motor o constructor de imágenes compatible. Ejecutar un job dentro de una imagen que contiene el cliente Docker no garantiza que exista un daemon accesible. En GitLab, opciones como Docker-in-Docker requieren configuración del runner y del servicio; no basta con copiar `docker build` a cualquier job.

Construir una imagen no la publica ni despliega un contenedor. La publicación requiere un registry y credenciales; el despliegue es otro paso con su propio entorno y comprobaciones.

## Ejemplo guiado

Prepara un repositorio de práctica con un `Dockerfile` válido. Este workflow de GitHub Actions construye una imagen en un runner Linux hospedado, sin publicarla. `actions/checkout` obtiene los archivos necesarios del repositorio.

```yaml
name: Comprobar imagen
on: [push, pull_request]
permissions:
  contents: read
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Construir
        run: docker build --tag codetasks:ci .
```

En GitLab, este ejemplo alternativo presupone un **runner dedicado con ejecutor shell**, Docker instalado y acceso al daemon. La etiqueta `docker-shell` debe estar asignada realmente a ese runner; el YAML no lo crea ni instala Docker.

```yaml
stages: [build]
build-image:
  stage: build
  tags: [docker-shell]
  script:
    - docker version
    - docker build --tag codetasks:ci .
```

Esta segunda configuración es para un repositorio de práctica de confianza: el acceso al daemon tiene privilegios sobre el host. Para otro tipo de runner, sigue la configuración específica de la documentación. En proyectos reales, fija las acciones externas a revisiones verificadas y configura credenciales mediante los mecanismos de secretos de la plataforma.

Comprueba en el log que se obtiene el repositorio y termina la construcción. Si el `Dockerfile` presupone un JAR ya construido, añade antes el job o paso de Maven; si utiliza una construcción multietapa que lo genera, esa tarea puede estar dentro del propio Dockerfile. Un build correcto no sustituye las pruebas de la aplicación.

## Ejercicios propuestos

1. Identifica archivo, job y runner de los dos ejemplos.
2. Explica qué fallaría si el cliente Docker no pudiera conectar con el daemon.
3. Añade un paso de pruebas apropiado para tu proyecto antes de construir la imagen.
4. Describe qué configuración adicional necesitarías para publicar, sin introducir credenciales en el YAML.

## Qué debes recordar

El pipeline declara trabajo; el runner aporta el entorno. Construir, publicar y desplegar son operaciones distintas. No presupongas que todos los runners ofrecen las mismas capacidades.

## Referencias

- [Docker: GitHub Actions](https://docs.docker.com/build/ci/github-actions/).
- [GitLab: construir imágenes Docker](https://docs.gitlab.com/ci/docker/using_docker_build/).

<div class="cla-lesson-nav">
  <a href="{{ '/docker/leccion56/' | relative_url }}">← 56 · Lección anterior</a>
  <a href="{{ '/docker/leccion58/' | relative_url }}">58 · Docker frente a Podman →</a>
</div>
