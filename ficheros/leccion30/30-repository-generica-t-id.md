---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion30"
lesson_file: "30-repository-generica-t-id"
lesson_number: "30"
title: "Un segundo modelo: Vehiculo e IVehiculoRepository"
description: "Comprobar IRepository<T,ID> con un modelo cuyo identificador es una matrícula String."
permalink: "/ficheros/leccion30/"
---

# Probar la generalización con `Vehiculo`

## El modelo

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

El `equals()` generado por un `record` compara **todos sus componentes**. El repositorio, en cambio, identifica una entidad solo por el extractor configurado.

Dos vehículos con la misma matrícula pero distinto modelo no son iguales como record, pero representan el mismo elemento lógico para `update`.

<div class="cla-lesson-nav"><a href="/ficheros/leccion29/">← 29 · Comparación</a><a href="/ficheros/leccion31/">31 · Repositorios de Vehiculo →</a></div>
