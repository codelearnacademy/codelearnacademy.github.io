---
layout: "lesson"
route: "orm"
lesson_id: "leccion06"
lesson_file: "06-crear-esquema-java"
lesson_number: "06"
title: "Crear el esquema desde Java"
description: "Crear el esquema desde Java"
permalink: "/orm/leccion06/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: crear-el-esquema-desde-java
  title: Crear el esquema desde Java
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Crear el esquema desde Java

## Objetivo de aprendizaje

Crea el esquema desde Java y explica qué ocurre al repetir CREATE TABLE IF NOT EXISTS.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/06-crear-esquema-java.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 06">
    <img src="{{ '/assets/images/orm/infografias/06-crear-esquema-java.webp' | relative_url }}" alt="Resumen visual de la lección 06. Crear el esquema desde Java" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 06.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/06-crear-esquema-java.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Crear el esquema desde Java

```java
public final class DatabaseInitializer {

    private DatabaseInitializer() {}

    public static void createSchema(String url) {
        String sql = """
            CREATE TABLE IF NOT EXISTS producto (
                id INTEGER PRIMARY KEY,
                nombre TEXT NOT NULL,
                precio REAL NOT NULL
            )
            """;

        try (Connection c = DriverManager.getConnection(url);
             Statement st = c.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RepositoryException("Error creando esquema", e);
        }
    }
}
```

La tabla se crea una vez si no existe. Para las pruebas podremos crear una base SQLite temporal y reconstruir el esquema en cada test.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/06-ddl-java.png' | relative_url }}" alt="Crear tablas desde Java" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El arranque puede preparar el esquema que necesita la aplicación. DDL define la estructura de la base de datos.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/06-if-not-exists.png' | relative_url }}" alt="Inicialización idempotente" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Ejecuta la misma sentencia en dos arranques. CREATE TABLE IF NOT EXISTS tampoco modifica una tabla existente.</p>


## Ejemplo guiado

### Crear la tabla producto al arrancar

1. Abre una conexión.
2. Prepara una sentencia `CREATE TABLE IF NOT EXISTS producto (...)`.
3. Ejecuta `executeUpdate()`.
4. Arranca de nuevo y comprueba que no falla.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué tipo de SQL es CREATE TABLE?

- A) JVM
- B) JPQL
- C) DDL
- D) DML

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> CREATE TABLE define estructura de datos.</p>

</details>

### 2. ¿Para qué sirve IF NOT EXISTS?

- A) Para hacer rollback
- B) Para evitar error si ya existe
- C) Para borrar la tabla
- D) Para insertar filas

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Permite inicializar repetidamente.</p>

</details>

### 3. ¿Qué objeto JDBC puede ejecutar DDL simple?

- A) Optional
- B) EntityManager
- C) Statement
- D) ResultSet

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Statement puede ejecutar CREATE TABLE.</p>

</details>

### 4. ¿Qué debe ocurrir en el segundo arranque?

- A) Borrar los datos
- B) Mantener la tabla existente
- C) Duplicar la tabla
- D) Fallar siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Una inicialización idempotente no destruye lo existente.</p>

</details>


## Ejercicio propuesto

Añade una tabla `vehiculo` y ejecuta la inicialización dos veces para comprobar que es idempotente.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion05/">← 5 · JDBC con SQLite</a>
  <a href="/orm/leccion07/">7 · SELECT, ResultSet y mapeo manual →</a>
</div>
