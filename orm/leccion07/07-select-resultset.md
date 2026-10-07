---
layout: "lesson"
route: "orm"
lesson_id: "leccion07"
lesson_file: "07-select-resultset"
lesson_number: "07"
title: "SELECT, ResultSet y mapeo manual"
description: "SELECT, ResultSet y mapeo manual"
permalink: "/orm/leccion07/"
---

# SELECT, ResultSet y mapeo manual

## `SELECT` y `ResultSet`

```java
String sql = "SELECT id, nombre, precio FROM producto ORDER BY id";
List<Producto> productos = new ArrayList<>();

try (Connection c = DriverManager.getConnection(url);
     PreparedStatement ps = c.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

    while (rs.next()) {
        productos.add(new Producto(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getDouble("precio")));
    }
}
```

Aquí aparece por primera vez el **mapeo objeto-relacional manual**:

```text
ResultSet → columnas → constructor → Producto
```

Guarda esta repetición: será uno de los problemas que justificará el ORM.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/07-resultset-cursor.png" alt="ResultSet recorre filas. SELECT → ResultSet → next() → Fila actual." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> SELECT → ResultSet → next() → Fila actual.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/07-mapping-manual.png" alt="Mapeo manual JDBC. Fila SQL → getLong/getString/getDouble → new Producto(...)." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Fila SQL → getLong/getString/getDouble → new Producto(...).</p>


## Ejemplo guiado

### Leer productos con ResultSet

1. Ejecuta un `SELECT id,nombre,precio FROM producto`.
2. Recorre el `ResultSet` con `while (rs.next())`.
3. Extrae cada columna por nombre.
4. Construye un `Producto` por fila.
5. Añádelo a una lista.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué representa ResultSet?

- A) La consulta SQL
- B) El resultado tabular de una consulta
- C) La conexión
- D) La transacción

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> ResultSet permite recorrer las filas devueltas.</p>

</details>

### 2. ¿Qué hace `next()`?

- A) Inserta una fila
- B) Avanza el cursor
- C) Cierra la conexión
- D) Crea la tabla

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Mueve el cursor a la siguiente fila.</p>

</details>

### 3. ¿Qué parte es mapeo manual?

- A) Escribir SELECT
- B) Convertir columnas en un Producto
- C) Abrir Maven
- D) Crear un índice

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El mapping transforma una fila relacional en un objeto.</p>

</details>

### 4. ¿Qué ocurre si findById no encuentra fila?

- A) Debe inventar un Producto
- B) Puede devolver Optional.empty()
- C) Debe borrar la tabla
- D) Debe lanzar siempre IOException

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El contrato usa Optional para ausencia.</p>

</details>


## Ejercicio propuesto

Implementa conceptualmente `findById(Long id)` con SELECT y un ResultSet de cero o una fila.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion06/">← 6 · Crear el esquema desde Java</a>
  <a href="/orm/leccion08/">8 · INSERT, UPDATE y DELETE con PreparedStatement →</a>
</div>
