---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion17"
lesson_file: "17-el-formato-json"
lesson_number: "17"
title: "El formato JSON"
description: "Estructura de JSON y correspondencia natural con objetos y colecciones Java."
permalink: "/ficheros/leccion17/"
lessons:
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo
    title: "Ejemplo"
  - id: correspondencia
    title: "Correspondencia"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: microproyecto-reconocer-colecciones-json
    title: "Microproyecto · Reconocer colecciones JSON"
---

# El formato JSON

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Reconocer objetos, arrays, propiedades y tipos JSON.
- Comparar JSON con el modelo `Producto`.
- Preparar `JsonCrudDemo` sin mezclar todavía la arquitectura de repositorios.

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/17.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/17.webp' | relative_url }}" alt="Colección JSON. El array contiene objetos y cada objeto contiene propiedades. Un array vacío, un archivo ausente y un documento inválido son casos distintos." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo
{: #ejemplo }

```json
[
  {"id":1,"nombre":"Teclado","precio":49.99},
  {"id":2,"nombre":"Monitor","precio":219.90}
]
```

La raíz es un array y cada elemento representa un `Producto`.

## Correspondencia
{: #correspondencia }

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
{: #ejercicios-propuestos }

1. Escribe manualmente tres productos en JSON válido.
2. Añade un carácter acentuado y comprueba UTF-8.
3. Introduce una coma incorrecta y observa cómo deja de ser JSON válido.


## Microproyecto · Reconocer colecciones JSON
{: #microproyecto-reconocer-colecciones-json }

Devuelve el número de objetos del array JSON. Lanza IOException si el documento no es un array válido.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F17-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F17-tarea-01.webp' | relative_url }}" alt="Reconocer colecciones JSON. Resultado esperado: El catálogo vacío tiene 0 elementos" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** El catálogo vacío tiene 0 elementos.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion17/F17-tarea-01.zip' | relative_url }}">Descargar F17-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion16/' | relative_url }}">← 16 · Flujo de operaciones del repositorio CSV</a>
  <a href="{{ '/ficheros/leccion18/' | relative_url }}">18 · Jackson Databind y ObjectMapper →</a>
</div>
