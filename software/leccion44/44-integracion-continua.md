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

# Integración continua

## Qué vas a conseguir

Comprender CI como integración frecuente y verificación automática.

## Punto de partida

Varios cambios de CodeTasks funcionan por separado, pero fallan al combinarse. Detectarlo al final dificulta localizar la causa.

## Conceptos clave

- **Integración continua:** incorporar cambios pequeños frecuentemente a una línea compartida.
- **Construcción automática:** producir el software de forma repetible.
- **Regresión:** comportamiento que deja de funcionar después de un cambio.

## Desarrollo

CI combina integración frecuente y comprobaciones automáticas rápidas. Tener un servidor que ejecuta pruebas en ramas aisladas durante semanas no resuelve el problema de integrar tarde.

El equipo debe atender enseguida una construcción rota. El despliegue no es un requisito de CI: puede añadirse en un flujo de entrega posterior. Las comprobaciones deben ser suficientemente rápidas y fiables para orientar el trabajo diario.

```text
Cambio pequeño → integrar → construir → probar → resultado visible
                                          ├─ fallo: corregir
                                          └─ éxito: versión comprobada
```

## Ejemplo guiado

Una persona cambia la validación de CodeTasks y otra modifica persistencia. Al integrar, una prueba detecta que una tarea válida ya no se guarda. Se corrige el cambio antes de seguir acumulando trabajo. La causa está cerca y el equipo comparte el resultado. Esta práctica funciona aunque todavía no haya despliegue automático.

## Relación con otras rutas

Git aporta integración; Maven construcción reproducible; Testing comprobaciones automáticas.

## Ejercicios propuestos

1. Explica por qué ejecutar pruebas solo al final de la semana es insuficiente.
2. Propón tres comprobaciones rápidas para CodeTasks.
3. Define cómo actuar si la rama compartida deja de construir.

## Qué debes recordar

CI requiere integrar pronto y reaccionar a fallos. Construir y probar no implica desplegar a producción.

## Referencias

- [DORA: integración continua](https://dora.dev/capabilities/continuous-integration/)
- [DORA: entrega continua](https://dora.dev/capabilities/continuous-delivery/)

<div class="cla-lesson-nav">
  <a href="{{ '/software/leccion43/' | relative_url }}">← 43 · Mantenimiento del software</a>
  <a href="{{ '/software/leccion45/' | relative_url }}">45 · Entrega y despliegue continuo →</a>
</div>
