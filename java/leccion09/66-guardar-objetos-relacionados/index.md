---
layout: lesson
route: java
lesson_id: leccion09
lesson_number: "09"
title: "Guardar objetos relacionados"
permalink: /java/leccion09/66-guardar-objetos-relacionados/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Guardar objetos relacionados

Crea y recupera un préstamo con una línea que referencia un material. Usa un fichero nuevo.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/prestamos-objectdb.zip' | relative_url }}">Descargar proyecto ObjectDB</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/66.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/66.webp' | relative_url }}" alt="Guardar objetos relacionados. Crea y recupera un préstamo con una línea que referencia un material. Usa un fichero nuevo. Resultado: ABIERTO · MAT-01 x 2" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        aula.Prestamos.main(new String[]{"relaciones.odb", "crear"});
        aula.Prestamos.main(new String[]{"relaciones.odb", "leer"});
    }
}
```

**Resultado esperado**

```text
ABIERTO · MAT-01 x 2
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion09/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion09/67-buscar-por-identidad-y-consulta/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Guarda un material.
2. Añade una línea embebida.
3. Persiste un préstamo.
4. Añade otra línea.
5. Reutiliza un mismo material.
6. Cuenta unidades de las líneas.
7. Recupera los detalles al reabrir.
8. Rechaza cantidad no positiva.
9. Verifica material compartido.
10. Guarda y recupera dos préstamos relacionados.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L09-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L09-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Guardar objetos relacionados. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion09/L09-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Guardar objetos relacionados</a>
</div>
