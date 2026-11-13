---
layout: "lesson"
route: "orm"
lesson_id: "leccion10"
lesson_file: "10-refactorizar-producto-jdbc-repository"
lesson_number: "10"
title: "Refactorizar a ProductoJdbcRepository"
description: "Refactorizar a ProductoJdbcRepository"
permalink: "/orm/leccion10/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: refactorizar-hacia-el-contrato-conocido
  title: Refactorizar hacia el contrato conocido
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Refactorizar a ProductoJdbcRepository

## Objetivo de aprendizaje

Separa el contrato de persistencia del código que ejecuta SQL y transforma filas.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/10-refactorizar-producto-jdbc-repository.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 10">
    <img src="{{ '/assets/images/orm/infografias/10-refactorizar-producto-jdbc-repository.webp' | relative_url }}" alt="Resumen visual de la lección 10. Refactorizar a ProductoJdbcRepository" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 10.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/10-refactorizar-producto-jdbc-repository.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/10-refactor-repository.png' | relative_url }}" alt="De demo a repositorio" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> La misma operación SQL queda encapsulada tras una interfaz. La refactorización separa el uso del CRUD de su implementación.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/10-contrato-implementacion.png' | relative_url }}" alt="Contrato e implementación" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Cada nivel cumple una responsabilidad distinta. Puedes cambiar la implementación si mantiene el contrato.</p>


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
- B) ResultSet
- C) Connection
- D) IProductoRepository

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Depender del contrato reduce acoplamiento.</p>

</details>

### 2. ¿Qué conoce ProductoJdbcRepository?

- A) La UI
- B) JDBC y SQLite
- C) El navegador
- D) HTML

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Encapsula infraestructura JDBC.</p>

</details>

### 3. ¿Qué beneficio obtenemos?

- A) Evitar identificadores
- B) No usar Maven
- C) Eliminar SQL de la base
- D) Cambiar de persistencia sin cambiar cliente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> El contrato permite sustituir implementaciones.</p>

</details>

### 4. ¿Debe cambiar IRepository al refactorizar JDBC?

- A) Solo para SELECT
- B) Sí siempre
- C) No si el contrato ya expresa el CRUD
- D) Solo en test

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> La misma API sirve para distintas persistencias.</p>

</details>


## Ejercicio propuesto

Completa la refactorización de `create`, `update` y `delete` manteniendo las firmas del contrato.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion09/">← 9 · ProductoJdbcCrudDemo: CRUD completo</a>
  <a href="/orm/leccion11/">11 · Transacciones con JDBC →</a>
</div>
