---
layout: lesson
route: java
lesson_id: leccion09
lesson_number: "09"
title: "Buscar por identidad y consulta"
permalink: /java/leccion09/67-buscar-por-identidad-y-consulta/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: consulta-avanzada-filtrar-ordenar-y-contar
    title: "Consulta avanzada · Filtrar, ordenar y contar"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Buscar por identidad y consulta

find localiza P1 por identidad. La consulta selecciona préstamos mediante el atributo estado.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/prestamos-objectdb.zip' | relative_url }}">Descargar proyecto ObjectDB</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

Crea primero el préstamo de ejemplo en un fichero nuevo, siguiendo el README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/67.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/67.webp' | relative_url }}" alt="Buscar por identidad y consulta. find localiza P1 por identidad. La consulta selecciona préstamos mediante el atributo estado. Resultado: true, 1 (si solo existe un préstamo abierto)" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var fabrica = jakarta.persistence.Persistence.createEntityManagerFactory("prestamos.odb");
        var gestor = fabrica.createEntityManager();
        try { System.out.println(gestor.find(aula.Prestamo.class, "P1") != null); System.out.println(gestor.createQuery("SELECT p FROM Prestamo p WHERE p.estado = :estado", aula.Prestamo.class).setParameter("estado", "ABIERTO").getResultList().size()); } finally { gestor.close(); fabrica.close(); }
    }
}
```

**Resultado esperado**

```text
true
1 (si solo existe un préstamo abierto)
```

## Consulta avanzada · Filtrar, ordenar y contar
{: #consulta-avanzada-filtrar-ordenar-y-contar }

Usa la base del proyecto de préstamos. Las consultas JPQL trabajan con la entidad `Prestamo` y sus atributos `estado` e `id`. La primera ordena los préstamos abiertos por identificador y devuelve hasta tres. La segunda cuenta todos los que cumplen el filtro.

```java
var primeros = gestor.createQuery(
        "SELECT p FROM Prestamo p WHERE p.estado = :estado ORDER BY p.id",
        aula.Prestamo.class)
    .setParameter("estado", "ABIERTO")
    .setMaxResults(3)
    .getResultList();

long total = gestor.createQuery(
        "SELECT COUNT(p) FROM Prestamo p WHERE p.estado = :estado",
        Long.class)
    .setParameter("estado", "ABIERTO")
    .getSingleResult();

System.out.println("Mostrados: " + primeros.size() + " · Total: " + total);
```

Coloca el fragmento dentro del bloque `try` que usa el gestor del ejemplo anterior. Con un préstamo abierto, muestra `Mostrados: 1 · Total: 1`. Con cuatro, muestra `Mostrados: 3 · Total: 4`. Cambia el parámetro a `CERRADO` y comprueba el resultado con tus datos.

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion09/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion09/68-actualizar-revertir-y-borrar/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Busca por identidad.
2. Filtra por estado.
3. Vincula el parámetro.
4. Ordena por identificador.
5. Limita a tres.
6. Cuenta todas las coincidencias.
7. Compara lista y total.
8. Prueba filtro sin resultados.
9. Comprueba orden determinista.
10. Entrega informe filtrado con límite y recuento.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L09-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L09-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Buscar por identidad y consulta. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion09/L09-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Buscar por identidad y consulta</a>
</div>
