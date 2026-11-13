---
layout: lesson
route: software
lesson_id: leccion13
lesson_file: 13-modelo-en-v
lesson_number: "13"
title: Modelo en V
description: Relacionar fases de desarrollo con verificación y validación.
permalink: /software/leccion13/
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

# Modelo en V

## Qué vas a conseguir

Relacionar fases de desarrollo con verificación y validación.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/13-modelo-en-v.webp' | relative_url }}" aria-label="Ampliar infografía: Modelo en V">
    <img src="{{ '/assets/images/software/infografias/13-modelo-en-v.webp' | relative_url }}" alt="Resumen visual: Modelo en V" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>La V conecta definición y comprobación. Cumplir una especificación no garantiza que la necesidad estuviera bien entendida.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/13-modelo-en-v.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Verificación:** comprobar conformidad con lo especificado.
- **Validación:** comprobar adecuación a las necesidades de uso.
- **Trazabilidad:** relación entre requisito, diseño y comprobación.

Una regla de CodeTasks debe poder seguirse desde su definición hasta la evidencia que demuestra su cumplimiento.

El modelo en V relaciona actividades de definición y descomposición con actividades de integración y pruebas. Una representación habitual asocia necesidades con aceptación, requisitos del sistema con pruebas de sistema, arquitectura con integración y diseño de componentes con pruebas unitarias. Los nombres y detalles varían según el modelo empleado.

La enseñanza principal es preparar cómo comprobar cada nivel mientras se define, no esperar al final para pensar en pruebas. Verificación y validación pueden incluir revisiones y otras técnicas, además de ejecutar software.

### Ejemplo guiado

Necesidad: encontrar la próxima entrega. Requisito: ordenar pendientes por fecha. Diseñamos un componente de ordenación y su conexión con persistencia. Una prueba unitaria comprueba el orden; una de integración comprueba recuperar fechas; una de sistema recorre la pantalla; una sesión de aceptación confirma que estudiantes encuentran su próxima entrega.

## Práctica

1. Relaciona la regla «título obligatorio» con una comprobación de componente y otra de sistema.
2. Explica cómo puede pasar una prueba técnica y fallar la validación con usuarios.
3. Construye una tabla requisito → diseño → prueba para dos requisitos.

## Para repasar

Testing desarrolla niveles de prueba; UML ayuda a conectar responsabilidades y componentes.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion12/' | relative_url }}">← 12 · Modelo en cascada</a>
  <a href="{{ '/software/leccion14/' | relative_url }}">14 · Desarrollo incremental →</a>
</div>
