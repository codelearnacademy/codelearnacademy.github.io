---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion03"
lesson_file: "03-lectura-y-escritura-de-texto"
lesson_number: "3"
title: "Lectura y escritura de texto"
description: "Lectura y escritura de texto: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion03/"
lessons:
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: conceptos-clave
    title: "Conceptos clave"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: relacion-con-el-resto-de-la-ruta
    title: "Relación con el resto de la ruta"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: que-debes-recordar
    title: "Qué debes recordar"
  - id: microproyecto-anadir-una-linea
    title: "Microproyecto · Añadir una línea"
---

# Lectura y escritura de texto

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Leer y escribir texto en UTF-8.
- Elegir entre carga completa y procesamiento por líneas.

## Punto de partida
{: #punto-de-partida }

Antes de usar un parser necesitas saber cómo obtener texto de un fichero y cómo guardarlo de forma explícita.

<div class="cla-note"><strong>Texto y codificación</strong><p>Haz explícito UTF-8 al trabajar con texto para que el resultado no dependa de la configuración del equipo.</p></div>

## Conceptos clave
{: #conceptos-clave }

- `Files.readString` y `writeString` son adecuados para ficheros pequeños.
- `Files.readAllLines` carga todas las líneas; `Files.lines` permite procesamiento perezoso.
- Especificar `StandardCharsets.UTF_8` evita depender del charset por defecto.

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/03.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/03.webp' | relative_url }}" alt="Leer y añadir texto. Un fichero de texto contiene líneas en una codificación como UTF-8. Verifica que la nueva línea se añade después de las anteriores." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo guiado
{: #ejemplo-guiado }

```java
Path file = Path.of("data", "saludo.txt");
Files.writeString(file, "áéíóú", StandardCharsets.UTF_8);
String texto = Files.readString(file, StandardCharsets.UTF_8);
System.out.println(texto);
```

## Relación con el resto de la ruta
{: #relacion-con-el-resto-de-la-ruta }

CSV, JSON y XML terminan siendo bytes o texto en disco; esta base permite entender qué parte hace Java y qué parte hace el parser.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Escribe tres líneas en UTF-8 y léelas con `Files.readAllLines`.
2. Repite la lectura con `Files.lines` y cuenta las líneas sin almacenarlas todas.

## Qué debes recordar
{: #que-debes-recordar }

- Declara el charset cuando trabajes con texto.
- No cargues un fichero grande completo si puedes procesarlo progresivamente.


## Microproyecto · Añadir una línea
{: #microproyecto-anadir-una-linea }

Añade una línea en UTF-8, conservando las anteriores. Usa el separador de línea del sistema.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F03-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F03-tarea-01.webp' | relative_url }}" alt="Añadir una línea. Resultado esperado: Las dos líneas aparecen en orden" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Las dos líneas aparecen en orden.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion03/F03-tarea-01.zip' | relative_url }}">Descargar F03-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/' | relative_url }}">← 2 · Path y Files</a>
  <a href="{{ '/ficheros/leccion04/' | relative_url }}">4 · IOException y try-with-resources →</a>
</div>
