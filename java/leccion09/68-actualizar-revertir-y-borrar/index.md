---
layout: lesson
route: java
lesson_id: leccion09
lesson_number: "09"
title: "Actualizar, revertir y borrar"
permalink: /java/leccion09/68-actualizar-revertir-y-borrar/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Actualizar, revertir y borrar

Ejecuta rollback antes de confirmar un cierre y comprueba que borrar el préstamo conserva el material.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/prestamos-objectdb.zip' | relative_url }}">Descargar proyecto ObjectDB</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

Crea primero el préstamo de ejemplo en un fichero nuevo, siguiendo el README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/68.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/68.webp' | relative_url }}" alt="Actualizar, revertir y borrar. Ejecuta rollback antes de confirmar un cierre y comprueba que borrar el préstamo conserva el material. Resultado: ABIERTO, CERRADO, Material presente" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        for (String op : new String[]{"rollback", "leer", "cerrar", "leer", "borrar", "material"}) aula.Prestamos.main(new String[]{"prestamos.odb", op});
    }
}
```

**Resultado esperado**

```text
ABIERTO
CERRADO
Material presente
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion09/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion09/69-cerrar-y-reabrir-para-verificar/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Cierra un préstamo.
2. Confirma el cambio.
3. Revierte un cierre.
4. Comprueba el estado tras reabrir.
5. Borra un préstamo.
6. Comprueba que el material sigue.
7. Filtra después de actualizar.
8. Trata un ID ausente.
9. Comprueba un fallo sin cambios parciales.
10. Ejecuta el ciclo crear, actualizar, revertir y borrar.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L09-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L09-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Actualizar, revertir y borrar. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion09/L09-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Actualizar, revertir y borrar</a>
</div>
