---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion21"
lesson_file: "21-serializar-json"
lesson_number: "21"
title: "Serializar JSON"
description: "Serializar JSON: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion21/"
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

# Serializar JSON

## Qué vas a conseguir

- Serializar objetos Java a JSON legible.
- Controlar la escritura del fichero mediante `ObjectMapper`.

## Punto de partida

Serializar es la operación inversa: el estado Java se convierte en una representación JSON persistible.

<div class="cla-note"><strong>Serialización</strong><p>La salida bonita facilita la inspección humana, pero la corrección depende de la estructura de datos, no del espaciado.</p></div>

## Conceptos clave

- `writeValue` puede escribir directamente en un fichero.
- `writerWithDefaultPrettyPrinter()` mejora la legibilidad en ejemplos y configuración.
- La serialización no decide qué objetos deberían existir; solo representa los que recibe.

## Ejemplo guiado

```java
mapper.writerWithDefaultPrettyPrinter()
      .writeValue(path.toFile(), productos);
```

## Relación con el resto de la ruta

Con lectura y escritura disponibles, la siguiente lección construye un repositorio CRUD completo sobre JSON.

## Ejercicios propuestos

1. Escribe dos productos en JSON con formato legible.
2. Vuelve a leerlos y comprueba que los objetos mantienen sus valores.

## Qué debes recordar

- Serializar no equivale a validar la lógica de negocio.
- Comprueba la ida y vuelta para detectar diferencias de mapeo.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion20/">← 20 · Deserializar JSON</a>
  <a href="/ficheros/leccion22/">22 · CRUD con JSON →</a>
</div>
