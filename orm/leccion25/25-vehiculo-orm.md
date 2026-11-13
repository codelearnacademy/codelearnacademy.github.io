---
layout: "lesson"
route: "orm"
lesson_id: "leccion25"
lesson_file: "25-vehiculo-orm"
lesson_number: "25"
title: "VehiculoEntity e IVehiculoRepository"
description: "VehiculoEntity e IVehiculoRepository"
permalink: "/orm/leccion25/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: generalizar-con-vehiculo
  title: Generalizar con Vehiculo
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# VehiculoEntity e IVehiculoRepository

## Objetivo de aprendizaje

Aplica el patrón de repositorio y el mapeo JPA al modelo Vehiculo.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/25-vehiculo-orm.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 25">
    <img src="{{ '/assets/images/orm/infografias/25-vehiculo-orm.webp' | relative_url }}" alt="Resumen visual de la lección 25. VehiculoEntity e IVehiculoRepository" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 25.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/25-vehiculo-orm.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/25-generalizacion.png' | relative_url }}" alt="Generalizar el contrato del repositorio" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> IRepository&lt;T, ID&gt; expresa operaciones comunes. Las dos interfaces reutilizan el contrato genérico con tipos propios.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/25-vehiculo-mapping.png' | relative_url }}" alt="Mapear un Vehiculo" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El identificador debe conservarse al pasar de un modelo a otro. Cada capa usa su representación del vehículo.</p>


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
- C) UUID obligatoriamente
- D) double

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La matrícula se modela como String.</p>

</details>

### 2. ¿Qué demuestra añadir Vehiculo?

- A) Que SQLite no soporta Strings
- B) Que Producto era incorrecto
- C) Que el patrón se generaliza
- D) Que no necesitamos interfaces

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Verificamos que la arquitectura no depende de una sola entidad.</p>

</details>

### 3. ¿Qué campo usa @Id?

- A) anio
- B) matricula
- C) marca
- D) modelo

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La matrícula identifica Vehiculo.</p>

</details>

### 4. ¿Qué interfaz comparte la estructura CRUD genérica?

- A) Path
- B) PreparedStatement
- C) EntityManager
- D) <code>IRepository&lt;T,ID&gt;</code>

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Las interfaces específicas extienden el contrato genérico.</p>

</details>


## Ejercicio propuesto

Implementa create y delete para Vehiculo y comprueba que la identidad es la matrícula, no el equals completo del record.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion24/">← 24 · Comparar el CRUD JDBC y ORM</a>
  <a href="/orm/leccion26/">26 · Tests ORM con SQLite →</a>
</div>

---
