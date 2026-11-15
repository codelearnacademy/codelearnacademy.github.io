---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "Clases y métodos genéricos"
permalink: /java/leccion06/46-clases-y-metodos-genericos/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Clases y métodos genéricos

Un parámetro de tipo permite reutilizar la clase y el método manteniendo el tipo del valor.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/46.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/46.webp' | relative_url }}" alt="Clases y métodos genéricos. Un parámetro de tipo permite reutilizar la clase y el método manteniendo el tipo del valor. Resultado: MAT-01" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(valor(new Caja<>("MAT-01")));
    }

    record Caja<T>(T dato) {}
    static <T> T valor(Caja<T> caja) { return caja.dato(); }
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
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/47-validar-codigos-con-pattern/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea Caja de String.
2. Crea Caja de Integer.
3. Escribe un método genérico de lectura.
4. Crea un resultado parametrizado.
5. Aplica el método a dos tipos.
6. Recorre una lista genérica.
7. Restringe un tipo numérico.
8. Corrige un tipo sin parámetro.
9. Demuestra un error de tipo en compilación.
10. Diseña un resultado reutilizable para dos importadores.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Clases y métodos genéricos. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Clases y métodos genéricos</a>
</div>
