---
layout: lesson
route: git
lesson_id: leccion17
lesson_number: "17"
title: "Pull Requests y Merge Requests"
description: "Publica una rama, solicita revisión y completa una integración mediante GitHub o GitLab."
permalink: /git/leccion17/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: antes-de-abrir-la-solicitud
    title: "Antes de abrir la solicitud"
  - id: crear-la-propuesta
    title: "Crear la propuesta"
  - id: revisar-antes-de-integrar
    title: "Revisar antes de integrar"
  - id: comentarios-y-correcciones
    title: "Comentarios y correcciones"
  - id: después-del-merge
    title: "Después del merge"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Pull Requests y Merge Requests

GitHub denomina **Pull Request** y GitLab denomina **Merge Request** a una propuesta para integrar una rama después de revisarla.

## Qué vas a conseguir

- Publicar una rama para revisión.
- Crear una Pull Request o Merge Request.
- Comprender origen y destino de la propuesta.
- Participar en una revisión sencilla.
- Integrar cambios y actualizar el repositorio local.

## Antes de abrir la solicitud

Comprueba tu rama:

```bash
git status
git log --oneline
```

Publícala:

```bash
git push -u origin feature/recursos
```

## Crear la propuesta

En GitHub o GitLab selecciona:

```text
rama origen: feature/recursos
rama destino: main
```

Escribe un título claro y una descripción breve:

```text
Añadir recursos de aprendizaje

- incorpora recursos.md
- organiza enlaces por categoría
- actualiza el índice del README
```

## Revisar antes de integrar

Una revisión debería comprobar:

- qué archivos cambian;
- si el cambio corresponde con la tarea;
- si existen archivos accidentales;
- si los mensajes y documentación son claros;
- si el resultado se puede integrar.

## Comentarios y correcciones

Si la persona revisora solicita un cambio, no necesitas abrir otra solicitud. Corrige en la misma rama, crea un nuevo commit y haz `push`. La Pull/Merge Request se actualiza.

## Después del merge

Actualiza tu copia local:

```bash
git switch main
git pull
```

Después puedes eliminar la rama local si ya no se necesita:

```bash
git branch -d feature/recursos
```

## Ejemplo guiado

En parejas:

1. A publica una rama.
2. B revisa el diff en la plataforma.
3. B solicita una pequeña mejora.
4. A corrige, commit y push.
5. B aprueba.
6. Se realiza el merge.
7. Ambos actualizan `main`.

<!-- IMAGEN RECOMENDADA: /assets/images/git/leccion17/pull-request-flujo.svg
Rama local → push → PR/MR → revisión → merge → main. -->

## Ejercicios propuestos

**Ejercicio 1.** Abre una PR/MR con título y descripción útiles.

**Ejercicio 2.** Revisa la solicitud de otra persona y formula un comentario concreto y respetuoso.

**Ejercicio 3.** Añade un commit a una solicitud ya abierta y comprueba que aparece automáticamente.

**Reto.** Completa un ciclo de revisión en el que la primera versión no sea aprobada hasta corregir una observación.

## Qué debes recordar

Una Pull/Merge Request no es un comando de Git: es una herramienta de colaboración de la plataforma. Convierte la integración en un proceso visible, revisable y discutible.

<div class="cla-lesson-nav">
  <a href="/git/leccion16/">← Lección 16 · Trabajo colaborativo con ramas</a>
  <a href="/git/leccion18/">Lección 18 · Revisión de código y buenas prácticas →</a>
</div>
