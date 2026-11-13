---
layout: "lesson"
route: "orm"
lesson_id: "leccion13"
lesson_file: "13-problema-mapeo-objeto-relacional"
lesson_number: "13"
title: "El problema del mapeo objeto-relacional"
description: "El problema del mapeo objeto-relacional"
permalink: "/orm/leccion13/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: qué-se-repite-en-jdbc
  title: ¿Qué se repite en JDBC?
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# El problema del mapeo objeto-relacional

## Objetivo de aprendizaje

Identifica qué trabajo requiere traducir entre objetos Java y filas de una tabla.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/13-problema-mapeo-objeto-relacional.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 13">
    <img src="{{ '/assets/images/orm/infografias/13-problema-mapeo-objeto-relacional.webp' | relative_url }}" alt="Resumen visual de la lección 13. El problema del mapeo objeto-relacional" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 13.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/13-problema-mapeo-objeto-relacional.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/13-mapeo-manual.png' | relative_url }}" alt="De ResultSet a objeto de dominio" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El código JDBC convierte cada fila de manera explícita. El mismo tipo de conversión reaparece en las consultas.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/13-codigo-repetido.png' | relative_url }}" alt="Qué se repite con JDBC" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Un listado y una búsqueda por ID comparten varias tareas. Un mapper puede centralizar la conversión; un ORM automatiza parte del trabajo.</p>


## Ejemplo guiado

### Localizar el mapping repetido

1. Revisa `findAll` y `findById`.
2. Marca las llamadas `getLong`, `getString`, `getDouble`.
3. Observa que el mismo conocimiento de columnas aparece varias veces.
4. Identifica qué parte podría declararse una sola vez.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Cuál es el problema central que introduce ORM?

- A) Ausencia de clases
- B) Falta de JVM
- C) Repetición del mapeo objeto-relacional
- D) No poder usar SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> JDBC obliga a mapear filas y objetos manualmente.</p>

</details>

### 2. ¿Qué información se repite?

- A) Nombres de campos/columnas y conversiones
- B) URLs web
- C) Solo comentarios
- D) Versiones de Java

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El mismo esquema se expresa en varios puntos.</p>

</details>

### 3. ¿ORM elimina siempre toda necesidad de SQL?

- A) Solo en Java 21
- B) No
- C) Sí
- D) Solo en SQLite

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Puede generar SQL, pero entender SQL y modelo relacional sigue siendo importante.</p>

</details>

### 4. ¿Por qué estudiamos JDBC antes de ORM?

- A) Para no usar Maven
- B) Porque Hibernate no funciona
- C) Para evitar entidades
- D) Para ver el problema que ORM intenta resolver

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Da contexto y evita tratar ORM como magia.</p>

</details>


## Ejercicio propuesto

Haz una lista de responsabilidades repetidas en ProductoJdbcRepository que un ORM podría automatizar.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion12/">← 12 · Testear JDBC con SQLite temporal</a>
  <a href="/orm/leccion14/">14 · Qué es un ORM: JPA y Hibernate →</a>
</div>

---
