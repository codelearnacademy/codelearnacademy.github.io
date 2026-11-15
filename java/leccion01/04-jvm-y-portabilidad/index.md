---
layout: lesson
route: java
lesson_id: leccion01
lesson_number: "01"
title: "JVM y portabilidad"
permalink: /java/leccion01/04-jvm-y-portabilidad/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# JVM y portabilidad

Ejecuta el mismo Main.class en dos sistemas con JVM compatibles con Java 21.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/04.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/04.webp' | relative_url }}" alt="JVM y portabilidad. Ejecuta el mismo Main.class en dos sistemas con JVM compatibles con Java 21. Resultado: Linux (en Linux)" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("os.name"));
    }
}
```

**Resultado esperado**

```text
Linux (en Linux)
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion01/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion01/05-inspeccionar-el-bytecode/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Imprime os.name.
2. Imprime os.arch.
3. Imprime la versión de la JVM.
4. Usa el separador de línea del sistema.
5. Construye una ruta con Path.of.
6. Presenta arquitectura y sistema juntos.
7. Ejecuta el mismo class en dos entornos disponibles.
8. Corrige una ruta con separador fijo.
9. Explica un fallo de bytecode incompatible a partir de su mensaje.
10. Genera una ficha portable de entorno.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L01-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L01-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea JVM y portabilidad. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion01/L01-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · JVM y portabilidad</a>
</div>
