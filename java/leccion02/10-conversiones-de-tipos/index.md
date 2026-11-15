---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Conversiones de tipos"
permalink: /java/leccion02/10-conversiones-de-tipos/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Conversiones de tipos

Compara división entera con división decimal. El cast explícito a int descarta la fracción.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/10.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/10.webp' | relative_url }}" alt="Conversiones de tipos. Compara división entera con división decimal. El cast explícito a int descarta la fracción. Resultado: 12, 12.5, 12" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(1250 / 100);
        System.out.println(1250 / 100.0);
        System.out.println((int) 12.5);
    }
}
```

**Resultado esperado**

```text
12
12.5
12
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/11-entrada-y-salida-con-scanner/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Convierte int a long.
2. Convierte double a int.
3. Compara división entera y decimal.
4. Convierte céntimos a euros.
5. Redondea frente a truncar un importe.
6. Amplía antes de multiplicar.
7. Convierte un texto válido en entero.
8. Detecta pérdida de fracción.
9. Corrige un cast que llega después de la división.
10. Muestra importe bruto, céntimos y euros sin perder precisión en la multiplicación.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Conversiones de tipos. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Conversiones de tipos</a>
</div>
