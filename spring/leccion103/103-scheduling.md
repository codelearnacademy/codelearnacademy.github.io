---
layout: lesson
route: spring
lesson_id: leccion103
lesson_file: 103-scheduling
lesson_number: "103"
title: Scheduling
description: Introduce mecanismos transversales de Spring y alternativas arquitectónicas sin perder el modelo mental.
permalink: /spring/leccion103/
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
# Scheduling

Introduce mecanismos transversales de Spring y alternativas arquitectónicas sin perder el modelo mental.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Scheduling** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Capacidades avanzadas de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Programación: Define cuándo ejecutar. Spring: Dispara el método. Tarea: Registra el resultado.]({{ "/assets/images/spring/103-scheduling.webp" | relative_url }})

## Ejemplo guiado

```java
@Scheduled(fixedRate = 60_000)
void cleanup() { ... }
```



## Relación con el resto de la ruta

AOP, proxies, eventos y cache explican parte del comportamiento transversal de Spring; MVC/WebFlux son modelos web distintos.



## Ejemplo adicional: aplicación práctica

```java
@Component
class LimpiezaProgramada {
    @Scheduled(cron = "0 0 3 * * *")
    void limpiar() { /* tarea diaria a las 03:00 */ }
}
```

Activa @EnableScheduling y controla qué ocurre si se despliegan varias réplicas.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Construye un ejemplo pequeño y aislado de **Scheduling**.
2. Compara su comportamiento con y sin la característica y explica en qué momento interviene Spring.
3. Crea una prueba que verifique el resultado observable y no solo la presencia de una anotación.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Scheduling** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion102/">← 102 · Eventos</a>
  <a href="/spring/leccion104/">104 · Cache →</a>
</div>
