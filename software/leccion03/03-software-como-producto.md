---
layout: lesson
route: software
lesson_id: leccion03
lesson_file: 03-software-como-producto
lesson_number: "03"
title: Software como producto
description: Entender que el software profesional es un producto mantenible y entregable, no solo código fuente.
permalink: /software/leccion03/
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

# Software como producto

## Qué vas a conseguir

Entender que el software profesional es un producto mantenible y entregable, no solo código fuente.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/03-software-como-producto.webp' | relative_url }}" aria-label="Ampliar infografía: Software como producto">
    <img src="{{ '/assets/images/software/infografias/03-software-como-producto.webp' | relative_url }}" alt="Resumen visual: Software como producto" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Un producto requiere continuidad de uso y mantenimiento. Una demostración funcional no equivale automáticamente a una entrega preparada para usuarios.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/03-software-como-producto.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Producto:** solución que se mantiene para un grupo de usuarios.
- **Resultado:** cambio útil que produce en su actividad.
- **Evolución:** adaptación del producto a necesidades y problemas observados.

Un prototipo de CodeTasks permite crear tareas, pero nadie sabe instalarlo ni recuperar sus datos. ¿Está preparado para ofrecerse a una clase?

Tratar software como producto obliga a pensar en su uso a lo largo del tiempo. Además de funcionalidades, requiere decisiones sobre soporte, actualizaciones, fiabilidad y costes de operación. Una demostración puede validar una idea sin estar preparada para un uso estable.

La cantidad de funciones no demuestra utilidad. Debemos observar resultados: si los estudiantes encuentran sus próximas entregas y evitan olvidos. La evolución combina nuevas capacidades y mejoras internas que permiten seguir ofreciendo el servicio.

### Ejemplo guiado

La primera demostración de CodeTasks guarda tareas en memoria. Sirve para discutir la interfaz, pero pierde todo al reiniciar. Para un piloto de uso real añadimos persistencia, instrucciones y una forma de comunicar incidencias. Evaluamos cuántos participantes consiguen registrar y consultar sus entregas, además de contar funciones terminadas.

## Práctica

1. Distingue qué exigirías a una demostración y a un piloto con datos reales.
2. Define dos indicadores de utilidad de CodeTasks.
3. Justifica una mejora de mantenimiento que no añada pantallas.

## Para repasar

Testing ayuda a conservar comportamientos al evolucionar; Git permite identificar versiones entregadas.

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion02/' | relative_url }}">← 02 · Tipos de software</a>
  <a href="{{ '/software/leccion04/' | relative_url }}">04 · Qué es la ingeniería del software →</a>
</div>
