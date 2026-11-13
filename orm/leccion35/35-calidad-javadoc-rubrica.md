---
layout: "lesson"
route: "orm"
lesson_id: "leccion35"
lesson_file: "35-calidad-javadoc-rubrica"
lesson_number: "35"
title: "Calidad, Javadoc y rúbrica automática"
description: "Comprender las métricas y el umbral de documentación de SportRent."
permalink: "/orm/leccion35/"
lessons:
- id: objetivo-de-aprendizaje
  title: Objetivo de aprendizaje
- id: infografía
  title: Infografía
- id: evaluación-aplicada
  title: Evaluación aplicada
- id: escalones-orientativos
  title: Escalones orientativos
- id: javadoc-útil
  title: Javadoc útil
- id: calidad-técnica
  title: Calidad técnica
- id: actividad-final
  title: Actividad final
---

# Calidad, Javadoc y rúbrica automática

## Objetivo de aprendizaje

Interpreta la rúbrica de SportRent y el umbral de 6,40 sobre 8,00 que habilita la documentación.

## Infografía

<figure class="cla-diagram">
  <a href="{{ '/assets/images/orm/infografias/35-calidad-javadoc-rubrica.webp' | relative_url }}" aria-label="Ampliar la infografía de la lección 35">
    <img src="{{ '/assets/images/orm/infografias/35-calidad-javadoc-rubrica.webp' | relative_url }}" alt="Resumen visual de la lección 35. Calidad, Javadoc y rúbrica automática" width="1236" height="1272" style="max-width:100%;height:auto" decoding="async">
  </a>
  <figcaption>Infografía resumen de la lección 35.</figcaption>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/images/orm/infografias/35-calidad-javadoc-rubrica.webp' | relative_url }}">Ampliar imagen</a>
  <a href="{{ '/orm/infografias/' | relative_url }}">Ver galería</a>
</div>

## Evaluación aplicada

| Bloque | Máximo |
|---|---:|
| CRUD: `ClienteDao`, `EquipoDao`, `AlquilerDao` | 4,50 |
| Nueve consultas JPQL | 3,50 |
| Calidad (Checkstyle, PMD, CPD) | 1,00 |
| Javadoc | 1,00 |
| **Total** | **10,00** |

La puntuación de documentación se aplica **solo si funcionalidad ≥ 6,40 / 8,00**, es decir, al menos el 80 % de la funcionalidad.

## Escalones orientativos

| Competencias superadas | Máximo acumulado |
|---|---:|
| CRUD completos | 4,50 |
| Más consultas básicas | 5,25 |
| Más consultas intermedias | 6,50 |
| Toda la funcionalidad | 8,00 |
| Más calidad y Javadoc habilitado | 10,00 |

El alumnado puede obtener puntuaciones parciales distintas; la tabla muestra **un recorrido progresivo**, no notas obligatorias ni prerrequisitos para superar tests individuales.

## Javadoc útil

```java
/**
 * Devuelve los alquileres pendientes de devolución ordenados por fecha prevista.
 *
 * @return lista de modelos Alquiler; vacía si no hay pendientes
 */
public List<Alquiler> pendientesDevolucion() {
    // implementación
}
```

Un comentario genérico como "método que hace cosas" no explica el contrato. En el ejercicio, revisamos Javadoc de las clases, métodos públicos, `@param`, `@return` y la generación HTML.

## Calidad técnica

- **Checkstyle**: convenciones de Java.
- **PMD**: prácticas de código que conviene revisar.
- **CPD**: duplicaciones relevantes, sin penalizar patrones mínimos inevitables de transacciones JPA.
- **Tests**: no sustituyen la revisión del diseño; cada prueba informa del comportamiento observable.

## Actividad final

1. Dibuja `model → mapper → entity → tabla` y sitúa el DAO.
2. Implementa una operación CRUD y crea tests para éxito, ausencia y error.
3. Construye una consulta con agrupación y otra con subconsulta.
4. Documenta sus contratos de entrada/salida.
5. Explica por qué `Javadoc = 1` no implica un punto añadido si la funcionalidad queda en 6,30/8.

<details><summary>Autoevaluación: ¿con 6,30/8 funcionales se añade Javadoc?</summary>

No. El umbral es 6,40/8.
</details>

**Vuelta al [índice de la ruta](/orm/).**
