---
layout: "lesson"
route: "orm"
lesson_id: "leccion12"
lesson_file: "12-tests-jdbc-sqlite"
lesson_number: "12"
title: "Testear JDBC con SQLite temporal"
description: "Testear JDBC con SQLite temporal"
permalink: "/orm/leccion12/"
---

# Testear JDBC con SQLite temporal

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

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/12-test-sqlite.png" alt="Test de repositorio JDBC. JUnit → Repositorio JDBC → SQLite temporal." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> JUnit → Repositorio JDBC → SQLite temporal.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/12-aaa.png" alt="Estructura de un test. Arrange → Act → Assert." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Arrange → Act → Assert.</p>


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

- A) Para compartir datos entre tests
- B) Para aislar pruebas
- C) Para eliminar JUnit
- D) Para compilar SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Cada test puede partir de un estado controlado.</p>

</details>

### 2. ¿Qué significa Arrange?

- A) Ejecutar operación
- B) Preparar contexto
- C) Comprobar resultado
- D) Borrar Maven

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Arrange prepara los datos y dependencias.</p>

</details>

### 3. ¿Qué debería evitar un test de repositorio?

- A) Ser repetible
- B) Depender de datos dejados por otro test
- C) Verificar resultados
- D) Usar asserts

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Los tests deben ser independientes.</p>

</details>

### 4. ¿Qué estamos probando aquí?

- A) Solo getters
- B) Integración repositorio-JDBC-SQLite
- C) HTML
- D) JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El test cruza varias capas de infraestructura.</p>

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
