---
layout: lesson
route: java
lesson_id: leccion01
lesson_number: "01"
title: "Diagnosticar errores"
permalink: /java/leccion01/06-diagnosticar-errores/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Diagnosticar errores

Compila primero. Guarda una copia como Otro.java e intenta compilarla para reproducir el error de nombre.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/06.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/06.webp' | relative_url }}" alt="Diagnosticar errores. Compila primero. Guarda una copia como Otro.java e intenta compilarla para reproducir el error de nombre. Resultado: Clase Main" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Clase Main");
    }
}
```

**Resultado esperado**

```text
Clase Main
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion01/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion01/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Corrige un punto y coma ausente.
2. Corrige un literal sin cerrar.
3. Corrige una llave extra.
4. Corrige el nombre mismatched de clase y archivo.
5. Corrige una llamada a println mal escrita.
6. Distingue error al compilar de clase ausente al ejecutar.
7. Reproduce y resuelve un class obsoleto.
8. Localiza el primer error entre varios diagnósticos.
9. Corrige la configuración de lanzamiento de una clase válida.
10. Prepara una secuencia reproducible de tres fallos y sus correcciones.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L01-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L01-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Diagnosticar errores. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion01/L01-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Diagnosticar errores</a>
</div>
