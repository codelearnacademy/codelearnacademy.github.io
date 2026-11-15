---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: "Constructores y métodos"
permalink: /java/leccion04/30-constructores-y-metodos/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Constructores y métodos

El constructor asigna el estado inicial y un método expone una operación.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/30.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/30.webp' | relative_url }}" alt="Constructores y métodos. El constructor asigna el estado inicial y un método expone una operación. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new Material(5).unidades());
    }

    record Material(int unidades) {}
}
```

**Resultado esperado**

```text
5
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion04/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion04/31-encapsulacion-y-validacion/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Inicializa un material.
2. Define un método de consulta.
3. Añade un constructor alternativo.
4. Calcula el importe.
5. Valida la cantidad.
6. Crea varios materiales.
7. Invoca métodos desde un recorrido.
8. Prueba una cantidad cero.
9. Rechaza un estado inicial inválido.
10. Entrega un modelo que calcule existencias y coste.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L04-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L04-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Constructores y métodos. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion04/L04-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Constructores y métodos</a>
</div>
