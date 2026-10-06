---
layout: "lesson"
route: "orm"
lesson_id: "leccion16"
lesson_file: "16-record-vs-entidad-jpa"
lesson_number: "16"
title: "Dominio record frente a entidad JPA"
description: "Dominio record frente a entidad JPA"
permalink: "/orm/leccion16/"
---

# Dominio record frente a entidad JPA

## ¿Por qué no convertir directamente `Producto` en entidad?

En la ruta anterior tenemos:

```java
public record Producto(long id, String nombre, double precio) {}
```

Los `record` son excelentes para nuestro modelo de dominio: compactos e inmutables. Una entidad JPA, en cambio, tiene ciclo de vida administrado, constructor sin argumentos y normalmente estado mutable.

Mantendremos el dominio limpio y añadiremos una clase de persistencia:

```java
@Entity
@Table(name = "producto")
public class ProductoEntity {
    @Id
    private Long id;
    private String nombre;
    private double precio;

    protected ProductoEntity() {}

    public ProductoEntity(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    // getters y setters
}
```

```text
Producto (record de dominio)
          ↕ mapper
ProductoEntity (persistencia ORM)
          ↕ Hibernate
       producto (tabla)
```

<div class="cla-lesson-nav">
  <a href="/orm/leccion15/">← 15 · Hibernate y SQLite con Maven</a>
  <a href="/orm/leccion17/">17 · .properties y configuración ORM →</a>
</div>
