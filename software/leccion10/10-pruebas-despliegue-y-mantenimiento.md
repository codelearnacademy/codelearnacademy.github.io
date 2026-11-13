---
layout: lesson
route: software
lesson_id: leccion10
lesson_file: 10-pruebas-despliegue-y-mantenimiento
lesson_number: "10"
title: Pruebas, despliegue y mantenimiento
description: Situar testing, despliegue y mantenimiento dentro del ciclo de vida.
permalink: /software/leccion10/
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

# Pruebas, despliegue y mantenimiento

## Qué vas a conseguir

Situar testing, despliegue y mantenimiento dentro del ciclo de vida.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/10-pruebas-despliegue-y-mantenimiento.webp' | relative_url }}" aria-label="Ampliar infografía: Pruebas, despliegue y mantenimiento">
    <img src="{{ '/assets/images/software/infografias/10-pruebas-despliegue-y-mantenimiento.webp' | relative_url }}" alt="Resumen visual: Pruebas, despliegue y mantenimiento" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Probar, desplegar y mantener tienen propósitos distintos. La entrega necesita comprobaciones y un procedimiento de recuperación.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/10-pruebas-despliegue-y-mantenimiento.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Prueba:** evaluación del comportamiento bajo condiciones concretas.
- **Despliegue:** instalación o actualización en un entorno.
- **Mantenimiento:** modificación del software durante su vida útil.

CodeTasks funciona en una demostración. Antes de ofrecerlo a una clase hay que comprobarlo, entregarlo y preparar su operación.

Las pruebas aportan evidencia sobre comportamientos y riesgos; no demuestran ausencia total de errores. Deben prepararse durante el desarrollo y cubrir casos relevantes, incluidas situaciones de fallo.

Desplegar requiere identificar la versión, configurar el entorno y comprobar que el servicio responde. Mantener incluye corregir errores y adaptar el sistema a cambios. Operar añade actividades como supervisión y recuperación. Una entrega debe prever qué hacer si falla: restaurar una versión anterior puede no bastar cuando también han cambiado los datos.

### Ejemplo guiado

Probamos que una tarea persiste tras reiniciar. Desplegamos una versión identificada en el entorno piloto y verificamos crear y consultar. Si falla una migración, detenemos la actualización y seguimos el procedimiento de recuperación probado. Después registramos el incidente y añadimos una comprobación que evite repetirlo.

## Práctica

1. Escribe un caso normal y uno de fallo al guardar una tarea.
2. Prepara una lista de comprobaciones posteriores al despliegue.
3. Explica qué datos necesitarías antes de intentar una recuperación.

## Para repasar

Testing profundiza en las pruebas; Docker en entornos; Ficheros en persistencia y tratamiento de errores.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion09/' | relative_url }}">← 09 · Diseño e implementación</a>
  <a href="{{ '/software/leccion11/' | relative_url }}">11 · Qué es una metodología de desarrollo →</a>
</div>
