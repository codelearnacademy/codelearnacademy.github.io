---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: "Probar y documentar una jerarquía"
permalink: /java/leccion07/56-probar-y-documentar-una-jerarquia/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Probar y documentar una jerarquía

Comprueba dos especializaciones por el mismo tipo base. Prueba con un resultado esperado incorrecto.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/56.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/56.webp' | relative_url }}" alt="Probar y documentar una jerarquía. Comprueba dos especializaciones por el mismo tipo base. Prueba con un resultado esperado incorrecto. Resultado: Plazos verificados" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        Material[] datos = {new Libro(), new Equipo()};
        if (!(datos[0].plazo() == 7 && datos[1].plazo() == 3)) throw new AssertionError();
        System.out.println("Plazos verificados");
    }

    /** Material con un plazo de préstamo. */
    interface Material { int plazo(); }
    static class Libro implements Material { public int plazo() { return 7; } }
    static class Equipo implements Material { public int plazo() { return 3; } }
}
```

**Resultado esperado**

```text
Plazos verificados
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion07/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion07/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Documenta el contrato.
2. Prueba Libro.
3. Prueba Equipo.
4. Prueba ambos mediante el tipo base.
5. Comprueba un límite.
6. Registra el valor observado al depurar.
7. Comprueba mensajes de error.
8. Reproduce una expectativa incorrecta.
9. Añade una prueba de regresión.
10. Entrega jerarquía documentada y pruebas de comportamiento.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L07-S07-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L07-S07-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Probar y documentar una jerarquía. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion07/L07-S07-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Probar y documentar una jerarquía</a>
</div>
