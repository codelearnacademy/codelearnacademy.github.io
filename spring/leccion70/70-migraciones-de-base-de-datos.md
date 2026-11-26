---
layout: lesson
route: spring
lesson_id: leccion70
lesson_file: 70-migraciones-de-base-de-datos
lesson_number: "70"
title: Migraciones de base de datos
description: Migra un archivo SQLite con datos existentes y comprueba el estado resultante.
permalink: /spring/leccion70/
lessons:
  - id: práctica-con-sqlite3
    title: Práctica con SQLite3
  - id: comprueba-lo-aprendido
    title: Comprueba lo aprendido
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Migraciones de base de datos

Migra un archivo SQLite con datos existentes y comprueba el estado resultante.

## Práctica con SQLite3

Usa el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}) para continuar la práctica de las lecciones 64–70.

Flyway aplica scripts versionados. V1 crea las tablas y deja una tarea de ejemplo. V2 añade un estado obligatorio con un valor inicial y restringe los valores permitidos.

```sql
ALTER TABLE tareas ADD COLUMN estado TEXT NOT NULL DEFAULT 'PENDIENTE'
    CHECK (estado IN ('PENDIENTE', 'COMPLETADA'));
```

**Ejercicio breve.** Sigue «Observar el paso de V1 a V2» en el README del ejemplo. Arranca primero con la versión objetivo 1 sobre un archivo nuevo y anota el ID y título de la fila. Aplica V2 al mismo archivo y ejecuta:

```sh
sqlite3 -readonly tareas-migracion.sqlite3 'SELECT id, titulo, estado FROM tareas;'
sqlite3 -readonly tareas-migracion.sqlite3 'SELECT version, success FROM flyway_schema_history ORDER BY installed_rank;'
```

Comprueba que el ID y el título se conservan, que el estado es `PENDIENTE` y que el historial registra las dos versiones. Explica qué decisión toma Flyway y qué comprueba Hibernate con `ddl-auto=validate`.

## Comprueba lo aprendido

Repite el ejercicio cambiando un dato de entrada o usando un archivo nuevo para la migración. Registra el resultado esperado y lo observado en la API, en la consulta SQL o en la prueba.

<div class="cla-lesson-nav">
  <a href="/spring/leccion69/">← 69 · Transacciones</a>
  <a href="/spring/leccion71/">71 · Configuración externa →</a>
</div>
