---
layout: "lesson"
route: "orm"
lesson_id: "leccion21"
lesson_file: "21-update-delete-orm"
lesson_number: "21"
title: "UPDATE y DELETE con entidades administradas"
description: "UPDATE y DELETE con entidades administradas"
permalink: "/orm/leccion21/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: actualizar-una-entidad-administrada
  title: Actualizar una entidad administrada
- id: borrar
  title: Borrar
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# UPDATE y DELETE con entidades administradas

## Objetivo de aprendizaje

Actualiza una entidad administrada o elimínala con remove() dentro de una transacción.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/21-update-delete-orm.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 21">
    <img src="{{ '/assets/images/orm/infografias/21-update-delete-orm.webp' | relative_url }}" alt="Resumen visual de la lección 21. UPDATE y DELETE con entidades administradas" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 21.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/21-update-delete-orm.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/21-managed.png' | relative_url }}" alt="Actualizar una entidad administrada" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El cambio se aplica sobre la entidad recuperada en la transacción. Una entidad debe estar administrada para detectar cambios de esta forma.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/21-remove.png' | relative_url }}" alt="Eliminar una entidad con JPA" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Primero se recupera la entidad que se quiere borrar. Si no existe, aplica el contrato del repositorio.</p>


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

- A) Un record inmutable sin entidad
- B) Cambios en una entidad managed
- C) Un Path
- D) Un println

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Hibernate detecta cambios de entidades administradas.</p>

</details>

### 2. ¿Qué método elimina una entidad managed?

- A) map
- B) findAll
- C) remove
- D) persist

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> remove marca la entidad para borrado.</p>

</details>

### 3. ¿Qué debe ocurrir si no existe el id según el contrato propuesto?

- A) Se devuelve null en create
- B) Siempre se borra otra fila
- C) Se crea automáticamente
- D) Puede devolverse false

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> update/delete son booleanos para indicar éxito.</p>

</details>

### 4. ¿Por qué seguimos usando transacciones?

- A) Para consistencia en escrituras
- B) Solo por sintaxis
- C) Para leer Markdown
- D) Para evitar entidades

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

---
