---
layout: "lesson"
route: "orm"
lesson_id: "leccion11"
lesson_file: "11-transacciones-jdbc"
lesson_number: "11"
title: "Transacciones con JDBC"
description: "Transacciones con JDBC"
permalink: "/orm/leccion11/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: por-qué-necesitamos-transacciones
  title: Por qué necesitamos transacciones
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Transacciones con JDBC

## Objetivo de aprendizaje

Agrupa dos cambios relacionados. Si ambos se completan, commit() los confirma. Si falla el segundo, rollback() revierte el primero.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/11-transacciones-jdbc.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 11">
    <img src="{{ '/assets/images/orm/infografias/11-transacciones-jdbc.webp' | relative_url }}" alt="Resumen visual de la lección 11. Transacciones con JDBC" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 11.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/11-transacciones-jdbc.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Por qué necesitamos transacciones

Una transacción agrupa operaciones que deben confirmarse o deshacerse juntas.

```java
try (Connection c = DriverManager.getConnection(url)) {
    c.setAutoCommit(false);
    try {
        // varias operaciones
        c.commit();
    } catch (SQLException e) {
        c.rollback();
        throw e;
    }
}
```

Conceptos:

```text
BEGIN → operaciones → COMMIT
                   ↘ ROLLBACK si falla
```

Esta idea reaparecerá en JPA/Hibernate: el ORM no elimina las transacciones; las hace más cómodas de gestionar.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/11-transaccion.png' | relative_url }}" alt="Ciclo de una transacción JDBC" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Agrupa cambios que deben confirmarse juntos. La transacción agrupa los cambios como una unidad.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/11-rollback.png' | relative_url }}" alt="Qué ocurre al hacer rollback" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> La segunda operación falla antes de confirmar la transacción. Comprueba en la base que el primer cambio no quedó guardado.</p>


## Ejemplo guiado

### Ejecutar dos operaciones como una unidad

1. Desactiva `autoCommit`.
2. Ejecuta dos cambios relacionados.
3. Si ambos terminan, llama a `commit()`.
4. Si uno falla, llama a `rollback()`.
5. Restaura el modo de conexión en un bloque seguro.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué garantiza una transacción?

- A) Que no haya excepciones
- B) Que un grupo de operaciones se trate como unidad
- C) Que JDBC sea ORM
- D) Que cada SQL se imprima

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Las operaciones se confirman o deshacen coherentemente.</p>

</details>

### 2. ¿Qué hace COMMIT?

- A) Confirma cambios
- B) Cierra Maven
- C) Crea una tabla
- D) Deshace cambios

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> COMMIT hace permanentes los cambios.</p>

</details>

### 3. ¿Qué hace ROLLBACK?

- A) Crea entidades
- B) Revierte cambios no confirmados
- C) Confirma
- D) Ordena filas

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> ROLLBACK vuelve al estado anterior de la transacción.</p>

</details>

### 4. ¿Por qué es importante en operaciones relacionadas?

- A) Para mantener consistencia
- B) Para evitar SELECT
- C) Para crear HTML
- D) Para usar records

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Evita estados parciales.</p>

</details>


## Ejercicio propuesto

Provoca deliberadamente un error en la segunda operación y comprueba que la primera no queda confirmada.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion10/">← 10 · Refactorizar a ProductoJdbcRepository</a>
  <a href="/orm/leccion12/">12 · Testear JDBC con SQLite temporal →</a>
</div>
