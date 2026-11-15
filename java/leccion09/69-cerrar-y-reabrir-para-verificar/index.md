---
layout: lesson
route: java
lesson_id: leccion09
lesson_number: "09"
title: "Cerrar y reabrir para verificar"
permalink: /java/leccion09/69-cerrar-y-reabrir-para-verificar/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Cerrar y reabrir para verificar

Cada llamada del proyecto cierra el gestor y la fábrica. Una segunda llamada vuelve a abrir la misma base.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/prestamos-objectdb.zip' | relative_url }}">Descargar proyecto ObjectDB</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/69.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/69.webp' | relative_url }}" alt="Cerrar y reabrir para verificar. Cada llamada del proyecto cierra el gestor y la fábrica. Una segunda llamada vuelve a abrir la misma base. Resultado: El préstamo y su línea siguen disponibles" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        aula.Prestamos.main(new String[]{"reapertura.odb", "crear"});
        aula.Prestamos.main(new String[]{"reapertura.odb", "leer"});
    }
}
```

**Resultado esperado**

```text
El préstamo y su línea siguen disponibles
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion09/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion09/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Guarda y cierra.
2. Reabre y lee.
3. Comprueba las líneas.
4. Comprueba la referencia al material.
5. Reabre después de cambiar estado.
6. Reabre después de revertir.
7. Consulta tras eliminar.
8. Prueba una base nueva.
9. Comprueba que el material compartido se conserva.
10. Automatiza una secuencia de reaperturas y verifica cada estado.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L09-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L09-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Cerrar y reabrir para verificar. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion09/L09-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Cerrar y reabrir para verificar</a>
</div>
