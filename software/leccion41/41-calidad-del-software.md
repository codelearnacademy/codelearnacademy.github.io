---
layout: lesson
route: software
lesson_id: leccion41
lesson_file: 41-calidad-del-software
lesson_number: "41"
title: Calidad del software
description: Reconocer que calidad incluye corrección, mantenibilidad, seguridad, rendimiento y usabilidad.
permalink: /software/leccion41/
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

# Calidad del software

## Qué vas a conseguir

Reconocer que calidad incluye corrección, mantenibilidad, seguridad, rendimiento y usabilidad.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/41-calidad-del-software.webp' | relative_url }}" aria-label="Ampliar infografía: Calidad del software">
    <img src="{{ '/assets/images/software/infografias/41-calidad-del-software.webp' | relative_url }}" alt="Resumen visual: Calidad del software" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>La calidad es multidimensional. Debe hacerse comprobable sin reducirla a una sola métrica.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/41-calidad-del-software.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Calidad funcional:** adecuación de los comportamientos a las necesidades.
- **Atributos de calidad:** propiedades como fiabilidad, rendimiento o mantenibilidad.
- **Evidencia de calidad:** resultados de comprobaciones relevantes.

CodeTasks guarda tareas, pero puede seguir fallando como producto si no es comprensible, seguro o fácil de modificar.

La calidad tiene varias dimensiones. Una función correcta no compensa por sí sola pérdida de datos o una interfaz inaccesible. Debemos decidir qué atributos importan en el contexto y cómo observarlos.

Ninguna métrica aislada representa toda la calidad. La cobertura de pruebas indica qué código se ejecutó, no que todos los comportamientos importantes estén comprobados. Combinar pruebas, revisiones y uso real permite conocer riesgos distintos. Los objetivos de calidad forman parte de la planificación.

### Ejemplo guiado

CodeTasks comprueba crear y consultar, persistir tras reiniciar, impedir acceso ajeno y recorrer la interfaz con teclado. Una revisión detecta que la misma validación está duplicada, lo que dificultaría cambios. Mejoramos esa estructura y repetimos las pruebas. Los resultados aportan evidencias distintas sobre calidad, no una única puntuación total.

## Práctica

1. Elige tres atributos importantes para el piloto y cómo comprobarlos.
2. Explica qué problema puede escapar a una cobertura elevada.
3. Describe un compromiso entre rendimiento y mantenibilidad que deba discutirse.

## Para repasar

Testing, revisión de código y análisis estático se complementan; ninguno sustituye a todos los demás.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion40/' | relative_url }}">← 40 · MVP y entregas incrementales</a>
  <a href="{{ '/software/leccion42/' | relative_url }}">42 · Deuda técnica →</a>
</div>
