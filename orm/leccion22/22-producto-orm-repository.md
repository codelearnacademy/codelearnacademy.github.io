---
layout: "lesson"
route: "orm"
lesson_id: "leccion22"
lesson_file: "22-producto-orm-repository"
lesson_number: "22"
title: "ProductoOrmRepository: CRUD completo"
description: "ProductoOrmRepository: CRUD completo"
permalink: "/orm/leccion22/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: repositorio-orm-completo
  title: Repositorio ORM completo
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# ProductoOrmRepository: CRUD completo

## Objetivo de aprendizaje

Ubica el mapper, el EntityManager y las transacciones en el CRUD del repositorio.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/22-producto-orm-repository.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 22">
    <img src="{{ '/assets/images/orm/infografias/22-producto-orm-repository.webp' | relative_url }}" alt="Resumen visual de la lección 22. ProductoOrmRepository: CRUD completo" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 22.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/22-producto-orm-repository.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Repositorio ORM completo

```java
public final class ProductoOrmRepository
        implements IProductoRepository {

    private final EntityManagerFactory emf;

    public ProductoOrmRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // findAll, findById, create, update, delete
}
```

El código cliente continúa viendo exactamente el contrato anterior:

```java
IProductoRepository productos = new ProductoOrmRepository(emf);

productos.create(new Producto(1, "Teclado", 30));
productos.findById(1L);
productos.update(new Producto(1, "Teclado", 35));
productos.delete(1L);
```

La aplicación no conoce `EntityManager`, `ProductoEntity` ni SQL.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/22-orm-repository.png' | relative_url }}" alt="Arquitectura del repositorio ORM" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El cliente accede al dominio a través del contrato. La aplicación recibe objetos de dominio.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/22-crud-orm.png' | relative_url }}" alt="CRUD dentro del repositorio ORM" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Acciones habituales sobre una entidad JPA. Las escrituras se ejecutan dentro de transacciones.</p>


## Ejemplo guiado

### Implementar findById en ProductoOrmRepository

1. Recibe el id del contrato.
2. Abre EntityManager.
3. Busca ProductoEntity con `find`.
4. Convierte la entidad encontrada a Producto.
5. Devuelve Optional y cierra recursos.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué interfaz implementa el repositorio?

- A) Connection
- B) ResultSet
- C) IProductoRepository
- D) Serializable obligatoriamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Conservamos el contrato de la ruta de ficheros.</p>

</details>

### 2. ¿Qué detalle oculta al cliente?

- A) Long
- B) Optional
- C) Producto
- D) EntityManager/Hibernate

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La infraestructura ORM queda encapsulada.</p>

</details>

### 3. ¿Qué devuelve findById?

- A) Connection
- B) <code>Optional&lt;Producto&gt;</code>
- C) ProductoEntity siempre
- D) ResultSet

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El contrato trabaja con dominio.</p>

</details>

### 4. ¿Puede sustituirse el repositorio JDBC por ORM sin cambiar el cliente?

- A) Solo sin SQLite
- B) Solo con Spring
- C) No nunca
- D) Sí, si ambos respetan la interfaz

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Ese es el objetivo del desacoplamiento.</p>

</details>


## Ejercicio propuesto

Completa create, findAll, update y delete manteniendo las firmas exactas de IProductoRepository.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion21/">← 21 · UPDATE y DELETE con entidades administradas</a>
  <a href="/orm/leccion23/">23 · Errores y RepositoryException en ORM →</a>
</div>

---
