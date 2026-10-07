---
layout: "lesson"
route: "orm"
lesson_id: "leccion25"
lesson_file: "25-vehiculo-orm"
lesson_number: "25"
title: "VehiculoEntity e IVehiculoRepository"
description: "VehiculoEntity e IVehiculoRepository"
permalink: "/orm/leccion25/"
---

# VehiculoEntity e IVehiculoRepository

## Generalizar con `Vehiculo`

El dominio existente continúa siendo:

```java
public record Vehiculo(
        String matricula,
        String marca,
        String modelo,
        int anio) {}
```

Creamos `VehiculoEntity` con:

```java
@Id
private String matricula;
```

y un `VehiculoMapper`.

Después:

```java
public final class VehiculoOrmRepository
        implements IVehiculoRepository {
```

No necesitamos modificar `IRepository<T, ID>`. La prueba de que la abstracción es general es que ahora el identificador es `String`, no `Long`.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/25-generalizacion.png" alt="Generalizar el diseño. IRepository<T,ID> → IProductoRepository → IVehiculoRepository." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> IRepository<T,ID> → IProductoRepository → IVehiculoRepository.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/25-vehiculo-mapping.png" alt="Vehiculo y persistencia. Vehiculo record → VehiculoMapper → VehiculoEntity." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Vehiculo record → VehiculoMapper → VehiculoEntity.</p>


## Ejemplo guiado

### Añadir Vehiculo al ORM

1. Crea VehiculoEntity con matrícula como @Id.
2. Crea VehiculoMapper.
3. Implementa IVehiculoRepository usando el patrón de Producto.
4. Prueba findById con matrícula normalizada.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué tipo de ID usa Vehiculo?

- A) String
- B) Long
- C) double
- D) UUID obligatoriamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La matrícula se modela como String.</p>

</details>

### 2. ¿Qué demuestra añadir Vehiculo?

- A) Que el patrón se generaliza
- B) Que Producto era incorrecto
- C) Que no necesitamos interfaces
- D) Que SQLite no soporta Strings

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Verificamos que la arquitectura no depende de una sola entidad.</p>

</details>

### 3. ¿Qué campo usa @Id?

- A) matricula
- B) marca
- C) modelo
- D) anio

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La matrícula identifica Vehiculo.</p>

</details>

### 4. ¿Qué interfaz comparte la estructura CRUD genérica?

- A) <code>IRepository&lt;T,ID&gt;</code>
- B) EntityManager
- C) PreparedStatement
- D) Path

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Las interfaces específicas extienden el contrato genérico.</p>

</details>


## Ejercicio propuesto

Implementa create y delete para Vehiculo y comprueba que la identidad es la matrícula, no el equals completo del record.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion24/">← 24 · Comparar el CRUD JDBC y ORM</a>
  <a href="/orm/leccion26/">26 · Tests ORM con SQLite →</a>
</div>
