---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion30"
lesson_file: "30-repository-generica-t-id"
lesson_number: "30"
title: "Generalizar la API"
description: "Generalización final del contrato y de AbstractFileRepository después de trabajar los tres formatos."
permalink: "/ficheros/leccion30/"
---

# Generalizar la API: `Repository<T, ID>`

## La abstracción llega después de los ejemplos

Hasta ahora hemos utilizado una API concreta para `Producto`. Solo después de trabajar CSV, JSON y XML tenemos evidencia suficiente para generalizar.

Partimos conceptualmente de:

```java
public interface IProductoRepository {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto create(Producto producto);
    Producto update(Producto producto);
    void delete(Long id);
}
```

## Primera generalización: el modelo

Sustituimos `Producto` por `T`:

```java
public interface IRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T create(T entity);
    T update(T entity);
    void delete(ID id);
}
```

- `T` representa el tipo de entidad.
- `ID` representa el tipo de su identificador.

`IProductoRepository` puede conservarse como contrato especializado:

```java
public interface IProductoRepository extends IRepository<Producto, Long> {
}
```

```text
IRepository<T, ID>
        ↓ especialización
IProductoRepository
        ↓
T  = Producto
ID = Long
```

## Generalizar también la clase base

La misma refactorización se aplica al CRUD común:

```java
public abstract class AbstractFileRepository<T, ID>
        implements IRepository<T, ID> {

    protected abstract ID getId(T entity);

    protected abstract List<T> readAll() throws IOException;

    protected abstract void writeAll(List<T> entities) throws IOException;

    // findAll()
    // findById()
    // create()
    // update()
    // delete()
}
```

Y las clases de formato pueden evolucionar de la misma manera:

```java
public class ProductoCsvRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {
    // ...
}
```

```java
public class ProductoJsonRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {
    // ...
}
```

```java
public class ProductoXmlRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {
    // ...
}
```

<div class="cla-note"><strong>Refactorización, no punto de partida</strong><p>Los parámetros <code>T</code> e <code>ID</code> aparecen ahora porque ya hemos identificado una abstracción estable. No eran necesarios para comprender las primeras demos.</p></div>

## Instanciar una implementación

El código consumidor puede declarar el contrato general:

```java
IRepository<Producto, Long> repository =
        new ProductoCsvRepository(Path.of("data", "productos.csv"));
```

o continuar usando el contrato especializado:

```java
IProductoRepository repository =
        new ProductoCsvRepository(Path.of("data", "productos.csv"));
```

<div class="cla-lesson-nav"><a href="/ficheros/leccion29/">← 29 · Comparación</a><a href="/ficheros/leccion31/">31 · Probar con Vehiculo →</a></div>
