---
layout: "lesson"
route: "orm"
lesson_id: "leccion08"
lesson_file: "08-preparedstatement-cud"
lesson_number: "08"
title: "INSERT, UPDATE y DELETE con PreparedStatement"
description: "INSERT, UPDATE y DELETE con PreparedStatement"
permalink: "/orm/leccion08/"
---

# INSERT, UPDATE y DELETE con PreparedStatement

## `PreparedStatement`

Crear:

```java
String sql = "INSERT INTO producto(id, nombre, precio) VALUES (?, ?, ?)";

try (PreparedStatement ps = connection.prepareStatement(sql)) {
    ps.setLong(1, producto.id());
    ps.setString(2, producto.nombre());
    ps.setDouble(3, producto.precio());
    ps.executeUpdate();
}
```

Actualizar:

```java
String sql = "UPDATE producto SET nombre = ?, precio = ? WHERE id = ?";
```

Borrar:

```java
String sql = "DELETE FROM producto WHERE id = ?";
```

`executeUpdate()` devuelve cuántas filas se han modificado. Esto encaja directamente con nuestros métodos `boolean update(...)` y `boolean delete(...)`.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/08-preparedstatement.png" alt="PreparedStatement y parámetros. SQL con ? → setLong / setString → executeUpdate." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> SQL con ? → setLong / setString → executeUpdate.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/08-parametros-vs-concatenacion.png" alt="Parámetros frente a concatenación. Concatenar valores → SQL parametrizado → Más seguro y claro." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Concatenar valores → SQL parametrizado → Más seguro y claro.</p>


## Ejemplo guiado

### Insertar un producto con PreparedStatement

1. Escribe `INSERT INTO producto(id,nombre,precio) VALUES (?,?,?)`.
2. Crea el `PreparedStatement`.
3. Asigna id, nombre y precio con métodos `set...`.
4. Ejecuta `executeUpdate()`.
5. Comprueba el número de filas afectadas.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué símbolo representa un parámetro JDBC?

- A) #
- B) ?
- C) @
- D) $

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> PreparedStatement usa `?` como placeholder.</p>

</details>

### 2. ¿Qué ventaja tiene frente a concatenar valores?

- A) Evita tipos Java
- B) Separa SQL y datos
- C) No necesita Connection
- D) Sustituye a SQLite

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Los parámetros separan la sentencia de los datos.</p>

</details>

### 3. ¿Qué devuelve normalmente executeUpdate?

- A) Un ResultSet
- B) Número de filas afectadas
- C) Un EntityManager
- D) Un fichero

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Indica cuántas filas cambiaron.</p>

</details>

### 4. ¿Qué operación usa normalmente SELECT?

- A) executeQuery
- B) executeUpdate
- C) persist
- D) remove

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> executeQuery devuelve ResultSet.</p>

</details>


## Ejercicio propuesto

Escribe los PreparedStatement necesarios para actualizar precio y eliminar por id sin concatenar valores en el SQL.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion07/">← 7 · SELECT, ResultSet y mapeo manual</a>
  <a href="/orm/leccion09/">9 · ProductoJdbcCrudDemo: CRUD completo →</a>
</div>
