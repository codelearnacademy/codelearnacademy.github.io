---
layout: "lesson"
route: "orm"
lesson_id: "leccion14"
lesson_file: "14-orm-jpa-hibernate"
lesson_number: "14"
title: "Qué es un ORM: JPA y Hibernate"
description: "Qué es un ORM: JPA y Hibernate"
permalink: "/orm/leccion14/"
---

# Qué es un ORM: JPA y Hibernate

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/14-orm.png" alt="Mapeo objeto-relacional. Objeto / entidad Java → ORM → Tabla / fila SQL." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Objeto / entidad Java → ORM → Tabla / fila SQL.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/14-jpa-hibernate.png" alt="JPA y Hibernate. Jakarta Persistence: API/especificación → Hibernate: implementación → JDBC + base de datos." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Jakarta Persistence: API/especificación → Hibernate: implementación → JDBC + base de datos.</p>


## Ejemplo guiado

### Distinguir JPA, Hibernate y JDBC

1. Sitúa JPA como API estándar.
2. Sitúa Hibernate como proveedor que implementa JPA.
3. Recuerda que debajo sigue existiendo JDBC.
4. Relaciona `EntityManager` con JPA y el dialecto con Hibernate.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué significa ORM?

- A) Object-Relational Mapping
- B) Open Runtime Manager
- C) Object Repository Maven
- D) Ordered Row Model

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> ORM es mapeo objeto-relacional.</p>

</details>

### 2. ¿Qué es Jakarta Persistence?

- A) Una base de datos
- B) Una especificación/API
- C) Un IDE
- D) Un formato de fichero

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Define el estándar de persistencia.</p>

</details>

### 3. ¿Qué es Hibernate?

- A) Una implementación ORM/proveedor
- B) El compilador Java
- C) SQLite
- D) JUnit

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Hibernate implementa la API y realiza el trabajo ORM.</p>

</details>

### 4. ¿Qué suele haber debajo de Hibernate al hablar con SQLite?

- A) JDBC
- B) CSV
- C) CSS
- D) JVM bytecode directamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Hibernate termina usando conectividad JDBC.</p>

</details>


## Ejercicio propuesto

Explica en no más de cinco líneas la diferencia entre ORM, JPA e Hibernate y dibuja cómo se conectan con SQLite.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion13/">← 13 · El problema del mapeo objeto-relacional</a>
  <a href="/orm/leccion15/">15 · Hibernate y SQLite con Maven →</a>
</div>
