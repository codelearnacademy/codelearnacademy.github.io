---
layout: "lesson"
route: "orm"
lesson_id: "leccion32"
lesson_file: "32-jpql-consultas-progresivas"
lesson_number: "32"
title: "Consultas JPQL: de filtros a agregaciones"
description: "Practicar JOIN, COUNT, HAVING, MAX, LIMIT, SUM y proyecciones."
permalink: "/orm/leccion32/"
---

# Consultas JPQL: de filtros a agregaciones

## JPQL no es SQL

JPQL usa el **nombre de la entidad** y sus **atributos Java**. Ejemplo:

```java
em.createQuery(
    "SELECT e FROM EquipoEntity e ORDER BY e.precioDia DESC, e.codigo ASC",
    EquipoEntity.class
).setMaxResults(5).getResultList();
```

En JPQL portátil, el límite se aplica con `setMaxResults(5)`, no con una cláusula `LIMIT` dentro de la cadena JPQL.

## Escalera de aprendizaje

| Nivel | Pregunta que responde | Técnica para estudiar |
|---|---|---|
| Básico | ¿Cuáles son los cinco equipos más caros? | Orden y máximo de resultados |
| Básico | ¿Qué alquileres no se han devuelto? | Relaciones, filtro y ordenación |
| Intermedio | ¿Qué clientes tienen más de dos alquileres? | Agrupar, contar y filtrar grupos |
| Intermedio | ¿Cuál es el precio máximo por categoría con al menos dos equipos? | Máximo, agrupación y condiciones de grupo |
| Intermedio | ¿Qué tres equipos generan más ingresos? | Sumar y limitar |
| Avanzado | ¿Qué equipos superan la media de su categoría? | Subconsulta correlacionada |

Para cada consulta, identifica primero el resultado esperado y después decide cómo expresar los filtros, agrupaciones y cálculos en JPQL.

## Consulta de ejemplo 1: `HAVING`

```java
String jpql = """
    SELECT c.dni, c.nombre, COUNT(a)
    FROM AlquilerEntity a JOIN a.cliente c
    GROUP BY c.dni, c.nombre
    HAVING COUNT(a) > :minimo
    ORDER BY COUNT(a) DESC, c.dni ASC
    """;

List<Object[]> filas = em.createQuery(jpql, Object[].class)
    .setParameter("minimo", 2L)
    .getResultList();
```

Las filas son una **proyección**, no entidades. En el DAO conviértelas a una clase de resultado (`ClienteAlquileres`) con constructor y getters. Alternativamente, usa una expresión `SELECT NEW ...` cuyo constructor coincida exactamente con los tipos proyectados.

## Consulta de ejemplo 2: `MAX`

```java
String jpql = """
    SELECT e.categoria, MAX(e.precioDia)
    FROM EquipoEntity e
    GROUP BY e.categoria
    HAVING COUNT(e) >= 2
    ORDER BY e.categoria ASC
    """;
```

## Actividad guiada

1. Cambia el umbral de alquileres de 2 a 3 mediante un parámetro.
2. Busca qué categorías desaparecen cuando se exige un mínimo de dos equipos.
3. Explica por qué `WHERE COUNT(...) > 2` no sustituye a `HAVING`.
4. Escribe tests con listado vacío y con empates para garantizar orden determinista.

<details><summary>Autoevaluación: ¿qué hace `setMaxResults(3)`?</summary>

Limita a tres las filas que devuelve JPA; en SQLite, Hibernate puede traducirlo a SQL con `LIMIT`.
</details>

**Siguiente:** [subconsultas y resultados de consulta](/orm/leccion33/).
