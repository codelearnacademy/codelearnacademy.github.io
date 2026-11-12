---
layout: lesson
route: spring
lesson_id: leccion90
lesson_file: 90-spring-boot-postgresql-con-compose
lesson_number: "90"
title: Spring Boot + PostgreSQL con Compose
description: Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.
permalink: /spring/leccion90/
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
# Spring Boot + PostgreSQL con Compose

Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Spring Boot + PostgreSQL con Compose** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedores y despliegue.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```yaml
services:
  db:
    image: postgres:16
  backend:
    build: .
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/tasks
```



## Relación con el resto de la ruta

Maven construye, Boot empaqueta/ejecuta, Docker crea el entorno, Compose conecta aplicación y base de datos.



## Ejemplo adicional: aplicación práctica

```yaml
services:
  db:
    image: postgres:16-alpine
    environment:
      POSTGRES_DB: tareas
      POSTGRES_USER: tareas
      POSTGRES_PASSWORD: ${DB_PASSWORD}
  app:
    build: .
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/tareas
      SPRING_DATASOURCE_USERNAME: tareas
      SPRING_DATASOURCE_PASSWORD: ${DB_PASSWORD}
    depends_on: [db]
```

depends_on controla el inicio, no garantiza que la base esté lista para conexiones.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara el recurso de Docker asociado a **Spring Boot + PostgreSQL con Compose**.
2. Construye y ejecuta el contenedor y comprueba el servicio mediante una petición HTTP.
3. Detén y recrea el contenedor; verifica que la configuración y la persistencia funcionan sin modificar la imagen.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Spring Boot + PostgreSQL con Compose** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion89/">← 89 · Dockerfile multi-stage</a>
  <a href="/spring/leccion91/">91 · Variables de entorno en Docker →</a>
</div>
