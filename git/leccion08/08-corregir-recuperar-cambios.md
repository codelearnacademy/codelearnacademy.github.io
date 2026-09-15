---
layout: lesson
route: git
lesson_id: leccion08
lesson_number: "08"
title: "Corregir errores y recuperar cambios"
description: "Aprende a deshacer cambios de forma segura y a distinguir restore, restore --staged y revert."
permalink: /git/leccion08/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: caso-1-cambio-local-que-no-quieres-conservar
    title: "Caso 1 · Cambio local que no quieres conservar"
  - id: caso-2-añadiste-por-error-a-staging
    title: "Caso 2 · Añadiste por error a staging"
  - id: caso-3-el-cambio-ya-está-en-un-commit
    title: "Caso 3 · El cambio ya está en un commit"
  - id: elegir-según-el-estado
    title: "Elegir según el estado"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Corregir errores y recuperar cambios

Git permite recuperar estados anteriores, pero es importante distinguir entre deshacer cambios locales, sacar algo de staging y crear una corrección histórica.

## Qué vas a conseguir

- Descartar un cambio local con `git restore`.
- Quitar un archivo del staging con `git restore --staged`.
- Comprender `git revert` como forma segura de revertir un commit publicado.
- Evitar comandos destructivos mientras estás aprendiendo.
- Elegir la herramienta según el estado del cambio.

## Caso 1 · Cambio local que no quieres conservar

Modifica `README.md` y comprueba:

```bash
git diff
```

Si quieres recuperar la última versión registrada:

```bash
git restore README.md
```

<div class="cla-note"><strong>Precaución</strong><p>git restore puede descartar trabajo no confirmado. Revisa siempre git diff antes de utilizarlo.</p></div>

## Caso 2 · Añadiste por error a staging

```bash
git add README.md
```

Si quieres sacarlo del staging sin perder la modificación:

```bash
git restore --staged README.md
```

El archivo vuelve a aparecer como modificado pero no preparado.

## Caso 3 · El cambio ya está en un commit

Cuando un commit ya forma parte de un historial compartido, una opción segura es crear otro commit que invierta sus cambios:

```bash
git revert <id-del-commit>
```

Git conserva tanto el commit original como el commit de reversión.

## Elegir según el estado

```text
Cambio sin commit
    ├─ quiero descartarlo → git restore
    └─ está en staging por error → git restore --staged

Commit ya compartido
    └─ quiero invertirlo → git revert
```

## Ejemplo guiado

1. Modifica un archivo.
2. Revisa con `git diff`.
3. Haz `git add`.
4. Sácalo con `git restore --staged`.
5. Comprueba que el contenido sigue modificado.
6. Finalmente, si quieres descartarlo, usa `git restore`.

## Ejercicios propuestos

**Ejercicio 1.** Prepara un archivo por error y retíralo de staging sin perder los cambios.

**Ejercicio 2.** Haz una modificación local y descártala después de revisarla.

**Ejercicio 3.** Explica por qué `git revert` resulta adecuado para historial compartido.

**Reto.** Dibuja un árbol de decisión que indique qué comando usar según dónde se encuentre el cambio.

## Qué debes recordar

Antes de deshacer, identifica el estado exacto del cambio. En Git, actuar con seguridad consiste en comprender primero qué quieres conservar y qué quieres eliminar.

<div class="cla-lesson-nav">
  <a href="/git/leccion07/">← Lección 07 · Ignorar archivos con .gitignore</a>
  <a href="/git/leccion09/">Lección 09 · Ramas: trabajar en paralelo →</a>
</div>
