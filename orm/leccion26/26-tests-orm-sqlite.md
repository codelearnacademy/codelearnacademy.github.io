---
layout: "lesson"
route: "orm"
lesson_id: "leccion26"
lesson_file: "26-tests-orm-sqlite"
lesson_number: "26"
title: "Tests ORM con SQLite"
description: "Tests ORM con SQLite"
permalink: "/orm/leccion26/"
---

# Tests ORM con SQLite

## Test ORM con SQLite real

```java
@TempDir
Path tempDir;

@Test
void crudCompletoOrm() {
    Path db = tempDir.resolve("orm-test.db");

    EntityManagerFactory emf =
            TestEntityManagerFactory.create(db);

    try {
        IProductoRepository repo =
                new ProductoOrmRepository(emf);

        repo.create(new Producto(1, "Teclado", 30));
        assertEquals(1, repo.findAll().size());

        assertTrue(repo.update(
                new Producto(1, "Teclado mecánico", 50)));

        assertTrue(repo.delete(1L));
        assertTrue(repo.findAll().isEmpty());
    } finally {
        emf.close();
    }
}
```

No simulamos el ORM: el test utiliza una base SQLite real en un fichero temporal.

<div class="cla-lesson-nav">
  <a href="/orm/leccion25/">← 25 · VehiculoEntity e IVehiculoRepository</a>
  <a href="/orm/leccion27/">27 · Comparar ficheros, JDBC y ORM →</a>
</div>
