---
layout: "lesson"
route: "orm"
lesson_id: "leccion23"
lesson_file: "23-errores-repositoryexception"
lesson_number: "23"
title: "Errores y RepositoryException en ORM"
description: "Errores y RepositoryException en ORM"
permalink: "/orm/leccion23/"
---

# Errores y RepositoryException en ORM

## Errores de persistencia

Igual que CSV/JSON/XML y JDBC, la implementación controla sus errores de infraestructura.

```java
try {
    // operación ORM
} catch (RuntimeException e) {
    throw new RepositoryException(
            "Error actualizando producto", e);
}
```

Las interfaces siguen limpias:

```java
boolean update(Producto producto);
```

No declaramos `SQLException`, excepciones de Hibernate ni detalles de SQLite en `IProductoRepository`.

<div class="cla-note"><strong>Regla arquitectónica</strong><p>Las excepciones técnicas no deben obligar al código cliente a saber cómo se persisten los datos.</p></div>

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/23-exceptions.png" alt="Traducción de excepciones. PersistenceException → ProductoOrmRepository → RepositoryException → Cliente." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> PersistenceException → ProductoOrmRepository → RepositoryException → Cliente.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/23-boundary.png" alt="Frontera de infraestructura. Hibernate/JPA → Repositorio → Dominio / aplicación." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Hibernate/JPA → Repositorio → Dominio / aplicación.</p>


## Ejemplo guiado

### Traducir un error de persistencia

1. Provoca una operación inválida.
2. Captura la excepción de infraestructura dentro del repositorio.
3. Haz rollback si la transacción está activa.
4. Lanza `RepositoryException` con contexto y causa.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Por qué traducir excepciones?

- A) Para no filtrar detalles de infraestructura al cliente
- B) Para ocultar todos los errores
- C) Para evitar rollback
- D) Para convertir SQL en JSON

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El contrato de aplicación no debe depender de Hibernate.</p>

</details>

### 2. ¿Qué debe conservar RepositoryException?

- A) La causa original
- B) Solo un mensaje vacío
- C) El EntityManager abierto
- D) Una imagen

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Conservar la causa ayuda al diagnóstico.</p>

</details>

### 3. ¿Qué debemos hacer con una transacción fallida?

- A) Rollback
- B) Commit siempre
- C) Ignorar
- D) Crear otra tabla

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Debe revertirse el trabajo parcial.</p>

</details>

### 4. ¿Dónde se realiza la traducción?

- A) En la frontera del repositorio
- B) En el record Producto
- C) En CSS
- D) En javac

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El repositorio encapsula infraestructura.</p>

</details>


## Ejercicio propuesto

Provoca una violación de identificador duplicado y verifica que el cliente recibe RepositoryException, no una excepción de Hibernate.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion22/">← 22 · ProductoOrmRepository: CRUD completo</a>
  <a href="/orm/leccion24/">24 · Comparar el CRUD JDBC y ORM →</a>
</div>
