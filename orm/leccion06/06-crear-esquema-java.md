---
layout: "lesson"
route: "orm"
lesson_id: "leccion06"
lesson_file: "06-crear-esquema-java"
lesson_number: "06"
title: "Crear el esquema desde Java"
description: "Crear el esquema desde Java"
permalink: "/orm/leccion06/"
---

# Crear el esquema desde Java

## Crear el esquema desde Java

```java
public final class DatabaseInitializer {

    private DatabaseInitializer() {}

    public static void createSchema(String url) {
        String sql = """
            CREATE TABLE IF NOT EXISTS producto (
                id INTEGER PRIMARY KEY,
                nombre TEXT NOT NULL,
                precio REAL NOT NULL
            )
            """;

        try (Connection c = DriverManager.getConnection(url);
             Statement st = c.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RepositoryException("Error creando esquema", e);
        }
    }
}
```

La tabla se crea una vez si no existe. Para las pruebas podremos crear una base SQLite temporal y reconstruir el esquema en cada test.

<div class="cla-lesson-nav">
  <a href="/orm/leccion05/">← 5 · JDBC con SQLite</a>
  <a href="/orm/leccion07/">7 · SELECT, ResultSet y mapeo manual →</a>
</div>
