---
layout: "lesson"
route: "orm"
lesson_id: "leccion05"
lesson_file: "05-jdbc-sqlite"
lesson_number: "05"
title: "JDBC con SQLite"
description: "JDBC con SQLite"
permalink: "/orm/leccion05/"
---

# JDBC con SQLite

## Driver JDBC para SQLite

Añadimos al `pom.xml`:

```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.53.4.0</version>
</dependency>
```

## Conexión

```java
String url = "jdbc:sqlite:data/app.db";

try (Connection connection = DriverManager.getConnection(url)) {
    System.out.println("Conectado a SQLite");
} catch (SQLException e) {
    throw new RepositoryException("Error conectando con SQLite", e);
}
```

Como en la ruta de ficheros, el código de infraestructura controla su propia excepción (`SQLException`). El contrato `IRepository` no la expone.

<div class="cla-lesson-nav">
  <a href="/orm/leccion04/">← 4 · SQL para el CRUD</a>
  <a href="/orm/leccion06/">6 · Crear el esquema desde Java →</a>
</div>
