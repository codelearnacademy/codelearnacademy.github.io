---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion18"
lesson_file: "jackson-databind-con-maven"
lesson_number: "18"
title: "Jackson Databind con Maven y ObjectMapper"
description: "Incorporación de Jackson Databind mediante Maven y uso inicial de ObjectMapper."
permalink: "/ficheros/leccion18/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: dependencia-maven
    title: "Dependencia Maven"
  - id: primera-instancia
    title: "Primera instancia"
  - id: microproyecto-mapear-con-objectmapper
    title: "Microproyecto · Mapear con ObjectMapper"
---

# Jackson Databind con Maven y ObjectMapper

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/18.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/18.webp' | relative_url }}" alt="Mapeo con ObjectMapper. ObjectMapper representa un documento JSON en Java. Relaciona los nombres de las propiedades con los campos esperados." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Añadir Jackson Databind al `pom.xml`.
- Crear un `ObjectMapper`.
- Relacionar serialización y deserialización con objetos Java.

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/ficheros/18-json-jackson.png' | relative_url }}" alt="Flujo entre JSON, ObjectMapper y objetos Java" loading="lazy">
  <figcaption>Jackson transforma JSON y objetos Java en ambos sentidos.</figcaption>
</figure>

## Dependencia Maven
{: #dependencia-maven }

```xml
<properties>
  <jackson.version>2.21.3</jackson.version>
</properties>

<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>${jackson.version}</version>
</dependency>
```

## Primera instancia
{: #primera-instancia }

```java
ObjectMapper mapper = new ObjectMapper();
```

`ObjectMapper` será la pieza central de `JsonCrudDemo` y, posteriormente, de `ProductoJsonRepository`.

<div class="cla-note"><strong>Evolución del pom.xml</strong><p>Commons CSV sigue presente. Ahora añadimos Jackson porque aparece una nueva necesidad tecnológica, no porque el repositorio lo exija.</p></div>


## Microproyecto · Mapear con ObjectMapper
{: #microproyecto-mapear-con-objectmapper }

Lee el campo nombre de un objeto JSON sin perder acentos.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F18-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F18-tarea-01.webp' | relative_url }}" alt="Mapear con ObjectMapper. Resultado esperado: Ratón" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Ratón.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion18/F18-tarea-01.zip' | relative_url }}">Descargar F18-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion17/' | relative_url }}">← 17 · Anterior</a>
  <a href="{{ '/ficheros/leccion19/' | relative_url }}">19 · Siguiente →</a>
</div>
