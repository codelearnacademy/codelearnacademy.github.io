---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: "Superclase y subclases"
permalink: /java/leccion07/50-superclase-y-subclases/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Superclase y subclases

Una subclase especializa a su clase base. Puedes guardar la instancia en una variable del tipo base.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/50.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/50.webp' | relative_url }}" alt="Superclase y subclases. Una subclase especializa a su clase base. Puedes guardar la instancia en una variable del tipo base. Resultado: Libro" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        Material material = new Libro();
        System.out.println(material.getClass().getSimpleName());
    }

    static class Material {}
    static class Libro extends Material {}
}
```

**Resultado esperado**

```text
Libro
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion07/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion07/51-constructores-y-super/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea clase base.
2. Crea una subclase.
3. Instancia dos especializaciones.
4. Consulta un atributo heredado.
5. Usa una variable del tipo base.
6. Recorre una lista del tipo base.
7. Filtra por una propiedad común.
8. Detecta una relación mal modelada.
9. Prueba un caso sin especialización.
10. Modela un inventario con dos tipos de material.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L07-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L07-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Superclase y subclases. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion07/L07-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Superclase y subclases</a>
</div>
