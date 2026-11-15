---
layout: lesson
route: java
lesson_id: leccion01
lesson_number: "01"
title: "Anatomía de Main.java"
permalink: /java/leccion01/02-anatomia-de-main-java/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Anatomía de Main.java

La clase contiene el método main. La JVM lo usa como punto de entrada.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/02.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/02.webp' | relative_url }}" alt="Anatomía de Main.java. La clase contiene el método main. La JVM lo usa como punto de entrada. Resultado: Inventario" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Inventario");
    }
}
```

**Resultado esperado**

```text
Inventario
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion01/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion01/03-compilar-y-ejecutar/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Imprime una ficha en tres líneas.
2. Combina print y println.
3. Ordena las sentencias de una ficha.
4. Añade una línea vacía.
5. Dibuja un marco con literales.
6. Introduce una comilla escapada.
7. Imprime dos fichas con el mismo formato.
8. Corrige una llave ausente.
9. Corrige un main mal declarado.
10. Construye una salida de inventario con encabezado, datos y pie.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L01-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L01-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Anatomía de Main.java. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion01/L01-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Anatomía de Main.java</a>
</div>
