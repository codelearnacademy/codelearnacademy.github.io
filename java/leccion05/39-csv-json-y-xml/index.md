---
layout: lesson
route: java
lesson_id: leccion05
lesson_number: "05"
title: "CSV, JSON y XML"
permalink: /java/leccion05/39-csv-json-y-xml/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# CSV, JSON y XML

Compara el mismo dato en tres formatos. Para CSV con comillas usa un lector de CSV.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/39.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/39.webp' | relative_url }}" alt="CSV, JSON y XML. Compara el mismo dato en tres formatos. Para CSV con comillas usa un lector de CSV. Resultado: MAT-01,5, {&quot;codigo&quot;:&quot;MAT-01&quot;,&quot;cantidad&quot;:5}, &lt;material codigo=&quot;MAT-01&quot;&gt;5&lt;/material&gt;" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("MAT-01,5");
        System.out.println("{\"codigo\":\"MAT-01\",\"cantidad\":5}");
        System.out.println("<material codigo=\"MAT-01\">5</material>");
    }
}
```

**Resultado esperado**

```text
MAT-01,5
{"codigo":"MAT-01","cantidad":5}
<material codigo="MAT-01">5</material>
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion05/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion05/40-crear-una-vista-javafx/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Representa un registro CSV.
2. Representa un registro JSON.
3. Representa un registro XML.
4. Representa dos materiales.
5. Verifica acentos UTF-8.
6. Compara campos ausentes.
7. Transforma una ficha entre formatos.
8. Detecta una fila incompleta.
9. Prueba un valor con comillas.
10. Genera un inventario de muestra en los tres formatos.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L05-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L05-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea CSV, JSON y XML. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion05/L05-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · CSV, JSON y XML</a>
</div>
