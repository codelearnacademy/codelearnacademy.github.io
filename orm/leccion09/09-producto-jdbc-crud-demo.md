---
layout: "lesson"
route: "orm"
lesson_id: "leccion09"
lesson_file: "09-producto-jdbc-crud-demo"
lesson_number: "09"
title: "ProductoJdbcCrudDemo: CRUD completo"
description: "ProductoJdbcCrudDemo: CRUD completo"
permalink: "/orm/leccion09/"
---

# ProductoJdbcCrudDemo: CRUD completo

## Antes de abstraer: CRUD monolítico

Construimos `ProductoJdbcCrudDemo`, equivalente a `CsvCrudDemo`, `JsonCrudDemo` y `XmlCrudDemo`.

```text
ProductoJdbcCrudDemo
 ├─ URL JDBC
 ├─ Connection
 ├─ SQL
 ├─ PreparedStatement
 ├─ ResultSet → Producto
 ├─ findAll / findById
 ├─ create / update / delete
 └─ tratamiento de SQLException
```

Ejemplo de `findById`:

```java
public Optional<Producto> findById(long id) {
    String sql = "SELECT id, nombre, precio FROM producto WHERE id = ?";
    try (Connection c = DriverManager.getConnection(url);
         PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setLong(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            return rs.next()
                    ? Optional.of(toProducto(rs))
                    : Optional.empty();
        }
    } catch (SQLException e) {
        throw new RepositoryException("Error buscando producto", e);
    }
}
```

Primero debe funcionar. Después refactorizamos.

<div class="cla-lesson-nav">
  <a href="/orm/leccion08/">← 8 · INSERT, UPDATE y DELETE con PreparedStatement</a>
  <a href="/orm/leccion10/">10 · Refactorizar a ProductoJdbcRepository →</a>
</div>
