---
layout: "lesson"
route: "orm"
lesson_id: "leccion26"
lesson_file: "26-tests-orm-sqlite"
lesson_number: "26"
title: "Tests ORM con SQLite"
description: "Tests ORM con SQLite"
permalink: "/orm/leccion26/"
---

# Tests ORM con SQLite

## Test ORM con SQLite real

```java
@TempDir
Path tempDir;

@Test
void crudCompletoOrm() {
    Path db = tempDir.resolve("orm-test.db");

    EntityManagerFactory emf =
            TestEntityManagerFactory.create(db);

    try {
        IProductoRepository repo =
                new ProductoOrmRepository(emf);

        repo.create(new Producto(1, "Teclado", 30));
        assertEquals(1, repo.findAll().size());

        assertTrue(repo.update(
                new Producto(1, "Teclado mecánico", 50)));

        assertTrue(repo.delete(1L));
        assertTrue(repo.findAll().isEmpty());
    } finally {
        emf.close();
    }
}
```

No simulamos el ORM: el test utiliza una base SQLite real en un fichero temporal.

<!-- MEJORAS-DIDACTICAS-ORM -->

## Mapa visual de la lección

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/26-test-orm.png" alt="Test ORM real. JUnit → ProductoOrmRepository → Hibernate → SQLite temporal." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> JUnit → ProductoOrmRepository → Hibernate → SQLite temporal.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="/orm/images/26-test-isolation.png" alt="Aislamiento del test. Base temporal nueva → Ejecutar caso → Destruir/descartar." loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Base temporal nueva → Ejecutar caso → Destruir/descartar.</p>


## Ejemplo guiado

### Testear create y findById con ORM

1. Crea configuración de test con SQLite temporal.
2. Construye EntityManagerFactory.
3. Crea el repositorio.
4. Persiste Producto y recupéralo.
5. Cierra EntityManagerFactory al final.

<div class="cla-note"><strong>Comprobación</strong><p>No avances hasta poder explicar qué hace cada paso y comprobar el resultado en la base de datos o en la salida del programa.</p></div>


## Autoevaluación

### 1. ¿Qué estamos probando?

- A) Integración ORM-Hibernate-SQLite
- B) Solo un getter
- C) Solo JUnit
- D) Solo Maven

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El repositorio se prueba contra infraestructura real.</p>

</details>

### 2. ¿Por qué una base temporal?

- A) Aislamiento y repetibilidad
- B) Para compartir datos
- C) Para evitar asserts
- D) Para usar CSV

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los tests no deben depender de ejecuciones anteriores.</p>

</details>

### 3. ¿Qué recurso debe cerrarse?

- A) EntityManagerFactory
- B) Solo String
- C) Record Producto
- D) La JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Es un recurso costoso que debe liberarse.</p>

</details>

### 4. ¿Qué conviene verificar además del retorno?

- A) El estado persistido real
- B) Solo que no lance excepción
- C) El color del IDE
- D) La versión de Git

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El objetivo es validar persistencia efectiva.</p>

</details>


## Ejercicio propuesto

Añade tests para update, delete y error por duplicado asegurando que cada caso parte de una base limpia.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion25/">← 25 · VehiculoEntity e IVehiculoRepository</a>
  <a href="/orm/leccion27/">27 · Comparar ficheros, JDBC y ORM →</a>
</div>
