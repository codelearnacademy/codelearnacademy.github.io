---
layout: lesson
route: spring
lesson_id: leccion68
lesson_file: 68-relaciones-entre-entidades
lesson_number: "68"
title: Relaciones entre entidades
description: Mapea una relación muchos a uno y comprueba la clave foránea en SQLite.
permalink: /spring/leccion68/
lessons:
  - id: práctica-con-sqlite3
    title: Práctica con SQLite3
  - id: comprueba-lo-aprendido
    title: Comprueba lo aprendido
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Relaciones entre entidades

Mapea una relación muchos a uno y comprueba la clave foránea en SQLite.

## Práctica con SQLite3

Usa el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}) para continuar la práctica de las lecciones 64–70.

Una categoría puede tener varias tareas. Cada tarea apunta a una categoría. En el ejemplo, `TareaEntity.categoria` es el lado propietario y escribe `tareas.categoria_id`.

```java
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "categoria_id", nullable = false)
private CategoriaEntity categoria;
```

La migración V1 impone `categoria_id INTEGER NOT NULL REFERENCES categorias(id)`. Si se necesita navegar desde una categoría a sus tareas, puede añadirse `@OneToMany(mappedBy = "categoria")` en la categoría. Ese lado inverso refleja la relación que ya guarda la clave foránea.

**Ejercicio breve.** Crea una tarea con una categoría válida y consulta el vínculo:

```sql
SELECT t.id, t.titulo, c.nombre
FROM tareas AS t
JOIN categorias AS c ON c.id = t.categoria_id;
```

Envía otro POST con `categoriaId` igual a un ID positivo inexistente. El servicio devuelve `404`. Después abre `sqlite3 tareas-practica.sqlite3` y ejecuta:

```sql
PRAGMA foreign_keys = ON;
INSERT INTO tareas(titulo, categoria_id) VALUES ('Invalida', -1);
PRAGMA foreign_key_check;
```

SQLite debe rechazar la inserción. La última consulta muestra las infracciones existentes, si las hay. La sesión de la consola tiene su propia configuración de claves foráneas.

## Comprueba lo aprendido

Repite el ejercicio cambiando un dato de entrada o usando un archivo nuevo para la migración. Registra el resultado esperado y lo observado en la API, en la consulta SQL o en la prueba.

<div class="cla-lesson-nav">
  <a href="/spring/leccion67/">← 67 · Repositories</a>
  <a href="/spring/leccion69/">69 · Transacciones →</a>
</div>
