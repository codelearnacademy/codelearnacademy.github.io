---
layout: lesson
route: spring
lesson_id: leccion95
lesson_file: 95-profiles-dentro-del-contenedor
lesson_number: "95"
title: Profiles dentro del contenedor
description: Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.
permalink: /spring/leccion95/
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
# Profiles dentro del contenedor

Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Profiles dentro del contenedor** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedores y despliegue.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Compose: Declara el perfil activo. Spring: Carga la configuración. Verificar: Comprueba el perfil en el log.]({{ "/assets/images/spring/92-profiles-dentro-del-contenedor.webp" | relative_url }})

## Ejemplo guiado

```yaml
environment:
  SPRING_PROFILES_ACTIVE: docker
```



## Relación con el resto de la ruta

Maven construye, Boot empaqueta/ejecuta, Docker crea el entorno, Compose conecta aplicación y base de datos.



## Ejemplo adicional: aplicación práctica

```bash
docker run --rm -e SPRING_PROFILES_ACTIVE=prod gestor-tareas:local
```

El perfil activo determina qué propiedades carga la aplicación.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara el recurso de Docker asociado a **Profiles dentro del contenedor**.
2. Construye y ejecuta el contenedor y comprueba el servicio mediante una petición HTTP.
3. Detén y recrea el contenedor; verifica que la configuración y la persistencia funcionan sin modificar la imagen.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Profiles dentro del contenedor** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion94/">← 94 · Variables de entorno en Docker</a>
  <a href="/spring/leccion96/">96 · Healthcheck de Spring →</a>
</div>
