---
layout: lesson
route: java
lesson_id: leccion05
lesson_number: "05"
title: "Leer y escribir con Path y Files"
permalink: /java/leccion05/37-leer-y-escribir-con-path-y-files/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Leer y escribir con Path y Files

Escribe un dato en un fichero temporal y vuelve a leerlo.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/37.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/37.webp' | relative_url }}" alt="Leer y escribir con Path y Files. Escribe un dato en un fichero temporal y vuelve a leerlo. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var ruta = java.nio.file.Files.createTempFile("aula", ".txt");
        try { java.nio.file.Files.writeString(ruta, "5"); System.out.println(java.nio.file.Files.readString(ruta)); } finally { java.nio.file.Files.deleteIfExists(ruta); }
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
  <a href="{{ '/java/leccion05/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion05/38-procesar-un-fichero-linea-a-linea/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Escribe una cantidad.
2. Lee la cantidad.
3. Crea una ruta relativa.
4. Añade una línea.
5. Compara antes y después.
6. Guarda una ficha UTF-8.
7. Lee y suma cantidades.
8. Gestiona fichero ausente.
9. Conserva datos ante entrada inválida.
10. Implementa un inventario que persista al reabrir.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L05-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L05-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Leer y escribir con Path y Files. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion05/L05-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Leer y escribir con Path y Files</a>
</div>
