---
layout: "lesson"
route: "orm"
lesson_id: "leccion28"
lesson_file: "28-proyecto-final-persistencelab"
lesson_number: "28"
title: "Proyecto final PersistenceLab"
description: "Proyecto final PersistenceLab"
permalink: "/orm/leccion28/"
---

# Proyecto final PersistenceLab

## Proyecto final: `PersistenceLab`

Construye una aplicación que pueda ejecutar el mismo CRUD de `Producto` y `Vehiculo` sobre SQLite.

### Requisitos mínimos

1. Mantener `IRepository<T, ID>`, `IProductoRepository` e `IVehiculoRepository`.
2. Implementar `ProductoJdbcRepository`.
3. Implementar `ProductoOrmRepository` y `VehiculoOrmRepository`.
4. Mantener `Producto` y `Vehiculo` como modelos de dominio.
5. Utilizar entidades JPA separadas.
6. Leer URL y opciones de Hibernate desde `.properties`.
7. Incluir tests CRUD completos con bases SQLite temporales.

### Retos

- Añadir una entidad `Categoria` y una relación `@ManyToOne`.
- Activar el log SQL y relacionar cada operación JPA con el SQL generado.
- Comparar rendimiento y número de sentencias de JDBC y ORM.
- Investigar `LAZY`, `EAGER` y el problema N+1.
- Introducir una migración de esquema en lugar de depender de `hbm2ddl.auto`.

<div class="cla-note"><strong>Objetivo final</strong><p>Elegir conscientemente entre serialización, JDBC y ORM entendiendo qué responsabilidad asume cada tecnología.</p></div>

<div class="cla-lesson-nav">
  <a href="/orm/leccion27/">← 27 · Comparar ficheros, JDBC y ORM</a>
  <a href="/orm/">Volver a la ruta →</a>
</div>
