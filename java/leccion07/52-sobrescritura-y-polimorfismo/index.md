---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: "Sobrescritura y polimorfismo"
permalink: /java/leccion07/52-sobrescritura-y-polimorfismo/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Sobrescritura y polimorfismo

La versión del método de instancia depende del tipo real del objeto.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/52.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/52.webp' | relative_url }}" alt="Sobrescritura y polimorfismo. La versión del método de instancia depende del tipo real del objeto. Resultado: 7" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        Material material = new Libro();
        System.out.println(material.plazo());
    }

    static class Material { int plazo() { return 3; } }
    static class Libro extends Material { @Override int plazo() { return 7; } }
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
  <a href="{{ '/java/leccion07/53-abstract-y-final/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Sobrescribe plazo.
2. Usa Override.
3. Llama desde una variable base.
4. Recorre dos tipos.
5. Calcula devoluciones distintas.
6. Sobrescribe la descripción.
7. Comprueba un añadido sin cambiar el cliente.
8. Detecta una sobrecarga accidental.
9. Prueba una colección mixta.
10. Genera un resumen polimórfico de préstamos.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L07-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L07-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Sobrescritura y polimorfismo. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion07/L07-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Sobrescritura y polimorfismo</a>
</div>
