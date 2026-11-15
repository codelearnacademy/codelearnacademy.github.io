---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: "Composición y delegación"
permalink: /java/leccion07/55-composicion-y-delegacion/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Composición y delegación

Cambia la política de un objeto mediante un colaborador que cumple el contrato.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/55.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/55.webp' | relative_url }}" alt="Composición y delegación. Cambia la política de un objeto mediante un colaborador que cumple el contrato. Resultado: 3, 7" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new Material(() -> 3).plazo());
        System.out.println(new Material(() -> 7).plazo());
    }

    interface Politica { int dias(); }
    record Material(Politica politica) { int plazo() { return politica.dias(); } }
}
```

**Resultado esperado**

```text
3
7
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion07/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion07/56-probar-y-documentar-una-jerarquia/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea una política.
2. Inyéctala por constructor.
3. Delega plazo.
4. Cambia a una segunda política.
5. Crea una política con parámetro.
6. Reutiliza una política para dos materiales.
7. Compara con herencia.
8. Rechaza política nula.
9. Prueba una política que devuelve cero.
10. Construye un catálogo con políticas intercambiables.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L07-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L07-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Composición y delegación. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion07/L07-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Composición y delegación</a>
</div>
