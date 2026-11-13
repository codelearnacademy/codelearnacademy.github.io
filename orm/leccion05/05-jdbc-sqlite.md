---
layout: "lesson"
route: "orm"
lesson_id: "leccion05"
lesson_file: "05-jdbc-sqlite"
lesson_number: "05"
title: "JDBC con SQLite"
description: "JDBC con SQLite"
permalink: "/orm/leccion05/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: driver-jdbc-para-sqlite
  title: Driver JDBC para SQLite
- id: conexión
  title: Conexión
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# JDBC con SQLite

## Objetivo de aprendizaje

Sigue el recorrido de una conexión desde Java hasta el archivo SQLite mediante el driver JDBC.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/05-jdbc-sqlite.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 05">
    <img src="{{ '/assets/images/orm/infografias/05-jdbc-sqlite.webp' | relative_url }}" alt="Resumen visual de la lección 05. JDBC con SQLite" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 05.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/05-jdbc-sqlite.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/05-jdbc-arquitectura.png' | relative_url }}" alt="Java, JDBC y SQLite" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Sigue el recorrido de una consulta. JDBC es la API y el driver realiza el acceso específico a SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/05-connection.png' | relative_url }}" alt="Abrir una conexión JDBC" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> La URL identifica dónde se encuentran los datos. Usa try-with-resources para cerrar la conexión.</p>


## Ejemplo guiado

### Abrir la primera conexión JDBC

1. Añade `sqlite-jdbc` al `pom.xml`.
2. Construye la URL `jdbc:sqlite:data/app.db`.
3. Llama a `DriverManager.getConnection(url)`.
4. Usa try-with-resources para cerrar la conexión.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué API estándar usa Java para bases de datos relacionales?

- A) JVM
- B) JPA
- C) JSON
- D) JDBC

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> JDBC define la API de acceso relacional.</p>

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

- A) Una fila
- B) Una tabla
- C) Un fichero CSV
- D) Una conexión activa a la base

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Connection es la sesión JDBC con la base.</p>

</details>

### 4. ¿Qué ventaja aporta try-with-resources?

- A) Cierra recursos automáticamente
- B) Elimina excepciones
- C) Crea entidades JPA
- D) Hace SQL más rápido

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Facilita el cierre seguro de Connection, Statement y ResultSet.</p>

</details>


## Ejercicio propuesto

Cambia la URL para trabajar con `data/pruebas.db` y verifica que ambas bases son ficheros distintos.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion04/">← 4 · SQL para el CRUD</a>
  <a href="/orm/leccion06/">6 · Crear el esquema desde Java →</a>
</div>
