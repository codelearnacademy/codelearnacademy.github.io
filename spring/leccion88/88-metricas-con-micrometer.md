---
layout: lesson
route: spring
lesson_id: leccion88
lesson_file: 88-metricas-con-micrometer
lesson_number: "88"
title: Métricas con Micrometer
description: Prepara la aplicación para operación mediante logs, health, métricas y configuración.
permalink: /spring/leccion88/
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
# Métricas con Micrometer

Prepara la aplicación para operación mediante logs, health, métricas y configuración.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Métricas con Micrometer** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Observabilidad y producción.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Petición: Genera una observación. Micrometer: Registra una métrica. Panel: Muestra evolución.]({{ "/assets/images/spring/85-metricas-con-micrometer.webp" | relative_url }})

## Ejemplo guiado

Usa Micrometer para entender contadores, timers y gauges sin acoplar la aplicación a un backend de métricas concreto.



## Relación con el resto de la ruta

Actuator y Micrometer conectan la aplicación con Docker, CI/CD y plataformas de monitorización.



## Ejemplo adicional: aplicación práctica

```java
@Component
class ContadorTareas {
    private final Counter creadas;
    ContadorTareas(MeterRegistry registry) {
        this.creadas = registry.counter("tareas_creadas_total");
    }
    void registrarCreacion() { creadas.increment(); }
}
```

Micrometer permite publicar métricas sin acoplarse al sistema de monitorización.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Configura **Métricas con Micrometer** en un perfil local y describe qué información ofrece.
2. Comprueba que los datos sensibles no aparecen en logs ni endpoints públicos.
3. Define un indicador o prueba observable que permita distinguir aplicación iniciada de aplicación lista para atender peticiones.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Métricas con Micrometer** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion87/">← 87 · Spring Boot Actuator</a>
  <a href="/spring/leccion89/">89 · Healthchecks →</a>
</div>
