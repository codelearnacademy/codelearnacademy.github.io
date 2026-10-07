---
layout: "lesson"
route: "orm"
lesson_id: "leccion27"
lesson_file: "27-comparar-persistencias"
lesson_number: "27"
title: "Comparar ficheros, JDBC y ORM"
description: "Comparar ficheros, JDBC y ORM"
permalink: "/orm/leccion27/"
---

# Comparar ficheros, JDBC y ORM

## Cinco implementaciones, un contrato

Al terminar las dos rutas podemos tener:

```text
IProductoRepository
 ├─ ProductoCsvRepository
 ├─ ProductoJsonRepository
 ├─ ProductoXmlRepository
 ├─ ProductoJdbcRepository
 └─ ProductoOrmRepository
```

Esto permite comparar responsabilidades:

```text
CSV/JSON/XML → serialización de una colección
JDBC         → SQL escrito manualmente
ORM          → mapeo y SQL gestionados por Hibernate
```

La interfaz no cambia. Esa es la conexión arquitectónica más importante entre ambas rutas.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/27-strategies.png" alt="Estrategias de persistencia. CSV / JSON / XML → JDBC + SQLite → ORM + Hibernate + SQLite." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> CSV / JSON / XML → JDBC + SQLite → ORM + Hibernate + SQLite.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/27-contract.png" alt="Un contrato común. Código cliente → IProductoRepository → Implementaciones intercambiables." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Código cliente → IProductoRepository → Implementaciones intercambiables.</p>


## Ejemplo guiado

### Cambiar implementación sin cambiar el cliente

1. Escribe un método que reciba IProductoRepository.
2. Pruébalo con ProductoCsvRepository.
3. Pruébalo con ProductoJdbcRepository.
4. Pruébalo con ProductoOrmRepository.
5. Comprueba que el método cliente no cambia.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué permite intercambiar estrategias?

- A) El contrato común
- B) La misma URL JDBC
- C) Usar siempre Hibernate
- D) No tener dominio

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La interfaz desacopla cliente e infraestructura.</p>

</details>

### 2. ¿Qué estrategia suele ser más simple para datos pequeños y portables?

- A) Ficheros estructurados
- B) ORM siempre
- C) Un servidor remoto siempre
- D) Ninguna

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> CSV/JSON/XML pueden ser suficientes en casos sencillos.</p>

</details>

### 3. ¿Qué estrategia ofrece mayor control SQL directo?

- A) JDBC
- B) ORM
- C) JSON
- D) record

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> JDBC expone las sentencias explícitamente.</p>

</details>

### 4. ¿Qué estrategia automatiza más mapping?

- A) ORM
- B) JDBC
- C) CSV manual
- D) sqlite3 CLI

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Ese es el objetivo principal del ORM.</p>

</details>


## Ejercicio propuesto

Elabora una matriz de decisión para elegir ficheros, JDBC u ORM en tres proyectos distintos y justifica la elección.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion26/">← 26 · Tests ORM con SQLite</a>
  <a href="/orm/leccion28/">28 · Proyecto final PersistenceLab →</a>
</div>
