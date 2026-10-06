---
layout: "lesson"
route: "orm"
lesson_id: "leccion11"
lesson_file: "11-transacciones-jdbc"
lesson_number: "11"
title: "Transacciones con JDBC"
description: "Transacciones con JDBC"
permalink: "/orm/leccion11/"
---

# Transacciones con JDBC

## Por qué necesitamos transacciones

Una transacción agrupa operaciones que deben confirmarse o deshacerse juntas.

```java
try (Connection c = DriverManager.getConnection(url)) {
    c.setAutoCommit(false);
    try {
        // varias operaciones
        c.commit();
    } catch (SQLException e) {
        c.rollback();
        throw e;
    }
}
```

Conceptos:

```text
BEGIN → operaciones → COMMIT
                   ↘ ROLLBACK si falla
```

Esta idea reaparecerá en JPA/Hibernate: el ORM no elimina las transacciones; las hace más cómodas de gestionar.

<div class="cla-lesson-nav">
  <a href="/orm/leccion10/">← 10 · Refactorizar a ProductoJdbcRepository</a>
  <a href="/orm/leccion12/">12 · Testear JDBC con SQLite temporal →</a>
</div>
