---
layout: lesson
route: software
lesson_id: leccion43
lesson_file: 43-mantenimiento-del-software
lesson_number: "43"
title: Mantenimiento del software
description: Distinguir mantenimiento correctivo, adaptativo, perfectivo y preventivo.
permalink: /software/leccion43/
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

# Mantenimiento del software

## Qué vas a conseguir

Distinguir mantenimiento correctivo, adaptativo, perfectivo y preventivo.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/43-mantenimiento-del-software.webp' | relative_url }}" aria-label="Ampliar infografía: Mantenimiento del software">
    <img src="{{ '/assets/images/software/infografias/43-mantenimiento-del-software.webp' | relative_url }}" alt="Resumen visual: Mantenimiento del software" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>El mantenimiento abarca corrección, adaptación, mejora y prevención. Su calidad depende de comprender impacto y conservar comportamientos.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/43-mantenimiento-del-software.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Correctivo:** resolver fallos descubiertos.
- **Adaptativo:** acomodar cambios del entorno.
- **Perfectivo:** mejorar capacidades o cualidades.
- **Preventivo:** reducir problemas futuros mediante cambios anticipados.

Tras el piloto aparecen un error, un cambio de entorno y una petición para mejorar el uso. No todas las intervenciones de mantenimiento tienen el mismo motivo.

Clasificar mantenimiento ayuda a entender por qué se modifica un sistema y qué comprobar. Las categorías pueden solaparse: una actualización puede adaptar el producto y prevenir un riesgo conocido. No conviene tratar la clasificación como una frontera absoluta.

Cada cambio necesita análisis de impacto y pruebas de regresión. Mantener exige conocer datos, dependencias y versiones en uso. Una corrección local puede alterar otro comportamiento; por eso se conserva evidencia de lo modificado.

### Ejemplo guiado

En CodeTasks corregir una fecha mal ordenada es correctivo. Ajustar la aplicación a una nueva versión del entorno es adaptativo. Mejorar un filtro solicitado es perfectivo. Reestructurar un módulo frágil para evitar fallos futuros es preventivo. En cada caso identificamos escenarios que deben seguir funcionando tras el cambio.

## Práctica

1. Clasifica corregir una exportación, mejorar accesibilidad y adaptar una API externa.
2. Explica un caso con más de una motivación.
3. Diseña una prueba de regresión para el error de ordenación.

## Para repasar

Git registra versiones; Testing aporta regresión; Maven ayuda a gestionar cambios de dependencias.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion42/' | relative_url }}">← 42 · Deuda técnica</a>
  <a href="{{ '/software/leccion44/' | relative_url }}">44 · Integración continua →</a>
</div>
