---
layout: "lesson"
route: "orm"
lesson_id: "leccion19"
lesson_file: "19-create-entitymanager"
lesson_number: "19"
title: "CREATE con EntityManager y persist()"
description: "CREATE con EntityManager y persist()"
permalink: "/orm/leccion19/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: crear-con-entitymanager
  title: Crear con EntityManager
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# CREATE con EntityManager y persist()

## Objetivo de aprendizaje

Persiste una entidad nueva con EntityManager y confirma la transacción.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/19-create-entitymanager.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 19">
    <img src="{{ '/assets/images/orm/infografias/19-create-entitymanager.webp' | relative_url }}" alt="Resumen visual de la lección 19. CREATE con EntityManager y persist()" width="1239" height="1269" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 19.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/19-create-entitymanager.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/19-persist.png' | relative_url }}" alt="Persistir una entidad nueva" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Una transacción delimita la creación del registro. La sincronización con la base puede ocurrir antes de confirmar.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/19-create-flow.png' | relative_url }}" alt="Crear un producto mediante JPA" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Sigue el objeto que recibe el repositorio. El repositorio coordina la conversión y la escritura.</p>


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

- A) remove
- B) persist
- C) find
- D) clear

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> persist registra una entidad nueva.</p>

</details>

### 2. ¿Qué debe rodear normalmente una escritura?

- A) Un stream
- B) Un ResultSet
- C) Un StringBuilder
- D) Una transacción

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Las escrituras ORM se realizan en transacción.</p>

</details>

### 3. ¿Qué objeto crea/gestiona operaciones de persistencia?

- A) PreparedStatement exclusivamente
- B) Path
- C) EntityManager
- D) Scanner

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> EntityManager es la API principal de JPA.</p>

</details>

### 4. ¿Qué ocurre antes de persistir en este diseño?

- A) Llamamos javac
- B) Mapeamos dominio a entidad
- C) Borramos Producto
- D) Convertimos a CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Producto no es directamente la entidad JPA.</p>

</details>


## Ejercicio propuesto

Inserta dos productos y comprueba en sqlite3 que Hibernate ha persistido las filas esperadas.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion18/">← 18 · ProductoMapper: dominio y persistencia</a>
  <a href="/orm/leccion20/">20 · READ con find() y JPQL →</a>
</div>

---
