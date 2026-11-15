---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Clases envolventes"
permalink: /java/leccion02/15-clases-envolventes/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Clases envolventes

Una lista parametrizada almacena Integer. El compilador aplica boxing al insertar y unboxing al leer.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/15.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/15.webp' | relative_url }}" alt="Clases envolventes. Una lista parametrizada almacena Integer. El compilador aplica boxing al insertar y unboxing al leer. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var lista = java.util.List.of(5);
        int unidades = lista.getFirst();
        System.out.println(unidades);
    }
}
```

**Resultado esperado**

```text
5
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/16-string-indices-y-subcadenas/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Boxea un int.
2. Desboxea un Integer.
3. Compara dos envolventes con equals.
4. Convierte Double en double.
5. Calcula el total tras leer dos Integer.
6. Usa valueOf para convertir texto.
7. Distingue ausencia de valor y cero.
8. Corrige un unboxing de null.
9. Corrige la comparación de envolventes con ==.
10. Normaliza tres lecturas opcionales y calcula el total.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S09-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S09-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Clases envolventes. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S09-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Clases envolventes</a>
</div>
