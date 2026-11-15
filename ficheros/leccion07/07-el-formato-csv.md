---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion07"
lesson_file: "07-el-formato-csv"
lesson_number: "07"
title: "El formato CSV"
description: "Estructura de CSV, cabeceras, delimitadores, quoting y límites de una lectura manual."
permalink: "/ficheros/leccion07/"
lessons:
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: conceptos-clave
    title: "Conceptos clave"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo-minimo-con-java
    title: "Ejemplo mínimo con Java"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: que-debes-recordar
    title: "Qué debes recordar"
  - id: microproyecto-inspeccionar-un-csv
    title: "Microproyecto · Inspeccionar un CSV"
---

# El formato CSV

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Reconocer la estructura de un fichero CSV.
- Diferenciar delimitador, cabecera, registro y campo.
- Entender por qué un CSV real no debe procesarse con `split(",")`.

## Punto de partida
{: #punto-de-partida }

CSV parece un formato sencillo porque cada línea suele representar un registro. La dificultad aparece cuando un campo contiene el mismo carácter que usamos como delimitador.

![Anatomía de un fichero CSV]({{ '/assets/images/ficheros/07-anatomia-csv.png' | relative_url }})

## Conceptos clave
{: #conceptos-clave }

```csv
id,nombre,precio
1,Teclado,49.99
2,"Monitor, 27 pulgadas",219.90
```

La segunda fila contiene **tres separadores de columna**, pero la coma dentro de `"Monitor, 27 pulgadas"` pertenece al texto del campo. Las comillas forman parte del dialecto CSV y permiten representar datos que contienen delimitadores, saltos de línea o comillas.

<div class="cla-note"><strong>Idea importante</strong><p>CSV no es simplemente “texto separado por comas”. Es un formato tabular con reglas de quoting y escape.</p></div>

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/07.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/07.webp' | relative_url }}" alt="Anatomía de un CSV. La cabecera asigna un nombre a cada columna. Un campo entrecomillado puede contener una coma." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo mínimo con Java
{: #ejemplo-minimo-con-java }

Antes de incorporar una biblioteca puedes leer el fichero como texto para observar su contenido:

```java
Path path = Path.of("data/productos.csv");
Files.readAllLines(path, StandardCharsets.UTF_8)
        .forEach(System.out::println);
```

Este código **lee líneas**, pero todavía no interpreta correctamente la sintaxis CSV.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Crea `productos.csv` con cabecera y tres productos.
2. Añade un producto cuyo nombre contenga una coma.
3. Explica por qué `line.split(",")` deja de ser fiable.

## Qué debes recordar
{: #que-debes-recordar }

- El fichero es texto; el CSV añade estructura.
- Las comillas cambian el significado del delimitador.
- En la siguiente lección delegaremos estas reglas en Apache Commons CSV.


## Microproyecto · Inspeccionar un CSV
{: #microproyecto-inspeccionar-un-csv }

Devuelve la segunda columna de la primera fila de datos. El CSV incluye cabecera y admite comas entrecomilladas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F07-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F07-tarea-01.webp' | relative_url }}" alt="Inspeccionar un CSV. Resultado esperado: Cable, largo" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Cable, largo.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion07/F07-tarea-01.zip' | relative_url }}">Descargar F07-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion06/' | relative_url }}">← 6 · Modelo común Producto</a>
  <a href="{{ '/ficheros/leccion08/' | relative_url }}">8 · Apache Commons CSV →</a>
</div>
