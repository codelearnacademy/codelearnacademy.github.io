---
layout: "lesson"
route: "orm"
lesson_id: "leccion27"
lesson_file: "27-comparar-persistencias"
lesson_number: "27"
title: "Comparar ficheros, JDBC y ORM"
description: "Comparar ficheros, JDBC y ORM"
permalink: "/orm/leccion27/"
---

# Comparar ficheros, JDBC y ORM

## Cinco implementaciones, un contrato

Al terminar las dos rutas podemos tener:

```text
IProductoRepository
 ├─ ProductoCsvRepository
 ├─ ProductoJsonRepository
 ├─ ProductoXmlRepository
 ├─ ProductoJdbcRepository
 └─ ProductoOrmRepository
```

Esto permite comparar responsabilidades:

```text
CSV/JSON/XML → serialización de una colección
JDBC         → SQL escrito manualmente
ORM          → mapeo y SQL gestionados por Hibernate
```

La interfaz no cambia. Esa es la conexión arquitectónica más importante entre ambas rutas.

<div class="cla-lesson-nav">
  <a href="/orm/leccion26/">← 26 · Tests ORM con SQLite</a>
  <a href="/orm/leccion28/">28 · Proyecto final PersistenceLab →</a>
</div>
