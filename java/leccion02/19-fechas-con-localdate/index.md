---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Fechas con LocalDate"
permalink: /java/leccion02/19-fechas-con-localdate/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Fechas con LocalDate

Suma días a una fecha. LocalDate devuelve una fecha nueva.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/19.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/19.webp' | relative_url }}" alt="Fechas con LocalDate. Suma días a una fecha. LocalDate devuelve una fecha nueva. Resultado: 2026-12-02" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var hoy = java.time.LocalDate.of(2026, 11, 29);
        System.out.println(hoy.plusDays(3));
    }
}
```

**Resultado esperado**

```text
2026-12-02
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/20-expresiones-regulares/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea una fecha fija.
2. Suma tres días.
3. Resta una semana.
4. Compara dos fechas.
5. Calcula días de préstamo.
6. Formatea una fecha de devolución.
7. Calcula una devolución que cruza de mes.
8. Detecta una fecha inválida.
9. Comprueba el cambio de febrero en año bisiesto.
10. Determina la devolución y si un préstamo está vencido.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S13-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S13-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Fechas con LocalDate. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S13-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Fechas con LocalDate</a>
</div>
