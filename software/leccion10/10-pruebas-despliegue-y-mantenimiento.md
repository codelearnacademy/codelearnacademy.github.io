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
---

# Pruebas, despliegue y mantenimiento

## Qué vas a conseguir

Situar testing, despliegue y mantenimiento dentro del ciclo de vida.

## Punto de partida

CodeTasks funciona en una demostración. Antes de ofrecerlo a una clase hay que comprobarlo, entregarlo y preparar su operación.

## Conceptos clave

- **Prueba:** evaluación del comportamiento bajo condiciones concretas.
- **Despliegue:** instalación o actualización en un entorno.
- **Mantenimiento:** modificación del software durante su vida útil.

## Desarrollo

Las pruebas aportan evidencia sobre comportamientos y riesgos; no demuestran ausencia total de errores. Deben prepararse durante el desarrollo y cubrir casos relevantes, incluidas situaciones de fallo.

Desplegar requiere identificar la versión, configurar el entorno y comprobar que el servicio responde. Mantener incluye corregir errores y adaptar el sistema a cambios. Operar añade actividades como supervisión y recuperación. Una entrega debe prever qué hacer si falla: restaurar una versión anterior puede no bastar cuando también han cambiado los datos.

## Ejemplo guiado

Probamos que una tarea persiste tras reiniciar. Desplegamos una versión identificada en el entorno piloto y verificamos crear y consultar. Si falla una migración, detenemos la actualización y seguimos el procedimiento de recuperación probado. Después registramos el incidente y añadimos una comprobación que evite repetirlo.

## Relación con otras rutas

Testing profundiza en las pruebas; Docker en entornos; Ficheros en persistencia y tratamiento de errores.

## Ejercicios propuestos

1. Escribe un caso normal y uno de fallo al guardar una tarea.
2. Prepara una lista de comprobaciones posteriores al despliegue.
3. Explica qué datos necesitarías antes de intentar una recuperación.

## Qué debes recordar

Probar, desplegar y mantener tienen propósitos distintos. La entrega necesita comprobaciones y un procedimiento de recuperación.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion09/' | relative_url }}">← 09 · Diseño e implementación</a>
  <a href="{{ '/software/leccion11/' | relative_url }}">11 · Qué es una metodología de desarrollo →</a>
</div>
