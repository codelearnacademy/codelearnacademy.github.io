---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "Arrays y matrices"
permalink: /java/leccion06/42-arrays-y-matrices/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: una-matriz-por-material-y-dia
    title: "Una matriz por material y día"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Arrays y matrices

En int[][] cada fila es un array. Usa la longitud de cada fila al recorrerla.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/42.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/42.webp' | relative_url }}" alt="Arrays y matrices. En int[][] cada fila es un array. Usa la longitud de cada fila al recorrerla. Resultado: 5, 7" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int[][] datos = { {5, 0}, {3, 4} };
        for (int[] fila : datos) System.out.println(java.util.Arrays.stream(fila).sum());
    }
}
```

**Resultado esperado**

```text
5
7
```

## Una matriz por material y día
{: #una-matriz-por-material-y-dia }

La fila corresponde al material y la columna al día. Un doble bucle visita cada celda.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/73.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/73.webp' | relative_url }}" alt="Una matriz por material y día. La fila corresponde al material y la columna al día. Un doble bucle visita cada celda. Resultado: Material 0: 5, Material 1: 7" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int[][] datos = { {5, 0}, {3, 4} };
        for (int i = 0; i < datos.length; i++) { int suma = 0; for (int j = 0; j < datos[i].length; j++) suma += datos[i][j]; System.out.println("Material " + i + ": " + suma); }
    }
}
```

**Resultado esperado**

```text
Material 0: 5
Material 1: 7
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/43-de-un-array-a-una-list/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Lee una celda.
2. Suma por filas.
3. Suma por columnas de una matriz rectangular.
4. Cuenta ceros.
5. Encuentra el máximo.
6. Compara totales de materiales.
7. Localiza la coordenada de un agotado.
8. Recorre una fila vacía.
9. Admite filas de distinta longitud al sumar por fila.
10. Genera un informe por material y día.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Arrays y matrices. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Arrays y matrices</a>
</div>
