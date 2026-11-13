---
layout: "lesson"
route: "orm"
lesson_id: "leccion12"
lesson_file: "12-tests-jdbc-sqlite"
lesson_number: "12"
title: "Testear JDBC con SQLite temporal"
description: "Testear JDBC con SQLite temporal"
permalink: "/orm/leccion12/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: test-con-una-base-temporal
  title: Test con una base temporal
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
- id: actividad-integradora-crud-jdbc-completo
  title: Actividad integradora · CRUD JDBC completo
---

# Testear JDBC con SQLite temporal

## Objetivo de aprendizaje

Prepara una base temporal, ejecuta una operación del repositorio y verifica su resultado en una prueba aislada.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/12-tests-jdbc-sqlite.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 12">
    <img src="{{ '/assets/images/orm/infografias/12-tests-jdbc-sqlite.webp' | relative_url }}" alt="Resumen visual de la lección 12. Testear JDBC con SQLite temporal" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 12.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/12-tests-jdbc-sqlite.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Test con una base temporal

Con JUnit podemos usar `@TempDir`:

```java
@TempDir
Path tempDir;

@Test
void crudCompletoJdbc() {
    Path db = tempDir.resolve("test.db");
    String url = "jdbc:sqlite:" + db;

    DatabaseInitializer.createSchema(url);
    IProductoRepository repo = new ProductoJdbcRepository(url);

    repo.create(new Producto(1, "Teclado", 30));
    assertTrue(repo.findById(1L).isPresent());

    assertTrue(repo.update(new Producto(1, "Teclado", 35)));
    assertEquals(35, repo.findById(1L).orElseThrow().precio());

    assertTrue(repo.delete(1L));
    assertTrue(repo.findAll().isEmpty());
}
```

Cada test trabaja contra una base SQLite real y aislada.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/12-test-sqlite.png' | relative_url }}" alt="Probar un repositorio JDBC" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Una base temporal permite comprobar el acceso real a datos. Libera conexiones y elimina los recursos temporales.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/12-aaa.png' | relative_url }}" alt="Arrange, Act, Assert" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Tres fases de un test, ilustradas con un producto. Cada fase ayuda a localizar por qué falla la prueba.</p>


## Ejemplo guiado

### Testear create y findById

1. Crea una base temporal para el test.
2. Inicializa el esquema.
3. Crea el repositorio.
4. Inserta un Producto.
5. Recupéralo y compara sus datos.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Por qué usar SQLite temporal?

- A) Para eliminar JUnit
- B) Para compartir datos entre tests
- C) Para compilar SQL
- D) Para aislar pruebas

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Cada test puede partir de un estado controlado.</p>

</details>

### 2. ¿Qué significa Arrange?

- A) Borrar Maven
- B) Preparar contexto
- C) Comprobar resultado
- D) Ejecutar operación

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Arrange prepara los datos y dependencias.</p>

</details>

### 3. ¿Qué debería evitar un test de repositorio?

- A) Usar asserts
- B) Ser repetible
- C) Depender de datos dejados por otro test
- D) Verificar resultados

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Los tests deben ser independientes.</p>

</details>

### 4. ¿Qué estamos probando aquí?

- A) Integración repositorio-JDBC-SQLite
- B) Solo getters
- C) JVM
- D) HTML

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El test cruza varias capas de infraestructura.</p>

</details>


## Ejercicio propuesto

Añade tests independientes para update, delete e intento de insertar un id duplicado.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


## Actividad integradora · CRUD JDBC completo

**Modalidad:** tarea integradora de bloque.

Construye un pequeño gestor de productos con `IProductoRepository` y `ProductoJdbcRepository`, transacciones donde sean necesarias y tests sobre SQLite temporal.

### Evidencias

- Proyecto reproducible.
- README con instrucciones de ejecución.
- Pruebas realizadas.
- Explicación de problemas encontrados y cómo se resolvieron.


<div class="cla-lesson-nav">
  <a href="/orm/leccion11/">← 11 · Transacciones con JDBC</a>
  <a href="/orm/leccion13/">13 · El problema del mapeo objeto-relacional →</a>
</div>
