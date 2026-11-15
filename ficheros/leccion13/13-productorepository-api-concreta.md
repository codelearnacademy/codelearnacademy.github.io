---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion13"
lesson_file: "13-productorepository-api-concreta"
lesson_number: "13"
title: "IRepository e IProductoRepository: extraer el contrato CRUD"
description: "Extraer del CsvCrudDemo un contrato CRUD general y especializarlo para Producto."
permalink: "/ficheros/leccion13/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: 1-extraer-las-operaciones-que-ya-existen
    title: "1. Extraer las operaciones que ya existen"
  - id: 2-especializar-el-contrato-para-producto
    title: "2. Especializar el contrato para Producto"
  - id: por-que-no-hay-ioexception
    title: "¿Por qué no hay IOException?"
  - id: mantener-la-semantica-del-crud-inicial
    title: "Mantener la semántica del CRUD inicial"
  - id: microproyecto-definir-un-contrato-de-busqueda
    title: "Microproyecto · Definir un contrato de búsqueda"
---

# Del CRUD inicial al contrato del repositorio

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/13.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/13.webp' | relative_url }}" alt="Contrato especializado. IRepository define las operaciones comunes. IProductoRepository fija Producto y Long como tipos de trabajo." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## 1. Extraer las operaciones que ya existen
{: #1-extraer-las-operaciones-que-ya-existen }

`CsvCrudDemo` ya nos ha dado las cinco operaciones que necesita la aplicación:

```java
findAll()
findById(...)
create(...)
update(...)
delete(...)
```

El primer paso es expresarlas sin hablar de CSV.

```java
package es.educacion.ficheros.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    void create(T entity);

    boolean update(T entity);

    boolean delete(ID id);
}
```

## 2. Especializar el contrato para `Producto`
{: #2-especializar-el-contrato-para-producto }

El proyecto de ejemplo conserva una interfaz de dominio específica:

```java
package es.educacion.ficheros.repository;

import es.educacion.ficheros.model.Producto;

public interface IProductoRepository
        extends IRepository<Producto, Long> {
}
```

Una **interfaz extiende** otra interfaz. Una clase será la que posteriormente la implemente.

```text
IRepository<T, ID>
       ▲
       │ T = Producto
       │ ID = Long
IProductoRepository
```

## ¿Por qué no hay `IOException`?
{: #por-que-no-hay-ioexception }

La aplicación no debería saber cómo se almacena la información. Por eso el contrato no contiene:

```java
throws IOException
```

Si una implementación CSV, JSON o XML tiene un problema de E/S, será esa implementación quien lo controle.

## Mantener la semántica del CRUD inicial
{: #mantener-la-semantica-del-crud-inicial }

La interfaz conserva la semántica que ya probamos en los demos:

- `create` crea o falla si el identificador está duplicado.
- `update` devuelve `true` si encontró y sustituyó la entidad.
- `delete` devuelve `true` si encontró y eliminó la entidad.
- `findById` devuelve `Optional<T>`.

<div class="cla-note"><strong>Importante</strong><p>La interfaz no añade comportamiento nuevo. Formaliza el CRUD que ya construimos.</p></div>


## Microproyecto · Definir un contrato de búsqueda
{: #microproyecto-definir-un-contrato-de-busqueda }

Declara un contrato de búsqueda e impleméntalo para una lista de IDs. Devuelve el índice de la primera coincidencia o -1.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F13-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F13-tarea-01.webp' | relative_url }}" alt="Definir un contrato de búsqueda. Resultado esperado: Índice 1 o -1 si falta" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Índice 1 o -1 si falta.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion13/F13-tarea-01.zip' | relative_url }}">Descargar F13-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion12/' | relative_url }}">← 12 · Responsabilidades</a><a href="{{ '/ficheros/leccion14/' | relative_url }}">14 · AbstractFileRepository →</a></div>
