---
layout: lesson
route: spring
lesson_id: leccion89
lesson_file: 89-healthchecks
lesson_number: "89"
title: Healthchecks
description: Prepara la aplicación para operación mediante logs, health, métricas y configuración.
permalink: /spring/leccion89/
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
# Healthchecks

Prepara la aplicación para operación mediante logs, health, métricas y configuración.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Healthchecks** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Observabilidad y producción.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Sonda: Consulta salud. Aplicación: Evalúa los indicadores. Resultado: Devuelve estado.]({{ "/assets/images/spring/86-healthchecks.webp" | relative_url }})

## Ejemplo guiado

Relaciona:

```text
Spring Actuator health
        ↓
Docker HEALTHCHECK / plataforma
```



## Relación con el resto de la ruta

Actuator y Micrometer conectan la aplicación con Docker, CI/CD y plataformas de monitorización.



## Ejemplo adicional: aplicación práctica

```bash
curl -i http://localhost:8080/actuator/health
# Respuesta típica: {"status":"UP"}
```

La disponibilidad del endpoint depende de la configuración de Actuator.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Configura **Healthchecks** en un perfil local y describe qué información ofrece.
2. Comprueba que los datos sensibles no aparecen en logs ni endpoints públicos.
3. Define un indicador o prueba observable que permita distinguir aplicación iniciada de aplicación lista para atender peticiones.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Healthchecks** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion88/">← 88 · Métricas con Micrometer</a>
  <a href="/spring/leccion90/">90 · Configuración para producción →</a>
</div>
