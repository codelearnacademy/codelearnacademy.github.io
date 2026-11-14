---
layout: lesson
route: spring
lesson_id: leccion96
lesson_file: 96-ci-para-spring-boot
lesson_number: "96"
title: CI para Spring Boot
description: Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.
permalink: /spring/leccion96/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>
# CI para Spring Boot

Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **CI para Spring Boot** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Git, integración y despliegue continuos.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Checkout: Obtiene el código. JDK 21: Prepara el entorno. Verificación: Ejecuta Maven verify.]({{ "/assets/images/spring/96-ci-para-spring-boot.webp" | relative_url }})

## Ejemplo guiado

Pipeline mínimo:

```text
checkout → Java 21 → ./mvnw clean verify
```



## Relación con el resto de la ruta

Git conserva el cambio; CI lo verifica; un registry conserva la imagen; CD despliega una versión inmutable.



## Ejemplo adicional: aplicación práctica

```yaml
name: CI
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '21'
      - run: mvn -B verify
```

La versión de Java de CI debe coincidir con la configurada en el proyecto.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Incorpora **CI para Spring Boot** a un flujo de construcción automatizado.
2. Ejecuta las pruebas y comprueba que un fallo provoca un estado de pipeline fallido.
3. Documenta cómo identificar la versión desplegada y cómo volver a una versión anterior.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **CI para Spring Boot** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion95/">← 95 · Spring dentro del flujo Git</a>
  <a href="/spring/leccion97/">97 · Construcción de imagen →</a>
</div>
