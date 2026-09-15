---
layout: lesson
route: git
lesson_id: leccion07
lesson_number: "07"
title: "Ignorar archivos con .gitignore"
description: "Decide qué archivos no deben versionarse y crea reglas .gitignore adecuadas para tus proyectos."
permalink: /git/leccion07/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: qué-suele-ignorarse
    title: "Qué suele ignorarse"
  - id: crear-gitignore
    title: "Crear .gitignore"
  - id: secretos-y-credenciales
    title: "Secretos y credenciales"
  - id: archivos-ya-registrados
    title: "Archivos ya registrados"
  - id: ejemplo-para-un-proyecto-java
    title: "Ejemplo para un proyecto Java"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Ignorar archivos con .gitignore

No todo lo que existe dentro de una carpeta de proyecto debe guardarse en Git. `.gitignore` permite declarar archivos y carpetas que no queremos versionar.

## Qué vas a conseguir

- Comprender por qué algunos archivos no deben formar parte del repositorio.
- Crear un archivo `.gitignore`.
- Ignorar archivos, extensiones y directorios.
- Reconocer el riesgo de versionar secretos.
- Entender que `.gitignore` no deja de seguir automáticamente archivos ya registrados.

## Qué suele ignorarse

Ejemplos frecuentes:

```text
*.log
build/
dist/
.idea/
.vscode/
.env
```

Las reglas concretas dependen de la tecnología y del equipo.

## Crear .gitignore

Crea un archivo llamado `.gitignore`:

```gitignore
*.log
build/
.env
```

Después crea:

```text
app.log
build/resultado.txt
.env
```

Consulta:

```bash
git status
```

Esos archivos no deberían aparecer como nuevos elementos para registrar.

## Secretos y credenciales

No debes subir al repositorio:

- contraseñas;
- tokens de acceso;
- claves privadas;
- archivos con credenciales reales.

<div class="cla-note"><strong>Importante</strong><p>.gitignore ayuda a evitar errores, pero no es un sistema de seguridad. Si un secreto ya fue publicado, borrarlo del archivo actual no garantiza que haya desaparecido del historial.</p></div>

## Archivos ya registrados

Si Git ya está siguiendo un archivo, añadirlo después a `.gitignore` no elimina automáticamente su seguimiento.

Compruébalo en una práctica controlada. Primero haz commit de `temporal.log`, luego añade `*.log` a `.gitignore` y modifica `temporal.log`. Verás que Git continúa detectando sus cambios.

## Ejemplo para un proyecto Java

Un `.gitignore` introductorio podría contener:

```gitignore
*.class
target/
build/
.idea/
*.iml
```

Las reglas reales deben adaptarse al IDE y herramienta de construcción utilizados.

## Ejercicios propuestos

**Ejercicio 1.** Ignora todos los archivos `.log`.

**Ejercicio 2.** Ignora una carpeta llamada `temporal/`.

**Ejercicio 3.** Explica por qué `.env` suele excluirse.

**Reto.** Crea tres archivos, configura reglas para ignorar exactamente dos y demuestra el resultado con `git status`.

## Qué debes recordar

Versiona el código y la documentación necesarios para reconstruir el proyecto. Evita resultados generados, archivos personales del entorno y, especialmente, credenciales.

<div class="cla-lesson-nav">
  <a href="/git/leccion06/">← Lección 06 · Seguimiento y revisión de cambios</a>
  <a href="/git/leccion08/">Lección 08 · Corregir errores y recuperar cambios →</a>
</div>
