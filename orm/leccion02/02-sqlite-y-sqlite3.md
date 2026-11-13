---
layout: "lesson"
route: "orm"
lesson_id: "leccion02"
lesson_file: "02-sqlite-y-sqlite3"
lesson_number: "02"
title: "SQLite y la consola sqlite3"
description: "SQLite y la consola sqlite3"
permalink: "/orm/leccion02/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: sqlite
  title: SQLite
- id: probarla-con-sqlite3
  title: Probarla con sqlite3
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# SQLite y la consola sqlite3

## Objetivo de aprendizaje

Abre una base de datos desde sqlite3, inspecciona el esquema y consulta una tabla.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/02-sqlite-y-sqlite3.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 02">
    <img src="{{ '/assets/images/orm/infografias/02-sqlite-y-sqlite3.webp' | relative_url }}" alt="Resumen visual de la lección 02. SQLite y la consola sqlite3" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 02.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/02-sqlite-y-sqlite3.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/02-sqlite-archivo.png' | relative_url }}" alt="SQLite como base de datos embebida" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El motor se ejecuta dentro del proceso que lo utiliza. SQLite no requiere un servidor de base de datos separado.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/02-sqlite3-flujo.png' | relative_url }}" alt="Explorar SQLite desde la consola" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Abre una base, inspecciona su esquema y comprueba los datos. Los comandos con punto pertenecen a la consola sqlite3.</p>


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

- A) No usa SQL
- B) Solo almacena texto
- C) Es una base embebida
- D) Necesita un servidor separado

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> SQLite se integra en la aplicación y almacena datos en un fichero.</p>

</details>

### 2. ¿Qué comando abre una base con la consola?

- A) jdbc app.db
- B) sqlite3 app.db
- C) java app.db
- D) mvn sqlite

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> `sqlite3` abre o crea el fichero indicado.</p>

</details>

### 3. ¿Qué ocurre si el fichero no existe al abrirlo con sqlite3?

- A) Siempre falla
- B) Se descarga de Internet
- C) Puede crearse al escribir la base
- D) Se convierte en CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> SQLite puede crear el fichero de base de datos.</p>

</details>

### 4. ¿Para qué usamos la consola sqlite3 en la ruta?

- A) Para generar bytecode
- B) Para probar SQL de forma directa
- C) Para sustituir Java
- D) Para compilar Hibernate

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
