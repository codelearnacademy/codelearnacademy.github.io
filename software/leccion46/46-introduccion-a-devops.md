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
  - id: infografía
    title: Infografía
  - id: explicación-y-ejemplo
    title: Explicación y ejemplo
  - id: práctica
    title: Práctica
  - id: para-repasar
    title: Para repasar
  - id: referencias
    title: Referencias
---

# Introducción a DevOps

## Qué vas a conseguir

Comprender DevOps como cultura de colaboración, automatización y feedback.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/46-introduccion-a-devops.webp' | relative_url }}" aria-label="Ampliar infografía: Introducción a DevOps">
    <img src="{{ '/assets/images/software/infografias/46-introduccion-a-devops.webp' | relative_url }}" alt="Resumen visual: Introducción a DevOps" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>DevOps conecta construcción y operación mediante colaboración, automatización y aprendizaje. Una herramienta aislada no aporta esa conexión.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/46-introduccion-a-devops.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Colaboración:** compartir información entre quienes construyen y operan.
- **Automatización:** reducir pasos repetitivos y errores manuales.
- **Observación:** conocer el comportamiento del servicio en uso.

CodeTasks funciona en desarrollo, pero al entregarlo aparecen problemas de configuración que nadie había considerado responsabilidad propia.

DevOps combina formas de colaboración y prácticas técnicas para mejorar construcción, entrega y operación. No se reduce a instalar Docker o asignar a una persona todos los problemas de infraestructura.

El equipo necesita comprender cómo se ejecuta el producto, qué señales indican fallos y cómo recuperarlo. Las incidencias sirven para mejorar el sistema y el proceso. Automatizar un procedimiento confuso sin revisarlo puede reproducir sus errores más deprisa.

### Ejemplo guiado

En CodeTasks, desarrollo y operación acuerdan variables de configuración, una comprobación de disponibilidad y pasos de recuperación. Una incidencia revela un valor ausente; se incorpora una validación al arranque y se actualizan instrucciones. En la siguiente entrega la comprobación detecta el problema antes de ofrecer el servicio a estudiantes.

## Práctica

1. Enumera información que debe acompañar una entrega de CodeTasks.
2. Propón una señal operativa y qué harías si cambia.
3. Redacta una mejora tras una incidencia sin atribuirla simplemente a «error humano».

## Para repasar

Docker, Git, Maven y Testing ayudan cuando forman parte de acuerdos operativos claros.

## Referencias

- [DORA: integración continua](https://dora.dev/capabilities/continuous-integration/)
- [DORA: entrega continua](https://dora.dev/capabilities/continuous-delivery/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion45/' | relative_url }}">← 45 · Entrega y despliegue continuo</a>
  <a href="{{ '/software/leccion47/' | relative_url }}">47 · Caso práctico · Analizando un proyecto →</a>
</div>
