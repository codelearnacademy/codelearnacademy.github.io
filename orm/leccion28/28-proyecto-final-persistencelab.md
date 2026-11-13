---
layout: "lesson"
route: "orm"
lesson_id: "leccion28"
lesson_file: "28-proyecto-final-persistencelab"
lesson_number: "28"
title: "Proyecto final PersistenceLab"
description: "Proyecto final PersistenceLab"
permalink: "/orm/leccion28/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: proyecto-final-persistencelab
  title: 'Proyecto final: PersistenceLab'
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
- id: tarea-final-para-casa-persistencelab
  title: Tarea final para casa · PersistenceLab
---

# Proyecto final PersistenceLab

## Objetivo de aprendizaje

Planifica PersistenceLab y relaciona sus capas con entregables que puedan verificarse.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/28-proyecto-final-persistencelab.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 28">
    <img src="{{ '/assets/images/orm/infografias/28-proyecto-final-persistencelab.webp' | relative_url }}" alt="Resumen visual de la lección 28. Proyecto final PersistenceLab" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 28.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/28-proyecto-final-persistencelab.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Proyecto final: `PersistenceLab`

Construye una aplicación que pueda ejecutar el mismo CRUD de `Producto` y `Vehiculo` sobre SQLite.

### Requisitos mínimos

1. Mantener `IRepository<T, ID>`, `IProductoRepository` e `IVehiculoRepository`.
2. Implementar `ProductoJdbcRepository`.
3. Implementar `ProductoOrmRepository` y `VehiculoOrmRepository`.
4. Mantener `Producto` y `Vehiculo` como modelos de dominio.
5. Utilizar entidades JPA separadas.
6. Leer URL y opciones de Hibernate desde `.properties`.
7. Incluir tests CRUD completos con bases SQLite temporales.

### Retos

- Añadir una entidad `Categoria` y una relación `@ManyToOne`.
- Activar el log SQL y relacionar cada operación JPA con el SQL generado.
- Comparar rendimiento y número de sentencias de JDBC y ORM.
- Investigar `LAZY`, `EAGER` y el problema N+1.
- Introducir una migración de esquema en lugar de depender de `hbm2ddl.auto`.

<div class="cla-note"><strong>Objetivo final</strong><p>Elegir conscientemente entre serialización, JDBC y ORM entendiendo qué responsabilidad asume cada tecnología.</p></div>

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/28-architecture.png' | relative_url }}" alt="Arquitectura de PersistenceLab" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Diferentes repositorios dan acceso al mismo dominio. Demuestra el CRUD y comprueba los resultados persistidos.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/28-packages.png' | relative_url }}" alt="Paquetes de PersistenceLab" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Organiza el código por responsabilidad. Localiza cada clase por la responsabilidad que le corresponde.</p>


## Ejemplo guiado

### Planificar PersistenceLab por iteraciones

1. Iteración 1: esquema y CRUD JDBC.
2. Iteración 2: refactorización a repositorios.
3. Iteración 3: entidades, mapper y ORM.
4. Iteración 4: Vehiculo y generalización.
5. Iteración 5: tests y comparación final.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué debe demostrar el proyecto final?

- A) Solo una clase main
- B) La evolución JDBC → repositorio → ORM
- C) Solo sintaxis SQL
- D) Solo Maven

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Integra toda la progresión de la ruta.</p>

</details>

### 2. ¿Qué contrato debe mantenerse?

- A) ResultSet
- B) Statement
- C) IRepository y sus especializaciones
- D) sqlite3 CLI

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El diseño se apoya en el mismo contrato.</p>

</details>

### 3. ¿Qué dos implementaciones relacionales se comparan?

- A) Git y Maven
- B) CSV y XML únicamente
- C) JVM y JDK
- D) JDBC y ORM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> El proyecto culmina comparando JDBC y Hibernate.</p>

</details>

### 4. ¿Qué evidencia debe incluir una entrega sólida?

- A) Código, tests y README
- B) Solo capturas
- C) Solo el .db
- D) Solo el pom.xml

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La entrega debe ser reproducible y verificable.</p>

</details>

### 5. ¿Qué criterio arquitectónico resume la ruta?

- A) Guardar todo en memoria
- B) Cambiar infraestructura sin cambiar el cliente
- C) Acoplar Main a Hibernate
- D) Evitar interfaces

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Ese desacoplamiento conecta Ficheros, JDBC y ORM.</p>

</details>


## Ejercicio propuesto

Construye PersistenceLab entregando README, tests y una comparación razonada de las dos implementaciones relacionales.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


## Tarea final para casa · PersistenceLab

**Modalidad:** tarea integradora de bloque.

Entrega el proyecto final completo con Producto y Vehiculo, implementaciones JDBC y ORM, SQLite, tests, README de ejecución y una comparación razonada de estrategias.

### Evidencias

- Proyecto reproducible.
- README con instrucciones de ejecución.
- Pruebas realizadas.
- Explicación de problemas encontrados y cómo se resolvieron.


<div class="cla-lesson-nav">
  <a href="/orm/leccion27/">← 27 · Comparar ficheros, JDBC y ORM</a>
  <a href="/orm/">Volver a la ruta →</a>
</div>

---
