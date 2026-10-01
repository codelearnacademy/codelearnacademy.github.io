---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion13"
lesson_file: "13-productorepository-api-concreta"
lesson_number: "13"
title: "ProductoRepository: extraer la API concreta"
description: "Extracción del contrato CRUD de Producto a partir de CsvCrudDemo."
permalink: "/ficheros/leccion13/"
---

# `ProductoRepository`: extraer la API concreta

## Por qué aparece esta clase

`IProductoRepository` **no sustituye arbitrariamente** a `CsvCrudDemo`. Se extrae durante la refactorización para separar lo que la aplicación necesita pedir de la forma concreta en que se guarda el fichero.

```java
public interface IProductoRepository {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto create(Producto producto);
    Producto update(Producto producto);
    void delete(Long id);
}
```

<div class="cla-note">
<strong>Recuerda:</strong>
    <p>Recueda que la documentación se debe de realizar en las api, para que este disponible en todas las implementaciones de esta.</p>
</div>

En esta etapa la API sigue siendo deliberadamente concreta: trabaja con `Producto` y `Long`.

## Qué responsabilidad se ha movido

Antes, quien utilizaba `CsvCrudDemo` conocía directamente la clase CSV. Ahora el cliente puede declarar:

```java
IProductoRepository repository;
```

Todavía falta una implementación, pero el código consumidor ya expresa **qué necesita** en lugar de **cómo se persiste**.

<div class="cla-note"><strong>Refactorización</strong><p>La interfaz aparece porque hemos extraído el contrato CRUD de <code>CsvCrudDemo</code>. No estamos cambiando el comportamiento funcional del programa.</p></div>

## Por qué no usamos todavía `Repository<T, ID>`

Con un solo modelo sería posible hacerlo, pero todavía no hemos demostrado que esa generalización sea necesaria. La introduciremos después de repetir el ejercicio con JSON y XML y de probar un segundo modelo.

<div class="cla-lesson-nav"><a href="/ficheros/leccion12/">← 12 · Responsabilidades</a><a href="/ficheros/leccion14/">14 · AbstractFileRepository →</a></div>
