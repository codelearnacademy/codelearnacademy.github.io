---
layout: "lesson"
route: "orm"
lesson_id: "leccion10"
lesson_file: "10-refactorizar-producto-jdbc-repository"
lesson_number: "10"
title: "Refactorizar a ProductoJdbcRepository"
description: "Refactorizar a ProductoJdbcRepository"
permalink: "/orm/leccion10/"
---

# Refactorizar a ProductoJdbcRepository

## Refactorizar hacia el contrato conocido

No necesitamos inventar otra API:

```java
public final class ProductoJdbcRepository
        implements IProductoRepository {

    private final String url;

    public ProductoJdbcRepository(String url) {
        this.url = url;
    }
}
```

El repositorio implementa exactamente:

```java
List<Producto> findAll();
Optional<Producto> findById(Long id);
void create(Producto producto);
boolean update(Producto producto);
boolean delete(Long id);
```

A diferencia de `AbstractFileRepository`, JDBC no necesita cargar toda la colección en memoria: cada operación se traduce a una sentencia SQL específica.

<div class="cla-lesson-nav">
  <a href="/orm/leccion09/">← 9 · ProductoJdbcCrudDemo: CRUD completo</a>
  <a href="/orm/leccion11/">11 · Transacciones con JDBC →</a>
</div>
