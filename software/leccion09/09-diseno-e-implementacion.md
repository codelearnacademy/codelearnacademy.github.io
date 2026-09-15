---
layout: lesson
route: software
lesson_id: leccion09
lesson_file: 09-diseno-e-implementacion
lesson_number: "09"
title: Diseño e implementación
description: Diferenciar decisiones de diseño de la escritura concreta del código.
permalink: /software/leccion09/
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

# Diseño e implementación

## Qué vas a conseguir

Diferenciar decisiones de diseño de la escritura concreta del código.

## Punto de partida

Sabemos que CodeTasks debe conservar tareas, pero aún debemos decidir cómo organizar la solución y escribirla.

## Conceptos clave

- **Diseño:** estructura, responsabilidades y contratos de la solución.
- **Implementación:** código y configuración que materializan ese diseño.
- **Acoplamiento:** dependencia entre partes.

## Desarrollo

Diseñar implica distribuir responsabilidades y decidir cómo colaboran los componentes. Implementar concreta esas decisiones mediante código. Ambas actividades se retroalimentan: una dificultad encontrada al programar puede motivar un cambio de diseño.

Un diseño útil facilita explicar una operación y modificarla sin afectar innecesariamente a otras. No se mide por el número de capas o diagramas. Para una aplicación pequeña basta una estructura que responda a sus necesidades y permita comprobar sus reglas.

## Ejemplo guiado

Para crear una tarea separamos la entrada del usuario, la regla «el título no puede estar vacío» y el almacenamiento. El servicio valida; el repositorio guarda. Si cambiamos un archivo por una base de datos, la regla del título puede mantenerse. La implementación añade clases y pruebas para verificar ese contrato.

## Relación con otras rutas

Java materializa clases y contratos; UML los comunica; Testing ayuda a comprobarlos.

## Ejercicios propuestos

1. Dibuja las responsabilidades de crear una tarea.
2. Explica dónde comprobarías el título y por qué.
3. Describe qué cambiaría al sustituir el almacenamiento y qué debería conservarse.

## Qué debes recordar

Diseño e implementación se influyen. Separar responsabilidades tiene sentido cuando facilita comprensión, pruebas o cambios.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion08/' | relative_url }}">← 08 · Análisis de requisitos</a>
  <a href="{{ '/software/leccion10/' | relative_url }}">10 · Pruebas, despliegue y mantenimiento →</a>
</div>
