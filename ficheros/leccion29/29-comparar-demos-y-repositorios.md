---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion29"
lesson_file: "29-comparar-demos-y-repositorios"
lesson_number: "29"
title: "Comparar los tres formatos y sus repositorios"
description: "Comparación de CsvCrudDemo, JsonCrudDemo y XmlCrudDemo antes de generalizar la API."
permalink: "/ficheros/leccion29/"
---

# Comparar `CsvCrudDemo`, `JsonCrudDemo` y `XmlCrudDemo`

## Tres demos, el mismo problema

A estas alturas hemos construido tres clases completas antes de refactorizar:

```text
CsvCrudDemo   → Commons CSV
JsonCrudDemo  → ObjectMapper
XmlCrudDemo   → XmlMapper
```

Las tres implementan esencialmente las mismas operaciones: `findAll`, `findById`, `create`, `update` y `delete`.

Después de distribuir responsabilidades hemos obtenido las implementaciones por formato:

```text
ProductoCsvRepository
ProductoJsonRepository
ProductoXmlRepository
```

Todas pueden verse desde la aplicación mediante `ProductoRepository`.

## Lo que cambia y lo que permanece

| Responsabilidad | CSV | JSON | XML |
|---|---|---|---|
| Sintaxis/formato | Commons CSV | Jackson Databind | Jackson XML |
| Demo inicial | `CsvCrudDemo` | `JsonCrudDemo` | `XmlCrudDemo` |
| Repositorio de Producto | `ProductoCsvRepository` | `ProductoJsonRepository` | `ProductoXmlRepository` |
| CRUD de la aplicación | igual | igual | igual |

## Ahora sí aparece un nuevo problema

`ProductoRepository` está acoplado al modelo `Producto` y a un identificador `Long`. Si queremos reutilizar exactamente el mismo diseño con otra entidad, la siguiente refactorización será generalizar ese contrato.

<div class="cla-lesson-nav"><a href="/ficheros/leccion28/">← 28 · Refactorizar XML</a><a href="/ficheros/leccion30/">30 · Repository&lt;T, ID&gt; →</a></div>
