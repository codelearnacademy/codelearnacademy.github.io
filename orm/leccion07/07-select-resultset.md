---
layout: "lesson"
route: "orm"
lesson_id: "leccion07"
lesson_file: "07-select-resultset"
lesson_number: "07"
title: "SELECT, ResultSet y mapeo manual"
description: "SELECT, ResultSet y mapeo manual"
permalink: "/orm/leccion07/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: select-y-resultset
  title: SELECT y ResultSet
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# SELECT, ResultSet y mapeo manual

## Objetivo de aprendizaje

Recorre un ResultSet fila a fila y transforma sus columnas en un objeto Java.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/07-select-resultset.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 07">
    <img src="{{ '/assets/images/orm/infografias/07-select-resultset.webp' | relative_url }}" alt="Resumen visual de la lección 07. SELECT, ResultSet y mapeo manual" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 07.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/07-select-resultset.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/07-resultset-cursor.png' | relative_url }}" alt="Recorrer un ResultSet" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El cursor empieza antes de la primera fila. Cuando next() devuelve false, termina el recorrido.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/07-mapping-manual.png' | relative_url }}" alt="Mapeo manual con JDBC" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Convierte la fila actual en un objeto Producto. El repositorio concentra la conversión de filas a objetos.</p>


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

- A) El resultado tabular de una consulta
- B) La conexión
- C) La consulta SQL
- D) La transacción

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> ResultSet permite recorrer las filas devueltas.</p>

</details>

### 2. ¿Qué hace `next()`?

- A) Cierra la conexión
- B) Inserta una fila
- C) Avanza el cursor
- D) Crea la tabla

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Mueve el cursor a la siguiente fila.</p>

</details>

### 3. ¿Qué parte es mapeo manual?

- A) Convertir columnas en un Producto
- B) Abrir Maven
- C) Crear un índice
- D) Escribir SELECT

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El mapping transforma una fila relacional en un objeto.</p>

</details>

### 4. ¿Qué ocurre si findById no encuentra fila?

- A) Debe lanzar siempre IOException
- B) Debe borrar la tabla
- C) Puede devolver Optional.empty()
- D) Debe inventar un Producto

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El contrato usa Optional para ausencia.</p>

</details>


## Ejercicio propuesto

Implementa conceptualmente `findById(Long id)` con SELECT y un ResultSet de cero o una fila.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion06/">← 6 · Crear el esquema desde Java</a>
  <a href="/orm/leccion08/">8 · INSERT, UPDATE y DELETE con PreparedStatement →</a>
</div>
