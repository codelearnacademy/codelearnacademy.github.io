---
layout: "route"
route: "orm"
title: "Persistencia relacional y ORM con Java y SQLite"
permalink: "/orm/"
---

# Persistencia relacional y ORM con Java y SQLite

Esta ruta introduce el almacenamiento de datos en SQLite, el acceso mediante JDBC y la persistencia de objetos con JPA e Hibernate. Las actividades avanzan desde operaciones SQL hasta aplicaciones Java organizadas en capas y verificadas mediante pruebas automatizadas.

## Itinerario de aprendizaje

| Lecciones | Contenidos |
|---|---|
| **01–04 · Fundamentos** | SQLite, tablas, claves y operaciones SQL |
| **05–12 · Acceso con JDBC** | Conexiones, `PreparedStatement`, CRUD, transacciones y tests |
| **13–17 · Introducción a ORM** | Mapeo objeto-relacional, JPA, Hibernate y configuración |
| **18–24 · Persistencia con JPA** | Entidades, mappers, `EntityManager` y operaciones de persistencia |
| **25–28 · Integración** | Relaciones, pruebas y proyecto práctico |
| **29–31 · Arquitectura DAO** | Modelos, entidades JPA, relaciones, CRUD y tratamiento de errores |
| **32–33 · Consultas JPQL** | Filtros, agrupaciones, agregaciones, límites y subconsultas |
| **34–35 · Verificación y calidad** | JUnit 5, pruebas con SQLite, Javadoc y análisis de código |

## Metodología

Cada lección presenta los conceptos necesarios, ejemplos y actividades para comprobar lo aprendido. El objetivo es comprender cómo se almacenan y recuperan los datos, cómo se organiza el código de persistencia y cómo se verifica su comportamiento.

Se recomienda seguir el orden de las lecciones: primero SQL y JDBC, después JPA e Hibernate, y finalmente la separación entre modelos, entidades, mappers y DAO.

## Prácticas de arquitectura DAO

En las últimas lecciones se trabaja con una aplicación de alquiler de material deportivo que utiliza tres entidades relacionadas: clientes, equipos y alquileres.

- **Lección 29:** separación entre modelos Java, entidades JPA, mappers y DAO.
- **Lección 30:** tablas, identificadores y relaciones de la base de datos.
- **Lección 31:** operaciones CRUD con `EntityManager` y transacciones.
- **Lecciones 32–33:** consultas JPQL y modelos de resultados.
- **Lección 34:** pruebas JUnit para resultados y casos especiales.
- **Lección 35:** documentación de código y herramientas de calidad.

## Accesibilidad

Los diagramas tienen alternativas textuales y las actividades pueden seguirse por escrito. Los ejemplos y el código se acompañan de explicaciones que no dependen exclusivamente de elementos visuales.

[Guía de accesibilidad](/orm/ACCESIBILIDAD/)
