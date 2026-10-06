---
layout: "lesson"
route: "orm"
lesson_id: "leccion18"
lesson_file: "18-producto-mapper"
lesson_number: "18"
title: "ProductoMapper: dominio y persistencia"
description: "ProductoMapper: dominio y persistencia"
permalink: "/orm/leccion18/"
---

# ProductoMapper: dominio y persistencia

## Mapper entre dominio y persistencia

```java
public final class ProductoMapper {
    private ProductoMapper() {}

    public static ProductoEntity toEntity(Producto p) {
        return new ProductoEntity(p.id(), p.nombre(), p.precio());
    }

    public static Producto toDomain(ProductoEntity e) {
        return new Producto(e.getId(), e.getNombre(), e.getPrecio());
    }
}
```

Esto introduce una responsabilidad explícita:

```text
IProductoRepository trabaja con Producto
Hibernate trabaja con ProductoEntity
```

El resto de la aplicación no necesita conocer las entidades ORM.

<div class="cla-lesson-nav">
  <a href="/orm/leccion17/">← 17 · .properties y configuración ORM</a>
  <a href="/orm/leccion19/">19 · CREATE con EntityManager y persist() →</a>
</div>
