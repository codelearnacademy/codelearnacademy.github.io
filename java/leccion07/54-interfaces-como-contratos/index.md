---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: "Interfaces como contratos"
permalink: /java/leccion07/54-interfaces-como-contratos/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Interfaces como contratos

El cliente puede invocar la operación a través de la interfaz.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/54.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/54.webp' | relative_url }}" alt="Interfaces como contratos. El cliente puede invocar la operación a través de la interfaz. Resultado: 7" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        Prestable material = new Libro();
        System.out.println(material.plazo());
    }

    interface Prestable { int plazo(); }
    static class Libro implements Prestable { public int plazo() { return 7; } }
}
```

**Resultado esperado**

```text
7
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion07/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion07/55-composicion-y-delegacion/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Define Prestable.
2. Implementa en Libro.
3. Implementa en Equipo.
4. Recibe una interfaz como argumento.
5. Recorre implementaciones.
6. Combina política y fecha.
7. Sustituye una implementación.
8. Corrige una firma incompatible.
9. Prueba un plazo límite.
10. Genera un cliente que solo dependa del contrato.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L07-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L07-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Interfaces como contratos. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion07/L07-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Interfaces como contratos</a>
</div>
