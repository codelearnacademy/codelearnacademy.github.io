---
layout: "lesson"
route: "orm"
lesson_id: "leccion02"
lesson_file: "02-sqlite-y-sqlite3"
lesson_number: "02"
title: "SQLite y la consola sqlite3"
description: "SQLite y la consola sqlite3"
permalink: "/orm/leccion02/"
---

# SQLite y la consola sqlite3

## SQLite

SQLite es una base de datos relacional embebida. No necesitamos levantar un servidor: toda la base puede vivir en un fichero como `data/app.db`.

```text
ficheros/data/productos.csv
            ↓
orm/data/app.db
```

## Probarla con `sqlite3`

```bash
sqlite3 data/app.db
```

Dentro de la consola:

```sql
.tables
.schema
.quit
```

Crear nuestra primera tabla:

```sql
CREATE TABLE producto (
    id INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    precio REAL NOT NULL CHECK (precio >= 0)
);
```

Insertar y consultar:

```sql
INSERT INTO producto(id, nombre, precio)
VALUES (1, 'Teclado', 35.50);

SELECT * FROM producto;
```

El fichero `app.db` sustituye al conjunto de ficheros de datos, pero conserva persistencia entre ejecuciones.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/02-sqlite-archivo.png" alt="SQLite como base de datos embebida. Aplicación → Motor SQLite → app.db." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Aplicación → Motor SQLite → app.db.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/02-sqlite3-flujo.png" alt="Flujo de trabajo con sqlite3. sqlite3 app.db → SQL → Comprobar resultados." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> sqlite3 app.db → SQL → Comprobar resultados.</p>


## Ejemplo guiado

### Crear una base SQLite desde la consola

1. Ejecuta `sqlite3 data/app.db`.
2. Crea una tabla `producto`.
3. Inserta dos filas con `INSERT`.
4. Comprueba los datos con `SELECT * FROM producto;`.
5. Sal de la consola y verifica que `app.db` existe.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué característica define a SQLite?

- A) Necesita un servidor separado
- B) Es una base embebida
- C) Solo almacena texto
- D) No usa SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> SQLite se integra en la aplicación y almacena datos en un fichero.</p>

</details>

### 2. ¿Qué comando abre una base con la consola?

- A) java app.db
- B) sqlite3 app.db
- C) mvn sqlite
- D) jdbc app.db

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> `sqlite3` abre o crea el fichero indicado.</p>

</details>

### 3. ¿Qué ocurre si el fichero no existe al abrirlo con sqlite3?

- A) Siempre falla
- B) Puede crearse al escribir la base
- C) Se descarga de Internet
- D) Se convierte en CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> SQLite puede crear el fichero de base de datos.</p>

</details>

### 4. ¿Para qué usamos la consola sqlite3 en la ruta?

- A) Para sustituir Java
- B) Para probar SQL de forma directa
- C) Para compilar Hibernate
- D) Para generar bytecode

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Permite aislar y entender SQL antes de introducir JDBC.</p>

</details>


## Ejercicio propuesto

Crea `vehiculos.db` con una tabla `vehiculo(matricula, marca, modelo, anio)` y añade tres vehículos.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion01/">← 1 · De ficheros a bases de datos</a>
  <a href="/orm/leccion03/">3 · Modelo relacional: Producto y Vehiculo →</a>
</div>
