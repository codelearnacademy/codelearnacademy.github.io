---
layout: lesson
route: spring
lesson_id: leccion61
lesson_file: 61-configurar-datasource
lesson_number: "61"
title: Configurar DataSource
description: Configura una base SQLite3 y localiza el archivo utilizado por la aplicación.
permalink: /spring/leccion61/
lessons:
  - id: práctica-con-sqlite3
    title: Práctica con SQLite3
  - id: comprueba-lo-aprendido
    title: Comprueba lo aprendido
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Configurar DataSource

Configura una base SQLite3 y localiza el archivo utilizado por la aplicación.

## Práctica con SQLite3

Usa el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}) para continuar la práctica de las lecciones 61–67.

El `DataSource` proporciona conexiones JDBC. En esta práctica, SQLite guarda los datos en un archivo local. El controlador Xerial abre el archivo y el dialecto de Hibernate adapta el SQL.

```properties
spring.datasource.url=jdbc:sqlite:tareas-practica.sqlite3
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.datasource.hikari.maximum-pool-size=1
spring.datasource.hikari.connection-init-sql=PRAGMA foreign_keys=ON
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.open-in-view=false
```

Flyway crea el esquema y Hibernate comprueba su compatibilidad. La URL relativa se resuelve desde el directorio de ejecución. La práctica usa una sola conexión en el pool y activa la comprobación de claves foráneas al abrirla.

**Ejercicio breve.** Descarga y descomprime el proyecto. Desde la carpeta del POM, ejecuta `mvn spring-boot:run`. En otra terminal, consulta el archivo en modo de solo lectura:

```sh
sqlite3 -readonly tareas-practica.sqlite3 '.tables'
sqlite3 -readonly tareas-practica.sqlite3 'SELECT id, nombre FROM categorias;'
```

Localiza las tablas `categorias`, `tareas` y `flyway_schema_history`. Guarda el ID de la categoría «Estudio» para las lecciones siguientes.

## Comprueba lo aprendido

Repite el ejercicio cambiando un dato de entrada o usando un archivo nuevo para la migración. Registra el resultado esperado y lo observado en la API, en la consulta SQL o en la prueba.

<div class="cla-lesson-nav">
  <a href="/spring/leccion60/">← 60 · Añadir PostgreSQL mediante Maven</a>
  <a href="/spring/leccion62/">62 · Entidades JPA →</a>
</div>
