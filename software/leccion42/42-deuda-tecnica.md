---
layout: lesson
route: software
lesson_id: leccion42
lesson_file: 42-deuda-tecnica
lesson_number: "42"
title: Deuda técnica
description: Comprender el coste futuro de decisiones que facilitan el corto plazo.
permalink: /software/leccion42/
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

# Deuda técnica

## Qué vas a conseguir

Comprender el coste futuro de decisiones que facilitan el corto plazo.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/42-deuda-tecnica.webp' | relative_url }}" aria-label="Ampliar infografía: Deuda técnica">
    <img src="{{ '/assets/images/software/infografias/42-deuda-tecnica.webp' | relative_url }}" alt="Resumen visual: Deuda técnica" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>La deuda debe describirse por sus consecuencias. Reducirla tiene sentido cuando disminuye riesgos o costes relevantes de evolución.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/42-deuda-tecnica.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Deuda técnica:** decisiones o condiciones internas que encarecen cambios futuros.
- **Interés:** esfuerzo adicional recurrente que provoca esa deuda.
- **Reducción de deuda:** trabajo para eliminar o disminuir ese coste.

Para terminar una demostración se duplica una regla de validación. Más adelante cada cambio exige modificar varios lugares.

La deuda puede originarse por una decisión consciente, por falta de conocimiento o por evolución del contexto. No todo defecto es deuda ni toda función pendiente debe llamarse así. La metáfora resulta útil cuando identificamos una causa técnica y su coste de mantenimiento.

Para gestionarla registramos consecuencia, alternativas y señales que justificarían actuar. No es necesario detener todo para corregir cualquier imperfección. Tampoco basta escribir «refactorizar» sin explicar qué problema se pretende reducir.

### Ejemplo guiado

CodeTasks valida el título en tres lugares con reglas ligeramente distintas. Cada ajuste produce errores. Registramos el problema y proponemos centralizar la regla con pruebas de sus límites. La prioridad aumenta porque afecta a cambios frecuentes. Tras hacerlo comprobamos que todas las entradas aplican la misma condición.

## Práctica

1. Distingue una mejora funcional pendiente de una deuda interna.
2. Redacta una tarjeta de deuda con causa, consecuencia y propuesta.
3. Explica cuándo pospondrías esa mejora y qué señal te haría retomarla.

## Para repasar

Refactorización, Testing y análisis estático ayudan a identificar y reducir problemas internos.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion41/' | relative_url }}">← 41 · Calidad del software</a>
  <a href="{{ '/software/leccion43/' | relative_url }}">43 · Mantenimiento del software →</a>
</div>
