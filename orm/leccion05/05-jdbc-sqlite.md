---
layout: "lesson"
route: "orm"
lesson_id: "leccion05"
lesson_file: "05-jdbc-sqlite"
lesson_number: "05"
title: "JDBC con SQLite"
description: "JDBC con SQLite"
permalink: "/orm/leccion05/"
---

# JDBC con SQLite

## Driver JDBC para SQLite

Añadimos al `pom.xml`:

```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.53.4.0</version>
</dependency>
```

## Conexión

```java
String url = "jdbc:sqlite:data/app.db";

try (Connection connection = DriverManager.getConnection(url)) {
    System.out.println("Conectado a SQLite");
} catch (SQLException e) {
    throw new RepositoryException("Error conectando con SQLite", e);
}
```

Como en la ruta de ficheros, el código de infraestructura controla su propia excepción (`SQLException`). El contrato `IRepository` no la expone.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/05-jdbc-arquitectura.png" alt="Java, JDBC y SQLite. Java → JDBC API + driver → SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Java → JDBC API + driver → SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/05-connection.png" alt="Abrir una conexión JDBC. URL jdbc:sqlite:... → DriverManager → Connection." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> URL jdbc:sqlite:... → DriverManager → Connection.</p>


## Ejemplo guiado

### Abrir la primera conexión JDBC

1. Añade `sqlite-jdbc` al `pom.xml`.
2. Construye la URL `jdbc:sqlite:data/app.db`.
3. Llama a `DriverManager.getConnection(url)`.
4. Usa try-with-resources para cerrar la conexión.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué API estándar usa Java para bases de datos relacionales?

- A) JPA
- B) JDBC
- C) JVM
- D) JSON

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> JDBC define la API de acceso relacional.</p>

</details>

### 2. ¿Qué componente conecta JDBC con SQLite?

- A) Un driver JDBC
- B) Un record
- C) Un mapper
- D) JUnit

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El driver implementa la comunicación con SQLite.</p>

</details>

### 3. ¿Qué representa `Connection`?

- A) Una tabla
- B) Una conexión activa a la base
- C) Una fila
- D) Un fichero CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Connection es la sesión JDBC con la base.</p>

</details>

### 4. ¿Qué ventaja aporta try-with-resources?

- A) Hace SQL más rápido
- B) Cierra recursos automáticamente
- C) Elimina excepciones
- D) Crea entidades JPA

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Facilita el cierre seguro de Connection, Statement y ResultSet.</p>

</details>


## Ejercicio propuesto

Cambia la URL para trabajar con `data/pruebas.db` y verifica que ambas bases son ficheros distintos.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion04/">← 4 · SQL para el CRUD</a>
  <a href="/orm/leccion06/">6 · Crear el esquema desde Java →</a>
</div>
