---
layout: "lesson"
route: "orm"
lesson_id: "leccion01"
lesson_file: "01-de-ficheros-a-bases-de-datos"
lesson_number: "01"
title: "De ficheros a bases de datos"
description: "De ficheros a bases de datos"
permalink: "/orm/leccion01/"
---

# De ficheros a bases de datos

## Punto de partida

En la ruta de ficheros persistíamos una colección completa:

```text
Producto ↔ CSV / JSON / XML
```

Ahora queremos almacenar los mismos objetos en una base de datos relacional:

```text
Producto ↔ fila de la tabla producto ↔ SQLite
```

No cambiaremos todavía `IProductoRepository`. Primero estudiaremos qué aporta una base de datos frente a reescribir un fichero completo.

## Diferencia esencial

En un fichero solemos leer o reescribir una colección. En una base de datos podemos pedir operaciones sobre filas concretas:

```sql
SELECT * FROM producto WHERE id = 2;
UPDATE producto SET precio = 29.95 WHERE id = 2;
DELETE FROM producto WHERE id = 2;
```

<div class="cla-note"><strong>Continuidad</strong><p>El dominio sigue siendo el mismo. Cambia la infraestructura de persistencia.</p></div>

<div class="cla-lesson-nav">
  <a href="/orm/">← Índice de la ruta</a>
  <a href="/orm/leccion02/">2 · SQLite y la consola sqlite3 →</a>
</div>
