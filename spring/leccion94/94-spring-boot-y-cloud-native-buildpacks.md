---
layout: lesson
route: spring
lesson_id: leccion94
lesson_file: 94-spring-boot-y-cloud-native-buildpacks
lesson_number: "94"
title: Spring Boot y Cloud Native Buildpacks
description: Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.
permalink: /spring/leccion94/
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
# Spring Boot y Cloud Native Buildpacks

Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Spring Boot y Cloud Native Buildpacks** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedores y despliegue.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Proyecto: Contiene el código. Buildpacks: Construyen capas. Imagen: Lista para ejecutar.]({{ "/assets/images/spring/94-spring-boot-y-cloud-native-buildpacks.webp" | relative_url }})

## Ejemplo guiado

```bash
./mvnw spring-boot:build-image
```

Compara la imagen generada mediante Buildpacks con tu Dockerfile manual.



## Relación con el resto de la ruta

Maven construye, Boot empaqueta/ejecuta, Docker crea el entorno, Compose conecta aplicación y base de datos.



## Ejemplo adicional: aplicación práctica

```bash
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=gestor-tareas:local
docker images gestor-tareas
```

Buildpacks crean imágenes OCI sin mantener un Dockerfile propio.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara el recurso de Docker asociado a **Spring Boot y Cloud Native Buildpacks**.
2. Construye y ejecuta el contenedor y comprueba el servicio mediante una petición HTTP.
3. Detén y recrea el contenedor; verifica que la configuración y la persistencia funcionan sin modificar la imagen.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Spring Boot y Cloud Native Buildpacks** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion93/">← 93 · Healthcheck de Spring</a>
  <a href="/spring/leccion95/">95 · Spring dentro del flujo Git →</a>
</div>
