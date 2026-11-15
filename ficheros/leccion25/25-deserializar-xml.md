---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion25"
lesson_file: "25-deserializar-xml"
lesson_number: "25"
title: "Deserializar XML"
description: "Lectura de DocumentoProductos y extracción de List<Producto> con XmlMapper."
permalink: "/ficheros/leccion25/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: fichero-inexistente
    title: "Fichero inexistente"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-importar-xml-con-diagnostico
    title: "Microproyecto · Importar XML con diagnóstico"
---

# Deserializar XML

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/25.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/25.webp' | relative_url }}" alt="XML → Java. Localiza el fichero antes de intentar interpretarlo. Solo un documento bien formado produce una colección válida." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Leer un documento XML con Jackson.
- Obtener la colección de dominio.
- Aislar el wrapper de representación.

```java
XmlMapper mapper = new XmlMapper();
DocumentoProductos documento = mapper.readValue(
        Path.of("data/productos.xml").toFile(),
        DocumentoProductos.class
);

List<Producto> productos = documento.productos();
```

## Fichero inexistente
{: #fichero-inexistente }

Al igual que en JSON, el Demo puede trabajar con una lista vacía cuando todavía no existe el fichero.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Lee dos productos.
2. Cambia el nombre del elemento `producto` y adapta la anotación.
3. Elimina el elemento raíz y observa el error de parsing.


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · Importar XML con diagnóstico
{: #microproyecto-importar-xml-con-diagnostico }

Devuelve los nombres de los elementos nombre del catálogo. Una importación exige un fichero válido. Propaga IOException ante ausencia o contenido mal formado.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F25-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F25-tarea-01.webp' | relative_url }}" alt="Importar XML con diagnóstico. Resultado esperado: Nombres en orden o IOException" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Nombres en orden o IOException.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion25/F25-tarea-01.zip' | relative_url }}">Descargar F25-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion24/' | relative_url }}">← 24 · Jackson XML y XmlMapper</a>
  <a href="{{ '/ficheros/leccion26/' | relative_url }}">26 · Serializar XML →</a>
</div>
