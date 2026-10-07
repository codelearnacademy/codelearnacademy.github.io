---
layout: "lesson"
route: "orm"
lesson_id: "leccion17"
lesson_file: "17-properties-configuracion-orm"
lesson_number: "17"
title: ".properties y configuración ORM"
description: ".properties y configuración ORM"
permalink: "/orm/leccion17/"
---

# .properties y configuración ORM

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/17-properties.png" alt="Configuración externa. application.properties → OrmConfig → EntityManagerFactory." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> application.properties → OrmConfig → EntityManagerFactory.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/17-entornos.png" alt="Configuración por entorno. desarrollo → test → producción." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> desarrollo → test → producción.</p>


## Ejemplo guiado

### Externalizar la URL de SQLite

1. Define una propiedad para `jdbc:sqlite:data/app.db`.
2. Léela desde `RepositoryConfig` u `OrmConfig`.
3. Úsala al construir la configuración ORM.
4. Cambia solo el properties para apuntar a una base de test.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué ventaja tiene .properties?

- A) Separar configuración del código
- B) Eliminar Maven
- C) Crear tablas automáticamente siempre
- D) Sustituir JPA

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Permite cambiar entorno sin recompilar lógica.</p>

</details>

### 2. ¿Qué debería evitarse hardcodear?

- A) La URL de base de datos
- B) El nombre de una variable local
- C) Un comentario
- D) Una interfaz

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La ubicación de la base es configuración.</p>

</details>

### 3. ¿Puede test usar otra base sin cambiar repositorio?

- A) Sí
- B) No
- C) Solo con CSV
- D) Solo con Spring

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La configuración externa permite variar infraestructura.</p>

</details>

### 4. ¿Debe contener .properties reglas de negocio?

- A) Sí
- B) No
- C) Solo las de Producto
- D) Solo en test

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
