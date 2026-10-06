---
layout: "lesson"
route: "orm"
lesson_id: "leccion21"
lesson_file: "21-update-delete-orm"
lesson_number: "21"
title: "UPDATE y DELETE con entidades administradas"
description: "UPDATE y DELETE con entidades administradas"
permalink: "/orm/leccion21/"
---

# UPDATE y DELETE con entidades administradas

## Actualizar una entidad administrada

```java
ProductoEntity entity = em.find(ProductoEntity.class, producto.id());

if (entity == null) {
    return false;
}

entity.setNombre(producto.nombre());
entity.setPrecio(producto.precio());
```

No necesitamos escribir `UPDATE`: Hibernate detecta cambios en una entidad administrada y sincroniza al confirmar la transacción.

## Borrar

```java
ProductoEntity entity = em.find(ProductoEntity.class, id);
if (entity == null) return false;
em.remove(entity);
```

La transacción sigue siendo obligatoria para modificar estado persistente.

<div class="cla-lesson-nav">
  <a href="/orm/leccion20/">← 20 · READ con find() y JPQL</a>
  <a href="/orm/leccion22/">22 · ProductoOrmRepository: CRUD completo →</a>
</div>
