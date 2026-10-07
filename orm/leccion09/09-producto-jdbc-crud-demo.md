---
layout: "lesson"
route: "orm"
lesson_id: "leccion09"
lesson_file: "09-producto-jdbc-crud-demo"
lesson_number: "09"
title: "ProductoJdbcCrudDemo: CRUD completo"
description: "ProductoJdbcCrudDemo: CRUD completo"
permalink: "/orm/leccion09/"
---

# ProductoJdbcCrudDemo: CRUD completo

## Antes de abstraer: CRUD monolítico

Construimos `ProductoJdbcCrudDemo`, equivalente a `CsvCrudDemo`, `JsonCrudDemo` y `XmlCrudDemo`.

```text
ProductoJdbcCrudDemo
 ├─ URL JDBC
 ├─ Connection
 ├─ SQL
 ├─ PreparedStatement
 ├─ ResultSet → Producto
 ├─ findAll / findById
 ├─ create / update / delete
 └─ tratamiento de SQLException
```

Ejemplo de `findById`:

```java
public Optional<Producto> findById(long id) {
    String sql = "SELECT id, nombre, precio FROM producto WHERE id = ?";
    try (Connection c = DriverManager.getConnection(url);
         PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setLong(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            return rs.next()
                    ? Optional.of(toProducto(rs))
                    : Optional.empty();
        }
    } catch (SQLException e) {
        throw new RepositoryException("Error buscando producto", e);
    }
}
```

Primero debe funcionar. Después refactorizamos.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/09-crud-monolitico.png" alt="CRUD monolítico. Main/Demo → Conexión + SQL + mapping → SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Main/Demo → Conexión + SQL + mapping → SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/09-responsabilidades-mezcladas.png" alt="Responsabilidades mezcladas. Interfaz de usuario → Reglas CRUD → SQL y JDBC." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Interfaz de usuario → Reglas CRUD → SQL y JDBC.</p>


## Ejemplo guiado

### Construir ProductoJdbcCrudDemo por fases

1. Empieza solo con `findAll`.
2. Añade `findById`.
3. Implementa `create`.
4. Completa `update` y `delete`.
5. Ejecuta una secuencia CRUD completa.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Por qué hacemos primero un CRUD monolítico?

- A) Porque es la arquitectura final
- B) Para entender el problema antes de abstraer
- C) Porque JDBC obliga
- D) Para evitar interfaces

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Primero experimentamos las responsabilidades reales.</p>

</details>

### 2. ¿Qué problema aparece?

- A) No hay SQL
- B) Se mezclan responsabilidades
- C) No existe Producto
- D) SQLite no permite CRUD

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Conexión, SQL, mapping y flujo cliente quedan acoplados.</p>

</details>

### 3. ¿Qué siguiente paso propone la ruta?

- A) Eliminar IRepository
- B) Refactorizar a repositorio
- C) Cambiar a XML
- D) Usar Spring inmediatamente

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Se extrae ProductoJdbcRepository.</p>

</details>

### 4. ¿El demo debe ser el diseño final?

- A) Sí
- B) No
- C) Solo para DELETE
- D) Solo para tests

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Es un punto de partida didáctico.</p>

</details>


## Ejercicio propuesto

Añade una comprobación de identificador duplicado antes de insertar y describe qué responsabilidad está empezando a crecer demasiado.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion08/">← 8 · INSERT, UPDATE y DELETE con PreparedStatement</a>
  <a href="/orm/leccion10/">10 · Refactorizar a ProductoJdbcRepository →</a>
</div>
