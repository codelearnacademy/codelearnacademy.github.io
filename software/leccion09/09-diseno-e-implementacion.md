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
  - id: infografía
    title: Infografía
  - id: explicación-y-ejemplo
    title: Explicación y ejemplo
  - id: práctica
    title: Práctica
  - id: para-repasar
    title: Para repasar
---

# Diseño e implementación

## Qué vas a conseguir

Diferenciar decisiones de diseño de la escritura concreta del código.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/09-diseno-e-implementacion.webp' | relative_url }}" aria-label="Ampliar infografía: Diseño e implementación">
    <img src="{{ '/assets/images/software/infografias/09-diseno-e-implementacion.webp' | relative_url }}" alt="Resumen visual: Diseño e implementación" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Diseño e implementación se influyen. Separar responsabilidades tiene sentido cuando facilita comprensión, pruebas o cambios.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/09-diseno-e-implementacion.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Diseño:** estructura, responsabilidades y contratos de la solución.
- **Implementación:** código y configuración que materializan ese diseño.
- **Acoplamiento:** dependencia entre partes.

Sabemos que CodeTasks debe conservar tareas, pero aún debemos decidir cómo organizar la solución y escribirla.

Diseñar implica distribuir responsabilidades y decidir cómo colaboran los componentes. Implementar concreta esas decisiones mediante código. Ambas actividades se retroalimentan: una dificultad encontrada al programar puede motivar un cambio de diseño.

Un diseño útil facilita explicar una operación y modificarla sin afectar innecesariamente a otras. No se mide por el número de capas o diagramas. Para una aplicación pequeña basta una estructura que responda a sus necesidades y permita comprobar sus reglas.

### Ejemplo guiado

Para crear una tarea separamos la entrada del usuario, la regla «el título no puede estar vacío» y el almacenamiento. El servicio valida; el repositorio guarda. Si cambiamos un archivo por una base de datos, la regla del título puede mantenerse. La implementación añade clases y pruebas para verificar ese contrato.

## Práctica

1. Dibuja las responsabilidades de crear una tarea.
2. Explica dónde comprobarías el título y por qué.
3. Describe qué cambiaría al sustituir el almacenamiento y qué debería conservarse.

## Para repasar

Java materializa clases y contratos; UML los comunica; Testing ayuda a comprobarlos.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion08/' | relative_url }}">← 08 · Análisis de requisitos</a>
  <a href="{{ '/software/leccion10/' | relative_url }}">10 · Pruebas, despliegue y mantenimiento →</a>
</div>
