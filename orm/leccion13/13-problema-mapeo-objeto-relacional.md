---
layout: "lesson"
route: "orm"
lesson_id: "leccion13"
lesson_file: "13-problema-mapeo-objeto-relacional"
lesson_number: "13"
title: "El problema del mapeo objeto-relacional"
description: "El problema del mapeo objeto-relacional"
permalink: "/orm/leccion13/"
---

# El problema del mapeo objeto-relacional

## ¿Qué se repite en JDBC?

Nuestro repositorio contiene mucho código que no pertenece al dominio:

```text
abrir Connection
preparar SQL
asignar parámetros
recorrer ResultSet
leer nombre de columnas
construir objetos
controlar SQLException
cerrar recursos
```

El fragmento:

```java
new Producto(
    rs.getLong("id"),
    rs.getString("nombre"),
    rs.getDouble("precio"))
```

es un mapeo manual entre dos modelos distintos:

```text
objetos Java ↔ modelo relacional
```

Un ORM intenta automatizar gran parte de esta correspondencia.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/13-mapeo-manual.png" alt="Mapeo manual repetitivo. ResultSet → getXxx por columna → Constructor de entidad de dominio." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> ResultSet → getXxx por columna → Constructor de entidad de dominio.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/13-codigo-repetido.png" alt="Qué repetimos con JDBC. SQL → Extracción de columnas → Conversión objeto ↔ fila." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> SQL → Extracción de columnas → Conversión objeto ↔ fila.</p>


## Ejemplo guiado

### Localizar el mapping repetido

1. Revisa `findAll` y `findById`.
2. Marca las llamadas `getLong`, `getString`, `getDouble`.
3. Observa que el mismo conocimiento de columnas aparece varias veces.
4. Identifica qué parte podría declararse una sola vez.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Cuál es el problema central que introduce ORM?

- A) No poder usar SQL
- B) Repetición del mapeo objeto-relacional
- C) Falta de JVM
- D) Ausencia de clases

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> JDBC obliga a mapear filas y objetos manualmente.</p>

</details>

### 2. ¿Qué información se repite?

- A) Nombres de campos/columnas y conversiones
- B) Solo comentarios
- C) Versiones de Java
- D) URLs web

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El mismo esquema se expresa en varios puntos.</p>

</details>

### 3. ¿ORM elimina siempre toda necesidad de SQL?

- A) Sí
- B) No
- C) Solo en SQLite
- D) Solo en Java 21

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Puede generar SQL, pero entender SQL y modelo relacional sigue siendo importante.</p>

</details>

### 4. ¿Por qué estudiamos JDBC antes de ORM?

- A) Para ver el problema que ORM intenta resolver
- B) Porque Hibernate no funciona
- C) Para evitar entidades
- D) Para no usar Maven

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Da contexto y evita tratar ORM como magia.</p>

</details>


## Ejercicio propuesto

Haz una lista de responsabilidades repetidas en ProductoJdbcRepository que un ORM podría automatizar.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion12/">← 12 · Testear JDBC con SQLite temporal</a>
  <a href="/orm/leccion14/">14 · Qué es un ORM: JPA y Hibernate →</a>
</div>
