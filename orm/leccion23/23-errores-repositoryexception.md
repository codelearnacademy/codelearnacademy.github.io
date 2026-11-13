---
layout: "lesson"
route: "orm"
lesson_id: "leccion23"
lesson_file: "23-errores-repositoryexception"
lesson_number: "23"
title: "Errores y RepositoryException en ORM"
description: "Errores y RepositoryException en ORM"
permalink: "/orm/leccion23/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: errores-de-persistencia
  title: Errores de persistencia
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Errores y RepositoryException en ORM

## Objetivo de aprendizaje

Gestiona el fallo de una operación de persistencia y conserva su causa al propagar el error.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/23-errores-repositoryexception.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 23">
    <img src="{{ '/assets/images/orm/infografias/23-errores-repositoryexception.webp' | relative_url }}" alt="Resumen visual de la lección 23. Errores y RepositoryException en ORM" width="1235" height="1274" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 23.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/23-errores-repositoryexception.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/23-exceptions.png' | relative_url }}" alt="Traducir errores de persistencia" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> El repositorio comunica los fallos sin perder información. La causa original permite diagnosticar el fallo.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/23-boundary.png' | relative_url }}" alt="La frontera de infraestructura" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Cada capa trabaja con tipos adecuados a su responsabilidad. Evita acoplar al cliente a tipos internos del proveedor.</p>


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
- C) Para convertir SQL en JSON
- D) Para evitar rollback

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El contrato de aplicación no debe depender de Hibernate.</p>

</details>

### 2. ¿Qué debe conservar RepositoryException?

- A) Una imagen
- B) El EntityManager abierto
- C) Solo un mensaje vacío
- D) La causa original

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Conservar la causa ayuda al diagnóstico.</p>

</details>

### 3. ¿Qué debemos hacer con una transacción fallida?

- A) Rollback
- B) Ignorar
- C) Crear otra tabla
- D) Commit siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Debe revertirse el trabajo parcial.</p>

</details>

### 4. ¿Dónde se realiza la traducción?

- A) En javac
- B) En CSS
- C) En el record Producto
- D) En la frontera del repositorio

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> El repositorio encapsula infraestructura.</p>

</details>


## Ejercicio propuesto

Provoca una violación de identificador duplicado y verifica que el cliente recibe RepositoryException, no una excepción de Hibernate.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion22/">← 22 · ProductoOrmRepository: CRUD completo</a>
  <a href="/orm/leccion24/">24 · Comparar el CRUD JDBC y ORM →</a>
</div>

---
