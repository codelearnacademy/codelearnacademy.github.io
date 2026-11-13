---
layout: "lesson"
route: "orm"
lesson_id: "leccion16"
lesson_file: "16-record-vs-entidad-jpa"
lesson_number: "16"
title: "Dominio record frente a entidad JPA"
description: "Dominio record frente a entidad JPA"
permalink: "/orm/leccion16/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: por-qué-no-convertir-directamente-producto-en-entidad
  title: ¿Por qué no convertir directamente Producto en entidad?
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Dominio record frente a entidad JPA

## Objetivo de aprendizaje

Separa los datos del dominio del mapeo de persistencia de una entidad JPA.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/16-record-vs-entidad-jpa.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 16">
    <img src="{{ '/assets/images/orm/infografias/16-record-vs-entidad-jpa.webp' | relative_url }}" alt="Resumen visual de la lección 16. Dominio record frente a entidad JPA" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 16.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/16-record-vs-entidad-jpa.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## ¿Por qué no convertir directamente `Producto` en entidad?

En la ruta anterior tenemos:

```java
public record Producto(long id, String nombre, double precio) {}
```

Los `record` son excelentes para nuestro modelo de dominio: compactos e inmutables. Una entidad JPA, en cambio, tiene ciclo de vida administrado, constructor sin argumentos y normalmente estado mutable.

Mantendremos el dominio limpio y añadiremos una clase de persistencia:

```java
@Entity
@Table(name = "producto")
public class ProductoEntity {
    @Id
    private Long id;
    private String nombre;
    private double precio;

    protected ProductoEntity() {}

    public ProductoEntity(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    // getters y setters
}
```

```text
Producto (record de dominio)
          ↕ mapper
ProductoEntity (persistencia ORM)
          ↕ Hibernate
       producto (tabla)
```

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/16-record-entity.png' | relative_url }}" alt="Record de dominio y entidad JPA" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El mismo producto tiene una representación para cada responsabilidad. El mapper transforma datos entre ambos tipos.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/16-responsabilidades.png' | relative_url }}" alt="Separar dominio y persistencia" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> La aplicación y el ORM necesitan información distinta. Cambiar el mapeo puede afectar solo a la capa de persistencia.</p>


## Ejemplo guiado

### Comparar Producto y ProductoEntity

1. Lista componentes del record Producto.
2. Crea una clase `ProductoEntity` con los mismos datos persistentes.
3. Añade `@Entity` y `@Id`.
4. Identifica qué requisitos pertenecen a JPA y cuáles al dominio.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Por qué separar record y entidad?

- A) Para distinguir dominio de persistencia
- B) Porque Java prohíbe records
- C) Para eliminar mappers
- D) Porque SQLite no acepta Strings

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La separación evita contaminar el dominio con detalles ORM.</p>

</details>

### 2. ¿Qué anotación marca una entidad JPA?

- A) @Sql
- B) @Jdbc
- C) @Record
- D) @Entity

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> @Entity declara una clase persistente.</p>

</details>

### 3. ¿Qué anotación marca la identidad?

- A) @Id
- B) @Column
- C) @Override
- D) @Table

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> @Id identifica la clave de entidad.</p>

</details>

### 4. ¿Quién transforma entre ambos modelos?

- A) sqlite3
- B) Mapper
- C) JVM
- D) Maven Surefire

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El mapper convierte dominio y entidad.</p>

</details>


## Ejercicio propuesto

Diseña `VehiculoEntity` manteniendo `Vehiculo` como record y usa matrícula como identificador.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion15/">← 15 · Hibernate y SQLite con Maven</a>
  <a href="/orm/leccion17/">17 · .properties y configuración ORM →</a>
</div>

---
