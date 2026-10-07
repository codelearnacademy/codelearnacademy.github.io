---
layout: "lesson"
route: "orm"
lesson_id: "leccion19"
lesson_file: "19-create-entitymanager"
lesson_number: "19"
title: "CREATE con EntityManager y persist()"
description: "CREATE con EntityManager y persist()"
permalink: "/orm/leccion19/"
---

# CREATE con EntityManager y persist()

## Crear con `EntityManager`

Toda escritura se realiza dentro de una transacción:

```java
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();

try {
    tx.begin();
    em.persist(ProductoMapper.toEntity(producto));
    tx.commit();
} catch (RuntimeException e) {
    if (tx.isActive()) tx.rollback();
    throw new RepositoryException("Error creando producto", e);
} finally {
    em.close();
}
```

Compara esto con JDBC: ya no escribimos `INSERT INTO`, ni asignamos tres parámetros manualmente.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/19-persist.png" alt="Crear una entidad ORM. begin → persist(entity) → commit." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> begin → persist(entity) → commit.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/19-create-flow.png" alt="CREATE ORM completo. Producto → Mapper → ProductoEntity → EntityManager → SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Producto → Mapper → ProductoEntity → EntityManager → SQLite.</p>


## Ejemplo guiado

### Persistir un Producto con EntityManager

1. Convierte Producto a ProductoEntity.
2. Abre un `EntityManager`.
3. Inicia la transacción.
4. Llama a `persist(entity)`.
5. Confirma con `commit()` y cierra el EntityManager.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué método JPA se usa para una entidad nueva?

- A) persist
- B) find
- C) remove
- D) clear

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> persist registra una entidad nueva.</p>

</details>

### 2. ¿Qué debe rodear normalmente una escritura?

- A) Una transacción
- B) Un ResultSet
- C) Un StringBuilder
- D) Un stream

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Las escrituras ORM se realizan en transacción.</p>

</details>

### 3. ¿Qué objeto crea/gestiona operaciones de persistencia?

- A) EntityManager
- B) Scanner
- C) Path
- D) PreparedStatement exclusivamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> EntityManager es la API principal de JPA.</p>

</details>

### 4. ¿Qué ocurre antes de persistir en este diseño?

- A) Mapeamos dominio a entidad
- B) Borramos Producto
- C) Convertimos a CSV
- D) Llamamos javac

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Producto no es directamente la entidad JPA.</p>

</details>


## Ejercicio propuesto

Inserta dos productos y comprueba en sqlite3 que Hibernate ha persistido las filas esperadas.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion18/">← 18 · ProductoMapper: dominio y persistencia</a>
  <a href="/orm/leccion20/">20 · READ con find() y JPQL →</a>
</div>
