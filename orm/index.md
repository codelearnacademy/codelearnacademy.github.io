---
layout: "route"
route: "orm"
title: "Persistencia relacional y ORM con Java y SQLite"
permalink: "/orm/"
---

# Persistencia relacional y ORM con Java y SQLite

Esta ruta continúa directamente la ruta de **Ficheros y formatos estructurados**. Conserva `Producto`, `Vehiculo`, `IRepository<T, ID>`, `IProductoRepository`, `IVehiculoRepository` y la configuración externa mediante `.properties`.

<div class="cla-route-flow">
  <span>CSV / JSON / XML</span><b>→</b><span>SQLite</span><b>→</b><span>JDBC</span><b>→</b><span>JdbcCrudDemo</span><b>→</b><span>ProductoJdbcRepository</span><b>→</b><span>problema de mapeo</span><b>→</b><span>JPA / Hibernate</span><b>→</b><span>ProductoOrmRepository</span><b>→</b><span>VehiculoOrmRepository</span>
</div>

## Principio didáctico

Como en la ruta de ficheros, **primero construimos un CRUD que funciona y después refactorizamos**. El ORM no aparece como magia: antes se implementa el mismo CRUD con JDBC y se identifica qué código repetitivo intenta resolver un ORM.

## Bloques

- **01–04 · De fichero a base de datos:** SQLite, `sqlite3`, tablas, claves y SQL básico.
- **05–12 · JDBC:** conexión, DDL, consultas, `PreparedStatement`, CRUD monolítico, repositorio, transacciones y tests.
- **13–17 · Del mapeo manual al ORM:** problema objeto-relacional, JPA, Hibernate, dependencias y configuración.
- **18–24 · CRUD ORM:** entidades de persistencia, mappers, `EntityManager`, CRUD y repositorios.
- **25–28 · Generalización y cierre:** `Vehiculo`, tests, comparación de estrategias y proyecto final.

## Contrato heredado de la ruta anterior

```java
public interface IRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    void create(T entity);
    boolean update(T entity);
    boolean delete(ID id);
}
```

El objetivo final es poder cambiar la infraestructura sin cambiar el código cliente:

```java
IProductoRepository repository;

repository = new ProductoCsvRepository(path);
repository = new ProductoJdbcRepository(url);
repository = new ProductoOrmRepository(entityManagerFactory);
```
