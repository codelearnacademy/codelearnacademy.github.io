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
  - id: referencias
    title: Referencias
---

# Entrega y despliegue continuo

## Qué vas a conseguir

Diferenciar Continuous Delivery y Continuous Deployment.

## Punto de partida

Una versión de CodeTasks supera sus pruebas. Decidir si puede desplegarse y si se desplegará automáticamente son preguntas distintas.

## Conceptos clave

- **Entrega continua:** capacidad de desplegar bajo demanda de forma fiable.
- **Despliegue continuo:** paso automático a producción tras superar las comprobaciones acordadas.
- **Artefacto:** versión identificable que recorre el proceso de entrega.

## Desarrollo

La entrega continua mantiene el software preparado para desplegar; puede existir una decisión humana de publicación. El despliegue continuo automatiza también ese paso. Son prácticas relacionadas, pero distintas.

El flujo necesita configuración, comprobaciones y recuperación. Un cambio de datos puede requerir compatibilidad entre versiones; volver al binario anterior no siempre revierte una migración. El equipo debe comprobar qué estrategia de recuperación es viable.

```text
CI → artefacto → comprobaciones de entrega → listo para producción
                                           ├─ decisión de publicar
                                           └─ publicación automática
```

## Ejemplo guiado

CodeTasks genera una versión y la valida en el entorno de pruebas. En el piloto, el docente decide cuándo publicarla: es compatible con entrega continua. Si más adelante cada versión que pasa controles se publica automáticamente, se añade despliegue continuo. En ambos casos comprobamos el servicio después y conservamos un procedimiento de recuperación.

## Relación con otras rutas

Maven produce artefactos; Docker ayuda a distribuirlos; Testing aporta verificaciones.

## Ejercicios propuestos

1. Identifica dónde situarías una decisión humana en el dibujo.
2. Define una comprobación antes y otra después del despliegue.
3. Explica por qué una migración obliga a planificar recuperación de datos.

## Qué debes recordar

Estar preparado para desplegar y desplegar automáticamente son capacidades diferentes. Ambas requieren controlar riesgos de la entrega.

## Referencias

- [DORA: integración continua](https://dora.dev/capabilities/continuous-integration/)
- [DORA: entrega continua](https://dora.dev/capabilities/continuous-delivery/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion44/' | relative_url }}">← 44 · Integración continua</a>
  <a href="{{ '/software/leccion46/' | relative_url }}">46 · Introducción a DevOps →</a>
</div>
