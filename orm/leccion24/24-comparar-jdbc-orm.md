---
layout: "lesson"
route: "orm"
lesson_id: "leccion24"
lesson_file: "24-comparar-jdbc-orm"
lesson_number: "24"
title: "Comparar el CRUD JDBC y ORM"
description: "Comparar el CRUD JDBC y ORM"
permalink: "/orm/leccion24/"
---

# Comparar el CRUD JDBC y ORM

## CRUD completo: JDBC frente a ORM

| Operación | JDBC | ORM |
|---|---|---|
| Crear | `INSERT` + parámetros | `persist()` |
| Buscar ID | `SELECT ... WHERE` | `find()` |
| Listar | `ResultSet` | JPQL |
| Actualizar | `UPDATE` | modificar entidad administrada |
| Eliminar | `DELETE` | `remove()` |
| Mapeo | manual | metadatos/anotaciones |

El ORM reduce código repetitivo, pero no elimina SQL, tablas, claves, índices ni transacciones. Precisamente por eso la ruta estudia primero JDBC.

<div class="cla-lesson-nav">
  <a href="/orm/leccion23/">← 23 · Errores y RepositoryException en ORM</a>
  <a href="/orm/leccion25/">25 · VehiculoEntity e IVehiculoRepository →</a>
</div>
