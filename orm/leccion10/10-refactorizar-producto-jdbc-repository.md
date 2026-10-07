---
layout: "lesson"
route: "orm"
lesson_id: "leccion10"
lesson_file: "10-refactorizar-producto-jdbc-repository"
lesson_number: "10"
title: "Refactorizar a ProductoJdbcRepository"
description: "Refactorizar a ProductoJdbcRepository"
permalink: "/orm/leccion10/"
---

# Refactorizar a ProductoJdbcRepository

## Refactorizar hacia el contrato conocido

No necesitamos inventar otra API:

```java
public final class ProductoJdbcRepository
        implements IProductoRepository {

    private final String url;

    public ProductoJdbcRepository(String url) {
        this.url = url;
    }
}
```

El repositorio implementa exactamente:

```java
List<Producto> findAll();
Optional<Producto> findById(Long id);
void create(Producto producto);
boolean update(Producto producto);
boolean delete(Long id);
```

A diferencia de `AbstractFileRepository`, JDBC no necesita cargar toda la colección en memoria: cada operación se traduce a una sentencia SQL específica.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/10-refactor-repository.png" alt="De demo a repositorio. Código cliente → IProductoRepository → ProductoJdbcRepository → SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Código cliente → IProductoRepository → ProductoJdbcRepository → SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/10-contrato-implementacion.png" alt="Contrato frente a implementación. IProductoRepository → Implementación JDBC → Infraestructura SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> IProductoRepository → Implementación JDBC → Infraestructura SQLite.</p>


## Ejemplo guiado

### Extraer findById al repositorio

1. Localiza SQL y mapping de `findById` en el demo.
2. Muévelos a `ProductoJdbcRepository`.
3. Haz que la clase implemente `IProductoRepository`.
4. Cambia el cliente para depender de la interfaz.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿De qué debe depender el cliente?

- A) ProductoJdbcRepository concreto
- B) IProductoRepository
- C) Connection
- D) ResultSet

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Depender del contrato reduce acoplamiento.</p>

</details>

### 2. ¿Qué conoce ProductoJdbcRepository?

- A) La UI
- B) JDBC y SQLite
- C) HTML
- D) El navegador

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Encapsula infraestructura JDBC.</p>

</details>

### 3. ¿Qué beneficio obtenemos?

- A) Cambiar de persistencia sin cambiar cliente
- B) Eliminar SQL de la base
- C) No usar Maven
- D) Evitar identificadores

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El contrato permite sustituir implementaciones.</p>

</details>

### 4. ¿Debe cambiar IRepository al refactorizar JDBC?

- A) Sí siempre
- B) No si el contrato ya expresa el CRUD
- C) Solo para SELECT
- D) Solo en test

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La misma API sirve para distintas persistencias.</p>

</details>


## Ejercicio propuesto

Completa la refactorización de `create`, `update` y `delete` manteniendo las firmas del contrato.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion09/">← 9 · ProductoJdbcCrudDemo: CRUD completo</a>
  <a href="/orm/leccion11/">11 · Transacciones con JDBC →</a>
</div>
