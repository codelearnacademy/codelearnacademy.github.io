---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: Persistencia con SQLite
search_title: Lección 08 - Persistencia con SQLite
search_description: Integrarás SQLite para persistir información en una aplicación Java.
description: Persistirás información con SQLite y JDBC en aplicaciones Java.
lessons:
  - id: modelo
    title: Modelo y conexión
  - id: crud
    title: CRUD con JDBC
  - id: organizacion
    title: DAO y transacciones
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion08/
---

<div class="cla-note"><strong>Qué se pretende</strong><p>Comprender cómo una aplicación Java mantiene información mediante SQLite, JDBC y técnicas de persistencia orientada a objetos.</p></div>

<div class="cla-note"><strong>Qué se consigue</strong><p>Al finalizar, podrás diseñar tablas, ejecutar operaciones CRUD, organizar un DAO, controlar transacciones y mapear entidades con JPA.</p></div>

## Modelo y conexión

SQLite almacena una base de datos relacional en un fichero. JDBC ofrece una API común para conectar, preparar sentencias y leer resultados. El driver de SQLite debe estar incluido como dependencia del proyecto.

```java
String url = "jdbc:sqlite:academia.db";
try (Connection connection = DriverManager.getConnection(url);
   Statement statement = connection.createStatement()) {
  statement.executeUpdate("CREATE TABLE IF NOT EXISTS alumno (id INTEGER PRIMARY KEY, nombre TEXT NOT NULL)");
}
```

### Ejemplos

**Ejemplo 1: crear una tabla**

```java
statement.executeUpdate("CREATE TABLE IF NOT EXISTS curso (id INTEGER PRIMARY KEY, nombre TEXT NOT NULL)");
```

**Ejemplo 2: insertar con parámetros**

```java
try (PreparedStatement query = connection.prepareStatement("INSERT INTO curso(nombre) VALUES (?)")) {
  query.setString(1, "Programación");
  query.executeUpdate();
}
```

**Ejemplo 3: consultar una conexión**

```java
try (Connection conexión = DriverManager.getConnection("jdbc:sqlite:academia.db")) {
  System.out.println(conexión.isValid(2));
}
```

**Ejemplo 4: comprobar el esquema**

```java
try (ResultSet tablas = connection.getMetaData().getTables(null, null, "alumno", null)) {
  System.out.println(tablas.next() ? "Tabla disponible" : "Tabla inexistente");
}
```

## CRUD con JDBC

Usa sentencias parametrizadas para no construir SQL concatenando datos del usuario:

```java
String insert = "INSERT INTO alumno(nombre) VALUES (?)";
try (PreparedStatement statement = connection.prepareStatement(insert)) {
  statement.setString(1, "Ada");
  statement.executeUpdate();
}

String select = "SELECT id, nombre FROM alumno ORDER BY nombre";
try (PreparedStatement statement = connection.prepareStatement(select);
   ResultSet result = statement.executeQuery()) {
  while (result.next()) {
    System.out.println(result.getInt("id") + " " + result.getString("nombre"));
  }
}
```

Las operaciones CRUD son insertar, consultar, actualizar y eliminar. Cada una debe validar entradas y cerrar sus recursos.

### Ejemplos CRUD

**Ejemplo 1: insertar**

```java
try (PreparedStatement query = connection.prepareStatement("INSERT INTO alumno(nombre) VALUES (?)")) {
  query.setString(1, "Grace");
  query.executeUpdate();
}
```

**Ejemplo 2: consultar**

```java
try (PreparedStatement query = connection.prepareStatement("SELECT nombre FROM alumno WHERE id = ?")) {
  query.setInt(1, 1);
  try (ResultSet result = query.executeQuery()) {
    if (result.next()) System.out.println(result.getString("nombre"));
  }
}
```

**Ejemplo 3: actualizar**

