---
layout: lesson
route: java
lesson_id: leccion05
lesson_number: "05"
title: "Procesar un fichero línea a línea"
permalink: /java/leccion05/38-procesar-un-fichero-linea-a-linea/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Procesar un fichero línea a línea

Abre Files.lines con try-with-resources y procesa el stream antes de cerrar.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/38.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/38.webp' | relative_url }}" alt="Procesar un fichero línea a línea. Abre Files.lines con try-with-resources y procesa el stream antes de cerrar. Resultado: 8" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var ruta = java.nio.file.Files.createTempFile("aula", ".txt");
        try { java.nio.file.Files.writeString(ruta, "5\n3\n"); try (var lineas = java.nio.file.Files.lines(ruta)) { System.out.println(lineas.mapToInt(Integer::parseInt).sum()); } } finally { java.nio.file.Files.deleteIfExists(ruta); }
    }
}
```

**Resultado esperado**

```text
8
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion05/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion05/39-csv-json-y-xml/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Cuenta filas.
2. Suma una columna.
3. Numera registros.
4. Filtra líneas vacías.
5. Detecta filas inválidas.
6. Agrupa por código.
7. Calcula el máximo.
8. Prueba un fichero vacío.
9. Cierra el stream aunque falle el procesamiento.
10. Produce un resumen con totales y errores por fila.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L05-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L05-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Procesar un fichero línea a línea. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion05/L05-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Procesar un fichero línea a línea</a>
</div>
