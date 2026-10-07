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

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/15-dependencias.png" alt="Dependencias del proyecto. hibernate-core → hibernate-community-dialects → sqlite-jdbc." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> hibernate-core → hibernate-community-dialects → sqlite-jdbc.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/15-sqlite-dialect.png" alt="Dialectos Hibernate. Hibernate → SQLiteDialect comunitario → SQL específico de SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Hibernate → SQLiteDialect comunitario → SQL específico de SQLite.</p>


## Ejemplo guiado

### Añadir Hibernate y SQLite al pom.xml

1. Añade `hibernate-core`.
2. Añade `hibernate-community-dialects` para SQLite.
3. Mantén `sqlite-jdbc`.
4. Ejecuta `mvn dependency:tree` y localiza las tres dependencias.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué dependencia contiene el núcleo ORM?

- A) hibernate-core
- B) sqlite-jdbc
- C) junit-jupiter
- D) commons-csv

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> hibernate-core contiene el motor Hibernate.</p>

</details>

### 2. ¿Dónde se encuentra SQLiteDialect en esta ruta?

- A) hibernate-community-dialects
- B) java.base
- C) sqlite3 CLI
- D) jackson

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> SQLite se trata mediante dialectos comunitarios.</p>

</details>

### 3. ¿Qué aporta sqlite-jdbc?

- A) El driver JDBC
- B) Las anotaciones @Entity
- C) JUnit
- D) JPQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Permite comunicación JDBC con SQLite.</p>

</details>

### 4. ¿Qué gestiona Maven aquí?

- A) Dependencias del proyecto
- B) Filas SQL
- C) Transacciones de negocio
- D) Objetos en Heap

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Maven resuelve librerías y versiones.</p>

</details>


## Ejercicio propuesto

Identifica qué dependencia aporta `SQLiteDialect` y explica por qué no pertenece al modelo de dominio.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion14/">← 14 · Qué es un ORM: JPA y Hibernate</a>
  <a href="/orm/leccion16/">16 · Dominio record frente a entidad JPA →</a>
</div>
