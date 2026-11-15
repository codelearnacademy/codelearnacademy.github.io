---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: "Abstract y final"
permalink: /java/leccion07/53-abstract-y-final/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Abstract y final

abstract exige que una subclase concreta implemente el método. final impide extender la clase que lo declara.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/53.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/53.webp' | relative_url }}" alt="Abstract y final. abstract exige que una subclase concreta implemente el método. final impide extender la clase que lo declara. Resultado: 7" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new Libro().plazo());
    }

    abstract static class Material { abstract int plazo(); }
    static final class Libro extends Material { int plazo() { return 7; } }
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
  <a href="{{ '/java/leccion07/54-interfaces-como-contratos/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Define una clase abstracta.
2. Declara un método abstracto.
3. Implementa el método.
4. Declara una clase final.
5. Declara un método final.
6. Combina comportamiento común y específico.
7. Prueba dos especializaciones.
8. Observa el error al instanciar un abstracto.
9. Observa el error al extender final.
10. Diseña una jerarquía con las extensiones permitidas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L07-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L07-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Abstract y final. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion07/L07-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Abstract y final</a>
</div>
