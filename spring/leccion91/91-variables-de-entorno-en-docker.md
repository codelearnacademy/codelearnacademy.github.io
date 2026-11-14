---
layout: lesson
route: spring
lesson_id: leccion91
lesson_file: 91-variables-de-entorno-en-docker
lesson_number: "91"
title: Variables de entorno en Docker
description: Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.
permalink: /spring/leccion91/
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
# Variables de entorno en Docker

Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Variables de entorno en Docker** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedores y despliegue.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Entorno Docker: Inyecta valores. Contenedor: Los recibe al arrancar. Spring: Resuelve sus propiedades.]({{ "/assets/images/spring/91-variables-de-entorno-en-docker.webp" | relative_url }})

## Ejemplo guiado

Pasa `SPRING_DATASOURCE_*` mediante Compose y elimina credenciales del `application.yml`.



## Relación con el resto de la ruta

Maven construye, Boot empaqueta/ejecuta, Docker crea el entorno, Compose conecta aplicación y base de datos.



## Ejemplo adicional: aplicación práctica

```yaml
services:
  app:
    environment:
      SPRING_PROFILES_ACTIVE: prod
      DB_PASSWORD: ${DB_PASSWORD}
```

Comprueba qué valores se inyectan al contenedor sin imprimir secretos.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara el recurso de Docker asociado a **Variables de entorno en Docker**.
2. Construye y ejecuta el contenedor y comprueba el servicio mediante una petición HTTP.
3. Detén y recrea el contenedor; verifica que la configuración y la persistencia funcionan sin modificar la imagen.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Variables de entorno en Docker** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion90/">← 90 · Spring Boot + PostgreSQL con Compose</a>
  <a href="/spring/leccion92/">92 · Profiles dentro del contenedor →</a>
</div>
