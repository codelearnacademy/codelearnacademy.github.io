---
layout: lesson
route: software
lesson_id: leccion44
lesson_file: 44-integracion-continua
lesson_number: "44"
title: Integración continua
description: Comprender CI como integración frecuente y verificación automática.
permalink: /software/leccion44/
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

# Integración continua

## Qué vas a conseguir

Comprender CI como integración frecuente y verificación automática.

## Infografía

<figure class="cla-lesson-infografia" style="margin-inline:0">
  <a href="{{ '/assets/images/software/infografias/44-integracion-continua.webp' | relative_url }}" aria-label="Ampliar infografía: Integración continua">
    <img src="{{ '/assets/images/software/infografias/44-integracion-continua.webp' | relative_url }}" alt="Resumen visual: Integración continua" style="display:block;max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>CI requiere integrar pronto y reaccionar a fallos. Construir y probar no implica desplegar a producción.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/software/infografias/44-integracion-continua.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/software/infografias/' | relative_url }}">Ver galería</a>
</div>

## Explicación y ejemplo

- **Integración continua:** incorporar cambios pequeños frecuentemente a una línea compartida.
- **Construcción automática:** producir el software de forma repetible.
- **Regresión:** comportamiento que deja de funcionar después de un cambio.

Varios cambios de CodeTasks funcionan por separado, pero fallan al combinarse. Detectarlo al final dificulta localizar la causa.

CI combina integración frecuente y comprobaciones automáticas rápidas. Tener un servidor que ejecuta pruebas en ramas aisladas durante semanas no resuelve el problema de integrar tarde.

El equipo debe atender enseguida una construcción rota. El despliegue no es un requisito de CI: puede añadirse en un flujo de entrega posterior. Las comprobaciones deben ser suficientemente rápidas y fiables para orientar el trabajo diario.

```text
Cambio pequeño → integrar → construir → probar → resultado visible
                                          ├─ fallo: corregir
                                          └─ éxito: versión comprobada
```

### Ejemplo guiado

Una persona cambia la validación de CodeTasks y otra modifica persistencia. Al integrar, una prueba detecta que una tarea válida ya no se guarda. Se corrige el cambio antes de seguir acumulando trabajo. La causa está cerca y el equipo comparte el resultado. Esta práctica funciona aunque todavía no haya despliegue automático.

## Práctica

1. Explica por qué ejecutar pruebas solo al final de la semana es insuficiente.
2. Propón tres comprobaciones rápidas para CodeTasks.
3. Define cómo actuar si la rama compartida deja de construir.

## Para repasar

Git aporta integración; Maven construcción reproducible; Testing comprobaciones automáticas.

## Referencias

- [DORA: integración continua](https://dora.dev/capabilities/continuous-integration/)
- [DORA: entrega continua](https://dora.dev/capabilities/continuous-delivery/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion43/' | relative_url }}">← 43 · Mantenimiento del software</a>
  <a href="{{ '/software/leccion45/' | relative_url }}">45 · Entrega y despliegue continuo →</a>
</div>
