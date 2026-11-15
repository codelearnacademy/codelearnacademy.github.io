---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion30"
lesson_file: "30-repository-generica-t-id"
lesson_number: "30"
title: "Un segundo modelo: Vehiculo e IVehiculoRepository"
description: "Comprobar IRepository<T,ID> con un modelo cuyo identificador es una matrícula String."
permalink: "/ficheros/leccion30/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: el-modelo
    title: "El modelo"
  - id: especializar-la-interfaz
    title: "Especializar la interfaz"
  - id: el-papel-de-function-t-id
    title: "El papel de Function<T, ID>"
  - id: record-e-identidad
    title: "record e identidad"
  - id: microproyecto-buscar-con-identidad-de-vehiculo
    title: "Microproyecto · Buscar con identidad de vehículo"
---

# Probar la generalización con `Vehiculo`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/30.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/30.webp' | relative_url }}" alt="Identidad de vehículos. Vehiculo se identifica por matrícula. IVehiculoRepository especializa el CRUD para su tipo de ID." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## El modelo
{: #el-modelo }

```java
package es.educacion.ficheros.model;

public record Vehiculo(
        String matricula,
        String marca,
        String modelo,
        int anio) {

    public Vehiculo {
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException(
                    "La matrícula es obligatoria");
        }
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException(
                    "La marca es obligatoria");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException(
                    "El modelo es obligatorio");
        }
        if (anio < 1886) {
            throw new IllegalArgumentException(
                    "El año no es válido");
        }

        matricula = matricula.trim().toUpperCase();
    }
}
```

`Vehiculo` no tiene `id()` ni `getId()`. Su identificador de dominio es `matricula()`.

## Especializar la interfaz
{: #especializar-la-interfaz }

```java
package es.educacion.ficheros.repository;

import es.educacion.ficheros.model.Vehiculo;

public interface IVehiculoRepository
        extends IRepository<Vehiculo, String> {
}
```

Ahora tenemos:

```text
IRepository<T, ID>
    ▲              ▲
    │              │
Producto, Long   Vehiculo, String
    │              │
IProductoRepository  IVehiculoRepository
```

## El papel de `Function<T, ID>`
{: #el-papel-de-function-t-id }

Los constructores concretos indican cómo obtener la identidad:

```java
super(path, Producto::id);
```

frente a:

```java
super(path, Vehiculo::matricula);
```

Por eso `AbstractFileRepository` no necesita exigir un método `getId()` a las entidades.

## `record` e identidad
{: #record-e-identidad }

El `equals()` generado por un `record` compara **todos sus componentes**. El repositorio, en cambio, identifica una entidad solo por el extractor configurado.

Dos vehículos con la misma matrícula pero distinto modelo no son iguales como record, pero representan el mismo elemento lógico para `update`.


## Microproyecto · Buscar con identidad de vehículo
{: #microproyecto-buscar-con-identidad-de-vehiculo }

Implementa una búsqueda de matrícula exacta. Devuelve el modelo o Optional.empty.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F30-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F30-tarea-01.webp' | relative_url }}" alt="Buscar con identidad de vehículo. Resultado esperado: Modelo o ausencia" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Modelo o ausencia.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion30/F30-tarea-01.zip' | relative_url }}">Descargar F30-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion29/' | relative_url }}">← 29 · Comparación</a><a href="{{ '/ficheros/leccion31/' | relative_url }}">31 · Repositorios de Vehiculo →</a></div>
