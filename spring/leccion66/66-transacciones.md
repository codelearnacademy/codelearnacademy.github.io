---
layout: lesson
route: spring
lesson_id: leccion66
lesson_file: 66-transacciones
lesson_number: "66"
title: Transacciones
description: Comprueba que un fallo revierte una escritura dentro de una transacción.
permalink: /spring/leccion66/
lessons:
  - id: práctica-con-sqlite3
    title: Práctica con SQLite3
  - id: comprueba-lo-aprendido
    title: Comprueba lo aprendido
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Transacciones

Comprueba que un fallo revierte una escritura dentro de una transacción.

## Práctica con SQLite3

Usa el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}) para continuar la práctica de las lecciones 61–67.

El servicio delimita la operación de escritura con `@Transactional`. Desde la prueba, `TransactionTemplate` abre una transacción y el servicio participa en ella. La prueba consulta la fila antes de provocar el fallo y vuelve a consultar tras el rollback.

```java
transacciones.executeWithoutResult(estado -> {
    servicio.crear("Tarea revertida", categoria);
    assertEquals(1L, contarTareasRevertidas());
    throw new IllegalStateException("Fallo simulado después de guardar");
});
```

**Ejercicio breve.** Predice cuántas filas devuelve la consulta dentro de la transacción y cuántas después de revertir. Ejecuta:

```sh
mvn -Dtest=PersistenciaSqliteTest#revierteLaInsercionSiLaOperacionFalla test
```

La prueba espera una fila antes del fallo y cero después. Consulta la implementación para localizar dónde se abre y dónde termina la transacción.

## Comprueba lo aprendido

Repite el ejercicio cambiando un dato de entrada o usando un archivo nuevo para la migración. Registra el resultado esperado y lo observado en la API, en la consulta SQL o en la prueba.

<div class="cla-lesson-nav">
  <a href="/spring/leccion65/">← 65 · Relaciones entre entidades</a>
  <a href="/spring/leccion67/">67 · Migraciones de base de datos →</a>
</div>
