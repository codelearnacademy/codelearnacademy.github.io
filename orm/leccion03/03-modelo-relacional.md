---
layout: "lesson"
route: "orm"
lesson_id: "leccion03"
lesson_file: "03-modelo-relacional"
lesson_number: "03"
title: "Modelo relacional: Producto y Vehiculo"
description: "Modelo relacional: Producto y Vehiculo"
permalink: "/orm/leccion03/"
---

# Modelo relacional: Producto y Vehiculo

## Del `record` a la tabla

Seguimos utilizando el modelo de dominio:

```java
public record Producto(long id, String nombre, double precio) {}
```

Su representación relacional es:

| Java | SQLite | Restricción |
|---|---|---|
| `long id` | `INTEGER` | `PRIMARY KEY` |
| `String nombre` | `TEXT` | `NOT NULL` |
| `double precio` | `REAL` | `NOT NULL` |

```sql
CREATE TABLE producto (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    precio REAL NOT NULL
);
```

## Clave primaria

La clave primaria representa la identidad de la fila. Es la misma idea que ya utilizábamos con `Producto::id` en `IRepository<Producto, Long>`.

Para `Vehiculo`, la identidad seguirá siendo la matrícula:

```sql
CREATE TABLE vehiculo (
    matricula TEXT PRIMARY KEY,
    marca TEXT NOT NULL,
    modelo TEXT NOT NULL,
    anio INTEGER NOT NULL
);
```

<div class="cla-lesson-nav">
  <a href="/orm/leccion02/">← 2 · SQLite y la consola sqlite3</a>
  <a href="/orm/leccion04/">4 · SQL para el CRUD →</a>
</div>
