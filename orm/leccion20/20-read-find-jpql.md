---
layout: "lesson"
route: "orm"
lesson_id: "leccion20"
lesson_file: "20-read-find-jpql"
lesson_number: "20"
title: "READ con find() y JPQL"
description: "READ con find() y JPQL"
permalink: "/orm/leccion20/"
---

# READ con find() y JPQL

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/20-find.png" alt="Buscar por clave primaria. EntityManager.find → ProductoEntity → Mapper → Producto." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> EntityManager.find → ProductoEntity → Mapper → Producto.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/20-jpql.png" alt="JPQL consulta entidades. JPQL → Hibernate genera SQL → Lista de entidades." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> JPQL → Hibernate genera SQL → Lista de entidades.</p>


## Ejemplo guiado

### Leer por id y listar todos

1. Usa `find(ProductoEntity.class, id)` para una PK.
2. Si existe, conviértela a Producto.
3. Para listar, escribe JPQL sobre `ProductoEntity`.
4. Convierte la lista de entidades al dominio.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué método busca por PK?

- A) find
- B) persist
- C) remove
- D) rollback

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> find recibe clase e identificador.</p>

</details>

### 2. ¿JPQL consulta directamente nombres de tablas?

- A) Normalmente consulta entidades y atributos
- B) Sí, siempre tablas físicas
- C) No permite SELECT
- D) Solo funciona con CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> JPQL trabaja en términos del modelo de entidades.</p>

</details>

### 3. ¿Quién traduce JPQL a SQL?

- A) El proveedor ORM como Hibernate
- B) javac
- C) sqlite3 CLI
- D) JUnit

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Hibernate genera el SQL apropiado.</p>

</details>

### 4. ¿Qué hacemos con ProductoEntity al devolver desde repositorio?

- A) La convertimos a Producto
- B) La imprimimos y descartamos siempre
- C) La convertimos a XML
- D) La compilamos

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
