---
layout: "lesson"
route: "orm"
lesson_id: "leccion20"
lesson_file: "20-read-find-jpql"
lesson_number: "20"
title: "READ con find() y JPQL"
description: "READ con find() y JPQL"
permalink: "/orm/leccion20/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: buscar-por-clave
  title: Buscar por clave
- id: listar-con-jpql
  title: Listar con JPQL
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# READ con find() y JPQL

## Objetivo de aprendizaje

Distingue una búsqueda por identificador con find() de una consulta por criterios en JPQL.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/20-read-find-jpql.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 20">
    <img src="{{ '/assets/images/orm/infografias/20-read-find-jpql.webp' | relative_url }}" alt="Resumen visual de la lección 20. READ con find() y JPQL" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 20.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/20-read-find-jpql.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Buscar por clave

```java
ProductoEntity entity = em.find(ProductoEntity.class, id);
```

El ORM genera la consulta necesaria.

## Listar con JPQL

```java
List<Producto> productos = em.createQuery(
        "select p from ProductoEntity p order by p.id",
        ProductoEntity.class)
    .getResultStream()
    .map(ProductoMapper::toDomain)
    .toList();
```

JPQL consulta **entidades y atributos**, no nombres físicos de tablas y columnas. Hibernate lo traduce al SQL del dialecto SQLite.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/20-find.png' | relative_url }}" alt="Buscar por clave primaria" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Recupera un producto por su identificador. Aplica el contrato del repositorio al representar una ausencia.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/20-jpql.png' | relative_url }}" alt="Consultar entidades con JPQL" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Escribe la consulta usando nombres de entidades y atributos. El nombre de la entidad puede diferir del nombre de la tabla.</p>


## Ejemplo guiado

### Leer por id y listar todos

1. Usa `find(ProductoEntity.class, id)` para una PK.
2. Si existe, conviértela a Producto.
3. Para listar, escribe JPQL sobre `ProductoEntity`.
4. Convierte la lista de entidades al dominio.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué método busca por PK?

- A) rollback
- B) remove
- C) find
- D) persist

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> find recibe clase e identificador.</p>

</details>

### 2. ¿JPQL consulta directamente nombres de tablas?

- A) Normalmente consulta entidades y atributos
- B) Solo funciona con CSV
- C) No permite SELECT
- D) Sí, siempre tablas físicas

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> JPQL trabaja en términos del modelo de entidades.</p>

</details>

### 3. ¿Quién traduce JPQL a SQL?

- A) javac
- B) JUnit
- C) sqlite3 CLI
- D) El proveedor ORM como Hibernate

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Hibernate genera el SQL apropiado.</p>

</details>

### 4. ¿Qué hacemos con ProductoEntity al devolver desde repositorio?

- A) La convertimos a Producto
- B) La compilamos
- C) La convertimos a XML
- D) La imprimimos y descartamos siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El contrato del repositorio usa el dominio.</p>

</details>


## Ejercicio propuesto

Escribe una consulta JPQL que recupere productos ordenados por precio y convierte el resultado al dominio.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion19/">← 19 · CREATE con EntityManager y persist()</a>
  <a href="/orm/leccion21/">21 · UPDATE y DELETE con entidades administradas →</a>
</div>

---
