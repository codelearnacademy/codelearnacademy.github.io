---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion16"
lesson_file: "16-flujo-repositorio-csv"
lesson_number: "16"
title: "Flujo y pruebas del repositorio CSV"
description: "Comprobar que ProductoCsvRepository conserva el CRUD del CsvCrudDemo y persiste correctamente."
permalink: "/ficheros/leccion16/"
---

# Probar `ProductoCsvRepository`

## El flujo ya no relee el fichero en cada operación

```text
new ProductoCsvRepository(path)
             ↓
         readAll()
             ↓
          entities
             ↓
 find / create / update / delete
             ↓
       writeAll(...) solo al modificar
```

`findAll()` y `findById()` trabajan directamente sobre `entities`.

## Uso mediante la interfaz

```java
IProductoRepository repository =
        new ProductoCsvRepository(
                Path.of("data", "productos.csv"));

repository.create(new Producto(1, "Teclado", 30.0));
repository.create(new Producto(2, "Ratón", 15.0));

System.out.println(repository.findById(1L));

repository.update(
        new Producto(1, "Teclado mecánico", 45.0));

repository.delete(2L);
```

## Test CRUD completo

El proyecto de referencia utiliza JUnit y `@TempDir` para no modificar los datos reales:

```java
@Test
void crudCompletoProductoCsv(@TempDir Path tempDir) {
    Path file = tempDir.resolve("productos.csv");
    IProductoRepository repository =
            new ProductoCsvRepository(file);

    assertTrue(repository.findAll().isEmpty());

    repository.create(new Producto(1, "Teclado", 30.0));
    repository.create(new Producto(2, "Ratón", 15.0));

    assertEquals(2, repository.findAll().size());
    assertEquals("Teclado",
            repository.findById(1L).orElseThrow().nombre());

    assertTrue(repository.update(
            new Producto(1, "Teclado mecánico", 45.0)));

    assertTrue(repository.delete(2L));

    IProductoRepository reloaded =
            new ProductoCsvRepository(file);

    assertEquals("Teclado mecánico",
            reloaded.findById(1L).orElseThrow().nombre());
}
```

La última creación de `reloaded` es importante: demuestra que `writeAll()` realmente guardó los cambios y que un nuevo constructor puede recuperarlos con `readAll()`.

<div class="cla-note"><strong>Siguiente bloque</strong><p>JSON volverá a empezar con un CRUD monolítico. Después lo refactorizaremos para comprobar cuánto código podemos reutilizar.</p></div>

<div class="cla-lesson-nav"><a href="/ficheros/leccion15/">← 15 · ProductoCsvRepository</a><a href="/ficheros/leccion17/">17 · JSON →</a></div>
