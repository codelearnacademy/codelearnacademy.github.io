---
layout: "lesson"
route: "orm"
lesson_id: "leccion17"
lesson_file: "17-properties-configuracion-orm"
lesson_number: "17"
title: ".properties y configuración ORM"
description: ".properties y configuración ORM"
permalink: "/orm/leccion17/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: mantener-properties
  title: Mantener .properties
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
- id: actividad-integradora-preparar-la-capa-orm
  title: Actividad integradora · Preparar la capa ORM
---

# .properties y configuración ORM

## Objetivo de aprendizaje

Localiza los ajustes de conexión, dialecto y gestión del esquema en la configuración del ORM.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/17-properties-configuracion-orm.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 17">
    <img src="{{ '/assets/images/orm/infografias/17-properties-configuracion-orm.webp' | relative_url }}" alt="Resumen visual de la lección 17. .properties y configuración ORM" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 17.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/17-properties-configuracion-orm.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Mantener `.properties`

Seguimos externalizando la configuración:

```properties
database.url=jdbc:sqlite:data/orm.db
hibernate.dialect=org.hibernate.community.dialect.SQLiteDialect
hibernate.hbm2ddl.auto=update
hibernate.show_sql=true
hibernate.format_sql=true
```

`OrmConfig` lee el fichero y crea las propiedades de JPA/Hibernate. El `persistence.xml` contiene el proveedor y las clases entidad, mientras que URL y opciones se pueden sobreescribir desde `.properties`.

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "sqlitePU",
        ormConfig.toJpaProperties());
```

La misma idea de la ruta de ficheros se mantiene: **la configuración cambia sin recompilar el código Java**.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/17-properties.png' | relative_url }}" alt="Configuración externa del ORM" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Los ajustes se leen al construir la infraestructura. Puedes cambiar la configuración sin recompilar las clases.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/17-entornos.png' | relative_url }}" alt="Configuración por entorno" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Revisa la URL, los datos y la gestión del esquema en cada entorno. Verifica a qué base apunta la URL antes de ejecutar escrituras.</p>


## Ejemplo guiado

### Externalizar la URL de SQLite

1. Define una propiedad para `jdbc:sqlite:data/app.db`.
2. Léela desde `RepositoryConfig` u `OrmConfig`.
3. Úsala al construir la configuración ORM.
4. Cambia solo el properties para apuntar a una base de test.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué ventaja tiene .properties?

- A) Sustituir JPA
- B) Crear tablas automáticamente siempre
- C) Separar configuración del código
- D) Eliminar Maven

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Permite cambiar entorno sin recompilar lógica.</p>

</details>

### 2. ¿Qué debería evitarse hardcodear?

- A) El nombre de una variable local
- B) Una interfaz
- C) Un comentario
- D) La URL de base de datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La ubicación de la base es configuración.</p>

</details>

### 3. ¿Puede test usar otra base sin cambiar repositorio?

- A) Sí
- B) Solo con Spring
- C) No
- D) Solo con CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La configuración externa permite variar infraestructura.</p>

</details>

### 4. ¿Debe contener .properties reglas de negocio?

- A) Solo las de Producto
- B) No
- C) Solo en test
- D) Sí

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Es un mecanismo de configuración, no de dominio.</p>

</details>


## Ejercicio propuesto

Crea `test.properties` que use otra base SQLite y explica qué valores deben variar respecto a desarrollo.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


## Actividad integradora · Preparar la capa ORM

**Modalidad:** tarea integradora de bloque.

Configura Hibernate + SQLite, crea `ProductoEntity`, separa dominio y persistencia y externaliza la configuración en `.properties`.

### Evidencias

- Proyecto reproducible.
- README con instrucciones de ejecución.
- Pruebas realizadas.
- Explicación de problemas encontrados y cómo se resolvieron.


<div class="cla-lesson-nav">
  <a href="/orm/leccion16/">← 16 · Dominio record frente a entidad JPA</a>
  <a href="/orm/leccion18/">18 · ProductoMapper: dominio y persistencia →</a>
</div>

---
