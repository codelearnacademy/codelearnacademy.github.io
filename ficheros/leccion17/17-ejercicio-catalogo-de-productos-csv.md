---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion17"
lesson_file: "17-ejercicio-catalogo-de-productos-csv"
lesson_number: "17"
title: "Ejercicio: catálogo de productos CSV"
description: "Ejercicio integrador de CSV con Producto, CRUD, validación y casos de campos que requieren quoting."
permalink: "/ficheros/leccion17/"
lessons:
  - id: "qué-vas-a-conseguir"
    title: "Qué vas a conseguir"
  - id: "punto-de-partida"
    title: "Punto de partida"
  - id: "conceptos-clave"
    title: "Conceptos clave"
  - id: "ejemplo-guiado"
    title: "Ejemplo guiado"
  - id: "relación-con-el-resto-de-la-ruta"
    title: "Relación con el resto de la ruta"
  - id: "ejercicios-propuestos"
    title: "Ejercicios propuestos"
  - id: "qué-debes-recordar"
    title: "Qué debes recordar"
---

# Ejercicio: catálogo de productos CSV

## Qué vas a conseguir

- Consolidar el CRUD CSV utilizando el mismo modelo `Producto` de la ruta.
- Aplicar validación sin mezclarla con el código específico de Apache Commons CSV.
- Comprobar casos reales de quoting y caracteres UTF-8.

## Punto de partida

Ya puedes leer y escribir `Producto` con Commons CSV. Ahora debes reunir esas operaciones en un pequeño catálogo persistente.

<div class="cla-note"><strong>Reto CSV</strong><p>Incluye al menos un producto cuyo nombre contenga una coma, por ejemplo <code>"Teclado, mecánico"</code>. Si la solución usa Commons CSV correctamente, el campo seguirá siendo uno solo.</p></div>

## Conceptos clave

- `Producto` no conoce el formato CSV.
- El identificador permite localizar, actualizar y eliminar registros.
- Una modificación requiere cargar los datos, aplicar el cambio y persistir el estado resultante.
- Commons CSV debe encargarse del quoting y del escape de campos.

## Ejemplo guiado

```csv
id,nombre,precio,stock
1,"Teclado, mecánico",49.99,10
2,Ratón,24.90,25
3,Monitor,189.00,7
```

## Relación con el resto de la ruta

Este ejercicio cierra CSV manteniendo `Producto`. En JSON se reutilizará exactamente el mismo dominio y cambiará únicamente el mecanismo de serialización.

## Ejercicios propuestos

1. Implementa listar, buscar por id, crear, actualizar y eliminar productos.
2. Rechaza ids duplicados, precios negativos y stock negativo.
3. Comprueba que `"Teclado, mecánico"` se conserva después de una actualización de otro producto.
4. Añade un producto con caracteres como `ñ`, `á` o `€` y verifica que se mantiene UTF-8.
5. Vuelve a abrir el fichero después de cada modificación y comprueba que el cambio es persistente.

## Qué debes recordar

- El CRUD opera sobre `Producto`; Commons CSV resuelve la representación tabular.
- Los casos con comas y comillas son la razón principal para no usar `split(",")`.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion16/">← 16 · CRUD con CSV</a>
  <a href="/ficheros/leccion18/">18 · El formato JSON →</a>
</div>
