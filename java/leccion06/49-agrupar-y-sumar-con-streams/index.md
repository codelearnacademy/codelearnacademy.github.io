---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "Agrupar y sumar con streams"
permalink: /java/leccion06/49-agrupar-y-sumar-con-streams/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Agrupar y sumar con streams

Agrupa por categoría y agrega la cantidad de cada elemento.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/49.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/49.webp' | relative_url }}" alt="Agrupar y sumar con streams. Agrupa por categoría y agrega la cantidad de cada elemento. Resultado: {aula=8}" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var datos = java.util.List.of(new Material("aula", 5), new Material("aula", 3));
        var totales = datos.stream().collect(java.util.stream.Collectors.groupingBy(Material::categoria, java.util.stream.Collectors.summingInt(Material::cantidad)));
        System.out.println(totales);
    }

    record Material(String categoria, int cantidad) {}
}
```

**Resultado esperado**

```text
{aula=8}
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Filtra stock positivo.
2. Extrae las cantidades.
3. Suma con mapToInt.
4. Agrupa por categoría.
5. Cuenta por grupo.
6. Ordena el resumen.
7. Calcula máximos por grupo.
8. Prueba una lista vacía.
9. Comprueba un grupo con un único registro.
10. Genera un informe agregado con categorías ordenadas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S08-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S08-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Agrupar y sumar con streams. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S08-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Agrupar y sumar con streams</a>
</div>
