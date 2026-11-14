---
layout: lesson
route: spring
lesson_id: leccion93
lesson_file: 93-healthcheck-de-spring
lesson_number: "93"
title: Healthcheck de Spring
description: Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.
permalink: /spring/leccion93/
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
# Healthcheck de Spring

Empaqueta y ejecuta Spring Boot de forma reproducible con Docker y PostgreSQL.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Healthcheck de Spring** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedores y despliegue.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Contenedor: Ejecuta la sonda. Actuator: Responde con salud. Docker: Registra el estado.]({{ "/assets/images/spring/93-healthcheck-de-spring.webp" | relative_url }})

## Ejemplo guiado

Usa `/actuator/health` como señal de salud de la aplicación y comprueba qué ocurre cuando PostgreSQL deja de responder.



## Relación con el resto de la ruta

Maven construye, Boot empaqueta/ejecuta, Docker crea el entorno, Compose conecta aplicación y base de datos.



## Ejemplo adicional: aplicación práctica

```yaml
healthcheck:
  test: ["CMD-SHELL", "wget -q -O - http://localhost:8080/actuator/health >/dev/null"]
  interval: 30s
  timeout: 5s
  retries: 3
```

La imagen debe disponer de wget, curl o una alternativa real para ejecutar el healthcheck.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara el recurso de Docker asociado a **Healthcheck de Spring**.
2. Construye y ejecuta el contenedor y comprueba el servicio mediante una petición HTTP.
3. Detén y recrea el contenedor; verifica que la configuración y la persistencia funcionan sin modificar la imagen.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Healthcheck de Spring** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion92/">← 92 · Profiles dentro del contenedor</a>
  <a href="/spring/leccion94/">94 · Spring Boot y Cloud Native Buildpacks →</a>
</div>
