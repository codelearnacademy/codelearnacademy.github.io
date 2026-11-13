---
layout: lesson
route: software
lesson_id: leccion04
lesson_file: 04-que-es-la-ingenieria-del-software
lesson_number: "04"
title: Qué es la ingeniería del software
description: Relacionar desarrollo de software con calidad, coste, plazo, mantenimiento y trabajo en equipo.
permalink: /software/leccion04/
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
---

# Qué es la ingeniería del software

## Qué vas a conseguir

Relacionar desarrollo de software con calidad, coste, plazo, mantenimiento y trabajo en equipo.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/04-que-es-la-ingenieria-del-software.webp' | relative_url }}" aria-label="Ampliar infografía: Qué es la ingeniería del software">
    <img src="{{ '/assets/images/software/infografias/04-que-es-la-ingenieria-del-software.webp' | relative_url }}" alt="Resumen visual: Qué es la ingeniería del software" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>La ingeniería conecta decisiones, restricciones y evidencias. La calidad no depende únicamente de que el código compile.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/04-que-es-la-ingenieria-del-software.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Ingeniería:** aplicación sistemática de conocimientos para construir y mantener soluciones.
- **Evidencia:** información que permite evaluar una decisión.
- **Compromiso:** elección entre objetivos que pueden competir.

Dos equipos pueden programar la misma pantalla y obtener resultados muy distintos en fiabilidad, coste y facilidad de cambio.

La ingeniería del software aborda requisitos, diseño, construcción, pruebas, operación y mantenimiento de forma disciplinada. Incluye justificar decisiones y comprobar resultados; escribir código es una de sus actividades.

No exige producir documentos sin utilidad ni aplicar siempre el mismo proceso. El rigor se adapta al riesgo: perder una tarea de prueba y perder información crítica tienen consecuencias diferentes. Las decisiones deben considerar calidad, plazo, presupuesto y capacidad del equipo. Si una restricción cambia, revisamos las alternativas en lugar de asumir que el plan original sigue siendo válido.

### Ejemplo guiado

CodeTasks necesita conservar entregas al reiniciar. El equipo compara archivos y base de datos según concurrencia, recuperación y conocimientos disponibles. Registra su elección, prueba el reinicio y documenta cómo recuperar una copia. La decisión tiene un motivo y una comprobación observable.

## Práctica

1. Propón una decisión técnica para CodeTasks y dos alternativas.
2. Indica qué evidencia permitiría comprobar que la elección funciona.
3. Explica cómo cambiaría tu análisis si el producto gestionara información irrecuperable.

## Para repasar

UML ayuda a comunicar diseño; Testing comprueba comportamientos; Maven hace reproducible la construcción.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion03/' | relative_url }}">← 03 · Software como producto</a>
  <a href="{{ '/software/leccion05/' | relative_url }}">05 · Proyecto, producto y servicio →</a>
</div>
