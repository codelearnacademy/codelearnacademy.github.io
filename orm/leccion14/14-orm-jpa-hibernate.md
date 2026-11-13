---
layout: "lesson"
route: "orm"
lesson_id: "leccion14"
lesson_file: "14-orm-jpa-hibernate"
lesson_number: "14"
title: "Qué es un ORM: JPA y Hibernate"
description: "Qué es un ORM: JPA y Hibernate"
permalink: "/orm/leccion14/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: orm
  title: ORM
- id: jpa-y-hibernate-no-son-lo-mismo
  title: JPA y Hibernate no son lo mismo
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Qué es un ORM: JPA y Hibernate

## Objetivo de aprendizaje

Distingue la especificación JPA, su implementación Hibernate y el acceso a SQLite mediante JDBC.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/14-orm-jpa-hibernate.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 14">
    <img src="{{ '/assets/images/orm/infografias/14-orm-jpa-hibernate.webp' | relative_url }}" alt="Resumen visual de la lección 14. Qué es un ORM: JPA y Hibernate" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 14.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/14-orm-jpa-hibernate.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## ORM

**Object-Relational Mapping** es la correspondencia entre clases/objetos y tablas/filas.

```text
ProductoEntity            tabla producto
──────────────             ──────────────
id                  ↔      id
nombre              ↔      nombre
precio              ↔      precio
```

## JPA y Hibernate no son lo mismo

- **Jakarta Persistence (JPA):** especificación/API estándar.
- **Hibernate ORM:** implementación de esa API y motor ORM.

En la ruta programaremos principalmente contra tipos de JPA (`EntityManager`, `@Entity`, `@Id`) y utilizaremos Hibernate como proveedor.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/14-orm.png' | relative_url }}" alt="Mapeo objeto-relacional" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El ORM vincula atributos de entidades con columnas de tablas. El mapeo permite recuperar entidades a partir de las filas.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/14-jpa-hibernate.png' | relative_url }}" alt="JPA, Hibernate y JDBC" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Tres nombres con funciones diferentes. SQLite sigue siendo la base de datos de la aplicación.</p>


## Ejemplo guiado

### Distinguir JPA, Hibernate y JDBC

1. Sitúa JPA como API estándar.
2. Sitúa Hibernate como proveedor que implementa JPA.
3. Recuerda que debajo sigue existiendo JDBC.
4. Relaciona `EntityManager` con JPA y el dialecto con Hibernate.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué significa ORM?

- A) Open Runtime Manager
- B) Object-Relational Mapping
- C) Object Repository Maven
- D) Ordered Row Model

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> ORM es mapeo objeto-relacional.</p>

</details>

### 2. ¿Qué es Jakarta Persistence?

- A) Un IDE
- B) Un formato de fichero
- C) Una especificación/API
- D) Una base de datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Define el estándar de persistencia.</p>

</details>

### 3. ¿Qué es Hibernate?

- A) JUnit
- B) El compilador Java
- C) SQLite
- D) Una implementación ORM/proveedor

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Hibernate implementa la API y realiza el trabajo ORM.</p>

</details>

### 4. ¿Qué suele haber debajo de Hibernate al hablar con SQLite?

- A) CSV
- B) CSS
- C) JDBC
- D) JVM bytecode directamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Hibernate termina usando conectividad JDBC.</p>

</details>


## Ejercicio propuesto

Explica en no más de cinco líneas la diferencia entre ORM, JPA e Hibernate y dibuja cómo se conectan con SQLite.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion13/">← 13 · El problema del mapeo objeto-relacional</a>
  <a href="/orm/leccion15/">15 · Hibernate y SQLite con Maven →</a>
</div>

---
