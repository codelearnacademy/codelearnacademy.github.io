---
layout: lesson
route: git
lesson_id: leccion21
lesson_number: "21"
title: "Problemas frecuentes y diagnóstico"
description: "Aprende a leer los mensajes de Git y a diagnosticar situaciones habituales antes de ejecutar comandos al azar."
permalink: /git/leccion21/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: regla-número-uno
    title: "Regla número uno"
  - id: caso-nothing-to-commit
    title: "Caso · nothing to commit"
  - id: caso-push-rechazado
    title: "Caso · push rechazado"
  - id: caso-estoy-en-la-rama-equivocada
    title: "Caso · estoy en la rama equivocada"
  - id: caso-remoto-incorrecto
    title: "Caso · remoto incorrecto"
  - id: detached-head
    title: "Detached HEAD"
  - id: método-de-diagnóstico
    title: "Método de diagnóstico"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Problemas frecuentes y diagnóstico

Git suele explicar qué ocurre, pero al principio sus mensajes pueden resultar intimidantes. La mejor respuesta no es copiar un comando al azar, sino diagnosticar el estado.

## Qué vas a conseguir

- Utilizar `git status` como primer diagnóstico.
- Reconocer causas habituales de push rechazado.
- Detectar rama equivocada y cambios pendientes.
- Comprender de forma introductoria detached HEAD.
- Adoptar un procedimiento de diagnóstico antes de buscar soluciones.

## Regla número uno

Ante un problema:

```bash
git status
```

Después consulta, cuando sea útil:

```bash
git branch
git remote -v
git log --oneline --all --graph
```

## Caso · nothing to commit

Puede significar simplemente que no has realizado cambios desde el último commit.

Comprueba:

```bash
git status
```

No es necesariamente un error.

## Caso · push rechazado

Una causa frecuente es que el remoto contiene commits que tu rama local no tiene.

No fuerces automáticamente. Primero comprende la diferencia:

```bash
git fetch
git log --oneline --all --graph
```

Después aplica el procedimiento de sincronización definido por el equipo.

## Caso · estoy en la rama equivocada

Comprueba:

```bash
git branch
```

o:

```bash
git status
```

Antes de cambiar de rama, revisa si tienes modificaciones locales que debas conservar o confirmar.

## Caso · remoto incorrecto

```bash
git remote -v
```

Verifica que `origin` apunta realmente al proyecto esperado.

## Detached HEAD

En determinadas operaciones puedes quedar situado directamente sobre un commit en lugar de una rama. Para principiantes, lo importante es reconocer que no estás trabajando sobre una rama normal y evitar crear trabajo importante sin comprender dónde quedará.

Si aparece ese mensaje durante una práctica, detente y consulta al docente o revisa el historial antes de continuar.

## Método de diagnóstico

```text
1. Leer el mensaje completo.
2. Ejecutar git status.
3. Comprobar rama.
4. Comprobar historial si es necesario.
5. Comprobar remoto si el problema implica red.
6. Decidir qué estado quieres alcanzar.
7. Ejecutar el mínimo comando necesario.
```

<div class="cla-note"><strong>Evita recetas peligrosas</strong><p>No utilices comandos con force, reset destructivo o limpieza masiva únicamente porque aparecieron en una búsqueda. Comprende primero qué información pueden eliminar.</p></div>

## Ejercicios propuestos

**Ejercicio 1.** Describe cómo investigarías un `push` rechazado sin utilizar `--force`.

**Ejercicio 2.** Simula estar en una rama diferente de la esperada y detecta el problema.

**Ejercicio 3.** Comprueba el remoto de tres repositorios y confirma a qué proyecto pertenece cada uno.

**Reto.** El docente prepara un repositorio con dos problemas. Debes entregar primero un diagnóstico escrito y solo después ejecutar comandos correctivos.

## Qué debes recordar

Git recompensa el diagnóstico. Antes de arreglar un problema, determina el estado actual y el estado objetivo. La herramienta suele darte pistas suficientes para decidir el siguiente paso.

<div class="cla-lesson-nav">
  <a href="/git/leccion20/">← Lección 20 · Flujo de trabajo profesional con Git</a>
  <a href="/git/leccion22/">Lección 22 · Proyecto final colaborativo →</a>
</div>
