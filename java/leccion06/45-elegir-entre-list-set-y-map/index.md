---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "Elegir entre List, Set y Map"
permalink: /java/leccion06/45-elegir-entre-list-set-y-map/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Elegir entre List, Set y Map

List conserva repeticiones, Set reúne únicos y Map recupera un valor por clave.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/45.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/45.webp' | relative_url }}" alt="Elegir entre List, Set y Map. List conserva repeticiones, Set reúne únicos y Map recupera un valor por clave. Resultado: 2, 1, 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(java.util.List.of("A", "A").size());
        System.out.println(new java.util.HashSet<>(java.util.List.of("A", "A")).size());
        System.out.println(java.util.Map.of("A", 5).get("A"));
    }
}
```

**Resultado esperado**

```text
2
1
5
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/46-clases-y-metodos-genericos/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Conserva movimientos repetidos en List.
2. Cuenta códigos únicos con Set.
3. Recupera cantidades con Map.
4. Detecta duplicados.
5. Construye un índice por código.
6. Conserva orden de aparición.
7. Agrupa cantidades.
8. Comprueba clave ausente.
9. Resuelve una colisión de códigos.
10. Combina las tres estructuras para resumir un lote.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Elegir entre List, Set y Map. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Elegir entre List, Set y Map</a>
</div>
