---
layout: lesson
route: software
lesson_id: leccion45
lesson_file: 45-entrega-y-despliegue-continuo
lesson_number: "45"
title: Entrega y despliegue continuo
description: Diferenciar Continuous Delivery y Continuous Deployment.
permalink: /software/leccion45/
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
  - id: referencias
    title: Referencias
---

# Entrega y despliegue continuo

## Qué vas a conseguir

Diferenciar Continuous Delivery y Continuous Deployment.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/45-entrega-y-despliegue-continuo.webp' | relative_url }}" aria-label="Ampliar infografía: Entrega y despliegue continuo">
    <img src="{{ '/assets/images/software/infografias/45-entrega-y-despliegue-continuo.webp' | relative_url }}" alt="Resumen visual: Entrega y despliegue continuo" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Estar preparado para desplegar y desplegar automáticamente son capacidades diferentes. Ambas requieren controlar riesgos de la entrega.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/45-entrega-y-despliegue-continuo.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Entrega continua:** capacidad de desplegar bajo demanda de forma fiable.
- **Despliegue continuo:** paso automático a producción tras superar las comprobaciones acordadas.
- **Artefacto:** versión identificable que recorre el proceso de entrega.

Una versión de CodeTasks supera sus pruebas. Decidir si puede desplegarse y si se desplegará automáticamente son preguntas distintas.

La entrega continua mantiene el software preparado para desplegar; puede existir una decisión humana de publicación. El despliegue continuo automatiza también ese paso. Son prácticas relacionadas, pero distintas.

El flujo necesita configuración, comprobaciones y recuperación. Un cambio de datos puede requerir compatibilidad entre versiones; volver al binario anterior no siempre revierte una migración. El equipo debe comprobar qué estrategia de recuperación es viable.

```text
CI → artefacto → comprobaciones de entrega → listo para producción
                                           ├─ decisión de publicar
                                           └─ publicación automática
```

### Ejemplo guiado

CodeTasks genera una versión y la valida en el entorno de pruebas. En el piloto, el docente decide cuándo publicarla: es compatible con entrega continua. Si más adelante cada versión que pasa controles se publica automáticamente, se añade despliegue continuo. En ambos casos comprobamos el servicio después y conservamos un procedimiento de recuperación.

## Práctica

1. Identifica dónde situarías una decisión humana en el dibujo.
2. Define una comprobación antes y otra después del despliegue.
3. Explica por qué una migración obliga a planificar recuperación de datos.

## Para repasar

Maven produce artefactos; Docker ayuda a distribuirlos; Testing aporta verificaciones.

## Referencias

- [DORA: integración continua](https://dora.dev/capabilities/continuous-integration/)
- [DORA: entrega continua](https://dora.dev/capabilities/continuous-delivery/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion44/' | relative_url }}">← 44 · Integración continua</a>
  <a href="{{ '/software/leccion46/' | relative_url }}">46 · Introducción a DevOps →</a>
</div>
