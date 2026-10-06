---
layout: "route"
route: "ficheros"
title: "Ficheros y formatos estructurados"
permalink: "/ficheros/"
---

# Ficheros y formatos estructurados

Esta ruta parte de ejemplos completos y funcionales y utiliza la refactorización para justificar cada nueva abstracción.

<div class="cla-route-flow">
  <span>Ficheros</span><b>→</b><span>CSV</span><b>→</b><span>CsvCrudDemo</span><b>→</b><span>refactorización</span><b>→</b><span>JSON / JsonCrudDemo</span><b>→</b><span>XML / XmlCrudDemo</span><b>→</b><span>IRepository&lt;T, ID&gt;</span><b>→</b><span>.properties</span><b>→</b><span>DataBridge</span>
</div>

## Cómo está organizada

- **Fundamentos (01–06):** `Path`, `Files`, texto, excepciones, Maven y `Producto`.
- **CSV (07–16):** Commons CSV, lectura/escritura, `CsvCrudDemo` y su refactorización por responsabilidades.
- **JSON (17–22):** Jackson Databind, `JsonCrudDemo` y refactorización a `ProductoJsonRepository` reutilizando el CRUD común.
- **XML (23–28):** Jackson XML, `XmlCrudDemo` y refactorización a `ProductoXmlRepository`.
- **Abstracción (29–31):** comparación de formatos, modelo `Vehiculo`, `IVehiculoRepository` y repositorios de vehículos en CSV/JSON/XML.
- **Configuración y proyecto (32–34):** `.properties`, DataBridge y ampliaciones.

## Principio didáctico

Los nombres `CsvCrudDemo`, `JsonCrudDemo` y `XmlCrudDemo` se mantienen como demos iniciales. Los nuevos contratos, clases abstractas y repositorios no son renombrados arbitrarios: **aparecen durante la refactorización para distribuir responsabilidades**.
