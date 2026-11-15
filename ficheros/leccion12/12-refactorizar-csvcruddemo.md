---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion12"
lesson_file: "12-refactorizar-csvcruddemo"
lesson_number: "12"
title: "Refactorizar CsvCrudDemo: detectar responsabilidades"
description: "Partir del CRUD CSV funcional para separar dominio, contrato, CRUD común y persistencia."
permalink: "/ficheros/leccion12/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: que-se-repite-en-el-crud
    title: "Qué se repite en el CRUD"
  - id: que-queremos-conseguir
    title: "Qué queremos conseguir"
  - id: las-excepciones-tambien-cambian-de-lugar
    title: "Las excepciones también cambian de lugar"
  - id: microproyecto-separar-lectura-y-escritura
    title: "Microproyecto · Separar lectura y escritura"
---

# Refactorizar `CsvCrudDemo`: partir de un CRUD que ya funciona

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/12.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/12.webp' | relative_url }}" alt="Separar responsabilidades. Identifica qué métodos leen y escriben el formato. Comprueba que la separación conserva el comportamiento del cliente." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Punto de partida
{: #punto-de-partida }

En la lección anterior construimos `CsvCrudDemo` con un CRUD completo. Esa clase es importante: **la arquitectura no aparece antes del problema**, sino después de tener un ejemplo que funciona.

`CsvCrudDemo` concentra:

```text
CsvCrudDemo
 ├─ Path del fichero
 ├─ Commons CSV
 ├─ conversión CSV ↔ Producto
 ├─ findAll / findById
 ├─ create / update / delete
 └─ tratamiento de IOException
```

El objetivo de la refactorización es conservar el mismo comportamiento y repartir responsabilidades.

## Qué se repite en el CRUD
{: #que-se-repite-en-el-crud }

Las operaciones del demo tienen una estructura común:

```text
leer colección
    ↓
buscar / añadir / sustituir / eliminar
    ↓
escribir colección cuando hay cambios
```

La sintaxis CSV solo afecta a dos operaciones:

```text
readAll()   fichero → List<Producto>
writeAll()  List<Producto> → fichero
```

Esta observación será la base de `AbstractFileRepository`.

## Qué queremos conseguir
{: #que-queremos-conseguir }

La evolución será:

```text
CsvCrudDemo
    ↓ separar contrato
IRepository<T, ID>
    ↓ especializar para Producto
IProductoRepository
    ↓ extraer CRUD común
AbstractFileRepository<T, ID>
    ↓ dejar solo lo específico de CSV
ProductoCsvRepository
```

<div class="cla-note"><strong>Regla de la ruta</strong><p>Cada nueva abstracción debe poder relacionarse con código que ya existía en el CRUD inicial.</p></div>

## Las excepciones también cambian de lugar
{: #las-excepciones-tambien-cambian-de-lugar }

En el demo es normal ver:

```java
public List<Producto> findAll() throws IOException
```

En la arquitectura final, las interfaces no expondrán `IOException`. Cada implementación concreta de fichero controlará sus errores de E/S y los transformará en `RepositoryException`.

Eso permite que la aplicación utilice un repositorio sin conocer si detrás hay CSV, JSON o XML.


## Microproyecto · Separar lectura y escritura
{: #microproyecto-separar-lectura-y-escritura }

Extrae un método para cargar las líneas y otro para guardarlas. Escribe todas las líneas en UTF-8, vuelve a leerlas y devuelve la lista.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F12-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F12-tarea-01.webp' | relative_url }}" alt="Separar lectura y escritura. Resultado esperado: Contenido idéntico tras reabrir" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Contenido idéntico tras reabrir.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion12/F12-tarea-01.zip' | relative_url }}">Descargar F12-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion11/' | relative_url }}">← 11 · CsvCrudDemo</a><a href="{{ '/ficheros/leccion13/' | relative_url }}">13 · IRepository e IProductoRepository →</a></div>
