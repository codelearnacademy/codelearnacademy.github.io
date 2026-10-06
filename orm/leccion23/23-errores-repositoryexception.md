---
layout: "lesson"
route: "orm"
lesson_id: "leccion23"
lesson_file: "23-errores-repositoryexception"
lesson_number: "23"
title: "Errores y RepositoryException en ORM"
description: "Errores y RepositoryException en ORM"
permalink: "/orm/leccion23/"
---

# Errores y RepositoryException en ORM

## Errores de persistencia

Igual que CSV/JSON/XML y JDBC, la implementación controla sus errores de infraestructura.

```java
try {
    // operación ORM
} catch (RuntimeException e) {
    throw new RepositoryException(
            "Error actualizando producto", e);
}
```

Las interfaces siguen limpias:

```java
boolean update(Producto producto);
```

No declaramos `SQLException`, excepciones de Hibernate ni detalles de SQLite en `IProductoRepository`.

<div class="cla-note"><strong>Regla arquitectónica</strong><p>Las excepciones técnicas no deben obligar al código cliente a saber cómo se persisten los datos.</p></div>

<div class="cla-lesson-nav">
  <a href="/orm/leccion22/">← 22 · ProductoOrmRepository: CRUD completo</a>
  <a href="/orm/leccion24/">24 · Comparar el CRUD JDBC y ORM →</a>
</div>
