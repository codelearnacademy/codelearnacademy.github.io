---
layout: "lesson"
route: "orm"
lesson_id: "leccion25"
lesson_file: "25-vehiculo-orm"
lesson_number: "25"
title: "VehiculoEntity e IVehiculoRepository"
description: "VehiculoEntity e IVehiculoRepository"
permalink: "/orm/leccion25/"
---

# VehiculoEntity e IVehiculoRepository

## Generalizar con `Vehiculo`

El dominio existente continúa siendo:

```java
public record Vehiculo(
        String matricula,
        String marca,
        String modelo,
        int anio) {}
```

Creamos `VehiculoEntity` con:

```java
@Id
private String matricula;
```

y un `VehiculoMapper`.

Después:

```java
public final class VehiculoOrmRepository
        implements IVehiculoRepository {
```

No necesitamos modificar `IRepository<T, ID>`. La prueba de que la abstracción es general es que ahora el identificador es `String`, no `Long`.

<div class="cla-lesson-nav">
  <a href="/orm/leccion24/">← 24 · Comparar el CRUD JDBC y ORM</a>
  <a href="/orm/leccion26/">26 · Tests ORM con SQLite →</a>
</div>
