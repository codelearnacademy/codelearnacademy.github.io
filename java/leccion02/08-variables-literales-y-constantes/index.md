---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Variables, literales y constantes"
permalink: /java/leccion02/08-variables-literales-y-constantes/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Variables, literales y constantes

Declara una cantidad variable y un precio fijo en céntimos.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/08.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/08.webp' | relative_url }}" alt="Variables, literales y constantes. Declara una cantidad variable y un precio fijo en céntimos. Resultado: 1250" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int cantidad = 5;
        final int PRECIO = 250;
        System.out.println(cantidad * PRECIO);
    }
}
```

**Resultado esperado**

```text
1250
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/09-operadores-y-expresiones/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Declara cantidad entera.
2. Declara un precio constante.
3. Reasigna una cantidad tras una entrada.
4. Guarda nombre y disponibilidad.
5. Calcula un coste con una constante.
6. Representa unidades grandes con long.
7. Utiliza literales con separadores de miles.
8. Corrige una reasignación a final.
9. Evita un desbordamiento al multiplicar dos int.
10. Genera una ficha con código, unidades, disponibilidad y coste.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Variables, literales y constantes. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Variables, literales y constantes</a>
</div>
