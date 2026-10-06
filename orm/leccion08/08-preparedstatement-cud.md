---
layout: "lesson"
route: "orm"
lesson_id: "leccion08"
lesson_file: "08-preparedstatement-cud"
lesson_number: "08"
title: "INSERT, UPDATE y DELETE con PreparedStatement"
description: "INSERT, UPDATE y DELETE con PreparedStatement"
permalink: "/orm/leccion08/"
---

# INSERT, UPDATE y DELETE con PreparedStatement

## `PreparedStatement`

Crear:

```java
String sql = "INSERT INTO producto(id, nombre, precio) VALUES (?, ?, ?)";

try (PreparedStatement ps = connection.prepareStatement(sql)) {
    ps.setLong(1, producto.id());
    ps.setString(2, producto.nombre());
    ps.setDouble(3, producto.precio());
    ps.executeUpdate();
}
```

Actualizar:

```java
String sql = "UPDATE producto SET nombre = ?, precio = ? WHERE id = ?";
```

Borrar:

```java
String sql = "DELETE FROM producto WHERE id = ?";
```

`executeUpdate()` devuelve cuántas filas se han modificado. Esto encaja directamente con nuestros métodos `boolean update(...)` y `boolean delete(...)`.

<div class="cla-lesson-nav">
  <a href="/orm/leccion07/">← 7 · SELECT, ResultSet y mapeo manual</a>
  <a href="/orm/leccion09/">9 · ProductoJdbcCrudDemo: CRUD completo →</a>
</div>
