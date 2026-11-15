---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Integer: del texto al número"
permalink: /java/leccion02/17-integer-del-texto-al-numero/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Integer: del texto al número

parseInt convierte texto válido a int. Prueba también con el texto cinco y observa la excepción.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/17.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/17.webp' | relative_url }}" alt="Integer: del texto al número. parseInt convierte texto válido a int. Prueba también con el texto cinco y observa la excepción. Resultado: 6" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int unidades = Integer.parseInt("5");
        System.out.println(unidades + 1);
    }
}
```

**Resultado esperado**

```text
6
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/18-math-redondeo/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Convierte 5 con parseInt.
2. Convierte un entero con signo.
3. Compara dos enteros con Integer.compare.
4. Convierte texto con espacios tras limpiarlo.
5. Suma dos cantidades de texto.
6. Devuelve un valor alternativo ante texto inválido.
7. Compara el resultado de parseInt y valueOf.
8. Diagnostica una conversión de texto decimal.
9. Rechaza números fuera del rango int.
10. Lee dos existencias textuales y valida antes de sumarlas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S11-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S11-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Integer: del texto al número. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S11-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Integer: del texto al número</a>
</div>
