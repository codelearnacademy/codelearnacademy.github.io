---
layout: "lesson"
route: "orm"
lesson_id: "leccion03"
lesson_file: "03-modelo-relacional"
lesson_number: "03"
title: "Modelo relacional: Producto y Vehiculo"
description: "Modelo relacional: Producto y Vehiculo"
permalink: "/orm/leccion03/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: del-record-a-la-tabla
  title: Del record a la tabla
- id: clave-primaria
  title: Clave primaria
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Modelo relacional: Producto y Vehiculo

## Objetivo de aprendizaje

Identifica la clave primaria y relaciona los atributos Java con las columnas de Producto y Vehiculo.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/03-modelo-relacional.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 03">
    <img src="{{ '/assets/images/orm/infografias/03-modelo-relacional.webp' | relative_url }}" alt="Resumen visual de la lección 03. Modelo relacional: Producto y Vehiculo" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 03.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/03-modelo-relacional.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Del `record` a la tabla

Seguimos utilizando el modelo de dominio:

```java
public record Producto(long id, String nombre, double precio) {}
```

Su representación relacional es:

| Java | SQLite | Restricción |
|---|---|---|
| `long id` | `INTEGER` | `PRIMARY KEY` |
| `String nombre` | `TEXT` | `NOT NULL` |
| `double precio` | `REAL` | `NOT NULL` |

```sql
CREATE TABLE producto (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    precio REAL NOT NULL
);
```

## Clave primaria

La clave primaria representa la identidad de la fila. Es la misma idea que ya utilizábamos con `Producto::id` en `IRepository<Producto, Long>`.

Para `Vehiculo`, la identidad seguirá siendo la matrícula:

```sql
CREATE TABLE vehiculo (
    matricula TEXT PRIMARY KEY,
    marca TEXT NOT NULL,
    modelo TEXT NOT NULL,
    anio INTEGER NOT NULL
);
```

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/03-tabla-fila-columna.png' | relative_url }}" alt="Tabla, fila y columna" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Lee la tabla producto a tres niveles. La clave primaria distingue cada fila.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/03-producto-tabla.png' | relative_url }}" alt="Producto y su tabla" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Sigue el mismo objeto desde Java hasta SQLite. El mapeo hace explícita la correspondencia entre ambos modelos.</p>


## Ejemplo guiado

### Convertir `Producto` en una tabla relacional

1. Lista los componentes `id`, `nombre` y `precio`.
2. Asigna un tipo SQL a cada uno.
3. Marca `id` como `PRIMARY KEY`.
4. Añade restricciones `NOT NULL` donde correspondan.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué representa una fila?

- A) Una ocurrencia o registro
- B) Un repositorio
- C) Una consulta
- D) Una tabla completa

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Cada fila representa una entidad almacenada.</p>

</details>

### 2. ¿Para qué sirve una clave primaria?

- A) Para guardar decimales
- B) Para ordenar siempre
- C) Para conectar JDBC
- D) Para identificar de forma única una fila

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La clave primaria identifica cada fila.</p>

</details>

### 3. En `Producto`, ¿qué campo es la identidad natural del repositorio?

- A) nombre
- B) id
- C) precio
- D) ninguno

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El contrato usa `Long` como ID de Producto.</p>

</details>

### 4. En `Vehiculo`, ¿qué identidad usamos en la ruta?

- A) matricula
- B) modelo
- C) marca
- D) anio

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> `IVehiculoRepository` usa `String` y la matrícula como identidad.</p>

</details>


## Ejercicio propuesto

Diseña la tabla de `Vehiculo` usando `matricula` como clave primaria y justifica los tipos SQL elegidos.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion02/">← 2 · SQLite y la consola sqlite3</a>
  <a href="/orm/leccion04/">4 · SQL para el CRUD →</a>
</div>
