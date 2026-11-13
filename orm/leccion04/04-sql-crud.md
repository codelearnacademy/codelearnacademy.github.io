---
layout: "lesson"
route: "orm"
lesson_id: "leccion04"
lesson_file: "04-sql-crud"
lesson_number: "04"
title: "SQL para el CRUD"
description: "SQL para el CRUD"
permalink: "/orm/leccion04/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: sql-mínimo-para-nuestro-crud
  title: SQL mínimo para nuestro CRUD
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
- id: actividad-integradora-de-ficheros-a-sqlite
  title: Actividad integradora · De ficheros a SQLite
---

# SQL para el CRUD

## Objetivo de aprendizaje

Distingue las cuatro operaciones CRUD y comprueba qué filas selecciona WHERE.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/04-sql-crud.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 04">
    <img src="{{ '/assets/images/orm/infografias/04-sql-crud.webp' | relative_url }}" alt="Resumen visual de la lección 04. SQL para el CRUD" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 04.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/04-sql-crud.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## SQL mínimo para nuestro CRUD

Vamos a implementar exactamente las cinco operaciones de `IRepository`.

### `findAll`

```sql
SELECT id, nombre, precio
FROM producto
ORDER BY id;
```

### `findById`

```sql
SELECT id, nombre, precio
FROM producto
WHERE id = ?;
```

### `create`

```sql
INSERT INTO producto(id, nombre, precio)
VALUES (?, ?, ?);
```

### `update`

```sql
UPDATE producto
SET nombre = ?, precio = ?
WHERE id = ?;
```

### `delete`

```sql
DELETE FROM producto
WHERE id = ?;
```

Los `?` serán parámetros de `PreparedStatement`; no concatenaremos valores recibidos desde Java.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/04-crud-sql.png' | relative_url }}" alt="CRUD con SQL" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Cuatro operaciones sobre la tabla producto. Comprueba qué filas identifica WHERE antes de actualizar o borrar.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/04-repository-sql.png' | relative_url }}" alt="Del repositorio a SQL" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El contrato expresa operaciones que la implementación traduce a SQL. El cliente puede trabajar con el contrato sin conocer la sentencia SQL.</p>


## Ejemplo guiado

### Construir el CRUD SQL de Producto

1. Inserta un producto con `INSERT`.
2. Recupéralo con `SELECT ... WHERE id = ...`.
3. Actualiza su precio con `UPDATE`.
4. Elimínalo con `DELETE`.
5. Comprueba después de cada paso el estado de la tabla.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué sentencia implementa create?

- A) UPDATE
- B) SELECT
- C) INSERT
- D) DELETE

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> INSERT crea una fila.</p>

</details>

### 2. ¿Qué cláusula suele limitar update/delete a una entidad?

- A) HAVING
- B) GROUP BY
- C) ORDER BY
- D) WHERE

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> WHERE identifica las filas afectadas.</p>

</details>

### 3. ¿Qué riesgo tiene un DELETE sin WHERE?

- A) Puede eliminar todas las filas
- B) Solo borra la primera
- C) No compila
- D) Convierte la tabla en JSON

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Sin filtro el DELETE puede afectar a todas las filas.</p>

</details>

### 4. ¿Qué operación de IRepository suele corresponder a SELECT por PK?

- A) update
- B) delete
- C) findById
- D) create

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> findById recupera una entidad por identificador.</p>

</details>


## Ejercicio propuesto

Escribe las cuatro sentencias CRUD equivalentes para `Vehiculo` usando `matricula` como identificador.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


## Actividad integradora · De ficheros a SQLite

**Modalidad:** tarea integradora de bloque.

Toma un conjunto de productos almacenado en CSV, diseña el esquema SQLite equivalente, importa al menos cinco registros y demuestra INSERT, SELECT, UPDATE y DELETE desde `sqlite3`.

### Evidencias

- Proyecto reproducible.
- README con instrucciones de ejecución.
- Pruebas realizadas.
- Explicación de problemas encontrados y cómo se resolvieron.


<div class="cla-lesson-nav">
  <a href="/orm/leccion03/">← 3 · Modelo relacional: Producto y Vehiculo</a>
  <a href="/orm/leccion05/">5 · JDBC con SQLite →</a>
</div>
