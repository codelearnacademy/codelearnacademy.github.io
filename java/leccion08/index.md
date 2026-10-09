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

### Ejercicios de práctica · Modelo y conexión

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a conectar Java con SQLite y crear esquema. Debes utilizar explícitamente JDBC URL, `Connection`, `Statement`, metadatos y SQL DDL. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Modelo y conexión**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por rutas de base, tablas repetidas y restricciones. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Modelo y conexión**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en crear una base de academia o catálogo. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## CRUD con JDBC


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/08-resultset-mapping.png" alt="Mapeo manual de ResultSet a objeto Java" loading="lazy">
</figure>

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

### Ejercicios de práctica · CRUD con JDBC

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a persistir y recuperar filas. Debes utilizar explícitamente `PreparedStatement`, `ResultSet`, INSERT, SELECT, UPDATE, DELETE. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **CRUD con JDBC**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por ids inexistentes, filas afectadas y caracteres especiales. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **CRUD con JDBC**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en un CRUD de productos o vehículos. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## DAO y transacciones


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/08-dao.png" alt="Separación mediante DAO" loading="lazy">
</figure>

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

### Ejercicios de práctica · DAO y transacciones

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a separar acceso a datos y asegurar atomicidad. Debes utilizar explícitamente DAO/repository, `commit`, `rollback`, excepciones de persistencia. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **DAO y transacciones**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por operaciones parciales y SQL filtrándose al cliente. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **DAO y transacciones**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en matrícula o transferencia atómica. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Persistencia orientada a objetos con JPA


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/08-transaccion.png" alt="Unidad de trabajo y transacción" loading="lazy">
</figure>

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

### Ejercicios de práctica · Persistencia orientada a objetos con JPA

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a mapear objetos a tablas mediante ORM. Debes utilizar explícitamente `@Entity`, `@Id`, `EntityManager`, JPQL y transacciones. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Persistencia orientada a objetos con JPA**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por estado de entidades y diferencias con JDBC. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Persistencia orientada a objetos con JPA**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en un CRUD ORM de alumnos o productos. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Ejercicios

1. Crea las tablas `alumno` y `curso` con una relación.
2. Implementa un DAO con métodos `crear`, `buscar`, `actualizar` y `borrar`.
3. Añade una consulta parametrizada por nombre.
4. Gestiona una transacción de matrícula.
5. Prueba duplicados, datos nulos y base de datos inexistente.
6. Construye una aplicación de consola CRUD y documenta su modelo.

<div class="cla-note"><strong>Buenas prácticas</strong><p>Usa `try-with-resources`, `PreparedStatement`, transacciones explícitas y excepciones de dominio que no filtren detalles innecesarios del motor.</p></div>

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/08-jdbc-sqlite.png" alt="Arquitectura de persistencia: una aplicación Java usa JDBC y el driver SQLite para acceder a una base de datos local" loading="lazy">
</figure>

### Ejemplo guiado

Crea una tabla `producto`, inserta una fila con `PreparedStatement` y recupérala con `ResultSet`.

### Ejercicio propuesto

Implementa un CRUD de `Vehiculo` con SQLite y separa el acceso en un DAO/repository.

## Tarea para casa

Construye un gestor de alumnos con SQLite y JDBC que persista entre ejecuciones, con CRUD completo y una clase DAO/repository.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué papel tiene JDBC?

- A) API estándar de Java para interactuar con bases de datos relacionales
- B) ORM completo obligatorio
- C) Compilador Java
- D) Gestor de memoria

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> JDBC define interfaces y operaciones para conexión y SQL.</p>

</details>

### 2. ¿Qué objeto representa una conexión JDBC?

- A) Connection
- B) Scanner
- C) Pattern
- D) Period

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Connection encapsula la sesión/conexión con la base de datos.</p>

</details>

### 3. ¿Por qué usar PreparedStatement?

- A) Permite parametrizar SQL y evita concatenar valores directamente
- B) Solo para SELECT
- C) Porque elimina la base
- D) Porque sustituye a SQLite

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los parámetros mejoran seguridad y claridad.</p>

</details>

### 4. ¿Qué representa ResultSet?

- A) Resultados tabulares de una consulta
- B) Una excepción
- C) Una interfaz de colección
- D) El JDK

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> ResultSet permite recorrer las filas devueltas.</p>

</details>

### 5. ¿Qué garantiza conceptualmente una transacción?

