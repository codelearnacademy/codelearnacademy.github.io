---
layout: "lesson"
route: "orm"
lesson_id: "leccion14"
lesson_file: "14-orm-jpa-hibernate"
lesson_number: "14"
title: "Qué es un ORM: JPA y Hibernate"
description: "Qué es un ORM: JPA y Hibernate"
permalink: "/orm/leccion14/"
---

# Qué es un ORM: JPA y Hibernate

## ORM

**Object-Relational Mapping** es la correspondencia entre clases/objetos y tablas/filas.

```text
ProductoEntity            tabla producto
──────────────             ──────────────
id                  ↔      id
nombre              ↔      nombre
precio              ↔      precio
```

## JPA y Hibernate no son lo mismo

- **Jakarta Persistence (JPA):** especificación/API estándar.
- **Hibernate ORM:** implementación de esa API y motor ORM.

En la ruta programaremos principalmente contra tipos de JPA (`EntityManager`, `@Entity`, `@Id`) y utilizaremos Hibernate como proveedor.

<div class="cla-lesson-nav">
  <a href="/orm/leccion13/">← 13 · El problema del mapeo objeto-relacional</a>
  <a href="/orm/leccion15/">15 · Hibernate y SQLite con Maven →</a>
</div>
