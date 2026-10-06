---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion33"
lesson_file: "33-proyecto-final-databridge"
lesson_number: "33"
title: "Proyecto final: repositorios de ficheros"
description: "Integrar los CRUD de partida con la arquitectura final para Producto y Vehiculo."
permalink: "/ficheros/leccion33/"
---

# Proyecto final: de los CRUD a los repositorios

## Objetivo

El proyecto final no sustituye `CsvCrudDemo`, `JsonCrudDemo` y `XmlCrudDemo`: **explica cómo evolucionan** hasta una arquitectura reutilizable.

```text
CsvCrudDemo / JsonCrudDemo / XmlCrudDemo
                 ↓
       detectar CRUD repetido
                 ↓
          IRepository<T, ID>
                 ↓
 IProductoRepository / IVehiculoRepository
                 ↓
      AbstractFileRepository<T, ID>
        readAll() + writeAll()
                 ↓
 ┌───────────────┼────────────────┐
 CSV             JSON             XML
                 ↓
       RepositoryConfig (.properties)
```

## Clases que debe contener la solución

### Modelo

```text
Producto
Vehiculo
```

### Contratos

```text
IRepository<T, ID>
IProductoRepository
IVehiculoRepository
```

### Infraestructura común

```text
AbstractFileRepository<T, ID>
RepositoryException
```

### CSV

```text
ProductoCsvRepository
VehiculoCsvRepository
```

### JSON

```text
ProductoJsonRepository
VehiculoJsonRepository
```

### XML

```text
ProductoXmlRepository
VehiculoXmlRepository
```

### Configuración

```text
RepositoryConfig
application.properties
```

## Reglas de arquitectura

1. Las interfaces no declaran `IOException`.
2. `AbstractFileRepository` tampoco controla excepciones de E/S.
3. Cada implementación de formato controla sus propias excepciones y lanza `RepositoryException`.
4. Los únicos métodos abstractos de la clase base son `readAll()` y `writeAll()`.
5. Cada repositorio concreto ejecuta `entities = readAll()` una sola vez en su constructor.
6. El CRUD común trabaja con la colección en memoria.
7. `writeAll()` persiste los cambios antes de sustituir el estado interno.
8. `Producto` se identifica con `Producto::id`.
9. `Vehiculo` se identifica con `Vehiculo::matricula`.
10. La configuración `.properties` contiene los tipos y rutas externas.

## Tests mínimos

El proyecto debe incluir:

```text
CsvRepositoryTest
JsonRepositoryTest
XmlRepositoryTest
RepositoryConfigTest
```

Los tres primeros prueban CRUD completo de `Producto` y `Vehiculo`, y además reconstruyen el repositorio para verificar la persistencia real.

## Ejercicio final

Construye una pequeña aplicación que:

1. cargue `application.properties`;
2. cree un repositorio de productos según `repository.productos.type`;
3. cree un repositorio de vehículos según `repository.vehiculos.type`;
4. permita listar, buscar, crear, actualizar y eliminar;
5. cambie de CSV a JSON o XML modificando únicamente la configuración.

<div class="cla-lesson-nav"><a href="/ficheros/leccion32/">← 32 · .properties</a><a href="/ficheros/leccion34/">34 · Retos y ampliaciones →</a></div>
