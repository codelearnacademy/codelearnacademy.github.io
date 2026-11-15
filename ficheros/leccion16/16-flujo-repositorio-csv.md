---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion16"
lesson_file: "16-flujo-repositorio-csv"
lesson_number: "16"
title: "Flujo y pruebas del repositorio CSV"
description: "Comprobar que ProductoCsvRepository conserva el CRUD del CsvCrudDemo y persiste correctamente."
permalink: "/ficheros/leccion16/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: el-flujo-ya-no-relee-el-fichero-en-cada-operacion
    title: "El flujo ya no relee el fichero en cada operación"
  - id: uso-mediante-la-interfaz
    title: "Uso mediante la interfaz"
  - id: test-crud-completo
    title: "Test CRUD completo"
  - id: practica-de-cierre-de-csv
    title: "Práctica de cierre de CSV"
  - id: pizarra-pruebas
    title: "¿Qué prueba corresponde a cada clase?"
  - id: microproyecto-alta-y-reapertura-csv
    title: "Microproyecto · Alta y reapertura CSV"
---

# Probar `ProductoCsvRepository`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/16.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/16.webp' | relative_url }}" alt="Verificar tras reabrir. Crea un fichero temporal para cada prueba. Comprueba resultados desde una instancia nueva del repositorio." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## El flujo ya no relee el fichero en cada operación
{: #el-flujo-ya-no-relee-el-fichero-en-cada-operacion }

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
{: #uso-mediante-la-interfaz }

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
{: #test-crud-completo }

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


## Práctica de cierre de CSV
{: #practica-de-cierre-de-csv }

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion16/practica-catalogo-csv/' | relative_url }}">Abrir catálogo de productos CSV</a>
</div>


## ¿Qué prueba corresponde a cada clase?
{: #pizarra-pruebas }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/pizarras/pruebas-responsabilidades.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/pizarras/pruebas-responsabilidades.webp' | relative_url }}" alt="¿Qué prueba corresponde a cada clase?. Datos comunes · ID 7, Cuaderno, precio 2.50. Mapper. Pasa los campos de la fila y comprueba el Producto. Con abc como precio, espera un error de conversión. Servicio. Prepara un repositorio en memoria con el ID 7. Intenta el alta y comprueba que el catálogo queda igual. Repositorio CSV. Con @TempDir, guarda el producto. Abre el fichero con otra instancia y comprueba los datos recuperados. Si falla el mapper. Revisa el paso de texto a los tipos de Producto. Si falla la relectura. Revisa cómo el repositorio escribe y vuelve a leer el fichero." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

Vincula cada comprobación a una clase y anota qué entrada y qué resultado debe verificar. Usa el microproyecto de la lección para practicar con un fichero temporal.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/ficheros/pizarras/pruebas-responsabilidades.webp' | relative_url }}">Ampliar la infografía</a>
  <a href="{{ '/ficheros/infografias/#pizarras' | relative_url }}">Ver todas las pizarras</a>
</div>

## Microproyecto · Alta y reapertura CSV
{: #microproyecto-alta-y-reapertura-csv }

Añade un producto a un catálogo CSV con cabecera id,nombre. Rechaza un identificador duplicado y conserva el nombre al reabrir.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F16-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F16-tarea-01.webp' | relative_url }}" alt="Alta y reapertura CSV. Resultado esperado: Un registro válido tras reabrir" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Un registro válido tras reabrir.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion16/F16-tarea-01.zip' | relative_url }}">Descargar F16-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion15/' | relative_url }}">← 15 · ProductoCsvRepository</a><a href="{{ '/ficheros/leccion17/' | relative_url }}">17 · JSON →</a></div>
