---
layout: "lesson"
route: "orm"
lesson_id: "leccion07"
lesson_file: "07-select-resultset"
lesson_number: "07"
title: "SELECT, ResultSet y mapeo manual"
description: "SELECT, ResultSet y mapeo manual"
permalink: "/orm/leccion07/"
---

# SELECT, ResultSet y mapeo manual

## `SELECT` y `ResultSet`

```java
String sql = "SELECT id, nombre, precio FROM producto ORDER BY id";
List<Producto> productos = new ArrayList<>();

try (Connection c = DriverManager.getConnection(url);
     PreparedStatement ps = c.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

    while (rs.next()) {
        productos.add(new Producto(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getDouble("precio")));
    }
}
```

Aquí aparece por primera vez el **mapeo objeto-relacional manual**:

```text
ResultSet → columnas → constructor → Producto
```

Guarda esta repetición: será uno de los problemas que justificará el ORM.

<div class="cla-lesson-nav">
  <a href="/orm/leccion06/">← 6 · Crear el esquema desde Java</a>
  <a href="/orm/leccion08/">8 · INSERT, UPDATE y DELETE con PreparedStatement →</a>
</div>
