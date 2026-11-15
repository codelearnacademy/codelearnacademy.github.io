---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion29"
lesson_file: "29-comparar-demos-y-repositorios"
lesson_number: "29"
title: "Comparar CRUD y repositorios de Producto"
description: "Relacionar cada demo monolítica con su implementación final de IProductoRepository."
permalink: "/ficheros/leccion29/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: demos-iniciales
    title: "Demos iniciales"
  - id: repositorios-resultantes
    title: "Repositorios resultantes"
  - id: que-cambia
    title: "Qué cambia"
  - id: una-consecuencia-del-modelo-en-memoria
    title: "Una consecuencia del modelo en memoria"
  - id: pizarra-tres-formatos
    title: "Un catálogo, tres formatos"
  - id: microproyecto-comparar-dos-implementaciones
    title: "Microproyecto · Comparar dos implementaciones"
---

# Tres CRUD de partida, una arquitectura

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/29.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/29.webp' | relative_url }}" alt="Comparar comportamientos. Ejecuta operaciones equivalentes en dos implementaciones. Compara identidad y contenido sin depender del orden de lectura." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Demos iniciales
{: #demos-iniciales }

```text
CsvCrudDemo   → Commons CSV
JsonCrudDemo  → ObjectMapper
XmlCrudDemo   → XmlMapper
```

Cada demo contiene un CRUD completo. Eso nos permitió descubrir qué se repetía antes de abstraer.

## Repositorios resultantes
{: #repositorios-resultantes }

```text
IProductoRepository
       ▲
       │
AbstractFileRepository<Producto, Long>
       ▲
 ┌─────┼──────────────┐
 │     │              │
CSV   JSON            XML
 │     │              │
ProductoCsvRepository
ProductoJsonRepository
ProductoXmlRepository
```

## Qué cambia
{: #que-cambia }

| Responsabilidad | CSV | JSON | XML |
|---|---|---|---|
| Lectura | `CSVParser` | `ObjectMapper` | `XmlMapper` |
| Escritura | `CSVPrinter` | `ObjectMapper` | `XmlMapper` + wrapper |
| Excepciones E/S | implementación CSV | implementación JSON | implementación XML |
| CRUD | `AbstractFileRepository` | `AbstractFileRepository` | `AbstractFileRepository` |
| API | `IProductoRepository` | `IProductoRepository` | `IProductoRepository` |

## Una consecuencia del modelo en memoria
{: #una-consecuencia-del-modelo-en-memoria }

Cada constructor ejecuta `readAll()` una sola vez:

```java
entities = readAll();
```

Si otro proceso modifica el fichero después, el objeto repositorio no se actualiza automáticamente. Para volver a leer el contenido habría que crear otra instancia o diseñar explícitamente una operación de recarga.

<div class="cla-note"><strong>Ahora debemos probar la generalidad</strong><p>Una abstracción creada solo para Producto todavía puede estar demasiado ligada a Producto. El siguiente paso es usar la misma infraestructura con otra entidad.</p></div>


## Un catálogo, tres formatos
{: #pizarra-tres-formatos }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/pizarras/tres-formatos.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/pizarras/tres-formatos.webp' | relative_url }}" alt="Un catálogo, tres formatos. Consulta común · Buscar el producto con ID 7. CSV. ProductoCsvRepository lee los campos de la fila 7,Cuaderno,2.50. JSON. ProductoJsonRepository lee el objeto:
{ &quot;id&quot;: 7, &quot;nombre&quot;: &quot;Cuaderno&quot;, &quot;precio&quot;: 2.50 } XML. ProductoXmlRepository lee el elemento:
&lt;producto&gt;&lt;id&gt;7&lt;/id&gt;
&lt;nombre&gt;Cuaderno&lt;/nombre&gt;
&lt;precio&gt;2.50&lt;/precio&gt;&lt;/producto&gt; Al arrancar. La aplicación selecciona la implementación y la ruta correspondiente. Al consultar. El servicio usa IProductoRepository y las tres implementaciones devuelven el mismo Producto." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

Dibuja el mismo producto en CSV, JSON y XML. Identifica qué implementación cambiarías al arrancar y qué llamada del servicio seguirías usando.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/ficheros/pizarras/tres-formatos.webp' | relative_url }}">Ampliar la infografía</a>
  <a href="{{ '/ficheros/infografias/#pizarras' | relative_url }}">Ver todas las pizarras</a>
</div>

## Microproyecto · Comparar dos implementaciones
{: #microproyecto-comparar-dos-implementaciones }

Compara dos inventarios por ID y contenido, independientemente del orden. Devuelve true solo si contienen las mismas asociaciones.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F29-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F29-tarea-01.webp' | relative_url }}" alt="Comparar dos implementaciones. Resultado esperado: Datos iguales: true; cambiado: false" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Datos iguales: true; cambiado: false.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion29/F29-tarea-01.zip' | relative_url }}">Descargar F29-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion28/' | relative_url }}">← 28 · ProductoXmlRepository</a><a href="{{ '/ficheros/leccion30/' | relative_url }}">30 · Modelo Vehiculo →</a></div>