```java
try (PreparedStatement query = connection.prepareStatement("UPDATE alumno SET nombre = ? WHERE id = ?")) {
  query.setString(1, "Grace Hopper");
  query.setInt(2, 1);
  query.executeUpdate();
}
```

**Ejemplo 4: eliminar**

```java
try (PreparedStatement query = connection.prepareStatement("DELETE FROM alumno WHERE id = ?")) {
  query.setInt(1, 1);
  query.executeUpdate();
}
```

## DAO y transacciones

Un DAO concentra el acceso a datos y evita que la interfaz de usuario conozca SQL. Una transacción agrupa operaciones que deben confirmarse juntas:

```java
try (Connection connection = DriverManager.getConnection(url)) {
  connection.setAutoCommit(false);
  try {
    // varias operaciones relacionadas
    connection.commit();
  } catch (SQLException error) {
    connection.rollback();
    throw error;
  }
}
```

### Ejemplos de organización

**Ejemplo 1: contrato DAO**

```java
public interface AlumnoDao {
  void guardar(Alumno alumno) throws SQLException;
  Optional<Alumno> buscar(int id) throws SQLException;
}
```

**Ejemplo 2: entidad Java**

```java
public record Alumno(int id, String nombre) { }
```

**Ejemplo 3: transacción de matrícula**

```java
connection.setAutoCommit(false);
try {
  insertarAlumno(connection);
  insertarMatricula(connection);
  connection.commit();
} catch (SQLException error) {
  connection.rollback();
  throw error;
}
```

**Ejemplo 4: conversión de errores**

```java
catch (SQLException error) {
  throw new PersistenciaException("No se pudo guardar el alumno", error);
}
```

## Persistencia orientada a objetos con JPA

El objetivo es relacionar objetos Java con tablas sin escribir cada operación SQL manualmente. JPA define la API de persistencia; Hibernate es una implementación habitual. Al finalizar, el alumno podrá mapear una entidad, abrir un contexto, guardar cambios y consultar objetos.

### Ejemplo 1: entidad

```java
@Entity
public class Alumno {
  @Id @GeneratedValue
  private Long id;
  private String nombre;
  protected Alumno() { }
  public Alumno(String nombre) { this.nombre = nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
}
```

### Ejemplo 2: persistir

```java
EntityTransaction transaction = entityManager.getTransaction();
transaction.begin();
entityManager.persist(new Alumno("Ada"));
transaction.commit();
```

### Ejemplo 3: consultar JPQL

```java
List<Alumno> alumnos = entityManager
    .createQuery("select a from Alumno a order by a.nombre", Alumno.class)
    .getResultList();
```

### Ejemplo 4: actualizar y eliminar

```java
Alumno alumno = entityManager.find(Alumno.class, 1L);
alumno.setNombre("Ada Lovelace");
entityManager.remove(alumno);
```

JPA facilita el mapeo objeto-relacional, pero no elimina la necesidad de comprender SQL, índices, transacciones y rendimiento. Para una aplicación pequeña con SQLite, JDBC puede ser más directo; JPA resulta útil cuando el modelo crece y se necesita una capa ORM.

### Ejercicios JPA

1. Configura una unidad de persistencia para SQLite.
2. Mapea `Alumno` y `Curso` con una relación.
3. Implementa un repositorio con alta, consulta, modificación y baja.
4. Compara la misma operación con JDBC y con JPA.

## Ejercicios

1. Crea las tablas `alumno` y `curso` con una relación.
2. Implementa un DAO con métodos `crear`, `buscar`, `actualizar` y `borrar`.
3. Añade una consulta parametrizada por nombre.
4. Gestiona una transacción de matrícula.
5. Prueba duplicados, datos nulos y base de datos inexistente.
6. Construye una aplicación de consola CRUD y documenta su modelo.

<div class="cla-note"><strong>Buenas prácticas</strong><p>Usa `try-with-resources`, `PreparedStatement`, transacciones explícitas y excepciones de dominio que no filtren detalles innecesarios del motor.</p></div>
