---
layout: "lesson"
route: "orm"
lesson_id: "leccion11"
lesson_file: "11-transacciones-jdbc"
lesson_number: "11"
title: "Transacciones con JDBC"
description: "Transacciones con JDBC"
permalink: "/orm/leccion11/"
---

# Transacciones con JDBC

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/11-transaccion.png" alt="Ciclo de una transacción. BEGIN / autoCommit=false → Varias operaciones → COMMIT o ROLLBACK." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> BEGIN / autoCommit=false → Varias operaciones → COMMIT o ROLLBACK.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/11-rollback.png" alt="Qué ocurre ante un fallo. Operación 1 correcta → Operación 2 falla → ROLLBACK restaura consistencia." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Operación 1 correcta → Operación 2 falla → ROLLBACK restaura consistencia.</p>


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

- A) Que cada SQL se imprima
- B) Que un grupo de operaciones se trate como unidad
- C) Que no haya excepciones
- D) Que JDBC sea ORM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Las operaciones se confirman o deshacen coherentemente.</p>

</details>

### 2. ¿Qué hace COMMIT?

- A) Deshace cambios
- B) Confirma cambios
- C) Cierra Maven
- D) Crea una tabla

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> COMMIT hace permanentes los cambios.</p>

</details>

### 3. ¿Qué hace ROLLBACK?

- A) Confirma
- B) Revierte cambios no confirmados
- C) Ordena filas
- D) Crea entidades

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> ROLLBACK vuelve al estado anterior de la transacción.</p>

</details>

### 4. ¿Por qué es importante en operaciones relacionadas?

- A) Para mantener consistencia
- B) Para usar records
- C) Para evitar SELECT
- D) Para crear HTML

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
