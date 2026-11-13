---
layout: "lesson"
route: "orm"
lesson_id: "leccion26"
lesson_file: "26-tests-orm-sqlite"
lesson_number: "26"
title: "Tests ORM con SQLite"
description: "Tests ORM con SQLite"
permalink: "/orm/leccion26/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: test-orm-con-sqlite-real
  title: Test ORM con SQLite real
- id: diagramas-de-apoyo
  title: Diagramas de apoyo
- id: ejemplo-guiado
  title: Ejemplo guiado
- id: autoevaluación
  title: Autoevaluación
- id: ejercicio-propuesto
  title: Ejercicio propuesto
---

# Tests ORM con SQLite

## Objetivo de aprendizaje

Prueba un repositorio ORM con SQLite y comprueba el estado persistido.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/26-tests-orm-sqlite.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 26">
    <img src="{{ '/assets/images/orm/infografias/26-tests-orm-sqlite.webp' | relative_url }}" alt="Resumen visual de la lección 26. Tests ORM con SQLite" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 26.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/26-tests-orm-sqlite.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

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

## Diagramas de apoyo

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/26-test-orm.png' | relative_url }}" alt="Probar ORM con SQLite" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Verifica la persistencia usando una base temporal real. Comprueba el efecto en SQLite además del valor devuelto.</p>

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/orm/26-test-isolation.png' | relative_url }}" alt="Aislar una prueba de persistencia" loading="lazy">
</figure>

<p class="cla-diagram-text"><strong>Lectura del diagrama:</strong> Cada caso empieza con un estado conocido. Una prueba aislada puede ejecutarse por separado.</p>


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

- A) Solo Maven
- B) Solo un getter
- C) Integración ORM-Hibernate-SQLite
- D) Solo JUnit

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El repositorio se prueba contra infraestructura real.</p>

</details>

### 2. ¿Por qué una base temporal?

- A) Aislamiento y repetibilidad
- B) Para usar CSV
- C) Para compartir datos
- D) Para evitar asserts

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los tests no deben depender de ejecuciones anteriores.</p>

</details>

### 3. ¿Qué recurso debe cerrarse?

- A) Record Producto
- B) EntityManagerFactory
- C) La JVM
- D) Solo String

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Es un recurso costoso que debe liberarse.</p>

</details>

### 4. ¿Qué conviene verificar además del retorno?

- A) La versión de Git
- B) Solo que no lance excepción
- C) El color del IDE
- D) El estado persistido real

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> El objetivo es validar persistencia efectiva.</p>

</details>


## Ejercicio propuesto

Añade tests para update, delete y error por duplicado asegurando que cada caso parte de una base limpia.

**Entrega mínima:** código o SQL utilizado, resultado obtenido y una explicación breve de las decisiones tomadas.


<div class="cla-lesson-nav">
  <a href="/orm/leccion25/">← 25 · VehiculoEntity e IVehiculoRepository</a>
  <a href="/orm/leccion27/">27 · Comparar ficheros, JDBC y ORM →</a>
</div>

---
