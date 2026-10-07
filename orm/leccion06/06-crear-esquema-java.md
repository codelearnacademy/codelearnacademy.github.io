---
layout: "lesson"
route: "orm"
lesson_id: "leccion06"
lesson_file: "06-crear-esquema-java"
lesson_number: "06"
title: "Crear el esquema desde Java"
description: "Crear el esquema desde Java"
permalink: "/orm/leccion06/"
---

# Crear el esquema desde Java

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/06-ddl-java.png" alt="Crear tablas desde Java. Java → Statement → CREATE TABLE → SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Java → Statement → CREATE TABLE → SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/06-if-not-exists.png" alt="Inicialización idempotente. Arranque 1 → CREATE TABLE IF NOT EXISTS → Arranque 2 sin error." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Arranque 1 → CREATE TABLE IF NOT EXISTS → Arranque 2 sin error.</p>


## Ejemplo guiado

### Crear la tabla producto al arrancar

1. Abre una conexión.
2. Prepara una sentencia `CREATE TABLE IF NOT EXISTS producto (...)`.
3. Ejecuta `executeUpdate()`.
4. Arranca de nuevo y comprueba que no falla.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué tipo de SQL es CREATE TABLE?

- A) DML
- B) DDL
- C) JPQL
- D) JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> CREATE TABLE define estructura de datos.</p>

</details>

### 2. ¿Para qué sirve IF NOT EXISTS?

- A) Para borrar la tabla
- B) Para evitar error si ya existe
- C) Para insertar filas
- D) Para hacer rollback

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Permite inicializar repetidamente.</p>

</details>

### 3. ¿Qué objeto JDBC puede ejecutar DDL simple?

- A) Statement
- B) ResultSet
- C) EntityManager
- D) Optional

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Statement puede ejecutar CREATE TABLE.</p>

</details>

### 4. ¿Qué debe ocurrir en el segundo arranque?

- A) Duplicar la tabla
- B) Fallar siempre
- C) Mantener la tabla existente
- D) Borrar los datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Una inicialización idempotente no destruye lo existente.</p>

</details>


## Ejercicio propuesto

Añade una tabla `vehiculo` y ejecuta la inicialización dos veces para comprobar que es idempotente.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion05/">← 5 · JDBC con SQLite</a>
  <a href="/orm/leccion07/">7 · SELECT, ResultSet y mapeo manual →</a>
</div>
