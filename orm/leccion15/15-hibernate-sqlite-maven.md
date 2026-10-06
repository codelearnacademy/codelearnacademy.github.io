---
layout: "lesson"
route: "orm"
lesson_id: "leccion15"
lesson_file: "15-hibernate-sqlite-maven"
lesson_number: "15"
title: "Hibernate y SQLite con Maven"
description: "Hibernate y SQLite con Maven"
permalink: "/orm/leccion15/"
---

# Hibernate y SQLite con Maven

## Dependencias

```xml
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>7.4.11.Final</version>
</dependency>

<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-community-dialects</artifactId>
    <version>7.4.11.Final</version>
</dependency>

<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.53.4.0</version>
</dependency>
```

SQLite usa un dialecto comunitario de Hibernate:

```text
org.hibernate.community.dialect.SQLiteDialect
```

Eso significa que es útil para esta ruta docente, pero no tiene el mismo nivel de soporte oficial que los dialectos incluidos en `hibernate-core`.

<div class="cla-lesson-nav">
  <a href="/orm/leccion14/">← 14 · Qué es un ORM: JPA y Hibernate</a>
  <a href="/orm/leccion16/">16 · Dominio record frente a entidad JPA →</a>
</div>
