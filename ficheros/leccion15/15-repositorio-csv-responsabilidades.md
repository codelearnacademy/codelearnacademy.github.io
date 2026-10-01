---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion15"
lesson_file: "15-repositorio-csv-responsabilidades"
lesson_number: "15"
title: "Refactorización CSV: clases y responsabilidades"
description: "Distribución de CsvCrudDemo en ProductoRepository, AbstractFileRepository, y ProductoCsvRepository."
permalink: "/ficheros/leccion15/"
---

# `ProductoCsvRepository`

## Segundo reparto de responsabilidades

Una vez que el CRUD común sale de `CsvCrudDemo`, todavía queda código específico de Commons CSV. La refactorización continúa creando las clases utilizadas en el diseño original de la ruta:

- `ProductoCsvRepository`: conoce cómo convertir entre un registro CSV y `Producto`. Además conoce `CSVParser`, `CSVPrinter`, cabeceras y escritura/lectura del formato.

```text
IProductoRepository
       ▲
       │
AbstractFileRepository
       ▲
       │
ProductoCsvRepository

```

## Instanciar la implementación

La aplicación sigue programando contra la API:

```java
IProductoRepository repository =
        new ProductoCsvRepository(Path.of("data", "productos.csv"));
```

El cambio importante es que el consumidor ya no necesita usar `CsvCrudDemo` como repositorio de producción. `CsvCrudDemo` se conserva como ejemplo didáctico anterior a la refactorización.

## Responsabilidades finales del bloque CSV

| Clase | Responsabilidad |
|---|---|
| `CsvCrudDemo` | ejemplo completo previo a refactorizar |
| `IProductoRepository` | contrato CRUD de Producto |
| `AbstractFileRepository` | comportamiento CRUD compartido |
| `ProductoCsvRepository` | mapeo entre CSV y Producto, y mecánica del formato CSV |

<div class="cla-lesson-nav"><a href="/ficheros/leccion14/">← 14 · CRUD común</a><a href="/ficheros/leccion16/">16 · Flujo del repositorio CSV →</a></div>
