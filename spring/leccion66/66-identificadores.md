---
layout: lesson
route: spring
lesson_id: leccion66
lesson_file: 66-identificadores
lesson_number: "66"
title: Identificadores
description: Relaciona el identificador JPA, la clave primaria SQLite y la URL del recurso.
permalink: /spring/leccion66/
lessons:
  - id: práctica-con-sqlite3
    title: Práctica con SQLite3
  - id: comprueba-lo-aprendido
    title: Comprueba lo aprendido
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Identificadores

Relaciona el identificador JPA, la clave primaria SQLite y la URL del recurso.

## Práctica con SQLite3

Usa el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}) para continuar la práctica de las lecciones 64–70.

En la entidad, `@Id` identifica la clave y `@GeneratedValue(strategy = GenerationType.IDENTITY)` delega su generación a la base. La migración V1 declara `id INTEGER PRIMARY KEY AUTOINCREMENT`. En SQLite, `INTEGER PRIMARY KEY` se vincula al identificador de fila. `AUTOINCREMENT` evita reutilizar identificadores generados de filas borradas, aunque la secuencia puede contener huecos.

**Ejercicio breve.** Crea dos tareas con el mismo título y el ID de «Estudio». Ajusta `categoriaId` a tu resultado de la lección 64.

```sh
curl -i -H 'Content-Type: application/json' --data '{"titulo":"Repasar JPA","categoriaId":1}' http://localhost:8080/api/tareas
sqlite3 -readonly tareas-practica.sqlite3 'SELECT id, titulo FROM tareas ORDER BY id;'
```

Repite el POST y compara ambas cabeceras `Location`. Sigue cada URL con GET y comprueba que las filas tienen IDs distintos aunque compartan título.

## Comprueba lo aprendido

Repite el ejercicio cambiando un dato de entrada o usando un archivo nuevo para la migración. Registra el resultado esperado y lo observado en la API, en la consulta SQL o en la prueba.

<div class="cla-lesson-nav">
  <a href="/spring/leccion65/">← 65 · Entidades JPA</a>
  <a href="/spring/leccion67/">67 · Repositories →</a>
</div>
