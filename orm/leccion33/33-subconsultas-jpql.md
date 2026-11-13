---
layout: "lesson"
route: "orm"
lesson_id: "leccion33"
lesson_file: "33-subconsultas-jpql"
lesson_number: "33"
title: "Subconsultas JPQL y modelos de resultado"
description: "Comprender consultas correlacionadas y DTO como clases normales."
permalink: "/orm/leccion33/"
lessons:
- id: objetivo
  title: Objetivo
- id: infografía
  title: Infografía
- id: subconsulta-correlacionada-precio-sobre-la-media-de-la-categoría
  title: 'Subconsulta correlacionada: precio sobre la media de la categoría'
- id: datos-que-devuelve-una-consulta-clase-de-resultado
  title: 'Datos que devuelve una consulta: clase de resultado'
- id: otra-comparación-avanzada-referencia-por-cliente
  title: 'Otra comparación avanzada: referencia por cliente'
- id: actividad-de-análisis
  title: Actividad de análisis
---

# Subconsultas JPQL y modelos de resultado

## Objetivo

Resolver comparaciones entre cada fila y un valor calculado en otra consulta, sin descargar todos los datos para filtrarlos con Java Streams.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/33-subconsultas-jpql.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 33">
    <img src="{{ '/assets/images/orm/infografias/33-subconsultas-jpql.webp' | relative_url }}" alt="Resumen visual de la lección 33. Subconsultas JPQL y modelos de resultado" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Relaciona una subconsulta con la consulta exterior y transforma su proyección en un objeto de resultado.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/33-subconsultas-jpql.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Subconsulta correlacionada: precio sobre la media de la categoría

```java
String jpql = """
    SELECT e
    FROM EquipoEntity e
    WHERE e.precioDia > (
        SELECT AVG(otro.precioDia)
        FROM EquipoEntity otro
        WHERE otro.categoria = e.categoria
    )
    ORDER BY e.codigo ASC
    """;
```

`otro.categoria = e.categoria` relaciona la subconsulta con la fila exterior. La base de datos calcula la media por categoría y compara cada precio. Una consulta que hiciera `SELECT e FROM EquipoEntity e` y luego filtrara con Java no demostraría el mismo aprendizaje.

## Datos que devuelve una consulta: clase de resultado

```java
public class EquipoPrecio {
    private String codigo;
    private String categoria;
    private BigDecimal precioDia;
    private Double mediaCategoria;

    public EquipoPrecio() { }
    public EquipoPrecio(String codigo, String categoria,
                        BigDecimal precioDia, Double mediaCategoria) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.precioDia = precioDia;
        this.mediaCategoria = mediaCategoria;
    }
    public String getCodigo() { return codigo; }
    public String getCategoria() { return categoria; }
    public BigDecimal getPrecioDia() { return precioDia; }
    public Double getMediaCategoria() { return mediaCategoria; }
    // setters análogos
}
```

Este modelo es una clase Java **sin** `@Entity`. Puede representar columnas calculadas que no existen en una tabla. Una consulta de proyección que requiera simultáneamente precio y media puede usar una segunda proyección JPQL adecuada; la consulta mostrada arriba demuestra la **selección** mediante subconsulta, no todas las columnas calculadas.

## Otra comparación avanzada: referencia por cliente

Una variante didáctica viable en JPQL compara el total de alquileres de cada cliente con el total de un **cliente de referencia**, en lugar de intentar calcular una media de grupos mediante una tabla derivada no portable:

```java
String jpql = """
    SELECT c.dni, COUNT(a)
    FROM AlquilerEntity a JOIN a.cliente c
    GROUP BY c.dni
    HAVING COUNT(a) > (
        SELECT COUNT(refAlq)
        FROM AlquilerEntity refAlq
        WHERE refAlq.cliente.dni = :dniReferencia
    )
    ORDER BY COUNT(a) DESC, c.dni ASC
    """;
```

Comprueba además en Java que el cliente de referencia **existe**: el contrato del ejercicio pide lista vacía para un DNI inexistente, aunque la subconsulta contara cero.

## Actividad de análisis

- ¿Qué devuelve cada consulta si no hay equipos o alquileres?
- ¿Qué ocurre con una categoría que tiene un único equipo?
- ¿Por qué es importante el segundo criterio de ordenación cuando hay empates?
- ¿Qué tipo de resultado debe devolver un método público: `EquipoEntity`, `Equipo` o `EquipoPrecio`?

<details><summary>Autoevaluación: ¿cuándo una subconsulta es correlacionada?</summary>

Cuando referencia atributos o alias definidos por la consulta externa.
</details>

**Siguiente:** [tests JUnit ordenados y aislados](/orm/leccion34/).
