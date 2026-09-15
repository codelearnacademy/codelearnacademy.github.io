---
layout: lesson
route: git
lesson_id: leccion20
lesson_number: "20"
title: "Flujo de trabajo profesional con Git"
description: "Integra ramas, revisión y sincronización en un flujo repetible para trabajar de forma segura."
permalink: /git/leccion20/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: flujo-recomendado
    title: "Flujo recomendado"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: qué-no-debes-convertir-en-rutina-ciega
    title: "Qué no debes convertir en rutina ciega"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Flujo de trabajo profesional con Git

Ya conoces las piezas principales. Ahora las uniremos en una rutina repetible que reduce errores y facilita el trabajo en equipo.

## Qué vas a conseguir

- Aplicar un flujo completo desde `main` hasta la integración.
- Mantener una tarea aislada en una rama.
- Revisar antes de commit y antes de push.
- Crear una PR/MR pequeña y comprensible.
- Limpiar y actualizar el entorno después del merge.

## Flujo recomendado

### 1. Actualizar main

```bash
git switch main
git pull
```

### 2. Crear una rama

```bash
git switch -c feature/nueva-seccion
```

### 3. Trabajar y revisar

```bash
git status
git diff
```

### 4. Preparar cambios

```bash
git add <archivos>
git diff --staged
```

### 5. Crear commits

```bash
git commit -m "Añadir nueva sección"
```

### 6. Publicar la rama

```bash
git push -u origin feature/nueva-seccion
```

### 7. Abrir PR/MR

Solicita revisión y responde a los comentarios mediante nuevos commits.

### 8. Integrar

Realiza el merge mediante el procedimiento definido por el equipo.

### 9. Actualizar y limpiar

```bash
git switch main
git pull
git branch -d feature/nueva-seccion
```

<!-- IMAGEN MUY RECOMENDADA: /assets/images/git/leccion20/flujo-profesional.svg
main actualizado → rama → cambios → commits → push → PR/MR → review → merge → main actualizado. -->

## Ejemplo guiado

Realiza todo el flujo para añadir `docs/faq.md`. No omitas `git diff --staged` antes del commit ni la revisión de la PR/MR.

## Qué no debes convertir en rutina ciega

No ejecutes `pull`, `merge` o comandos de recuperación sin comprobar antes:

```bash
git status
```

Un flujo profesional no consiste en memorizar una receta, sino en saber **qué estado esperas antes y después de cada operación**.

## Ejercicios propuestos

**Ejercicio 1.** Completa el flujo completo con una tarea pequeña.

**Ejercicio 2.** Explica en qué paso puede intervenir otra persona y qué aporta.

**Ejercicio 3.** Señala tres puntos donde `git status` aporta información útil.

**Reto.** Realiza el mismo flujo sin consultar la lección, pero detente antes de cada comando y explica qué estado esperas obtener.

## Qué debes recordar

La eficiencia con Git surge de una secuencia predecible: actualizar, aislar, revisar, confirmar, publicar, revisar en equipo, integrar y limpiar.

<div class="cla-lesson-nav">
  <a href="/git/leccion19/">← Lección 19 · Etiquetas, versiones y releases</a>
  <a href="/git/leccion21/">Lección 21 · Problemas frecuentes y diagnóstico →</a>
</div>
