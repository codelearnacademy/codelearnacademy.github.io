---
layout: "lesson"
route: "orm"
lesson_id: "leccion22"
lesson_file: "22-producto-orm-repository"
lesson_number: "22"
title: "ProductoOrmRepository: CRUD completo"
description: "ProductoOrmRepository: CRUD completo"
permalink: "/orm/leccion22/"
---

# ProductoOrmRepository: CRUD completo

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/22-orm-repository.png" alt="Arquitectura del repositorio ORM. Cliente → IProductoRepository → ProductoOrmRepository → EntityManager/Hibernate → SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Cliente → IProductoRepository → ProductoOrmRepository → EntityManager/Hibernate → SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/22-crud-orm.png" alt="CRUD dentro del repositorio. create → find/read → update → delete." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> create → find/read → update → delete.</p>


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

- A) IProductoRepository
- B) Connection
- C) ResultSet
- D) Serializable obligatoriamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Conservamos el contrato de la ruta de ficheros.</p>

</details>

### 2. ¿Qué detalle oculta al cliente?

- A) EntityManager/Hibernate
- B) Producto
- C) Long
- D) Optional

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La infraestructura ORM queda encapsulada.</p>

</details>

### 3. ¿Qué devuelve findById?

- A) <code>Optional&lt;Producto&gt;</code>
- B) ProductoEntity siempre
- C) ResultSet
- D) Connection

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El contrato trabaja con dominio.</p>

</details>

### 4. ¿Puede sustituirse el repositorio JDBC por ORM sin cambiar el cliente?

- A) Sí, si ambos respetan la interfaz
- B) No nunca
- C) Solo con Spring
- D) Solo sin SQLite

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Ese es el objetivo del desacoplamiento.</p>

</details>


## Ejercicio propuesto

Completa create, findAll, update y delete manteniendo las firmas exactas de IProductoRepository.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion21/">← 21 · UPDATE y DELETE con entidades administradas</a>
  <a href="/orm/leccion23/">23 · Errores y RepositoryException en ORM →</a>
</div>
