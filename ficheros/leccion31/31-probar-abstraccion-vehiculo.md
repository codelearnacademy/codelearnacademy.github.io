---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion31"
lesson_file: "31-probar-abstraccion-vehiculo"
lesson_number: "31"
title: "Vehiculo en CSV, JSON y XML"
description: "Implementar y probar IVehiculoRepository en los tres formatos."
permalink: "/ficheros/leccion31/"
---

# Repositorios de `Vehiculo`

## Las tres implementaciones

El proyecto de ejemplo contiene:

```text
VehiculoCsvRepository
VehiculoJsonRepository
VehiculoXmlRepository
```

Las tres:

```java
extends AbstractFileRepository<Vehiculo, String>
implements IVehiculoRepository
```

## CSV

```java
public VehiculoCsvRepository(Path path) {
    super(path, Vehiculo::matricula);
    entities = readAll();
}
```

## JSON

```java
public VehiculoJsonRepository(Path path) {
    super(path, Vehiculo::matricula);
    entities = readAll();
}
```

## XML

```java
public VehiculoXmlRepository(Path path) {
    super(path, Vehiculo::matricula);
    entities = readAll();
}
```

Lo que cambia entre ellas es únicamente la implementación de `readAll()` y `writeAll()`.

## CRUD mediante `IVehiculoRepository`

```java
IVehiculoRepository repository =
        new VehiculoCsvRepository(file);

repository.create(
        new Vehiculo("1234abc", "Toyota", "Corolla", 2022));

repository.create(
        new Vehiculo("5678DEF", "Seat", "León", 2021));

repository.update(
        new Vehiculo("1234ABC", "Toyota", "Corolla GR", 2023));

repository.delete("5678DEF");
```

La matrícula se normaliza a mayúsculas en el constructor compacto del record.

## Qué deben comprobar los tests

Para cada formato:

1. crear dos vehículos;
2. buscar por matrícula;
3. actualizar sustituyendo el record completo;
4. eliminar;
5. construir un repositorio nuevo con el mismo `Path`;
6. comprobar que los cambios se recuperan desde el fichero.

El mismo patrón de test se utiliza para `Producto` y `Vehiculo` en CSV, JSON y XML.

<div class="cla-lesson-nav"><a href="/ficheros/leccion30/">← 30 · Vehiculo</a><a href="/ficheros/leccion32/">32 · Configuración .properties →</a></div>