- A) Agrupar operaciones para confirmar todas o revertir ante fallo
- B) Que toda consulta sea SELECT
- C) Que nunca haya errores
- D) Que JDBC sea ORM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Commit/rollback protegen la atomicidad del conjunto de operaciones.</p>

</details>

## Ejercicios propuestos

1. Crea una tabla `producto` en SQLite y realiza INSERT y SELECT desde JDBC.
2. Extrae el SQL de `main` a `ProductoDao` o `ProductoJdbcRepository`.
3. Implementa una operación de dos pasos dentro de una transacción y fuerza un error para comprobar el rollback.

## Ejercicios de repaso de la lección

Realiza estos retos después de completar los ejercicios de práctica. Cada concepto de la lección dispone de cinco ejercicios de repaso más autónomos.

### Modelo y conexión

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible conectar Java con SQLite y crear esquema. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Modelo y conexión** a un contexto distinto del explicado en clase, por ejemplo crear una base de academia o catálogo. Usa JDBC URL, `Connection`, `Statement`, metadatos y SQL DDL y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Modelo y conexión** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con rutas de base, tablas repetidas y restricciones. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Modelo y conexión**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### CRUD con JDBC

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible persistir y recuperar filas. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **CRUD con JDBC** a un contexto distinto del explicado en clase, por ejemplo un CRUD de productos o vehículos. Usa `PreparedStatement`, `ResultSet`, INSERT, SELECT, UPDATE, DELETE y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **CRUD con JDBC** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con ids inexistentes, filas afectadas y caracteres especiales. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **CRUD con JDBC**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### DAO y transacciones

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible separar acceso a datos y asegurar atomicidad. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **DAO y transacciones** a un contexto distinto del explicado en clase, por ejemplo matrícula o transferencia atómica. Usa DAO/repository, `commit`, `rollback`, excepciones de persistencia y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **DAO y transacciones** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con operaciones parciales y SQL filtrándose al cliente. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **DAO y transacciones**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Persistencia orientada a objetos con JPA

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible mapear objetos a tablas mediante ORM. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Persistencia orientada a objetos con JPA** a un contexto distinto del explicado en clase, por ejemplo un CRUD ORM de alumnos o productos. Usa `@Entity`, `@Id`, `EntityManager`, JPQL y transacciones y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Persistencia orientada a objetos con JPA** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con estado de entidades y diferencias con JDBC. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Persistencia orientada a objetos con JPA**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Actividades principales de la lección

### Actividad 1 · Primer CRUD con SQLite y JDBC

**Modalidad:** clase · **Tiempo orientativo:** 50–60 minutos

**Objetivo:** relacionar operaciones CRUD con sentencias SQL ejecutadas desde Java.

Crea `productos.db` y una tabla `producto`. Desde Java realiza al menos un `INSERT`, un `SELECT`, un `UPDATE` y un `DELETE` utilizando `PreparedStatement`.

**Comprobación:** después de cada operación realiza una consulta que demuestre el estado de la tabla.

### Actividad 2 · Extraer `ProductoDao`

**Modalidad:** clase · **Tiempo orientativo:** 50–60 minutos

**Objetivo:** separar la lógica de acceso a datos del código cliente.

Parte del CRUD anterior y mueve el SQL y el uso de JDBC a `ProductoDao` o `ProductoJdbcRepository`. `Main` no debe contener sentencias SQL.

**Comprobación:** cambia una consulta dentro del DAO y verifica que `Main` no necesita modificarse.

### Actividad 3 · Gestor persistente de alumnos

**Modalidad:** casa · **Tiempo orientativo:** 90–120 minutos

**Objetivo:** construir una pequeña aplicación CRUD persistente.

Desarrolla una aplicación con SQLite que permita crear, buscar, actualizar, eliminar y listar alumnos. Los datos deben mantenerse entre distintas ejecuciones.

**Requisitos mínimos:**

- uso de `PreparedStatement`;
- clase de acceso a datos separada;
- control básico de errores;
- base de datos local;
- `README.md` con instrucciones y al menos cinco casos de prueba.

**Ampliación:** compara este enfoque con la ruta ORM y anota qué código repetitivo podría eliminar un ORM.

<div class="cla-lesson-nav"><a href="/java/leccion07/">← 07 · Herencia e interfaces</a><a href="/java/">Volver a la ruta →</a></div>
