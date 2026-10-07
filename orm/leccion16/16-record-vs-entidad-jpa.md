---
layout: "lesson"
route: "orm"
lesson_id: "leccion16"
lesson_file: "16-record-vs-entidad-jpa"
lesson_number: "16"
title: "Dominio record frente a entidad JPA"
description: "Dominio record frente a entidad JPA"
permalink: "/orm/leccion16/"
---

# Dominio record frente a entidad JPA

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/16-record-entity.png" alt="Dominio y persistencia. Producto record de dominio → Mapper → ProductoEntity JPA." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Producto record de dominio → Mapper → ProductoEntity JPA.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/16-responsabilidades.png" alt="Separar responsabilidades. Modelo de dominio → Modelo de persistencia." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Modelo de dominio → Modelo de persistencia.</p>


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
- C) Porque SQLite no acepta Strings
- D) Para eliminar mappers

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La separación evita contaminar el dominio con detalles ORM.</p>

</details>

### 2. ¿Qué anotación marca una entidad JPA?

- A) @Entity
- B) @Record
- C) @Sql
- D) @Jdbc

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> @Entity declara una clase persistente.</p>

</details>

### 3. ¿Qué anotación marca la identidad?

- A) @Table
- B) @Id
- C) @Column
- D) @Override

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> @Id identifica la clave de entidad.</p>

</details>

### 4. ¿Quién transforma entre ambos modelos?

- A) Mapper
- B) JVM
- C) sqlite3
- D) Maven Surefire

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El mapper convierte dominio y entidad.</p>

</details>


## Ejercicio propuesto

Diseña `VehiculoEntity` manteniendo `Vehiculo` como record y usa matrícula como identificador.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion15/">← 15 · Hibernate y SQLite con Maven</a>
  <a href="/orm/leccion17/">17 · .properties y configuración ORM →</a>
</div>
