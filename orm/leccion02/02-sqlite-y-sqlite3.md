---
layout: "lesson"
route: "orm"
lesson_id: "leccion02"
lesson_file: "02-sqlite-y-sqlite3"
lesson_number: "02"
title: "SQLite y la consola sqlite3"
description: "SQLite y la consola sqlite3"
permalink: "/orm/leccion02/"
---

# SQLite y la consola sqlite3

## SQLite

SQLite es una base de datos relacional embebida. No necesitamos levantar un servidor: toda la base puede vivir en un fichero como `data/app.db`.

```text
ficheros/data/productos.csv
            ↓
orm/data/app.db
```

## Probarla con `sqlite3`

```bash
sqlite3 data/app.db
```

Dentro de la consola:

```sql
.tables
.schema
.quit
```

Crear nuestra primera tabla:

```sql
CREATE TABLE producto (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    precio REAL NOT NULL CHECK (precio >= 0)
);
```

Insertar y consultar:

```sql
INSERT INTO producto(id, nombre, precio)
VALUES (1, 'Teclado', 35.50);

SELECT * FROM producto;
```

El fichero `app.db` sustituye al conjunto de ficheros de datos, pero conserva persistencia entre ejecuciones.

<div class="cla-lesson-nav">
  <a href="/orm/leccion01/">← 1 · De ficheros a bases de datos</a>
  <a href="/orm/leccion03/">3 · Modelo relacional: Producto y Vehiculo →</a>
</div>
