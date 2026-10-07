---
layout: "lesson"
route: "orm"
lesson_id: "leccion21"
lesson_file: "21-update-delete-orm"
lesson_number: "21"
title: "UPDATE y DELETE con entidades administradas"
description: "UPDATE y DELETE con entidades administradas"
permalink: "/orm/leccion21/"
---

# UPDATE y DELETE con entidades administradas

## Actualizar una entidad administrada

```java
ProductoEntity entity = em.find(ProductoEntity.class, producto.id());

if (entity == null) {
    return false;
}

entity.setNombre(producto.nombre());
entity.setPrecio(producto.precio());
```

No necesitamos escribir `UPDATE`: Hibernate detecta cambios en una entidad administrada y sincroniza al confirmar la transacción.

## Borrar

```java
ProductoEntity entity = em.find(ProductoEntity.class, id);
if (entity == null) return false;
em.remove(entity);
```

La transacción sigue siendo obligatoria para modificar estado persistente.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/21-managed.png" alt="Actualizar entidad administrada. find entidad → modificar estado → commit → UPDATE." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> find entidad → modificar estado → commit → UPDATE.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/21-remove.png" alt="Eliminar con JPA. find entidad → remove → commit → DELETE." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> find entidad → remove → commit → DELETE.</p>


## Ejemplo guiado

### Actualizar y eliminar con EntityManager

1. Busca la entidad por id.
2. Para update, cambia los atributos mientras está administrada.
3. Confirma la transacción.
4. Para delete, busca y llama a `remove`.
5. Comprueba el SQL generado.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué puede generar UPDATE al commit?

- A) Cambios en una entidad managed
- B) Un println
- C) Un record inmutable sin entidad
- D) Un Path

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Hibernate detecta cambios de entidades administradas.</p>

</details>

### 2. ¿Qué método elimina una entidad managed?

- A) remove
- B) persist
- C) findAll
- D) map

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> remove marca la entidad para borrado.</p>

</details>

### 3. ¿Qué debe ocurrir si no existe el id según el contrato propuesto?

- A) Puede devolverse false
- B) Se crea automáticamente
- C) Siempre se borra otra fila
- D) Se devuelve null en create

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> update/delete son booleanos para indicar éxito.</p>

</details>

### 4. ¿Por qué seguimos usando transacciones?

- A) Para consistencia en escrituras
- B) Solo por sintaxis
- C) Para evitar entidades
- D) Para leer Markdown

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Update y delete son cambios persistentes.</p>

</details>


## Ejercicio propuesto

Implementa update y delete devolviendo `false` cuando la entidad no existe.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion20/">← 20 · READ con find() y JPQL</a>
  <a href="/orm/leccion22/">22 · ProductoOrmRepository: CRUD completo →</a>
</div>
