---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Sentencias break y continue"
permalink: /java/leccion03/24-sentencias-break-y-continue/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Sentencias break y continue

continue salta la iteración actual. break termina el bucle.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/24.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/24.webp' | relative_url }}" alt="Sentencias break y continue. continue salta la iteración actual. break termina el bucle. Resultado: 0, 2" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) { if (i == 1) continue; if (i == 3) break; System.out.println(i); }
    }
}
```

**Resultado esperado**

```text
0
2
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/25-validar-entradas-y-capturar-excepciones/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Detén una búsqueda al encontrar un código.
2. Salta registros con stock cero.
3. Termina en un centinela.
4. Cuenta válidos usando continue para descartar.
5. Aplica break a un menú.
6. Detén una búsqueda en un doble recorrido.
7. Distingue saltar un valor de terminar el recorrido.
8. Corrige un continue que impide avanzar en while.
9. Comprueba que break omite los elementos posteriores.
10. Procesa movimientos hasta cierre y omite entradas inválidas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Sentencias break y continue. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Sentencias break y continue</a>
</div>
