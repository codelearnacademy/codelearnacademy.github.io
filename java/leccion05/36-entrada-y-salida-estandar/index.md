---
layout: lesson
route: java
lesson_id: leccion05
lesson_number: "05"
title: "Entrada y salida estándar"
permalink: /java/leccion05/36-entrada-y-salida-estandar/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Entrada y salida estándar

La salida estándar muestra resultados. La salida de error comunica diagnósticos.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/36.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/36.webp' | relative_url }}" alt="Entrada y salida estándar. La salida estándar muestra resultados. La salida de error comunica diagnósticos. Resultado: MAT-01: 5, Fin del diagnóstico" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.printf("%s: %d%n", "MAT-01", 5);
        System.err.println("Fin del diagnóstico");
    }
}
```

**Resultado esperado**

```text
MAT-01: 5
Fin del diagnóstico
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion05/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion05/37-leer-y-escribir-con-path-y-files/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Lee un código.
2. Formatea una cantidad.
3. Emite un aviso por stderr.
4. Lee dos registros.
5. Alinea columnas con printf.
6. Muestra un total.
7. Separa resultados y errores.
8. Prueba fin de entrada.
9. Corrige un especificador incompatible.
10. Genera un informe de consola reproducible.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L05-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L05-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Entrada y salida estándar. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion05/L05-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Entrada y salida estándar</a>
</div>
