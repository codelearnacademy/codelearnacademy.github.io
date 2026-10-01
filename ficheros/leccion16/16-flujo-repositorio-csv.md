---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion16"
lesson_file: "16-flujo-repositorio-csv"
lesson_number: "16"
title: "Flujo del repositorio CSV tras la refactorización"
description: "Recorrido de las operaciones después de distribuir las responsabilidades de CsvCrudDemo."
permalink: "/ficheros/leccion16/"
---

# Flujo de operaciones después de refactorizar CSV

## `findById`

Después de la refactorización, la aplicación no llama a un método diferente por usar CSV. Trabaja contra `ProductoRepository` y la implementación concreta resuelve el acceso al fichero.

```text
Aplicación
   ↓
ProductoRepository.findById(id)
   ↓
AbstractFileRepository
   ↓
readAll()
   ↓
productos.csv
```

<div class="cla-note">
  <p>
    <strong>Mejora:</strong>
    cargar una <code>List&lt;Producto&gt;</code> en el constructor
    y persistirla mediante <code>saveAll()</code>.
  </p>
</div>

## `create`, `update` y `delete`

El CRUD común modifica la colección y delega la persistencia:

```text
AbstractFileRepository
    │ llama a
    ▼
writeAll(...)
    │ implementado por
    ▼
ProductoCsvRepository
    │
    ▼
CSVPrinter
```

## Qué hemos ganado

`CsvCrudDemo` sigue siendo válido como demostración autocontenida. La nueva arquitectura no lo “corrige” cambiándole el nombre: **extrae responsabilidades a nuevas clases** para poder reutilizar el diseño posteriormente.

<div class="cla-note"><strong>Puente hacia JSON</strong><p>Ahora repetiremos el aprendizaje con <code>JsonCrudDemo</code> como demo independiente. Solo después integraremos JSON en la arquitectura de repositorios.</p></div>

<div class="cla-lesson-nav"><a href="/ficheros/leccion15/">← 15 · Refactorización CSV</a><a href="/ficheros/leccion17/">17 · JSON →</a></div>
