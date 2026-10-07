---
layout: "lesson"
route: "orm"
lesson_id: "leccion01"
lesson_file: "01-de-ficheros-a-bases-de-datos"
lesson_number: "01"
title: "De ficheros a bases de datos"
description: "De ficheros a bases de datos"
permalink: "/orm/leccion01/"
---

# De ficheros a bases de datos

## Punto de partida

En la ruta de ficheros persistíamos una colección completa:

```text
Producto ↔ CSV / JSON / XML
```

Ahora queremos almacenar los mismos objetos en una base de datos relacional:

```text
Producto ↔ fila de la tabla producto ↔ SQLite
```

No cambiaremos todavía `IProductoRepository`. Primero estudiaremos qué aporta una base de datos frente a reescribir un fichero completo.

## Diferencia esencial

En un fichero solemos leer o reescribir una colección. En una base de datos podemos pedir operaciones sobre filas concretas:

```sql
SELECT * FROM producto WHERE id = 2;
UPDATE producto SET precio = 29.95 WHERE id = 2;
DELETE FROM producto WHERE id = 2;
```

<div class="cla-note"><strong>Continuidad</strong><p>El dominio sigue siendo el mismo. Cambia la infraestructura de persistencia.</p></div>

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/01-evolucion-persistencia.png" alt="Evolución de la persistencia. Colección en memoria → CSV / JSON / XML → SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Colección en memoria → CSV / JSON / XML → SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/01-fichero-vs-bd.png" alt="Fichero frente a base de datos. A la izquierda se resumen rasgos habituales de persistencia en fichero; a la derecha, operaciones y capacidades que aporta una base de datos." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> A la izquierda se resumen rasgos habituales de persistencia en fichero; a la derecha, operaciones y capacidades que aporta una base de datos.</p>


## Ejemplo guiado

### Transformar una colección CSV en una tabla SQLite

1. Partimos de un `productos.csv` con `id,nombre,precio`.
2. Identificamos qué columna puede actuar como clave primaria.
3. Diseñamos `CREATE TABLE producto (id INTEGER PRIMARY KEY, nombre TEXT NOT NULL, precio REAL NOT NULL)`.
4. Comparamos una búsqueda en fichero con `SELECT ... WHERE id = ?`.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué cambia al pasar de CSV a SQLite?

- A) El modelo de dominio
- B) La infraestructura de persistencia
- C) La sintaxis de Java
- D) La JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Seguimos trabajando con los mismos objetos; cambia cómo se almacenan.</p>

</details>

### 2. ¿Qué ventaja ofrece una base de datos para actualizar un solo producto?

- A) Obliga a reescribir todo el fichero
- B) Permite operar sobre filas concretas
- C) Elimina la necesidad de identificadores
- D) No necesita consultas

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> SQL permite dirigir UPDATE o DELETE a filas concretas.</p>

</details>

### 3. ¿Qué sentencia consulta datos?

- A) SELECT
- B) INSERT
- C) UPDATE
- D) DELETE

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> SELECT recupera filas.</p>

</details>

### 4. ¿Debe desaparecer `IProductoRepository` al introducir SQLite?

- A) Sí
- B) No
- C) Solo en producción
- D) Solo si usamos Maven

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El contrato puede mantenerse mientras cambia la implementación.</p>

</details>


## Ejercicio propuesto

Dado un fichero `alumnos.csv` con `id,nombre,nota`, diseña la tabla SQL equivalente e indica qué campo usarías como clave primaria.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/">← Índice de la ruta</a>
  <a href="/orm/leccion02/">2 · SQLite y la consola sqlite3 →</a>
</div>
