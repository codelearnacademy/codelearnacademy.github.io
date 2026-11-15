---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: "Encapsulación y validación"
permalink: /java/leccion04/31-encapsulacion-y-validacion/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Encapsulación y validación

Protege el estado con acceso privado y valida antes de construir.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/31.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/31.webp' | relative_url }}" alt="Encapsulación y validación. Protege el estado con acceso privado y valida antes de construir. Resultado: Stock inválido" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try { new Material(-1); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
    }

    static class Material { private final int n; Material(int n) { if (n < 0) throw new IllegalArgumentException("Stock inválido"); this.n = n; } }
}
```

**Resultado esperado**

```text
Stock inválido
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion04/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion04/32-paquetes-visibilidad-e-importaciones/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Haz privado el stock.
2. Expón una consulta.
3. Valida el constructor.
4. Implementa una retirada.
5. Conserva el estado ante un fallo.
6. Cuenta retiradas válidas.
7. Documenta la invariante.
8. Rechaza cantidades negativas.
9. Prueba el stock exacto.
10. Simula una jornada con estado protegido.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L04-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L04-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Encapsulación y validación. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion04/L04-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Encapsulación y validación</a>
</div>
