---
layout: "lesson"
route: "orm"
lesson_id: "leccion20"
lesson_file: "20-read-find-jpql"
lesson_number: "20"
title: "READ con find() y JPQL"
description: "READ con find() y JPQL"
permalink: "/orm/leccion20/"
---

# READ con find() y JPQL

## Buscar por clave

```java
ProductoEntity entity = em.find(ProductoEntity.class, id);
```

El ORM genera la consulta necesaria.

## Listar con JPQL

```java
List<Producto> productos = em.createQuery(
        "select p from ProductoEntity p order by p.id",
        ProductoEntity.class)
    .getResultStream()
    .map(ProductoMapper::toDomain)
    .toList();
```

JPQL consulta **entidades y atributos**, no nombres físicos de tablas y columnas. Hibernate lo traduce al SQL del dialecto SQLite.

<div class="cla-lesson-nav">
  <a href="/orm/leccion19/">← 19 · CREATE con EntityManager y persist()</a>
  <a href="/orm/leccion21/">21 · UPDATE y DELETE con entidades administradas →</a>
</div>
