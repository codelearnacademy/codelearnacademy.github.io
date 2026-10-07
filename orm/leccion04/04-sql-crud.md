---
layout: "lesson"
route: "orm"
lesson_id: "leccion04"
lesson_file: "04-sql-crud"
lesson_number: "04"
title: "SQL para el CRUD"
description: "SQL para el CRUD"
permalink: "/orm/leccion04/"
---

# SQL para el CRUD

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/04-crud-sql.png" alt="CRUD y sentencias SQL. CREATE → INSERT → READ → SELECT → UPDATE → UPDATE → DELETE → DELETE." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> CREATE → INSERT → READ → SELECT → UPDATE → UPDATE → DELETE → DELETE.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/04-repository-sql.png" alt="Repositorio y SQL. IRepository → Operación CRUD → Sentencia SQL." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> IRepository → Operación CRUD → Sentencia SQL.</p>


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

- A) SELECT
- B) INSERT
- C) UPDATE
- D) DELETE

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> INSERT crea una fila.</p>

</details>

### 2. ¿Qué cláusula suele limitar update/delete a una entidad?

- A) ORDER BY
- B) WHERE
- C) GROUP BY
- D) HAVING

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> WHERE identifica las filas afectadas.</p>

</details>

### 3. ¿Qué riesgo tiene un DELETE sin WHERE?

- A) No compila
- B) Puede eliminar todas las filas
- C) Solo borra la primera
- D) Convierte la tabla en JSON

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Sin filtro el DELETE puede afectar a todas las filas.</p>

</details>

### 4. ¿Qué operación de IRepository suele corresponder a SELECT por PK?

- A) create
- B) findById
- C) update
- D) delete

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> findById recupera una entidad por identificador.</p>

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
