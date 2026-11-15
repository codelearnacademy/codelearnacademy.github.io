---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion34"
lesson_file: "34-retos-y-ampliaciones"
lesson_number: "34"
title: "Retos y ampliaciones"
description: "Ejercicios para extender la arquitectura manteniendo la separación de responsabilidades."
permalink: "/ficheros/leccion34/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: retos-sobre-el-diseno
    title: "Retos sobre el diseño"
  - id: preguntas-de-revision
    title: "Preguntas de revisión"
  - id: pizarra-guardado-seguro
    title: "¿Qué ocurre si falla el guardado?"
  - id: microproyecto-conservar-el-original-ante-un-fallo
    title: "Microproyecto · Conservar el original ante un fallo"
---

# Retos y ampliaciones

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/34.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/34.webp' | relative_url }}" alt="Escritura mediante temporal. Prepara los nuevos datos junto al fichero de destino. Sustituye el original tras escribir y limpia el temporal si falla." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Retos sobre el diseño
{: #retos-sobre-el-diseno }

1. Extrae una `RepositoryFactory` para que `main` no contenga el `switch` de formatos.
2. Añade un nuevo modelo `Cliente` con identificador `UUID` y reutiliza `IRepository<T, ID>`.
3. Añade un cuarto formato sin modificar el código consumidor.
4. Introduce validaciones de dominio fuera de las clases de persistencia.
5. Añade pruebas que ejecuten el mismo contrato CRUD contra CSV, JSON y XML.

## Preguntas de revisión
{: #preguntas-de-revision }

- ¿Qué responsabilidades tenía inicialmente `CsvCrudDemo`?
- ¿Qué clases aparecieron al distribuir esas responsabilidades?
- ¿Qué se mantuvo igual al pasar a `JsonCrudDemo` y `XmlCrudDemo`?
- ¿Qué partes de `IRepository<T, ID>` puedes justificar a partir de los tres CRUD iniciales?
- ¿Qué demuestra `IRepository<Vehiculo, String>`?
- ¿Qué decisión sacamos del código gracias a `.properties`?


## ¿Qué ocurre si falla el guardado?
{: #pizarra-guardado-seguro }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/pizarras/guardado-seguro.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/pizarras/guardado-seguro.webp' | relative_url }}" alt="¿Qué ocurre si falla el guardado?. Original · 7,Cuaderno,2.50   →   Precio solicitado · 3.00. Preparar. Crea un temporal junto al catálogo. Prepara el estado nuevo sin tocar el original. Escribir y cerrar. Guarda todo el catálogo nuevo en el temporal y cierra el escritor. Reemplazar. Solo tras completar la escritura, intenta sustituir el original por el temporal. Escritura completada. Si el reemplazo termina, el original pasa a contener el precio nuevo. Fallo al escribir. Se interrumpe antes del reemplazo. Se conserva el original y se intenta eliminar el temporal." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

Simula una excepción de escritura cuando el temporal ya contiene datos parciales. Comprueba que el catálogo original todavía contiene el precio 2.50.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/ficheros/pizarras/guardado-seguro.webp' | relative_url }}">Ampliar la infografía</a>
  <a href="{{ '/ficheros/infografias/#pizarras' | relative_url }}">Ver todas las pizarras</a>
</div>

## Microproyecto · Conservar el original ante un fallo
{: #microproyecto-conservar-el-original-ante-un-fallo }

Escribe en un temporal de la misma carpeta. Si falla la escritura, conserva el original y borra el temporal. Si termina, sustituye el fichero. Usa el callback para probar el fallo.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F34-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F34-tarea-01.webp' | relative_url }}" alt="Conservar el original ante un fallo. Resultado esperado: El original sobrevive a una escritura fallida" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** El original sobrevive a una escritura fallida.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion34/F34-tarea-01.zip' | relative_url }}">Descargar F34-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion33/' | relative_url }}">← 33 · DataBridge</a><a href="/ficheros/">Volver a la ruta →</a></div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/' | relative_url }}">Volver a la ruta</a>
</div>
