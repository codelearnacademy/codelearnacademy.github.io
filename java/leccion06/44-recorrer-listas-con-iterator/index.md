---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "Recorrer listas con Iterator"
permalink: /java/leccion06/44-recorrer-listas-con-iterator/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Recorrer listas con Iterator

Llama a hasNext antes de next y observa el valor visitado en cada paso.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/44.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/44.webp' | relative_url }}" alt="Recorrer listas con Iterator. Llama a hasNext antes de next y observa el valor visitado en cada paso. Resultado: MAT-01, MAT-02" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var it = java.util.List.of("MAT-01", "MAT-02").iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}
```

**Resultado esperado**

```text
MAT-01
MAT-02
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/45-elegir-entre-list-set-y-map/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Recorre con Iterator.
2. Cuenta elementos visitados.
3. Busca un código.
4. Detén el recorrido al encontrarlo.
5. Elimina agotados con remove del iterador.
6. Suma existencias.
7. Compara con for-each.
8. Prueba una lista vacía.
9. Evita llamar a next sin hasNext.
10. Filtra movimientos inválidos y calcula un resumen.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Recorrer listas con Iterator. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Recorrer listas con Iterator</a>
</div>
