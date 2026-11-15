---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Validar entradas y capturar excepciones"
permalink: /java/leccion03/25-validar-entradas-y-capturar-excepciones/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Validar entradas y capturar excepciones

Captura el error específico de una conversión inválida.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/25.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/25.webp' | relative_url }}" alt="Validar entradas y capturar excepciones. Captura el error específico de una conversión inválida. Resultado: Cantidad inválida" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try { Integer.parseInt("cinco"); } catch (NumberFormatException e) { System.out.println("Cantidad inválida"); }
    }
}
```

**Resultado esperado**

```text
Cantidad inválida
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/26-crear-una-excepcion-propia/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Captura una conversión inválida.
2. Muestra un mensaje distinto para cantidad negativa.
3. Reintenta tras una entrada errónea.
4. Valida antes de dividir.
5. Compara tratamiento de dos tipos de error.
6. Informa el número de línea de una entrada inválida.
7. Registra éxito y error sin perder el total previo.
8. Corrige un catch que oculta el motivo.
9. Comprueba una entrada vacía y fin de entrada.
10. Lee un lote y resume aceptados y rechazados.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Validar entradas y capturar excepciones. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Validar entradas y capturar excepciones</a>
</div>
