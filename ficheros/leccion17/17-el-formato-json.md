---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion17"
lesson_file: "17-el-formato-json"
lesson_number: "17"
title: "El formato JSON"
description: "Estructura de JSON y correspondencia natural con objetos y colecciones Java."
permalink: "/ficheros/leccion17/"
---

# El formato JSON

## Qué vas a conseguir

- Reconocer objetos, arrays, propiedades y tipos JSON.
- Comparar JSON con el modelo `Producto`.
- Preparar `JsonCrudDemo` sin mezclar todavía la arquitectura de repositorios.

## Ejemplo

```json
[
  {"id":1,"nombre":"Teclado","precio":49.99},
  {"id":2,"nombre":"Monitor","precio":219.90}
]
```

La raíz es un array y cada elemento representa un `Producto`.

## Correspondencia

| JSON | Java |
|---|---|
| object | objeto/record |
| array | `List<T>` |
| string | `String` |
| number | `int`, `long`, `double`, `BigDecimal` |
| boolean | `boolean` |
| null | `null` |

<div class="cla-note"><strong>Diferencia con CSV</strong><p>JSON conserva estructura y tipos sintácticos; no trabaja solo con filas y campos de texto.</p></div>

## Ejercicios propuestos

1. Escribe manualmente tres productos en JSON válido.
2. Añade un carácter acentuado y comprueba UTF-8.
3. Introduce una coma incorrecta y observa cómo deja de ser JSON válido.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion16/">← 16 · Flujo de operaciones del repositorio CSV</a>
  <a href="/ficheros/leccion18/">18 · Jackson Databind y ObjectMapper →</a>
</div>
