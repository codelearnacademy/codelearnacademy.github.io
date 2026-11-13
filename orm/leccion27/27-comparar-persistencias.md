---
layout: "lesson"
route: "orm"
lesson_id: "leccion27"
lesson_file: "27-comparar-persistencias"
lesson_number: "27"
title: "Comparar ficheros, JDBC y ORM"
description: "Comparar ficheros, JDBC y ORM"
permalink: "/orm/leccion27/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: cinco-implementaciones-un-contrato
  title: Cinco implementaciones, un contrato
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Comparar ficheros, JDBC y ORM

## Objetivo de aprendizaje

Compara ficheros, JDBC y ORM según las consultas, las transacciones y el trabajo de mapeo.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/27-comparar-persistencias.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 27">
    <img src="{{ '/assets/images/orm/infografias/27-comparar-persistencias.webp' | relative_url }}" alt="Resumen visual de la lección 27. Comparar ficheros, JDBC y ORM" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 27.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/27-comparar-persistencias.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/27-strategies.png' | relative_url }}" alt="Elegir una estrategia de persistencia" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Compara el trabajo necesario para guardar y recuperar productos. La elección depende del acceso a datos y del coste de configuración.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/27-contract.png' | relative_url }}" alt="Un contrato para varias estrategias" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El código cliente solicita las mismas operaciones. Las pruebas de contrato ayudan a comparar el comportamiento.</p>


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
- B) No tener dominio
- C) Usar siempre Hibernate
- D) La misma URL JDBC

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La interfaz desacopla cliente e infraestructura.</p>

</details>

### 2. ¿Qué estrategia suele ser más simple para datos pequeños y portables?

- A) Ninguna
- B) Un servidor remoto siempre
- C) Ficheros estructurados
- D) ORM siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> CSV/JSON/XML pueden ser suficientes en casos sencillos.</p>

</details>

### 3. ¿Qué estrategia ofrece mayor control SQL directo?

- A) record
- B) JDBC
- C) ORM
- D) JSON

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> JDBC expone las sentencias explícitamente.</p>

</details>

### 4. ¿Qué estrategia automatiza más mapping?

- A) sqlite3 CLI
- B) JDBC
- C) CSV manual
- D) ORM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Ese es el objetivo principal del ORM.</p>

</details>


## Ejercicio propuesto

Elabora una matriz de decisión para elegir ficheros, JDBC u ORM en tres proyectos distintos y justifica la elección.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion26/">← 26 · Tests ORM con SQLite</a>
  <a href="/orm/leccion28/">28 · Proyecto final PersistenceLab →</a>
</div>

---
