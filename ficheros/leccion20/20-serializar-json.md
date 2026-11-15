---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion20"
lesson_file: "20-serializar-json"
lesson_number: "20"
title: "Serializar JSON"
description: "Escritura de objetos y listas con Jackson y salida legible."
permalink: "/ficheros/leccion20/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: ciclo-de-ida-y-vuelta
    title: "Ciclo de ida y vuelta"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: microproyecto-exportar-json
    title: "Microproyecto · Exportar JSON"
---

# Serializar JSON

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/20.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/20.webp' | relative_url }}" alt="Java → JSON. La serialización transforma los objetos en texto estructurado. La lectura posterior permite comparar sus valores." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Guardar `Producto` y `List<Producto>` en JSON.
- Generar salida indentada.
- Reutilizar `ObjectMapper`.

```java
mapper.writerWithDefaultPrettyPrinter()
        .writeValue(Path.of("data/productos.json").toFile(), productos);
```

El mapper se encarga de:

- comillas;
- escapes;
- arrays;
- nombres de propiedades;
- representación numérica.

## Ciclo de ida y vuelta
{: #ciclo-de-ida-y-vuelta }

```text
productos.json → readValue → List<Producto>
List<Producto> → writeValue → productos.json
```

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Añade un producto y serializa la colección.
2. Vuelve a deserializar el fichero.
3. Compara la representación JSON con el CSV equivalente.


## Microproyecto · Exportar JSON
{: #microproyecto-exportar-json }

Guarda los nombres como array JSON de cadenas. Conserva el orden y los caracteres.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F20-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F20-tarea-01.webp' | relative_url }}" alt="Exportar JSON. Resultado esperado: Array recuperado: Á, B" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Array recuperado: Á, B.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion20/F20-tarea-01.zip' | relative_url }}">Descargar F20-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion19/' | relative_url }}">← 19 · Deserializar JSON</a>
  <a href="{{ '/ficheros/leccion21/' | relative_url }}">21 · CRUD con JSON: JsonCrudDemo →</a>
</div>
