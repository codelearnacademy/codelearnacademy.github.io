---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion24"
lesson_file: "jackson-xml-con-maven"
lesson_number: "24"
title: "Jackson XML con Maven y XmlMapper"
description: "Incorporación del módulo Jackson XML y primeras operaciones con XmlMapper."
permalink: "/ficheros/leccion24/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: dependencia-maven
    title: "Dependencia Maven"
  - id: documento-con-coleccion
    title: "Documento con colección"
  - id: microproyecto-mapear-con-xmlmapper
    title: "Microproyecto · Mapear con XmlMapper"
---

# Jackson XML con Maven y XmlMapper

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/24.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/24.webp' | relative_url }}" alt="Mapeo con XmlMapper. El documento representa el nombre en un elemento. Relaciona el elemento con el dato esperado en Java." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Añadir `jackson-dataformat-xml` con Maven.
- Utilizar `XmlMapper` con el mismo modelo `Producto`.
- Entender cuándo puede ser útil un wrapper de documento.

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/ficheros/24-xml-jackson.png' | relative_url }}" alt="Flujo entre XML, XmlMapper y objetos Java" loading="lazy">
  <figcaption>XmlMapper aplica el modelo de Jackson al formato XML.</figcaption>
</figure>

## Dependencia Maven
{: #dependencia-maven }

```xml
<dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

Utilizamos la misma propiedad `jackson.version` declarada al incorporar Databind.

```java
XmlMapper mapper = new XmlMapper();
```

## Documento con colección
{: #documento-con-coleccion }

```java
public record DocumentoProductos(List<Producto> productos) {}
```

Según la forma del XML, pueden ser necesarias anotaciones como `@JacksonXmlElementWrapper` o `@JacksonXmlProperty`.

<div class="cla-note"><strong>Misma familia</strong><p><code>ObjectMapper</code> y <code>XmlMapper</code> comparten muchas ideas porque ambos pertenecen al ecosistema Jackson.</p></div>


## Microproyecto · Mapear con XmlMapper
{: #microproyecto-mapear-con-xmlmapper }

Lee la propiedad nombre de un producto representado como XML.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F24-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F24-tarea-01.webp' | relative_url }}" alt="Mapear con XmlMapper. Resultado esperado: Ratón" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Ratón.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion24/F24-tarea-01.zip' | relative_url }}">Descargar F24-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion23/' | relative_url }}">← 23 · Anterior</a>
  <a href="{{ '/ficheros/leccion25/' | relative_url }}">25 · Siguiente →</a>
</div>
