---
layout: "lesson"
route: "orm"
lesson_id: "leccion03"
lesson_file: "03-modelo-relacional"
lesson_number: "03"
title: "Modelo relacional: Producto y Vehiculo"
description: "Modelo relacional: Producto y Vehiculo"
permalink: "/orm/leccion03/"
---

# Modelo relacional: Producto y Vehiculo

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/03-tabla-fila-columna.png" alt="Elementos del modelo relacional. Tabla → Filas → Columnas." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Tabla → Filas → Columnas.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/03-producto-tabla.png" alt="Producto y su tabla. Producto record → Mapeo de campos → tabla producto." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Producto record → Mapeo de campos → tabla producto.</p>


## Ejemplo guiado

### Convertir `Producto` en una tabla relacional

1. Lista los componentes `id`, `nombre` y `precio`.
2. Asigna un tipo SQL a cada uno.
3. Marca `id` como `PRIMARY KEY`.
4. Añade restricciones `NOT NULL` donde correspondan.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué representa una fila?

- A) Una tabla completa
- B) Una ocurrencia o registro
- C) Una consulta
- D) Un repositorio

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Cada fila representa una entidad almacenada.</p>

</details>

### 2. ¿Para qué sirve una clave primaria?

- A) Para ordenar siempre
- B) Para identificar de forma única una fila
- C) Para guardar decimales
- D) Para conectar JDBC

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La clave primaria identifica cada fila.</p>

</details>

### 3. En `Producto`, ¿qué campo es la identidad natural del repositorio?

- A) nombre
- B) precio
- C) id
- D) ninguno

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El contrato usa `Long` como ID de Producto.</p>

</details>

### 4. En `Vehiculo`, ¿qué identidad usamos en la ruta?

- A) marca
- B) modelo
- C) anio
- D) matricula

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> `IVehiculoRepository` usa `String` y la matrícula como identidad.</p>

</details>


## Ejercicio propuesto

Diseña la tabla de `Vehiculo` usando `matricula` como clave primaria y justifica los tipos SQL elegidos.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion02/">← 2 · SQLite y la consola sqlite3</a>
  <a href="/orm/leccion04/">4 · SQL para el CRUD →</a>
</div>
