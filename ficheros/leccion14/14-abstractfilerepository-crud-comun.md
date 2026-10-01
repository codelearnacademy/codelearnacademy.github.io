---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion14"
lesson_file: "14-abstractfilerepository-crud-comun"
lesson_number: "14"
title: "AbstractFileRepository: extraer el CRUD común"
description: "Extracción progresiva del CRUD común desde CsvCrudDemo antes de aplicar genéricos."
permalink: "/ficheros/leccion14/"
---

# `AbstractFileRepository`: extraer el CRUD común

## De dónde sale

Al observar `CsvCrudDemo` vemos que `findById`, `create`, `update` y `delete` trabajan siempre sobre una colección. La parte verdaderamente dependiente del formato es leer y escribir esa colección.

Creamos `AbstractFileRepository` como **resultado de mover esa responsabilidad** fuera de `CsvCrudDemo`.

En esta primera explicación puede seguir pensándose en `Producto`; más adelante generalizaremos la clase con `<T, ID>`.

```java
public abstract class AbstractFileRepository implements IProductoRepository {
    protected final Path path;

    public List<Producto> productos;

    protected AbstractFileRepository(Path path) {
        this.path = path;
    }

    protected abstract List<Producto> readAll() throws IOException;
    protected abstract void writeAll(List<Producto> productos) throws IOException;

    // además contine el conjunto de funciones comunes (findByid, readAll) que utiliza la lista
}
```

<div class="cla-note">
<strong>Mejora:</strong>
    <p>Esta clase puede mejorar, controlando si el fichero indicado en path, existe o no.</p>
</div>

El objetivo no es terminar aquí toda la implementación, sino reconocer el reparto:

```text
CRUD y coordinación        → AbstractFileRepository
sintaxis concreta CSV      → capa CSV
mapeo Producto ↔ registro  → repositorio de Producto
```

<div class="cla-note"><strong>Evolución del diseño</strong><p>Más adelante esta misma clase se convertirá en <code>AbstractFileRepository&lt;T, ID&gt;</code>. Ese cambio también será una refactorización: primero resolvemos el caso concreto y después abstraemos.</p></div>

<div class="cla-lesson-nav"><a href="/ficheros/leccion13/">← 13 · ProductoRepository</a><a href="/ficheros/leccion15/">15 · CSV por responsabilidades →</a></div>
