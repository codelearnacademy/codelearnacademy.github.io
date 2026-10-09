---
layout: lesson
route: git
lesson_id: leccion18
lesson_number: "18"
title: "Revisión de código y buenas prácticas"
description: "Revisa cambios con criterio, mejora la calidad de los commits y evita errores habituales en equipos."
permalink: /git/leccion18/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: qué-revisar
    title: "Qué revisar"
  - id: buen-tamaño-de-cambio
    title: "Buen tamaño de cambio"
  - id: nombres-de-ramas
    title: "Nombres de ramas"
  - id: mensajes-de-commit
    title: "Mensajes de commit"
  - id: ejemplo-guiado-de-revisión
    title: "Ejemplo guiado de revisión"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
  - id: markdown-de-esta-leccion
    title: "Markdown de esta lección"
  - id: laboratorio-dam-git-lab
    title: "Trabajo sobre dam-git-lab"
---

# Revisión de código y buenas prácticas

Trabajar con Git de forma eficiente no consiste en ejecutar muchos comandos. Consiste en producir cambios fáciles de entender, revisar y recuperar.

<figure class="cla-diagram cla-diagram--small">
  <img src="/git/images/18-code-review.png" alt="Una revisión de código parte del diff y produce comentarios y sugerencias concretas." loading="lazy">
</figure>

<figure class="cla-diagram cla-diagram--small">
  <img src="/git/images/18-feedback.png" alt="Ciclo de revisión: review, modificar, commit y push hasta obtener aprobación." loading="lazy">
</figure>

## Qué vas a conseguir

- Revisar una rama antes de integrarla.
- Detectar commits demasiado grandes o poco claros.
- Mejorar nombres de ramas y mensajes.
- Evitar archivos no relacionados y secretos.
- Aplicar una checklist previa a la integración.

## Qué revisar

Antes de aprobar una PR/MR pregunta:

```text
¿La tarea está bien definida?
¿El diff contiene solo cambios relacionados?
¿Hay archivos generados o credenciales?
¿Los nombres son claros?
¿La documentación necesaria está actualizada?
¿El historial es comprensible?
```

## Buen tamaño de cambio

Una modificación pequeña es más fácil de:

- comprender;
- probar;
- revisar;
- revertir.

Evita solicitudes que mezclen refactorización, documentación, nuevas funciones y archivos temporales sin relación.

## Nombres de ramas

Ejemplos claros:

```text
feature/registro
fix/enlace-roto
docs/instalacion
```

El objetivo no es seguir una convención universal, sino adoptar una convención coherente dentro del equipo.

## Mensajes de commit

Mejor:

```text
Corregir cálculo de descuento
```

que:

```text
fix
```

## Ejemplo guiado de revisión

Supón que una rama contiene:

```text
README.md modificado
docs/instalacion.md nuevo
passwords.txt nuevo
app.log nuevo
```

Antes de integrar deberías detectar que `passwords.txt` y probablemente `app.log` no pertenecen al repositorio.

## Ejercicios propuestos

**Ejercicio 1.** Revisa una PR/MR de práctica y enumera tres aspectos positivos y una posible mejora.

**Ejercicio 2.** Divide conceptualmente un commit que contiene cinco cambios no relacionados.

**Ejercicio 3.** Diseña una checklist de revisión para tu clase.

**Reto.** Prepara deliberadamente una rama con dos errores de higiene del repositorio y pide a otra persona que los detecte únicamente mediante el diff.

## Markdown de esta lección

En comentarios y revisiones puedes citar código en línea con backticks o utilizar bloques de código:

````markdown
```java
System.out.println("Hola");
```
````

## Evidencia de revisión

La PR de `dam-git-lab` debe contener al menos un comentario útil de revisión y, cuando proceda, un commit posterior que responda a ese comentario.

## Qué debes recordar

La revisión protege `main` y también enseña al equipo. Un buen historial y un diff limpio reducen el coste de comprender el proyecto meses después.

<div class="cla-lesson-nav">
  <a href="/git/leccion17/">← Lección 17 · Pull Requests y Merge Requests</a>
  <a href="/git/leccion19/">Lección 19 · Etiquetas, versiones y releases →</a>
</div>
