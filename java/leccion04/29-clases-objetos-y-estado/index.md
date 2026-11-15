---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: "Clases, objetos y estado"
permalink: /java/leccion04/29-clases-objetos-y-estado/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Clases, objetos y estado

Diferentes objetos de la misma clase pueden guardar estados distintos.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/29.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/29.webp' | relative_url }}" alt="Clases, objetos y estado. Diferentes objetos de la misma clase pueden guardar estados distintos. Resultado: 0" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        Material a = new Material();
        Material b = new Material();
        a.unidades = 5;
        System.out.println(b.unidades);
    }

    static class Material { int unidades; }
}
```

**Resultado esperado**

```text
0
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion04/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion04/30-constructores-y-metodos/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea un material.
2. Crea dos objetos.
3. Consulta sus estados.
4. Actualiza uno.
5. Compara referencias.
6. Busca por código.
7. Cuenta agotados.
8. Prueba dos referencias al mismo objeto.
9. Prueba una colección vacía.
10. Simula un inventario con objetos independientes.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L04-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L04-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Clases, objetos y estado. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion04/L04-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Clases, objetos y estado</a>
</div>
