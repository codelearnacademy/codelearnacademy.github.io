---
layout: "lesson"
route: "orm"
lesson_id: "leccion31"
lesson_file: "31-crud-dao-entitymanager"
lesson_number: "31"
title: "CRUD con DAO y EntityManager"
description: "Implementar listar, buscar, insertar, actualizar y eliminar con contratos defensivos."
permalink: "/orm/leccion31/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: contrato-de-los-dao-del-ejercicio
  title: Contrato de los DAO del ejercicio
- id: buscar-sin-transacción-de-escritura
  title: Buscar sin transacción de escritura
- id: insertar-con-transacción-y-rollback
  title: Insertar con transacción y rollback
- id: actualizar-y-eliminar-decisiones-clave
  title: 'Actualizar y eliminar: decisiones clave'
- id: actividad
  title: Actividad
---

# CRUD con DAO y EntityManager

## Objetivo de aprendizaje

Aplica el contrato del DAO a las consultas, las escrituras y los casos de error.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/31-crud-dao-entitymanager.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 31">
    <img src="{{ '/assets/images/orm/infografias/31-crud-dao-entitymanager.webp' | relative_url }}" alt="Resumen visual de la lección 31. CRUD con DAO y EntityManager" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 31.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/31-crud-dao-entitymanager.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Contrato de los DAO del ejercicio

| Operación | Éxito | Fallo, ausencia o dato inválido |
|---|---|---|
| `List<Cliente> listarTodos()` | Lista ordenada | Lista vacía, nunca `null` |
| `Cliente buscarPorId(String dni)` | Modelo encontrado | `null` |
| `boolean insertar(Cliente modelo)` | `true` | `false` |
| `boolean actualizar(Cliente modelo)` | `true` | `false` |
| `boolean eliminar(String dni)` | `true` | `false` |

Los métodos públicos de estos DAO gestionan internamente las excepciones habituales de validación y persistencia, y devuelven el resultado definido por su contrato.

## Buscar sin transacción de escritura

```java
public Cliente buscarPorId(String dni) {
    if (dni == null || dni.isBlank()) return null;

    EntityManager em = emf.createEntityManager();
    try {
        ClienteEntity entidad = em.find(ClienteEntity.class, dni);
        return ClienteMapper.toModel(entidad);
    } catch (RuntimeException ex) {
        return null;
    } finally {
        em.close();
    }
}
```

`emf` representa una `EntityManagerFactory` correctamente inicializada y compartida. **No crees una factoría nueva en cada método.**

## Insertar con transacción y `rollback`

```java
public boolean insertar(Cliente modelo) {
    if (modelo == null || modelo.getDni() == null
            || modelo.getDni().isBlank()
            || modelo.getNombre() == null
            || modelo.getNombre().isBlank()) return false;

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        if (em.find(ClienteEntity.class, modelo.getDni()) != null) {
            tx.rollback();
            return false;
        }
        em.persist(ClienteMapper.toEntity(modelo));
        tx.commit();
        return true;
    } catch (RuntimeException ex) {
        if (tx.isActive()) tx.rollback();
        return false;
    } finally {
        em.close();
    }
}
```

El ejemplo presupone que la creación de `EntityManager` funciona. En una implementación defensiva completa, protege también la apertura/cierre de recursos y comprueba que no se repropagan excepciones técnicas, con cuidado de no capturar errores graves de la JVM.

## Actualizar y eliminar: decisiones clave

- Para `actualizar`, comprueba que el ID existe antes de reemplazar los atributos permitidos. No utilices `merge` para dar de alta accidentalmente un registro inexistente.
- Para `eliminar`, recupera la entidad gestionada y aplica `remove` dentro de una transacción.
- Una FK existente puede impedir eliminar un cliente/equipo; devuelve `false` y conserva los datos.
- Si se produce un error, `rollback` y **estado coherente**.

## Actividad

Implementa `listarTodos`, `actualizar` y `eliminar` a partir de los patrones anteriores. Comprueba cinco casos: registro existente, inexistente, nulo, duplicado y tabla vacía. No uses `System.out.println` en el DAO.

<details><summary>Autoevaluación: ¿qué devuelve `listarTodos` cuando no hay filas?</summary>

Una lista vacía, **no** `null`.
</details>

**Siguiente:** [consultas JPQL por niveles](/orm/leccion32/).
