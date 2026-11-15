---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "De un array a una List"
permalink: /java/leccion06/43-de-un-array-a-una-list/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# De un array a una List

Un array conserva su longitud. Copia los valores a una lista mutable antes de añadir otros.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/43.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/43.webp' | relative_url }}" alt="De un array a una List. Un array conserva su longitud. Copia los valores a una lista mutable antes de añadir otros. Resultado: [5, 0, 3, 4]" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int[] datos = {5, 0, 3};
        var lista = new java.util.ArrayList<Integer>();
        for (int n : datos) lista.add(n);
        lista.add(4);
        System.out.println(lista);
    }
}
```

**Resultado esperado**

```text
[5, 0, 3, 4]
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/44-recorrer-listas-con-iterator/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Copia un array.
2. Añade una unidad a la lista.
3. Actualiza una posición.
4. Elimina por índice.
5. Busca un valor.
6. Conserva el orden inicial.
7. Compara array y lista tras modificar.
8. Prueba el array vacío.
9. Corrige eliminación por valor frente a índice.
10. Transforma recuentos en una lista editable sin alterar la entrada.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea De un array a una List. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · De un array a una List</a>
</div>
