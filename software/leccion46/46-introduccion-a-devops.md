---
layout: lesson
route: software
lesson_id: leccion46
lesson_file: 46-introduccion-a-devops
lesson_number: "46"
title: Introducción a DevOps
description: Comprender DevOps como cultura de colaboración, automatización y feedback.
permalink: /software/leccion46/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: desarrollo
    title: Desarrollo
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-otras-rutas
    title: Relación con otras rutas
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
  - id: referencias
    title: Referencias
---

# Introducción a DevOps

## Qué vas a conseguir

Comprender DevOps como cultura de colaboración, automatización y feedback.

## Punto de partida

CodeTasks funciona en desarrollo, pero al entregarlo aparecen problemas de configuración que nadie había considerado responsabilidad propia.

## Conceptos clave

- **Colaboración:** compartir información entre quienes construyen y operan.
- **Automatización:** reducir pasos repetitivos y errores manuales.
- **Observación:** conocer el comportamiento del servicio en uso.

## Desarrollo

DevOps combina formas de colaboración y prácticas técnicas para mejorar construcción, entrega y operación. No se reduce a instalar Docker o asignar a una persona todos los problemas de infraestructura.

El equipo necesita comprender cómo se ejecuta el producto, qué señales indican fallos y cómo recuperarlo. Las incidencias sirven para mejorar el sistema y el proceso. Automatizar un procedimiento confuso sin revisarlo puede reproducir sus errores más deprisa.

## Ejemplo guiado

En CodeTasks, desarrollo y operación acuerdan variables de configuración, una comprobación de disponibilidad y pasos de recuperación. Una incidencia revela un valor ausente; se incorpora una validación al arranque y se actualizan instrucciones. En la siguiente entrega la comprobación detecta el problema antes de ofrecer el servicio a estudiantes.

## Relación con otras rutas

Docker, Git, Maven y Testing ayudan cuando forman parte de acuerdos operativos claros.

## Ejercicios propuestos

1. Enumera información que debe acompañar una entrega de CodeTasks.
2. Propón una señal operativa y qué harías si cambia.
3. Redacta una mejora tras una incidencia sin atribuirla simplemente a «error humano».

## Qué debes recordar

DevOps conecta construcción y operación mediante colaboración, automatización y aprendizaje. Una herramienta aislada no aporta esa conexión.

## Referencias

- [DORA: integración continua](https://dora.dev/capabilities/continuous-integration/)
- [DORA: entrega continua](https://dora.dev/capabilities/continuous-delivery/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion45/' | relative_url }}">← 45 · Entrega y despliegue continuo</a>
  <a href="{{ '/software/leccion47/' | relative_url }}">47 · Caso práctico · Analizando un proyecto →</a>
</div>
