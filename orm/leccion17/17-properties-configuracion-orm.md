---
layout: "lesson"
route: "orm"
lesson_id: "leccion17"
lesson_file: "17-properties-configuracion-orm"
lesson_number: "17"
title: ".properties y configuración ORM"
description: ".properties y configuración ORM"
permalink: "/orm/leccion17/"
---

# .properties y configuración ORM

## Mantener `.properties`

Seguimos externalizando la configuración:

```properties
database.url=jdbc:sqlite:data/orm.db
hibernate.dialect=org.hibernate.community.dialect.SQLiteDialect
hibernate.hbm2ddl.auto=update
hibernate.show_sql=true
hibernate.format_sql=true
```

`OrmConfig` lee el fichero y crea las propiedades de JPA/Hibernate. El `persistence.xml` contiene el proveedor y las clases entidad, mientras que URL y opciones se pueden sobreescribir desde `.properties`.

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "sqlitePU",
        ormConfig.toJpaProperties());
```

La misma idea de la ruta de ficheros se mantiene: **la configuración cambia sin recompilar el código Java**.

<div class="cla-lesson-nav">
  <a href="/orm/leccion16/">← 16 · Dominio record frente a entidad JPA</a>
  <a href="/orm/leccion18/">18 · ProductoMapper: dominio y persistencia →</a>
</div>
