---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion31"
lesson_file: "31-probar-abstraccion-vehiculo"
lesson_number: "31"
title: "Vehiculo en CSV, JSON y XML"
description: "Implementar y probar IVehiculoRepository en los tres formatos."
permalink: "/ficheros/leccion31/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: las-tres-implementaciones
    title: "Las tres implementaciones"
  - id: csv
    title: "CSV"
  - id: json
    title: "JSON"
  - id: xml
    title: "XML"
  - id: crud-mediante-ivehiculorepository
    title: "CRUD mediante IVehiculoRepository"
  - id: que-deben-comprobar-los-tests
    title: "Qué deben comprobar los tests"
  - id: microproyecto-contrato-compartido-de-vehiculos
    title: "Microproyecto · Contrato compartido de vehículos"
---

# Repositorios de `Vehiculo`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/31.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/31.webp' | relative_url }}" alt="Contrato común en tres formatos. CSV, JSON y XML representan la misma matrícula con estructuras distintas. Pasa las mismas comprobaciones de negocio para cada formato." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Las tres implementaciones
{: #las-tres-implementaciones }

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
{: #csv }

```java
public VehiculoCsvRepository(Path path) {
    super(path, Vehiculo::matricula);
    entities = readAll();
}
```

## JSON
{: #json }

```java
public VehiculoJsonRepository(Path path) {
    super(path, Vehiculo::matricula);
    entities = readAll();
}
```

## XML
{: #xml }

```java
public VehiculoXmlRepository(Path path) {
    super(path, Vehiculo::matricula);
    entities = readAll();
}
```

Lo que cambia entre ellas es únicamente la implementación de `readAll()` y `writeAll()`.

## CRUD mediante `IVehiculoRepository`
{: #crud-mediante-ivehiculorepository }

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
{: #que-deben-comprobar-los-tests }

Para cada formato:

1. crear dos vehículos;
2. buscar por matrícula;
3. actualizar sustituyendo el record completo;
4. eliminar;
5. construir un repositorio nuevo con el mismo `Path`;
6. comprobar que los cambios se recuperan desde el fichero.

El mismo patrón de test se utiliza para `Producto` y `Vehiculo` en CSV, JSON y XML.


## Microproyecto · Contrato compartido de vehículos
{: #microproyecto-contrato-compartido-de-vehiculos }

Recupera la matrícula desde CSV con cabecera matricula, JSON con campo matricula o XML con elemento matricula. El argumento formato indica csv, json o xml.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F31-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F31-tarea-01.webp' | relative_url }}" alt="Contrato compartido de vehículos. Resultado esperado: 1234ABC en los tres formatos" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** 1234ABC en los tres formatos.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion31/F31-tarea-01.zip' | relative_url }}">Descargar F31-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion30/' | relative_url }}">← 30 · Vehiculo</a><a href="{{ '/ficheros/leccion32/' | relative_url }}">32 · Configuración .properties →</a></div>
