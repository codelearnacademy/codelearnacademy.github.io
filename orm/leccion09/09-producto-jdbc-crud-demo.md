---
layout: "lesson"
route: "orm"
lesson_id: "leccion09"
lesson_file: "09-producto-jdbc-crud-demo"
lesson_number: "09"
title: "ProductoJdbcCrudDemo: CRUD completo"
description: "ProductoJdbcCrudDemo: CRUD completo"
permalink: "/orm/leccion09/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: antes-de-abstraer-crud-monolítico
  title: 'Antes de abstraer: CRUD monolítico'
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# ProductoJdbcCrudDemo: CRUD completo

## Objetivo de aprendizaje

Sigue el estado de un producto a través del ciclo completo de operaciones JDBC.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/09-producto-jdbc-crud-demo.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 09">
    <img src="{{ '/assets/images/orm/infografias/09-producto-jdbc-crud-demo.webp' | relative_url }}" alt="Resumen visual de la lección 09. ProductoJdbcCrudDemo: CRUD completo" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 09.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/09-producto-jdbc-crud-demo.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/09-crud-monolitico.png' | relative_url }}" alt="CRUD en un único programa" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> La demo permite seguir las operaciones de principio a fin. Este flujo sirve de punto de partida para extraer el repositorio.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/09-responsabilidades-mezcladas.png' | relative_url }}" alt="Responsabilidades de una demo CRUD" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Localiza estas tareas antes de refactorizar. Extrae SQL y mapeo al repositorio para simplificar el cliente.</p>


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

- A) Para evitar interfaces
- B) Para entender el problema antes de abstraer
- C) Porque JDBC obliga
- D) Porque es la arquitectura final

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Primero experimentamos las responsabilidades reales.</p>

</details>

### 2. ¿Qué problema aparece?

- A) SQLite no permite CRUD
- B) No hay SQL
- C) No existe Producto
- D) Se mezclan responsabilidades

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Conexión, SQL, mapping y flujo cliente quedan acoplados.</p>

</details>

### 3. ¿Qué siguiente paso propone la ruta?

- A) Refactorizar a repositorio
- B) Usar Spring inmediatamente
- C) Cambiar a XML
- D) Eliminar IRepository

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Se extrae ProductoJdbcRepository.</p>

</details>

### 4. ¿El demo debe ser el diseño final?

- A) Sí
- B) Solo para DELETE
- C) Solo para tests
- D) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Es un punto de partida didáctico.</p>

</details>


## Ejercicio propuesto

Añade una comprobación de identificador duplicado antes de insertar y describe qué responsabilidad está empezando a crecer demasiado.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion08/">← 8 · INSERT, UPDATE y DELETE con PreparedStatement</a>
  <a href="/orm/leccion10/">10 · Refactorizar a ProductoJdbcRepository →</a>
</div>
