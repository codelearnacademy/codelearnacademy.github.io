---
layout: lesson
route: java
lesson_id: leccion01
lesson_number: "01"
title: "Compilar y ejecutar"
permalink: /java/leccion01/03-compilar-y-ejecutar/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Compilar y ejecutar

Guarda Main.java. Ejecuta javac Main.java y luego java Main: el compilador crea Main.class.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/03.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/03.webp' | relative_url }}" alt="Compilar y ejecutar. Guarda Main.java. Ejecuta javac Main.java y luego java Main: el compilador crea Main.class. Resultado: 1250" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(5 * 250);
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
  <a href="{{ '/java/leccion01/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion01/04-jvm-y-portabilidad/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Calcula 5 por 250.
2. Muestra el importe y sus unidades.
3. Compila dos mensajes consecutivos.
4. Compara la salida antes y después de recompilar.
5. Genera Main.class en out y ejecútalo.
6. Compila dos archivos que colaboran.
7. Ejecuta desde la carpeta padre con classpath.
8. Corrige java Main.class.
9. Diagnostica una clase ausente del classpath.
10. Entrega código y comandos para reproducir una ficha compilada.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L01-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L01-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Compilar y ejecutar. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion01/L01-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Compilar y ejecutar</a>
</div>
