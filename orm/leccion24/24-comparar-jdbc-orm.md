---
layout: "lesson"
route: "orm"
lesson_id: "leccion24"
lesson_file: "24-comparar-jdbc-orm"
lesson_number: "24"
title: "Comparar el CRUD JDBC y ORM"
description: "Comparar el CRUD JDBC y ORM"
permalink: "/orm/leccion24/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: crud-completo-jdbc-frente-a-orm
  title: 'CRUD completo: JDBC frente a ORM'
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
- id: actividad-integradora-el-mismo-crud-con-dos-estrategias
  title: Actividad integradora · El mismo CRUD con dos estrategias
---

# Comparar el CRUD JDBC y ORM

## Objetivo de aprendizaje

Compara el trabajo que realiza el código JDBC con el que realiza JPA en un mismo CRUD.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/24-comparar-jdbc-orm.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 24">
    <img src="{{ '/assets/images/orm/infografias/24-comparar-jdbc-orm.webp' | relative_url }}" alt="Resumen visual de la lección 24. Comparar el CRUD JDBC y ORM" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 24.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/24-comparar-jdbc-orm.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/24-jdbc-vs-orm.png' | relative_url }}" alt="La misma actualización en JDBC y ORM" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Dos implementaciones pueden producir el mismo cambio en SQLite. Ambas estrategias deben respetar el contrato y gestionar los errores.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/24-misma-api.png' | relative_url }}" alt="Mismo contrato, dos implementaciones" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> IProductoRepository es el punto de entrada común. El cliente puede elegir cualquiera de las implementaciones del contrato.</p>


## Ejemplo guiado

### Comparar findById en JDBC y ORM

1. Pon ambos métodos lado a lado.
2. Marca SQL explícito, PreparedStatement y ResultSet en JDBC.
3. Marca EntityManager y mapper en ORM.
4. Identifica qué desaparece y qué nuevas abstracciones aparecen.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué suele tener JDBC que ORM abstrae?

- A) Tests
- B) ResultSet y SQL explícito
- C) Interfaces Java
- D) Objetos Producto

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> ORM reduce gran parte del mapping y SQL repetitivo.</p>

</details>

### 2. ¿ORM elimina la necesidad de entender SQL?

- A) Solo con SQLite
- B) Sí por completo
- C) No
- D) Solo en test

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El modelo relacional y el SQL siguen importando.</p>

</details>

### 3. ¿Qué permanece igual en ambas implementaciones?

- A) EntityManager
- B) PreparedStatement
- C) El código interno de persistencia
- D) IProductoRepository

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La interfaz permite comparar estrategias.</p>

</details>

### 4. ¿Cuál es la mejor opción siempre?

- A) Siempre JDBC
- B) Siempre ORM
- C) No existe una respuesta universal
- D) Siempre CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Depende de requisitos, complejidad y control deseado.</p>

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

---
