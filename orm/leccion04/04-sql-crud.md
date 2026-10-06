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

<div class="cla-lesson-nav">
  <a href="/orm/leccion03/">← 3 · Modelo relacional: Producto y Vehiculo</a>
  <a href="/orm/leccion05/">5 · JDBC con SQLite →</a>
</div>
