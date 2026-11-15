---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Bucles y acumuladores"
permalink: /java/leccion03/22-bucles-y-acumuladores/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Bucles y acumuladores

El acumulador conserva el total parcial de cada iteración.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/22.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/22.webp' | relative_url }}" alt="Bucles y acumuladores. El acumulador conserva el total parcial de cada iteración. Resultado: 750" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int total = 0;
        for (int i = 1; i <= 3; i++) total += 250;
        System.out.println(total);
    }
}
```

**Resultado esperado**

```text
750
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/23-recorrer-un-array/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Cuenta de uno a n.
2. Suma existencias leídas.
3. Encuentra el mayor valor leído.
4. Cuenta entradas válidas e inválidas.
5. Calcula la media sin incluir el centinela.
6. Repite una operación con do while.
7. Aplica un bucle interno para generar etiquetas.
8. Corrige un acumulador reiniciado dentro del bucle.
9. Corrige un contador que no avanza.
10. Procesa una jornada y muestra total, máximo y número de movimientos.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Bucles y acumuladores. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Bucles y acumuladores</a>
</div>
