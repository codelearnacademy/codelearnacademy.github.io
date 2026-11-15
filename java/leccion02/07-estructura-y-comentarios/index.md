---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Estructura y comentarios"
permalink: /java/leccion02/07-estructura-y-comentarios/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Estructura y comentarios

Usa comentarios para explicar decisiones del programa y reconoce las llaves de clase y método.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/07.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/07.webp' | relative_url }}" alt="Estructura y comentarios. Usa comentarios para explicar decisiones del programa y reconoce las llaves de clase y método. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        // Stock inicial del aula.
        System.out.println(5);
    }
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
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/08-variables-literales-y-constantes/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Ordena las instrucciones de una ficha.
2. Añade un comentario que explique una decisión.
3. Extrae el saludo a un método.
4. Documenta el precio en céntimos.
5. Usa dos métodos para imprimir una ficha.
6. Cambia el orden de las llamadas y predice la salida.
7. Imprime un comentario como texto literal.
8. Corrige un comentario de bloque sin cerrar.
9. Localiza una instrucción fuera de main.
10. Crea una ficha documentada con dos métodos reutilizables.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Estructura y comentarios. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Estructura y comentarios</a>
</div>
