---
layout: "lesson"
route: "orm"
lesson_id: "leccion08"
lesson_file: "08-preparedstatement-cud"
lesson_number: "08"
title: "INSERT, UPDATE y DELETE con PreparedStatement"
description: "INSERT, UPDATE y DELETE con PreparedStatement"
permalink: "/orm/leccion08/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: preparedstatement
  title: PreparedStatement
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# INSERT, UPDATE y DELETE con PreparedStatement

## Objetivo de aprendizaje

Asigna los valores de un PreparedStatement por posición y comprueba las filas afectadas.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/08-preparedstatement-cud.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 08">
    <img src="{{ '/assets/images/orm/infografias/08-preparedstatement-cud.webp' | relative_url }}" alt="Resumen visual de la lección 08. INSERT, UPDATE y DELETE con PreparedStatement" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 08.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/08-preparedstatement-cud.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/08-preparedstatement.png' | relative_url }}" alt="Asignar parámetros con PreparedStatement" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El SQL define la estructura y cada marcador recibe un valor. Comprueba el resultado de la escritura.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/08-parametros-vs-concatenacion.png' | relative_url }}" alt="Parámetros frente a concatenación" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Un valor recibido puede contener comillas u otros caracteres. Parametriza los valores para que se traten como datos.</p>


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
- B) $
- C) @
- D) ?

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> PreparedStatement usa `?` como placeholder.</p>

</details>

### 2. ¿Qué ventaja tiene frente a concatenar valores?

- A) Evita tipos Java
- B) Separa SQL y datos
- C) Sustituye a SQLite
- D) No necesita Connection

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Los parámetros separan la sentencia de los datos.</p>

</details>

### 3. ¿Qué devuelve normalmente executeUpdate?

- A) Un fichero
- B) Un EntityManager
- C) Número de filas afectadas
- D) Un ResultSet

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Indica cuántas filas cambiaron.</p>

</details>

### 4. ¿Qué operación usa normalmente SELECT?

- A) executeQuery
- B) persist
- C) executeUpdate
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
