---
layout: "lesson"
route: "orm"
lesson_id: "leccion12"
lesson_file: "12-tests-jdbc-sqlite"
lesson_number: "12"
title: "Testear JDBC con SQLite temporal"
description: "Testear JDBC con SQLite temporal"
permalink: "/orm/leccion12/"
---

# Testear JDBC con SQLite temporal

## Test con una base temporal

Con JUnit podemos usar `@TempDir`:

```java
@TempDir
Path tempDir;

@Test
void crudCompletoJdbc() {
    Path db = tempDir.resolve("test.db");
    String url = "jdbc:sqlite:" + db;

    DatabaseInitializer.createSchema(url);
    IProductoRepository repo = new ProductoJdbcRepository(url);

    repo.create(new Producto(1, "Teclado", 30));
    assertTrue(repo.findById(1L).isPresent());

    assertTrue(repo.update(new Producto(1, "Teclado", 35)));
    assertEquals(35, repo.findById(1L).orElseThrow().precio());

    assertTrue(repo.delete(1L));
    assertTrue(repo.findAll().isEmpty());
}
```

Cada test trabaja contra una base SQLite real y aislada.

<div class="cla-lesson-nav">
  <a href="/orm/leccion11/">← 11 · Transacciones con JDBC</a>
  <a href="/orm/leccion13/">13 · El problema del mapeo objeto-relacional →</a>
</div>
