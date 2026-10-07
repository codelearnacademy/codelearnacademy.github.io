---
layout: "lesson"
route: "orm"
lesson_id: "leccion24"
lesson_file: "24-comparar-jdbc-orm"
lesson_number: "24"
title: "Comparar el CRUD JDBC y ORM"
description: "Comparar el CRUD JDBC y ORM"
permalink: "/orm/leccion24/"
---

# Comparar el CRUD JDBC y ORM

## CRUD completo: JDBC frente a ORM

| Operación | JDBC | ORM |
|---|---|---|
| Crear | `INSERT` + parámetros | `persist()` |
| Buscar ID | `SELECT ... WHERE` | `find()` |
| Listar | `ResultSet` | JPQL |
| Actualizar | `UPDATE` | modificar entidad administrada |
| Eliminar | `DELETE` | `remove()` |
| Mapeo | manual | metadatos/anotaciones |

El ORM reduce código repetitivo, pero no elimina SQL, tablas, claves, índices ni transacciones. Precisamente por eso la ruta estudia primero JDBC.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/24-jdbc-vs-orm.png" alt="JDBC frente a ORM. JDBC expone SQL, PreparedStatement, ResultSet y mapping manual; ORM desplaza parte de ese trabajo a EntityManager, entidades y Hibernate." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> JDBC expone SQL, PreparedStatement, ResultSet y mapping manual; ORM desplaza parte de ese trabajo a EntityManager, entidades y Hibernate.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/24-misma-api.png" alt="Mismo contrato, distinta infraestructura. IProductoRepository → ProductoJdbcRepository → ProductoOrmRepository." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> IProductoRepository → ProductoJdbcRepository → ProductoOrmRepository.</p>


## Ejemplo guiado

### Comparar findById en JDBC y ORM

1. Pon ambos métodos lado a lado.
2. Marca SQL explícito, PreparedStatement y ResultSet en JDBC.
3. Marca EntityManager y mapper en ORM.
4. Identifica qué desaparece y qué nuevas abstracciones aparecen.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué suele tener JDBC que ORM abstrae?

- A) ResultSet y SQL explícito
- B) Interfaces Java
- C) Objetos Producto
- D) Tests

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> ORM reduce gran parte del mapping y SQL repetitivo.</p>

</details>

### 2. ¿ORM elimina la necesidad de entender SQL?

- A) No
- B) Sí por completo
- C) Solo en test
- D) Solo con SQLite

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El modelo relacional y el SQL siguen importando.</p>

</details>

### 3. ¿Qué permanece igual en ambas implementaciones?

- A) IProductoRepository
- B) El código interno de persistencia
- C) PreparedStatement
- D) EntityManager

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La interfaz permite comparar estrategias.</p>

</details>

### 4. ¿Cuál es la mejor opción siempre?

- A) No existe una respuesta universal
- B) Siempre ORM
- C) Siempre JDBC
- D) Siempre CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Depende de requisitos, complejidad y control deseado.</p>

</details>


## Ejercicio propuesto

Escribe una tabla con al menos cuatro ventajas, costes o riesgos de JDBC y ORM en este proyecto.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


## Actividad integradora · El mismo CRUD con dos estrategias

**Modalidad:** tarea integradora de bloque.

Implementa y prueba la misma secuencia CRUD con `ProductoJdbcRepository` y `ProductoOrmRepository`; compara código, SQL visible, manejo de errores y esfuerzo de mapping.

### Evidencias

- Proyecto reproducible.
- README con instrucciones de ejecución.
- Pruebas realizadas.
- Explicación de problemas encontrados y cómo se resolvieron.


<div class="cla-lesson-nav">
  <a href="/orm/leccion23/">← 23 · Errores y RepositoryException en ORM</a>
  <a href="/orm/leccion25/">25 · VehiculoEntity e IVehiculoRepository →</a>
</div>
