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

<div class="cla-lesson-nav">
  <a href="/orm/leccion18/">← 18 · ProductoMapper: dominio y persistencia</a>
  <a href="/orm/leccion20/">20 · READ con find() y JPQL →</a>
</div>
