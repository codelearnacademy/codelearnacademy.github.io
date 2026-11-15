---
layout: lesson
route: java
lesson_id: leccion01
lesson_number: "01"
title: "Inspeccionar el bytecode"
permalink: /java/leccion01/05-inspeccionar-el-bytecode/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Inspeccionar el bytecode

Compila y ejecuta javap -c Main para ver las instrucciones del método main.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/05.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/05.webp' | relative_url }}" alt="Inspeccionar el bytecode. Compila y ejecuta javap -c Main para ver las instrucciones del método main. Resultado: Hola" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hola");
    }
}
```

**Resultado esperado**

```text
Hola
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion01/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion01/06-diagnosticar-errores/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Inspecciona un println.
2. Inspecciona dos println.
3. Localiza la carga de un literal.
4. Compara dos literales numéricos.
5. Inspecciona una suma sencilla.
6. Localiza la llamada a un método propio.
7. Contrasta println de texto y de entero.
8. Detecta un class que no corresponde al fuente.
9. Corrige el classpath de javap.
10. Relaciona tres fragmentos fuente con sus instrucciones desensambladas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L01-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L01-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Inspeccionar el bytecode. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion01/L01-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Inspeccionar el bytecode</a>
</div>
