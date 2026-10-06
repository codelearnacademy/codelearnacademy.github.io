---
layout: "lesson"
route: "orm"
lesson_id: "leccion22"
lesson_file: "22-producto-orm-repository"
lesson_number: "22"
title: "ProductoOrmRepository: CRUD completo"
description: "ProductoOrmRepository: CRUD completo"
permalink: "/orm/leccion22/"
---

# ProductoOrmRepository: CRUD completo

## Repositorio ORM completo

```java
public final class ProductoOrmRepository
        implements IProductoRepository {

    private final EntityManagerFactory emf;

    public ProductoOrmRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // findAll, findById, create, update, delete
}
```

El código cliente continúa viendo exactamente el contrato anterior:

```java
IProductoRepository productos = new ProductoOrmRepository(emf);

productos.create(new Producto(1, "Teclado", 30));
productos.findById(1L);
productos.update(new Producto(1, "Teclado", 35));
productos.delete(1L);
```

La aplicación no conoce `EntityManager`, `ProductoEntity` ni SQL.

<div class="cla-lesson-nav">
  <a href="/orm/leccion21/">← 21 · UPDATE y DELETE con entidades administradas</a>
  <a href="/orm/leccion23/">23 · Errores y RepositoryException en ORM →</a>
</div>
