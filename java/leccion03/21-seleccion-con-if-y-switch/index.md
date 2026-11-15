---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Selección con if y switch"
permalink: /java/leccion03/21-seleccion-con-if-y-switch/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Selección con if y switch

Usa if para un intervalo o validación y switch para alternativas discretas.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/21.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/21.webp' | relative_url }}" alt="Selección con if y switch. Usa if para un intervalo o validación y switch para alternativas discretas. Resultado: Agotado" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int cantidad = 0;
        if (cantidad >= 0) System.out.println(switch (cantidad) { case 0 -> "Agotado"; default -> "Disponible"; });
    }
}
```

**Resultado esperado**

```text
Agotado
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/22-bucles-y-acumuladores/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Clasifica stock con if.
2. Traduce un código de operación con switch.
3. Valida un intervalo cerrado.
4. Combina condiciones de cantidad y permiso.
5. Usa switch como expresión.
6. Clasifica por tramos y después aplica una operación.
7. Emite un mensaje específico por cada motivo de rechazo.
8. Detecta una rama inalcanzable.
9. Prueba ambos lados de un umbral.
10. Construye un selector de operaciones de inventario.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Selección con if y switch. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Selección con if y switch</a>
</div>
