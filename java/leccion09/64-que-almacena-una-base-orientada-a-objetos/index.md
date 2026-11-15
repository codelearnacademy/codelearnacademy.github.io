---
layout: lesson
route: java
lesson_id: leccion09
lesson_number: "09"
title: "Qué almacena una base orientada a objetos"
permalink: /java/leccion09/64-que-almacena-una-base-orientada-a-objetos/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Qué almacena una base orientada a objetos

Una entidad persistente puede conservar referencias y valores compuestos. Lee el préstamo creado por el proyecto ObjectDB.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/prestamos-objectdb.zip' | relative_url }}">Descargar proyecto ObjectDB</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

Crea primero el préstamo de ejemplo en un fichero nuevo, siguiendo el README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/64.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/64.webp' | relative_url }}" alt="Qué almacena una base orientada a objetos. Una entidad persistente puede conservar referencias y valores compuestos. Lee el préstamo creado por el proyecto ObjectDB. Resultado: ABIERTO · MAT-01 x 2 (préstamo creado)" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        aula.Prestamos.main(new String[]{"prestamos.odb", "leer"});
    }
}
```

**Resultado esperado**

```text
ABIERTO · MAT-01 x 2 (préstamo creado)
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion09/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion09/65-configurar-el-gestor-y-crear-la-base/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Identifica una entidad.
2. Distingue un valor embebido.
3. Añade un material persistente.
4. Recupera el préstamo.
5. Lee una línea relacionada.
6. Compara lectura por identidad y consulta.
7. Comprueba el material compartido.
8. Prueba una identidad ausente.
9. Reabre para verificar el grafo.
10. Describe y verifica la persistencia de un préstamo completo.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L09-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L09-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Qué almacena una base orientada a objetos. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion09/L09-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Qué almacena una base orientada a objetos</a>
</div>
