---
layout: lesson
route: software
lesson_id: leccion37
lesson_file: 37-descomposicion-del-trabajo
lesson_number: "37"
title: Descomposición del trabajo
description: Dividir objetivos grandes en piezas pequeñas, verificables y gestionables.
permalink: /software/leccion37/
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

# Descomposición del trabajo

## Qué vas a conseguir

Dividir objetivos grandes en piezas pequeñas, verificables y gestionables.

## Punto de partida

«Construir CodeTasks» no permite estimar ni comprobar avance con suficiente precisión.

## Conceptos clave

- **Descomposición:** dividir un resultado amplio en unidades comprensibles.
- **Porción vertical:** recorrido que produce una capacidad comprobable.
- **Dependencia:** relación que condiciona orden o ejecución.

## Desarrollo

Primero dividimos por resultados de usuario; después identificamos tareas técnicas necesarias para cada resultado. Así podemos evaluar utilidad sin perder de vista diseño, persistencia y pruebas.

Una división excesiva también perjudica: tarjetas que no pueden entenderse sin leer diez más generan coordinación innecesaria. Buscamos unidades pequeñas pero con sentido. Las dependencias deben hacerse visibles, y una investigación puede preceder a una estimación cuando falta información crítica.

## Ejemplo guiado

«Gestionar tareas» se divide en crear y consultar, completar, y ordenar por fecha. Dentro de crear y consultar aparecen validar título, guardar, mostrar y probar reinicio. Separar toda la interfaz de toda la persistencia dejaría varias semanas sin un recorrido completo. Conservamos la relación entre tareas técnicas y capacidad entregable.

## Relación con otras rutas

UML aclara dependencias; Git permite relacionar cambios pequeños con cada resultado.

## Ejercicios propuestos

1. Divide «gestionar una biblioteca» en tres resultados utilizables.
2. Descompón ordenar por fecha en tareas técnicas y comprobaciones.
3. Identifica una dependencia que deba resolverse primero.

## Qué debes recordar

La división debe facilitar comprensión, ejecución y comprobación. Las tareas técnicas sirven a un resultado explícito.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion36/' | relative_url }}">← 36 · Definition of Done</a>
  <a href="{{ '/software/leccion38/' | relative_url }}">38 · Estimación →</a>
</div>
