---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: "Constructores y super"
permalink: /java/leccion07/51-constructores-y-super/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Constructores y super

Llama a super para inicializar el estado de la clase base.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/51.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/51.webp' | relative_url }}" alt="Constructores y super. Llama a super para inicializar el estado de la clase base. Resultado: MAT-01" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new Libro("MAT-01").codigo);
    }

    static class Material { final String codigo; Material(String codigo) { this.codigo = codigo; } }
    static class Libro extends Material { Libro(String codigo) { super(codigo); } }
}
```

**Resultado esperado**

```text
MAT-01
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion07/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion07/52-sobrescritura-y-polimorfismo/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Inicializa código con super.
2. Añade un campo específico.
3. Crea un segundo constructor.
4. Reutiliza un constructor con this.
5. Valida en la clase base.
6. Instancia dos subclases.
7. Comprueba estado heredado.
8. Corrige una llamada a super inválida.
9. Prueba un código vacío.
10. Centraliza la inicialización común de una familia de materiales.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L07-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L07-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Constructores y super. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion07/L07-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Constructores y super</a>
</div>
