---
layout: "lesson"
route: "orm"
lesson_id: "leccion13"
lesson_file: "13-problema-mapeo-objeto-relacional"
lesson_number: "13"
title: "El problema del mapeo objeto-relacional"
description: "El problema del mapeo objeto-relacional"
permalink: "/orm/leccion13/"
---

# El problema del mapeo objeto-relacional

## ¿Qué se repite en JDBC?

Nuestro repositorio contiene mucho código que no pertenece al dominio:

```text
abrir Connection
preparar SQL
asignar parámetros
recorrer ResultSet
leer nombre de columnas
construir objetos
controlar SQLException
cerrar recursos
```

El fragmento:

```java
new Producto(
    rs.getLong("id"),
    rs.getString("nombre"),
    rs.getDouble("precio"))
```

es un mapeo manual entre dos modelos distintos:

```text
objetos Java ↔ modelo relacional
```

Un ORM intenta automatizar gran parte de esta correspondencia.

<div class="cla-lesson-nav">
  <a href="/orm/leccion12/">← 12 · Testear JDBC con SQLite temporal</a>
  <a href="/orm/leccion14/">14 · Qué es un ORM: JPA y Hibernate →</a>
</div>
