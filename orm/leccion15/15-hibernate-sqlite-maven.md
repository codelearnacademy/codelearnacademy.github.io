---
layout: "lesson"
route: "orm"
lesson_id: "leccion15"
lesson_file: "15-hibernate-sqlite-maven"
lesson_number: "15"
title: "Hibernate y SQLite con Maven"
description: "Hibernate y SQLite con Maven"
permalink: "/orm/leccion15/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: dependencias
  title: Dependencias
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Hibernate y SQLite con Maven

## Objetivo de aprendizaje

Reconoce la función del proveedor ORM, el driver de SQLite y el dialecto en la configuración Maven.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/15-hibernate-sqlite-maven.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 15">
    <img src="{{ '/assets/images/orm/infografias/15-hibernate-sqlite-maven.webp' | relative_url }}" alt="Resumen visual de la lección 15. Hibernate y SQLite con Maven" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 15.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/15-hibernate-sqlite-maven.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/15-dependencias.png' | relative_url }}" alt="Dependencias Maven para ORM" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Cada dependencia cubre una función en la aplicación. Consulta el pom.xml para las versiones del proyecto.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/15-sqlite-dialect.png' | relative_url }}" alt="El dialecto de SQLite" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Hibernate necesita conocer las particularidades del motor SQL. El dialecto y el driver cumplen funciones distintas.</p>


## Ejemplo guiado

### Añadir Hibernate y SQLite al pom.xml

1. Añade `hibernate-core`.
2. Añade `hibernate-community-dialects` para SQLite.
3. Mantén `sqlite-jdbc`.
4. Ejecuta `mvn dependency:tree` y localiza las tres dependencias.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué dependencia contiene el núcleo ORM?

- A) junit-jupiter
- B) commons-csv
- C) hibernate-core
- D) sqlite-jdbc

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> hibernate-core contiene el motor Hibernate.</p>

</details>

### 2. ¿Dónde se encuentra SQLiteDialect en esta ruta?

- A) sqlite3 CLI
- B) hibernate-community-dialects
- C) java.base
- D) jackson

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> SQLite se trata mediante dialectos comunitarios.</p>

</details>

### 3. ¿Qué aporta sqlite-jdbc?

- A) JUnit
- B) JPQL
- C) El driver JDBC
- D) Las anotaciones @Entity

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Permite comunicación JDBC con SQLite.</p>

</details>

### 4. ¿Qué gestiona Maven aquí?

- A) Objetos en Heap
- B) Dependencias del proyecto
- C) Transacciones de negocio
- D) Filas SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Maven resuelve librerías y versiones.</p>

</details>


## Ejercicio propuesto

Identifica qué dependencia aporta `SQLiteDialect` y explica por qué no pertenece al modelo de dominio.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion14/">← 14 · Qué es un ORM: JPA y Hibernate</a>
  <a href="/orm/leccion16/">16 · Dominio record frente a entidad JPA →</a>
</div>

---
